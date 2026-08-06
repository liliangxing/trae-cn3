package com.bytedance.android.tools.superkv;

import android.os.Build;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes3.dex */
class Utils {
    private static Method cleanMethod;
    private static Class cleanerClass;
    private static Class directByteBufferClass;
    private static Method directByteBufferFreeMethod;
    private static Method getCleanerMethod;
    private static Class mappedByteBufferAdapterClass;
    private static Method mappedByteBufferAdapterFreeMethod;

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void releaseMappedByteBuffer(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        mappedByteBuffer.force();
        releaseMBBAPI24(mappedByteBuffer);
    }

    private static void releaseMBBAPI17(final MappedByteBuffer mappedByteBuffer) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.bytedance.android.tools.superkv.Utils.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    if (Utils.mappedByteBufferAdapterClass == null) {
                        Class unused = Utils.mappedByteBufferAdapterClass = Class.forName("java.nio.MappedByteBufferAdapter");
                    }
                    if (Utils.mappedByteBufferAdapterFreeMethod == null) {
                        Method unused2 = Utils.mappedByteBufferAdapterFreeMethod = Utils.mappedByteBufferAdapterClass.getMethod("free", new Class[0]);
                    }
                    Utils.mappedByteBufferAdapterFreeMethod.setAccessible(true);
                    Utils.mappedByteBufferAdapterFreeMethod.invoke(mappedByteBuffer, new Object[0]);
                    return null;
                } catch (Exception e) {
                    Debug.e("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
                    return null;
                }
            }
        });
    }

    private static void releaseMBBAPI23(final MappedByteBuffer mappedByteBuffer) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.bytedance.android.tools.superkv.Utils.2
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    if (Utils.directByteBufferClass == null) {
                        Class unused = Utils.directByteBufferClass = Class.forName("java.nio.DirectByteBuffer");
                    }
                    if (Utils.directByteBufferFreeMethod == null) {
                        Method unused2 = Utils.directByteBufferFreeMethod = Utils.directByteBufferClass.getMethod("free", new Class[0]);
                    }
                    Utils.directByteBufferFreeMethod.setAccessible(true);
                    Utils.directByteBufferFreeMethod.invoke(mappedByteBuffer, new Object[0]);
                    return null;
                } catch (Exception e) {
                    Debug.e("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
                    return null;
                }
            }
        });
    }

    private static void releaseMBBAPI24(final MappedByteBuffer mappedByteBuffer) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: com.bytedance.android.tools.superkv.Utils.3
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    if (Utils.getCleanerMethod == null) {
                        Method unused = Utils.getCleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner", new Class[0]);
                    }
                    if (Utils.cleanerClass == null) {
                        Class unused2 = Utils.cleanerClass = Class.forName("sun.misc.Cleaner");
                    }
                    if (Utils.cleanMethod == null) {
                        Method unused3 = Utils.cleanMethod = Utils.cleanerClass.getMethod("clean", new Class[0]);
                    }
                    Utils.getCleanerMethod.setAccessible(true);
                    Utils.cleanMethod.setAccessible(true);
                    Utils.cleanMethod.invoke(Utils.getCleanerMethod.invoke(mappedByteBuffer, new Object[0]), new Object[0]);
                    return null;
                } catch (Exception e) {
                    Debug.e("Unable to unmap MappedByteBuffer! API: " + Build.VERSION.SDK_INT, e);
                    return null;
                }
            }
        });
    }
}
