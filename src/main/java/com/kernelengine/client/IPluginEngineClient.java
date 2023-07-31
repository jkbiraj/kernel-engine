package com.kernelengine.client;

import com.kernelengine.client.model.*;
import com.kernelengine.customexception.FetchDataException;

import java.io.IOException;

public interface IPluginEngineClient {

    FireWallData fetchFirewallData() throws IOException, FetchDataException;

    LinuxServerData fetchLinuxServerData() throws IOException, FetchDataException;

    LoadBalancerData fetchLoadBalancerData() throws IOException, FetchDataException;

    RouterData fetchRouterData() throws IOException, FetchDataException;

    SwitchData fetchSwitchData() throws IOException, FetchDataException;

    WindowsServerData fetchWindowsServerData() throws IOException, FetchDataException;
}
