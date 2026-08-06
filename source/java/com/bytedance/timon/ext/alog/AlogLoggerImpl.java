package com.bytedance.timon.ext.alog;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon.foundation.interfaces.UploadCallback;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AlogLoggerImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/timon/ext/alog/AlogLoggerImpl;", "Lcom/bytedance/timon/foundation/interfaces/ILogger;", "()V", "d", "", "tag", "", "message", "throwable", "", "e", "i", "isLoggerReady", "", "setDebugMode", "isDebug", "upload", "startTime", "", "endTime", "scene", "callback", "Lcom/bytedance/timon/foundation/interfaces/UploadCallback;", "v", "w", "ext-alog_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AlogLoggerImpl implements ILogger {
    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void setDebugMode(boolean isDebug) {
        ALog.setDebug(isDebug);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    /* renamed from: d */
    public void mo213d(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        ALog.d(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    /* renamed from: v */
    public void mo216v(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        ALog.v(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    /* renamed from: i */
    public void mo215i(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        ALog.i(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    /* renamed from: w */
    public void mo217w(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        ALog.w(tag, message, throwable);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    /* renamed from: e */
    public void mo214e(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        ALog.e(tag, message, throwable);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void upload(long startTime, long endTime, String scene, final UploadCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        ALog.syncFlush();
        ALogConfig aLogConfig = ALog.sConfig;
        Intrinsics.checkExpressionValueIsNotNull(aLogConfig, "ALog.sConfig");
        long j = 1000;
        ApmAgent.activeUploadAlog(aLogConfig.getLogDirPath(), startTime / j, endTime / j, scene, new IALogActiveUploadObserver() { // from class: com.bytedance.timon.ext.alog.AlogLoggerImpl$upload$1
            public final void flushAlogDataToFile() {
                ALog.syncFlush();
            }
        }, new IALogActiveUploadCallback() { // from class: com.bytedance.timon.ext.alog.AlogLoggerImpl$upload$2
            public final void onCallback(boolean z, JSONObject jSONObject) {
                UploadCallback.this.onUploadResult(z, String.valueOf(jSONObject != null ? jSONObject.opt("code") : null), String.valueOf(jSONObject));
            }
        });
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public boolean isLoggerReady() {
        return ALog.isInitSuccess() && ALog.sConfig != null;
    }
}
