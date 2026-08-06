package com.bytedance.reparo.core;

import dalvik.system.BaseDexClassLoader;
import java.io.File;

/* loaded from: classes4.dex */
public class PatchContainerClassLoader extends BaseDexClassLoader {
    public PatchContainerClassLoader(String str, File file, String str2, ClassLoader classLoader) {
        super(str, file, str2, classLoader);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        return super.findClass(str);
    }

    public Class<?> findClassFromCurrent(String str) throws ClassNotFoundException {
        return findClass(str);
    }
}
