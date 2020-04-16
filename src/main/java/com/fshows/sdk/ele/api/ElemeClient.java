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

import java.util.List;

/**
 * @author CoderMa
 * @version ElemeClient.java, v 0.1 2020-04-01 09:42 CoderMa
 */
public interface ElemeClient {

    /**
     * 调用接口
     *
     * @param request
     * @param <T>
     * @return
     * @throws ElemeApiException
     */
    <T extends ElemeResponse<ElemeResponse>> T execute(ElemeRequest<T> request) throws ElemeApiException;

    /**
     * 调用接口
     *
     * @param request
     * @param token
     * @param userId
     * @param <T>
     * @return
     * @throws ElemeApiException
     */
    <T extends ElemeResponse<ElemeResponse>> T execute(ElemeRequest<T> request, String token, String userId) throws ElemeApiException;

    /**
     * 调用接口返回String
     *
     * @param request
     * @param token
     * @param userId
     * @param <T>
     * @return
     * @throws ElemeApiException
     */
    <T extends ElemeResponse<ElemeResponse>> String executeString(ElemeRequest<T> request, String token, String userId) throws ElemeApiException;

    /**
     * 调用接口返回Array
     *
     * @param request
     * @param token
     * @param userId
     * @param <T>
     * @return
     * @throws ElemeApiException
     */
    <T extends ElemeResponse<ElemeResponse>> List<T> executeArray(ElemeRequest<T> request, String token, String userId) throws ElemeApiException;

}