package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.monitor.InitMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitBlockUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0086\b\u001a.\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0086\b¢\u0006\u0002\u0010\t\u001a4\u0010\n\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0086\b¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000f\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0010\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0086\b¢\u0006\u0002\u0010\t\u001a>\u0010\u0011\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005H\u0086\b¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"LOG_TAG", "", "ifLogEnable", "", "block", "Lkotlin/Function0;", "runOrThrow", "T", "exceptionTag", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runWithMonitor", "monitorTag", "isMainThread", "", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runWithTrace", "traceTag", "runWithTraceAndMonitor", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initscheduler_release"}, k = 2, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitBlockUtilsKt {
    public static final String LOG_TAG = "InitTaskDispatcher";

    public static final <T> T runWithTrace(String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "traceTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        InitTraceUtil.INSTANCE.beginSection(str);
        T t = (T) function0.invoke();
        InitTraceUtil.INSTANCE.endSection();
        return t;
    }

    public static /* synthetic */ Object runWithMonitor$default(String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        Intrinsics.checkParameterIsNotNull(str, "monitorTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        long currentTimeMillis = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m92v(LOG_TAG, str + " start");
        }
        InitMonitor.INSTANCE.monitorStart(str, z);
        Object invoke = function0.invoke();
        InitMonitor.INSTANCE.monitorEnd(str, z);
        InitMonitor.INSTANCE.monitorCosTime(str, System.currentTimeMillis() - currentTimeMillis, z);
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m86d(LOG_TAG, str + " done. cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
        return invoke;
    }

    public static final <T> T runWithMonitor(String str, boolean z, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "monitorTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        long currentTimeMillis = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m92v(LOG_TAG, str + " start");
        }
        InitMonitor.INSTANCE.monitorStart(str, z);
        T t = (T) function0.invoke();
        InitMonitor.INSTANCE.monitorEnd(str, z);
        InitMonitor.INSTANCE.monitorCosTime(str, System.currentTimeMillis() - currentTimeMillis, z);
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m86d(LOG_TAG, str + " done. cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
        return t;
    }

    public static /* synthetic */ Object runWithTraceAndMonitor$default(String str, boolean z, String str2, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        Intrinsics.checkParameterIsNotNull(str, "monitorTag");
        Intrinsics.checkParameterIsNotNull(str2, "traceTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        long currentTimeMillis = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m92v(LOG_TAG, str + " start");
        }
        InitMonitor.INSTANCE.monitorStart(str, z);
        InitTraceUtil.INSTANCE.beginSection(str2);
        Object invoke = function0.invoke();
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(str, z);
        InitMonitor.INSTANCE.monitorCosTime(str, System.currentTimeMillis() - currentTimeMillis, z);
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m86d(LOG_TAG, str + " done. cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
        return invoke;
    }

    public static final void ifLogEnable(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        if (InitLogger.INSTANCE.isDebug()) {
            function0.invoke();
        }
    }

    public static /* synthetic */ Object runOrThrow$default(String str, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        Intrinsics.checkParameterIsNotNull(str, "exceptionTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        try {
            return function0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            if (InitScheduler.INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, str);
                return null;
            }
            throw e;
        }
    }

    public static final <T> T runOrThrow(String str, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "exceptionTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        try {
            return (T) function0.invoke();
        } catch (Exception e) {
            e.printStackTrace();
            if (InitScheduler.INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, str);
                return null;
            }
            throw e;
        }
    }

    public static final <T> T runWithTraceAndMonitor(String str, boolean z, String str2, Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "monitorTag");
        Intrinsics.checkParameterIsNotNull(str2, "traceTag");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        long currentTimeMillis = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m92v(LOG_TAG, str + " start");
        }
        InitMonitor.INSTANCE.monitorStart(str, z);
        InitTraceUtil.INSTANCE.beginSection(str2);
        T t = (T) function0.invoke();
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(str, z);
        InitMonitor.INSTANCE.monitorCosTime(str, System.currentTimeMillis() - currentTimeMillis, z);
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m86d(LOG_TAG, str + " done. cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
        return t;
    }
}
