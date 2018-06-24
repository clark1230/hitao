package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.job.ScheduleJob;

/**
 * 定时作业接口
 */
public interface ScheduleManagerService {
    /**
     * 添加定时任务
     * @param scheduleJob
     * @return
     */
    ServerResponse addJob(ScheduleJob scheduleJob,Class jobClass);

    /**
     * 修改定时任务
     * @param scheduleJob
     * @return
     */
    ServerResponse updateJob(ScheduleJob scheduleJob);

    /**
     * 删除定时作业
     * @param scheduleJob
     * @return
     */
    ServerResponse removeJob(ScheduleJob scheduleJob);

    /**
     * 开启所有任务
     * @return
     */
    ServerResponse startAllJob();

    /**
     * 关闭所有任务
     * @return
     */
    ServerResponse shutdownAllJob();

    /**
     * 暂停指定的任务
     * @param scheduleJob
     * @return
     */
    ServerResponse pauseJob(ScheduleJob scheduleJob);

    /**
     * 暂停所有任务
     * @return
     */
    ServerResponse pauseAll();

    /**
     * 恢复指定任务
     * @param scheduleJob
     * @return
     */
    ServerResponse resumeJob(ScheduleJob scheduleJob);

    /**
     * 恢复所有任务
     * @return
     */
    ServerResponse resumeAll();
}
