package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.job.ScheduleJob;
import com.hzitxx.hitao.service.ScheduleManagerService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 定时任务管理
 */
@Service
public class ScheduleManagerServiceImpl implements ScheduleManagerService {
    @Autowired(required = false)
    private Scheduler scheduler;

    private Logger logger = LoggerFactory.getLogger(ScheduleManagerServiceImpl.class);

    /**
     * 添加任务
     * @param scheduleJob
     * @param jobClass
     * @return
     */
    @Override
    public ServerResponse addJob(ScheduleJob scheduleJob,Class jobClass) {
        try {
            // 任务名，任务组，任务执行类
            JobDetail jobDetail= JobBuilder.newJob(jobClass)
                    .storeDurably(scheduleJob.getStoreDurably() ==1) //是否持久化
                    .withDescription(scheduleJob.getDescription())  //任务描述
                    .withIdentity(scheduleJob.getJobName(),
                            scheduleJob.getJobGroup()).build();

            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup());
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression()));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
            return  ServerResponse.createBySuccessMessage("任务添加成功!");
        } catch (Exception e) {
            logger.error("添加定时任务:"+e.getMessage());
            return ServerResponse.createByErrorMessage("任务添加失败!");
        }

    }

    /**
     * 修改任务
     * @param scheduleJob
     * @return
     */
    @Override
    public ServerResponse updateJob(ScheduleJob scheduleJob) {
        return null;
    }

    /**
     * 移除任务
     * @param scheduleJob
     * @return
     */
    @Override
    public ServerResponse removeJob(ScheduleJob scheduleJob) {
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup());
        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        try{
            scheduler.pauseJob(jobKey);//暂停任务
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            boolean result = scheduler.deleteJob(jobKey);//删除任务
            return ServerResponse.createBySuccessMessage("删除任务成功!");

        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除定时任务--"+e.getMessage());
            return ServerResponse.createByErrorMessage("删除任务失败!");
        }
    }

    /**
     * 开启所有任务
     * @return
     */
    @Override
    public ServerResponse startAllJob() {
        try{
            if(!scheduler.isStarted()){
                scheduler.start();
                return ServerResponse.createBySuccessMessage("开启成功!");
            }
            return  ServerResponse.createByErrorMessage("开启失败!");
        }catch (Exception e){
            logger.error("开启所有定时任务:"+e.getMessage());
            return ServerResponse.createByErrorMessage("开启失败!");

        }
    }

    /**
     * 关闭所有任务
     * @return
     */
    @Override
    public ServerResponse shutdownAllJob() {
        try{
            if(!scheduler.isShutdown()){
                scheduler.shutdown();
                return ServerResponse.createBySuccessMessage("关闭成功!");
            }
            return  ServerResponse.createBySuccessMessage("关闭失败!");
        }catch (Exception e){
            logger.error("关闭所有定时任务"+e.getMessage());
            return ServerResponse.createByErrorMessage("关闭失败!");
        }

    }

    /**
     * 暂停任务
     * @param scheduleJob
     * @return
     */
    @Override
    public ServerResponse pauseJob(ScheduleJob scheduleJob) {
        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(scheduleJob.getJobName(),scheduleJob.getJobGroup()));
            scheduler.pauseJob(JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup()));
            return ServerResponse.createBySuccessMessage("任务暂停成功!");
        } catch (SchedulerException e) {
            logger.error("暂停指定任务:"+e.getMessage());
            return ServerResponse.createByErrorMessage("暂任务停失败！");
        }

    }

    /**
     * 暂停所有任务
     * @return
     */
    @Override
    public ServerResponse pauseAll() {
        try {
            scheduler.pauseAll();
            return ServerResponse.createBySuccessMessage("所有任务暂停成功!");
        } catch (SchedulerException e) {
            logger.error("暂停所所有任务:"+e.getMessage());
            return ServerResponse.createByErrorMessage("所有任务暂停失败!");
        }

    }

    /**
     * 恢复指定任务
     * @param scheduleJob
     * @return
     */
    @Override
    public ServerResponse resumeJob(ScheduleJob scheduleJob) {
        try {
            scheduler.resumeJob(JobKey.jobKey(scheduleJob.getJobName(),scheduleJob.getJobGroup()));
            scheduler.resumeTrigger(TriggerKey.triggerKey(scheduleJob.getJobName(),scheduleJob.getJobGroup()));
            return ServerResponse.createBySuccessMessage("任务恢复成功!");
        } catch (SchedulerException e) {
            logger.error("任务恢复:"+e.getMessage());
            return ServerResponse.createByErrorMessage("任务恢复失败!");
        }
    }

    /**
     * 恢复所有任务
     * @return
     */
    @Override
    public ServerResponse resumeAll() {
        try {
            scheduler.resumeAll();
            return ServerResponse.createBySuccessMessage("所有任务恢复成功!");
        } catch (SchedulerException e) {
            logger.error("所有任务恢复:"+e.getMessage());
            return ServerResponse.createByErrorMessage("所有任务恢复失败!");
        }

    }
}
