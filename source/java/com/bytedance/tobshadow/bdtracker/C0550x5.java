package com.bytedance.tobshadow.bdtracker;

import android.os.SystemProperties;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import java.util.Collections;
import java.util.List;

/* renamed from: com.bytedance.tobshadow.bdtracker.x5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0550x5 {

    /* renamed from: b */
    public static volatile Object f1249b;

    /* renamed from: a */
    public final List<String> f1250a = Collections.singletonList("SystemPropertiesProxy");

    /* renamed from: a */
    public final Object m753a() {
        if (f1249b == null) {
            synchronized (C0550x5.class) {
                if (f1249b == null) {
                    try {
                        f1249b = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        }
        return f1249b;
    }

    /* renamed from: a */
    public String m754a(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            LoggerImpl.global().error(this.f1250a, "Get key:{} value failed", th, str);
            try {
                Object m753a = m753a();
                return (String) m753a.getClass().getMethod(ApiRequest.METHOD_GET, String.class).invoke(m753a, str);
            } catch (Throwable th2) {
                LoggerImpl.global().error(this.f1250a, "Get key:{} value by reflection failed", th2, str);
                return "";
            }
        }
    }
}
