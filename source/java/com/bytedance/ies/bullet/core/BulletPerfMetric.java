package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletPerfMetric.kt */
@Deprecated(message = "保留仅兼容Lucky BC, 请勿使用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletPerfMetric;", "", "mContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "(Lcom/bytedance/ies/bullet/core/BulletContext;)V", "getMContext", "()Lcom/bytedance/ies/bullet/core/BulletContext;", "getTimeStamp", "", "name", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletPerfMetric {
    private final BulletContext mContext;

    public BulletPerfMetric(BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(bulletContext, "mContext");
        this.mContext = bulletContext;
    }

    public final BulletContext getMContext() {
        return this.mContext;
    }

    public final long getTimeStamp(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual(name, "container_init_time")) {
            return this.mContext.getMonitorCallback().getPerfMetric(MetricConstant.BULLET_INIT);
        }
        return -1L;
    }
}
