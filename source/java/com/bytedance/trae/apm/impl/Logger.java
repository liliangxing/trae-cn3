package com.bytedance.trae.apm.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.crash.Npth;
import com.bytedance.crash.alog.DefaultAlogUploadStrategy;
import com.bytedance.crash.alog.IALogCrashObserver;
import com.bytedance.trae.common.apphost.AppHost;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.callback.IAlogConsumer;
import com.monitor.cloudmessage.entity.ConsumerResult;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LoggerImpl.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH\u0002J(\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0005J,\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0007J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0018\u0010 \u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\"\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\"\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010$\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\"\u0010$\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001cJ&\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00052\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010(J0\u0010)\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00052 \u0010*\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010+J4\u0010,\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010(JX\u00100\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r\u0018\u00010(2 \u0010*\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/apm/impl/Logger;", "", "<init>", "()V", "TAG", "", "debug", "", "inited", "pendingLogs", "", "Lcom/bytedance/trae/apm/impl/Logger$LogInfo;", "initLogAndALog", "", "isDebug", "maxALogDirSizeMb", "", "context", "Landroid/content/Context;", "submitPendingLogs", "initAlog", "logLevel", "getDirPath", "addLogToPendingList", "level", "tag", "message", "th", "", "isInitSuccess", "v", "msg", "d", "i", "w", "tr", "e", "uploadAllLog", "scene", "unit", "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", "uploadALog", "startTime", "", "endTime", "uploadALogInternal", "LogInfo", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Logger {
    private static final String TAG = "Logger";
    private static volatile boolean inited;
    public static final Logger INSTANCE = new Logger();
    private static boolean debug = true;
    private static final List<LogInfo> pendingLogs = new ArrayList();

    private Logger() {
    }

    public final void initLogAndALog(boolean isDebug, int maxALogDirSizeMb, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        debug = isDebug;
        initAlog(isDebug, 3, maxALogDirSizeMb, context);
        inited = true;
        submitPendingLogs();
    }

    private final void submitPendingLogs() {
        ArrayList<LogInfo> arrayList = new ArrayList();
        List<LogInfo> list = pendingLogs;
        synchronized (list) {
            arrayList.addAll(list);
            list.clear();
            Unit unit = Unit.INSTANCE;
        }
        for (LogInfo logInfo : arrayList) {
            String str = logInfo.getMessage() + ", <pending:" + (System.currentTimeMillis() - logInfo.getMillis()) + "ms>";
            int level = logInfo.getLevel();
            if (level == 2) {
                INSTANCE.m791v(logInfo.getTag(), str);
            } else if (level == 3) {
                INSTANCE.m787d(logInfo.getTag(), str);
            } else if (level == 4) {
                INSTANCE.m790i(logInfo.getTag(), str);
            } else if (level == 5) {
                INSTANCE.m793w(logInfo.getTag(), str, logInfo.getTh());
            } else if (level == 6) {
                INSTANCE.m789e(logInfo.getTag(), str, logInfo.getTh());
            } else {
                throw new IllegalArgumentException(logInfo.toString());
            }
        }
    }

    private final void initAlog(boolean isDebug, int logLevel, int maxALogDirSizeMb, Context context) {
        ALog.init(new ALogConfig.Builder(context).setMaxDirSize(maxALogDirSizeMb * 1024 * 1024).setPerSize(2097152).setOffloadMainThreadWrite(true).setEnableOffloadInAllProcess(true).setNewThreadPoolImplementation(true).build());
        ALog.setDebug(isDebug);
        ALog.changeLevel(logLevel);
        if (!AppHost.INSTANCE.isOversea()) {
            CloudMessageManager.setAlogConsumerSafely(new IAlogConsumer() { // from class: com.bytedance.trae.apm.impl.Logger$initAlog$1
                private List<String> alogList = CollectionsKt.emptyList();

                public List<String> handleAlogData(long startTime, long endTime, JSONObject params) {
                    Intrinsics.checkNotNullParameter(params, "params");
                    if (startTime < endTime) {
                        ALog.asyncFlush();
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        List<String> aLogFiles = ALog.getALogFiles(startTime, endTime);
                        Intrinsics.checkNotNullExpressionValue(aLogFiles, "getALogFiles(...)");
                        this.alogList = aLogFiles;
                    }
                    return this.alogList;
                }

                public ConsumerResult getConsumerResult() {
                    boolean z = !this.alogList.isEmpty();
                    ConsumerResult build = ConsumerResult.build(z, z ? "" : "alog file not get", z ? null : ALog.getLastFetchErrorInfo());
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    return build;
                }
            });
            if (ALog.isInitSuccess()) {
                ALog.i(TAG, "alog enableALogCollector");
                Npth.enableALogCollector(ALog.sConfig.getLogDirPath(), new IALogCrashObserver() { // from class: com.bytedance.trae.apm.impl.Logger$$ExternalSyntheticLambda0
                    public final void flushAlogDataToFile() {
                        Logger.initAlog$lambda$2();
                    }
                }, new DefaultAlogUploadStrategy());
            }
        }
        ALogServiceImpl.INSTANCE.initService(isDebug);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAlog$lambda$2() {
        ALog.e(TAG, "app happen crash, upload alog");
        ALog.asyncFlush();
    }

    public final boolean isDebug() {
        return debug;
    }

    public final String getDirPath() {
        String logDirPath;
        ALogConfig aLogConfig = ALog.sConfig;
        return (aLogConfig == null || (logDirPath = aLogConfig.getLogDirPath()) == null) ? "" : logDirPath;
    }

    private final void addLogToPendingList(int level, String tag, String message, Throwable th) {
        List<LogInfo> list = pendingLogs;
        synchronized (list) {
            list.add(new LogInfo(level, tag, message, th, 0L, 16, null));
        }
    }

    public final boolean isInitSuccess() {
        return ALog.isInitSuccess();
    }

    /* renamed from: v */
    public final void m791v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(2, tag, msg, null);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.v(tag, msg);
    }

    /* renamed from: d */
    public final void m787d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(3, tag, msg, null);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.d(tag, msg);
    }

    /* renamed from: i */
    public final void m790i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(4, tag, msg, null);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.i(tag, msg);
    }

    /* renamed from: w */
    public final void m792w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(5, tag, msg, null);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.w(tag, msg);
    }

    /* renamed from: w */
    public final void m793w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(5, tag, msg, tr);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.w(tag, msg, tr);
    }

    /* renamed from: w */
    public final void m794w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(5, tag, null, tr);
        } else {
            ALog.w(tag, "", tr);
        }
    }

    /* renamed from: e */
    public final void m788e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(6, tag, msg, null);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.e(tag, msg);
    }

    /* renamed from: e */
    public final void m789e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!inited) {
            addLogToPendingList(6, tag, msg, tr);
            return;
        }
        if (msg == null) {
            msg = "";
        }
        ALog.e(tag, msg, tr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void uploadAllLog$default(Logger logger, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        logger.uploadAllLog(str, function1);
    }

    public final void uploadAllLog(String scene, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        m787d(TAG, "uploadALogData: called");
        long j = 1000;
        uploadALogInternal(scene, (System.currentTimeMillis() / j) - 10800, System.currentTimeMillis() / j, unit, null);
    }

    public final void uploadAllLogV2(String scene, Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        m787d(TAG, "uploadALogData: called");
        long j = 1000;
        uploadALogInternal(scene, (System.currentTimeMillis() / j) - 10800, System.currentTimeMillis() / j, null, callback);
    }

    public final void uploadALog(String scene, long startTime, long endTime, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        uploadALogInternal(scene, startTime, endTime, unit, null);
    }

    private final void uploadALogInternal(String scene, long startTime, long endTime, final Function1<? super Boolean, Unit> unit, final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        String str;
        Log.i(TAG, "uploadALogInternal: called");
        Log.i(TAG, "uploadALogInternal: scene = " + scene + ", startTime = " + startTime + ", endTime = " + endTime);
        if (ALog.sConfig != null && !TextUtils.isEmpty(ALog.sConfig.getLogDirPath())) {
            ApmAgent.activeUploadAlog(ALog.sConfig.getLogDirPath(), startTime, endTime, scene, new IALogActiveUploadObserver() { // from class: com.bytedance.trae.apm.impl.Logger$$ExternalSyntheticLambda1
                public final void flushAlogDataToFile() {
                    Logger.uploadALogInternal$lambda$4(unit, callback);
                }
            }, new IALogActiveUploadCallback() { // from class: com.bytedance.trae.apm.impl.Logger$$ExternalSyntheticLambda2
                public final void onCallback(boolean z, JSONObject jSONObject) {
                    Logger.uploadALogInternal$lambda$8(unit, callback, z, jSONObject);
                }
            });
            return;
        }
        if (ALog.sConfig == null) {
            if (unit != null) {
                unit.invoke(false);
            }
            if (callback != null) {
                callback.invoke(false, 0, "log config is null");
            }
            str = "ALog.sConfig is null";
        } else {
            if (unit != null) {
                unit.invoke(false);
            }
            if (callback != null) {
                callback.invoke(false, 4, "log file is null");
            }
            str = "Alog logDirPath is empty!";
        }
        String concat = "[uploadAlogInternal] Error : ".concat(str);
        Log.i(TAG, "uploadALogInternal: failed, " + concat);
        Log.w(TAG, concat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadALogInternal$lambda$4(Function1 function1, Function3 function3) {
        try {
            ALog.asyncFlush();
            Thread.sleep(1000L);
        } catch (Exception e) {
            Log.e(TAG, "[uploadAlogInternal] Error in flush Alog to file!", e);
            if (function1 != null) {
                function1.invoke(false);
            }
            if (function3 != null) {
                function3.invoke(false, 0, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadALogInternal$lambda$8(Function1 function1, Function3 function3, boolean z, JSONObject jSONObject) {
        File[] listFiles;
        Log.w(TAG, "uploadALogInternal: onCallback called, success = " + z + ", ret = " + jSONObject);
        boolean z2 = true;
        if (!z) {
            if (jSONObject != null) {
                Log.i(TAG, "uploadALogInternal: ret = " + jSONObject);
                int optInt = jSONObject.optInt("code", 0);
                if (optInt != -1 && optInt != 5) {
                    z2 = false;
                }
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(z2));
                }
                if (function3 != null) {
                    Boolean valueOf = Boolean.valueOf(z2);
                    Integer valueOf2 = Integer.valueOf(optInt);
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                    function3.invoke(valueOf, valueOf2, jSONObject2);
                    return;
                }
                return;
            }
            Log.i(TAG, "uploadALogInternal: ret = null");
            if (function1 != null) {
                function1.invoke(false);
            }
            if (function3 != null) {
                function3.invoke(false, 0, "log config is null");
                return;
            }
            return;
        }
        File file = new File(ALog.sConfig.getLogDirPath());
        if (!(file.exists() && file.listFiles() != null)) {
            file = null;
        }
        if (file != null && (listFiles = file.listFiles()) != null) {
            ArrayList<File> arrayList = new ArrayList();
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isFile()) {
                    arrayList.add(file2);
                }
            }
            for (File file3 : arrayList) {
                if (file3 != null) {
                    file3.delete();
                }
            }
        }
        if (function1 != null) {
            function1.invoke(true);
        }
        if (function3 != null) {
            function3.invoke(true, -1, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LoggerImpl.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/apm/impl/Logger$LogInfo;", "", "level", "", "tag", "", "message", "th", "", "millis", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;J)V", "getLevel", "()I", "getTag", "()Ljava/lang/String;", "getMessage", "getTh", "()Ljava/lang/Throwable;", "getMillis", "()J", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class LogInfo {
        private final int level;
        private final String message;
        private final long millis;
        private final String tag;
        private final Throwable th;

        public LogInfo(int i, String str, String str2, Throwable th, long j) {
            Intrinsics.checkNotNullParameter(str, "tag");
            this.level = i;
            this.tag = str;
            this.message = str2;
            this.th = th;
            this.millis = j;
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getTag() {
            return this.tag;
        }

        public final String getMessage() {
            return this.message;
        }

        public final Throwable getTh() {
            return this.th;
        }

        public /* synthetic */ LogInfo(int i, String str, String str2, Throwable th, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, th, (i2 & 16) != 0 ? System.currentTimeMillis() : j);
        }

        public final long getMillis() {
            return this.millis;
        }
    }
}
