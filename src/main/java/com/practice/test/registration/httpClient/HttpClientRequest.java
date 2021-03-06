package com.practice.test.registration.httpClient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientRequest {
	
	public static String getClientRequestResult() throws IOException, ClientProtocolException {
		HttpGet request = new HttpGet("http://localhost:8080/requestLogin/json");
		String result = null;

        CredentialsProvider provider = new BasicCredentialsProvider();
        provider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials("user", "pa$$word")
        );

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // 401 if wrong user/password
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                result = EntityUtils.toString(entity);
            }
            
            return result;
        }
	}
}
