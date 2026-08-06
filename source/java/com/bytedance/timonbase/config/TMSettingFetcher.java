package com.bytedance.timonbase.config;

import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.cache.TMCacheService;
import com.bytedance.timonbase.network.Response;
import com.bytedance.timonbase.network.Settings;
import com.bytedance.timonbase.network.TMNetworkService;
import com.bytedance.timonbase.report.TMMetric;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMSettingFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00142\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004:\u0001\u0014B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/config/TMSettingFetcher;", "Lkotlin/Function1;", "", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timonbase/scene/SettingFetcher;", "settingObserver", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "settings", "Lcom/bytedance/timonbase/network/Settings;", "fetchConfig", "", "retryCount", "", "invoke", "key", "forceUpdate", "Companion", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMSettingFetcher implements Function1<String, JsonObject> {
    private static final long FETCH_INTERVAL_MS = 5000;
    private static final int FETCH_RETRY_MAX = 3;
    private static final String TAG = "TMSettingFetcher";
    private final AtomicBoolean isRunning;
    private final Function0<Unit> settingObserver;
    private Settings settings;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function0<Unit> delayInitTask = new Function0<Unit>() { // from class: com.bytedance.timonbase.config.TMSettingFetcher$Companion$delayInitTask$1
        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1050invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1050invoke();
            return Unit.INSTANCE;
        }
    };

    public TMSettingFetcher(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "settingObserver");
        this.settingObserver = function0;
        this.isRunning = new AtomicBoolean(false);
    }

    /* compiled from: TMSettingFetcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/timonbase/config/TMSettingFetcher$Companion;", "", "()V", "FETCH_INTERVAL_MS", "", "FETCH_RETRY_MAX", "", "TAG", "", "delayInitTask", "Lkotlin/Function0;", "", "getDelayInitTask", "()Lkotlin/jvm/functions/Function0;", "setDelayInitTask", "(Lkotlin/jvm/functions/Function0;)V", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Function0<Unit> getDelayInitTask() {
            return TMSettingFetcher.delayInitTask;
        }

        public final void setDelayInitTask(Function0<Unit> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "<set-?>");
            TMSettingFetcher.delayInitTask = function0;
        }
    }

    public JsonObject invoke(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return invoke(key, false);
    }

    public final JsonObject invoke(String key, boolean forceUpdate) {
        JsonObject jsonObject;
        Intrinsics.checkParameterIsNotNull(key, "key");
        JsonObject jsonObject2 = null;
        try {
            Settings settings = this.settings;
            if (settings == null) {
                settings = TMCacheService.INSTANCE.getConfig();
                if (settings != null) {
                    this.settings = settings;
                } else {
                    settings = null;
                }
            }
            if (settings != null) {
                switch (key.hashCode()) {
                    case -2145585032:
                        if (key.equals(TimonConstantKt.RULER_RULE_KEY)) {
                            jsonObject = (JsonObject) TMInjection.INSTANCE.getGson().fromJson(settings.getConfig().getRulerEngineConfig(), JsonObject.class);
                            jsonObject2 = jsonObject;
                            break;
                        }
                        break;
                    case -942791662:
                        if (key.equals(TimonConstantKt.TIMON_ENCRYPTION_LIST)) {
                            jsonObject = (JsonObject) TMInjection.INSTANCE.getGson().fromJson(settings.getConfig().getTimonEncryptionList(), JsonObject.class);
                            jsonObject2 = jsonObject;
                            break;
                        }
                        break;
                    case -827436022:
                        if (key.equals("timon_config")) {
                            jsonObject = (JsonObject) TMInjection.INSTANCE.getGson().fromJson(settings.getConfig().getTimonConfig(), JsonObject.class);
                            jsonObject2 = jsonObject;
                            break;
                        }
                        break;
                    case 1459131507:
                        if (key.equals(TimonConstantKt.SENSITIVE_PATH_CONFIG_KEY)) {
                            jsonObject = (JsonObject) TMInjection.INSTANCE.getGson().fromJson(settings.getConfig().getSensitivePathConfig(), JsonObject.class);
                            jsonObject2 = jsonObject;
                            break;
                        }
                        break;
                }
            }
        } catch (Exception e) {
            TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(e, "Load localConfig FAILED", MapsKt.emptyMap());
        }
        if (!this.isRunning.get() && forceUpdate) {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.bytedance.timonbase.config.TMSettingFetcher$invoke$task$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1052invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1052invoke() {
                    Function0 function02;
                    AtomicBoolean atomicBoolean;
                    if (TMSettingFetcher.fetchConfig$default(TMSettingFetcher.this, 0, 1, null)) {
                        function02 = TMSettingFetcher.this.settingObserver;
                        function02.invoke();
                        atomicBoolean = TMSettingFetcher.this.isRunning;
                        atomicBoolean.set(false);
                        return;
                    }
                    TMThreadUtils.INSTANCE.postDelay(5000L, new Function0<Unit>() { // from class: com.bytedance.timonbase.config.TMSettingFetcher$invoke$task$1.1
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1053invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1053invoke() {
                            AtomicBoolean atomicBoolean2;
                            atomicBoolean2 = TMSettingFetcher.this.isRunning;
                            atomicBoolean2.set(false);
                        }
                    });
                }
            };
            if (TMEnv.INSTANCE.getEnableDelayInit()) {
                delayInitTask = function0;
            } else {
                TMThreadUtils.INSTANCE.async(new Function0<Unit>() { // from class: com.bytedance.timonbase.config.TMSettingFetcher$invoke$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1051invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1051invoke() {
                        function0.invoke();
                    }
                });
            }
        }
        return jsonObject2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean fetchConfig$default(TMSettingFetcher tMSettingFetcher, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return tMSettingFetcher.fetchConfig(i);
    }

    private final boolean fetchConfig(int retryCount) {
        if (retryCount >= 3) {
            TMLogger.INSTANCE.m221e(TAG, "exceeded the max number of retry, exit");
            return false;
        }
        try {
            Response<Settings> settings = TMNetworkService.INSTANCE.getSettings();
            if (settings != null && settings.getSucceed()) {
                Settings data = settings.getData();
                if (data == null) {
                    data = new Settings(null, null, 3, null);
                }
                Settings config = TMCacheService.INSTANCE.getConfig();
                if (config != null) {
                    if (data.getConfig().getTimonConfig().length() == 0) {
                        data = Settings.copy$default(data, Settings.Config.copy$default(data.getConfig(), config.getConfig().getTimonConfig(), null, null, null, 14, null), null, 2, null);
                    }
                    if (data.getConfig().getRulerEngineConfig().length() == 0) {
                        data = Settings.copy$default(data, Settings.Config.copy$default(data.getConfig(), null, config.getConfig().getRulerEngineConfig(), null, null, 13, null), null, 2, null);
                    }
                    if (data.getConfig().getSensitivePathConfig().length() == 0) {
                        data = Settings.copy$default(data, Settings.Config.copy$default(data.getConfig(), null, null, config.getConfig().getSensitivePathConfig(), null, 11, null), null, 2, null);
                    }
                    if (data.getConfig().getTimonEncryptionList().length() == 0) {
                        data = Settings.copy$default(data, Settings.Config.copy$default(data.getConfig(), null, null, null, config.getConfig().getTimonEncryptionList(), 7, null), null, 2, null);
                    }
                }
                TMCacheService.INSTANCE.putConfig(data);
                TMMetric.reportNetworkCall$default(TMMetric.INSTANCE, true, retryCount, null, 4, null);
                return true;
            }
            throw new IllegalStateException(settings != null ? settings.getMessage() : null);
        } catch (Exception e) {
            TMLogger.INSTANCE.m222e(TAG, "fetch config failed[" + retryCount + ']', e);
            TMMetric.INSTANCE.reportNetworkCall(false, retryCount, e.getMessage());
            Thread.sleep(5000L);
            return fetchConfig(retryCount + 1);
        }
    }
}
