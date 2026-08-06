package com.bytedance.apm.battery.stats;

import android.app.PendingIntent;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.AlarmInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import com.bytedance.apm.util.IntentUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryAlarmStatsImpl extends AbsHookStatsTask<AlarmInfo> implements IHookService {
    private final Object lock;
    private List<Long> mGroundChangeList;
    private int mIndex;
    private int mNormalAlarmTriggerCnt;
    private final List<Long> mTmpList;
    private int[] mWakeUpAlarmTriggerCnt;

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.app.IAlarmManager";
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String str, boolean z) {
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String str, boolean z) {
    }

    public BatteryAlarmStatsImpl() {
        super(BatteryTypeInf.BATTERY_ALARM);
        this.mGroundChangeList = new ArrayList();
        this.lock = new Object();
        this.mTmpList = new ArrayList();
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public void invoke(Object obj, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            if ("set".equals(name)) {
                parseSetAlarmArgs(objArr);
            } else if ("remove".equals(name)) {
                parseRemoveAlarmArgs(objArr);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean z) {
        super.onBack(z);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.lock) {
            this.mGroundChangeList.add(Long.valueOf(currentTimeMillis));
        }
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean z) {
        super.onFront(z);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.lock) {
            this.mGroundChangeList.add(Long.valueOf(currentTimeMillis));
        }
    }

    private void parseSetAlarmArgs(Object[] objArr) {
        AlarmInfo alarmInfo = new AlarmInfo();
        boolean z = false;
        int i = 0;
        int i2 = -1;
        for (Object obj : objArr) {
            if ((obj instanceof Integer) && !z) {
                alarmInfo.type = ((Integer) obj).intValue();
                z = true;
            } else if (obj instanceof Long) {
                if (i == 0) {
                    alarmInfo.startTime = ((Long) obj).longValue();
                    alarmInfo.startTime = alarmInfo.getUTCTriggerAtMillis();
                } else if (i == 2) {
                    alarmInfo.interval = ((Long) obj).longValue();
                }
                i++;
            } else if (obj instanceof PendingIntent) {
                PendingIntent pendingIntent = (PendingIntent) obj;
                alarmInfo.intentInfo = IntentUtils.parsePendingIntent(pendingIntent);
                i2 = pendingIntent.hashCode();
            }
        }
        if (i2 != -1) {
            alarmInfo.endTime = alarmInfo.interval == 0 ? alarmInfo.startTime : -1L;
            if (BatteryCollector.getInstance().isEnableTrace()) {
                alarmInfo.threadName = Thread.currentThread().getName();
                alarmInfo.elements = Thread.currentThread().getStackTrace();
            }
            this.mDetectMap.put(Integer.valueOf(i2), alarmInfo);
        }
    }

    private void parseRemoveAlarmArgs(Object[] objArr) {
        Object obj = objArr[0];
        int hashCode = (obj == null || !(obj instanceof PendingIntent)) ? -1 : obj.hashCode();
        AlarmInfo alarmInfo = (AlarmInfo) this.mDetectMap.get(Integer.valueOf(hashCode));
        if (alarmInfo == null || alarmInfo.interval <= 0) {
            return;
        }
        alarmInfo.endTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(hashCode), alarmInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void pollingTask(long j, long j2, boolean z) {
        this.mNormalAlarmTriggerCnt = 0;
        this.mWakeUpAlarmTriggerCnt = new int[2];
        this.mTmpList.add(Long.valueOf(j));
        synchronized (this.lock) {
            this.mTmpList.addAll(this.mGroundChangeList);
            this.mGroundChangeList.clear();
        }
        this.mTmpList.add(Long.valueOf(j2));
        this.mIndex = 1;
        while (this.mIndex < this.mTmpList.size()) {
            super.pollingTask(this.mTmpList.get(this.mIndex - 1).longValue(), this.mTmpList.get(this.mIndex).longValue(), z);
            this.mIndex++;
        }
        int[] iArr = this.mWakeUpAlarmTriggerCnt;
        if (iArr[0] + iArr[1] != 0) {
            record(iArr, this.mTmpList.size());
        }
        this.mTmpList.clear();
        reportIssue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void checkStats(AlarmInfo alarmInfo, long j, long j2) {
        int i = 1;
        if (alarmInfo.interval > 0) {
            long j3 = alarmInfo.startTime;
            if (j3 < j) {
                j3 = (alarmInfo.interval + j) - ((j - alarmInfo.startTime) % alarmInfo.interval);
            }
            long j4 = alarmInfo.endTime;
            if (j4 <= j2 && alarmInfo.endTime > 0) {
                j2 = j4;
            }
            long j5 = j2 - j3;
            if (j5 <= 0) {
                return;
            } else {
                i = 1 + ((int) (j5 / alarmInfo.interval));
            }
        } else if (j > alarmInfo.startTime || alarmInfo.startTime > j2) {
            return;
        }
        if (alarmInfo.isWakeUpAlarm()) {
            int[] iArr = this.mWakeUpAlarmTriggerCnt;
            int i2 = this.mIndex % 2;
            iArr[i2] = iArr[i2] + i;
            return;
        }
        this.mNormalAlarmTriggerCnt += i;
    }

    private void reportIssue() {
        long currentTimeMillis = System.currentTimeMillis();
        int[] iArr = this.mWakeUpAlarmTriggerCnt;
        double d = ((iArr[0] + iArr[1]) / (currentTimeMillis - this.mLastPollingTime)) * 60000.0d * 10.0d;
        double d2 = (this.mNormalAlarmTriggerCnt / (currentTimeMillis - this.mLastPollingTime)) * 60000.0d * 10.0d;
        int i = d >= ((double) BatteryDetectConfig.getMaxWakeUpAlarmInvokeCount()) ? 49 : 0;
        if (d2 >= BatteryDetectConfig.getMaxNormalAlarmInvokeCount()) {
            i |= 50;
        }
        if (i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.BATTERY_ISSUE_TYPE, i).put(Constants.KEY_WAKE_UP_COUNT, d).put(Constants.KEY_NORMAL_COUNT, d2);
            if (this.mDetectMap != null && this.mDetectMap.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.mDetectMap.values().iterator();
                while (it.hasNext()) {
                    jSONArray.put(((AlarmInfo) it.next()).toJson());
                }
                jSONObject.put("detail", jSONArray);
            }
            CommonDataAssembly.wrapPerfException(jSONObject, "battery_trace");
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", jSONObject));
        } catch (Throwable unused) {
        }
    }

    private void record(int[] iArr, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if ((this.mIsFront && i % 2 == 0) || (!this.mIsFront && i % 2 == 1)) {
            BatteryDataManager.getInstance().record(new BatteryLogEntity(false, currentTimeMillis, getType(), this.mIsCharging, iArr[0], null));
            BatteryDataManager.getInstance().record(new BatteryLogEntity(true, currentTimeMillis, getType(), this.mIsCharging, iArr[1], null));
        } else {
            BatteryDataManager.getInstance().record(new BatteryLogEntity(true, currentTimeMillis, getType(), this.mIsCharging, iArr[0], null));
            BatteryDataManager.getInstance().record(new BatteryLogEntity(false, currentTimeMillis, getType(), this.mIsCharging, iArr[1], null));
        }
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (getType().equals(batteryLogEntity.type)) {
            if (batteryLogEntity.isBack()) {
                batteryStatsRet.addBackWakeUpAlarmCount(batteryLogEntity.getAccumulation());
            } else {
                batteryStatsRet.addFrontWakeUpAlarmCount(batteryLogEntity.getAccumulation());
            }
        }
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean z, boolean z2) {
        this.mIsCharging = z;
    }
}
