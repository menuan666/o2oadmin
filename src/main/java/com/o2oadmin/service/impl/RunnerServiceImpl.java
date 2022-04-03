package com.o2oadmin.service.impl;
import com.o2oadmin.dao.RunnerDao;
import com.o2oadmin.entity.Runner;
import com.o2oadmin.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class RunnerServiceImpl implements RunnerService {
    @Autowired
    private RunnerDao runnerDao;

    /**
     * 查询跑腿信息管理
     *
     * @param runnerId 跑腿信息管理主键
     * @return 跑腿信息管理
     */
    @Override
    public Runner selectRunnerByRunnerId(Long runnerId)
    {
        return runnerDao.selectRunnerByRunnerId(runnerId);
    }

    /**
     * 查询跑腿信息管理列表
     *
     * @param Runner 跑腿信息管理
     * @return 跑腿信息管理
     */
    @Override
    public List<Runner> selectRunnerList(Runner Runner)
    {
        return runnerDao.selectRunnerList(Runner);
    }



    /**
     * 修改跑腿信息管理
     *
     * @param Runner 跑腿信息管理
     * @return 结果
     */
    @Override
    public int updateRunner(Runner Runner)
    {
        return runnerDao.updateRunner(Runner);
    }

    /**
     * 批量删除跑腿信息管理
     *
     * @param runnerIds 需要删除的跑腿信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRunnerByRunnerIds(String runnerIds)
    {
        String[] str = runnerIds.split(",");
        System.out.println(Arrays.toString(str));
        return runnerDao.deleteRunnerByRunnerIds(str);
    }

    /**
     * 删除跑腿信息管理信息
     *
     * @param runnerId 跑腿信息管理主键
     * @return 结果
     */
    @Override
    public int deleteRunnerByRunnerId(Long runnerId)
    {
        return runnerDao.deleteRunnerByRunnerId(runnerId);
    }
}
