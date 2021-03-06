// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.vo.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public abstract class BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Date createTime;
    private Date updateTime;

    @java.lang.SuppressWarnings("all")
    public BaseVo() {
    }

    @java.lang.SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @java.lang.SuppressWarnings("all")
    public Date getCreateTime() {
        return this.createTime;
    }

    @java.lang.SuppressWarnings("all")
    public Date getUpdateTime() {
        return this.updateTime;
    }

    @java.lang.SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @java.lang.SuppressWarnings("all")
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    @java.lang.SuppressWarnings("all")
    public void setUpdateTime(final Date updateTime) {
        this.updateTime = updateTime;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseVo)) return false;
        final BaseVo other = (BaseVo) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$id = this.getId();
        final java.lang.Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final java.lang.Object this$createTime = this.getCreateTime();
        final java.lang.Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime)) return false;
        final java.lang.Object this$updateTime = this.getUpdateTime();
        final java.lang.Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof BaseVo;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final java.lang.Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final java.lang.Object $updateTime = this.getUpdateTime();
        result = result * PRIME + ($updateTime == null ? 43 : $updateTime.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "BaseVo(id=" + this.getId() + ", createTime=" + this.getCreateTime() + ", updateTime=" + this.getUpdateTime() + ")";
    }
}
