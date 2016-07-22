package com.devilmole.reg.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by devilmole on 2016/7/22 0022.
 */
public class HttpTool {

    private static final CloseableHttpClient httpClient;
    public static final String CHARSET = "UTF-8";
    static {
        httpClient = HttpClientBuilder.create().build();
    }

    public static void defaultHttpPost(String url){

        HttpPost httpPost = new HttpPost(url);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void defaultHttpGet(String url){
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();
                throw new RuntimeException("HttpClient,error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null){
                result = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            response.close();
            System.out.println("result---->"+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
