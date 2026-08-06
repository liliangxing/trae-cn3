package com.bytedance.forest.utils;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.utils.ForestLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002JB\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010\u000e\u001a\u00020\u0004JH\u0010#\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000Ru\u0010\n\u001a]\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bj\u0004\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/forest/utils/ForestLogger;", "", "()V", "containerId", "", "getContainerId", "()Ljava/lang/String;", "setContainerId", "(Ljava/lang/String;)V", "id", "report", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "logLevel", Api.COL_TAG, "", "params", "", "Lcom/bytedance/forest/utils/LogReporter;", "getReport", "()Lkotlin/jvm/functions/Function3;", "setReport", "(Lkotlin/jvm/functions/Function3;)V", "requestUrl", "getRequestUrl", "setRequestUrl", "print", "level", "msg", "needALog", "", "t", "", "printOptimize", "msgBuilder", "Lkotlin/Function0;", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    @Deprecated
    public static final Companion INSTANCE = new Companion(null);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    private Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> report;
    private String containerId = "";
    private String requestUrl = "";
    private final String id = new StringBuilder().append(hashCode()).append('-').append(System.currentTimeMillis()).toString();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LogUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/forest/utils/ForestLogger$Companion;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SimpleDateFormat getDateFormat() {
            return ForestLogger.dateFormat;
        }
    }

    public final Function3<Integer, String, Map<String, ? extends Object>, Unit> getReport() {
        return this.report;
    }

    public final void setReport(Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> function3) {
        this.report = function3;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final void setContainerId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.containerId = str;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.requestUrl = str;
    }

    public static /* synthetic */ void print$default(ForestLogger forestLogger, int i, String str, String str2, boolean z, Throwable th, String str3, int i2, Object obj) {
        String str4;
        Throwable th2;
        if ((i2 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        boolean z2 = (i2 & 8) != 0 ? false : z;
        if ((i2 & 16) != 0) {
            th2 = null;
        } else {
            th2 = th;
        }
        forestLogger.print(i, str4, str2, z2, th2, (i2 & 32) != 0 ? "" : str3);
    }

    public final void print(final int level, final String tag, String msg, final boolean needALog, final Throwable t, final String name) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        Intrinsics.checkParameterIsNotNull(name, "name");
        final long currentTimeMillis = System.currentTimeMillis();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        StringBuilder append = new StringBuilder("[").append(this.id).append("][");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        objectRef.element = append.append(currentThread.getName()).append(']').append(msg).toString();
        final HashMap hashMap = new HashMap();
        hashMap.put("request_id", this.id);
        hashMap.put("session_id", this.containerId);
        hashMap.put("url", this.requestUrl);
        ThreadUtils.INSTANCE.runInReportThread(new Runnable() { // from class: com.bytedance.forest.utils.ForestLogger$print$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                ForestLogger.Companion companion;
                try {
                    Result.Companion companion2 = Result.Companion;
                    companion = ForestLogger.INSTANCE;
                    obj = Result.constructor-impl(companion.getDateFormat().format(new Date(currentTimeMillis)));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str == null) {
                    str = "";
                }
                objectRef.element = "[" + str + ']' + ((String) objectRef.element);
                int i = level;
                if (i == 3) {
                    LogUtils.INSTANCE.m288d(tag, (String) objectRef.element, needALog, ForestLogger.this.getReport(), name, hashMap);
                } else if (i == 4) {
                    LogUtils.INSTANCE.m291i(tag, (String) objectRef.element, needALog, ForestLogger.this.getReport(), name, hashMap);
                } else {
                    LogUtils.INSTANCE.m290e(tag, (String) objectRef.element, t, needALog, ForestLogger.this.getReport(), name, hashMap);
                }
            }
        });
    }

    public static /* synthetic */ void printOptimize$default(ForestLogger forestLogger, int i, String str, boolean z, Throwable th, String str2, Function0 function0, int i2, Object obj) {
        String str3;
        Throwable th2;
        if ((i2 & 2) != 0) {
            str3 = null;
        } else {
            str3 = str;
        }
        boolean z2 = (i2 & 4) != 0 ? false : z;
        if ((i2 & 8) != 0) {
            th2 = null;
        } else {
            th2 = th;
        }
        forestLogger.printOptimize(i, str3, z2, th2, (i2 & 16) != 0 ? "" : str2, function0);
    }

    public final void printOptimize(final int level, final String tag, final boolean needALog, final Throwable t, final String name, final Function0<String> msgBuilder) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(msgBuilder, "msgBuilder");
        final long currentTimeMillis = System.currentTimeMillis();
        StringBuilder append = new StringBuilder("[").append(this.id).append("][");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        final String sb = append.append(currentThread.getName()).append(']').toString();
        final HashMap hashMap = new HashMap();
        hashMap.put("request_id", this.id);
        hashMap.put("session_id", this.containerId);
        hashMap.put("url", this.requestUrl);
        ThreadUtils.INSTANCE.runInReportThread(new Runnable() { // from class: com.bytedance.forest.utils.ForestLogger$printOptimize$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                ForestLogger.Companion companion;
                try {
                    Result.Companion companion2 = Result.Companion;
                    companion = ForestLogger.INSTANCE;
                    obj = Result.constructor-impl(companion.getDateFormat().format(new Date(currentTimeMillis)));
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                String str = (String) obj;
                if (str == null) {
                    str = "";
                }
                String str2 = "[" + str + ']' + sb + ((String) msgBuilder.invoke());
                int i = level;
                if (i == 3) {
                    LogUtils.INSTANCE.m288d(tag, str2, needALog, ForestLogger.this.getReport(), name, hashMap);
                } else if (i == 4) {
                    LogUtils.INSTANCE.m291i(tag, str2, needALog, ForestLogger.this.getReport(), name, hashMap);
                } else {
                    LogUtils.INSTANCE.m290e(tag, str2, t, needALog, ForestLogger.this.getReport(), name, hashMap);
                }
            }
        });
    }
}
