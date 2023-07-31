package com.kernelengine.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kernelengine.client.model.*;

import com.kernelengine.customexception.FetchDataException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PluginEngineClientImpl implements IPluginEngineClient {

    private static final CloseableHttpClient httpClient;
    private static final String pluginEngineURL;

    private static final Logger logger = LogManager.getLogger(PluginEngineClientImpl.class);

    static {
        httpClient = HttpClients.createDefault();
        pluginEngineURL = "http://localhost:8443/fetchData";
    }

    private <T> T fetchData(String virtualDevice, Class<T> dataClass) throws IOException, FetchDataException {
        HttpGet httpGetRequest = new HttpGet(pluginEngineURL + "?virtualDevice=" + virtualDevice);
        T data = null;
        try (CloseableHttpResponse response = httpClient.execute(httpGetRequest)) {
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity httpEntity = response.getEntity();
            if (statusCode == 200) {
                if (httpEntity != null) {
                    try (InputStream inputStream = httpEntity.getContent()) {
                        String responseBody = new String(inputStream.readAllBytes());
                        ObjectMapper objectMapper = new ObjectMapper();
                        data = objectMapper.readValue(responseBody, dataClass);
                        logger.info("Fetch data success for: " + virtualDevice);
                    }
                } else {
                    logger.error("Ëmpty or invalid response for: " + virtualDevice);
                    throw new FetchDataException("Ëmpty or invalid response for: " + virtualDevice);
                }
            } else {
                if (httpEntity != null) {
                    try (InputStream inputStream = httpEntity.getContent()) {
                        String responseBody = new String(inputStream.readAllBytes());
                        ObjectMapper objectMapper = new ObjectMapper();
                        ErrorData errorData = objectMapper.readValue(responseBody, ErrorData.class);
                        logger.error("Fetch data request was not successful for: " + virtualDevice);
                        throw new FetchDataException("Error occurred while fetching data for: " + virtualDevice + ", errorResponse: " + errorData.getError());
                    }
                } else {
                    logger.error("Ëmpty or invalid response for: " + virtualDevice);
                    throw new FetchDataException("Ëmpty or invalid response for: " + virtualDevice);
                }

            }
        }
        return data;
    }

    @Override
    public FireWallData fetchFirewallData() throws IOException, FetchDataException {
        return fetchData("firewall", FireWallData.class);
    }

    @Override
    public LinuxServerData fetchLinuxServerData() throws IOException, FetchDataException {
        return fetchData("linuxServer", LinuxServerData.class);
    }

    @Override
    public LoadBalancerData fetchLoadBalancerData() throws IOException, FetchDataException {
        return fetchData("loadBalancer", LoadBalancerData.class);
    }

    @Override
    public RouterData fetchRouterData() throws IOException, FetchDataException {
        return fetchData("router", RouterData.class);
    }

    @Override
    public SwitchData fetchSwitchData() throws IOException, FetchDataException {
        return fetchData("switch", SwitchData.class);
    }

    @Override
    public WindowsServerData fetchWindowsServerData() throws IOException, FetchDataException {
        return fetchData("windowsServer", WindowsServerData.class);
    }
}
