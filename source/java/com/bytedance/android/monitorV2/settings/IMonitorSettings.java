package com.bytedance.android.monitorV2.settings;

import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import kotlin.Metadata;

/* compiled from: IMonitorSettings.kt */
@Settings(migrations = {}, settingsId = "hybrid_monitor", storageKey = "hybrid_monitor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/IMonitorSettings;", "Lcom/bytedance/news/common/settings/api/annotation/ISettings;", "getLynxBlankConfig", "Lcom/bytedance/android/monitorV2/settings/LynxBlankConfig;", "getMonitorConfig", "Lcom/bytedance/android/monitorV2/settings/MonitorConfig;", "getWebBlankConfig", "Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface IMonitorSettings extends ISettings {
    LynxBlankConfig getLynxBlankConfig();

    MonitorConfig getMonitorConfig();

    WebBlankConfig getWebBlankConfig();
}
