package com.o2oadmin.service.impl;

import com.o2oadmin.dao.AreaDao;
import com.o2oadmin.entity.Area;
import com.o2oadmin.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceIpml implements AreaService {
    @Autowired
    private AreaDao AreaDao;

    /**
     * 查询区域信息管理
     *
     * @param areaId 区域信息管理主键
     * @return 区域信息管理
     */
    @Override
    public Area selectAreaByAreaId(Long areaId)
    {
        return AreaDao.selectAreaByAreaId(areaId);
    }

    /**
     * 查询区域信息管理列表
     *
     * @param Area 区域信息管理
     * @return 区域信息管理
     */
    @Override
    public List<Area> selectAreaList(Area Area)
    {
        return AreaDao.selectAreaList(Area);
    }

    /**
     * 新增区域信息管理
     *
     * @param Area 区域信息管理
     * @return 结果
     */
    @Override
    public int insertArea(Area Area)
    {
        Area.setCreateTime(new Date());
        return AreaDao.insertArea(Area);
    }

    /**
     * 修改区域信息管理
     *
     * @param Area 区域信息管理
     * @return 结果
     */
    @Override
    public int updateArea(Area Area)
    {
        return AreaDao.updateArea(Area);
    }

    /**
     * 批量删除区域信息管理
     *
     * @param areaIds 需要删除的区域信息管理主键
     * @return 结果
     */
    @Override
    public int deleteAreaByAreaIds(String areaIds)
    {
        //return AreaDao.deleteAreaByAreaIds(Convert.toStrArray(areaIds));
        return 0;
    }

    /**
     * 删除区域信息管理信息
     *
     * @param areaId 区域信息管理主键
     * @return 结果
     */
    @Override
    public int deleteAreaByAreaId(Long areaId)
    {
        return AreaDao.deleteAreaByAreaId(areaId);
    }
}
