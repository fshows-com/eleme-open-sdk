/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fshows.sdk.ele.api.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author wujn
 * @version FsRequestUtil.java, v 0.1 2019-04-03 17:31 wujn
 */
@Slf4j(topic = "FsRequestLog")
public class FsRequestUtil {

    /**
     * 默认请求超时时间10S
     */
    private static final int DEFAULT_REQUEST_TIME_OUT = 10 * 1000;
    /**
     * 默认连接超时时间5S
     */
    private static final int DEFAULT_CONNECT_TIME_OUT = 5 * 1000;
    /**
     * 默认连接池获取连接超时时间5S
     */
    private static final int DEFUALT_GET_CONNECTION_TIME_OUT = 5 * 1000;
    /**
     * 默认最大连接数，所有域名的请求之和
     */
    private static final int DEFAULT_MAX_TOTAL = 5 * 1000;
    /**
     * 每个路由的最大连接数，单个域名请求的最大连接数，超过这个链接会导致链接池耗尽，无法获取连接。
     */
    private static final int DEFAULT_MAX_PER_ROUT = 1000;
    /**
     * 默认content-type的值
     */
    private static final String DEFUALT_HTTP_CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";
    /**
     * XML内容头
     */
    private static final String XML_CONTENT_TYPE = "application/xml";
    /**
     * JSON内容头
     */
    private static final String JSON_CONTENT_TYPE = "application/json";
    /**
     * 默认字符集
     */
    private static final String DEFUALT_CHARSET_HEADER = "charset=utf-8";
    /**
     * 默认content-type
     */
    private static final String DEFUALT_HTTP_CONTENT_TYPE_NAME = "Content-Type";
    /**
     * 单条日志大小限制
     */
    private static final int LOG_SIZE_LIMITED = 10 * 1000;
    /**
     * 默认SSL Session缓存大小 5000 个 session
     */
    private static final int DEFAULT_SSL_SESSION_CACHE_SIZE = 5 * 1000;
    /**
     * 默认 SSL Session 缓存时间 5 分钟
     */
    private static final int DEFAULT_SSL_SESSION_TIME_OUT = 15;
    /**
     * 互斥锁
     */
    private static final Object SYNCLOCK = new Object();
    /**
     * httpclient对象
     */
    private static CloseableHttpClient httpClient = null;

    /**
     * 配置 httprequest对象，设置请求参数
     *
     * @param httpRequestBase 请求对象
     * @param timeout         超时时间
     * @throws URISyntaxException URL格式错误
     */
    private static void config(HttpRequestBase httpRequestBase, int timeout) throws URISyntaxException {
        if (timeout <= 0) {
            timeout = DEFAULT_REQUEST_TIME_OUT;
        } else {
            //转换为毫秒
            timeout = timeout * 1000;
        }
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(DEFUALT_GET_CONNECTION_TIME_OUT)
                .setConnectTimeout(DEFAULT_CONNECT_TIME_OUT)
                .setSocketTimeout(timeout).build();
        httpRequestBase.setConfig(requestConfig);
    }

    /**
     * 获取httpclient接口
     *
     * @return httpclient
     */
    private static CloseableHttpClient getHttpClient() throws NoSuchAlgorithmException, KeyManagementException {
        if (httpClient == null) {
            synchronized (SYNCLOCK) {
                if (httpClient == null) {
                    httpClient = createPoolHttpClient();
                }
            }
        }
        return httpClient;
    }

    @SuppressWarnings("unchecked")
    private static CloseableHttpClient getBasicHttpClient(InputStream certStream, char[] password) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        Registry registry = getCertSSLRegistry(certStream, password);
        BasicHttpClientConnectionManager clientConnectionManager = new BasicHttpClientConnectionManager(registry);
        HttpRequestRetryHandler requestRetryHandler = new DefaultHttpRequestRetryHandler(0, false);
        return HttpClients.custom()
                .setRetryHandler(requestRetryHandler)
                .setConnectionManager(clientConnectionManager).build();
    }

    /**
     * 创建带连接池的httpclient对象
     *
     * @return org.apache.http.impl.client.CloseableHttpClient
     */
    private static CloseableHttpClient createPoolHttpClient() throws KeyManagementException, NoSuchAlgorithmException {
        PoolingHttpClientConnectionManager clientConnectionManager = new PoolingHttpClientConnectionManager(getDefaultSSLRegistry());
        // 将最大连接数增加
        clientConnectionManager.setMaxTotal(DEFAULT_MAX_TOTAL);
        // 将每个路由基础的连接增加
        clientConnectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_PER_ROUT);
        // 关闭重试
        HttpRequestRetryHandler requestRetryHandler = new DefaultHttpRequestRetryHandler(0, false);
        return HttpClients.custom()
                .setRetryHandler(requestRetryHandler)
                .setConnectionManager(clientConnectionManager).build();
    }

    /**
     * 获取默认SSL签名
     *
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    private static Registry<ConnectionSocketFactory> getDefaultSSLRegistry() throws KeyManagementException, NoSuchAlgorithmException {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(createIgnoreVerifyContext(), NoopHostnameVerifier.INSTANCE);
        return RegistryBuilder
                .<ConnectionSocketFactory>create().register("http", plainsf)
                .register("https", sslsf).build();
    }

    /**
     * 获取自签名的SSL
     *
     * @param certStream
     * @param password
     * @return
     */
    private static Registry<ConnectionSocketFactory> getCertSSLRegistry(InputStream certStream, char[] password) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                createSignedSSLContext(password, certStream),
                new String[]{"TLSv1"},
                null,
                new DefaultHostnameVerifier());
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        return RegistryBuilder
                .<ConnectionSocketFactory>create().register("http", plainsf)
                .register("https", sslsf).build();
    }

    /**
     * 设置post请求参数
     *
     * @param httpost post请求对象
     * @param params  请求参数
     * @param charset 请求参数编码的字符集
     * @throws UnsupportedEncodingException 字符集异常
     */
    private static void setPostParams(HttpPost httpost,
                                      Map<String, String> params, String charset) throws UnsupportedEncodingException {
        List<NameValuePair> nvps = convertParam(params);
        if (nvps == null) {
            return;
        }
        httpost.setEntity(new UrlEncodedFormEntity(nvps, charset));
    }

    private static List<NameValuePair> convertParam(Map<String, String> params) {
        List<NameValuePair> nvps = new ArrayList<>();
        if (params == null || params.size() <= 0) {
            return null;
        }
        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        return nvps;
    }

    /**
     * 设置JSON请求头参数
     *
     * @param httpost post请求对象
     * @param content 字符串对象
     * @param charset 字符集
     */
    private static void setPostStringParams(HttpPost httpost, String type,
                                            String content, String charset) {
        if (!StringUtils.isBlank(content)) {
            ContentType contentType = ContentType.create(type, charset);
            httpost.setEntity(new StringEntity(content, contentType));
        }
    }

    /**
     * 设置http请求头，header内容会自动排重
     *
     * @param httpRequestBase 请求对象
     * @param headers         自定义头
     */
    private static void setHeaders(HttpRequestBase httpRequestBase,
                                   Map<String, String> headers) {
        if (headers != null && headers.size() > 0) {
            headers.forEach(httpRequestBase::setHeader);
        }
        httpRequestBase.removeHeaders("Connection");
        httpRequestBase.setHeader("Connection", "close");
    }

    /**
     * 发送请求
     *
     * @param url         请求url
     * @param requestBase 请求对象
     * @param charset     字符集
     * @param timeout     超时时间
     * @param headers     请求头部
     * @return 响应的内容
     * @throws IOException        异常
     * @throws URISyntaxException
     */
    private static String send(String url,
                               HttpRequestBase requestBase,
                               String charset,
                               int timeout,
                               Map<String, String> headers) throws IOException, URISyntaxException {
        if (StringUtils.isBlank(charset)) {
            charset = StringPool.UTF_8;
        }
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url is empty");
        }
        config(requestBase, timeout);
        setHeaders(requestBase, headers);
        try (CloseableHttpResponse response = getHttpClient().execute(requestBase, HttpClientContext.create())) {
            return getResponseContent(charset, response);
        } catch (IOException e) {
            LogUtil.error(log, "send http request error, url={},msg={}", e, url, e.getMessage());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LogUtil.error(log, e.getMessage(), e);
            /*ignore*/
        }
        return null;
    }

    private static String sendRequest(String url, String charset, Map<String, String> headers, int timeout, HttpPost post) throws IOException {
        try {
            return send(url, post, charset, timeout, headers);
        } catch (URISyntaxException e) {
            LogUtil.error(log, "request url format error, url={},msg={}", e, url, e.getMessage());
        }
        return null;
    }

    private static void validatParam(String url, String json) {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url is empty");
        }
        if (StringUtils.isBlank(json)) {
            throw new IllegalArgumentException("json data is empty");
        }
    }

    private static String getResponseContent(String charset, CloseableHttpResponse response) throws IOException {
        if (response == null) {
            return null;
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, charset);
        }
        EntityUtils.consume(entity);
        return result;
    }

    private static void logRequest(String url, String params, String headers, long begin, String result, long end) {
        if (StringUtils.isBlank(result)) {
            LogUtil.info(log, "request url={},time={}ms,param={},header={},response={}",
                    url,
                    end - begin,
                    params,
                    headers,
                    StringPool.EMPTY,
                    result);
        } else if (result.length() <= LOG_SIZE_LIMITED) {
            LogUtil.info(log, "request url={},time={}ms,param={},header={},response={}",
                    url,
                    end - begin,
                    params,
                    headers,
                    result);
        }
    }

    private static SSLContext createIgnoreVerifyContext() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
        sslContext.getClientSessionContext().setSessionTimeout(DEFAULT_SSL_SESSION_TIME_OUT);
        sslContext.getClientSessionContext().setSessionCacheSize(DEFAULT_SSL_SESSION_CACHE_SIZE);
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        sslContext.init(null, new TrustManager[]{trustManager}, null);
        return sslContext;
    }

    private static SSLContext createSignedSSLContext(char[] password, InputStream certStream) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException, KeyManagementException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(certStream, password);
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, password)
                .build();
        sslContext.getClientSessionContext().setSessionTimeout(DEFAULT_SSL_SESSION_TIME_OUT);
        sslContext.getClientSessionContext().setSessionCacheSize(DEFAULT_SSL_SESSION_CACHE_SIZE);
        return sslContext;
    }

    private static String postByString(String url,
                                       String charset,
                                       String param,
                                       String mimeType,
                                       Map<String, String> headers,
                                       int timeout) throws IOException {
        validatParam(url, param);
        long begin = System.currentTimeMillis();
        HttpPost post = new HttpPost(url);
        setPostStringParams(post, mimeType, param, charset);
        String result = sendRequest(url, charset, headers, timeout, post);
        long end = System.currentTimeMillis();
        logRequest(url, param, JSON.toJSONString(headers), begin, result, end);
        return result;
    }

    /**
     * 发送http post 请求
     *
     * @param url     url
     * @param params  请求参数
     * @param headers 自定义投
     * @param timeout 超时时间，单位为秒
     * @return
     * @throws IOException
     */
    public static String post(String url,
                              String charset,
                              Map<String, String> params,
                              Map<String, String> headers,
                              int timeout) throws IOException {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url is empty");
        }
        HttpPost post = new HttpPost(url);
        setPostParams(post, params, charset);
        long begin = System.currentTimeMillis();
        String result = sendRequest(url, charset, headers, timeout, post);
        long end = System.currentTimeMillis();
        logRequest(url, JSON.toJSONString(params), JSON.toJSONString(headers), begin, result, end);
        return result;
    }

    /**
     * 发送自签名的POST请求,每个线程持有一个httpclient，使用完后会自动关闭client和response
     *
     * @param url
     * @param certStream
     * @param password
     * @param charset
     * @param params
     * @param contentType eg:application/json
     * @param headers
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String post(String url,
                              InputStream certStream,
                              char[] password,
                              String charset,
                              String params,
                              String contentType,
                              Map<String, String> headers,
                              int timeout) throws IOException {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url is empty");
        }
        if (certStream == null || password == null) {
            throw new IllegalArgumentException("certStream is null or password is null");
        }
        if (StringUtils.isBlank(charset)) {
            charset = StringPool.UTF_8;
        }
        long begin = System.currentTimeMillis();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpClient = getBasicHttpClient(certStream, password)) {
            config(post, timeout);
            setHeaders(post, headers);
            setPostStringParams(post, contentType, params, charset);
            response = httpClient.execute(post, HttpClientContext.create());
            String result = getResponseContent(charset, response);
            long end = System.currentTimeMillis();
            logRequest(url, params, JSON.toJSONString(headers), begin, result, end);
            return result;
        } catch (CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | KeyStoreException | KeyManagementException | URISyntaxException e) {
            throw new IOException(e.getMessage(), e);
        } finally {
            if (response != null) {
                try {
                    if (response != null) {
                        response.close();
                    }
                } catch (IOException var2) {
                }
            }
        }
    }

    /**
     * 发送简单POST请求，默认使用连接池
     *
     * @param url     url
     * @param params  请求参数
     * @param timeout 超时时间
     * @return
     * @throws IOException
     */
    public static String post(String url,
                              Map<String, String> params,
                              int timeout) throws IOException {
        return post(url, StringPool.UTF_8, params, null, timeout);
    }

    /**
     * 发送 content-type为json的post请求，默认使用连接池
     *
     * @param url
     * @param json
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String postByJson(String url, String json, int timeout) throws IOException {
        return postByJson(url, StringPool.UTF_8, json, null, timeout);
    }

    /**
     * 发送 content-type为json的post请求，默认使用连接池
     *
     * @param url
     * @param charset
     * @param json
     * @param headers
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String postByJson(String url,
                                    String charset,
                                    String json,
                                    Map<String, String> headers, int timeout) throws IOException {
        return postByString(url, StringPool.UTF_8, json, JSON_CONTENT_TYPE, headers, timeout);
    }

    /**
     * 发送xml请求
     *
     * @param url
     * @param charset
     * @param xml
     * @param headers
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String postByXml(String url,
                                   String charset,
                                   String xml,
                                   Map<String, String> headers,
                                   int timeout) throws IOException {
        return postByString(url, StringPool.UTF_8, xml, XML_CONTENT_TYPE, headers, timeout);
    }

    /**
     * 发送 content-type为xml的post请求，默认使用连接池
     *
     * @param url
     * @param xml
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String postByXml(String url, String xml, int timeout) throws IOException {
        return postByXml(url, StringPool.UTF_8, xml, null, timeout);
    }

    /**
     * 发送get请求
     *
     * @param url
     * @param charset
     * @param params
     * @param headers
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String get(String url,
                             String charset,
                             Map<String, String> params,
                             Map<String, String> headers,
                             int timeout) throws IOException {
        if (StringUtils.isBlank(url)) {
            throw new IllegalArgumentException("url is empty");
        }
        URI uri = null;
        try {
            long begin = System.currentTimeMillis();
            URIBuilder builder = new URIBuilder(url);
            if (params != null && params.size() > 0) {
                List<NameValuePair> nvps = convertParam(params);
                builder.addParameters(nvps);
            }
            uri = builder.build();
            HttpGet httpGet = new HttpGet(uri);
            String content = send(url, httpGet, charset, timeout, headers);
            long end = System.currentTimeMillis();
            logRequest(url, JSON.toJSONString(params), JSON.toJSONString(headers), begin, content, end);
            return content;
        } catch (URISyntaxException ex) {
            LogUtil.error(log, "request url format error, url={},msg={}", ex, url, ex.getMessage());
        }
        return null;
    }

    /**
     * 发送get请求，默认使用连接池
     *
     * @param url
     * @param params
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String get(String url, Map<String, String> params, int timeout) throws IOException {
        return get(url, StringPool.UTF_8, params, null, timeout);
    }

    /**
     * 发送get请求,url 有中文的需要urlencode,默认使用连接池
     *
     * @param url
     * @param timeout
     * @return
     * @throws IOException
     */
    public static String get(String url, int timeout) throws IOException {
        return get(url, null, timeout);
    }

    /**
     * 手动关闭httpclient,默认是连接池模式，不建议主动关闭client，只需要在应用退出的时候关闭。
     *
     * @throws IOException
     */
    public static void closeClient() throws IOException {
        if (httpClient != null) {
            httpClient.close();
        }
    }

}