// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.module.admin.vo.base;

import java.util.List;

/**
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public class PageResultVo {
    private List rows;
    private Long total;

    @java.lang.SuppressWarnings("all")
    public List getRows() {
        return this.rows;
    }

    @java.lang.SuppressWarnings("all")
    public Long getTotal() {
        return this.total;
    }

    @java.lang.SuppressWarnings("all")
    public void setRows(final List rows) {
        this.rows = rows;
    }

    @java.lang.SuppressWarnings("all")
    public void setTotal(final Long total) {
        this.total = total;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof PageResultVo)) return false;
        final PageResultVo other = (PageResultVo) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$rows = this.getRows();
        final java.lang.Object other$rows = other.getRows();
        if (this$rows == null ? other$rows != null : !this$rows.equals(other$rows)) return false;
        final java.lang.Object this$total = this.getTotal();
        final java.lang.Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof PageResultVo;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $rows = this.getRows();
        result = result * PRIME + ($rows == null ? 43 : $rows.hashCode());
        final java.lang.Object $total = this.getTotal();
        result = result * PRIME + ($total == null ? 43 : $total.hashCode());
        return result;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "PageResultVo(rows=" + this.getRows() + ", total=" + this.getTotal() + ")";
    }

    @java.lang.SuppressWarnings("all")
    public PageResultVo(final List rows, final Long total) {
        this.rows = rows;
        this.total = total;
    }
}
