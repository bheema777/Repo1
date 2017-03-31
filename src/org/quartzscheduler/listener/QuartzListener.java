package org.quartzscheduler.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartzscheduler.jobs.DemoJob;

public class QuartzListener implements ServletContextListener {
	Scheduler schedule = null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try{
			schedule.shutdown();
		}
		catch(SchedulerException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Context Initialized");
		try{
			JobDetail detail = org.quartz.JobBuilder.newJob(DemoJob.class).withIdentity("quartz","Group").build();
			Trigger trigger = org.quartz.TriggerBuilder.newTrigger().withIdentity("TriggerName","Group").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
			schedule = new StdSchedulerFactory().getScheduler();
			schedule.start();
			schedule.scheduleJob(detail,trigger);
		}
		catch(SchedulerException e){
			e.printStackTrace();
		}
		
	}

}

