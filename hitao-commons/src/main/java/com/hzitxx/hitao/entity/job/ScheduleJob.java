package com.hzitxx.hitao.entity.job;

import lombok.Data;

import java.beans.Transient;
import java.util.Date;

/**
 * 定时任务
 */
@Data
public class ScheduleJob {

    private Long scheduleJobId;

    /** 任务名称 */
    private String jobName;

    /** 任务分组 */
    private String jobGroup;
    /**
     * 是否持久化
     * 0:不持久化
     * 1:持久化
     */
    private int  storeDurably;

    /** 定时任务对应的类（包括包路径）*/
    private String clazz;


    /** 任务运行时间表达式 */
    private String cronExpression;
    /**
     * 是否并发执行任务
     */
    private int isNonConcurrent;

    /**
     * 任务描述
     */
    private String description;

}
