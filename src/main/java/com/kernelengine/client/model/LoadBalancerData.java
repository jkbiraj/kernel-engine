package com.kernelengine.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LoadBalancerData {

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

    @JsonProperty("active_connections")
    private int activeConnections;

    @JsonProperty("backend_servers")
    private int backendServers;

    @JsonProperty("algorithm")
    private String algorithm;

    @JsonProperty("uptime")
    private String uptime;

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
}
