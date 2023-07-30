package com.kernelengine.client.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FireWallData {

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

    @JsonProperty("packets_filtered")
    private int packetsFiltered;

    @JsonProperty("active_connections")
    private int activeConnections;

    @JsonProperty("rules")
    private int rules;

    @JsonProperty("uptime")
    private String uptime;

    @JsonProperty("interfaces")
    private Map<String, Interfaces> interfaces;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class NetworkThroughput {
        @JsonProperty("incoming")
        private double incoming;

        @JsonProperty("outgoing")
        private double outgoing;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class Interfaces {

        @JsonProperty("ip_address")
        private String ipAddress;

        @JsonProperty("subnet_mask")
        private String subnetMask;

        @JsonProperty("packets_in")
        private int packetsIn;

        @JsonProperty("packets_out")
        private int packetsOut;
    }
}
