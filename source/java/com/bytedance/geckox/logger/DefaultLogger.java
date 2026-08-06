package com.bytedance.geckox.logger;

import android.util.Log;
import com.bytedance.applog.server.Api;
import com.bytedance.geckox.gson.GsonUtil;
import com.ss.android.agilelogger.ALog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/geckox/logger/DefaultLogger;", "Lcom/bytedance/geckox/logger/Logger;", "()V", "d", "", Api.COL_TAG, "", "msg", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "e", "tr", "", "w", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultLogger implements Logger {
    @Override // com.bytedance.geckox.logger.Logger
    /* renamed from: d */
    public void mo292d(String tag, Object... msg) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        try {
            if (msg.length == 1) {
                Object obj = msg[0];
                if (obj instanceof String) {
                    if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    ALog.i(tag, (String) obj);
                    return;
                }
            }
            ALog.i(tag, GsonUtil.INSTANCE.inst().getGson().toJson(msg));
        } catch (Throwable unused) {
            if (msg.length == 1) {
                Object obj2 = msg[0];
                if (obj2 instanceof String) {
                    if (obj2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                    Log.d(tag, (String) obj2);
                    return;
                }
            }
            Log.d(tag, GsonUtil.INSTANCE.inst().getGson().toJson(msg));
        }
    }

    @Override // com.bytedance.geckox.logger.Logger
    /* renamed from: w */
    public void mo295w(String tag, String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Log.w(tag, msg, tr);
    }

    @Override // com.bytedance.geckox.logger.Logger
    /* renamed from: w */
    public void mo294w(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        try {
            ALog.w(tag, msg);
        } catch (Throwable unused) {
            Log.w(tag, msg);
        }
    }

    @Override // com.bytedance.geckox.logger.Logger
    /* renamed from: e */
    public void mo293e(String tag, String msg, Throwable tr) {
        Intrinsics.checkParameterIsNotNull(tag, Api.COL_TAG);
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        try {
            ALog.e(tag, msg, tr);
        } catch (Throwable unused) {
            Log.e(tag, msg, tr);
        }
    }
}
