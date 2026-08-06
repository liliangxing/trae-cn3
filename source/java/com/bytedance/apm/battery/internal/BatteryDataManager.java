package com.bytedance.apm.battery.internal;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.battery.dao.tmp.BatteryTmpLogDao;
import com.bytedance.apm.battery.stats.IBatteryStats;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.CommonMonitorUtil;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.bdturing.EventReport;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryDataManager {
    private static final String TAG = "BatteryData";
    private BatteryTmpLogDao mBatteryLogManager;
    private String mCurrentActivityName;
    private String mStartUUID;

    private BatteryDataManager() {
        this.mCurrentActivityName = "";
    }

    public static BatteryDataManager getInstance() {
        return Holder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        private static final BatteryDataManager sInstance = new BatteryDataManager();

        private Holder() {
        }
    }

    public void setCurrentActivityName(String str) {
        this.mCurrentActivityName = str;
    }

    public String getCurrentActivityName() {
        return this.mCurrentActivityName;
    }

    public void record(BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity == null) {
            return;
        }
        handleRecord(batteryLogEntity);
    }

    public void handleReportAndHandleCache(boolean z) {
        if (z) {
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.battery.internal.BatteryDataManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        BatteryDataManager.this.reportLastTimeBattery();
                    } catch (Throwable th) {
                        EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");
                    }
                }
            });
            return;
        }
        try {
            reportLastTimeBattery();
        } catch (Throwable th) {
            EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");
        }
    }

    private void handleRecord(BatteryLogEntity batteryLogEntity) {
        if (TextUtils.isEmpty(this.mStartUUID)) {
            this.mStartUUID = String.valueOf(System.currentTimeMillis());
        }
        batteryLogEntity.setMainProcess(ApmContext.isMainProcess());
        batteryLogEntity.setProcessName(ApmContext.getCurrentProcessName());
        batteryLogEntity.setStartUuid(this.mStartUUID);
        String str = batteryLogEntity.isFront() ? this.mCurrentActivityName : EventReport.DIALOG_BACKGROUND;
        if (!TextUtils.isEmpty(batteryLogEntity.getScene())) {
            str = batteryLogEntity.getScene() + "#" + str;
        }
        batteryLogEntity.setScene(str);
        handleChargingStatus(batteryLogEntity);
        saveBatteryLog(batteryLogEntity);
    }

    private void handleChargingStatus(BatteryLogEntity batteryLogEntity) {
        if (Build.VERSION.SDK_INT < 34 || batteryLogEntity.isFront()) {
            return;
        }
        batteryLogEntity.setStatus(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportLastTimeBattery() {
        if (ApmContext.isMainProcess()) {
            BatteryStatsRet batteryStatsRet = new BatteryStatsRet();
            List<BatteryLogEntity> batteryLog = getBatteryLog(true, 0L);
            if (ListUtils.isEmpty(batteryLog)) {
                return;
            }
            boolean divideBySceneAndReport = divideBySceneAndReport(batteryStatsRet, batteryLog);
            batteryStatsRet.isProcessOver();
            BatteryLogEntity batteryLogEntity = batteryLog.get(batteryLog.size() - 1);
            long id = batteryLogEntity.getId();
            long time = batteryLogEntity.getTime();
            if (!divideBySceneAndReport) {
                if (ApmContext.isDebugMode()) {
                    Logger.m90w(DebugLogger.TAG_BATTERY, "report main process data failed, clean data and stop calc data of other process");
                }
                cleanBatteryLog(id);
                return;
            }
            if (ApmContext.isDebugMode()) {
                Logger.m88i(DebugLogger.TAG_BATTERY, "report main process data over, begin handle other process data");
            }
            List<BatteryLogEntity> batteryLog2 = getBatteryLog(false, time);
            HashMap hashMap = new HashMap(4);
            for (BatteryLogEntity batteryLogEntity2 : batteryLog2) {
                String processName = batteryLogEntity2.getProcessName();
                List list = (List) hashMap.get(processName);
                if (list != null) {
                    list.add(batteryLogEntity2);
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(batteryLogEntity2);
                    hashMap.put(processName, linkedList);
                }
            }
            try {
                Iterator it = hashMap.values().iterator();
                while (it.hasNext()) {
                    divideBySceneAndReport(batteryStatsRet, (List) it.next());
                    batteryStatsRet.isProcessOver();
                }
            } catch (Exception e) {
                EnsureManager.ensureNotReachHere(e, "reportLastTimeBattery");
            }
            batteryStatsRet.reportOverallData();
            cleanBatteryLog(id);
            ApmAlogHelper.m77i(Constants.TAG_BATTERY, "Report Data All Success");
        }
    }

    private boolean divideBySceneAndReport(BatteryStatsRet batteryStatsRet, List<BatteryLogEntity> list) {
        HashMap hashMap = new HashMap(4);
        for (BatteryLogEntity batteryLogEntity : list) {
            String scene = batteryLogEntity.getScene();
            List list2 = (List) hashMap.get(scene);
            if (list2 != null) {
                list2.add(batteryLogEntity);
            } else {
                LinkedList linkedList = new LinkedList();
                linkedList.add(batteryLogEntity);
                hashMap.put(scene, linkedList);
            }
        }
        try {
            Iterator it = hashMap.values().iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (!divideByChargingStatusAndReport(batteryStatsRet, (List) it.next())) {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            EnsureManager.ensureNotReachHere(e, "divideBySceneAndReport");
            return false;
        }
    }

    private boolean divideByChargingStatusAndReport(BatteryStatsRet batteryStatsRet, List<BatteryLogEntity> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BatteryLogEntity batteryLogEntity : list) {
            if (batteryLogEntity.isOn()) {
                arrayList.add(batteryLogEntity);
            } else {
                arrayList2.add(batteryLogEntity);
            }
        }
        try {
            boolean z = arrayList.isEmpty() || report(batteryStatsRet, arrayList);
            if (!arrayList2.isEmpty()) {
                if (!report(batteryStatsRet, arrayList2)) {
                    return false;
                }
            }
            return z;
        } catch (Exception e) {
            EnsureManager.ensureNotReachHere(e, "divideByChargingStatusAndReport");
            return false;
        }
    }

    private boolean report(BatteryStatsRet batteryStatsRet, List<BatteryLogEntity> list) throws Exception {
        Map<String, IBatteryStats> batteryStatsMap = BatteryCollector.getInstance().getBatteryStatsMap();
        StringBuilder sb = new StringBuilder();
        String str = null;
        for (BatteryLogEntity batteryLogEntity : list) {
            if (str == null || !str.equals(batteryLogEntity.getStartUuid())) {
                str = batteryLogEntity.getStartUuid();
                sb.append(str);
            }
            if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(batteryLogEntity.type)) {
                if (batteryLogEntity.isFront()) {
                    batteryStatsRet.addFrontDuration(batteryLogEntity.getAccumulation());
                } else {
                    batteryStatsRet.addBackDuration(batteryLogEntity.getAccumulation());
                }
            } else {
                IBatteryStats iBatteryStats = batteryStatsMap.get(batteryLogEntity.type);
                if (iBatteryStats != null) {
                    iBatteryStats.updateStatsRet(batteryStatsRet, batteryLogEntity);
                }
            }
        }
        BatteryLogEntity batteryLogEntity2 = list.get(0);
        batteryStatsRet.setMainProcess(batteryLogEntity2.isMainProcess());
        batteryStatsRet.setProcessName(batteryLogEntity2.getProcessName());
        batteryStatsRet.setStartUUID(sb.toString());
        batteryStatsRet.setScene(batteryLogEntity2.getScene());
        batteryStatsRet.setIsCharging(batteryLogEntity2.isOn());
        ApmAlogHelper.m77i(Constants.TAG_BATTERY, "Report Data proc:" + batteryLogEntity2.getProcessName() + " scene:" + batteryLogEntity2.getScene() + " size:" + list.size());
        return batteryStatsRet.report(true);
    }

    private void saveBatteryLog(BatteryLogEntity batteryLogEntity) {
        try {
            if (ApmContext.isDebugMode()) {
                Logger.m88i(DebugLogger.TAG_BATTERY, "saveBatteryLog into db: " + batteryLogEntity);
            }
            ApmAlogHelper.m77i(Constants.TAG_BATTERY_LOCAL, transToLocalRecordData(batteryLogEntity));
            getBatteryLogManager().saveLog(batteryLogEntity);
        } catch (Exception e) {
            EnsureManager.ensureNotReachHere(e, "saveBatteryLog");
        }
    }

    private String transToLocalRecordData(BatteryLogEntity batteryLogEntity) throws JSONException {
        JSONObject simpleJson = batteryLogEntity.simpleJson();
        if (TextUtils.equals(batteryLogEntity.getType(), BatteryTypeInf.BATTERY_CPU_ACTIVE)) {
            simpleJson.put(DBHelper.BATTERY_COL_ACCUMULATION, (batteryLogEntity.getAccumulation() * 1000) / CommonMonitorUtil.getScClkTck(100L));
        } else if (TextUtils.equals(batteryLogEntity.getType(), "traffic")) {
            simpleJson.put(DBHelper.BATTERY_COL_ACCUMULATION, batteryLogEntity.getAccumulation() / 1024);
        } else {
            simpleJson.put(DBHelper.BATTERY_COL_ACCUMULATION, batteryLogEntity.getAccumulation());
        }
        return simpleJson.toString();
    }

    private List<BatteryLogEntity> getBatteryLog(boolean z, long j) {
        try {
            return getBatteryLogManager().getLogs(z, j);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    private void cleanBatteryLog(long j) {
        try {
            getBatteryLogManager().updateDeleteFlag(j);
        } catch (Exception e) {
            EnsureManager.ensureNotReachHere(e, "cleanBatteryLog");
        }
    }

    private BatteryTmpLogDao getBatteryLogManager() {
        if (this.mBatteryLogManager == null) {
            this.mBatteryLogManager = BatteryTmpLogDao.getInstance();
        }
        return this.mBatteryLogManager;
    }

    public JSONObject getMainThreadBatteryData() {
        JSONObject jSONObject = new JSONObject();
        List<BatteryLogEntity> batteryLog = getBatteryLog(true, 0L);
        if (ListUtils.isEmpty(batteryLog)) {
            return jSONObject;
        }
        BatteryStatsRet batteryStatsRet = new BatteryStatsRet();
        if (setupBatteryStats(batteryStatsRet, batteryLog)) {
            try {
                JSONObject computeAndReturnJSONObject = batteryStatsRet.computeAndReturnJSONObject(true);
                if (computeAndReturnJSONObject != null) {
                    return computeAndReturnJSONObject;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private boolean setupBatteryStats(BatteryStatsRet batteryStatsRet, List<BatteryLogEntity> list) {
        Map<String, IBatteryStats> batteryStatsMap = BatteryCollector.getInstance().getBatteryStatsMap();
        StringBuilder sb = new StringBuilder();
        String str = null;
        for (BatteryLogEntity batteryLogEntity : list) {
            if (str == null || !str.equals(batteryLogEntity.getStartUuid())) {
                str = batteryLogEntity.getStartUuid();
                sb.append(str);
            }
            if (BatteryTypeInf.BATTERY_GROUND_RECORD.equals(batteryLogEntity.type)) {
                if (batteryLogEntity.isFront()) {
                    batteryStatsRet.addFrontDuration(batteryLogEntity.getAccumulation());
                } else {
                    batteryStatsRet.addBackDuration(batteryLogEntity.getAccumulation());
                }
            } else {
                IBatteryStats iBatteryStats = batteryStatsMap.get(batteryLogEntity.type);
                if (iBatteryStats != null) {
                    iBatteryStats.updateStatsRet(batteryStatsRet, batteryLogEntity);
                }
            }
        }
        BatteryLogEntity batteryLogEntity2 = list.get(0);
        batteryStatsRet.setMainProcess(batteryLogEntity2.isMainProcess());
        batteryStatsRet.setProcessName(batteryLogEntity2.getProcessName());
        batteryStatsRet.setStartUUID(sb.toString());
        return true;
    }
}
