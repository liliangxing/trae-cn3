package com.bytedance.android.monitorV2.settings;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.news.common.settings.IndividualManager;
import com.bytedance.news.common.settings.LazyConfig;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorSettingsCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J!\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter;", "", "()V", "TAG", "", "callbackAsync", "", "getCallbackAsync", "()Z", "settingId", "settingsListener", "Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter$OnUpdateListener;", "getSettingsListener", "()Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter$OnUpdateListener;", "setSettingsListener", "(Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter$OnUpdateListener;)V", "settingsStorage", "Lcom/bytedance/android/monitorV2/settings/SettingsProvider;", "getSettingsStorage", "()Lcom/bytedance/android/monitorV2/settings/SettingsProvider;", "checkUpdate", "", "obtainSettings", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "OnUpdateListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorSettingsCenter {
    private OnUpdateListener settingsListener;
    private final String TAG = "MonitorSettingsCenter";
    private final String settingId = "hybrid_monitor";
    private final SettingsProvider settingsStorage = new SettingsProvider();
    private final boolean callbackAsync = true;

    /* compiled from: MonitorSettingsCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter$OnUpdateListener;", "", "onUpdate", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface OnUpdateListener {
        void onUpdate();
    }

    public MonitorSettingsCenter() {
        IndividualManager.obtainManager("hybrid_monitor").init(new LazyConfig() { // from class: com.bytedance.android.monitorV2.settings.MonitorSettingsCenter.1
            public final SettingsConfig create() {
                return new SettingsConfig.Builder().context(HybridMultiMonitor.getInstance().getApplication()).updateInterval(3600000).requestService(new MonitorRequestServiceImpl()).build();
            }
        });
        MonitorLog.m29i("MonitorSettingsCenter", "monitor app settings init");
        IndividualManager.obtainManager("hybrid_monitor").registerListener(new SettingsUpdateListener() { // from class: com.bytedance.android.monitorV2.settings.MonitorSettingsCenter.2
            public final void onSettingsUpdate(SettingsData settingsData) {
                Object obtain = IndividualManager.obtainManager(MonitorSettingsCenter.this.settingId).obtain(IMonitorSettings.class);
                Intrinsics.checkNotNullExpressionValue(obtain, "obtainManager(settingId)…itorSettings::class.java)");
                IMonitorSettings iMonitorSettings = (IMonitorSettings) obtain;
                MonitorSettingsCenter.this.getSettingsStorage().registerHolder(WebBlankConfig.class, iMonitorSettings.getWebBlankConfig());
                MonitorSettingsCenter.this.getSettingsStorage().registerHolder(MonitorConfig.class, iMonitorSettings.getMonitorConfig());
                MonitorSettingsCenter.this.getSettingsStorage().registerHolder(LynxBlankConfig.class, iMonitorSettings.getLynxBlankConfig());
                OnUpdateListener settingsListener = MonitorSettingsCenter.this.getSettingsListener();
                if (settingsListener != null) {
                    settingsListener.onUpdate();
                }
            }
        }, !true);
        IndividualManager.obtainManager("hybrid_monitor").updateSettings(true);
    }

    public final SettingsProvider getSettingsStorage() {
        return this.settingsStorage;
    }

    public final boolean getCallbackAsync() {
        return this.callbackAsync;
    }

    public final OnUpdateListener getSettingsListener() {
        return this.settingsListener;
    }

    public final void setSettingsListener(OnUpdateListener onUpdateListener) {
        this.settingsListener = onUpdateListener;
    }

    public final void checkUpdate() {
        IndividualManager.obtainManager(this.settingId).updateSettings(true);
    }

    public final <T> T obtainSettings(Class<T> clazz) {
        T t;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Result.Companion companion = Result.Companion;
            t = (T) Result.constructor-impl(this.settingsStorage.provideInstance(clazz));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = (T) Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }
}
