package com.aliyun.skywalkingdemo.demo07;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HelloHttpClient {

  public static void main(String[] args) {
    CloseableHttpClient httpClient = null;
    try {
      httpClient = HttpClientBuilder.create().build();
      HttpGet httpGet = new HttpGet("http://localhost:8888/hello");
      HttpResponse response = httpClient.execute(httpGet);
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        System.out.println("response content: " + EntityUtils.toString(entity, "UTF-8"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // 关闭或释放资源
      try {
        httpClient.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
