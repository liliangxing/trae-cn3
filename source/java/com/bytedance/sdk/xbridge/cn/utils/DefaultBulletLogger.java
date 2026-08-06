package com.bytedance.sdk.xbridge.cn.utils;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeInjectLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/DefaultBulletLogger;", "Lcom/bytedance/sdk/xbridge/cn/utils/Logger;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "msg", "e", RXScreenCaptureService.KEY_INDEX, "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class DefaultBulletLogger implements Logger {
    private final String TAG = BulletLogger.TAG;

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.Logger
    public void d(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.d(this.TAG, msg);
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.Logger
    public void e(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.e(this.TAG, msg);
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.Logger
    public void w(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.w(this.TAG, msg);
    }

    @Override // com.bytedance.sdk.xbridge.cn.utils.Logger
    public void i(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.i(this.TAG, msg);
    }
}
