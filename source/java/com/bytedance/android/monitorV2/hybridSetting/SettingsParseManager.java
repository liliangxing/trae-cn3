package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.DataReporter;
import com.bytedance.android.monitorV2.listener.EventTraceToTea;
import com.bytedance.android.monitorV2.listener.EventWatchTools;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.settings.MonitorSettingsCenter;
import kotlin.Metadata;

/* compiled from: SettingsParseManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager;", "", "()V", "TAG", "", "parseListener", "Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager$SettingsParseListener;", "getParseListener", "()Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager$SettingsParseListener;", "settingsCenter", "Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter;", "getSettingsCenter", "()Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter;", "setSettingsCenter", "(Lcom/bytedance/android/monitorV2/settings/MonitorSettingsCenter;)V", "ISettingsParseListener", "SettingsParseListener", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SettingsParseManager {
    public static final String TAG = "SettingsParseManager";
    private static MonitorSettingsCenter settingsCenter;
    public static final SettingsParseManager INSTANCE = new SettingsParseManager();
    private static final SettingsParseListener parseListener = new SettingsParseListener();

    /* compiled from: SettingsParseManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager$ISettingsParseListener;", "", "highPriorityTaskDone", "", "lowPriorityTaskDone", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ISettingsParseListener {
        void highPriorityTaskDone();

        void lowPriorityTaskDone();
    }

    private SettingsParseManager() {
    }

    public final SettingsParseListener getParseListener() {
        return parseListener;
    }

    public final MonitorSettingsCenter getSettingsCenter() {
        return settingsCenter;
    }

    public final void setSettingsCenter(MonitorSettingsCenter monitorSettingsCenter) {
        settingsCenter = monitorSettingsCenter;
    }

    /* compiled from: SettingsParseManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager$SettingsParseListener;", "Lcom/bytedance/android/monitorV2/hybridSetting/SettingsParseManager$ISettingsParseListener;", "()V", "highPriorityTaskDone", "", "lowPriorityTaskDone", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class SettingsParseListener implements ISettingsParseListener {
        @Override // com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager.ISettingsParseListener
        public void highPriorityTaskDone() {
            EventWatchTools.INSTANCE.register();
            EventTraceToTea.INSTANCE.register();
            MonitorLog.m26d(SettingsParseManager.TAG, "highPriorityTaskDone");
        }

        @Override // com.bytedance.android.monitorV2.hybridSetting.SettingsParseManager.ISettingsParseListener
        public void lowPriorityTaskDone() {
            DataReporter.INSTANCE.getTypedDataDispatcher().notifyAllEvents();
            if (Switches.appSettings.isEnabled()) {
                MonitorSettingsCenter settingsCenter = SettingsParseManager.INSTANCE.getSettingsCenter();
                if (settingsCenter != null) {
                    settingsCenter.checkUpdate();
                    MonitorLog.m29i(SettingsParseManager.TAG, "update app settings...");
                } else {
                    SettingsParseManager.INSTANCE.setSettingsCenter(new MonitorSettingsCenter());
                }
            }
            MonitorLog.m26d(SettingsParseManager.TAG, "lowPriorityTaskDone");
        }
    }
}
