package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.exposure.ViewExposureConfig;
import com.bytedance.tobshadow.applog.exposure.ViewExposureData;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.bytedance.tobshadow.bdtracker.z0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0559z0 {

    /* renamed from: a */
    public final ViewExposureData<ViewExposureConfig> f1264a;

    /* renamed from: b */
    public boolean f1265b;

    /* renamed from: c */
    public EnumC0406d1 f1266c;

    /* renamed from: d */
    public long f1267d;

    public /* synthetic */ C0559z0(ViewExposureData viewExposureData, boolean z, EnumC0406d1 enumC0406d1, long j, int i) {
        z = (i & 2) != 0 ? false : z;
        enumC0406d1 = (i & 4) != 0 ? EnumC0406d1.NOT_EXPOSURE : enumC0406d1;
        j = (i & 8) != 0 ? 0L : j;
        Intrinsics.checkParameterIsNotNull(viewExposureData, "data");
        Intrinsics.checkParameterIsNotNull(enumC0406d1, "viewExposureTriggerType");
        this.f1264a = viewExposureData;
        this.f1265b = z;
        this.f1266c = enumC0406d1;
        this.f1267d = j;
    }

    /* renamed from: a */
    public final void m761a(EnumC0406d1 enumC0406d1) {
        Intrinsics.checkParameterIsNotNull(enumC0406d1, "<set-?>");
        this.f1266c = enumC0406d1;
    }
}
