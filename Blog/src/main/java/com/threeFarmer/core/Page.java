package com.threeFarmer.core;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页查询参数
 */
public class Page {
    private int pageNo;
    private int pageSize;

    public Page(HttpServletRequest request){
        String no = request.getParameter("pageNo");
        try {
            this.pageNo = Integer.parseInt(no);
            if(this.getPageNo() < 1){
                this.setPageNo(1);
            }
        }catch (Exception e){
            this.setPageNo(1);
        }
        String size = request.getParameter("pageSize");
        try {
            this.setPageSize(Integer.parseInt(size));
        }catch (Exception e){
            this.setPageSize(3);
        }
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
