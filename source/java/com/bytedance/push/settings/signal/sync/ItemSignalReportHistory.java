package com.bytedance.push.settings.signal.sync;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class ItemSignalReportHistory {

    @SerializedName("last_report_time")
    public long lastReportTime;

    @SerializedName("last_signal_info")
    public String lastSignalInfo;

    public ItemSignalReportHistory() {
    }

    public ItemSignalReportHistory(String str, long j) {
        this.lastSignalInfo = str;
        this.lastReportTime = j;
    }
}
