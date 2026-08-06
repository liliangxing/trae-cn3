package com.bytedance.crash.tracker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.bdturing.EventReport;
import com.bytedance.crash.Flavor;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.tools.JsonDumper;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.fragment.FragmentLifeManager;
import com.bytedance.crash.util.DateUtils;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ActivityLifecycle {
    private static final String ACTIVITY_ALIVE = "alive_activities";
    private static final String ACTIVITY_FINISH = "finish_activities";
    public static final String ACTIVITY_TRACE = "activity_trace";
    public static final String ACTIVITY_TRACK = "activity_track";
    private static final int DESTROYED_ACTIVITY_LIMIT = 20;
    public static final int LAUNCH_COLD = 1;
    public static final int LAUNCH_COLD_FIRST = 1;
    public static final int LAUNCH_COLD_SECOND = 2;
    public static final int LAUNCH_HOT = 3;
    public static final int LAUNCH_WARM = 4;
    public static final String NAME = "name";
    private static final int STATE_CREATED = 0;
    private static final int STATE_DESTROYED = 5;
    private static final int STATE_MAX = 6;
    private static final int STATE_PAUSED = 3;
    private static final int STATE_RESUMED = 2;
    private static final int STATE_STARTED = 1;
    private static final int STATE_STOPPED = 4;
    private static final String TIME = "time";
    private static final int TRACE_POOL_CAPACITY = 50;
    private static boolean isClodLaunch = true;
    private static boolean isRestore = false;
    private static boolean isWalkOnCreate = false;
    private static boolean sFirstLaunch = false;
    private static volatile ActivityLifecycle sInstance = null;
    private static int sLaunchMode = 1;
    private static long sLaunchTime = -1;
    private int mActivityNum;
    private CustomActivity mCustomActivity;
    private boolean mIsForeground;
    private String mLastPauseActivity;
    public static final String LAST_RESUME_ACTIVITY = "last_resume_activity";
    private static final String[] JSON_TAGS = {"last_create_activity", "last_start_activity", LAST_RESUME_ACTIVITY, "last_pause_activity", "last_stop_activity", "last_destroy_activity"};
    private static final String[] METHOD_NAMES = {"onCreate", AgentConstants.ON_START, "onResume", "onPause", "onStop", "onDestroy"};
    private final Map<Integer, ActivityRecord> mAliveActivities = new HashMap();
    private final List<ActivityRecord> mDestroyedActivities = new ArrayList();
    private final ActivityStateRecord[] mLastStates = new ActivityStateRecord[6];
    private final LinkedList<LifecycleTrace> mLifecycleTracePool = new LinkedList<>();
    private final ArrayList<WeakReference<Activity>> mActivitiesCache = new ArrayList<>();

    private static String getTrackMethodName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "onDestroy" : "onStop" : "onPause" : "onResume" : AgentConstants.ON_START : "onCreate";
    }

    static /* synthetic */ int access$508(ActivityLifecycle activityLifecycle) {
        int i = activityLifecycle.mActivityNum;
        activityLifecycle.mActivityNum = i + 1;
        return i;
    }

    static /* synthetic */ int access$510(ActivityLifecycle activityLifecycle) {
        int i = activityLifecycle.mActivityNum;
        activityLifecycle.mActivityNum = i - 1;
        return i;
    }

    public static void setCustomActivity(CustomActivity customActivity) {
        instance().mCustomActivity = customActivity;
    }

    public static ArrayList<WeakReference<Activity>> getAllActivities() {
        return instance().mActivitiesCache;
    }

    public static void start() {
        instance();
    }

    private static ActivityLifecycle instance() {
        if (sInstance == null) {
            synchronized (ActivityLifecycle.class) {
                if (sInstance == null) {
                    sInstance = new ActivityLifecycle();
                }
            }
        }
        return sInstance;
    }

    private ActivityLifecycle() {
        Application application = Global.getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks());
        }
        Flavor.setActivityImpl();
    }

    private String getActivityName(Activity activity) {
        CustomActivity customActivity = this.mCustomActivity;
        String activityName = customActivity != null ? customActivity.getActivityName(activity) : null;
        return TextUtils.isEmpty(activityName) ? activity.getClass().getName() : activityName;
    }

    public static void markFirstLaunch() {
        sFirstLaunch = true;
    }

    public static int getLaunchMode() {
        int i = sLaunchMode;
        return i == 1 ? sFirstLaunch ? 2 : 1 : i;
    }

    public static long getLaunchTime() {
        return sLaunchTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ActivityStateRecord {
        ActivityRecord mActivity;
        long mTime;

        ActivityStateRecord() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordLifecycle(int i, Activity activity) {
        long currentTimeMillis = System.currentTimeMillis();
        int hashCode = activity.hashCode();
        ActivityRecord activityRecord = this.mAliveActivities.get(Integer.valueOf(hashCode));
        if (activityRecord == null) {
            ActivityRecord activityRecord2 = new ActivityRecord(getActivityName(activity), i == 0 ? currentTimeMillis : 0L, hashCode);
            this.mAliveActivities.put(Integer.valueOf(hashCode), activityRecord2);
            activityRecord = activityRecord2;
        }
        activityRecord.changeState(i, currentTimeMillis);
        if (ProcessTracker.getInstance().isEnable()) {
            recordActivityLife(activityRecord.mActivityName, activityRecord.mCreatedMillis, getTrackMethodName(i), activity.hashCode());
        }
        writeLifecycleTrace(activityRecord);
        ActivityStateRecord[] activityStateRecordArr = this.mLastStates;
        if (activityStateRecordArr[i] == null) {
            activityStateRecordArr[i] = new ActivityStateRecord();
        }
        this.mLastStates[i].mActivity = activityRecord;
        this.mLastStates[i].mTime = activityRecord.mCurrentMillis;
        if (i == 5) {
            this.mAliveActivities.remove(Integer.valueOf(activityRecord.mHashCode));
            if (this.mDestroyedActivities.size() == 20) {
                this.mDestroyedActivities.remove(19);
            }
            this.mDestroyedActivities.add(activityRecord);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        ActivityLifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            boolean unused = ActivityLifecycle.isRestore = bundle != null;
            ActivityLifecycle.this.recordLifecycle(0, activity);
            boolean unused2 = ActivityLifecycle.isWalkOnCreate = true;
            ActivityLifecycle.this.mActivitiesCache.add(new WeakReference(activity));
            FragmentLifeManager.register(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ActivityLifecycle.this.recordLifecycle(1, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String activityName;
            ActivityLifecycle.this.recordLifecycle(2, activity);
            if (ActivityLifecycle.this.mCustomActivity != null) {
                activityName = ActivityLifecycle.this.mCustomActivity.getActivityName(activity);
            } else {
                activityName = activity.getClass().getName();
            }
            long currentTimeMillis = System.currentTimeMillis();
            ActivityLifecycle.access$508(ActivityLifecycle.this);
            if (ActivityLifecycle.this.mIsForeground) {
                return;
            }
            ActivityLifecycle.this.mIsForeground = true;
            if (ActivityLifecycle.isClodLaunch) {
                boolean unused = ActivityLifecycle.isClodLaunch = false;
                int unused2 = ActivityLifecycle.sLaunchMode = 1;
                long unused3 = ActivityLifecycle.sLaunchTime = currentTimeMillis;
            }
            if (activityName.equals(ActivityLifecycle.this.mLastPauseActivity)) {
                if (!ActivityLifecycle.isWalkOnCreate || ActivityLifecycle.isRestore) {
                    if (ActivityLifecycle.isWalkOnCreate) {
                        return;
                    }
                    int unused4 = ActivityLifecycle.sLaunchMode = 3;
                    long unused5 = ActivityLifecycle.sLaunchTime = currentTimeMillis;
                    return;
                }
                int unused6 = ActivityLifecycle.sLaunchMode = 4;
                long unused7 = ActivityLifecycle.sLaunchTime = currentTimeMillis;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            String activityName;
            ActivityLifecycle activityLifecycle = ActivityLifecycle.this;
            if (activityLifecycle.mCustomActivity != null) {
                activityName = ActivityLifecycle.this.mCustomActivity.getActivityName(activity);
            } else {
                activityName = activity.getClass().getName();
            }
            activityLifecycle.mLastPauseActivity = activityName;
            ActivityLifecycle.access$510(ActivityLifecycle.this);
            if (ActivityLifecycle.this.mActivityNum == 0) {
                ActivityLifecycle.this.mIsForeground = false;
                boolean unused = ActivityLifecycle.isWalkOnCreate = false;
            } else if (ActivityLifecycle.this.mActivityNum < 0) {
                ActivityLifecycle.this.mActivityNum = 0;
                ActivityLifecycle.this.mIsForeground = false;
                boolean unused2 = ActivityLifecycle.isWalkOnCreate = false;
            }
            ActivityLifecycle.this.recordLifecycle(3, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ActivityLifecycle.this.recordLifecycle(4, activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            ActivityLifecycle.this.recordLifecycle(5, activity);
            FragmentLifeManager.unregister(activity);
        }
    }

    public static long getBackgroundTimeMs() {
        return instance().getBackgroundTimeMsInner();
    }

    public static boolean isBackgroundV2() {
        if (instance().mAliveActivities.isEmpty()) {
            return !isForegroundByAms();
        }
        return !instance().isForegroundInner();
    }

    public static boolean isBackground() {
        if (instance().mAliveActivities.isEmpty()) {
            return !isForegroundByAms();
        }
        return !instance().isForegroundInner() && System.currentTimeMillis() - getBackgroundTimeMs() > 2000;
    }

    private static boolean isForegroundByAms() {
        Context context = Global.getContext();
        if (context == null) {
            return false;
        }
        context.getPackageName();
        try {
        } catch (Throwable unused) {
        }
        return false;
    }

    private long getBackgroundTimeMsInner() {
        ArrayList arrayList = new ArrayList(this.mAliveActivities.entrySet());
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            ActivityRecord activityRecord = (ActivityRecord) ((Map.Entry) arrayList.get(i)).getValue();
            if (activityRecord.mCurrentState < 3) {
                return 0L;
            }
            if (j < activityRecord.mCurrentMillis) {
                j = activityRecord.mCurrentMillis;
            }
        }
        return j;
    }

    private boolean isForegroundInner() {
        ArrayList arrayList = new ArrayList(this.mAliveActivities.entrySet());
        for (int i = 0; i < arrayList.size(); i++) {
            if (((ActivityRecord) ((Map.Entry) arrayList.get(i)).getValue()).mCurrentState < 3) {
                return true;
            }
        }
        return false;
    }

    public static void dump(File file) {
        if (isBackground()) {
            FileSystemUtils.createFile(file, EventReport.DIALOG_BACKGROUND);
        }
        if (isBackgroundV2()) {
            FileSystemUtils.createFile(file, "background_v2");
        }
        instance().dumpTrace(file);
        instance().dumpTrack(file);
        FragmentLifeManager.dump(file);
    }

    public static void loadActivityTrace(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (int i = 0; i < 6; i++) {
                if (instance().mLastStates[i] != null && instance().mLastStates[i].mActivity != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("name", instance().mLastStates[i].mActivity.mActivityName);
                    jSONObject3.put("time", instance().mLastStates[i].mTime);
                    jSONObject2.put(JSON_TAGS[i], jSONObject3);
                }
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(instance().mAliveActivities.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<Integer, ActivityRecord>>() { // from class: com.bytedance.crash.tracker.ActivityLifecycle.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<Integer, ActivityRecord> entry, Map.Entry<Integer, ActivityRecord> entry2) {
                    long j = entry.getValue().mCreatedMillis - entry2.getValue().mCreatedMillis;
                    if (j > 0) {
                        return 1;
                    }
                    return j < 0 ? -1 : 0;
                }
            });
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : arrayList) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("name", ((ActivityRecord) entry.getValue()).mActivityName);
                jSONObject4.put("time", ((ActivityRecord) entry.getValue()).mCreatedMillis);
                jSONArray.put(jSONObject4);
            }
            jSONObject2.put(ACTIVITY_ALIVE, jSONArray);
            Object jSONArray2 = new JSONArray();
            for (int size = instance().mDestroyedActivities.size() - 1; size >= 0; size--) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("name", instance().mDestroyedActivities.get(size).mActivityName);
                jSONObject5.put("time", instance().mDestroyedActivities.get(size).mCurrentMillis);
            }
            jSONObject2.put(ACTIVITY_FINISH, jSONArray2);
            jSONObject.put(ACTIVITY_TRACE, jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void loadActivityTrack(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = new ArrayList(instance().mLifecycleTracePool).iterator();
            while (it.hasNext()) {
                jSONArray.put(((LifecycleTrace) it.next()).formatWithTime());
            }
            CustomLong.add(jSONObject, ACTIVITY_TRACK, jSONArray);
        } catch (Exception unused) {
        }
    }

    public static void load(JSONObject jSONObject, File file) {
        try {
            jSONObject.put(Constants.IS_BACKGROUND, new File(file, EventReport.DIALOG_BACKGROUND).exists());
        } catch (Throwable unused) {
        }
        String readUtf8File = FileSystemUtils.readUtf8File(new File(file, "activity_trace.json"));
        if (readUtf8File != null) {
            try {
                JSONUtils.combineJson(jSONObject, new JSONObject(readUtf8File));
            } catch (Throwable unused2) {
            }
        }
        try {
            JSONArray jSONArray = new JSONArray();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file, "activity_track.inf")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String formatLine = LifecycleTrace.formatLine(readLine);
                if (formatLine != null) {
                    jSONArray.put(formatLine);
                }
            }
            CustomLong.add(jSONObject, ACTIVITY_TRACK, jSONArray);
        } catch (IOException unused3) {
        }
        try {
            FragmentLifeManager.load(jSONObject, file);
        } catch (Throwable unused4) {
        }
    }

    public static String getLastResumedActivityFromBody(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(ACTIVITY_TRACE);
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(JSON_TAGS[2])) == null) {
            return null;
        }
        return optJSONObject.optString("name");
    }

    private void dumpTrace(File file) {
        JsonDumper jsonDumper = new JsonDumper(file.getAbsolutePath() + "/activity_trace.json");
        jsonDumper.objectBegin();
        jsonDumper.key(ACTIVITY_TRACE);
        jsonDumper.objectBegin();
        for (int i = 0; i < 6; i++) {
            ActivityStateRecord activityStateRecord = this.mLastStates[i];
            if (activityStateRecord != null && activityStateRecord.mActivity != null) {
                jsonDumper.key(JSON_TAGS[i]);
                jsonDumper.objectBegin();
                jsonDumper.key("name").value(this.mLastStates[i].mActivity.mActivityName).next();
                jsonDumper.key("time").value(this.mLastStates[i].mTime);
                jsonDumper.objectEnd();
                jsonDumper.next();
            }
        }
        jsonDumper.key(ACTIVITY_ALIVE);
        jsonDumper.arrayBegin();
        ArrayList<Map.Entry> arrayList = new ArrayList(this.mAliveActivities.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Integer, ActivityRecord>>() { // from class: com.bytedance.crash.tracker.ActivityLifecycle.2
            @Override // java.util.Comparator
            public int compare(Map.Entry<Integer, ActivityRecord> entry, Map.Entry<Integer, ActivityRecord> entry2) {
                long j = entry.getValue().mCreatedMillis - entry2.getValue().mCreatedMillis;
                if (j > 0) {
                    return 1;
                }
                return j < 0 ? -1 : 0;
            }
        });
        boolean z = true;
        for (Map.Entry entry : arrayList) {
            if (z) {
                z = false;
            } else {
                jsonDumper.next();
            }
            jsonDumper.objectBegin();
            jsonDumper.key("name").value(((ActivityRecord) entry.getValue()).mActivityName).next();
            jsonDumper.key("time").value(((ActivityRecord) entry.getValue()).mCreatedMillis);
            jsonDumper.objectEnd();
        }
        jsonDumper.arrayEnd().next();
        jsonDumper.key(ACTIVITY_FINISH);
        jsonDumper.arrayBegin();
        for (int size = this.mDestroyedActivities.size() - 1; size >= 0; size--) {
            jsonDumper.objectBegin();
            jsonDumper.key("name").value(this.mDestroyedActivities.get(size).mActivityName).next();
            jsonDumper.key("time").value(this.mDestroyedActivities.get(size).mCurrentMillis);
            jsonDumper.objectEnd();
            if (size != 0) {
                jsonDumper.next();
            }
        }
        jsonDumper.arrayEnd();
        jsonDumper.objectEnd();
        jsonDumper.objectEnd();
        jsonDumper.release();
    }

    private void dumpTrack(File file) {
        StringBuilder sb = new StringBuilder();
        Iterator<LifecycleTrace> it = instance().mLifecycleTracePool.iterator();
        while (it.hasNext()) {
            it.next().appendLine(sb);
        }
        if (sb.length() == 0) {
            return;
        }
        FileSystemUtils.writeFile(new File(file, "activity_track.inf"), sb.toString());
    }

    public static JSONArray getLifecycleTrack() {
        JSONArray jSONArray = new JSONArray();
        Iterator it = new ArrayList(instance().mLifecycleTracePool).iterator();
        while (it.hasNext()) {
            jSONArray.put(((LifecycleTrace) it.next()).formatWithTime());
        }
        return jSONArray;
    }

    public static String getLastResumeActivity() {
        ActivityStateRecord activityStateRecord = instance().mLastStates[2];
        return (activityStateRecord == null || activityStateRecord.mActivity == null) ? ArgusConstants.NULL_PLACE_HOLDER : activityStateRecord.mActivity.mActivityName;
    }

    void writeLifecycleTrace(ActivityRecord activityRecord) {
        LifecycleTrace poll = this.mLifecycleTracePool.size() >= 50 ? this.mLifecycleTracePool.poll() : null;
        if (poll == null) {
            poll = new LifecycleTrace();
        }
        this.mLifecycleTracePool.add(poll);
        poll.copyFrom(activityRecord);
    }

    private void recordActivityLife(final String str, final long j, final String str2, final int i) {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.tracker.ActivityLifecycle.3
            @Override // java.lang.Runnable
            public void run() {
                ProcessTracker.getInstance().addEvent("activityLifeCycle", str + '.' + str2 + '@' + Long.toHexString(i), j);
            }
        });
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class LifecycleTrace {
        long mMillis;
        ActivityRecord mRecord;
        int mState;

        void copyFrom(ActivityRecord activityRecord) {
            this.mRecord = activityRecord;
            this.mMillis = activityRecord.mCurrentMillis;
            this.mState = activityRecord.mCurrentState;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void appendLine(StringBuilder sb) {
            sb.append(this.mMillis).append(' ').append(this.mRecord.mActivityName).append(' ').append(this.mRecord.mHashCode).append(' ').append(this.mState).append('\n');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String formatLine(String str) {
            String[] split = str.split(" ");
            if (split.length != 4) {
                return null;
            }
            try {
                long parseLong = Long.parseLong(split[0]);
                String str2 = split[1];
                int parseInt = Integer.parseInt(split[2]);
                int parseInt2 = Integer.parseInt(split[3]);
                if (parseInt2 >= 0 && parseInt2 < ActivityLifecycle.METHOD_NAMES.length) {
                    return format(parseLong, str2, parseInt, parseInt2);
                }
            } catch (Exception unused) {
            }
            return null;
        }

        private static String format(long j, String str, int i, int i2) {
            return DateUtils.formatDate(j) + " : " + str + '.' + ActivityLifecycle.METHOD_NAMES[i2] + '@' + Long.toHexString(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String formatWithTime() {
            return format(this.mMillis, this.mRecord.mActivityName, this.mRecord.mHashCode, this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ActivityRecord {
        String mActivityName;
        long mCreatedMillis;
        long mCurrentMillis;
        int mCurrentState;
        int mHashCode;

        public ActivityRecord(String str, long j, int i) {
            this.mActivityName = str;
            this.mHashCode = i;
            this.mCreatedMillis = j;
        }

        public void changeState(int i, long j) {
            this.mCurrentState = i;
            this.mCurrentMillis = j;
        }
    }
}
