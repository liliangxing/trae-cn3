package com.bytedance.bdinstall.util;

import android.os.SystemProperties;

/* loaded from: classes3.dex */
public class SystemPropertiesProxy {
    private static volatile Object sSystemProperties;

    private Object getSystemProperties() {
        if (sSystemProperties == null) {
            synchronized (SystemPropertiesProxy.class) {
                if (sSystemProperties == null) {
                    try {
                        sSystemProperties = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return sSystemProperties;
    }

    public String get(String str) throws IllegalArgumentException {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                Object systemProperties = getSystemProperties();
                return (String) systemProperties.getClass().getMethod("get", String.class).invoke(systemProperties, str);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public String get(String str, String str2) throws IllegalArgumentException {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                Object systemProperties = getSystemProperties();
                return (String) systemProperties.getClass().getMethod("get", String.class, String.class).invoke(systemProperties, str, str2);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return str2;
            }
        }
    }

    public Integer getInt(String str, int i) throws IllegalArgumentException {
        try {
            return Integer.valueOf(SystemProperties.getInt(str, i));
        } catch (Throwable th) {
            th.printStackTrace();
            Integer.valueOf(i);
            try {
                Object systemProperties = getSystemProperties();
                return (Integer) systemProperties.getClass().getMethod("getInt", String.class, Integer.TYPE).invoke(systemProperties, str, Integer.valueOf(i));
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return Integer.valueOf(i);
            }
        }
    }

    public Long getLong(String str, long j) throws IllegalArgumentException {
        try {
            return Long.valueOf(SystemProperties.getLong(str, j));
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                Object systemProperties = getSystemProperties();
                return (Long) systemProperties.getClass().getMethod("getLong", String.class, Integer.TYPE).invoke(systemProperties, str, Long.valueOf(j));
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return Long.valueOf(j);
            }
        }
    }

    public Boolean getBoolean(String str, boolean z) throws IllegalArgumentException {
        try {
            return Boolean.valueOf(SystemProperties.getBoolean(str, z));
        } catch (Throwable th) {
            th.printStackTrace();
            Boolean.valueOf(z);
            try {
                Object systemProperties = getSystemProperties();
                return (Boolean) systemProperties.getClass().getMethod("getBoolean", String.class, Boolean.TYPE).invoke(systemProperties, str, Boolean.valueOf(z));
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable unused) {
                return Boolean.valueOf(z);
            }
        }
    }
}
