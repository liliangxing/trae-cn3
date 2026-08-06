package com.bytedance.reparo.core;

import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DexCacheCleaner {
    private static Field sClassDexCacheField;
    private HashSet dexCaches = new HashSet();

    static {
        try {
            Field declaredField = Class.class.getDeclaredField("dexCache");
            sClassDexCacheField = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void collectDexCache(Class cls) throws IllegalAccessException {
        this.dexCaches.add(sClassDexCacheField.get(cls));
    }

    private void clearDexCacheResolveTypes(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("DexCache is null!");
        }
        ReflectUtils.findField(obj, "resolvedTypes").get(obj);
        int i = ReflectUtils.findField(obj, "numResolvedTypes").getInt(obj);
        Method findMethod = ReflectUtils.findMethod(obj, "setResolvedType", (Class<?>[]) new Class[]{Integer.TYPE, Class.class});
        for (int i2 = 0; i2 < i; i2++) {
            findMethod.invoke(obj, Integer.valueOf(i2), null);
        }
        TLog.m319d("clearDexCacheResolveTypes:" + i);
    }

    private void clearDexCacheResolveFields(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("DexCache is null!");
        }
        long j = ReflectUtils.findField(obj, "resolvedFields").getLong(obj);
        int i = ReflectUtils.findField(obj, "numResolvedFields").getInt(obj);
        if (j == 0 || i == 0) {
            return;
        }
        WandTrick.getInstance().clearPointerArrayMemory(j, i);
        TLog.m319d("clearDexCacheResolveFields:" + i);
    }

    private void clearDexCacheResolveMethods(Object obj) throws Exception {
        if (obj == null) {
            throw new Exception("DexCache is null!");
        }
        long j = ReflectUtils.findField(obj, "resolvedMethods").getLong(obj);
        int i = ReflectUtils.findField(obj, "numResolvedMethods").getInt(obj);
        if (j == 0 || i == 0) {
            return;
        }
        WandTrick.getInstance().clearPointerArrayMemory(j, i);
        TLog.m319d("clearDexCacheResolveMethods:" + i);
    }

    public void clearDexCaches() throws Exception {
        Iterator it = this.dexCaches.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            clearDexCacheResolveTypes(next);
            clearDexCacheResolveFields(next);
            clearDexCacheResolveMethods(next);
        }
        this.dexCaches.clear();
    }
}
