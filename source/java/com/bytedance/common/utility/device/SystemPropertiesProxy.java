package com.bytedance.common.utility.device;

@Deprecated
/* loaded from: classes3.dex */
public final class SystemPropertiesProxy {
    public String get(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }
}
