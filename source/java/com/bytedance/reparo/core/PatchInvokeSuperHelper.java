package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.reparo.core.log.TLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes4.dex */
public class PatchInvokeSuperHelper {
    private static final Map<String, Class> sPatchedClassMap = new HashMap();
    private static Map<Class, ReentrantLock> sPatchedClassLocks = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPatchedClasses(List<Class> list) {
        sPatchedClassMap.clear();
        for (Class cls : list) {
            if (cls != null) {
                sPatchedClassMap.put(cls.getName(), cls);
            }
        }
    }

    public static boolean replaceSuperClassForReflectionInvoke(String str, Class cls) {
        if (!PatchUtils.isART() || Build.VERSION.SDK_INT >= 26 || TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, Class> map = sPatchedClassMap;
        if (map.containsKey(str)) {
            return replaceSuperClassForReflectionInvoke(map.get(str), cls);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean replaceSuperClassForReflectionInvokeNoLock(Class cls, Class cls2) {
        Field field;
        if (cls == null) {
            return false;
        }
        try {
            field = cls.getClass().getDeclaredField("superClass");
        } catch (NoSuchFieldException e) {
            TLog.e("replaceSuperClassForReflectionInvoke: " + cls.getName(), e);
            field = null;
        }
        if (field == null) {
            return false;
        }
        field.setAccessible(true);
        try {
            field.set(cls, cls2);
            return true;
        } catch (Exception e2) {
            TLog.e("replaceSuperClassForReflectionInvoke: " + cls.getName(), e2);
            return false;
        }
    }

    static boolean replaceSuperClassForReflectionInvoke(Class cls, Class cls2) {
        if (cls == null) {
            return false;
        }
        return replaceSuperClassForReflectionInvokeNoLock(cls, cls2);
    }
}
