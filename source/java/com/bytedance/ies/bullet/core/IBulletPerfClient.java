package com.bytedance.ies.bullet.core;

import com.lynx.tasm.gesture.handler.GestureConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: IBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletPerfClient;", "", "onSetup", "", "engineMetrics", "Lorg/json/JSONObject;", "bulletMetrics", GestureConstants.ON_UPDATE, "flag", "", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletPerfClient {

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onUpdate(IBulletPerfClient iBulletPerfClient, JSONObject engineMetrics, JSONObject bulletMetrics, String str) {
            Intrinsics.checkNotNullParameter(engineMetrics, "engineMetrics");
            Intrinsics.checkNotNullParameter(bulletMetrics, "bulletMetrics");
        }
    }

    void onSetup(JSONObject engineMetrics, JSONObject bulletMetrics);

    void onUpdate(JSONObject engineMetrics, JSONObject bulletMetrics);

    void onUpdate(JSONObject engineMetrics, JSONObject bulletMetrics, String flag);

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletPerfClient$Base;", "Lcom/bytedance/ies/bullet/core/IBulletPerfClient;", "()V", "onSetup", "", "engineMetrics", "Lorg/json/JSONObject;", "bulletMetrics", GestureConstants.ON_UPDATE, "flag", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Base implements IBulletPerfClient {
        @Override // com.bytedance.ies.bullet.core.IBulletPerfClient
        public void onSetup(JSONObject engineMetrics, JSONObject bulletMetrics) {
            Intrinsics.checkNotNullParameter(engineMetrics, "engineMetrics");
            Intrinsics.checkNotNullParameter(bulletMetrics, "bulletMetrics");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletPerfClient
        public void onUpdate(JSONObject engineMetrics, JSONObject bulletMetrics) {
            Intrinsics.checkNotNullParameter(engineMetrics, "engineMetrics");
            Intrinsics.checkNotNullParameter(bulletMetrics, "bulletMetrics");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletPerfClient
        public void onUpdate(JSONObject engineMetrics, JSONObject bulletMetrics, String flag) {
            Intrinsics.checkNotNullParameter(engineMetrics, "engineMetrics");
            Intrinsics.checkNotNullParameter(bulletMetrics, "bulletMetrics");
            onUpdate(engineMetrics, bulletMetrics);
        }
    }
}
