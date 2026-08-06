package com.bytedance.ies.bullet.base.utils.logger;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import com.bytedance.notification.Constants;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: HybridLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J<\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJD\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ<\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJD\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ2\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0002J<\u0010\"\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJD\u0010\"\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ,\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019J<\u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJD\u0010%\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/logger/HybridLogger;", "", "()V", "TAG", "", "level", "", "getLevel", "()I", "setLevel", "(I)V", "logHandler", "Landroid/os/Handler;", "getLogHandler", "()Landroid/os/Handler;", "logHandler$delegate", "Lkotlin/Lazy;", "asyncExecute", "", "block", "Lkotlin/Function0;", "d", "moduleTag", "msg", "params", "", "ctx", "Lcom/bytedance/ies/bullet/base/utils/logger/LoggerContext;", "formatTag", "", "e", "formatMessage", Constants.NOTIFICATION_TAG, "module", "i", IFrontierMonitor.KEY_LOG, "logLevel", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HybridLogger {
    public static final HybridLogger INSTANCE = new HybridLogger();
    public static final String TAG = "HybridLogger";
    private static int level;

    /* renamed from: logHandler$delegate, reason: from kotlin metadata */
    private static final Lazy logHandler;

    private HybridLogger() {
    }

    static {
        CommonConfig commonConfig;
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        level = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? 4 : commonConfig.getHybridLoggerLevel();
        logHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$logHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m494invoke() {
                HandlerThread handlerThread = new HandlerThread(HybridLogger.TAG, 10);
                handlerThread.start();
                return new Handler(handlerThread.getLooper());
            }
        });
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(int i) {
        level = i;
    }

    private final Handler getLogHandler() {
        return (Handler) logHandler.getValue();
    }

    private final void asyncExecute(Function0<Unit> block) {
        getLogHandler().post(new Runnable(block) { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$sam$java_lang_Runnable$0
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
    }

    public final void log(int i, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, Constants.NOTIFICATION_TAG);
        Object obj = map != null ? map.get("name") : null;
        String str2 = obj instanceof String ? (String) obj : null;
        String str3 = str2 == null ? "" : str2;
        LoggerContext loggerContext = new LoggerContext();
        Object obj2 = map != null ? map.get(XConstant.SESSION_ID) : null;
        String str4 = obj2 instanceof String ? (String) obj2 : null;
        loggerContext.pushStage(XConstant.SESSION_ID, str4 != null ? str4 : "");
        if (i == 3) {
            m8d(str, str3, map, loggerContext, false);
            return;
        }
        if (i == 4) {
            m12i(str, str3, map, loggerContext, false);
        } else if (i == 5) {
            m14w(str, str3, map, loggerContext, false);
        } else {
            if (i != 6) {
                return;
            }
            m10e(str, str3, map, loggerContext, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d$default(HybridLogger hybridLogger, String str, String str2, Map map, LoggerContext loggerContext, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            loggerContext = null;
        }
        hybridLogger.m7d(str, str2, map, loggerContext);
    }

    /* renamed from: d */
    public final void m7d(String moduleTag, String msg, Map<String, ? extends Object> params, LoggerContext ctx) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        m8d(moduleTag, msg, params, ctx, true);
    }

    /* renamed from: d */
    public final void m8d(final String moduleTag, final String msg, final Map<String, ? extends Object> params, final LoggerContext ctx, final boolean formatTag) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 3 || BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$d$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m491invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m491invoke() {
                    String formatMessage;
                    String formatTag2 = formatTag ? HybridLogger.INSTANCE.formatTag(HybridLogger.TAG, moduleTag) : moduleTag;
                    formatMessage = HybridLogger.INSTANCE.formatMessage(msg, params, ctx);
                    UGLogger.INSTANCE.getALog().d(formatTag2, formatMessage);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i$default(HybridLogger hybridLogger, String str, String str2, Map map, LoggerContext loggerContext, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            loggerContext = null;
        }
        hybridLogger.m11i(str, str2, map, loggerContext);
    }

    /* renamed from: i */
    public final void m11i(String moduleTag, String msg, Map<String, ? extends Object> params, LoggerContext ctx) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        m12i(moduleTag, msg, params, ctx, true);
    }

    /* renamed from: i */
    public final void m12i(final String moduleTag, final String msg, final Map<String, ? extends Object> params, final LoggerContext ctx, final boolean formatTag) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 4 || BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$i$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m493invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m493invoke() {
                    String formatMessage;
                    String formatTag2 = formatTag ? HybridLogger.INSTANCE.formatTag(HybridLogger.TAG, moduleTag) : moduleTag;
                    formatMessage = HybridLogger.INSTANCE.formatMessage(msg, params, ctx);
                    UGLogger.INSTANCE.getALog().i(formatTag2, formatMessage);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w$default(HybridLogger hybridLogger, String str, String str2, Map map, LoggerContext loggerContext, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            loggerContext = null;
        }
        hybridLogger.m13w(str, str2, map, loggerContext);
    }

    /* renamed from: w */
    public final void m13w(String moduleTag, String msg, Map<String, ? extends Object> params, LoggerContext ctx) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        m14w(moduleTag, msg, params, ctx, true);
    }

    /* renamed from: w */
    public final void m14w(final String moduleTag, final String msg, final Map<String, ? extends Object> params, final LoggerContext ctx, final boolean formatTag) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 5 || BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$w$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m495invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m495invoke() {
                    String formatMessage;
                    String formatTag2 = formatTag ? HybridLogger.INSTANCE.formatTag(HybridLogger.TAG, moduleTag) : moduleTag;
                    formatMessage = HybridLogger.INSTANCE.formatMessage(msg, params, ctx);
                    UGLogger.INSTANCE.getALog().w(formatTag2, formatMessage);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(HybridLogger hybridLogger, String str, String str2, Map map, LoggerContext loggerContext, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            loggerContext = null;
        }
        hybridLogger.m9e(str, str2, map, loggerContext);
    }

    /* renamed from: e */
    public final void m9e(String moduleTag, String msg, Map<String, ? extends Object> params, LoggerContext ctx) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        m10e(moduleTag, msg, params, ctx, true);
    }

    /* renamed from: e */
    public final void m10e(final String moduleTag, final String msg, final Map<String, ? extends Object> params, final LoggerContext ctx, final boolean formatTag) {
        Intrinsics.checkNotNullParameter(moduleTag, "moduleTag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 6 || BulletEnv.INSTANCE.getInstance().getDebuggable()) {
            asyncExecute(new Function0<Unit>() { // from class: com.bytedance.ies.bullet.base.utils.logger.HybridLogger$e$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m492invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m492invoke() {
                    String formatMessage;
                    String formatTag2 = formatTag ? HybridLogger.INSTANCE.formatTag(HybridLogger.TAG, moduleTag) : moduleTag;
                    formatMessage = HybridLogger.INSTANCE.formatMessage(msg, params, ctx);
                    UGLogger.INSTANCE.getALog().e(formatTag2, formatMessage);
                }
            });
        }
    }

    public final String formatTag(String r2, String module) {
        StringBuilder sb = new StringBuilder(r2);
        String str = module;
        if (!(str == null || StringsKt.isBlank(str))) {
            sb.append(RomVersionParamHelper.SEPARATOR).append(module);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    public final String formatMessage(String msg, Map<String, ? extends Object> params, LoggerContext ctx) {
        List<Stage> stages;
        if ((params == null || params.isEmpty()) && ctx == null) {
            return msg;
        }
        StringBuffer stringBuffer = new StringBuffer(msg);
        if (!(params == null || params.isEmpty())) {
            stringBuffer.append("|xParam:").append(new JSONObject(params).toString());
        }
        List<Stage> stages2 = ctx != null ? ctx.getStages() : null;
        if (!(stages2 == null || stages2.isEmpty())) {
            JSONObject jSONObject = new JSONObject();
            if (ctx != null && (stages = ctx.getStages()) != null) {
                for (Stage stage : stages) {
                    jSONObject.put(stage.getName(), stage.getSessionId());
                }
            }
            stringBuffer.append("|xContext:").append(jSONObject.toString());
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "builder.toString()");
        return stringBuffer2;
    }
}
