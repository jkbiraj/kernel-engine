package com.kernelengine.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LinuxServerData {

    @JsonProperty("cpu_utilization")
    private double cpuUtilization;

    @JsonProperty("memory_usage")
    private double memoryUsage;

    @JsonProperty("network_throughput")
    private NetworkThroughput networkThroughput;

    @JsonProperty("request_latency_ms")
    private double requestLatencyMS;

    @JsonProperty("error_rate")
    private double errorRate;

    @JsonProperty("disk_usage")
    private DiskUsage diskUsage;

    @JsonProperty("active_connections")
    private int activeConnections;

    @JsonProperty("processes")
    private int processes;

    @JsonProperty("uptime")
    private String uptime;

    @JsonProperty("load_average")
    private LoadAverage loadAverage;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class NetworkThroughput {
        @JsonProperty("sent")
        private int sent;

        @JsonProperty("received")
        private int received;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class DiskUsage {
        @JsonProperty("total")
        private long total;

        @JsonProperty("used")
        private long used;

        @JsonProperty("available")
        private long available;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class LoadAverage {
        @JsonProperty("1min")
        private double min1;

        @JsonProperty("5min")
        private double min5;

        @JsonProperty("15min")
        private double min15;
    }
}
