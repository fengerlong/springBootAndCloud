package net.cdsunrise.alps.ewp.eiamanage.utils;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
public class PageUtils<T> implements Serializable {

    /**
     * 总记录数
     */
    private Long totalCount;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 当前页记录数
     */
    private Integer currentSize;

    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 数据列表
     */
    private List<T> list;
}
