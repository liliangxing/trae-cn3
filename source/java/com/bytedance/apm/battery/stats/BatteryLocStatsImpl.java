package com.bytedance.apm.battery.stats;

import android.text.TextUtils;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.hook.IHookService;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.battery.stats.info.LocInfo;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.ExceptionLogData;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.perf.CommonDataAssembly;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryLocStatsImpl extends AbsBatteryTimeStats<LocInfo> implements IHookService {
    private List<String> mListenerRecord;

    @Override // com.bytedance.apm.battery.hook.IHookService
    public String getInterfaceName() {
        return "android.location.ILocationManager";
    }

    public BatteryLocStatsImpl() {
        super(BatteryTypeInf.BATTERY_LOC_API);
        this.mListenerRecord = new ArrayList();
    }

    @Override // com.bytedance.apm.battery.hook.IHookService
    public void invoke(Object obj, Method method, Object[] objArr) {
        try {
            String name = method.getName();
            if (TextUtils.equals(name, "requestLocationUpdates")) {
                parseRequestArgs(objArr);
            } else if (TextUtils.equals(name, "registerLocationListener")) {
                parseRequestArgsAbove12(objArr);
            } else if (TextUtils.equals(name, "removeUpdates") || TextUtils.equals(name, "unregisterLocationListener")) {
                parseRemoveArgs(objArr);
            }
        } catch (Exception unused) {
        }
    }

    private void parseRequestArgs(Object[] objArr) {
        Object obj;
        if (objArr[0] == null || (obj = objArr[1]) == null) {
            return;
        }
        recordRequest(obj.hashCode(), objArr[0].toString());
    }

    private void parseRequestArgsAbove12(Object[] objArr) {
        Object obj;
        if (objArr[1] == null || (obj = objArr[2]) == null) {
            return;
        }
        recordRequest(obj.hashCode(), objArr[1].toString());
    }

    private void recordRequest(int i, String str) {
        String valueOf = String.valueOf(i);
        if (!this.mListenerRecord.contains(valueOf)) {
            addHolderCount();
            this.mListenerRecord.add(valueOf);
        }
        if (BatteryCollector.getInstance().isEnableTrace()) {
            LocInfo locInfo = (LocInfo) this.mDetectMap.get(Integer.valueOf(i));
            if (locInfo == null) {
                locInfo = new LocInfo();
                locInfo.request = str;
            }
            locInfo.startTime = System.currentTimeMillis();
            locInfo.endTime = -1L;
            locInfo.elements = Thread.currentThread().getStackTrace();
            locInfo.threadName = Thread.currentThread().getName();
            this.mDetectMap.put(Integer.valueOf(i), locInfo);
        }
    }

    private void parseRemoveArgs(Object[] objArr) {
        LocInfo locInfo;
        Object obj = objArr[0];
        if (obj != null) {
            int hashCode = obj.hashCode();
            String valueOf = String.valueOf(hashCode);
            if (this.mListenerRecord.contains(valueOf)) {
                reduceHolderCount();
                this.mListenerRecord.remove(valueOf);
            }
            if (!BatteryCollector.getInstance().isEnableTrace() || (locInfo = (LocInfo) this.mDetectMap.get(Integer.valueOf(hashCode))) == null) {
                return;
            }
            locInfo.endTime = System.currentTimeMillis();
            this.mDetectMap.put(Integer.valueOf(hashCode), locInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    public void reportSingleIssue(LocInfo locInfo, long j) {
        if (j < BatteryDetectConfig.getMaxSingleLocRequestTimeMs()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Constants.BATTERY_ISSUE_TYPE, 32).put("single_hold_time", j);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(locInfo.toJson());
            jSONObject.put("detail", jSONArray);
            CommonDataAssembly.wrapPerfException(jSONObject, "battery_trace");
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryTimeStats
    void reportAccumulatedIssue(double d, double d2) {
        int i = d >= ((double) BatteryDetectConfig.getMaxTotalLocRequestTimeMs()) ? 33 : 0;
        if (d2 >= BatteryDetectConfig.getMaxTotalLocRequestCount()) {
            i |= 34;
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
                    jSONArray.put(((LocInfo) it.next()).toJson());
                }
                jSONObject.put("detail", jSONArray);
            }
            CommonDataAssembly.wrapPerfException(jSONObject, "battery_trace");
            CommonDataPipeline.getInstance().handle(new ExceptionLogData("battery_trace", jSONObject));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (getType().equals(batteryLogEntity.type)) {
            if (batteryLogEntity.isFront()) {
                batteryStatsRet.addFrontLocMs(batteryLogEntity.getAccumulation());
            } else {
                batteryStatsRet.addBackLocMs(batteryLogEntity.getAccumulation());
            }
        }
    }
}
