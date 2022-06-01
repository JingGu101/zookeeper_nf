package org.apache.zookeeper.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IPFilterUtil {
    public final static String EMPTY_STRING = "";

    public final static String COMMA = ",";

    public static List<String> parseList(String originalStr, String splitStr) {
        List<String> list = new ArrayList<String>();
        if (IPFilterUtil.isBlank(originalStr) || IPFilterUtil.isBlank(splitStr))
            return list;
        return IPFilterUtil.toArrayList(originalStr.split(splitStr));

    }

    public static Map<String, String> parseMap(String originalStr, String splitStr) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (IPFilterUtil.isBlank(originalStr) || IPFilterUtil.isBlank(splitStr))
            return map;
        List<String> list = IPFilterUtil.toArrayList(originalStr.split(splitStr));
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
