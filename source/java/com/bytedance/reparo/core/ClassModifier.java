package com.bytedance.reparo.core;

import android.os.Build;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClassModifier {
    private static Field sClassAccessFlagsField;
    private static Field sClassClassLoaderField;
    private static Field sClassStastusField;
    private static int sInitializedStatus;

    static {
        try {
            Field declaredField = Class.class.getDeclaredField("classLoader");
            sClassClassLoaderField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Class.class.getDeclaredField("accessFlags");
            sClassAccessFlagsField = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = Class.class.getDeclaredField("status");
            sClassStastusField = declaredField3;
            declaredField3.setAccessible(true);
            Class.forName("com.bytedance.reparo.core.WandTrick");
            sInitializedStatus = ((Integer) sClassStastusField.get(WandTrick.class)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeClassClassLoader(Class cls, ClassLoader classLoader) throws IllegalAccessException {
        synchronized (cls) {
            sClassClassLoaderField.set(cls, classLoader);
        }
    }

    public static void changeClassSuperAndInterfacesToPublic(Class cls) throws IllegalAccessException {
        changeClassToPublic(cls.getSuperclass());
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces != null) {
            for (Class<?> cls2 : interfaces) {
                changeClassToPublic(cls2);
            }
        }
    }

    public static void changeClassToPublic(Class cls) throws IllegalAccessException {
        if (cls == null) {
            return;
        }
        int intValue = ((Integer) sClassAccessFlagsField.get(cls)).intValue();
        if ((intValue & 1) == 0) {
            int i = (intValue & (-8)) | 1;
            synchronized (cls) {
                sClassAccessFlagsField.set(cls, Integer.valueOf(i));
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ClassVerifingException extends Exception {
        public ClassVerifingException() {
        }

        public ClassVerifingException(String str) {
            super(str);
        }

        public ClassVerifingException(String str, Throwable th) {
            super(str, th);
        }

        public ClassVerifingException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        com.bytedance.reparo.core.ClassModifier.sClassStastusField.set(r5, java.lang.Integer.valueOf(r1));
        ensurePreverifiedMethods(r5);
        com.bytedance.reparo.core.log.TLog.m323w("status bumped to " + r1 + ", class: " + r5.getName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void changeClassToVerified(Class cls, boolean z) throws Exception {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        int i3 = sInitializedStatus;
        if (z) {
            i = 0;
            i2 = 0;
        } else {
            i3 = Build.VERSION.SDK_INT == 27 ? i3 - 3 : i3 - 2;
            i = i3 - 3;
            i2 = i3 - 1;
        }
        synchronized (cls) {
            int intValue = ((Integer) sClassStastusField.get(cls)).intValue();
            if (!z && (intValue == i || intValue == i2)) {
                throw new ClassVerifingException();
            }
        }
    }

    public static void changeFieldsToPublic(Class<?> cls) throws Exception {
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        for (Field field : ReflectUtils.getDeclaredFields(cls)) {
            WandTrick.getInstance().changeFieldToPublic(field);
        }
    }

    public static void changeConstructorsToPublic(Class<?> cls) throws Exception {
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            WandTrick.getInstance().changeConstructorToPublic(constructor);
        }
    }

    public static void changeMethodProtectedToPublic(Class<?> cls) throws Exception {
        if (Build.VERSION.SDK_INT >= 26) {
            return;
        }
        for (Method method : ReflectUtils.getDeclaredMethods(cls).getValueIgnoreError()) {
            WandTrick.getInstance().changeMethodProtectedToPublic(method);
        }
    }

    private static void ensurePreverifiedMethods(Class cls) throws Exception {
        int i = sClassAccessFlagsField.getInt(cls);
        if ((i & 524288) == 0) {
            WandTrick.getInstance().changeClinitToPreverified(cls);
            for (Method method : ReflectUtils.getDeclaredMethods(cls).getValueIgnoreError()) {
                WandTrick.getInstance().changeMethodToPreverified(method);
            }
            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                WandTrick.getInstance().changeMethodToPreverified(constructor);
            }
            sClassAccessFlagsField.set(cls, Integer.valueOf(i | 524288));
            TLog.m319d("ensurePreverifiedMethods:" + cls.getName());
        }
    }
}
