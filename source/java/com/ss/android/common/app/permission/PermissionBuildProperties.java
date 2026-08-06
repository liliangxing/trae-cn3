package com.ss.android.common.app.permission;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes7.dex */
public class PermissionBuildProperties {
    private static PermissionBuildProperties ourInstance;
    private final Properties properties;

    public static PermissionBuildProperties getInstance() throws IOException {
        if (ourInstance == null) {
            ourInstance = new PermissionBuildProperties();
        }
        return ourInstance;
    }

    private PermissionBuildProperties() throws IOException {
        Properties properties = new Properties();
        this.properties = properties;
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    public boolean containsKey(Object obj) {
        return this.properties.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.properties.containsValue(obj);
    }

    public String getProperty(String str) {
        return this.properties.getProperty(str);
    }

    public String getProperty(String str, String str2) {
        return this.properties.getProperty(str, str2);
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.properties.entrySet();
    }

    public boolean isEmpty() {
        return this.properties.isEmpty();
    }

    public Enumeration keys() {
        return this.properties.keys();
    }

    public Set keySet() {
        return this.properties.keySet();
    }

    public int size() {
        return this.properties.size();
    }

    public Collection values() {
        return this.properties.values();
    }
}
