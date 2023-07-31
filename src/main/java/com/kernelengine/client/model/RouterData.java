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
public class RouterData {

    @JsonProperty("router_id")
    private String routerID;

    @JsonProperty("cpu_utilization")
    private CPUUtilization cpuUtilization;

    @JsonProperty("memory_usage")
    private MemoryUsage memoryUsage;

    @JsonProperty("network_throughput")
    private NetworkThroughput networkThroughput;

    @JsonProperty("request_latency")
    private RequestLatency requestLatency;

    @JsonProperty("error_rates")
    private ErrorRates errorRates;

    @JsonProperty("operational_parameters")
    private OperationalParams operationalParams;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class CPUUtilization {
        @JsonProperty("average")
        private double average;

        @JsonProperty("max")
        private double max;

        @JsonProperty("min")
        private double min;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class MemoryUsage {
        @JsonProperty("used")
        private int used;

        @JsonProperty("total")
        private int total;

        @JsonProperty("percentage")
        private double percentage;
    }

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
    private static class RequestLatency {
        @JsonProperty("average_ms")
        private double averageMs;

        @JsonProperty("max_ms")
        private double maxMs;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class ErrorRates {
        @JsonProperty("http_500")
        private double http500;

        @JsonProperty("http_404")
        private double http404;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    private static class OperationalParams {
        @JsonProperty("is_active")
        private boolean isActive;

        @JsonProperty("uptime")
        private String uptime;

        @JsonProperty("temperature")
        private double temperature;
    }
}
