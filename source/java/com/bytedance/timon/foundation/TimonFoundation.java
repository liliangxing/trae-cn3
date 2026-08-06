package com.bytedance.timon.foundation;

import com.bytedance.timon.foundation.impl.LocalTimonLogger;
import com.bytedance.timon.foundation.interfaces.IAppLog;
import com.bytedance.timon.foundation.interfaces.IEventMonitor;
import com.bytedance.timon.foundation.interfaces.IExceptionMonitor;
import com.bytedance.timon.foundation.interfaces.ILogger;
import com.bytedance.timon.foundation.interfaces.IStore;
import com.bytedance.timon.foundation.interfaces.ITimonLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonFoundation.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/timon/foundation/TimonFoundation;", "", "()V", "appLog", "Lcom/bytedance/timon/foundation/interfaces/IAppLog;", "exceptionMonitor", "Lcom/bytedance/timon/foundation/interfaces/IExceptionMonitor;", "logger", "Lcom/bytedance/timon/foundation/interfaces/ILogger;", "monitor", "Lcom/bytedance/timon/foundation/interfaces/IEventMonitor;", "store", "Lcom/bytedance/timon/foundation/interfaces/IStore;", "timonLogger", "Lcom/bytedance/timon/foundation/interfaces/ITimonLogger;", "getAppLog", "getEventMonitor", "getExceptionMonitor", "getKvStore", "getLogger", "getTimonLogger", "setAppLog", "", "setEventMonitor", "eventMonitor", "setExceptionMonitor", "setKvStore", "setLogger", "setTimonLogger", "impl", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TimonFoundation {
    private static IAppLog appLog;
    private static IExceptionMonitor exceptionMonitor;
    private static ILogger logger;
    private static IEventMonitor monitor;
    private static IStore store;
    public static final TimonFoundation INSTANCE = new TimonFoundation();
    private static ITimonLogger timonLogger = new LocalTimonLogger();

    private TimonFoundation() {
    }

    public final ILogger getLogger() {
        ILogger iLogger = logger;
        if (iLogger != null) {
            return iLogger;
        }
        Object service = ServiceManager.get().getService(ILogger.class);
        ILogger iLogger2 = (ILogger) service;
        logger = iLogger2;
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().get…ava).also { logger = it }");
        return iLogger2;
    }

    public final IStore getKvStore() {
        IStore iStore = store;
        if (iStore != null) {
            return iStore;
        }
        Object service = ServiceManager.get().getService(IStore.class);
        IStore iStore2 = (IStore) service;
        store = iStore2;
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().get…java).also { store = it }");
        return iStore2;
    }

    public final IAppLog getAppLog() {
        IAppLog iAppLog = appLog;
        if (iAppLog != null) {
            return iAppLog;
        }
        Object service = ServiceManager.get().getService(IAppLog.class);
        IAppLog iAppLog2 = (IAppLog) service;
        appLog = iAppLog2;
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().get…ava).also { appLog = it }");
        return iAppLog2;
    }

    public final IEventMonitor getEventMonitor() {
        IEventMonitor iEventMonitor = monitor;
        if (iEventMonitor != null) {
            return iEventMonitor;
        }
        Object service = ServiceManager.get().getService(IEventMonitor.class);
        IEventMonitor iEventMonitor2 = (IEventMonitor) service;
        monitor = iEventMonitor2;
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().get…va).also { monitor = it }");
        return iEventMonitor2;
    }

    public final IExceptionMonitor getExceptionMonitor() {
        IExceptionMonitor iExceptionMonitor = exceptionMonitor;
        if (iExceptionMonitor != null) {
            return iExceptionMonitor;
        }
        Object service = ServiceManager.get().getService(IExceptionMonitor.class);
        IExceptionMonitor iExceptionMonitor2 = (IExceptionMonitor) service;
        exceptionMonitor = iExceptionMonitor2;
        Intrinsics.checkExpressionValueIsNotNull(service, "ServiceManager.get().get…{ exceptionMonitor = it }");
        return iExceptionMonitor2;
    }

    public final ITimonLogger getTimonLogger() {
        return timonLogger;
    }

    public final void setLogger(ILogger logger2) {
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        logger = logger2;
    }

    public final void setKvStore(IStore store2) {
        Intrinsics.checkParameterIsNotNull(store2, "store");
        store = store2;
    }

    public final void setAppLog(IAppLog appLog2) {
        Intrinsics.checkParameterIsNotNull(appLog2, "appLog");
        appLog = appLog2;
    }

    public final void setEventMonitor(IEventMonitor eventMonitor) {
        Intrinsics.checkParameterIsNotNull(eventMonitor, "eventMonitor");
        monitor = eventMonitor;
    }

    public final void setExceptionMonitor(IExceptionMonitor exceptionMonitor2) {
        Intrinsics.checkParameterIsNotNull(exceptionMonitor2, "exceptionMonitor");
        exceptionMonitor = exceptionMonitor2;
    }

    public final void setTimonLogger(ITimonLogger impl) {
        Intrinsics.checkParameterIsNotNull(impl, "impl");
        timonLogger = impl;
    }
}
