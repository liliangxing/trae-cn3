package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class PatchConstructorHelper {
    private static Map<String, Class> sOriginClassMap = new HashMap();

    public static void collectConstructorClass(Constructor constructor) {
        Class declaringClass = constructor.getDeclaringClass();
        sOriginClassMap.put(declaringClass.getName(), declaringClass);
    }

    public static void changeInstanceDeclaringClass(String str, Object obj) {
        if (PatchUtils.isART() && Build.VERSION.SDK_INT < 26 && !TextUtils.isEmpty(str) && sOriginClassMap.containsKey(str)) {
            Class cls = sOriginClassMap.get(str);
            if (cls.isInstance(obj)) {
                return;
            }
            synchronized (obj) {
                try {
                    Field declaredField = Object.class.getDeclaredField("shadow$_klass_");
                    declaredField.setAccessible(true);
                    declaredField.set(obj, cls);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
