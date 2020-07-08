package com.util;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * 工具类-页面下载
 * @author Kai
 * @date 2020/7/8 19:03
 */
public class PageDownloadUtil {
    public static String getPageContent(String url){
        HttpClientBuilder builder = HttpClients.custom();
        CloseableHttpClient client = builder.build();
        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");

        String content = null;
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() != 200){
                 return null;
            }
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Test
    public void TestUtil() {
        String url = "https://yuedu.163.com/book/category/category/2000";
        String content = PageDownloadUtil.getPageContent(url);
        System.out.println(content);
    }
}
