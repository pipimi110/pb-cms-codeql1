// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.puboot.common.shiro.MyShiroRealm;
import com.puboot.common.util.CoreConst;
import com.puboot.common.util.ResultUtil;
import com.puboot.module.admin.model.Permission;
import com.puboot.module.admin.model.Role;
import com.puboot.module.admin.model.User;
import com.puboot.module.admin.service.PermissionService;
import com.puboot.module.admin.service.RoleService;
import com.puboot.module.admin.vo.PermissionTreeListVo;
import com.puboot.module.admin.vo.base.PageResultVo;
import com.puboot.module.admin.vo.base.ResponseVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 后台角色配置
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @java.lang.SuppressWarnings("all")
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RoleController.class);
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final MyShiroRealm myShiroRealm;

    @GetMapping("/add")
    public String add() {
        return CoreConst.ADMIN_PREFIX + "role/form";
    }

    /*角色列表数据*/
    @PostMapping("/list")
    @ResponseBody
    public PageResultVo pageRoles(Role role, Integer pageNumber, Integer pageSize) {
        try {
            IPage<Role> rolePage = roleService.selectRoles(role, pageNumber, pageSize);
            return ResultUtil.table(rolePage.getRecords(), rolePage.getTotal());
        } catch (Exception e) {
            log.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

    /*新增角色*/
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo addRole(Role role) {
        try {
            int a = roleService.insert(role);
            if (a > 0) {
                return ResultUtil.success("添加角色成功");
            } else {
                return ResultUtil.error("添加角色失败");
            }
        } catch (Exception e) {
            log.error(String.format("RoleController.addRole%s", e));
            throw e;
        }
    }

    /*删除角色*/
    @PostMapping("/delete")
    @ResponseBody
    public ResponseVo deleteRole(String roleId) {
        if (roleService.findByRoleId(roleId).size() > 0) {
            return ResultUtil.error("删除失败,该角色下存在用户");
        }
        List<String> roleIdsList = Collections.singletonList(roleId);
        int a = roleService.updateStatusBatch(roleIdsList, CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除角色成功");
        } else {
            return ResultUtil.error("删除角色失败");
        }
    }

    /*批量删除角色*/
    @PostMapping("/batch/delete")
    @ResponseBody
    public ResponseVo batchDeleteRole(@RequestParam("ids[]") String[] ids) {
        List<String> roleIdsList = Arrays.asList(ids);
        if (CollectionUtils.isNotEmpty(roleService.findByRoleIds(roleIdsList))) {
            return ResultUtil.error("删除失败,选择的角色下存在用户");
        }
        int a = roleService.updateStatusBatch(roleIdsList, CoreConst.STATUS_INVALID);
        if (a > 0) {
            return ResultUtil.success("删除角色成功");
        } else {
            return ResultUtil.error("删除角色失败");
        }
    }

    /*编辑角色详情*/
    @GetMapping("/edit")
    public String detail(Model model, Integer roleId) {
        Role role = roleService.findById(roleId);
        model.addAttribute("role", role);
        return CoreConst.ADMIN_PREFIX + "role/form";
    }

    /*编辑角色*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo editRole(@ModelAttribute("role") Role role) {
        int a = roleService.updateByRoleId(role);
        if (a > 0) {
            return ResultUtil.success("编辑角色成功");
        } else {
            return ResultUtil.error("编辑角色失败");
        }
    }

    /*分配权限列表查询*/
    @PostMapping("/assign/permission/list")
    @ResponseBody
    public List<PermissionTreeListVo> assignRole(String roleId) {
        List<PermissionTreeListVo> listVos = new ArrayList<>();
        List<Permission> allPermissions = permissionService.selectAll(CoreConst.STATUS_VALID);
        List<Permission> hasPermissions = roleService.findPermissionsByRoleId(roleId);
        for (Permission permission : allPermissions) {
            PermissionTreeListVo vo = new PermissionTreeListVo();
            vo.setId(permission.getId());
            vo.setPermissionId(permission.getPermissionId());
            vo.setName(permission.getName());
            vo.setParentId(permission.getParentId());
            for (Permission hasPermission : hasPermissions) {
                //有权限则选中
                if (hasPermission.getPermissionId().equals(permission.getPermissionId())) {
                    vo.setChecked(true);
                    break;
                }
            }
            listVos.add(vo);
        }
        return listVos;
    }

    /*分配权限*/
    @PostMapping("/assign/permission")
    @ResponseBody
    public ResponseVo assignRole(String roleId, String permissionIdStr) {
        List<String> permissionIdsList = new ArrayList<>();
        if (StringUtils.isNotBlank(permissionIdStr)) {
            String[] permissionIds = permissionIdStr.split(",");
            permissionIdsList = Arrays.asList(permissionIds);
        }
        try {
            roleService.addAssignPermission(roleId, permissionIdsList);
            /*重新加载角色下所有用户权限*/
            List<User> userList = roleService.findByRoleId(roleId);
            if (!userList.isEmpty()) {
                List<String> userIds = new ArrayList<>();
                for (User user : userList) {
                    userIds.add(user.getUserId());
                }
                myShiroRealm.clearAuthorizationByUserId(userIds);
            }
            return ResultUtil.success("分配权限成功");
        } catch (Exception e) {
            return ResultUtil.error("分配权限失败");
        }
    }

    @java.lang.SuppressWarnings("all")
    public RoleController(final RoleService roleService, final PermissionService permissionService, final MyShiroRealm myShiroRealm) {
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.myShiroRealm = myShiroRealm;
    }
}
