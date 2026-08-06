package com.bytedance.watson.assist.core;

import android.content.Context;
import com.bytedance.watson.assist.api.AssistConfig;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.abnormal.AbnormalManager;
import com.bytedance.watson.assist.core.battery.BatteryInfoManager;
import com.bytedance.watson.assist.core.cpu.CpuInfoManager;
import com.bytedance.watson.assist.core.cpu.ThreadStatInfo;
import com.bytedance.watson.assist.core.thermal.ThermalInfoManager;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AssistStatImp implements IAssistStat {
    private static volatile AssistStatImp mInstance;
    private AbnormalManager mAbnormalManager;
    private BatteryInfoManager mBatteryInfoManager;
    private AssistConfig mConfig;
    private Context mContext;
    private CpuInfoManager mCpuInfoManager;
    private ThermalInfoManager mThermalInfoManager;

    private AssistStatImp(Context context) {
        this(context, AssistConfig.DEFAULT);
    }

    private AssistStatImp(Context context, AssistConfig assistConfig) {
        this.mContext = context.getApplicationContext();
        this.mConfig = assistConfig == null ? AssistConfig.DEFAULT : assistConfig;
        this.mBatteryInfoManager = new BatteryInfoManager(this.mContext, this);
        this.mThermalInfoManager = new ThermalInfoManager(this.mContext, this);
        this.mCpuInfoManager = new CpuInfoManager(this.mContext, this);
        this.mAbnormalManager = new AbnormalManager(this);
        DebugLog.m30i("new assist obj:" + this + " config : " + assistConfig);
    }

    public static AssistStatImp getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AssistStatImp.class) {
                if (mInstance == null) {
                    mInstance = new AssistStatImp(context);
                }
            }
        }
        return mInstance;
    }

    public static AssistStatImp createNewInstance(Context context, AssistConfig assistConfig) {
        return new AssistStatImp(context, assistConfig);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat start() {
        DebugLog.m26d("start, obj:" + this);
        this.mBatteryInfoManager.start();
        this.mThermalInfoManager.start();
        this.mCpuInfoManager.start();
        return this;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void end() {
        DebugLog.m26d("end, obj:" + this);
        this.mBatteryInfoManager.end();
        this.mThermalInfoManager.end();
        this.mCpuInfoManager.end();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public AssistConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void updateConfig(AssistConfig assistConfig) {
        if (assistConfig != null) {
            this.mConfig = assistConfig;
            DebugLog.m30i("update config : " + assistConfig + ", obj:" + this);
        }
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardware() {
        return CpuUtils.getCpuHardware();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardwareFromProp() {
        return CpuUtils.getCpuHardwareFromProp();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getSystemCpuUsage() {
        return this.mCpuInfoManager.getSystemCpuUsage();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuUsage() {
        return this.mCpuInfoManager.getProcCpuUsage();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuSpeed() {
        return this.mCpuInfoManager.getProcCpuSpeed();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuSpeed(int i) {
        return this.mCpuInfoManager.getThreadCpuSpeed(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuUsage(int i) {
        return this.mCpuInfoManager.getThreadCpuUsage(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail() {
        return this.mCpuInfoManager.getProcCpuTimeDetail();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int i) {
        return this.mCpuInfoManager.getThreadCpuTimeDetail(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail() {
        return this.mCpuInfoManager.getSystemCpuTimeFreqDetail();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getProcessCpuTimeFreqPercent() {
        return this.mCpuInfoManager.getProcessCpuTimeFreqPercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getThreadCpuTimeFreqPercent(int i) {
        return this.mCpuInfoManager.getThreadCpuTimeFreqPercent(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getSystemCpuTimeFreqPercent() {
        return this.mCpuInfoManager.getSystemCpuTimeFreqPercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getProcessCpuTimePercent() {
        return this.mCpuInfoManager.getProcessCpuTimePercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getThreadCpuTimePercent(int i) {
        return this.mCpuInfoManager.getThreadCpuTimePercent(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getSystemCpuTimePercent() {
        return this.mCpuInfoManager.getSystemCpuTimePercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public ThreadStatInfo getThreadCpuStatInfo(int i) {
        return this.mCpuInfoManager.getThreadCpuStatInfo(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<IAssistStat.CpuClusterFreqInfo> getCurrentCpuClusterFreqInfo() {
        List<CpuUtils.CpuClusterInfo> cpuClusterInfoList = CpuUtils.getCpuClusterInfoList();
        if (cpuClusterInfoList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = cpuClusterInfoList.size();
        for (int i = 0; i < size; i++) {
            CpuUtils.CpuClusterInfo cpuClusterInfo = cpuClusterInfoList.get(i);
            IAssistStat.CpuClusterFreqInfo cpuClusterFreqInfo = new IAssistStat.CpuClusterFreqInfo();
            cpuClusterFreqInfo.name = cpuClusterInfo.getName();
            cpuClusterFreqInfo.affectedCpuList = cpuClusterInfo.getAffectedCpuList();
            cpuClusterFreqInfo.freqList = cpuClusterInfo.getFreqList();
            cpuClusterFreqInfo.scalingMinFreq = CpuUtils.getClusterMaxFreq(i);
            cpuClusterFreqInfo.scalingCurFreq = CpuUtils.getClusterCurrentFreq(i);
            cpuClusterFreqInfo.scalingMaxFreq = CpuUtils.getClusterMaxFreq(i);
            if (cpuClusterFreqInfo.scalingMinFreq != -1 && cpuClusterFreqInfo.scalingMaxFreq != -1 && cpuClusterFreqInfo.scalingMinFreq == cpuClusterFreqInfo.scalingMaxFreq) {
                cpuClusterFreqInfo.isLockFreq = true;
            }
            cpuClusterFreqInfo.scalingMinFreqLevel = CpuUtils.getFreqLevel(i, cpuClusterFreqInfo.scalingMinFreq);
            cpuClusterFreqInfo.scalingCurFreqLevel = CpuUtils.getFreqLevel(i, cpuClusterFreqInfo.scalingCurFreq);
            cpuClusterFreqInfo.scalingMaxFreqLevel = CpuUtils.getFreqLevel(i, cpuClusterFreqInfo.scalingMaxFreq);
            arrayList.add(cpuClusterFreqInfo);
        }
        return arrayList;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<ThreadStatInfo> getSortedThreadStatInfoList() {
        return this.mCpuInfoManager.getSortedThreadStatInfoList();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<ThreadStatInfo> getTopThreadCpuStatInfoList(int i) {
        return this.mCpuInfoManager.getTopThreadCpuStatInfoList(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCharging() {
        return this.mBatteryInfoManager.isCharging();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int isPowerSaveMode() {
        return this.mBatteryInfoManager.isPowerSaveMode();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getBatteryLevel() {
        return this.mBatteryInfoManager.getBatteryLevel();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public float getBatteryTemperature() {
        return this.mBatteryInfoManager.getBatteryTemperature();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getCurrentThermalStatus() {
        return this.mThermalInfoManager.getCurrentThermalStatus();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void refreshCpuStat() {
        this.mCpuInfoManager.refresh();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuSampleEnvironment() {
        return this.mAbnormalManager.isCpuSampleEnvironment();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess(float f) {
        return this.mAbnormalManager.isAbnormalProcess(f);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess() {
        return this.mAbnormalManager.isAbnormalProcess();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalThread(int i) {
        return this.mAbnormalManager.isAbnormalThread(i);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuFactorTag getCpuFactorTag() {
        IAssistStat.CpuFactorTag cpuFactorTag = new IAssistStat.CpuFactorTag();
        cpuFactorTag.cpuHardware = getCpuHardwareFromProp();
        cpuFactorTag.isCharging = isCharging();
        cpuFactorTag.batteryLevel = getBatteryLevel();
        cpuFactorTag.thermalStatus = getCurrentThermalStatus();
        cpuFactorTag.powerSaveMode = isPowerSaveMode();
        cpuFactorTag.batteryThermal = getBatteryTemperature();
        cpuFactorTag.processCpuTimeFreqPercent = getProcessCpuTimeFreqPercent();
        return cpuFactorTag;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test(int i) {
        test();
        DebugLog.m26d("get thread cpu usage :" + getThreadCpuUsage(i));
        DebugLog.m26d("get thread cpu time detail :" + getThreadCpuTimeDetail(i));
        DebugLog.m26d("get thread cpu time percent :" + getThreadCpuTimeFreqPercent(i));
        DebugLog.m26d("get thread stat :" + getThreadCpuStatInfo(i));
        DebugLog.m26d("get TopN thread stat :" + getTopThreadCpuStatInfoList(i));
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test() {
        refreshCpuStat();
        StringBuilder sb = new StringBuilder();
        sb.append(" get cpu hardware:" + getCpuHardware()).append("\n get cpu cur freq : " + CpuUtils.getClusterCurrentFreq(0)).append("\n get cpu max freq: " + CpuUtils.getClusterMaxFreq(0)).append("\n get cpu min freq: " + CpuUtils.getClusterMinFreq(0)).append("\n get process cpu usage : " + getProcCpuUsage()).append("\n get process cpu speed : " + getProcCpuSpeed()).append("\n get cluster info list : " + CpuUtils.getCpuClusterInfoList()).append("\n get cpu scaling max : " + CpuUtils.getClusterMaxFreq(1)).append("\n get cpu scaling max level: " + CpuUtils.getClusterMaxFreqLevel(1)).append("\n get process cpu time percent : " + getProcessCpuTimePercent()).append("\n getThreadInfoList:" + getSortedThreadStatInfoList()).append("\n getSystemCpuTimeFreqDetail:" + getSystemCpuTimeFreqDetail()).append("\n getSystemCpuTimeFreqPercent:" + getSystemCpuTimeFreqPercent()).append("\n getSystemCpuTimePercent:" + getSystemCpuTimePercent()).append("\n getSystemCpuUsage:" + getSystemCpuUsage()).append("\n getCurrentCpuClusterFreqInfo:" + getCurrentCpuClusterFreqInfo());
        DebugLog.m30i(sb.toString());
        DebugLog.toast(this.mContext, sb.toString());
    }
}
