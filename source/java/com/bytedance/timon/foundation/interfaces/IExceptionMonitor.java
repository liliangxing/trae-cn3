package com.bytedance.timon.foundation.interfaces;

import com.lynx.tasm.LynxError;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IExceptionMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J`\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\n2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J,\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nH&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/IExceptionMonitor;", "", "monitorNativeException", "", "nativeStack", "", "javaStack", "threadName", "message", "data", "", "monitorThrowable", "logType", "ensureType", "isCore", "", "customData", "filterData", LynxError.LYNX_THROWABLE, "", "setDebugMode", "isDebug", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IExceptionMonitor {
    void monitorNativeException(String nativeStack, String javaStack, String threadName, String message, Map<String, String> data);

    void monitorThrowable(String javaStack, String message, String logType, String ensureType, String threadName, boolean isCore, Map<String, String> customData, Map<String, String> filterData);

    void monitorThrowable(Throwable throwable, String message, Map<String, String> data);

    void setDebugMode(boolean isDebug);
}
