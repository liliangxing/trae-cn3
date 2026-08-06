package com.bytedance.ies.bullet.service.base;

import android.os.Handler;
import android.os.HandlerThread;
import bolts.Task;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BulletLogger.kt */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0002J\u001c\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0010\u0010-\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0004H\u0002J\u0018\u0010/\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u000201J\u0016\u00102\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J,\u00106\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u000201J4\u00109\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\u0006\u0010:\u001a\u0002042\b\b\u0002\u00108\u001a\u000201J\"\u0010;\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u0004J \u0010<\u001a\u00020$2\u0006\u00103\u001a\u0002042\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u0004JZ\u0010=\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010?2\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020\u0004JZ\u0010A\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010?2\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020\u0004J\"\u0010B\u001a\u00020$2\u0006\u0010+\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u0014J\u000e\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\u0014J\u0010\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006I"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/BulletLogger;", "", "()V", "MODULE_ANNIE_CARD", "", "MODULE_DEBUG", "MODULE_INIT", "MODULE_LYNX", "MODULE_PAGE", "MODULE_POPUP", "MODULE_PR", "MODULE_PREFETCH", "MODULE_PRELOAD", "MODULE_RL", "MODULE_ROUTER", "MODULE_SCHEME", "MODULE_VIEW", "MODULE_WEB", "TAG", "bulletLoggerExperiment", "", "getBulletLoggerExperiment", "()Z", "setBulletLoggerExperiment", "(Z)V", "dropLog", "isDebug", "logExecutors", "Ljava/util/concurrent/ExecutorService;", "logHandler", "Landroid/os/Handler;", "getLogHandler", "()Landroid/os/Handler;", "logHandler$delegate", "Lkotlin/Lazy;", "asyncExecute", "", "block", "Lkotlin/Function0;", "getLogHeader", "sessionId", "rlSessionId", "innerLogD", "msg", "innerLogE", "innerLogI", "innerLogW", "onLog", "level", "Lcom/bytedance/ies/bullet/service/base/api/LogLevel;", "onReject", "e", "", "extraMsg", "printCoreLog", "subModule", "logLevel", "printCoreReject", "tr", "printLog", "printReject", "printTridentCoreLog", "content", "", XConstant.CALL_ID, "printTridentLog", "printXDBLog", "setDebug", MemoryApi.DEBUG, "setDrop", "drop", "setSkipNoCoreALog", "skip", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletLogger {
    public static final BulletLogger INSTANCE = new BulletLogger();
    public static final String MODULE_ANNIE_CARD = "XAnnieCard";
    public static final String MODULE_DEBUG = "XDebug";
    public static final String MODULE_INIT = "XInit";
    public static final String MODULE_LYNX = "XLynxKit";
    public static final String MODULE_PAGE = "XPage";
    public static final String MODULE_POPUP = "XPopup";
    public static final String MODULE_PR = "XPreRender";
    public static final String MODULE_PREFETCH = "XPrefetch";
    public static final String MODULE_PRELOAD = "XPreload";
    public static final String MODULE_RL = "XResourceLoader";
    public static final String MODULE_ROUTER = "XRouter";
    public static final String MODULE_SCHEME = "XSchema";
    public static final String MODULE_VIEW = "XView";
    public static final String MODULE_WEB = "XWebKit";
    public static final String TAG = "BulletLog";
    private static boolean bulletLoggerExperiment;
    private static boolean dropLog;
    private static boolean isDebug;
    private static ExecutorService logExecutors;

    /* renamed from: logHandler$delegate, reason: from kotlin metadata */
    private static final Lazy logHandler;

    /* compiled from: BulletLogger.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.E.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Deprecated(message = "影响问题排查效率，功能下线")
    public final void setSkipNoCoreALog(boolean skip) {
    }

    private BulletLogger() {
    }

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        logExecutors = newSingleThreadExecutor;
        bulletLoggerExperiment = true;
        logHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.bullet.service.base.BulletLogger$logHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m554invoke() {
                HandlerThread handlerThread = new HandlerThread(BulletLogger.TAG, 10);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            }
        });
    }

    public final boolean getBulletLoggerExperiment() {
        return bulletLoggerExperiment;
    }

    public final void setBulletLoggerExperiment(boolean z) {
        bulletLoggerExperiment = z;
    }

    private final Handler getLogHandler() {
        return (Handler) logHandler.getValue();
    }

    public final void setDebug(boolean r1) {
        isDebug = r1;
    }

    public final void setDrop(boolean drop) {
        innerLogI("BulletLogger setDrop " + drop);
        dropLog = drop;
    }

    public final void onReject(final Throwable e, final String extraMsg) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(extraMsg, "extraMsg");
        try {
            Result.Companion companion = Result.Companion;
            INSTANCE.asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.base.BulletLogger$onReject$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m556invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m556invoke() {
                    BulletLogger.INSTANCE.innerLogE("onReject: " + e.getMessage() + ", extra: " + extraMsg);
                }
            });
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void onLog$default(BulletLogger bulletLogger, String str, LogLevel logLevel, int i, Object obj) {
        if ((i & 2) != 0) {
            logLevel = LogLevel.I;
        }
        bulletLogger.onLog(str, logLevel);
    }

    public final void onLog(final String msg, final LogLevel level) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(level, "level");
        if (!dropLog || isDebug || level == LogLevel.E || level == LogLevel.W) {
            asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.service.base.BulletLogger$onLog$1

                /* compiled from: BulletLogger.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[LogLevel.values().length];
                        try {
                            iArr[LogLevel.D.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[LogLevel.E.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[LogLevel.W.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m555invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m555invoke() {
                    int i = WhenMappings.$EnumSwitchMapping$0[LogLevel.this.ordinal()];
                    if (i == 1) {
                        BulletLogger.INSTANCE.innerLogD(msg);
                        return;
                    }
                    if (i == 2) {
                        BulletLogger.INSTANCE.innerLogE(msg);
                    } else if (i != 3) {
                        BulletLogger.INSTANCE.innerLogI(msg);
                    } else {
                        BulletLogger.INSTANCE.innerLogW(msg);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void printLog$default(BulletLogger bulletLogger, String str, LogLevel logLevel, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            logLevel = LogLevel.I;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        bulletLogger.printLog(str, logLevel, str2);
    }

    public final void printLog(String msg, LogLevel logLevel, String subModule) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        try {
            Result.Companion companion = Result.Companion;
            if (subModule.length() > 0) {
                msg = "[" + subModule + "] " + msg;
            }
            INSTANCE.onLog(msg, logLevel);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void printXDBLog$default(BulletLogger bulletLogger, String str, LogLevel logLevel, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            logLevel = LogLevel.I;
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        bulletLogger.printXDBLog(str, logLevel, str2);
    }

    public final void printXDBLog(String msg, LogLevel logLevel, String subModule) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        printLog(msg, logLevel, subModule);
    }

    public final void printTridentLog(String msg, Map<String, ? extends Object> content, LogLevel logLevel, String subModule, String sessionId, String rlSessionId, String r13) {
        String str;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        Intrinsics.checkNotNullParameter(rlSessionId, "rlSessionId");
        Intrinsics.checkNotNullParameter(r13, XConstant.CALL_ID);
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = content == null ? null : new JSONObject(content);
            boolean z = true;
            if ((r13.length() > 0) && jSONObject != null) {
                jSONObject.put(XConstant.CALL_ID, r13);
            }
            String str2 = "xMsg:" + msg + '|' + (jSONObject == null ? "" : "xContent:" + jSONObject);
            BulletLogger bulletLogger = INSTANCE;
            String logHeader = bulletLogger.getLogHeader(sessionId, rlSessionId);
            if (subModule.length() <= 0) {
                z = false;
            }
            if (z) {
                str = logHeader + '[' + subModule + "] " + str2;
            } else {
                str = logHeader + str2;
            }
            bulletLogger.onLog(str, logLevel);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void printTridentCoreLog(String msg, Map<String, ? extends Object> content, LogLevel logLevel, String subModule, String sessionId, String rlSessionId, String r13) {
        String str;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(rlSessionId, "rlSessionId");
        Intrinsics.checkNotNullParameter(r13, XConstant.CALL_ID);
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jSONObject = content == null ? null : new JSONObject(content);
            boolean z = true;
            if ((r13.length() > 0) && jSONObject != null) {
                jSONObject.put(XConstant.CALL_ID, r13);
            }
            String str2 = "xMsg:" + msg + '|' + (jSONObject == null ? "" : "xContent:" + jSONObject);
            BulletLogger bulletLogger = INSTANCE;
            String logHeader = bulletLogger.getLogHeader(sessionId, rlSessionId);
            if (subModule.length() <= 0) {
                z = false;
            }
            if (z) {
                str = logHeader + "-[Core][" + subModule + "] " + str2;
            } else {
                str = logHeader + "-[Core]" + str2;
            }
            bulletLogger.onLog(str, logLevel);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final String getLogHeader(String sessionId, String rlSessionId) {
        StringBuilder sb = new StringBuilder();
        String str = sessionId;
        if (str == null || str.length() == 0) {
            sb.append("[bulletSession-unknown]");
        } else {
            sb.append("[bulletSession-" + sessionId + ']');
        }
        String str2 = rlSessionId;
        if (!(str2 == null || str2.length() == 0)) {
            sb.append("[resourceSession-" + rlSessionId + ']');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    public static /* synthetic */ void printReject$default(BulletLogger bulletLogger, Throwable th, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        bulletLogger.printReject(th, str, str2);
    }

    public final void printReject(Throwable e, String msg, String subModule) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        try {
            Result.Companion companion = Result.Companion;
            if (subModule.length() > 0) {
                msg = "[" + subModule + "] " + msg;
            }
            INSTANCE.onReject(e, msg);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void printCoreLog$default(BulletLogger bulletLogger, String str, String str2, String str3, LogLevel logLevel, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            logLevel = LogLevel.I;
        }
        bulletLogger.printCoreLog(str, str2, str3, logLevel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
    
        r7 = "[bulletSession-unknown]-[Core] " + r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void printCoreLog(String sessionId, String msg, String subModule, LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        try {
            Result.Companion companion = Result.Companion;
            boolean z = true;
            if (subModule.length() > 0) {
                msg = "[" + subModule + "] " + msg;
            }
            String str = sessionId;
            if (str != null && str.length() != 0) {
                z = false;
            }
            String str2 = "[bulletSession-" + sessionId + "]-[Core] " + msg;
            INSTANCE.onLog(str2, logLevel);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static /* synthetic */ void printCoreReject$default(BulletLogger bulletLogger, String str, String str2, String str3, Throwable th, LogLevel logLevel, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        String str4 = str3;
        if ((i & 16) != 0) {
            logLevel = LogLevel.W;
        }
        bulletLogger.printCoreReject(str, str2, str4, th, logLevel);
    }

    public final void printCoreReject(String sessionId, String msg, String subModule, Throwable tr, LogLevel logLevel) {
        String str;
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(subModule, "subModule");
        Intrinsics.checkNotNullParameter(tr, "tr");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        try {
            Result.Companion companion = Result.Companion;
            if (subModule.length() > 0) {
                msg = "[" + subModule + "] " + msg;
            }
            String str2 = sessionId;
            if (str2 == null || str2.length() == 0) {
                str = "[bulletSession-unknown]-[Core] " + msg;
            } else {
                str = "[bulletSession-" + sessionId + "]-[Core] " + msg;
            }
            if (WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()] == 1) {
                UGLogger.INSTANCE.getALog().e(TAG, str, tr);
            } else {
                UGLogger.INSTANCE.getALog().w(TAG, str, tr);
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    private final void asyncExecute(final Function0<Unit> block) {
        if (bulletLoggerExperiment) {
            getLogHandler().post(new Runnable(block) { // from class: com.bytedance.ies.bullet.service.base.BulletLogger$sam$java_lang_Runnable$0
                private final /* synthetic */ Function0 function;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Intrinsics.checkNotNullParameter(block, "function");
                    this.function = block;
                }

                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.function.invoke();
                }
            });
        } else {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.base.BulletLogger$asyncExecute$1
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    block.invoke();
                }
            }, logExecutors);
        }
    }

    public final void innerLogD(String msg) {
        UGLogger.INSTANCE.getALog().d(TAG, msg);
    }

    public final void innerLogE(String msg) {
        UGLogger.INSTANCE.getALog().e(TAG, msg);
    }

    public final void innerLogW(String msg) {
        UGLogger.INSTANCE.getALog().w(TAG, msg);
    }

    public final void innerLogI(String msg) {
        UGLogger.INSTANCE.getALog().i(TAG, msg);
    }
}
