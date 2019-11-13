package com.langg.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * 测试job
 *
 * @author zh
 * @date 2019/11/13 10:22
 * @since 1.0.0
 */
@Slf4j
public class HelloQuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        log.debug("Hello Quartz, time = {}", new Date());
    }
}
