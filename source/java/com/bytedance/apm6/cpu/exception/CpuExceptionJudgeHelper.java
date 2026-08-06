package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuExceptionJudgeHelper {
    private static String cacheScene;

    public static void initScene(String str) {
        cacheScene = str;
    }

    public static boolean isNeedSkipJudge() {
        return isSceneChanged();
    }

    public static boolean isForeMatchScene(CpuExceptionConfig cpuExceptionConfig) {
        if (cpuExceptionConfig.getForeSceneMaxSpeedMap().isEmpty()) {
            return false;
        }
        Iterator<String> it = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        while (it.hasNext()) {
            if (cpuExceptionConfig.getForeSceneMaxSpeedMap().containsKey(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSceneChanged() {
        cacheScene = ApmCpuManager.getInstance().getCpuSceneString();
        return false;
    }

    public static String getCacheScene() {
        return cacheScene;
    }

    public static boolean judge(CpuExceptionConfig cpuExceptionConfig, double d, boolean z) {
        double d2;
        double d3;
        if (z) {
            if (cpuExceptionConfig.getBackSceneMaxSpeedMap().isEmpty()) {
                d3 = 0.0d;
            } else {
                Iterator<String> it = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
                d3 = 0.0d;
                while (it.hasNext()) {
                    String next = it.next();
                    if (cpuExceptionConfig.getBackSceneMaxSpeedMap().containsKey(next)) {
                        double doubleValue = cpuExceptionConfig.getBackSceneMaxSpeedMap().get(next).doubleValue();
                        if (doubleValue >= 0.0d && d3 <= doubleValue) {
                            d3 = doubleValue;
                        }
                    }
                }
            }
            if (d3 <= 0.0d) {
                d3 = cpuExceptionConfig.getMaxProcessBackCpuSpeed();
            }
            return d > d3;
        }
        if (cpuExceptionConfig.getForeSceneMaxSpeedMap().isEmpty()) {
            d2 = 0.0d;
        } else {
            Iterator<String> it2 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
            d2 = 0.0d;
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (cpuExceptionConfig.getForeSceneMaxSpeedMap().containsKey(next2)) {
                    double doubleValue2 = cpuExceptionConfig.getForeSceneMaxSpeedMap().get(next2).doubleValue();
                    if (doubleValue2 >= 0.0d && d2 <= doubleValue2) {
                        d2 = doubleValue2;
                    }
                }
            }
        }
        if (d2 <= 0.0d) {
            d2 = cpuExceptionConfig.getMaxProcessForeCpuSpeed();
        }
        return d > d2;
    }
}
