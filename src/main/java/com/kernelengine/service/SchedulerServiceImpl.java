package com.kernelengine.service;

import com.kernelengine.client.IPluginEngineClient;
import com.kernelengine.client.PluginEngineClientImpl;
import com.kernelengine.client.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SchedulerServiceImpl implements ISchedulerService {

    private static final Logger logger = LogManager.getLogger(SchedulerServiceImpl.class);

    @Override
    public void initSchedulerService() {
        IPluginEngineClient pluginEngineClient = new PluginEngineClientImpl();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                FireWallData fireWallData = pluginEngineClient.fetchFirewallData();
                System.out.println(fireWallData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                LinuxServerData linuxServerData = pluginEngineClient.fetchLinuxServerData();
                System.out.println(linuxServerData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                LoadBalancerData loadBalancerData = pluginEngineClient.fetchLoadBalancerData();
                System.out.println(loadBalancerData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                RouterData routerData = pluginEngineClient.fetchRouterData();
                System.out.println(routerData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                SwitchData switchData = pluginEngineClient.fetchSwitchData();
                System.out.println(switchData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                WindowsServerData windowsServerData = pluginEngineClient.fetchWindowsServerData();
                System.out.println(windowsServerData);
            } catch (Exception e) {
                logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
            }
        }, 0, 5, TimeUnit.SECONDS);

        // Keep the thread alive for demonstration purposes
        try {
            Thread.sleep(50000); // Wait for 20 seconds
        } catch (InterruptedException e) {
            logger.error("Ëxception occurred: " + e.getMessage()); //TODO: logging can be improved
        }

        // Shutdown the executor service gracefully
        scheduledExecutorService.shutdown();
    }
}
