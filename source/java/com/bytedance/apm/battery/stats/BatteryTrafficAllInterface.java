package com.bytedance.apm.battery.stats;

import android.app.usage.NetworkStatsManager;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryTrafficAllInterface extends AbsBatteryValueStats {
    private final String SOURCE_BYTES;
    private final String SOURCE_PACKETS;
    private boolean hasReportedCustomException;
    private Method mGetDataLayerMethod;
    private long[] mLastNetInfo;
    private Object mServiceInstance;

    public BatteryTrafficAllInterface() {
        super(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE);
        this.SOURCE_BYTES = "source_bytes";
        this.SOURCE_PACKETS = "source_packets";
        this.hasReportedCustomException = false;
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean z, boolean z2) {
        if (isMainProcess()) {
            try {
                long[] trafficData = getTrafficData();
                if (this.mLastNetInfo != null && z2) {
                    String curSceneSetStr = BatteryCollector.getInstance().getCurSceneSetStr();
                    saveNetInfo(z, trafficData[0] - this.mLastNetInfo[0], "source_bytes", curSceneSetStr);
                    saveNetInfo(z, trafficData[1] - this.mLastNetInfo[1], "source_packets", curSceneSetStr);
                }
                this.mLastNetInfo = trafficData;
            } catch (Throwable th) {
                if (ApmContext.isDebugMode()) {
                    Logger.m88i(DebugLogger.TAG_BATTERY, "handleTrafficMonitor error: " + th.getCause());
                }
                if (this.hasReportedCustomException) {
                    return;
                }
                EnsureManager.ensureNotReachHere(th, "BatteryTrafficAllInterface");
                this.hasReportedCustomException = true;
            }
        }
    }

    private void saveNetInfo(boolean z, long j, String str, String str2) {
        if (j < 0) {
            if (ApmContext.isDebugMode()) {
                Logger.m88i(DebugLogger.TAG_BATTERY, "BatteryTrafficAllInterface value error: " + j);
            }
            ApmAlogHelper.m77i(Constants.TAG_BATTERY, "BatteryTrafficAllInterface value error: " + j);
            return;
        }
        BatteryDataManager.getInstance().record(new BatteryLogEntity(z, System.currentTimeMillis(), BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, this.mIsCharging, j, str2, str));
    }

    private long[] getTrafficData() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (this.mGetDataLayerMethod == null) {
            NetworkStatsManager networkStatsManager = (NetworkStatsManager) ApmContext.getContext().getSystemService("netstats");
            Field declaredField = networkStatsManager.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(networkStatsManager);
            this.mServiceInstance = obj;
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            int length = declaredMethods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Method method = declaredMethods[i];
                if (TextUtils.equals("getDataLayerSnapshotForUid", method.getName())) {
                    this.mGetDataLayerMethod = method;
                    method.setAccessible(true);
                    break;
                }
                i++;
            }
        }
        Object invoke = this.mGetDataLayerMethod.invoke(this.mServiceInstance, Integer.valueOf(Process.myUid()));
        Field declaredField2 = invoke.getClass().getDeclaredField("rxBytes");
        declaredField2.setAccessible(true);
        long[] jArr = (long[]) declaredField2.get(invoke);
        Field declaredField3 = invoke.getClass().getDeclaredField("txBytes");
        declaredField3.setAccessible(true);
        long[] jArr2 = (long[]) declaredField3.get(invoke);
        Field declaredField4 = invoke.getClass().getDeclaredField("rxPackets");
        declaredField4.setAccessible(true);
        long[] jArr3 = (long[]) declaredField4.get(invoke);
        Field declaredField5 = invoke.getClass().getDeclaredField("txPackets");
        declaredField5.setAccessible(true);
        return new long[]{sum(jArr) + sum(jArr2), sum(jArr3) + sum((long[]) declaredField5.get(invoke))};
    }

    private long sum(long[] jArr) {
        long j = 0;
        if (jArr != null && jArr.length != 0) {
            for (long j2 : jArr) {
                j += j2;
            }
        }
        return j;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet batteryStatsRet, BatteryLogEntity batteryLogEntity) {
        if (batteryLogEntity.isFront()) {
            if (TextUtils.equals(batteryLogEntity.getSource(), "source_bytes")) {
                batteryStatsRet.addFrontBytesAllInterface(batteryLogEntity.getAccumulation());
                return;
            } else {
                if (TextUtils.equals(batteryLogEntity.getSource(), "source_packets")) {
                    batteryStatsRet.addFrontPacketsAllInterface(batteryLogEntity.getAccumulation());
                    return;
                }
                return;
            }
        }
        if (TextUtils.equals(batteryLogEntity.getSource(), "source_bytes")) {
            batteryStatsRet.addBackBytesAllInterface(batteryLogEntity.getAccumulation());
        } else if (TextUtils.equals(batteryLogEntity.getSource(), "source_packets")) {
            batteryStatsRet.addBackPacketsAllInterface(batteryLogEntity.getAccumulation());
        }
    }
}
