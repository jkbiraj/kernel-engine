package com.kernelengine.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kernelengine.client.model.FireWallData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class PluginEngineClientImpl implements IPluginEngineClient {

    private static final CloseableHttpClient httpClient;
    private static final String pluginEngineURL;

    static {
        httpClient = HttpClients.createDefault();
        pluginEngineURL = "http://localhost:8443/fetchData";
    }

    @Override
    public FireWallData fetchFirewallData() throws IOException {
        HttpGet httpGetFirewallDataRequest = new HttpGet(pluginEngineURL + "?virtualDevice=firewall");
        FireWallData fireWallData = null;
        try (CloseableHttpResponse response = httpClient.execute(httpGetFirewallDataRequest)) {
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null) {
                    try (InputStream inputStream = httpEntity.getContent()) {
                        String responseBody = new String(inputStream.readAllBytes());
                        ObjectMapper objectMapper = new ObjectMapper();

                        fireWallData = objectMapper.readValue(responseBody, FireWallData.class);
                    }
                }

            }
        }
        return fireWallData;
    }
}
