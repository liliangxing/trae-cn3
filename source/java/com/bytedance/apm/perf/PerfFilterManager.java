package com.bytedance.apm.perf;

import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.DeviceInfoUtil;
import com.bytedance.apm.util.ListUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PerfFilterManager {
    private static volatile PerfFilterManager singleton;
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

    public void startScene(String str) {
        this.mSceneSet.add(str);
    }

    public void stopScene(String str) {
        this.mSceneSet.remove(str);
    }

    public void addPerfTag(String str, String str2) {
        this.mPerfFilters.put(str, str2);
    }

    public JSONObject getPerfFiltersJson() {
        return getPerfFiltersJson(false);
    }

    public JSONObject getPerfFiltersJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.mPerfFilters.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            if (z) {
                DeviceInfoUtil.getInstance().addRealTimeDeviceInfo(jSONObject);
                DeviceInfoUtil.getInstance().addConstantDeviceInfo(jSONObject);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getSceneString() {
        String arrayToString = ListUtils.arrayToString(this.mSceneSet.toArray(), "#");
        return TextUtils.isEmpty(arrayToString) ? ActivityLifeObserver.getInstance().getTopActivityClassName() : arrayToString;
    }

    public CopyOnWriteArraySet<String> getSceneSet() {
        return this.mSceneSet;
    }

    public ConcurrentHashMap<String, String> getPerfFilters() {
        return this.mPerfFilters;
    }

    public void removePerfTag(String str, String str2) {
        this.mPerfFilters.remove(str, str2);
    }
}
