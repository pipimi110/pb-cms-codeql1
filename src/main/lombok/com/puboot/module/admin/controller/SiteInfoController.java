// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.controller;

import com.puboot.common.util.CoreConst;
import com.puboot.common.util.ResultUtil;
import com.puboot.module.admin.service.StaticHtmlService;
import com.puboot.module.admin.service.SysConfigService;
import com.puboot.module.admin.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import static com.puboot.common.util.CoreConst.SITE_STATIC_KEY;

/**
 * 后台网站信息配置
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
@Controller
public class SiteInfoController {
    private final SysConfigService configService;
    private final StaticHtmlService staticHtmlService;

    @PostMapping("/siteinfo/edit")
    @ResponseBody
    public ResponseVo save(@RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (map.containsKey(SITE_STATIC_KEY)) {
                boolean siteStaticOn = "on".equalsIgnoreCase(map.get(SITE_STATIC_KEY));
                if (siteStaticOn) {
                    staticHtmlService.makeStaticSite(request, response, true);
                }
                CoreConst.SITE_STATIC.set(siteStaticOn);
            }
            configService.updateAll(map, request, response);
            return ResultUtil.success("保存网站信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存网站信息失败");
        }
    }

    @java.lang.SuppressWarnings("all")
    public SiteInfoController(final SysConfigService configService, final StaticHtmlService staticHtmlService) {
        this.configService = configService;
        this.staticHtmlService = staticHtmlService;
    }
}