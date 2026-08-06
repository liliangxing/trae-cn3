package com.bytedance.watson.assist.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class SystemProperties {
    private static Method sysPropGet;
    private static Method sysPropGetInt;
    private static Method sysPropGetLong;
    private static Method sysPropSet;

    static {
        try {
            for (Method method : Class.forName("android.os.SystemProperties").getMethods()) {
                String name = method.getName();
                if (name.equals("get")) {
                    sysPropGet = method;
                } else if (name.equals("set")) {
                    sysPropSet = method;
                } else if (name.equals("getLong")) {
                    sysPropGetLong = method;
                } else if (name.equals("getInt")) {
                    sysPropGetInt = method;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private SystemProperties() {
    }

    public static String get(String str, String str2) {
        Method method = sysPropGet;
        if (method == null) {
            return str2;
        }
        try {
            return (String) method.invoke(null, str, str2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return str2;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return str2;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return str2;
        }
    }

    public static long getLong(String str, long j) {
        Method method = sysPropGetLong;
        if (method == null) {
            return j;
        }
        try {
            return ((Long) method.invoke(null, str, Long.valueOf(j))).longValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return j;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return j;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return j;
        }
    }

    public static int getInt(String str, int i) {
        Method method = sysPropGetInt;
        if (method == null) {
            return i;
        }
        try {
            return ((Integer) method.invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return i;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return i;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return i;
        }
    }

    public static void set(String str, String str2) {
        try {
            sysPropSet.invoke(null, str, str2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }
}
