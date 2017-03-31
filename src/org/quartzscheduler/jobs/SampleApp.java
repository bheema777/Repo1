package org.quartzscheduler.jobs;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SampleApp {
	
	public static void main(String args[]){
		Scheduler schedule = null;	
		try{
			JobDetail detail = org.quartz.JobBuilder.newJob(DemoJob.class).withIdentity("quartz","Group").build();
			Trigger trigger = org.quartz.TriggerBuilder.newTrigger().withIdentity("TriggerName","Group").withSchedule(CronScheduleBuilder.cronSchedule("* 54-55 11 * * ?")).build();
			schedule = new StdSchedulerFactory().getScheduler();
			schedule.start();
			schedule.scheduleJob(detail,trigger);
		}
		catch(SchedulerException e){
			e.printStackTrace();
		}
	}

}
