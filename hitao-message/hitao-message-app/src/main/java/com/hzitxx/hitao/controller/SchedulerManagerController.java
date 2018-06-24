package com.hzitxx.hitao.controller;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.job.ScheduleJob;
import com.hzitxx.hitao.service.ScheduleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerManagerController {
    @Autowired
    private ScheduleManagerService scheduleManagerService;

    /**
     * 删除任务
     * @return
     */
    @GetMapping("/removeJob")
    public ServerResponse removeJob(ScheduleJob scheduleJob){
        return this.scheduleManagerService.removeJob(scheduleJob);
    }

    /**
     * 添加定时任务
     * @param scheduleJob
     * @return
     * @throws ClassNotFoundException
     */
    @GetMapping("/addJob")
    public ServerResponse addJob(ScheduleJob scheduleJob) throws ClassNotFoundException {
        return this.scheduleManagerService.addJob(scheduleJob,Class.forName(scheduleJob.getClazz()));
    }

    /**
     * 暂定任务
     * @param scheduleJob
     * @return
     */
    @GetMapping("/pauseJob")
    public ServerResponse pauseJob(ScheduleJob scheduleJob){
        return this.scheduleManagerService.pauseJob(scheduleJob);
    }

    /**
     * 暂停所有任务
     * @return
     */
    @GetMapping("/pauseAll")
    public ServerResponse pauseAll(){
        return this.scheduleManagerService.pauseAll();
    }

    /**
     * 恢复指定暂停的任务
     * @param scheduleJob
     * @return
     */
    @GetMapping("/resumeJob")
    public ServerResponse resumeJob(ScheduleJob scheduleJob){
        return this.scheduleManagerService.resumeJob(scheduleJob);
    }

    /**
     * 恢复暂停所有任务
     * @return
     */
    @GetMapping("/resumeAll")
    public ServerResponse resumeAll(){
        return this.scheduleManagerService.resumeAll();
    }
}
