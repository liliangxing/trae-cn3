package com.bytedance.apm.battery.internal;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.CommonDataAssembly;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BatteryStatsRet {
    private long mBackDuration;
    private long mFrontDuration;
    private boolean mIsCharging;
    private long mMaxBackDuration;
    private long mMaxFrontDuration;
    private long mProcessBackDuration;
    private long mProcessFrontDuration;
    private String mProcessName;
    private String mScene;
    private String mStartUUID;
    private int mTotalBackAlarmCount;
    private int mTotalBackCpuMs;
    private int mTotalBackLocMs;
    private long mTotalBackTrafficBytes;
    private long mTotalBackTrafficPackets;
    private int mTotalBackWakeLockMs;
    private int mTotalFrontAlarmCount;
    private int mTotalFrontCpuMs;
    private int mTotalFrontLocMs;
    private long mTotalFrontTrafficBytes;
    private long mTotalFrontTrafficPackets;
    private int mTotalFrontWakeLockMs;
    private long mFrontCpuMs = 0;
    private long mFrontLocMs = 0;
    private long mFrontWakeLockMs = 0;
    private long mFrontAlarmCount = 0;
    private long mFrontTrafficBytes = 0;
    private long mFrontTrafficPackets = 0;
    private long mFrontTrafficBytesAllIface = 0;
    private long mFrontTrafficPacketsAllIface = 0;
    private long mFrontBatteryConsume = 0;
    private long mBackCpuMs = 0;
    private long mBackLocMs = 0;
    private long mBackWakeLockMs = 0;
    private long mBackAlarmCount = 0;
    private long mBackTrafficBytes = 0;
    private long mBackTrafficPackets = 0;
    private long mBackTrafficBytesAllIface = 0;
    private long mBackTrafficPacketsAllIface = 0;
    private boolean mMainProcess = true;
    private long mTotalFrontBytesAllInterface = 0;
    private long mTotalFrontPacketAllInterface = 0;
    private long mTotalBackBytesAllInterface = 0;
    private long mTotalBackPacketAllInterface = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBackDuration(long j) {
        this.mBackDuration += j;
    }

    public void addBackCpuMs(long j) {
        this.mBackCpuMs += j;
    }

    public void addBackWakeLockMs(long j) {
        this.mBackWakeLockMs += j;
    }

    public void addBackTrafficBytes(long j) {
        this.mBackTrafficBytes += j;
    }

    public void addBackTrafficPackets(long j) {
        this.mBackTrafficPackets += j;
    }

    public void addBackBytesAllInterface(long j) {
        this.mBackTrafficBytesAllIface += j;
    }

    public void addBackPacketsAllInterface(long j) {
        this.mBackTrafficPacketsAllIface += j;
    }

    public void addBackLocMs(long j) {
        this.mBackLocMs += j;
    }

    public void addBackWakeUpAlarmCount(long j) {
        this.mBackAlarmCount += j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFrontDuration(long j) {
        this.mFrontDuration += j;
    }

    public void addFrontCpuMs(long j) {
        this.mFrontCpuMs += j;
    }

    public void addFrontWakeLockMs(long j) {
        this.mFrontWakeLockMs += j;
    }

    public void addFrontTrafficBytes(long j) {
        this.mFrontTrafficBytes += j;
    }

    public void addFrontTrafficPackets(long j) {
        this.mFrontTrafficPackets += j;
    }

    public void addFrontBytesAllInterface(long j) {
        this.mFrontTrafficBytesAllIface += j;
    }

    public void addFrontPacketsAllInterface(long j) {
        this.mFrontTrafficPacketsAllIface += j;
    }

    public void addFrontLocMs(long j) {
        this.mFrontLocMs += j;
    }

    public void addFrontWakeUpAlarmCount(long j) {
        this.mFrontAlarmCount += j;
    }

    public void addBatteryConsume(long j) {
        this.mFrontBatteryConsume += j;
    }

    public boolean isMainProcess() {
        return this.mMainProcess;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMainProcess(boolean z) {
        this.mMainProcess = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsCharging(boolean z) {
        this.mIsCharging = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProcessName(String str) {
        this.mProcessName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStartUUID(String str) {
        this.mStartUUID = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScene(String str) {
        this.mScene = str;
    }

    void clearReportedData() {
        this.mFrontDuration = 0L;
        this.mBackDuration = 0L;
        this.mFrontCpuMs = 0L;
        this.mFrontLocMs = 0L;
        this.mFrontWakeLockMs = 0L;
        this.mFrontAlarmCount = 0L;
        this.mFrontTrafficBytes = 0L;
        this.mFrontTrafficPackets = 0L;
        this.mFrontTrafficBytesAllIface = 0L;
        this.mFrontTrafficPacketsAllIface = 0L;
        this.mFrontBatteryConsume = 0L;
        this.mBackCpuMs = 0L;
        this.mBackLocMs = 0L;
        this.mBackWakeLockMs = 0L;
        this.mBackAlarmCount = 0L;
        this.mBackTrafficBytes = 0L;
        this.mBackTrafficPackets = 0L;
        this.mBackTrafficBytesAllIface = 0L;
        this.mBackTrafficPacketsAllIface = 0L;
        this.mMainProcess = true;
        this.mIsCharging = false;
        this.mProcessName = "";
        this.mStartUUID = "";
        this.mScene = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportOverallData() {
        this.mFrontAlarmCount = this.mTotalFrontAlarmCount;
        this.mFrontCpuMs = this.mTotalFrontCpuMs;
        this.mFrontLocMs = this.mTotalFrontLocMs;
        this.mFrontWakeLockMs = this.mTotalFrontWakeLockMs;
        this.mFrontDuration = this.mMaxFrontDuration;
        this.mFrontTrafficBytes = this.mTotalFrontTrafficBytes;
        this.mFrontTrafficPackets = this.mTotalFrontTrafficPackets;
        this.mFrontTrafficBytesAllIface = this.mTotalFrontBytesAllInterface;
        this.mFrontTrafficPacketsAllIface = this.mTotalFrontPacketAllInterface;
        this.mBackAlarmCount = this.mTotalBackAlarmCount;
        this.mBackCpuMs = this.mTotalBackCpuMs;
        this.mBackLocMs = this.mTotalBackLocMs;
        this.mBackWakeLockMs = this.mTotalBackWakeLockMs;
        this.mBackDuration = this.mMaxBackDuration;
        this.mBackTrafficBytes = this.mTotalBackTrafficBytes;
        this.mBackTrafficPackets = this.mTotalBackTrafficPackets;
        this.mBackTrafficBytesAllIface = this.mTotalBackBytesAllInterface;
        this.mBackTrafficPacketsAllIface = this.mTotalBackPacketAllInterface;
        this.mMainProcess = false;
        this.mProcessName = "all_process";
        this.mIsCharging = false;
        this.mScene = "";
        try {
            report(false);
        } catch (Exception unused) {
        }
    }

    boolean isFrontDataValid() {
        return this.mFrontDuration > 10000;
    }

    boolean isBackDataValid() {
        return this.mBackDuration > 5000;
    }

    public boolean report(boolean z) throws Exception {
        boolean compute = compute(z);
        if (!compute && ApmContext.isDebugMode()) {
            Logger.i(DebugLogger.TAG_BATTERY, "stats report failed, processName: " + this.mProcessName);
        }
        clearReportedData();
        return compute;
    }

    public void isProcessOver() {
        long j = this.mProcessFrontDuration;
        if (j > this.mMaxFrontDuration) {
            this.mMaxFrontDuration = j;
        }
        this.mProcessFrontDuration = 0L;
        long j2 = this.mProcessBackDuration;
        if (j2 > this.mMaxBackDuration) {
            this.mMaxBackDuration = j2;
        }
        this.mProcessBackDuration = 0L;
    }

    private boolean compute(boolean z) throws Exception {
        JSONObject computeAndReturnJSONObject = computeAndReturnJSONObject(z);
        if (computeAndReturnJSONObject == null) {
            return false;
        }
        if (computeAndReturnJSONObject.length() == 0) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_main_process", this.mMainProcess);
        jSONObject.put("process_name", this.mProcessName);
        jSONObject.put("scene", this.mScene);
        jSONObject.put(CommonKey.KEY_IS_CHARGING, this.mIsCharging ? 1 : 0);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("sid", this.mStartUUID);
        PerfData perfData = new PerfData("battery", "", computeAndReturnJSONObject, jSONObject, jSONObject2);
        CommonDataAssembly.wrapFilters(perfData, false);
        CommonDataPipeline.getInstance().handle(perfData);
        if (ApmContext.isDebugMode()) {
            Logger.i(DebugLogger.TAG_BATTERY, "stats report, processName: " + this.mProcessName + " Json:" + computeAndReturnJSONObject.toString());
        }
        return true;
    }

    public JSONObject computeAndReturnJSONObject(boolean z) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (isFrontDataValid()) {
            jSONObject.put("front_alarm", this.mFrontAlarmCount);
            jSONObject.put("front_loc_p_time", (((float) this.mFrontLocMs) * 1.0f) / 1000.0f);
            jSONObject.put("front_power_p_time", (((float) this.mFrontWakeLockMs) * 1.0f) / 1000.0f);
            if (this.mFrontCpuMs < 0) {
                if (ApmContext.isDebugMode()) {
                    Logger.w(DebugLogger.TAG_BATTERY, " report data invalid, frontCpuMs < 0 : " + this.mFrontCpuMs);
                }
                return null;
            }
            jSONObject.put("front_cpu_active_time_p_time", (((float) r4) * 1.0f) / 1000.0f);
            double d = (this.mFrontAlarmCount * 0.002083333383779973d) + (this.mFrontCpuMs * 6.944444612599909E-5d) + (this.mFrontLocMs * 7.499999810534064E-6d) + (this.mFrontWakeLockMs * 6.944444521650439E-6d);
            if (this.mMainProcess || !z) {
                jSONObject.put("front_traffic_all_iface", (((float) this.mFrontTrafficBytesAllIface) * 1.0f) / 1024.0f);
                jSONObject.put("front_traffic_packets_all_iface", this.mFrontTrafficPacketsAllIface);
                jSONObject.put("front_traffic_p_capacity", (((float) this.mFrontTrafficBytes) * 1.0f) / 1024.0f);
                jSONObject.put("front_traffic_packets", this.mFrontTrafficPackets);
                d += this.mFrontTrafficBytes * 2.6666666030905617E-7d;
            }
            if (d < 0.0d) {
                if (ApmContext.isDebugMode()) {
                    Logger.w(DebugLogger.TAG_BATTERY, " report data invalid, frontScore < 0 : " + d);
                }
                return null;
            }
            jSONObject.put("front_score", d);
            jSONObject.put("front_p_time", (((float) this.mFrontDuration) * 1.0f) / 1000.0f);
            float f = 60000.0f / ((float) this.mFrontDuration);
            jSONObject.put("front_alarm_per_min", ((float) this.mFrontAlarmCount) * f);
            jSONObject.put("front_loc_per_min_p_time", (((float) this.mFrontLocMs) / 1000.0f) * f);
            jSONObject.put("front_power_per_min_p_time", (((float) this.mFrontWakeLockMs) / 1000.0f) * f);
            jSONObject.put("front_cpu_active_time_per_min_p_time", (((float) this.mFrontCpuMs) / 1000.0f) * f);
            if (this.mMainProcess || !z) {
                jSONObject.put("front_traffic_per_min_p_capacity", (((float) this.mFrontTrafficBytes) / 1024.0f) * f);
                jSONObject.put("front_traffic_packets_per_min", ((float) this.mFrontTrafficPackets) * f);
                jSONObject.put("front_traffic_all_iface_per_min", ((((float) this.mFrontTrafficBytesAllIface) * 1.0f) / 1024.0f) * f);
                jSONObject.put("front_traffic_packets_all_iface_per_min", ((float) this.mFrontTrafficPacketsAllIface) * f);
            }
            jSONObject.put("front_score_per_min", d * f);
            if (this.mMainProcess) {
                jSONObject.put("front_battery_consume", this.mFrontBatteryConsume);
                jSONObject.put("front_battery_consume_per_min", ((float) this.mFrontBatteryConsume) * f);
            }
            if (z) {
                this.mTotalFrontAlarmCount = (int) (this.mTotalFrontAlarmCount + this.mFrontAlarmCount);
                this.mTotalFrontCpuMs = (int) (this.mTotalFrontCpuMs + this.mFrontCpuMs);
                this.mTotalFrontLocMs = (int) (this.mTotalFrontLocMs + this.mFrontLocMs);
                this.mTotalFrontWakeLockMs = (int) (this.mTotalFrontWakeLockMs + this.mFrontWakeLockMs);
                this.mProcessFrontDuration += this.mFrontDuration;
                this.mTotalFrontTrafficBytes += this.mFrontTrafficBytes;
                this.mTotalFrontTrafficPackets += this.mFrontTrafficPackets;
                this.mTotalFrontBytesAllInterface += this.mFrontTrafficBytesAllIface;
                this.mTotalFrontPacketAllInterface += this.mFrontTrafficPacketsAllIface;
            }
        }
        if (isBackDataValid()) {
            jSONObject.put("back_alarm", this.mBackAlarmCount);
            jSONObject.put("back_loc_p_time", (((float) this.mBackLocMs) * 1.0f) / 1000.0f);
            jSONObject.put("back_power_p_time", (((float) this.mBackWakeLockMs) * 1.0f) / 1000.0f);
            if (this.mBackCpuMs < 0) {
                if (ApmContext.isDebugMode()) {
                    Logger.w(DebugLogger.TAG_BATTERY, " report data invalid, mBackCpuMs < 0 : " + this.mBackCpuMs);
                }
                return null;
            }
            jSONObject.put("back_cpu_active_time_p_time", (((float) r4) * 1.0f) / 1000.0f);
            double d2 = (this.mBackAlarmCount * 0.002083333383779973d) + (this.mBackCpuMs * 6.944444612599909E-5d) + (this.mBackLocMs * 7.499999810534064E-6d) + (this.mBackWakeLockMs * 6.944444521650439E-6d);
            if (this.mMainProcess || !z) {
                jSONObject.put("back_traffic_all_iface", (((float) this.mBackTrafficBytesAllIface) * 1.0f) / 1024.0f);
                jSONObject.put("back_traffic_packets_all_iface", this.mBackTrafficPacketsAllIface);
                jSONObject.put("back_traffic_p_capacity", (((float) this.mBackTrafficBytes) * 1.0f) / 1024.0f);
                jSONObject.put("back_traffic_packets", this.mBackTrafficPackets);
                d2 += this.mBackTrafficBytes * 2.6666666030905617E-7d;
            }
            jSONObject.put("back_score", d2);
            jSONObject.put("back_p_time", (((float) this.mBackDuration) * 1.0f) / 1000.0f);
            float f2 = 60000.0f / ((float) this.mBackDuration);
            jSONObject.put("back_alarm_per_min", ((float) this.mBackAlarmCount) * f2);
            jSONObject.put("back_loc_per_min_p_time", (((float) this.mBackLocMs) / 1000.0f) * f2);
            jSONObject.put("back_power_per_min_p_time", (((float) this.mBackWakeLockMs) / 1000.0f) * f2);
            jSONObject.put("back_cpu_active_time_per_min_p_time", (((float) this.mBackCpuMs) / 1000.0f) * f2);
            if (this.mMainProcess || !z) {
                jSONObject.put("back_traffic_all_iface_per_min", ((((float) this.mBackTrafficBytesAllIface) * 1.0f) / 1024.0f) * f2);
                jSONObject.put("back_traffic_packets_all_iface_per_min", ((float) this.mBackTrafficPacketsAllIface) * f2);
                jSONObject.put("back_traffic_per_min_p_capacity", (((float) this.mBackTrafficBytes) / 1024.0f) * f2);
                jSONObject.put("back_traffic_packets_per_min", ((float) this.mBackTrafficPackets) * f2);
            }
            jSONObject.put("back_score_per_min", d2 * f2);
            if (z) {
                this.mTotalBackAlarmCount = (int) (this.mTotalBackAlarmCount + this.mBackAlarmCount);
                this.mTotalBackCpuMs = (int) (this.mTotalBackCpuMs + this.mBackCpuMs);
                this.mTotalBackLocMs = (int) (this.mTotalBackLocMs + this.mBackLocMs);
                this.mTotalBackWakeLockMs = (int) (this.mTotalBackWakeLockMs + this.mBackWakeLockMs);
                this.mProcessBackDuration += this.mBackDuration;
                this.mTotalBackBytesAllInterface += this.mBackTrafficBytesAllIface;
                this.mTotalBackPacketAllInterface += this.mBackTrafficPacketsAllIface;
                this.mTotalBackTrafficBytes += this.mBackTrafficBytes;
                this.mTotalBackTrafficPackets += this.mBackTrafficPackets;
            }
        }
        return jSONObject;
    }
}
