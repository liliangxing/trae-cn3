package com.bytedance.applog.util;

import com.bytedance.bdinstall.util.Singleton;

/* loaded from: classes3.dex */
public class RomUtils {
    private static final String HARMONY_UI = "harmony";
    private static final Singleton<Boolean> sIsHarmony = new Singleton<Boolean>() { // from class: com.bytedance.applog.util.RomUtils.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Boolean create(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return false;
            }
        }
    };

    public static boolean isHarmonyUI() {
        return sIsHarmony.get(new Object[0]).booleanValue();
    }
}
