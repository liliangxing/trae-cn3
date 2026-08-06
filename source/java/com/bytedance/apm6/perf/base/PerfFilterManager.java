package com.bytedance.apm6.perf.base;

import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PerfFilterManager implements IPerfFilterManager {
    private static volatile PerfFilterManager singleton;
    private boolean mHasJavaHeapLeak;
    private long mJavaHeapSizeMaxMega;
    private long mJavaHeapSizeUsedMega;
    private long mNativeHeapSizeMega;
    private CopyOnWriteArraySet<String> mSceneSet = new CopyOnWriteArraySet<>();
    private ConcurrentHashMap<String, String> mPerfFilters = new ConcurrentHashMap<>();

    private PerfFilterManager() {
    }

    public static PerfFilterManager getInstance() {
        if (singleton == null) {
            synchronized (PerfFilterManager.class) {
                if (singleton == null) {
                    singleton = new PerfFilterManager();
                }
            }
        }
        return singleton;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void startScene(String str) {
        this.mSceneSet.add(str);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void stopScene(String str) {
        this.mSceneSet.remove(str);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void addPerfTag(String str, String str2) {
        this.mPerfFilters.put(str, str2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public String getSceneString() {
        String arrayToString = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        if (!TextUtils.isEmpty(arrayToString)) {
            return arrayToString;
        }
        ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        return activityLifecycleService != null ? activityLifecycleService.getTopActivityClassName() : "";
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getPerfFiltersJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.mPerfFilters.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject getPerfFiltersJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.mPerfFilters.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("RealRefreshRate", String.valueOf(FpsUtil.getRealMaxRate()));
            jSONObject.put("RealMaxRefreshRate", String.valueOf(FpsUtil.getRealMaxRate()));
            if (z) {
                DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(jSONObject);
                DeviceInfoUtil.getInstance().addConstantDeviceInfo(jSONObject);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public void removePerfTag(String str, String str2) {
        this.mPerfFilters.remove(str, str2);
    }

    @Override // com.bytedance.apm6.service.perf.IPerfFilterManager
    public JSONObject getRealTimeMemInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            updateMemInfo();
            jSONObject.put("apm_native_heap_size", this.mNativeHeapSizeMega);
            jSONObject.put("apm_java_heap_leak", this.mHasJavaHeapLeak);
            jSONObject.put("apm_java_heap_used", this.mJavaHeapSizeUsedMega);
            jSONObject.put("apm_java_heap_max", this.mJavaHeapSizeMaxMega);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void updateMemInfo() {
        this.mNativeHeapSizeMega = Debug.getNativeHeapAllocatedSize() / 1048576;
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        long j = runtime.totalMemory();
        this.mJavaHeapSizeMaxMega = maxMemory / 1048576;
        long j2 = j - freeMemory;
        this.mJavaHeapSizeUsedMega = j2 / 1048576;
        this.mHasJavaHeapLeak = ((float) j2) > ((float) maxMemory) * 0.95f;
    }
}
