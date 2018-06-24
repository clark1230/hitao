package com.hzitxx.hitao.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailQuartzJobBean extends QuartzJobBean{

    private String targetObject;
    private String targetMethod;
    private ApplicationContext ctx;


    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Object otargetObject = ctx.getBean(targetObject);
            Method m = null;

            System.out.println(targetObject + " - " + targetMethod + " - " + ((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date())));
            try {
                m = otargetObject.getClass().getMethod(targetMethod, new Class[] { JobExecutionContext.class });
                m.invoke(otargetObject, new Object[] { context });
            } catch (SecurityException e) {
                // Logger.error(e);
                System.out.println(e.getMessage());
            } catch (NoSuchMethodException e) {
                // Logger.error(e);
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new JobExecutionException(e);
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.ctx = applicationContext;
    }

    public void setTargetObject(String targetObject) {
        this.targetObject = targetObject;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }
}
