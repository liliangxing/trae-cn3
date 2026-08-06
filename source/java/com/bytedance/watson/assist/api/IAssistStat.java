package com.bytedance.watson.assist.api;

import com.bytedance.watson.assist.core.cpu.ThreadStatInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public interface IAssistStat {
    public static final int CPU_FREQ_LEVEL_HIGH = 3;
    public static final int CPU_FREQ_LEVEL_LOW = 0;
    public static final int CPU_FREQ_LEVEL_LOW_MID = 1;
    public static final int CPU_FREQ_LEVEL_MAX = 4;
    public static final int CPU_FREQ_LEVEL_MID_HIGH = 2;
    public static final int POWERSAVE_CLOSE = 0;
    public static final int POWERSAVE_OPEN = 1;
    public static final int POWERSAVE_UNKNOW = -1;

    /* loaded from: classes6.dex */
    public static class CpuFactorTag {
        public int batteryLevel;
        public float batteryThermal;
        public String cpuHardware;
        public boolean isCharging;
        public int powerSaveMode;
        public List<List<Integer>> processCpuTimeFreqPercent;
        public int thermalStatus;
    }

    void end();

    int getBatteryLevel();

    float getBatteryTemperature();

    AssistConfig getConfig();

    CpuFactorTag getCpuFactorTag();

    String getCpuHardware();

    String getCpuHardwareFromProp();

    List<CpuClusterFreqInfo> getCurrentCpuClusterFreqInfo();

    int getCurrentThermalStatus();

    double getProcCpuSpeed();

    List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail();

    double getProcCpuUsage();

    List<List<Integer>> getProcessCpuTimeFreqPercent();

    CpuTimePercent getProcessCpuTimePercent();

    List<ThreadStatInfo> getSortedThreadStatInfoList();

    List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail();

    List<List<Integer>> getSystemCpuTimeFreqPercent();

    CpuTimePercent getSystemCpuTimePercent();

    double getSystemCpuUsage();

    double getThreadCpuSpeed(int i);

    ThreadStatInfo getThreadCpuStatInfo(int i);

    List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int i);

    List<List<Integer>> getThreadCpuTimeFreqPercent(int i);

    CpuTimePercent getThreadCpuTimePercent(int i);

    double getThreadCpuUsage(int i);

    List<ThreadStatInfo> getTopThreadCpuStatInfoList(int i);

    boolean isCharging();

    boolean isCpuAbnormalProcess();

    boolean isCpuAbnormalProcess(float f);

    boolean isCpuAbnormalThread(int i);

    boolean isCpuSampleEnvironment();

    int isPowerSaveMode();

    void refreshCpuStat();

    IAssistStat start();

    void test();

    void test(int i);

    void updateConfig(AssistConfig assistConfig);

    /* loaded from: classes6.dex */
    public static class CpuTimePercent {
        public float bigCoreHigh;
        public float bigCoreLow;
        public float bigCoreMidHigh;
        public float bigCoreMidLow;
        public float bigCoreSum;
        public float middleCoreHigh;
        public float middleCoreLow;
        public float middleCoreMidHigh;
        public float middleCoreMidLow;
        public float middleCoreSum;
        public float smallCoreHigh;
        public float smallCoreLow;
        public float smallCoreMidHigh;
        public float smallCoreMidLow;
        public float smallCoreSum;

        public String toString() {
            return "CpuTimePercent{smallCoreLow=" + this.smallCoreLow + ", smallCoreMidLow=" + this.smallCoreMidLow + ", smallCoreMidHigh=" + this.smallCoreMidHigh + ", smallCoreHigh=" + this.smallCoreHigh + ", smallCoreSum=" + this.smallCoreSum + ", middleCoreLow=" + this.middleCoreLow + ", middleCoreMidLow=" + this.middleCoreMidLow + ", middleCoreMidHigh=" + this.middleCoreMidHigh + ", middleCoreHigh=" + this.middleCoreHigh + ", middleCoreSum=" + this.middleCoreSum + ", bigCoreLow=" + this.bigCoreLow + ", bigCoreMidLow=" + this.bigCoreMidLow + ", bigCoreMidHigh=" + this.bigCoreMidHigh + ", bigCoreHigh=" + this.bigCoreHigh + ", bigCoreSum=" + this.bigCoreSum + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* loaded from: classes6.dex */
    public static class CpuClusterFreqInfo {
        public List<Integer> affectedCpuList = new ArrayList();
        public List<Long> freqList = new ArrayList();
        public boolean isLockFreq = false;
        public String name;
        public long scalingCurFreq;
        public int scalingCurFreqLevel;
        public long scalingMaxFreq;
        public int scalingMaxFreqLevel;
        public long scalingMinFreq;
        public int scalingMinFreqLevel;

        public String toString() {
            return "CpuClusterFreqInfo{name='" + this.name + "', affectedCpuList=" + this.affectedCpuList + ", freqList=" + this.freqList + ", isLockFreq=" + this.isLockFreq + ", scalingMinFreq=" + this.scalingMinFreq + ", scalingCurFreq=" + this.scalingCurFreq + ", scalingMaxFreq=" + this.scalingMaxFreq + ", scalingMinFreqLevel=" + this.scalingMinFreqLevel + ", scalingCurFreqLevel=" + this.scalingCurFreqLevel + ", scalingMaxFreqLevel=" + this.scalingMaxFreqLevel + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
