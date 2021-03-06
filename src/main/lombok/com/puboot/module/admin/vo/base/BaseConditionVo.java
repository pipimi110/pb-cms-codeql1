// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.vo.base;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public class BaseConditionVo {
    private int pageNumber = 1;
    private int pageSize = 10;

    @java.lang.SuppressWarnings("all")
    public BaseConditionVo() {
    }

    @java.lang.SuppressWarnings("all")
    public int getPageNumber() {
        return this.pageNumber;
    }

    @java.lang.SuppressWarnings("all")
    public int getPageSize() {
        return this.pageSize;
    }

    @java.lang.SuppressWarnings("all")
    public void setPageNumber(final int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @java.lang.SuppressWarnings("all")
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof BaseConditionVo)) return false;
        final BaseConditionVo other = (BaseConditionVo) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.getPageNumber() != other.getPageNumber()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof BaseConditionVo;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getPageNumber();
        result = result * PRIME + this.getPageSize();
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "BaseConditionVo(pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
    }
}
