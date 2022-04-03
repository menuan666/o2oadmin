package com.o2oadmin.dao;

import com.o2oadmin.entity.Runner;

import java.util.List;

public interface RunnerDao {
    /**
     * 查询跑腿信息管理
     *
     * @param runnerId 跑腿信息管理主键
     * @return 跑腿信息管理
     */
    public Runner selectRunnerByRunnerId(Long runnerId);

    /**
     * 查询跑腿信息管理列表
     *
     * @param Runner 跑腿信息管理
     * @return 跑腿信息管理集合
     */
    public List<Runner> selectRunnerList(Runner Runner);

    /**
     * 修改跑腿信息管理
     *
     * @param Runner 跑腿信息管理
     * @return 结果
     */
    public int updateRunner(Runner Runner);

    /**
     * 删除跑腿信息管理
     *
     * @param runnerId 跑腿信息管理主键
     * @return 结果
     */
    public int deleteRunnerByRunnerId(Long runnerId);

    /**
     * 批量删除跑腿信息管理
     *
     * @param runnerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRunnerByRunnerIds(String[] runnerIds);
}
