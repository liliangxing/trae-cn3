package com.bytedance.push.settings.statistics;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class DeviceDurationLevelModel {

    @SerializedName("cur_device_doze_duration")
    public long curDeviceDozeDuration;

    @SerializedName("cur_device_kill_process_duration")
    public long curDeviceKillProcessDuration;

    @SerializedName("last_detect_min_doze_duration_timestamp")
    public long lastDetectMinDozeDurationTimestamp;

    @SerializedName("last_device_doze_duration")
    public long lastDeviceDozeDuration;

    @SerializedName("last_device_kill_process_duration")
    public long lastDeviceKillProcessDuration;

    public long getDeviceKillProcessDuration() {
        return this.lastDeviceKillProcessDuration;
    }

    public long getDeviceDozeDuration() {
        return this.lastDeviceDozeDuration;
    }
}
