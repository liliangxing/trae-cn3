package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.IMessageInterceptor;
import com.bytedance.android.alog.Log;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.agilelogger.utils.FileUtils;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.ss.android.agilelogger.utils.StackTraceUtils;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static int prio = 3;
    private static Handler sAsyncHandler;
    private static HandlerThread sAsyncLogThread;
    public static ALogConfig sConfig;
    private static volatile boolean sDebug;
    private static volatile ILogCacheCallback sILogCacheCallback;
    private static volatile boolean sInitSuccess;
    private static volatile List<INativeFuncAddrCallback> sINativeFuncAddrCallbackList = new ArrayList();
    private static ScheduledExecutorService sOuterExecutorService = null;
    private static Alog mainThreadRef = null;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances = new ArrayList<>();
    private static ExecutorService sSingleThreadExecutor = null;
    private static boolean sInitialized = false;
    private static Object sInitLock = new Object();
    private static final ThreadLocal<Long> sThreadId = new ThreadLocal<Long>() { // from class: com.ss.android.agilelogger.ALog.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Long initialValue() {
            return Long.valueOf(Process.myTid());
        }
    };

    @Deprecated
    public static void forceLogSharding() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int level2AlogCoreLevel(int i) {
        return i - 2;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean z) {
    }

    @Deprecated
    public static void setsPackageClassName(String str) {
    }

    static /* synthetic */ long access$500() {
        return getThreadId();
    }

    public static boolean init(ALogConfig aLogConfig) {
        Queue<LogItem> cachedLog;
        boolean z = false;
        if (aLogConfig == null) {
            return false;
        }
        sConfig = aLogConfig;
        try {
            Alog.init(new LibLoader());
            synchronized (sInitLock) {
                if (sInitialized) {
                    return false;
                }
                sInitialized = true;
                prio = aLogConfig.getLevel();
                boolean isMainProcess = Util.isMainProcess(aLogConfig.getContext());
                boolean isOffloadMainThreadWrite = aLogConfig.isOffloadMainThreadWrite();
                boolean z2 = !isOffloadMainThreadWrite && aLogConfig.isMainThreadSpeedUp() && isMainProcess;
                boolean enableOffloadInAllProcess = aLogConfig.enableOffloadInAllProcess();
                boolean isNewThreadPoolImplementation = aLogConfig.isNewThreadPoolImplementation();
                if (!isMainProcess) {
                    aLogConfig.setMaxDirSize((int) (aLogConfig.getMaxDirSize() * aLogConfig.getSubProcessMaxDirSizeRatio()));
                }
                Log.setInstance(new Alog.Builder(aLogConfig.getContext()).setInstanceName(DownloadSettingKeys.BugFix.DEFAULT).setLevel(level2AlogCoreLevel(aLogConfig.getLevel())).setSyslog(sDebug).setLogFileDir(aLogConfig.getLogDirPath()).setLogFileSizeEach(aLogConfig.getPerSize()).setLogFileSizeTotal(z2 ? (aLogConfig.getMaxDirSize() / 3) * 2 : aLogConfig.getMaxDirSize()).setLogFileExpDays(aLogConfig.getLogFileExpDays()).setCacheFileDir(aLogConfig.getBufferDirPath()).setCacheFileSizeEach(isMainProcess ? aLogConfig.getCacheFileSizeInKB() * 1024 : 32768).setCacheFileSizeTotal(isMainProcess ? aLogConfig.getCacheFileSizeInKB() * 3 * 1024 : 65536).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY).setCompress(aLogConfig.isCompress() ? Alog.Compress.ZSTD : Alog.Compress.NONE).setSymCrypt(aLogConfig.isEncrypt() ? Alog.SymCrypt.TEA_16 : Alog.SymCrypt.NONE).setAsymCrypt(aLogConfig.isEncrypt() ? Alog.AsymCrypt.EC_SECP256K1 : Alog.AsymCrypt.NONE).setServerPublicKey(aLogConfig.getPubKey()).setNewCompression(aLogConfig.isEnableNewCompression()).build());
                if (isOffloadMainThreadWrite && (enableOffloadInAllProcess || isMainProcess)) {
                    if (isNewThreadPoolImplementation) {
                        sSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.ss.android.agilelogger.ALog.2
                            @Override // java.util.concurrent.ThreadFactory
                            public Thread newThread(Runnable runnable) {
                                Thread thread = new Thread(runnable);
                                thread.setName("Alog_newthreadpoolimpl");
                                return thread;
                            }
                        });
                    } else {
                        HandlerThread handlerThread = new HandlerThread("Alog_main_delegate");
                        sAsyncLogThread = handlerThread;
                        handlerThread.start();
                        sAsyncHandler = new Handler(sAsyncLogThread.getLooper()) { // from class: com.ss.android.agilelogger.ALog.3
                            @Override // android.os.Handler
                            public void handleMessage(Message message) {
                                int i = message.what;
                                if (i != 1) {
                                    if (i != 2) {
                                        return;
                                    }
                                    Log.asyncFlush();
                                } else {
                                    if (message.obj == null || !(message.obj instanceof AsyncLog)) {
                                        return;
                                    }
                                    ALog.handleAsyncLog((AsyncLog) message.obj);
                                }
                            }
                        };
                    }
                }
                if (z2) {
                    mainThreadRef = new Alog.Builder(aLogConfig.getContext()).setInstanceName("main").setLevel(level2AlogCoreLevel(aLogConfig.getLevel())).setSyslog(sDebug).setLogFileDir(aLogConfig.getLogDirPath()).setLogFileSizeEach(aLogConfig.getPerSize() / 2).setLogFileSizeTotal(aLogConfig.getMaxDirSize() / 3).setLogFileExpDays(aLogConfig.getLogFileExpDays()).setCacheFileDir(aLogConfig.getBufferDirPath()).setCacheFileSizeEach(32768).setCacheFileSizeTotal(98304).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY).setCompress(aLogConfig.isCompress() ? Alog.Compress.ZSTD : Alog.Compress.NONE).setSymCrypt(aLogConfig.isEncrypt() ? Alog.SymCrypt.TEA_16 : Alog.SymCrypt.NONE).setAsymCrypt(aLogConfig.isEncrypt() ? Alog.AsymCrypt.EC_SECP256K1 : Alog.AsymCrypt.NONE).setServerPublicKey(aLogConfig.getPubKey()).setNewCompression(aLogConfig.isEnableNewCompression()).build();
                }
                final String bufferDirPath = aLogConfig.getBufferDirPath();
                final String logDirPath = aLogConfig.getLogDirPath();
                final Queue<LogItem> queue = null;
                if (sILogCacheCallback != null && ((cachedLog = sILogCacheCallback.getCachedLog()) == null || cachedLog.size() != 0)) {
                    queue = cachedLog;
                }
                if (queue != null || getNativeFuncAddrCallbackList().size() > 0) {
                    Runnable runnable = new Runnable() { // from class: com.ss.android.agilelogger.ALog.4
                        @Override // java.lang.Runnable
                        public void run() {
                            Queue queue2 = queue;
                            if (queue2 != null) {
                                ALog.writeCachedItems(queue2);
                                ALog.sILogCacheCallback.notifyCacheLogConsumed();
                            }
                            for (INativeFuncAddrCallback iNativeFuncAddrCallback : ALog.getNativeFuncAddrCallbackList()) {
                                if (iNativeFuncAddrCallback != null) {
                                    iNativeFuncAddrCallback.onNativeFuncReady(Log.getLegacyWriteFuncAddr());
                                }
                            }
                            try {
                                Thread.sleep(NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT);
                            } catch (Exception unused) {
                            }
                            ALog.removeLegacyFiles(bufferDirPath, logDirPath);
                        }
                    };
                    ScheduledExecutorService scheduledExecutorService = sOuterExecutorService;
                    if (scheduledExecutorService == null) {
                        new Thread(runnable, "_ALOG_OPT_").start();
                    } else {
                        scheduledExecutorService.execute(runnable);
                    }
                    z = true;
                }
                if (!z) {
                    ScheduledExecutorService scheduledExecutorService2 = sOuterExecutorService;
                    if (scheduledExecutorService2 == null) {
                        new Timer("_ALOG_OPT_").schedule(new TimerTask() { // from class: com.ss.android.agilelogger.ALog.5
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                ALog.removeLegacyFiles(bufferDirPath, logDirPath);
                            }
                        }, NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT);
                    } else {
                        scheduledExecutorService2.schedule(new Runnable() { // from class: com.ss.android.agilelogger.ALog.6
                            @Override // java.lang.Runnable
                            public void run() {
                                ALog.removeLegacyFiles(bufferDirPath, logDirPath);
                            }
                        }, 15L, TimeUnit.SECONDS);
                    }
                }
                sInitSuccess = true;
                return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeLegacyFiles(String str, String str2) {
        File[] listFiles;
        File[] listFiles2;
        File file = new File(str);
        if (file.exists() && (listFiles2 = file.listFiles(new FilenameFilter() { // from class: com.ss.android.agilelogger.ALog.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str3) {
                return str3.startsWith(".logCache_");
            }
        })) != null) {
            for (File file2 : listFiles2) {
                file2.delete();
            }
        }
        File file3 = new File(str2);
        if (!file3.exists() || (listFiles = file3.listFiles(new FilenameFilter() { // from class: com.ss.android.agilelogger.ALog.8
            @Override // java.io.FilenameFilter
            public boolean accept(File file4, String str3) {
                if (str3.endsWith(".hoting")) {
                    return true;
                }
                return str3.endsWith(".hot") && !str3.endsWith(".alog.hot");
            }
        })) == null) {
            return;
        }
        for (File file4 : listFiles) {
            file4.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeCachedItems(Queue<LogItem> queue) {
        for (LogItem logItem : queue) {
            if (checkPrioAndTag(logItem.mLevel, logItem.mTag)) {
                handleItemMsg(logItem);
                Log.innerWrite(level2AlogCoreLevel(logItem.mLevel), logItem.mTag, logItem.mMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.agilelogger.ALog$14 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C034214 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE;

        static {
            int[] iArr = new int[FormatUtils.TYPE.values().length];
            $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE = iArr;
            try {
                iArr[FormatUtils.TYPE.MSG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BORDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.JSON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.INTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THREAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private static void handleItemMsg(LogItem logItem) {
        String str;
        switch (C034214.$SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[logItem.mFormatType.ordinal()]) {
            case 1:
                str = (String) logItem.mObj;
                break;
            case 2:
                if (logItem.mObj2 == null) {
                    str = StackTraceUtils.getStackTraceString((Throwable) logItem.mObj);
                    break;
                } else {
                    str = logItem.mObj2 + StackTraceUtils.getStackTraceString((Throwable) logItem.mObj);
                    break;
                }
            case 3:
            case 4:
                str = FormatUtils.format(logItem.mFormatType, (String) logItem.mObj);
                break;
            case 5:
                str = FormatUtils.format(logItem.mFormatType, (Bundle) logItem.mObj);
                break;
            case 6:
                str = FormatUtils.format(logItem.mFormatType, (Intent) logItem.mObj);
                break;
            case 7:
                str = FormatUtils.format(logItem.mFormatType, (Throwable) logItem.mObj);
                break;
            case 8:
                str = FormatUtils.format(logItem.mFormatType, (Thread) logItem.mObj);
                break;
            case 9:
                str = FormatUtils.format(logItem.mFormatType, (StackTraceElement[]) logItem.mObj);
                break;
            default:
                str = "";
                break;
        }
        logItem.mMsg = str;
    }

    public static void setDebug(boolean z) {
        sDebug = z;
        Log.setSyslog(sDebug);
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.setSyslog(sDebug);
        }
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void setBlockTagSet(Set<String> set) {
        mBlockTagSet = Collections.unmodifiableSet(set);
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static void setILogCacheCallback(ILogCacheCallback iLogCacheCallback) {
        sILogCacheCallback = iLogCacheCallback;
    }

    public static void addNativeFuncAddrCallback(INativeFuncAddrCallback iNativeFuncAddrCallback) {
        sINativeFuncAddrCallbackList.add(iNativeFuncAddrCallback);
    }

    public static List<INativeFuncAddrCallback> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static boolean checkPrioAndTag(int i, String str) {
        if (i < prio) {
            return false;
        }
        Set<String> set = mBlockTagSet;
        return set == null || TextUtils.isEmpty(str) || !set.contains(str);
    }

    /* renamed from: v */
    public static void m49v(String str, String str2) {
        if (checkPrioAndTag(2, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(2, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(2, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(2, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(2, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.v(str, str2);
            } else {
                Log.innerVerbose(str, str2);
            }
        }
    }

    /* renamed from: d */
    public static void m44d(String str, String str2) {
        if (checkPrioAndTag(3, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(3, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(3, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(3, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(3, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.d(str, str2);
            } else {
                Log.innerDebug(str, str2);
            }
        }
    }

    /* renamed from: i */
    public static void m48i(String str, String str2) {
        if (checkPrioAndTag(4, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(4, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(4, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(4, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(4, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.i(str, str2);
            } else {
                Log.innerInfo(str, str2);
            }
        }
    }

    /* renamed from: w */
    public static void m50w(String str, String str2) {
        if (checkPrioAndTag(5, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(5, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(5, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.w(str, str2);
            } else {
                Log.innerWarn(str, str2);
            }
        }
    }

    /* renamed from: w */
    public static void m51w(String str, String str2, Throwable th) {
        if (checkPrioAndTag(5, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, str2, th, null, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(5, str, str2, th, null, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, str2, th, null, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(5, str, str2, th, null, null);
                return;
            }
            String str3 = str2 + UpdateDialogNewBase.TYPE + StackTraceUtils.getStackTraceString(th);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.w(str, str3);
            } else {
                Log.innerWarn(str, str3);
            }
        }
    }

    /* renamed from: w */
    public static void m52w(String str, Throwable th) {
        if (checkPrioAndTag(5, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, null, th, null, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(5, str, null, th, null, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(5, str, null, th, null, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(5, str, null, th, null, null);
                return;
            }
            String stackTraceString = StackTraceUtils.getStackTraceString(th);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.w(str, stackTraceString);
            } else {
                Log.innerWarn(str, stackTraceString);
            }
        }
    }

    /* renamed from: e */
    public static void m45e(String str, String str2) {
        if (checkPrioAndTag(6, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(6, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(6, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.e(str, str2);
            } else {
                Log.innerError(str, str2);
            }
        }
    }

    /* renamed from: e */
    public static void m46e(String str, String str2, Throwable th) {
        if (checkPrioAndTag(6, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, str2, th, null, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(6, str, str2, th, null, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, str2, th, null, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(6, str, str2, th, null, null);
                return;
            }
            String str3 = str2 + UpdateDialogNewBase.TYPE + StackTraceUtils.getStackTraceString(th);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.e(str, str3);
            } else {
                Log.innerError(str, str3);
            }
        }
    }

    /* renamed from: e */
    public static void m47e(String str, Throwable th) {
        if (checkPrioAndTag(6, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, null, th, null, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(6, str, null, th, null, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(6, str, null, th, null, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(6, str, null, th, null, null);
                return;
            }
            String stackTraceString = StackTraceUtils.getStackTraceString(th);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.e(str, stackTraceString);
            } else {
                Log.innerError(str, stackTraceString);
            }
        }
    }

    public static void header(int i, String str, String str2) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2, null, FormatUtils.TYPE.BORDER, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, str2, null, FormatUtils.TYPE.BORDER, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2, null, FormatUtils.TYPE.BORDER, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, str2, null, FormatUtils.TYPE.BORDER, null);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.BORDER, str2);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void json(int i, String str, String str2) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2, null, FormatUtils.TYPE.JSON, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, str2, null, FormatUtils.TYPE.JSON, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2, null, FormatUtils.TYPE.JSON, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, str2, null, FormatUtils.TYPE.JSON, null);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.JSON, str2);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void bundle(int i, String str, Bundle bundle) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.BUNDLE, bundle);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.BUNDLE, bundle);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.BUNDLE, bundle);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.BUNDLE, bundle);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.BUNDLE, bundle);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void intent(int i, String str, Intent intent) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.INTENT, intent);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.INTENT, intent);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.INTENT, intent);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.INTENT, intent);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.INTENT, intent);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void throwable(int i, String str, Throwable th) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, th, FormatUtils.TYPE.THROWABLE, null);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, null, th, FormatUtils.TYPE.THROWABLE, null);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, th, FormatUtils.TYPE.THROWABLE, null);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.THROWABLE, th);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.THROWABLE, th);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void thread(int i, String str, Thread thread) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.THREAD, thread);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.THREAD, thread);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.THREAD, thread);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.THREAD, thread);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.THREAD, thread);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void stacktrace(int i, String str, StackTraceElement[] stackTraceElementArr) {
        if (checkPrioAndTag(i, str)) {
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.STACKTRACE, stackTraceElementArr);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.STACKTRACE, stackTraceElementArr);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, null, null, FormatUtils.TYPE.STACKTRACE, stackTraceElementArr);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, null, null, FormatUtils.TYPE.STACKTRACE, stackTraceElementArr);
                return;
            }
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            String format = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, stackTraceElementArr);
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, format);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, format);
            }
        }
    }

    public static void statcktrace(int i, String str, StackTraceElement[] stackTraceElementArr) {
        stacktrace(i, str, stackTraceElementArr);
    }

    public static void println(int i, String str, Object obj, FormatUtils.TYPE type) {
        String str2;
        if (checkPrioAndTag(i, str)) {
            int level2AlogCoreLevel = level2AlogCoreLevel(i);
            switch (C034214.$SwitchMap$com$ss$android$agilelogger$utils$FormatUtils$TYPE[type.ordinal()]) {
                case 1:
                    str2 = (String) obj;
                    break;
                case 2:
                    str2 = StackTraceUtils.getStackTraceString((Throwable) obj);
                    break;
                case 3:
                    str2 = FormatUtils.format(FormatUtils.TYPE.BORDER, (String) obj);
                    break;
                case 4:
                    str2 = FormatUtils.format(FormatUtils.TYPE.JSON, (String) obj);
                    break;
                case 5:
                    str2 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) obj);
                    break;
                case 6:
                    str2 = FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) obj);
                    break;
                case 7:
                    str2 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) obj);
                    break;
                case 8:
                    str2 = FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) obj);
                    break;
                case 9:
                    str2 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) obj);
                    break;
                default:
                    str2 = "";
                    break;
            }
            ALogConfig aLogConfig = sConfig;
            if (aLogConfig != null && aLogConfig.enableOffloadInAllThread() && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2);
                return;
            }
            ALogConfig aLogConfig2 = sConfig;
            if (aLogConfig2 != null && aLogConfig2.enableOffloadInAllThread() && sAsyncHandler != null) {
                postAsyncLog(i, str, str2);
                return;
            }
            boolean isMainThread = Util.isMainThread();
            if (isMainThread && sSingleThreadExecutor != null) {
                postAsyncLogByThreadPool(i, str, str2);
                return;
            }
            if (isMainThread && sAsyncHandler != null) {
                postAsyncLog(i, str, str2);
                return;
            }
            Alog alog = mainThreadRef;
            if (alog != null && isMainThread) {
                alog.write(level2AlogCoreLevel, str, str2);
            } else {
                Log.innerWrite(level2AlogCoreLevel, str, str2);
            }
        }
    }

    public static void asyncFlush() {
        Alog alog;
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.ss.android.agilelogger.ALog.9
                @Override // java.lang.Runnable
                public void run() {
                    Log.asyncFlush();
                }
            });
        } else {
            Handler handler = sAsyncHandler;
            if (handler != null) {
                handler.sendEmptyMessage(2);
            }
        }
        Log.asyncFlush();
        Alog alog2 = mainThreadRef;
        if (alog2 != null) {
            alog2.asyncFlush();
        }
        Iterator<WeakReference<Alog>> it = sStandaloneInstances.iterator();
        while (it.hasNext()) {
            WeakReference<Alog> next = it.next();
            if (next != null && (alog = next.get()) != null) {
                alog.asyncFlush();
            }
        }
    }

    public static void syncFlush() {
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.ss.android.agilelogger.ALog.10
                @Override // java.lang.Runnable
                public void run() {
                    Log.asyncFlush();
                }
            });
        }
        Handler handler = sAsyncHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        Log.syncFlush();
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.syncFlush();
        }
        Iterator<WeakReference<Alog>> it = sStandaloneInstances.iterator();
        while (it.hasNext()) {
            Alog alog2 = it.next().get();
            if (alog2 != null) {
                alog2.syncFlush();
            }
        }
    }

    public static void timedSyncFlush(int i) {
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.ss.android.agilelogger.ALog.11
                @Override // java.lang.Runnable
                public void run() {
                    Log.asyncFlush();
                }
            });
        }
        Handler handler = sAsyncHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        Log.timedSyncFlush(i);
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.timedSyncFlush(i);
        }
        Iterator<WeakReference<Alog>> it = sStandaloneInstances.iterator();
        while (it.hasNext()) {
            Alog alog2 = it.next().get();
            if (alog2 != null) {
                alog2.timedSyncFlush(i);
            }
        }
    }

    public static void setOuterExecutorService(ScheduledExecutorService scheduledExecutorService) {
        sOuterExecutorService = scheduledExecutorService;
    }

    public static void changeLevel(int i) {
        prio = i;
        Log.setLevel(level2AlogCoreLevel(i));
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.setLevel(level2AlogCoreLevel(i));
        }
    }

    public static List<String> getALogFiles(long j, long j2) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] logs = Log.getLogs((String) null, (String) null, j * 1000, j2 * 1000);
            for (File file : logs) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return Log.getLastFetchErrorInfo();
    }

    public static String getStatus() {
        try {
            return Log.getStatus();
        } catch (Exception unused) {
            return "getStatus exception";
        }
    }

    public static List<String> getALogFiles(String str, String str2, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] logs = Log.getLogs(str, str2, j * 1000, j2 * 1000);
            for (File file : logs) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void destroy() {
        Log.close();
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.close();
        }
        if (sAsyncHandler != null) {
            sAsyncLogThread.quit();
            sAsyncLogThread = null;
            sAsyncHandler = null;
        }
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.shutdown();
            sSingleThreadExecutor = null;
        }
    }

    public static void release() {
        Log.close();
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.close();
        }
        if (sAsyncHandler != null) {
            sAsyncLogThread.quit();
            sAsyncLogThread = null;
            sAsyncHandler = null;
        }
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.shutdown();
            sSingleThreadExecutor = null;
        }
    }

    @Deprecated
    public static void flush() {
        ExecutorService executorService = sSingleThreadExecutor;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.ss.android.agilelogger.ALog.12
                @Override // java.lang.Runnable
                public void run() {
                    Log.asyncFlush();
                }
            });
        }
        Handler handler = sAsyncHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        Log.asyncFlush();
        Alog alog = mainThreadRef;
        if (alog != null) {
            alog.asyncFlush();
        }
    }

    public static long getALogWriteFuncAddr() {
        return Log.getLegacyWriteFuncAddr();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return Log.getLegacyFlushFuncAddr();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return Log.getLegacyGetLogFileDirFuncAddr();
    }

    public static long getALogSimpleWriteFuncAddr() {
        return Log.getNativeWriteFuncAddr();
    }

    public static long getALogSimpleWriteAsyncFuncAddr() {
        return Log.getNativeWriteAsyncFuncAddr();
    }

    public static long getALogSimpleInitFuncAddr() {
        return Log.getNativeInitFuncAddr();
    }

    public static void writeAsyncLog(int i, String str, String str2, long j, long j2) {
        Log.innerWriteAsyncMsg(level2AlogCoreLevel(i), str, str2, j, j2);
    }

    private static void postAsyncLogByThreadPool(int i, String str, String str2) {
        postAsyncLogByThreadPool(i, str, str2, null, null, null);
    }

    private static void postAsyncLogByThreadPool(final int i, final String str, final String str2, final Throwable th, final FormatUtils.TYPE type, final Object obj) {
        final long threadId = getThreadId();
        final long currentTimeMillis = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new Runnable() { // from class: com.ss.android.agilelogger.ALog.13
            @Override // java.lang.Runnable
            public void run() {
                int level2AlogCoreLevel = ALog.level2AlogCoreLevel(i);
                FormatUtils.TYPE type2 = type;
                if (type2 == null) {
                    if (th != null) {
                        String str3 = (str2 == null ? "" : str2 + UpdateDialogNewBase.TYPE) + StackTraceUtils.getStackTraceString(th);
                    }
                } else if (type2 == FormatUtils.TYPE.BORDER) {
                    FormatUtils.format(FormatUtils.TYPE.BORDER, str2);
                } else if (type == FormatUtils.TYPE.JSON) {
                    FormatUtils.format(FormatUtils.TYPE.JSON, str2);
                } else if (type == FormatUtils.TYPE.BUNDLE) {
                    FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) obj);
                } else if (type == FormatUtils.TYPE.INTENT) {
                    FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) obj);
                } else if (type == FormatUtils.TYPE.THROWABLE) {
                    FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) obj);
                } else if (type == FormatUtils.TYPE.THREAD) {
                    FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) obj);
                } else if (type == FormatUtils.TYPE.STACKTRACE) {
                    FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) obj);
                }
                Log.innerWriteAsyncMsg(level2AlogCoreLevel, str, str2, threadId, currentTimeMillis);
            }
        });
    }

    private static void postAsyncLog(int i, String str, String str2) {
        postAsyncLog(i, str, str2, null, null, null);
    }

    private static void postAsyncLog(int i, String str, String str2, Throwable th, FormatUtils.TYPE type, Object obj) {
        AsyncLog obtain = AsyncLog.obtain();
        obtain.level = i;
        obtain.tag = str;
        obtain.msg = str2;
        obtain.throwable = th;
        obtain.formatType = type;
        obtain.infoObject = obj;
        obtain.tid = getThreadId();
        obtain.timestampMs = System.currentTimeMillis();
        Message obtain2 = Message.obtain();
        obtain2.what = 1;
        obtain2.obj = obtain;
        sAsyncHandler.sendMessage(obtain2);
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleAsyncLog(AsyncLog asyncLog) {
        String str;
        String format;
        int level2AlogCoreLevel = level2AlogCoreLevel(asyncLog.level);
        if (asyncLog.formatType == null) {
            if (asyncLog.throwable == null) {
                format = asyncLog.msg;
            } else {
                format = (asyncLog.msg != null ? asyncLog.msg + UpdateDialogNewBase.TYPE : "") + StackTraceUtils.getStackTraceString(asyncLog.throwable);
            }
        } else if (asyncLog.formatType == FormatUtils.TYPE.BORDER) {
            format = FormatUtils.format(FormatUtils.TYPE.BORDER, asyncLog.msg);
        } else if (asyncLog.formatType == FormatUtils.TYPE.JSON) {
            format = FormatUtils.format(FormatUtils.TYPE.JSON, asyncLog.msg);
        } else if (asyncLog.formatType == FormatUtils.TYPE.BUNDLE) {
            format = FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) asyncLog.infoObject);
        } else if (asyncLog.formatType == FormatUtils.TYPE.INTENT) {
            format = FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) asyncLog.infoObject);
        } else if (asyncLog.formatType == FormatUtils.TYPE.THROWABLE) {
            format = FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) asyncLog.infoObject);
        } else if (asyncLog.formatType == FormatUtils.TYPE.THREAD) {
            format = FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) asyncLog.infoObject);
        } else if (asyncLog.formatType == FormatUtils.TYPE.STACKTRACE) {
            format = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) asyncLog.infoObject);
        } else {
            str = "";
            Log.innerWriteAsyncMsg(level2AlogCoreLevel, asyncLog.tag, str, asyncLog.tid, asyncLog.timestampMs);
            asyncLog.recycle();
        }
        str = format;
        Log.innerWriteAsyncMsg(level2AlogCoreLevel, asyncLog.tag, str, asyncLog.tid, asyncLog.timestampMs);
        asyncLog.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class AsyncLog {
        private static final int MAX_POOL_SIZE = 50;
        private static AsyncLog sPool;
        private static int sPoolSize;
        private static final Object sPoolSync = new Object();
        public FormatUtils.TYPE formatType = null;
        public Object infoObject;
        public int level;
        public String msg;
        public AsyncLog next;
        public String tag;
        public Throwable throwable;
        public long tid;
        public long timestampMs;

        private AsyncLog() {
        }

        public static AsyncLog obtain() {
            synchronized (sPoolSync) {
                AsyncLog asyncLog = sPool;
                if (asyncLog != null) {
                    sPool = asyncLog.next;
                    asyncLog.next = null;
                    sPoolSize--;
                    return asyncLog;
                }
                return new AsyncLog();
            }
        }

        public void recycle() {
            this.tag = null;
            this.msg = null;
            this.throwable = null;
            this.formatType = null;
            this.infoObject = null;
            this.tid = -1L;
            this.timestampMs = 0L;
            this.next = null;
            synchronized (sPoolSync) {
                int i = sPoolSize;
                if (i < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize = i + 1;
                }
            }
        }
    }

    public static LogInstance createInstance(String str, Context context) {
        if (context == null) {
            return null;
        }
        return createInstance(str, new ALogConfig.Builder(context).build());
    }

    public static LogInstance createInstance(String str, ALogConfig aLogConfig) {
        if (aLogConfig == null) {
            return null;
        }
        if (!sInitSuccess) {
            try {
                Alog.init(new LibLoader());
            } catch (Throwable unused) {
                return null;
            }
        }
        Alog.Builder syslog = new Alog.Builder(aLogConfig.getContext()).setInstanceName(str).setLevel(level2AlogCoreLevel(aLogConfig.getLevel())).setSyslog(sDebug);
        ALogConfig aLogConfig2 = sConfig;
        Alog.Builder logFileExpDays = syslog.setLogFileDir(aLogConfig2 != null ? aLogConfig2.getLogDirPath() : aLogConfig.getLogDirPath()).setLogFileSizeEach(aLogConfig.getPerSize()).setLogFileSizeTotal(aLogConfig.getMaxDirSize()).setLogFileExpDays(aLogConfig.getLogFileExpDays());
        ALogConfig aLogConfig3 = sConfig;
        Alog build = logFileExpDays.setCacheFileDir(aLogConfig3 != null ? aLogConfig3.getBufferDirPath() : aLogConfig.getBufferDirPath()).setCacheFileSizeEach(65536).setCacheFileSizeTotal(196608).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY).setCompress(aLogConfig.isCompress() ? Alog.Compress.ZSTD : Alog.Compress.NONE).setSymCrypt(aLogConfig.isEncrypt() ? Alog.SymCrypt.TEA_16 : Alog.SymCrypt.NONE).setAsymCrypt(aLogConfig.isEncrypt() ? Alog.AsymCrypt.EC_SECP256K1 : Alog.AsymCrypt.NONE).setServerPublicKey(aLogConfig.getPubKey()).setNewCompression(aLogConfig.isEnableNewCompression()).build();
        if (build == null) {
            return null;
        }
        sStandaloneInstances.add(new WeakReference<>(build));
        return new LogInstance(build, str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LogInstance {
        private static ExecutorService sLogInstanceExecutor;
        private final Alog mAlog;

        public LogInstance(Alog alog, final String str) {
            this.mAlog = alog;
            sLogInstanceExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.ss.android.agilelogger.ALog.LogInstance.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("Alog_instance-" + str);
                    return thread;
                }
            });
        }

        public void shutdown() {
            sLogInstanceExecutor.shutdown();
        }

        /* renamed from: v */
        public void m56v(final String str, final String str2) {
            final long access$500 = ALog.access$500();
            final long currentTimeMillis = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(2, str)) {
                sLogInstanceExecutor.submit(new Runnable() { // from class: com.ss.android.agilelogger.ALog.LogInstance.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LogInstance.this.mAlog.writeAsyncMsg(ALog.level2AlogCoreLevel(2), str, str2, access$500, currentTimeMillis);
                    }
                });
            }
        }

        /* renamed from: d */
        public void m53d(final String str, final String str2) {
            final long access$500 = ALog.access$500();
            final long currentTimeMillis = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(3, str)) {
                sLogInstanceExecutor.submit(new Runnable() { // from class: com.ss.android.agilelogger.ALog.LogInstance.3
                    @Override // java.lang.Runnable
                    public void run() {
                        LogInstance.this.mAlog.writeAsyncMsg(ALog.level2AlogCoreLevel(3), str, str2, access$500, currentTimeMillis);
                    }
                });
            }
        }

        /* renamed from: i */
        public void m55i(final String str, final String str2) {
            final long access$500 = ALog.access$500();
            final long currentTimeMillis = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(4, str)) {
                sLogInstanceExecutor.submit(new Runnable() { // from class: com.ss.android.agilelogger.ALog.LogInstance.4
                    @Override // java.lang.Runnable
                    public void run() {
                        LogInstance.this.mAlog.writeAsyncMsg(ALog.level2AlogCoreLevel(4), str, str2, access$500, currentTimeMillis);
                    }
                });
            }
        }

        /* renamed from: w */
        public void m57w(final String str, final String str2) {
            final long access$500 = ALog.access$500();
            final long currentTimeMillis = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(5, str)) {
                sLogInstanceExecutor.submit(new Runnable() { // from class: com.ss.android.agilelogger.ALog.LogInstance.5
                    @Override // java.lang.Runnable
                    public void run() {
                        LogInstance.this.mAlog.writeAsyncMsg(ALog.level2AlogCoreLevel(5), str, str2, access$500, currentTimeMillis);
                    }
                });
            }
        }

        /* renamed from: e */
        public void m54e(final String str, final String str2) {
            final long access$500 = ALog.access$500();
            final long currentTimeMillis = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(6, str)) {
                sLogInstanceExecutor.submit(new Runnable() { // from class: com.ss.android.agilelogger.ALog.LogInstance.6
                    @Override // java.lang.Runnable
                    public void run() {
                        LogInstance.this.mAlog.writeAsyncMsg(ALog.level2AlogCoreLevel(6), str, str2, access$500, currentTimeMillis);
                    }
                });
            }
        }

        public long getNativeRef() {
            return this.mAlog.getNativeRef();
        }

        public List<String> getFiles(long j, long j2) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] logs = this.mAlog.getLogs(j, j2);
                for (File file : logs) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        public List<String> getFilesOfAllProcesses(long j, long j2) {
            ArrayList arrayList = new ArrayList();
            try {
                File[] logs = this.mAlog.getLogs((String) null, j, j2);
                for (File file : logs) {
                    arrayList.add(file.getAbsolutePath());
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        public void asyncFlush() {
            this.mAlog.asyncFlush();
        }

        public void syncFlush() {
            this.mAlog.syncFlush();
        }

        public void timedSyncFlush(int i) {
            this.mAlog.timedSyncFlush(i);
        }
    }

    public static void removeObsoleteInstance(String str, Context context, boolean z) {
        String bufferDirPath;
        String str2;
        String processName = Util.getProcessName();
        if (processName == null || processName.contains(Constants.COLON_SEPARATOR)) {
            return;
        }
        if (!z) {
            processName = processName + '-';
        }
        ALogConfig aLogConfig = sConfig;
        if (aLogConfig != null) {
            str2 = aLogConfig.getLogDirPath();
            bufferDirPath = sConfig.getBufferDirPath();
        } else {
            String absolutePath = FileUtils.getDefaultLogDir(context).getAbsolutePath();
            bufferDirPath = FileUtils.getBufferDirPath(context);
            str2 = absolutePath;
        }
        File file = new File(str2);
        if (file.exists() && file.isDirectory()) {
            String str3 = "__" + str + ".alog.hot";
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name != null && name.endsWith(str3) && name.contains(processName)) {
                    file2.delete();
                }
            }
            File file3 = new File(bufferDirPath);
            if (file3.exists() && file3.isDirectory()) {
                String str4 = "__" + str;
                for (File file4 : file3.listFiles()) {
                    String name2 = file4.getName();
                    if (name2 != null && name2.contains(str4) && name2.contains(processName)) {
                        file4.delete();
                    }
                }
            }
        }
    }

    public static void addMessageInterceptor(IMessageInterceptor iMessageInterceptor) {
        Alog.addMessageInterceptor(iMessageInterceptor);
    }

    public static void removeMessageInterceptor(IMessageInterceptor iMessageInterceptor) {
        Alog.removeMessageInterceptor(iMessageInterceptor);
    }
}
