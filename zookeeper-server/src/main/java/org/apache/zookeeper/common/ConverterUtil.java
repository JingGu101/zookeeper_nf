package org.apache.zookeeper.common;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConverterUtil {
    public final static String EMPTY_STRING = "";

    public final static String COMMA = ",";

    public static List<String> parseList(String originalStr, String splitStr) {
        List<String> list = new ArrayList<String>();
        if (ConverterUtil.isBlank(originalStr) || ConverterUtil.isBlank(splitStr))
            return list;
        return ConverterUtil.toArrayList(originalStr.split(splitStr));

    }

    public static Map<String, String> parseMap(String originalStr, String splitStr) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (ConverterUtil.isBlank(originalStr) || ConverterUtil.isBlank(splitStr))
            return map;
        List<String> list = ConverterUtil.toArrayList(originalStr.split(splitStr));
        for (String ip : list) {
            ip = trimToEmpty(ip);
            map.put(ip, ip);

        }
        return map;

    }

    public static boolean isBlank(String originalStr) {
        if (null == originalStr || trimToEmpty(originalStr).isEmpty())
            return true;
        return false;
    }

    public static String trimToEmpty(String originalStr) {

        if (null == originalStr || originalStr.isEmpty())
            return EMPTY_STRING;
        return originalStr.trim();
    }

    public static ArrayList<String> toArrayList(String[] array) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (null == array || 0 == array.length) {
            return arrayList;
        }
        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    public static void startThread(Runnable runnable, String threadName) {
        if (null == runnable)
            return;
        try {
            Thread thread = new Thread(runnable, threadName);
            thread.start();

        } catch (Exception e) {
        }
    }
}
