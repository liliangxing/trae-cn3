package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.InitConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.w2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0540w2 {

    /* renamed from: b */
    public static final C0540w2 f1184b = new C0540w2();

    /* renamed from: a */
    public static final Map<InitConfig, Boolean> f1183a = new LinkedHashMap();

    @JvmStatic
    /* renamed from: a */
    public static final boolean m724a(InitConfig initConfig) {
        Intrinsics.checkParameterIsNotNull(initConfig, "config");
        Boolean bool = f1183a.get(initConfig);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    /* renamed from: b */
    public static final Object m725b(InitConfig initConfig) {
        Intrinsics.checkParameterIsNotNull(initConfig, "config");
        Map<InitConfig, Boolean> map = f1183a;
        Boolean bool = map.get(initConfig);
        if (bool != null) {
            return bool;
        }
        map.put(initConfig, true);
        return Unit.INSTANCE;
    }
}
