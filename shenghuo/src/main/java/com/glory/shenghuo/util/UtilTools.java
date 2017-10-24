package com.glory.shenghuo.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * marsplan-web
 * Created by xian.juanjuan on 2017-6-7 10:35.
 */
public class UtilTools {
    public static PageInfos pageChange(PageInfo<?> data, Page page) {
        if (data == null) {
            return null;
        }
        PageInfos pageInfos = new PageInfos();
        try {
            pageInfos.setPageNo(page.getPageNum());
            pageInfos.setPageSize(page.getPageSize());
            pageInfos.setTotalCount(page.getTotal());
            pageInfos.setPageCount(page.getPages());
            pageInfos.setData(data.getList());
        } catch (Exception e) {
        }
        return pageInfos;
    }
}
