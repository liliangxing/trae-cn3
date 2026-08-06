package com.bytedance.ies.argus.api;

import android.app.Application;
import android.os.Build;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.base.ArgusInitializer;
import com.bytedance.ies.argus.plugin.SecLinkPluginHandler;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.SecuritySettingConfigModel;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ArgusSecureManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0014\u001a\u00020\rH\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/api/ArgusSecureManager;", "", "()V", "TAG", "", "_initializer", "Lcom/bytedance/ies/argus/base/ArgusInitializer;", "asyncUpdateJSONConfig", "", "data", "ensureSetupFinished", "executeInitTask", "hasInit", "", "init", "config", "Lcom/bytedance/ies/argus/api/interfaces/ArgusInitConfig;", "isSecLinkUrl", "url", "onFeConfigUpdated", "shouldInit", "triggerUpdateConfig", "updateSecuritySettingConfig", "Lcom/bytedance/ies/argus/repository/SecuritySettingConfigModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusSecureManager {
    public static final ArgusSecureManager INSTANCE = new ArgusSecureManager();
    public static final String TAG = "ArgusSecureManager";
    private static volatile ArgusInitializer _initializer;

    private ArgusSecureManager() {
    }

    public final boolean hasInit() {
        return _initializer != null;
    }

    public final void init(ArgusInitConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!shouldInit() || hasInit()) {
            return;
        }
        synchronized (ArgusSecureManager.class) {
            if (!INSTANCE.hasInit()) {
                ArgusInitializer argusInitializer = new ArgusInitializer(config);
                _initializer = argusInitializer;
                argusInitializer.init$anniex_release();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void executeInitTask() {
        ArgusInitializer argusInitializer = _initializer;
        if (argusInitializer != null) {
            argusInitializer.initAsyncSetupTask();
        }
    }

    public final void ensureSetupFinished() {
        ArgusInitializer argusInitializer = _initializer;
        if (argusInitializer != null) {
            argusInitializer.ensureExecuteSetupTask();
        }
    }

    public final void asyncUpdateJSONConfig(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArgusConfigManager.INSTANCE.getInstance().updateFromSettings(data);
    }

    public final void updateSecuritySettingConfig(SecuritySettingConfigModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArgusConfigManager.INSTANCE.getInstance().updateSecuritySettingConfig(data);
    }

    public final void onFeConfigUpdated() {
        ArgusConfigManager.INSTANCE.getInstance().onFeConfigUpdated();
    }

    public final boolean isSecLinkUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return SecLinkPluginHandler.INSTANCE.isSecLinkPage(url);
    }

    public final void triggerUpdateConfig() {
        ArgusConfigManager companion = ArgusConfigManager.INSTANCE.getInstance();
        companion.triggerGetLatestConfig();
        companion.triggerGetOfflineConfig();
    }

    private final boolean shouldInit() {
        try {
            Result.Companion companion = Result.Companion;
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                Intrinsics.checkNotNullExpressionValue(processName, "processName");
                if (StringsKt.contains$default(processName, ":", false, 2, (Object) null)) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, TAG, "force close argus in process=" + processName, (Map) null, (LoggerContext) null, 12, (Object) null);
                    return false;
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
            return true;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return true;
        }
    }
}
