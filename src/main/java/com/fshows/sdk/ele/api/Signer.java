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
package com.fshows.sdk.ele.api;

import com.fshows.sdk.ele.api.utils.LogUtil;
import com.fshows.sdk.ele.api.utils.MD5Utils;
import com.fshows.sdk.ele.api.utils.StringPool;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author CoderMa
 * @version Signer.java, v 0.1 2020-04-01 09:52 CoderMa
 */
@Slf4j
public class Signer {

    public static String sign(Map<String, Object> businessPara, String token, String secretKey, String appid, String time, String userId) {
        TreeMap<String, Object> sortMap = new TreeMap<>();
        sortMap.put("appid", appid);
        if (null != token) {
            sortMap.put("token", token);
        }
        if (null != time) {
            sortMap.put("time", time);
        }
        if (null != userId) {
            sortMap.put("user_id", userId);
        }
        if (null != secretKey) {
            sortMap.put("secret_key", secretKey);
        }

        if (businessPara != null) {
            for (Map.Entry<String, Object> o : businessPara.entrySet()) {
                sortMap.put(o.getKey(), o.getValue());
            }
        }

        String encodeUrl = buildUri(sortMap);
        LogUtil.debug(log, "encodeUrl={}", encodeUrl);

        String sign = MD5Utils.md5(encodeUrl);
        LogUtil.debug(log, "sign={}", sign);
        return sign;
    }

    private static String buildUri(TreeMap<String, Object> sortMap) {
        if (sortMap.isEmpty()) {
            return StringPool.EMPTY;
        }
        StringBuilder urlParam = new StringBuilder();
        for (Map.Entry<String, Object> sort : sortMap.entrySet()) {
            urlParam.append(sort.getKey()).append("=").append(sort.getValue());
            urlParam.append("&");
        }
        try {
            urlParam = urlParam.deleteCharAt(urlParam.length() - 1);
            return URLEncoder.encode(urlParam.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}