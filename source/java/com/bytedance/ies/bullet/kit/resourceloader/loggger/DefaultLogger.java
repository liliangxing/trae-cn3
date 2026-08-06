package com.bytedance.ies.bullet.kit.resourceloader.loggger;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/loggger/DefaultLogger;", "Lcom/bytedance/ies/bullet/kit/resourceloader/loggger/Logger;", "()V", "core", "", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "msg", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "e", "tr", "", "tridentCore", "content", "", "", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DefaultLogger implements Logger {
    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void d(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.d(RLLogger.TAG, msg);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void w(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.w(RLLogger.TAG, msg);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void w(String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        Log.w(RLLogger.TAG, msg, tr);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void e(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.e(RLLogger.TAG, msg);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void e(String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(tr, "tr");
        Log.e(RLLogger.TAG, msg, tr);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void core(TaskConfig config, String msg) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.e(RLLogger.TAG, "RlCoreLog " + msg);
    }

    @Override // com.bytedance.ies.bullet.kit.resourceloader.loggger.Logger
    public void tridentCore(TaskConfig config, String msg, Map<String, ? extends Object> content) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.e(RLLogger.TAG, "RlCoreLog " + msg);
    }
}
