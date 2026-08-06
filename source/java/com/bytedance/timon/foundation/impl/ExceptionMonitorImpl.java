package com.bytedance.timon.foundation.impl;

import com.bytedance.crash.Ensure;
import com.bytedance.crash.Npth;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.assembly.ActivityDataManager;
import com.bytedance.crash.upload.EventUploadQueue;
import com.bytedance.timon.foundation.interfaces.IExceptionMonitor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionMonitorImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J`\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J,\u0010\f\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/timon/foundation/impl/ExceptionMonitorImpl;", "Lcom/bytedance/timon/foundation/interfaces/IExceptionMonitor;", "()V", "monitorNativeException", "", "nativeStack", "", "javaStack", "threadName", "message", "data", "", "monitorThrowable", "logType", "ensureType", "isCore", "", "customData", "filterData", "throwable", "", "setDebugMode", "isDebug", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ExceptionMonitorImpl implements IExceptionMonitor {
    @Override // com.bytedance.timon.foundation.interfaces.IExceptionMonitor
    public void setDebugMode(boolean isDebug) {
        ConfigManager configManager = Npth.getConfigManager();
        Intrinsics.checkExpressionValueIsNotNull(configManager, "Npth.getConfigManager()");
        configManager.setDebugMode(isDebug);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IExceptionMonitor
    public void monitorThrowable(Throwable throwable, String message, Map<String, String> data) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Ensure.ensureNotReachHere(throwable, message, data);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IExceptionMonitor
    public void monitorThrowable(String javaStack, String message, String logType, String ensureType, String threadName, boolean isCore, Map<String, String> customData, Map<String, String> filterData) {
        Intrinsics.checkParameterIsNotNull(javaStack, "javaStack");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(logType, "logType");
        Intrinsics.checkParameterIsNotNull(ensureType, "ensureType");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(customData, "customData");
        Intrinsics.checkParameterIsNotNull(filterData, "filterData");
        EventBody wrapEnsure = EventBody.wrapEnsure(new StackTraceElement(getClass().getName(), "", "", 0), javaStack, message, threadName, isCore, ensureType, logType);
        Intrinsics.checkExpressionValueIsNotNull(wrapEnsure, "EventBody.wrapEnsure(\n  …        logType\n        )");
        for (Map.Entry<String, String> entry : customData.entrySet()) {
            wrapEnsure.addCustom(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : filterData.entrySet()) {
            wrapEnsure.addFilter(entry2.getKey(), entry2.getValue());
        }
        wrapEnsure.setActivityTrace(ActivityDataManager.getInstance());
        EventUploadQueue.enqueue(wrapEnsure);
    }

    @Override // com.bytedance.timon.foundation.interfaces.IExceptionMonitor
    public void monitorNativeException(String nativeStack, String javaStack, String threadName, String message, Map<String, String> data) {
        Intrinsics.checkParameterIsNotNull(nativeStack, "nativeStack");
        Intrinsics.checkParameterIsNotNull(javaStack, "javaStack");
        Intrinsics.checkParameterIsNotNull(threadName, "threadName");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(data, "data");
        Ensure.ensureNativeStack(nativeStack, javaStack, threadName, message, data);
    }
}
