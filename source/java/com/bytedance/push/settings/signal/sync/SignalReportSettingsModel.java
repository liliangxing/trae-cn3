package com.bytedance.push.settings.signal.sync;

import com.bytedance.push.settings.PushOnlineSettings;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class SignalReportSettingsModel {

    @SerializedName(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS)
    private List<SignalReportConfig> signalReportSettings = new ArrayList();

    public List<SignalReportConfig> getSignalReportSettings() {
        List<SignalReportConfig> list = this.signalReportSettings;
        return list == null ? new ArrayList() : list;
    }
}
