package com.ttnet.org.chromium.base;

/* loaded from: classes7.dex */
public class WrappedClassLoader extends ClassLoader {
    private ClassLoader mPrimaryClassLoader;
    private ClassLoader mSecondaryClassLoader;

    @Override // java.lang.ClassLoader
    public String findLibrary(String str) {
        return null;
    }

    public WrappedClassLoader(ClassLoader classLoader, ClassLoader classLoader2) {
        this.mPrimaryClassLoader = classLoader;
        this.mSecondaryClassLoader = classLoader2;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        try {
            return this.mPrimaryClassLoader.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return this.mSecondaryClassLoader.loadClass(str);
        }
    }
}
