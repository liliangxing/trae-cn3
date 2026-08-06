package com.bytedance.push.settings.signal.sync;

import com.bytedance.push.settings.LocalSettings;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class SignalReportHistory {

    @SerializedName(LocalSettings.SIGNAL_REPORT_HISTORY)
    public Map<String, ItemSignalReportHistory> history = new HashMap();
}
