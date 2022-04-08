package com.o2oadmin.service.impl;

import com.o2oadmin.dao.HeadLineDao;
import com.o2oadmin.entity.HeadLine;
import com.o2oadmin.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    /**
     * 查询头条信息管理
     *
     * @param lineId 头条信息管理主键
     * @return 头条信息管理
     */
    @Override
    public HeadLine selectHeadLineByLineId(Long lineId)
    {
        return headLineDao.selectHeadLineByLineId(lineId);
    }

    /**
     * 查询头条信息管理列表
     *
     * @param HeadLine 头条信息管理
     * @return 头条信息管理
     */
    @Override
    public List<HeadLine> selectHeadLineList(HeadLine HeadLine)
    {
        return headLineDao.selectHeadLineList(HeadLine);
    }

    /**
     * 新增头条信息管理
     *
     * @param HeadLine 头条信息管理
     * @return 结果
     */
    @Override
    public int insertHeadLine(HeadLine HeadLine)
    {
        HeadLine.setCreateTime(new Date());
        return headLineDao.insertHeadLine(HeadLine);
    }

    /**
     * 修改头条信息管理
     *
     * @param HeadLine 头条信息管理
     * @return 结果
     */
    @Override
    public int updateHeadLine(HeadLine HeadLine)
    {
        return headLineDao.updateHeadLine(HeadLine);
    }

    /**
     * 批量删除头条信息管理
     *
     * @param lineIds 需要删除的头条信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHeadLineByLineIds(String lineIds)
    {
        return 0;
    }

    /**
     * 删除头条信息管理信息
     *
     * @param lineId 头条信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHeadLineByLineId(Long lineId)
    {
        return headLineDao.deleteHeadLineByLineId(lineId);
    }
}
