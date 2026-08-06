package com.bytedance.crash.runtime.assembly;

import android.app.Activity;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityDataManager {
    private static volatile ActivityDataManager sInst;

    public void setCustomActivity(CustomActivity customActivity) {
        ActivityLifecycle.setCustomActivity(customActivity);
    }

    private ActivityDataManager() {
    }

    public static ActivityDataManager getInstance() {
        if (sInst == null) {
            synchronized (ActivityDataManager.class) {
                if (sInst == null) {
                    sInst = new ActivityDataManager();
                }
            }
        }
        return sInst;
    }

    public static int getLaunchMode() {
        return ActivityLifecycle.getLaunchMode();
    }

    public static long getLaunchTime() {
        return ActivityLifecycle.getLaunchTime();
    }

    public long backgroundTime() {
        return ActivityLifecycle.getBackgroundTimeMs();
    }

    public boolean isForeground() {
        return !ActivityLifecycle.isBackground();
    }

    public ArrayList<WeakReference<Activity>> getAllActivities() {
        return ActivityLifecycle.getAllActivities();
    }

    public JSONArray getActivityLife() {
        return ActivityLifecycle.getLifecycleTrack();
    }

    public JSONObject getActivityTrace() {
        JSONObject jSONObject = new JSONObject();
        ActivityLifecycle.loadActivityTrace(jSONObject);
        return jSONObject.has(ActivityLifecycle.ACTIVITY_TRACE) ? jSONObject.optJSONObject(ActivityLifecycle.ACTIVITY_TRACE) : jSONObject;
    }

    public String getLastResumeActivity() {
        return ActivityLifecycle.getLastResumeActivity();
    }
}
