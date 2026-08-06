package com.bytedance.watson.assist.core.abnormal;

import android.os.SystemClock;
import com.bytedance.watson.assist.api.AssistConfig;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.utils.DebugLog;

/* loaded from: classes6.dex */
public class AbnormalManager {
    private static final long UPDATE_TIME = 5000;
    private IAssistStat mAssistStat;
    private boolean mIsCpuSampleEnvironment = false;
    private long mLastUpdate;

    public boolean isAbnormalThread(int i) {
        return false;
    }

    public AbnormalManager(IAssistStat iAssistStat) {
        this.mAssistStat = iAssistStat;
    }

    public boolean isCpuSampleEnvironment() {
        updateCpuSampleEnvironment();
        return this.mIsCpuSampleEnvironment;
    }

    private void updateCpuSampleEnvironment() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mLastUpdate;
        if (j == 0 || elapsedRealtime - j >= 5000) {
            this.mLastUpdate = elapsedRealtime;
            float batteryTemperature = this.mAssistStat.getBatteryTemperature();
            int batteryLevel = this.mAssistStat.getBatteryLevel();
            int isPowerSaveMode = this.mAssistStat.isPowerSaveMode();
            boolean z = batteryTemperature <= ((float) this.mAssistStat.getConfig().getCpuSampleBatteryTemp());
            if (batteryLevel < this.mAssistStat.getConfig().getCpuSampleBatteryLevel()) {
                z = false;
            }
            boolean z2 = isPowerSaveMode != 1 ? z : false;
            DebugLog.i("updateCpuSampleEnvironment:" + z2 + ", temp:" + batteryTemperature + ", level:" + batteryLevel + ", powerSave:" + isPowerSaveMode);
            this.mIsCpuSampleEnvironment = z2;
        }
    }

    public boolean isAbnormalProcess() {
        return isCpuSampleEnvironment();
    }

    public boolean isAbnormalProcess(float f) {
        IAssistStat.CpuTimePercent processCpuTimePercent;
        if (!isCpuSampleEnvironment()) {
            DebugLog.i("isAbnormalProcess false, cpuSpeed " + f + ", not sample environment");
            return false;
        }
        AssistConfig.CpuAbnormalConfig cpuAbnormalConfig = this.mAssistStat.getConfig().getCpuAbnormalConfig();
        if (cpuAbnormalConfig == null) {
            DebugLog.i("isAbnormalProcess true, cpuSpeed " + f + ", configSpeed:null");
            return true;
        }
        float cpuSpeed = cpuAbnormalConfig.getCpuSpeed();
        float bigCpuCoreTimePercent = cpuAbnormalConfig.getBigCpuCoreTimePercent();
        if (f < cpuSpeed) {
            return false;
        }
        if (bigCpuCoreTimePercent > 0.0d && (processCpuTimePercent = this.mAssistStat.getProcessCpuTimePercent()) != null) {
            DebugLog.i("isAbnormalProcess true, cpuSpeed " + f + ", configSpeed:" + cpuSpeed + ", bigCorePercent:" + processCpuTimePercent.bigCoreSum + ", config bigCorePercent:" + bigCpuCoreTimePercent);
            return processCpuTimePercent.bigCoreSum > bigCpuCoreTimePercent;
        }
        DebugLog.i("isAbnormalProcess true, cpuSpeed " + f + ", configSpeed:" + cpuSpeed);
        return true;
    }
}
