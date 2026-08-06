package com.bytedance.push.settings.push.click;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PushClickReportOptSettingsModel {

    @SerializedName("opt_push_click_session_id")
    public boolean optPushClickSessionId = false;

    @SerializedName("min_delay_time_in_mill")
    public long minDelayTimeInMill = 3000;

    @SerializedName("max_delay_time_in_mill")
    public long maxDelayTimeInMill = 10000;
}
