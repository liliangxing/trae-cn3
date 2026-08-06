package com.bytedance.push.settings.notification;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PollingNotificationReport {

    @SerializedName("enable_alliance_report")
    public boolean enableAllianceReport;

    @SerializedName("enable_back_to_fore_notification_report")
    public boolean enableBackToForeNotificationReport;

    @SerializedName("enable_original_reporting")
    public boolean enableOriginalReporting = true;

    @SerializedName("enable_polling")
    public boolean enablePolling;

    @SerializedName("enable_reporting_timing")
    public boolean enableReportingTiming;

    @SerializedName("polling_interval")
    public int pollingInterval;
}
