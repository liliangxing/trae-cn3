package com.bytedance.tobshadow.bdtracker;

import android.app.Activity;
import com.bytedance.tobshadow.applog.exposure.ViewExposureManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.bytedance.tobshadow.bdtracker.b1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0390b1 extends Lambda implements Function1<Activity, Unit> {

    /* renamed from: a */
    public final /* synthetic */ ViewExposureManager f467a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0390b1(ViewExposureManager viewExposureManager) {
        super(1);
        this.f467a = viewExposureManager;
    }

    public Object invoke(Object obj) {
        Intrinsics.checkParameterIsNotNull((Activity) obj, "it");
        ViewExposureManager.access$getTask$p(this.f467a).f808b.mo457a();
        return Unit.INSTANCE;
    }
}
