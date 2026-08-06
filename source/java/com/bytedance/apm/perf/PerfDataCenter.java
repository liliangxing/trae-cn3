package com.bytedance.apm.perf;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.perf.ICpuDataService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PerfDataCenter {
    private static volatile PerfDataCenter singleton;

    private PerfDataCenter() {
    }

    public static PerfDataCenter getInstance() {
        if (singleton == null) {
            synchronized (PerfDataCenter.class) {
                if (singleton == null) {
                    singleton = new PerfDataCenter();
                }
            }
        }
        return singleton;
    }

    public JSONObject getCpuInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            ICpuDataService iCpuDataService = (ICpuDataService) ServiceManager.getService(ICpuDataService.class);
            jSONObject.put(PerfConsts.PERF_CPU_PROCESS_USAGE, iCpuDataService.getCpuRate());
            jSONObject.put(PerfConsts.PERF_CPU_STAT_SPEED, iCpuDataService.getCpuSpeed());
            return jSONObject;
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
