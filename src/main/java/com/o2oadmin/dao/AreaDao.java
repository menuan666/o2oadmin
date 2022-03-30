package com.o2oadmin.dao;

import com.o2oadmin.entity.Area;
import java.util.List;

/**
 * @author menuan
 */
public interface AreaDao {
    /**
     * 查询区域信息管理
     *
     * @param areaId 区域信息管理主键
     * @return 区域信息管理
     */
    public Area selectAreaByAreaId(Long areaId);

    /**
     * 查询区域信息管理列表
     *
     * @param Area 区域信息管理
     * @return 区域信息管理集合
     */
    public List<Area> selectAreaList(Area Area);

    /**
     * 新增区域信息管理
     *
     * @param Area 区域信息管理
     * @return 结果
     */
    public int insertArea(Area Area);

    /**
     * 修改区域信息管理
     *
     * @param Area 区域信息管理
     * @return 结果
     */
    public int updateArea(Area Area);

    /**
     * 删除区域信息管理
     *
     * @param areaId 区域信息管理主键
     * @return 结果
     */
    public int deleteAreaByAreaId(Long areaId);

    /**
     * 批量删除区域信息管理
     *
     * @param areaIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAreaByAreaIds(String[] areaIds);
}
