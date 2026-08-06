package com.bytedance.trae.apm.impl;

import android.os.Build;
import com.bytedance.apm.ApmAgent;
import com.bytedance.crash.Npth;
import com.bytedance.platform.godzilla.Godzilla;
import com.bytedance.platform.godzilla.anr.SpBlockPlugin;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.bytedance.platform.godzilla.common.DoubleReflectHelper;
import com.bytedance.platform.godzilla.common.ILog;
import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.uncaughtexecption.SuperUncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.plugin.StartType;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.trae.apm.api.IGodzilla;
import com.bytedance.trae.apm.impl.plugin.HoraeArrayMapException;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.ThreadUtils;
import com.bytedance.trae.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GodzillaImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/apm/impl/GodzillaImpl;", "Lcom/bytedance/trae/apm/api/IGodzilla;", "<init>", "()V", "startGzlRunnable", "Ljava/lang/Runnable;", "enableGodzillaInTestChannel", "", "init", "", "enable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GodzillaImpl implements IGodzilla {
    private static final int DEFAULT_MEMORY = -1;
    private static final String TAG = "GodzillaExt";
    private boolean enableGodzillaInTestChannel;
    private Runnable startGzlRunnable;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long sMaxMemory = -1;

    /* compiled from: GodzillaImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Logger.Level.values().length];
            try {
                iArr[Logger.Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Logger.Level.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Logger.Level.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Logger.Level.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: GodzillaImpl.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/apm/impl/GodzillaImpl$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_MEMORY", "", "sMaxMemory", "", "getAppMaxMemory", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getAppMaxMemory() {
            long j;
            if (GodzillaImpl.sMaxMemory != -1) {
                return GodzillaImpl.sMaxMemory;
            }
            synchronized (this) {
                if (GodzillaImpl.sMaxMemory == -1) {
                    Companion companion = GodzillaImpl.INSTANCE;
                    GodzillaImpl.sMaxMemory = Runtime.getRuntime().maxMemory();
                }
                j = GodzillaImpl.sMaxMemory;
            }
            return j;
        }
    }

    @Override // com.bytedance.trae.apm.api.IGodzilla
    public void init() {
        Godzilla.Builder builder = new Godzilla.Builder(AppHost.INSTANCE.getApplication());
        builder.setLog(new ILog() { // from class: com.bytedance.trae.apm.impl.GodzillaImpl$$ExternalSyntheticLambda0
            public final void println(String str, String str2, Logger.Level level) {
                GodzillaImpl.init$lambda$0(str, str2, level);
            }
        });
        builder.setReflectHackHelper(new IReflectHackHelper() { // from class: com.bytedance.trae.apm.impl.GodzillaImpl$init$2
            public Field getField(Class<?> clazz, String fieldName) {
                Intrinsics.checkNotNullParameter(fieldName, "fieldName");
                Field field = DoubleReflectHelper.getField(clazz, fieldName);
                Intrinsics.checkNotNullExpressionValue(field, "getField(...)");
                return field;
            }

            public Method getMethod(Class<?> clazz, String methodName, Class<?>... params) {
                Intrinsics.checkNotNullParameter(methodName, "methodName");
                Intrinsics.checkNotNullParameter(params, "params");
                Method method = DoubleReflectHelper.getMethod(clazz, methodName, (Class[]) Arrays.copyOf(params, params.length));
                Intrinsics.checkNotNullExpressionValue(method, "getMethod(...)");
                return method;
            }
        });
        builder.plugin(new BinderTranTooLargeExp(true, true, new ArrayList()));
        if (Build.VERSION.SDK_INT < 26) {
            builder.plugin(new SpBlockPlugin());
        }
        builder.plugin(new HoraeArrayMapException());
        builder.plugin(new SuperUncaughtExceptionPlugin(new SuperUncaughtExceptionPlugin.ConfigFetcher() { // from class: com.bytedance.trae.apm.impl.GodzillaImpl$init$3
            public List<CrashPortrait> getCrashPortrait() {
                return new ArrayList();
            }

            public String getAppVersion() {
                return AppHost.INSTANCE.getVersionName();
            }

            public int getUpdateVersion() {
                return AppHost.INSTANCE.getUpdateVersionCode();
            }

            public void onCrashCatchSucceed(CrashPortrait crashPortrait) {
                Intrinsics.checkNotNullParameter(crashPortrait, "crashPortrait");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("process_name", crashPortrait.processName);
                jSONObject.put("thread_name", crashPortrait.threadName);
                jSONObject.put("clazz_name", crashPortrait.clazzName);
                jSONObject.put("method_name", crashPortrait.methodName);
                jSONObject.put("throwable_class_name", crashPortrait.throwableClassName);
                jSONObject.put("message", crashPortrait.detailMessage);
                jSONObject.put(Constant.KEY_APP_VERSION, crashPortrait.appVersion);
                jSONObject.put("update_version", crashPortrait.updateVersion);
                jSONObject.put(Constant.KEY_OS_VERSION, crashPortrait.osVersion);
                ApmAgent.monitorEvent("crash_portrait", jSONObject, (JSONObject) null, (JSONObject) null);
                FLogger.INSTANCE.e("GodzillaExt", "onCrashCatchSucceed", new Throwable(crashPortrait.toString()));
            }
        }, AppHost.INSTANCE.getApplication()));
        Godzilla.init(builder.build()).start();
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.apm.impl.GodzillaImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GodzillaImpl.init$lambda$1(GodzillaImpl.this);
            }
        };
        this.startGzlRunnable = runnable;
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(String str, String str2, Logger.Level level) {
        int i = level == null ? -1 : WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            FLogger fLogger = FLogger.INSTANCE;
            Intrinsics.checkNotNull(str);
            fLogger.d(str, str2);
            return;
        }
        if (i == 2) {
            FLogger fLogger2 = FLogger.INSTANCE;
            Intrinsics.checkNotNull(str);
            fLogger2.i(str, str2);
        } else if (i == 3) {
            FLogger fLogger3 = FLogger.INSTANCE;
            Intrinsics.checkNotNull(str);
            fLogger3.w(str, str2);
        } else if (i == 4) {
            FLogger fLogger4 = FLogger.INSTANCE;
            Intrinsics.checkNotNull(str);
            fLogger4.e(str, str2);
        } else {
            FLogger fLogger5 = FLogger.INSTANCE;
            Intrinsics.checkNotNull(str);
            fLogger5.d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(GodzillaImpl godzillaImpl) {
        if (Npth.isInit()) {
            Godzilla.with().start(StartType.REGISTER_EXCEPTION);
            return;
        }
        Runnable runnable = godzillaImpl.startGzlRunnable;
        if (runnable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startGzlRunnable");
            runnable = null;
        }
        ThreadUtils.postInForeground(runnable, 500L);
    }

    @Override // com.bytedance.trae.apm.api.IGodzilla
    public void enableGodzillaInTestChannel(boolean enable) {
        this.enableGodzillaInTestChannel = enable;
    }
}
