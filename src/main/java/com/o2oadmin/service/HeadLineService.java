package com.o2oadmin.service;

import com.o2oadmin.entity.HeadLine;

import java.util.List;

public interface HeadLineService {
    /**
     * 查询头条信息管理
     *
     * @param lineId 头条信息管理主键
     * @return 头条信息管理
     */
    public HeadLine selectHeadLineByLineId(Long lineId);

    /**
     * 查询头条信息管理列表
     *
     * @param HeadLine 头条信息管理
     * @return 头条信息管理集合
     */
    public List<HeadLine> selectHeadLineList(HeadLine HeadLine);

    /**
     * 新增头条信息管理
     *
     * @param HeadLine 头条信息管理
     * @return 结果
     */
    public int insertHeadLine(HeadLine HeadLine);

    /**
     * 修改头条信息管理
     *
     * @param HeadLine 头条信息管理
     * @return 结果
     */
    public int updateHeadLine(HeadLine HeadLine);

    /**
     * 批量删除头条信息管理
     *
     * @param lineIds 需要删除的头条信息管理主键集合
     * @return 结果
     */
    public int deleteHeadLineByLineIds(String lineIds);

    /**
     * 删除头条信息管理信息
     *
     * @param lineId 头条信息管理主键
     * @return 结果
     */
    public int deleteHeadLineByLineId(Long lineId);
}
