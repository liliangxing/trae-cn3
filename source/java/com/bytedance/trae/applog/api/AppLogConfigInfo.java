package com.bytedance.trae.applog.api;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLogConfigInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\t\u00107\u001a\u00020\u000bHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0013HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\u000bHÆ\u0003J½\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000bHÆ\u0001J\u0013\u0010B\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0015\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\"¨\u0006F"}, d2 = {"Lcom/bytedance/trae/applog/api/AppLogConfigInfo;", "", "appId", "", "appName", "", "versionCode", "versionName", "updateVersionCode", "channel", "isBoe", "", "filterEnable", "samplingEnable", "newMonitorEnabled", "newMonitorInDebugMode", "defaultSentryEnabled", "defaultSentryColdStartSamplingRate", "defaultColdStartReportDelay", "", "defaultReportInterval", "packByLengthEnabled", "realtimeEventOptEnabled", "packMultiQueryEnabled", "<init>", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ZZZZZZIJJZZZ)V", "getAppId", "()I", "getAppName", "()Ljava/lang/String;", "getVersionCode", "getVersionName", "getUpdateVersionCode", "getChannel", "()Z", "getFilterEnable", "getSamplingEnable", "getNewMonitorEnabled", "getNewMonitorInDebugMode", "getDefaultSentryEnabled", "getDefaultSentryColdStartSamplingRate", "getDefaultColdStartReportDelay", "()J", "getDefaultReportInterval", "getPackByLengthEnabled", "getRealtimeEventOptEnabled", "getPackMultiQueryEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AppLogConfigInfo {
    private final int appId;
    private final String appName;
    private final String channel;
    private final long defaultColdStartReportDelay;
    private final long defaultReportInterval;
    private final int defaultSentryColdStartSamplingRate;
    private final boolean defaultSentryEnabled;
    private final boolean filterEnable;
    private final boolean isBoe;
    private final boolean newMonitorEnabled;
    private final boolean newMonitorInDebugMode;
    private final boolean packByLengthEnabled;
    private final boolean packMultiQueryEnabled;
    private final boolean realtimeEventOptEnabled;
    private final boolean samplingEnable;
    private final int updateVersionCode;
    private final int versionCode;
    private final String versionName;

    /* renamed from: component1, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getNewMonitorEnabled() {
        return this.newMonitorEnabled;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getNewMonitorInDebugMode() {
        return this.newMonitorInDebugMode;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getDefaultSentryEnabled() {
        return this.defaultSentryEnabled;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDefaultSentryColdStartSamplingRate() {
        return this.defaultSentryColdStartSamplingRate;
    }

    /* renamed from: component14, reason: from getter */
    public final long getDefaultColdStartReportDelay() {
        return this.defaultColdStartReportDelay;
    }

    /* renamed from: component15, reason: from getter */
    public final long getDefaultReportInterval() {
        return this.defaultReportInterval;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getPackByLengthEnabled() {
        return this.packByLengthEnabled;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getRealtimeEventOptEnabled() {
        return this.realtimeEventOptEnabled;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getPackMultiQueryEnabled() {
        return this.packMultiQueryEnabled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsBoe() {
        return this.isBoe;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getFilterEnable() {
        return this.filterEnable;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getSamplingEnable() {
        return this.samplingEnable;
    }

    public final AppLogConfigInfo copy(int appId, String appName, int versionCode, String versionName, int updateVersionCode, String channel, boolean isBoe, boolean filterEnable, boolean samplingEnable, boolean newMonitorEnabled, boolean newMonitorInDebugMode, boolean defaultSentryEnabled, int defaultSentryColdStartSamplingRate, long defaultColdStartReportDelay, long defaultReportInterval, boolean packByLengthEnabled, boolean realtimeEventOptEnabled, boolean packMultiQueryEnabled) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new AppLogConfigInfo(appId, appName, versionCode, versionName, updateVersionCode, channel, isBoe, filterEnable, samplingEnable, newMonitorEnabled, newMonitorInDebugMode, defaultSentryEnabled, defaultSentryColdStartSamplingRate, defaultColdStartReportDelay, defaultReportInterval, packByLengthEnabled, realtimeEventOptEnabled, packMultiQueryEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppLogConfigInfo)) {
            return false;
        }
        AppLogConfigInfo appLogConfigInfo = (AppLogConfigInfo) other;
        return this.appId == appLogConfigInfo.appId && Intrinsics.areEqual(this.appName, appLogConfigInfo.appName) && this.versionCode == appLogConfigInfo.versionCode && Intrinsics.areEqual(this.versionName, appLogConfigInfo.versionName) && this.updateVersionCode == appLogConfigInfo.updateVersionCode && Intrinsics.areEqual(this.channel, appLogConfigInfo.channel) && this.isBoe == appLogConfigInfo.isBoe && this.filterEnable == appLogConfigInfo.filterEnable && this.samplingEnable == appLogConfigInfo.samplingEnable && this.newMonitorEnabled == appLogConfigInfo.newMonitorEnabled && this.newMonitorInDebugMode == appLogConfigInfo.newMonitorInDebugMode && this.defaultSentryEnabled == appLogConfigInfo.defaultSentryEnabled && this.defaultSentryColdStartSamplingRate == appLogConfigInfo.defaultSentryColdStartSamplingRate && this.defaultColdStartReportDelay == appLogConfigInfo.defaultColdStartReportDelay && this.defaultReportInterval == appLogConfigInfo.defaultReportInterval && this.packByLengthEnabled == appLogConfigInfo.packByLengthEnabled && this.realtimeEventOptEnabled == appLogConfigInfo.realtimeEventOptEnabled && this.packMultiQueryEnabled == appLogConfigInfo.packMultiQueryEnabled;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((Integer.hashCode(this.appId) * 31) + this.appName.hashCode()) * 31) + Integer.hashCode(this.versionCode)) * 31) + this.versionName.hashCode()) * 31) + Integer.hashCode(this.updateVersionCode)) * 31) + this.channel.hashCode()) * 31) + Boolean.hashCode(this.isBoe)) * 31) + Boolean.hashCode(this.filterEnable)) * 31) + Boolean.hashCode(this.samplingEnable)) * 31) + Boolean.hashCode(this.newMonitorEnabled)) * 31) + Boolean.hashCode(this.newMonitorInDebugMode)) * 31) + Boolean.hashCode(this.defaultSentryEnabled)) * 31) + Integer.hashCode(this.defaultSentryColdStartSamplingRate)) * 31) + Long.hashCode(this.defaultColdStartReportDelay)) * 31) + Long.hashCode(this.defaultReportInterval)) * 31) + Boolean.hashCode(this.packByLengthEnabled)) * 31) + Boolean.hashCode(this.realtimeEventOptEnabled)) * 31) + Boolean.hashCode(this.packMultiQueryEnabled);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppLogConfigInfo(appId=");
        sb.append(this.appId).append(", appName=").append(this.appName).append(", versionCode=").append(this.versionCode).append(", versionName=").append(this.versionName).append(", updateVersionCode=").append(this.updateVersionCode).append(", channel=").append(this.channel).append(", isBoe=").append(this.isBoe).append(", filterEnable=").append(this.filterEnable).append(", samplingEnable=").append(this.samplingEnable).append(", newMonitorEnabled=").append(this.newMonitorEnabled).append(", newMonitorInDebugMode=").append(this.newMonitorInDebugMode).append(", defaultSentryEnabled=");
        sb.append(this.defaultSentryEnabled).append(", defaultSentryColdStartSamplingRate=").append(this.defaultSentryColdStartSamplingRate).append(", defaultColdStartReportDelay=").append(this.defaultColdStartReportDelay).append(", defaultReportInterval=").append(this.defaultReportInterval).append(", packByLengthEnabled=").append(this.packByLengthEnabled).append(", realtimeEventOptEnabled=").append(this.realtimeEventOptEnabled).append(", packMultiQueryEnabled=").append(this.packMultiQueryEnabled).append(')');
        return sb.toString();
    }

    public AppLogConfigInfo(int i, String appName, int i2, String versionName, int i3, String channel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i4, long j, long j2, boolean z7, boolean z8, boolean z9) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.appId = i;
        this.appName = appName;
        this.versionCode = i2;
        this.versionName = versionName;
        this.updateVersionCode = i3;
        this.channel = channel;
        this.isBoe = z;
        this.filterEnable = z2;
        this.samplingEnable = z3;
        this.newMonitorEnabled = z4;
        this.newMonitorInDebugMode = z5;
        this.defaultSentryEnabled = z6;
        this.defaultSentryColdStartSamplingRate = i4;
        this.defaultColdStartReportDelay = j;
        this.defaultReportInterval = j2;
        this.packByLengthEnabled = z7;
        this.realtimeEventOptEnabled = z8;
        this.packMultiQueryEnabled = z9;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }

    public final boolean getFilterEnable() {
        return this.filterEnable;
    }

    public final boolean getSamplingEnable() {
        return this.samplingEnable;
    }

    public final boolean getNewMonitorEnabled() {
        return this.newMonitorEnabled;
    }

    public final boolean getNewMonitorInDebugMode() {
        return this.newMonitorInDebugMode;
    }

    public final boolean getDefaultSentryEnabled() {
        return this.defaultSentryEnabled;
    }

    public final int getDefaultSentryColdStartSamplingRate() {
        return this.defaultSentryColdStartSamplingRate;
    }

    public final long getDefaultColdStartReportDelay() {
        return this.defaultColdStartReportDelay;
    }

    public final long getDefaultReportInterval() {
        return this.defaultReportInterval;
    }

    public final boolean getPackByLengthEnabled() {
        return this.packByLengthEnabled;
    }

    public final boolean getRealtimeEventOptEnabled() {
        return this.realtimeEventOptEnabled;
    }

    public final boolean getPackMultiQueryEnabled() {
        return this.packMultiQueryEnabled;
    }
}
