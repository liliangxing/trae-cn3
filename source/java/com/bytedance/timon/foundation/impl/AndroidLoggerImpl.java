package com.bytedance.timon.foundation.impl;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon.foundation.interfaces.UploadCallback;
import com.lynx.tasm.LynxError;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLoggerImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/timon/foundation/impl/AndroidLoggerImpl;", "Lcom/bytedance/timon/foundation/interfaces/ILogger;", "()V", "isDebug", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "", "message", LynxError.LYNX_THROWABLE, "", "e", RXScreenCaptureService.KEY_INDEX, "isLoggerReady", "setDebugMode", "upload", "startTime", "", "endTime", "scene", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/timon/foundation/interfaces/UploadCallback;", BaseSwitches.V, "w", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class AndroidLoggerImpl implements ILogger {
    private boolean isDebug;

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public boolean isLoggerReady() {
        return true;
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void setDebugMode(boolean isDebug) {
        this.isDebug = isDebug;
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void d(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.d(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void v(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.v(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void i(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.i(tag, message);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void w(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.w(tag, message, throwable);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void e(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Log.e(tag, message, throwable);
    }

    @Override // com.bytedance.timon.foundation.interfaces.ILogger
    public void upload(long startTime, long endTime, String scene, UploadCallback callback) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        callback.onUploadResult(false, "-1", "default log not support upload");
    }
}
