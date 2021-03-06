// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.vo;

import com.puboot.module.admin.vo.base.BaseConditionVo;
import lombok.EqualsAndHashCode;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public class CommentConditionVo {
    private String userId;
    private Integer sid;
    private Integer pid;
    private String qq;
    private String email;
    private String url;
    private Integer status;

    @java.lang.SuppressWarnings("all")
    public CommentConditionVo() {
    }

    @java.lang.SuppressWarnings("all")
    public String getUserId() {
        return this.userId;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getSid() {
        return this.sid;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getPid() {
        return this.pid;
    }

    @java.lang.SuppressWarnings("all")
    public String getQq() {
        return this.qq;
    }

    @java.lang.SuppressWarnings("all")
    public String getEmail() {
        return this.email;
    }

    @java.lang.SuppressWarnings("all")
    public String getUrl() {
        return this.url;
    }

    @java.lang.SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    @java.lang.SuppressWarnings("all")
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @java.lang.SuppressWarnings("all")
    public void setSid(final Integer sid) {
        this.sid = sid;
    }

    @java.lang.SuppressWarnings("all")
    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    @java.lang.SuppressWarnings("all")
    public void setQq(final String qq) {
        this.qq = qq;
    }

    @java.lang.SuppressWarnings("all")
    public void setEmail(final String email) {
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    public void setUrl(final String url) {
        this.url = url;
    }

    @java.lang.SuppressWarnings("all")
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentConditionVo)) return false;
        final CommentConditionVo other = (CommentConditionVo) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$userId = this.getUserId();
        final java.lang.Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final java.lang.Object this$sid = this.getSid();
        final java.lang.Object other$sid = other.getSid();
        if (this$sid == null ? other$sid != null : !this$sid.equals(other$sid)) return false;
        final java.lang.Object this$pid = this.getPid();
        final java.lang.Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) return false;
        final java.lang.Object this$qq = this.getQq();
        final java.lang.Object other$qq = other.getQq();
        if (this$qq == null ? other$qq != null : !this$qq.equals(other$qq)) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$url = this.getUrl();
        final java.lang.Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final java.lang.Object this$status = this.getStatus();
        final java.lang.Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CommentConditionVo;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final java.lang.Object $sid = this.getSid();
        result = result * PRIME + ($sid == null ? 43 : $sid.hashCode());
        final java.lang.Object $pid = this.getPid();
        result = result * PRIME + ($pid == null ? 43 : $pid.hashCode());
        final java.lang.Object $qq = this.getQq();
        result = result * PRIME + ($qq == null ? 43 : $qq.hashCode());
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final java.lang.Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final java.lang.Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "CommentConditionVo(userId=" + this.getUserId() + ", sid=" + this.getSid() + ", pid=" + this.getPid() + ", qq=" + this.getQq() + ", email=" + this.getEmail() + ", url=" + this.getUrl() + ", status=" + this.getStatus() + ")";
    }
}
