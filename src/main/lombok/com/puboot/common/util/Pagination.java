// Generated by delombok at Wed Apr 13 12:12:31 CST 2022
package com.puboot.common.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页对象
 *
 * @author Linzhaoguan
 * @version V1.0
 * @date 2019年9月11日
 */
public class Pagination<T> extends Page<T> {
    private static final long serialVersionUID = 5194933845448697148L;

    public Pagination(long current, long size) {
        super(current, size);
    }

    //总页数
    private long pages;
    //前一页
    private long prePage;
    //下一页
    private long nextPage;
    //是否为第一页
    private boolean isFirstPage;
    //是否为最后一页
    private boolean isLastPage;
    //是否有前一页
    private boolean hasPreviousPage;
    //是否有下一页
    private boolean hasNextPage;

    @Override
    public Pagination<T> setTotal(long total) {
        super.setTotal(total);
        pages = super.getPages();
        long current = getCurrent();
        isFirstPage = current == 1;
        isLastPage = current == pages || pages == 0;
        hasPreviousPage = current > 1;
        hasNextPage = current < pages;
        if (current > 1) {
            prePage = current - 1;
        }
        if (current < pages) {
            nextPage = current + 1;
        }
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public long getPages() {
        return this.pages;
    }

    @java.lang.SuppressWarnings("all")
    public long getPrePage() {
        return this.prePage;
    }

    @java.lang.SuppressWarnings("all")
    public long getNextPage() {
        return this.nextPage;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isFirstPage() {
        return this.isFirstPage;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isLastPage() {
        return this.isLastPage;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isHasPreviousPage() {
        return this.hasPreviousPage;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isHasNextPage() {
        return this.hasNextPage;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setPages(final long pages) {
        this.pages = pages;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setPrePage(final long prePage) {
        this.prePage = prePage;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setNextPage(final long nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setFirstPage(final boolean isFirstPage) {
        this.isFirstPage = isFirstPage;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setLastPage(final boolean isLastPage) {
        this.isLastPage = isLastPage;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setHasPreviousPage(final boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
        return this;
    }

    @java.lang.SuppressWarnings("all")
    public Pagination<T> setHasNextPage(final boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        return this;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "Pagination(pages=" + this.getPages() + ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage() + ", isFirstPage=" + this.isFirstPage() + ", isLastPage=" + this.isLastPage() + ", hasPreviousPage=" + this.isHasPreviousPage() + ", hasNextPage=" + this.isHasNextPage() + ")";
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof Pagination)) return false;
        final Pagination<?> other = (Pagination<?>) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (!super.equals(o)) return false;
        if (this.getPages() != other.getPages()) return false;
        if (this.getPrePage() != other.getPrePage()) return false;
        if (this.getNextPage() != other.getNextPage()) return false;
        if (this.isFirstPage() != other.isFirstPage()) return false;
        if (this.isLastPage() != other.isLastPage()) return false;
        if (this.isHasPreviousPage() != other.isHasPreviousPage()) return false;
        if (this.isHasNextPage() != other.isHasNextPage()) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof Pagination;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final long $pages = this.getPages();
        result = result * PRIME + (int) ($pages >>> 32 ^ $pages);
        final long $prePage = this.getPrePage();
        result = result * PRIME + (int) ($prePage >>> 32 ^ $prePage);
        final long $nextPage = this.getNextPage();
        result = result * PRIME + (int) ($nextPage >>> 32 ^ $nextPage);
        result = result * PRIME + (this.isFirstPage() ? 79 : 97);
        result = result * PRIME + (this.isLastPage() ? 79 : 97);
        result = result * PRIME + (this.isHasPreviousPage() ? 79 : 97);
        result = result * PRIME + (this.isHasNextPage() ? 79 : 97);
        return result;
    }
}