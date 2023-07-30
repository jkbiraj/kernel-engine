package com.kernelengine.service;

import com.kernelengine.client.IPluginEngineClient;
import com.kernelengine.client.PluginEngineClientImpl;
import com.kernelengine.client.model.FireWallData;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class SchedulerServiceImpl implements ISchedulerService {
    @Override
    public void initSchedulerService() {
        IPluginEngineClient pluginEngineClient = new PluginEngineClientImpl();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                FireWallData fireWallData = pluginEngineClient.fetchFirewallData();
                System.out.println(fireWallData);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}
