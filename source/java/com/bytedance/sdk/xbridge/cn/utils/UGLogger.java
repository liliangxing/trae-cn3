package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sync.SyncConstants;
import com.ss.android.agilelogger.ALog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: UGLogger.kt */
@Deprecated(message = "该类已经废弃，请使用HybridLogger进行日志打印")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004./01B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0002JH\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(JH\u0010)\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(J2\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001a\u0010+\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0002JH\u0010,\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(JH\u0010-\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00062"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger;", "", "()V", "DEFAULT_LOG_PREFIX", "", "TAG", "aLog", "Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$IALog;", "getALog", "()Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$IALog;", "setALog", "(Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$IALog;)V", "logHandler", "Landroid/os/Handler;", "getLogHandler", "()Landroid/os/Handler;", "logHandler$delegate", "Lkotlin/Lazy;", "tagPrefix", "getTagPrefix", "()Ljava/lang/String;", "setTagPrefix", "(Ljava/lang/String;)V", "useTagPrefix", "", "getUseTagPrefix", "()Z", "setUseTagPrefix", "(Z)V", "asyncExecute", "", "block", "Lkotlin/Function0;", "d", "tag", "msg", "module", "params", "", "ctx", "Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$Context;", "e", "formatMessage", "formatTag", "i", "w", "Context", "IALog", "Stage", "Status", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UGLogger {
    public static final String TAG = "UGLogger";
    private static boolean useTagPrefix;
    public static final UGLogger INSTANCE = new UGLogger();
    private static IALog aLog = new IALog() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$aLog$1
        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: d */
        public void mo164d(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ALog.d(tag, msg);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: i */
        public void mo167i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ALog.i(tag, msg);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: w */
        public void mo169w(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ALog.w(tag, msg);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: w */
        public void mo170w(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            ALog.w(tag, msg, tr);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: e */
        public void mo165e(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ALog.e(tag, msg);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: e */
        public void mo166e(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            ALog.e(tag, msg, tr);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        /* renamed from: v */
        public void mo168v(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            ALog.v(tag, msg);
        }

        @Override // com.bytedance.sdk.xbridge.cn.utils.UGLogger.IALog
        public long getALogSimpleWriteFuncAddr() {
            return ALog.getALogSimpleWriteFuncAddr();
        }
    };
    private static final String DEFAULT_LOG_PREFIX = "UGLog_";
    private static String tagPrefix = DEFAULT_LOG_PREFIX;

    /* renamed from: logHandler$delegate, reason: from kotlin metadata */
    private static final Lazy logHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$logHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m921invoke() {
            HandlerThread handlerThread = new HandlerThread(UGLogger.TAG, 10);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    /* compiled from: UGLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$IALog;", "", "d", "", "tag", "", "msg", "e", "tr", "", "getALogSimpleWriteFuncAddr", "", "i", "v", "w", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IALog {
        /* renamed from: d */
        void mo164d(String tag, String msg);

        /* renamed from: e */
        void mo165e(String tag, String msg);

        /* renamed from: e */
        void mo166e(String tag, String msg, Throwable tr);

        long getALogSimpleWriteFuncAddr();

        /* renamed from: i */
        void mo167i(String tag, String msg);

        /* renamed from: v */
        void mo168v(String tag, String msg);

        /* renamed from: w */
        void mo169w(String tag, String msg);

        /* renamed from: w */
        void mo170w(String tag, String msg, Throwable tr);
    }

    /* compiled from: UGLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$Status;", "", "(Ljava/lang/String;I)V", "Success", "Failed", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum Status {
        Success,
        Failed
    }

    private UGLogger() {
    }

    /* compiled from: UGLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$Stage;", "", "name", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Stage {
        private final String name;
        private final String sessionId;

        public static /* synthetic */ Stage copy$default(Stage stage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stage.name;
            }
            if ((i & 2) != 0) {
                str2 = stage.sessionId;
            }
            return stage.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public final Stage copy(String name, String sessionId) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new Stage(name, sessionId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stage)) {
                return false;
            }
            Stage stage = (Stage) other;
            return Intrinsics.areEqual(this.name, stage.name) && Intrinsics.areEqual(this.sessionId, stage.sessionId);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.sessionId.hashCode();
        }

        public String toString() {
            return "Stage(name=" + this.name + ", sessionId=" + this.sessionId + ')';
        }

        public Stage(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "sessionId");
            this.name = str;
            this.sessionId = str2;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSessionId() {
            return this.sessionId;
        }
    }

    /* compiled from: UGLogger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$Context;", "", "()V", "stages", "", "Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$Stage;", "getStages", "()Ljava/util/List;", "popStage", "", "pushStage", "name", "", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Context {
        private final List<Stage> stages = new ArrayList();

        public final List<Stage> getStages() {
            return this.stages;
        }

        public final void pushStage(String name, String sessionId) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.stages.add(new Stage(name, sessionId));
        }

        public final void popStage() {
            if (this.stages.isEmpty()) {
                return;
            }
            this.stages.remove(r0.size() - 1);
        }
    }

    public final IALog getALog() {
        return aLog;
    }

    public final void setALog(IALog iALog) {
        Intrinsics.checkNotNullParameter(iALog, "<set-?>");
        aLog = iALog;
    }

    public final boolean getUseTagPrefix() {
        return useTagPrefix;
    }

    public final void setUseTagPrefix(boolean z) {
        useTagPrefix = z;
    }

    public final String getTagPrefix() {
        return tagPrefix;
    }

    public final void setTagPrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        tagPrefix = str;
    }

    private final Handler getLogHandler() {
        return (Handler) logHandler.getValue();
    }

    private final void asyncExecute(final Function0<Unit> block) {
        getLogHandler().post(new Runnable(block) { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$sam$java_lang_Runnable$0
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

    /* renamed from: d */
    public final void m160d(final String tag, final String msg, final String module, final Map<String, ? extends Object> params, final Context ctx) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (XBridge.INSTANCE.isDropLog()) {
            return;
        }
        asyncExecute(new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$d$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m918invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m918invoke() {
                String formatTag;
                String formatMessage;
                formatTag = UGLogger.INSTANCE.formatTag(tag, module);
                formatMessage = UGLogger.INSTANCE.formatMessage(msg, params, ctx);
                UGLogger.INSTANCE.getALog().mo164d(formatTag, formatMessage);
            }
        });
    }

    /* renamed from: i */
    public final void m162i(final String tag, final String msg, final String module, final Map<String, ? extends Object> params, final Context ctx) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (XBridge.INSTANCE.isDropLog()) {
            return;
        }
        asyncExecute(new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$i$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m920invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m920invoke() {
                String formatTag;
                String formatMessage;
                formatTag = UGLogger.INSTANCE.formatTag(tag, module);
                formatMessage = UGLogger.INSTANCE.formatMessage(msg, params, ctx);
                UGLogger.INSTANCE.getALog().mo167i(formatTag, formatMessage);
            }
        });
    }

    /* renamed from: w */
    public final void m163w(final String tag, final String msg, final String module, final Map<String, ? extends Object> params, final Context ctx) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (XBridge.INSTANCE.isDropLog()) {
            return;
        }
        asyncExecute(new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$w$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m922invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m922invoke() {
                String formatTag;
                String formatMessage;
                formatTag = UGLogger.INSTANCE.formatTag(tag, module);
                formatMessage = UGLogger.INSTANCE.formatMessage(msg, params, ctx);
                UGLogger.INSTANCE.getALog().mo169w(formatTag, formatMessage);
            }
        });
    }

    /* renamed from: e */
    public final void m161e(final String tag, final String msg, final String module, final Map<String, ? extends Object> params, final Context ctx) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        asyncExecute(new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.utils.UGLogger$e$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m919invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m919invoke() {
                String formatTag;
                String formatMessage;
                formatTag = UGLogger.INSTANCE.formatTag(tag, module);
                formatMessage = UGLogger.INSTANCE.formatMessage(msg, params, ctx);
                UGLogger.INSTANCE.getALog().mo165e(formatTag, formatMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTag(String tag, String module) {
        if (!useTagPrefix && module == null) {
            return tag;
        }
        StringBuilder sb = new StringBuilder();
        if (useTagPrefix) {
            sb.append(tagPrefix);
        }
        sb.append(tag);
        String str = module;
        if (!(str == null || StringsKt.isBlank(str))) {
            sb.append(SyncConstants.SEPARATOR).append(module);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatMessage(String msg, Map<String, ? extends Object> params, Context ctx) {
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
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("stages", jSONObject);
            stringBuffer.append("|xContext:").append(jSONObject2.toString());
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "builder.toString()");
        return stringBuffer2;
    }
}
