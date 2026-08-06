package com.bytedance.apm.battery.stats;

import android.os.IBinder;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.WakeLockInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryWakeLockStatsImpl extends AbsBatteryTimeStats<WakeLockInfo> implements IHookService {
    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.os.IPowerManager";
    }

    public BatteryWakeLockStatsImpl() {
        super(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public synchronized void invoke(Object obj, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            if ("acquireWakeLock".equals(name)) {
                parseAcquireWakeLockArgs(objArr);
            } else if ("releaseWakeLock".equals(name)) {
                parseReleaseWakeLockArgs(objArr);
            }
        } catch (Exception unused) {
        }
    }

    private void parseAcquireWakeLockArgs(Object[] objArr) {
        Object obj;
        WakeLockInfo wakeLockInfo;
        addHolderCount();
        if (!BatteryCollector.getInstance().isEnableTrace() || objArr.length > 7 || objArr.length < 4 || (obj = objArr[0]) == null || !(obj instanceof IBinder)) {
            return;
        }
        int hashCode = obj.hashCode();
        if (!this.mDetectMap.containsKey(Integer.valueOf(hashCode))) {
            wakeLockInfo = new WakeLockInfo();
            Object obj2 = objArr[1];
            if (obj2 == null || !(obj2 instanceof Integer)) {
                return;
            }
            wakeLockInfo.flags = ((Integer) obj2).intValue();
            Object obj3 = objArr[2];
            if (obj3 == null || !(obj3 instanceof String)) {
                return;
            }
            wakeLockInfo.tag = (String) obj3;
            wakeLockInfo.endTime = -1L;
        } else {
            wakeLockInfo = (WakeLockInfo) this.mDetectMap.get(Integer.valueOf(hashCode));
            if (wakeLockInfo == null) {
                return;
            }
        }
        wakeLockInfo.elements = Thread.currentThread().getStackTrace();
        wakeLockInfo.threadName = Thread.currentThread().getName();
        wakeLockInfo.startTime = System.currentTimeMillis();
        this.mDetectMap.put(Integer.valueOf(hashCode), wakeLockInfo);
    }

    private void parseReleaseWakeLockArgs(Object[] objArr) {
        Object obj;
        reduceHolderCount();
        if (BatteryCollector.getInstance().isEnableTrace() && objArr.length == 2 && (obj = objArr[0]) != null && (obj instanceof IBinder)) {
            int hashCode = obj.hashCode();
            WakeLockInfo wakeLockInfo = (WakeLockInfo) this.mDetectMap.get(Integer.valueOf(hashCode));
            if (wakeLockInfo != null) {
                wakeLockInfo.endTime = System.currentTimeMillis();
                this.mDetectMap.put(Integer.valueOf(hashCode), wakeLockInfo);
            }
        }
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    protected void reportAccumulatedIssue(double d, double d2) {
        int i = d >= ((double) BatteryDetectConfig.getMaxTotalWakeLockHoldTimeMs()) ? 17 : 0;
        if (d2 >= BatteryDetectConfig.getMaxTotalWakeLockAcquireCount()) {
            i |= 18;
        }
        if (i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.BATTERY_ISSUE_TYPE, i).put(Constants.KEY_TOTAL_HOLD_TIME, d).put(Constants.KEY_TOTAL_ACQUIRE_COUNT, d2);
            if (this.mDetectMap != null && this.mDetectMap.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.mDetectMap.values().iterator();
                while (it.hasNext()) {
                    jSONArray.put(((WakeLockInfo) it.next()).toJson());
                }
                jSONObject.put("detail", jSONArray);
            }
            CommonDataAssembly.wrapPerfException(jSONObject, "battery_trace");
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", jSONObject));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    public void reportSingleIssue(WakeLockInfo wakeLockInfo, long j) {
        if (j < BatteryDetectConfig.getMaxSingleWakeLockHoldTimeMs()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "battery_trace");
            jSONObject.put(Constants.BATTERY_ISSUE_TYPE, 16).put("single_hold_time", j).put(Constants.KEY_WAKE_LOCK_INFO, wakeLockInfo.toString());
            CommonDataAssembly.wrapPerfException(jSONObject, "battery_trace");
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", jSONObject));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (getType().equals(batteryLogEntity.type)) {
            if (batteryLogEntity.isFront()) {
                batteryStatsRet.addFrontWakeLockMs(batteryLogEntity.getAccumulation());
            } else {
                batteryStatsRet.addBackWakeLockMs(batteryLogEntity.getAccumulation());
            }
        }
    }
}
