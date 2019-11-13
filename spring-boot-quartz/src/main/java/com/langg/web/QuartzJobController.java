package com.langg.web;

import com.langg.job.HelloQuartzJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * quartz控制层
 *
 * @author zh
 * @date 2019/11/12 17:59
 * @since 1.0.0
 */
@RestController
@Slf4j
public class QuartzJobController {

    @Autowired
    private Scheduler scheduler;

    private static final String GROUP_NAME = "test_group";

    /**
     * 开启任务
     *
     * @return
     * @throws SchedulerException
     */
    @RequestMapping("/addQuartzJob")
    public boolean addQuartzJob() throws SchedulerException {
        scheduler.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloQuartzJob.class)
                .withIdentity(HelloQuartzJob.class.getSimpleName(), GROUP_NAME)
                .build();

        // Trigger the job to run now, and then repeat every 20 seconds
        Trigger trigger = newTrigger()
                .withIdentity(HelloQuartzJob.class.getSimpleName(), GROUP_NAME)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(20)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            log.error("开启任务失败", e);
            return false;
        }
        return true;
    }

    /**
     * 暂停任务
     *
     * @return
     */
    @RequestMapping("/pauseQuartzJob")
    public boolean pauseQuartzJob() {
        try {
            scheduler.pauseJob(JobKey.jobKey(HelloQuartzJob.class.getSimpleName(), GROUP_NAME));
        } catch (SchedulerException e) {
            log.error("任务暂停失败", e);
            return false;
        }
        return true;
    }

    /**
     * 恢复任务
     *
     * @return
     */
    @RequestMapping("/resumeQuartzJob")
    public boolean resumeQuartzJob() {
        try {
            scheduler.resumeJob(JobKey.jobKey(HelloQuartzJob.class.getSimpleName(), GROUP_NAME));
        } catch (SchedulerException e) {
            log.error("任务恢复失败", e);
            return false;
        }
        return true;
    }

    /**
     * 删除任务
     *
     * @return
     */
    @RequestMapping("/deleteQuartzJob")
    public boolean deleteQuartzJob() {
        try {
            scheduler.pauseTrigger(TriggerKey.triggerKey(HelloQuartzJob.class.getSimpleName(), GROUP_NAME));
            scheduler.unscheduleJob(TriggerKey.triggerKey(HelloQuartzJob.class.getSimpleName(), GROUP_NAME));
            scheduler.deleteJob(JobKey.jobKey(HelloQuartzJob.class.getSimpleName(), GROUP_NAME));
        } catch (SchedulerException e) {
            log.error("任务删除失败", e);
            return false;
        }
        return true;
    }
}
