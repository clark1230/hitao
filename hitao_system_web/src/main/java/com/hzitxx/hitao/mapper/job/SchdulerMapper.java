package com.hzitxx.hitao.mapper.job;

import com.hzitxx.hitao.entity.job.ScheduleJob;

import java.util.List;

public interface SchdulerMapper {
    /**
     * 新增任务
     * @param scheduleJob
     * @throws Exception
     */
    public void addJobCron(ScheduleJob scheduleJob) throws Exception;

    /**
     * 暂停任务
     * @param scheduleJob
     */
    public void pauseJob(ScheduleJob scheduleJob) throws Exception;

    /**
     * 暂停全部任务
     */
    public void pauseAll() throws Exception;

    /**
     * 恢复任务
     * @param scheduleJob
     */
    public void resumeJob(ScheduleJob scheduleJob) throws Exception;


    /**
     * 恢复所有任务
     */
    public void resumeAll() throws Exception;

    /**
     * 删除任务后，所对应的trigger也将被删除
     * @param scheduleJob
     */
    public void deleteJob(ScheduleJob scheduleJob) throws Exception;

    /**
     * 立即运行任务
     * @param scheduleJob
     */
    public void triggerJob(ScheduleJob scheduleJob) throws Exception;

    /**
     * 更新任务的时间表达式
     * @param scheduleJob
     */
    public void updateJobCron(ScheduleJob scheduleJob) throws Exception;


    /**
     * 获取quartz调度器的计划任务
     * @return
     */
    public List<ScheduleJob> getScheduleJobList();

    /**
     * 获取quartz调度器的运行任务
     * @return
     */
    public List<ScheduleJob> getScheduleJobRunningList();

    /**
     * 添加任务
     * @param scheduleJob
     * @throws Exception
     */
    public void addJobSimple(ScheduleJob scheduleJob) throws Exception;

    /**
     * 修改任务
     * @param scheduleJob
     * @throws Exception
     */
    public void updateJobSimple(ScheduleJob scheduleJob) throws Exception;

    /**
     * 如果scheduleJob.getCronExpression()表达式不为空，使用表达式方式，如果为空，则使用简单方式
     * @param scheduleJob
     */
    public void add(ScheduleJob scheduleJob) throws Exception;

    /**
     * 如果scheduleJob.getCronExpression()表达式不为空，使用表达式方式，如果为空，则使用简单方式
     * @param scheduleJob
     */
    public void update(ScheduleJob scheduleJob) throws Exception;
}
