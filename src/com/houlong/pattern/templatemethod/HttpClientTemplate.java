/*
package com.houlong.pattern.templatemethod;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

*/
/**
 * Created by houlong on 2017/8/30.
 *//*

public class HttpClientTemplate<T> implements HttpClientOperations {


    @Override
    public Object post(Object object) {


        class HttpClientPostCallBack implements HttpClientCallBack {

            @Override
            public Object processResponse(HttpResponse response) {
                try {
                    if (response.containsHeader("content-type")) {
                        String head = response.getHeaders("content-type")[0].getValue();
                        String contentType = head.split(";")[0];

                            if (contentType.equalsIgnoreCase("application/json")) {
                                return EntityUtils.toByteArray(response.getEntity());

                            } else if ("text".equalsIgnoreCase("application/x-tex")) {
                                return EntityUtils.toString(response.getEntity(), "UTF-8");
                            } else {
                                return "error";
                            }
                    } else {
                        return EntityUtils.toString(response.getEntity(), "UTF-8");
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
                return null;
            }
        }
        HttpPost post = new HttpPost("");

        return execute(post, new HttpClientPostCallBack());
    }

    @Override
    public Object get(Object object) {

        class HttpClientGetCallBack implements HttpClientCallBack {

            @Override
            public Object processResponse(HttpResponse response) {
                try {
                    if (response.containsHeader("content-type")) {
                        String head = response.getHeaders("content-type")[0].getValue();
                        String contentType = head.split(";")[0];
                        if (contentType.equals("application/json")) {
                            return EntityUtils.toByteArray(response.getEntity());
                        } else {
                            if (response.containsHeader("Content-disposition")) {
                                String disposition = response.getHeaders("Content-disposition")[0].getValue();
                                String fileName = disposition.substring(disposition.indexOf("=") + 2, disposition.lastIndexOf("\""));
                                File file = new File(System.getProperty("user.dir") + fileName);
                                FileOutputStream fos = new FileOutputStream(file);
                                try {
                                    FileCopyUtils.copy(response.getEntity().getContent(), fos);
                                } finally {
                                    fos.close();
                                }
                                return file.getAbsolutePath();
                            } else {
                                return EntityUtils.toString(response.getEntity(), "UTF-8");
                            }
                        }
                    } else {
                        return EntityUtils.toString(response.getEntity(), "UTF-8");
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
                return "";
            }
        }

        HttpGet get = new HttpGet("");

        return execute(get, new HttpClientGetCallBack());
    }



    //模板方法模式
    public Object execute(HttpRequestBase method, HttpClientCallBack callBack) {
        HttpClient client;
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //设置代理
        String proxyArray[] = {"11", "22"};
        HttpHost proxy = null;
        if (null != proxyArray && proxyArray.length > 1) {
            proxy = new HttpHost(proxyArray[0], Integer.parseInt(proxyArray[1]));
            httpClientBuilder.setProxy(proxy);
        }
        httpClientBuilder.setConnectionManager(null);
        RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(2000).setConnectionRequestTimeout(1200).setProxy(proxy).build();
        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);
        client = httpClientBuilder.build();


        try {
            HttpResponse response = client.execute(method);
            //方法回调
            Object result = callBack.processResponse(response);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    ((CloseableHttpClient) client).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        int de = 12;
       int a = Integer.getInteger("xxx", de);
    }
}
*/
