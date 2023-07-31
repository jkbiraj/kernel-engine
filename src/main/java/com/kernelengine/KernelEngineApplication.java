package com.kernelengine;

import com.kernelengine.client.IPluginEngineClient;
import com.kernelengine.client.PluginEngineClientImpl;
import com.kernelengine.client.model.FireWallData;
import com.kernelengine.service.ISchedulerService;
import com.kernelengine.service.SchedulerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class KernelEngineApplication {

	@Autowired
	private static ISchedulerService schedulerService;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KernelEngineApplication.class, args);


        schedulerService = new SchedulerServiceImpl();
        schedulerService.initSchedulerService();
    }

}
