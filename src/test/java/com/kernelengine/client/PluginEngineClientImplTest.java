package com.kernelengine.client;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PluginEngineClientImplTest {

    @Test
    private void testFetchFirewallData() throws IOException {
        PluginEngineClientImpl pluginEngineClient = new PluginEngineClientImpl();
        pluginEngineClient.fetchFirewallData();

    }
}