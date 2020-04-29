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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author CoderMa
 * @version MD5Utils.java, v 0.1 2020-04-16 14:32 CoderMa
 */
public class MD5Utils {

    private static final String[] HEX_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static String md5(String rawString) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(rawString.getBytes());
            byte[] rawBit = md.digest();
            String outputMD5 = " ";
            for (int i = 0; i < 16; i++) {
                outputMD5 = outputMD5 + HEX_ARRAY[rawBit[i] >>> 4 & 0x0f];
                outputMD5 = outputMD5 + HEX_ARRAY[rawBit[i] & 0x0f];
            }
            return outputMD5.trim().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("计算MD5值发生错误");
            e.printStackTrace();
        }
        return null;
    }

}