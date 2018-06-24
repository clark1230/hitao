package com.hzitxx.hitao.job;

import com.hzitxx.hitao.rpc.member.ShopAreaService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class Job2 extends QuartzJobBean {
    @Autowired
    ShopAreaService shopAreaService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("==================================================================");
        System.out.println("===========        "+(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss.SSSSSS")).format(new Date())+"         ============");
        System.out.println("=======================      定时任务2  Job2         ======================");
        System.out.println("==================================================================");
       // System.out.println(this.shopAreaService.getShopArea(0).getData());
    }
}
