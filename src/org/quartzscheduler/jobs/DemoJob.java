package org.quartzscheduler.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DemoJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
 		  System.out.println("Hello World");
	}

}
