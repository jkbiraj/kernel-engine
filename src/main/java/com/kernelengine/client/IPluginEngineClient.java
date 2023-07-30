package com.kernelengine.client;

import com.kernelengine.client.model.FireWallData;

import java.io.IOException;

public interface IPluginEngineClient {

    FireWallData fetchFirewallData() throws IOException;
}
