package com.bytedance.ies.bullet.service.monitor;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/BulletMonitor;", "", "()V", "callbackConstructFunc", "Lkotlin/Function0;", "Lcom/bytedance/ies/bullet/service/monitor/AbsBulletMonitorCallback;", "generateMonitorCallback", "setMonitor", "", "func", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletMonitor {
    public static final BulletMonitor INSTANCE = new BulletMonitor();
    private static Function0<? extends AbsBulletMonitorCallback> callbackConstructFunc = new Function0<AbsBulletMonitorCallback>() { // from class: com.bytedance.ies.bullet.service.monitor.BulletMonitor$callbackConstructFunc$1
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AbsBulletMonitorCallback m558invoke() {
            return new AbsBulletMonitorCallback();
        }
    };

    private BulletMonitor() {
    }

    public final void setMonitor(Function0<? extends AbsBulletMonitorCallback> func) {
        Intrinsics.checkNotNullParameter(func, "func");
        callbackConstructFunc = func;
    }

    public final AbsBulletMonitorCallback generateMonitorCallback() {
        return (AbsBulletMonitorCallback) callbackConstructFunc.invoke();
    }
}
