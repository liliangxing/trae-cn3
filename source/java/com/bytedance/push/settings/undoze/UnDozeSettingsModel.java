package com.bytedance.push.settings.undoze;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* loaded from: classes4.dex */
public class UnDozeSettingsModel {

    @SerializedName("enable_vv_un_doze")
    public boolean enableVvUnDoze;

    @SerializedName("opt_terminate_report")
    public boolean optTerminateReport;

    @SerializedName("process_settings")
    public Map<String, UnDozeProcessSettings> unDozeProcessSettings;

    /* loaded from: classes4.dex */
    public static class UnDozeProcessSettings {

        @SerializedName("enable_vv_un_doze")
        public boolean enableVvUnDoze;

        @SerializedName("un_doze_time")
        public long unDozeTime;
    }
}
