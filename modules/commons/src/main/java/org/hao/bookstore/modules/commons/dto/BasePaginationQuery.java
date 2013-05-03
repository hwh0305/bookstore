package org.hao.bookstore.modules.commons.dto;

import java.io.Serializable;

public class BasePaginationQuery implements Serializable {

    private static final long serialVersionUID   = 7772426086022495562L;

    private static final int  DEFAULT_PAGE_SIZE  = 20;

    private static final int  DEFAULT_FIRST_PAGE = 1;

    private int               pageSize           = DEFAULT_PAGE_SIZE;

    private int               currentPage        = DEFAULT_FIRST_PAGE;

    private int               total;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 0 ? pageSize : DEFAULT_PAGE_SIZE;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        int totalPage = getTotalPage();
        if (totalPage != 0 && currentPage > totalPage) this.currentPage = totalPage;
        else this.currentPage = currentPage > DEFAULT_FIRST_PAGE ? currentPage : DEFAULT_FIRST_PAGE;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return (int) ((total + pageSize - 1) / pageSize);
    }

    public int getStart() {
        int totalPage = getTotalPage();
        currentPage = this.currentPage > totalPage ? totalPage : this.currentPage;
        return currentPage == 0 ? 0 : (currentPage - 1) * pageSize;
    }
}
