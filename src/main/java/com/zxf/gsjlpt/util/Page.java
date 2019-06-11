package com.zxf.gsjlpt.util;

import lombok.Data;

import java.util.List;

/**
 * @ClassName Page
 * @Description TODO 页数信息
 * @Author zxf
 * @Date 2019/1/20  15:41
 **/
@Data
public class Page {
    // 当前页
    private int pageNumber;
    // 总记录数
    private long fullListSize;
    // 每页记录数，默认为10条
    private int pageSize = 10;
    // 总页数
    private long totalPage;
    // 第一页
    private int firstPage;
    // 最后一页
    private long lastPage;
    // 前一页
    private int previousPage;
    // 后一页
    private long nextPage;
    // 结果集
    private List<?> list;

    public static int getTotalPage(int totalNum , int pageSize) {
        int totalPage = (int) (totalNum % pageSize ==0 ? totalNum / pageSize : totalNum / pageSize +1);
        return totalPage;
    }
}
