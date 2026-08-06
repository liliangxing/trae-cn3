package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringLifeCycleListener;
import com.bytedance.bdturing.VerifyTaskHandler;
import com.bytedance.bdturing.cache.TuringSingleThreadPool;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PageTracer {
    private static final int FIRST_TOUCH_MAX_EVENT = 100;
    private static final int HOOK_INIT_RETRY_MAX_COUNT = 3;
    private static final int MAX_TOUCH_EVENT_NUM = 600;
    private static final int PAGE_HISTORY_MAX_SIZE = 60;
    private static final int PAGE_SIZE = 80;
    private static final double TOUCH_EVENT_INTERVAL = 33.0d;
    private static long initPid;
    private static long initTime;
    private static volatile PageTracer sInstance;
    private static boolean touchHookInit;
    private static String touchHookInitPageName;
    private static long touchHookInitTime;
    private long mLastEventTime;
    private static final List<PageRecord> sPageRecord = new LinkedList();
    private static final List<TouchEvent> sLastTouchEvents = new LinkedList();
    private static final List<TouchEvent> sFirstTouchEvents = new LinkedList();
    private static final Map<String, PageProfile> sPageInfoMap = new ConcurrentHashMap();
    private static int mHookInitRetryCount = 0;
    private int mForegroundActivityCount = 0;
    private boolean isBackGround = false;
    private boolean mInterceptTouchEvent = false;
    private boolean mRecordPageHistory = false;
    private boolean isInited = false;

    static /* synthetic */ int access$208() {
        int i = mHookInitRetryCount;
        mHookInitRetryCount = i + 1;
        return i;
    }

    private PageTracer() {
    }

    public boolean isBackGround() {
        return this.isBackGround;
    }

    public boolean inited() {
        return this.isInited;
    }

    public static PageTracer getInstance() {
        if (sInstance == null) {
            synchronized (PageTracer.class) {
                if (sInstance == null) {
                    sInstance = new PageTracer();
                }
            }
        }
        return sInstance;
    }

    public void init() {
        try {
            if (this.isInited) {
                return;
            }
            this.mInterceptTouchEvent = NoCaptchaSetting.collectTouchEventPre();
            this.mRecordPageHistory = NoCaptchaSetting.collectPageHistoryPre();
            this.isInited = true;
            initPid = Process.myPid();
            initTime = System.currentTimeMillis();
            if (this.mInterceptTouchEvent) {
                touchHookInit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void touchHookInit() {
        VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.senseless.PageTracer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PageTracer.this.hookTopActivityTouchEvent()) {
                    return;
                }
                PageTracer.this.tryHookTopActivityDelay(3000L);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryHookTopActivityDelay(long j) {
        VerifyTaskHandler.getInstance().postRunnableDelay(new Runnable() { // from class: com.bytedance.bdturing.senseless.PageTracer.2
            @Override // java.lang.Runnable
            public void run() {
                if (PageTracer.this.hookTopActivityTouchEvent() || PageTracer.mHookInitRetryCount >= 3) {
                    return;
                }
                PageTracer.access$208();
                PageTracer.this.tryHookTopActivityDelay(2000L);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hookTopActivityTouchEvent() {
        boolean z = false;
        try {
            Activity topActivity = getTopActivity();
            if (topActivity != null) {
                Window.Callback callback = topActivity.getWindow().getCallback();
                if (callback != null && isProxied(callback)) {
                    touchHookInitTime = System.currentTimeMillis();
                    z = true;
                    touchHookInit = true;
                    touchHookInitPageName = topActivity.getClass().getName();
                } else {
                    boolean replaceWindowCallback = replaceWindowCallback(topActivity);
                    try {
                        touchHookInitTime = System.currentTimeMillis();
                        touchHookInit = replaceWindowCallback;
                        touchHookInitPageName = topActivity.getClass().getName();
                        handleActivityStart(topActivity, false);
                        z = replaceWindowCallback;
                    } catch (Exception e) {
                        e = e;
                        z = replaceWindowCallback;
                        EventReport.hookTouchFail(e.getMessage());
                        return z;
                    }
                }
            } else {
                touchHookInitTime = System.currentTimeMillis();
                touchHookInit = false;
                touchHookInitPageName = "";
            }
        } catch (Exception e2) {
            e = e2;
        }
        return z;
    }

    public JSONObject getRuntimeInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init_pid", initPid);
            jSONObject.put("pid", Process.myPid());
            jSONObject.put("init_time", initTime);
            jSONObject.put("life_cycle_register_time", TuringLifeCycleListener.sInitTime);
            jSONObject.put("th_init_ts", touchHookInitTime);
            jSONObject.put("th_init_result", touchHookInit);
            jSONObject.put("th_init_page_id", touchHookInitPageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void startWatchTouchEvent() {
        this.mInterceptTouchEvent = true;
        Activity topActivity = getTopActivity();
        if (topActivity != null) {
            replaceWindowCallback(topActivity);
        }
    }

    private Activity getTopActivity() {
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null) {
            return config.getTopActivity();
        }
        return null;
    }

    public void startRecordPageHistory() {
        this.mRecordPageHistory = true;
    }

    public void stopWatchTouchEvent() {
        this.mInterceptTouchEvent = false;
    }

    public JSONArray getTouchEvent() {
        return touchEventToJsonArray(sLastTouchEvents);
    }

    public JSONArray getFirstTouchEvent() {
        return touchEventToJsonArray(sFirstTouchEvents);
    }

    private JSONArray touchEventToJsonArray(List<TouchEvent> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i).toJsonObj());
            }
        }
        return jSONArray;
    }

    public JSONArray getPageProfile() {
        JSONArray jSONArray = new JSONArray();
        Map<String, PageProfile> map = sPageInfoMap;
        if (map != null && !map.isEmpty()) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                PageProfile pageProfile = sPageInfoMap.get(it.next());
                if (pageProfile != null) {
                    jSONArray.put(pageProfile.toJson());
                }
            }
        }
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void savePageInfo(PageProfile pageProfile) {
        if (pageProfile == null || TextUtils.isEmpty(pageProfile.name)) {
            return;
        }
        Map<String, PageProfile> map = sPageInfoMap;
        if (map.size() > 80) {
            return;
        }
        map.put(pageProfile.name, pageProfile);
    }

    private boolean replaceWindowCallback(Activity activity) {
        if (activity == null || !this.mInterceptTouchEvent) {
            return false;
        }
        String name = activity.getClass().getName();
        PageProfile pageProfile = sPageInfoMap.get(name);
        if (pageProfile == null) {
            pageProfile = new PageProfile(name, r2.size());
            savePageInfo(pageProfile);
        }
        try {
            Window.Callback callback = activity.getWindow().getCallback();
            if (callback == null) {
                return false;
            }
            if (isProxied(callback)) {
                return true;
            }
            activity.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(callback.getClass().getClassLoader(), new Class[]{Window.Callback.class}, new TouchEventProxy(callback)));
            pageProfile.updateHookState(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            pageProfile.updateHookState(false);
            EventReport.hookTouchFail(e.getMessage());
            return false;
        }
    }

    private boolean isProxied(Window.Callback callback) {
        InvocationHandler invocationHandler;
        return (callback instanceof Proxy) && (invocationHandler = Proxy.getInvocationHandler(callback)) != null && (invocationHandler instanceof TouchEventProxy);
    }

    public void updateForeGroundActivity() {
        this.mForegroundActivityCount++;
    }

    private void handleActivityStart(Activity activity, boolean z) {
        if (this.mRecordPageHistory) {
            TuringSingleThreadPool.getInstance().execute(new PageInfoRecordTask(activity != null ? activity.getClass().getName() : "", 4));
        }
        if (z) {
            replaceWindowCallback(activity);
        }
    }

    public void onActivityStart(Activity activity) {
        int i = this.mForegroundActivityCount + 1;
        this.mForegroundActivityCount = i;
        if (i == 1) {
            this.isBackGround = false;
        }
        handleActivityStart(activity, this.mInterceptTouchEvent);
    }

    public void onActivityStopped(Activity activity) {
        int i = this.mForegroundActivityCount - 1;
        this.mForegroundActivityCount = i;
        if (i == 0) {
            this.isBackGround = true;
        }
        if (this.mRecordPageHistory) {
            TuringSingleThreadPool.getInstance().execute(new PageInfoRecordTask(activity != null ? activity.getClass().getName() : "", 2));
        }
    }

    public JSONArray getPageHistory() {
        PageProfile pageProfile;
        List<PageRecord> list = sPageRecord;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            List<PageRecord> list2 = sPageRecord;
            if (i >= list2.size()) {
                return jSONArray;
            }
            PageRecord pageRecord = list2.get(i);
            if (pageRecord != null) {
                if (i == list2.size() - 1 && pageRecord.downEvent == null && (pageProfile = sPageInfoMap.get(getCurrentPageName())) != null) {
                    if (pageProfile.downEvent != null) {
                        pageRecord.downEvent = pageProfile.downEvent.copy();
                    }
                    if (pageProfile.upEvent != null) {
                        pageRecord.upEvent = pageProfile.upEvent.copy();
                    }
                    if (pageProfile.firstMoveEvent != null) {
                        pageRecord.firstMoveEvent = pageProfile.firstMoveEvent.copy();
                    }
                    if (pageProfile.secondMoveEvent != null) {
                        pageRecord.secondMoveEvent = pageProfile.secondMoveEvent.copy();
                    }
                }
                jSONArray.put(pageRecord.toJsonObj());
            }
            i++;
        }
    }

    private String getCurrentPageName() {
        Activity topActivity;
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        if (config != null && (topActivity = config.getTopActivity()) != null) {
            return topActivity.getClass().getName();
        }
        try {
            return sPageRecord.get(r0.size() - 1).pageId;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public JSONObject getDataProfile() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_history_count", sPageRecord.size());
            jSONObject.put("touch_event_count", sLastTouchEvents.size());
            jSONObject.put("first_touch_event_count", sFirstTouchEvents.size());
            jSONObject.put("page_profile_count", sPageInfoMap.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void onDispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mInterceptTouchEvent) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mLastEventTime;
            if (currentTimeMillis == j) {
                return;
            }
            long j2 = currentTimeMillis - j;
            int actionMasked = motionEvent.getActionMasked();
            if (2 != actionMasked || j2 >= TOUCH_EVENT_INTERVAL) {
                this.mLastEventTime = currentTimeMillis;
                TouchEvent touchEvent = new TouchEvent();
                touchEvent.phase = actionMasked;
                touchEvent.x = motionEvent.getX();
                touchEvent.y = motionEvent.getY();
                touchEvent.majorRadius = motionEvent.getTouchMajor();
                touchEvent.force = motionEvent.getPressure();
                touchEvent.timestamp = currentTimeMillis;
                List<TouchEvent> list = sFirstTouchEvents;
                if (list.size() < 100) {
                    list.add(touchEvent);
                } else if (1 == actionMasked && list.size() == 100) {
                    list.add(touchEvent);
                }
                PageProfile pageProfile = sPageInfoMap.get(getCurrentPageName());
                if (pageProfile != null) {
                    if (actionMasked == 0) {
                        pageProfile.downEvent = touchEvent;
                        pageProfile.firstMoveEvent = null;
                        pageProfile.secondMoveEvent = null;
                    } else if (1 == actionMasked) {
                        pageProfile.upEvent = touchEvent;
                    } else if (2 == actionMasked) {
                        if (pageProfile.firstMoveEvent == null) {
                            pageProfile.firstMoveEvent = touchEvent;
                        } else if (pageProfile.secondMoveEvent == null && touchEvent.timestamp - pageProfile.firstMoveEvent.timestamp > 50) {
                            pageProfile.secondMoveEvent = touchEvent;
                        }
                    }
                }
                List<TouchEvent> list2 = sLastTouchEvents;
                if (list2.size() >= 600) {
                    list2.remove(0);
                }
                list2.add(touchEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class PageInfoRecordTask implements Runnable {
        public static final int TYPE_ACTIVITY_CREATE = 0;
        public static final int TYPE_ACTIVITY_DESTROY = 3;
        public static final int TYPE_ACTIVITY_PAUSE = 5;
        public static final int TYPE_ACTIVITY_RESUME = 1;
        public static final int TYPE_ACTIVITY_START = 4;
        public static final int TYPE_ACTIVITY_STOP = 2;
        private String mPageId;
        private int mType;

        private void handleDestroy() {
        }

        private void handleResume() {
        }

        public PageInfoRecordTask(String str, int i) {
            this.mPageId = str;
            this.mType = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int i = this.mType;
                if (i == 1) {
                    handleResume();
                } else if (i == 2) {
                    handleStop();
                } else if (i == 3) {
                    handleDestroy();
                } else if (i == 4) {
                    handleStart();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void handleStart() {
            if (((PageProfile) PageTracer.sPageInfoMap.get(this.mPageId)) == null) {
                PageTracer.getInstance().savePageInfo(new PageProfile(this.mPageId, PageTracer.sPageInfoMap.size()));
            }
            if (PageTracer.sPageRecord.size() >= 60) {
                PageTracer.sPageRecord.remove(0);
            }
            PageRecord pageRecord = new PageRecord(this.mPageId);
            pageRecord.enterTime = System.currentTimeMillis();
            int lastIndexOf = PageTracer.sPageRecord.lastIndexOf(pageRecord);
            if (lastIndexOf < 0) {
                PageTracer.sPageRecord.add(pageRecord);
            } else if (((PageRecord) PageTracer.sPageRecord.get(lastIndexOf)).leaveTime > 0) {
                PageTracer.sPageRecord.add(pageRecord);
            }
        }

        private void handleStop() {
            int lastIndexOf = PageTracer.sPageRecord.lastIndexOf(new PageRecord(this.mPageId));
            if (lastIndexOf >= 0) {
                PageRecord pageRecord = (PageRecord) PageTracer.sPageRecord.get(lastIndexOf);
                pageRecord.leaveTime = System.currentTimeMillis();
                PageProfile pageProfile = (PageProfile) PageTracer.sPageInfoMap.get(this.mPageId);
                if (pageProfile != null) {
                    if (pageProfile.downEvent != null) {
                        pageRecord.downEvent = pageProfile.downEvent.copy();
                    }
                    if (pageProfile.upEvent != null) {
                        pageRecord.upEvent = pageProfile.upEvent.copy();
                    }
                    if (pageProfile.firstMoveEvent != null) {
                        pageRecord.firstMoveEvent = pageProfile.firstMoveEvent.copy();
                    }
                    if (pageProfile.secondMoveEvent != null) {
                        pageRecord.secondMoveEvent = pageProfile.secondMoveEvent.copy();
                    }
                }
            }
        }
    }
}
