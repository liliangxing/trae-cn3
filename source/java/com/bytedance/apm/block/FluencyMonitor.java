package com.bytedance.apm.block;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.internal.FunctionSwitcher;
import com.bytedance.apm.npth.NpthUtil;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FluencyMonitor {
    public static final int ASCRIBE = 101;
    public static final int NORMAL = 0;
    public static final int OFFLINE = 11;
    public static final int TURNOFF = 1001;
    private static volatile FluencyMonitor sInstance;
    private int mMode = 0;

    public static int getMode(int i) {
        if (i == 11) {
            return 2;
        }
        if (i != 101) {
            return i != 1001 ? 1 : 0;
        }
        return 3;
    }

    public static FluencyMonitor getInstance() {
        if (sInstance == null) {
            synchronized (FluencyMonitor.class) {
                if (sInstance == null) {
                    sInstance = new FluencyMonitor();
                }
            }
        }
        return sInstance;
    }

    private FluencyMonitor() {
    }

    public void init() {
        NpthUtil.addNpthUserData(new NpthUtil.IGetUserData() { // from class: com.bytedance.apm.block.FluencyMonitor.1
            @Override // com.bytedance.apm.npth.NpthUtil.IGetUserData
            public Map<String, String> getUserData() {
                HashMap hashMap = new HashMap();
                JSONObject dumpInfos = PerfMonitorManager.getInstance().dumpInfos();
                Iterator<String> keys = dumpInfos.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, dumpInfos.optString(next));
                }
                HashMap hashMap2 = new HashMap();
                String evilMethod = MethodCollector.getInstance().getEvilMethod(0L, SystemClock.uptimeMillis());
                if (!TextUtils.isEmpty(evilMethod)) {
                    hashMap.put(CommonKey.KEY_EVIL_METHOD, evilMethod);
                    hashMap2.put(CommonKey.KEY_WITH_EVIL_METHOD, "true");
                } else {
                    hashMap2.put(CommonKey.KEY_WITH_EVIL_METHOD, "false");
                }
                String dumpSortedStackTrace = PerfMonitorManager.getInstance().dumpSortedStackTrace(0L, SystemClock.uptimeMillis());
                if (!TextUtils.isEmpty(dumpSortedStackTrace) && dumpSortedStackTrace.length() > 10) {
                    hashMap.put(CommonKey.KEY_STACK_TRACE, dumpSortedStackTrace);
                    hashMap2.put(CommonKey.KEY_WITH_STACK_TRACE, "true");
                } else {
                    hashMap2.put(CommonKey.KEY_WITH_STACK_TRACE, "false");
                }
                hashMap2.put(CommonKey.KEY_WITH_APM_TRACE, String.valueOf(FunctionSwitcher.getSwitch(2)));
                NpthUtil.addNpthTags(hashMap2);
                return hashMap;
            }
        });
    }

    public void onRefresh(int i, boolean z) {
        this.mMode = getMode(i);
        PerfMonitorManager.getInstance().refreshMonitorConfig(this.mMode);
    }

    public static int getMode(JSONObject jSONObject) {
        int optInt = JsonUtils.optInt(jSONObject, "performance_modules", SlardarSettingsConsts.PERF_KEY_SMOOTH, SlardarSettingsConsts.PERF_SMOOTH_BLOCK_MONITOR_MODE);
        if (optInt == 11) {
            return 2;
        }
        if (optInt != 101) {
            return optInt != 1001 ? 1 : 0;
        }
        return 3;
    }

    public void onReady() {
        PerfMonitorManager.getInstance().onReady();
    }
}
