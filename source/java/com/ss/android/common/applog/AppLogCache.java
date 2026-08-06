package com.ss.android.common.applog;

import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppLogCache {
    private static final int LIMIT_EVENT_SIZE = 200;
    private static volatile AppLogCache sInstance;
    private final LinkedList<AppLogEventData> mEventData = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class AppLogEventData {
        String mCategory;
        JSONObject mExt_json;
        long mExt_value;
        boolean mInstant_only;
        String mLabel;
        String mTag;
        long mValue;

        AppLogEventData(String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
            this.mCategory = str;
            this.mTag = str2;
            this.mLabel = str3;
            this.mValue = j;
            this.mExt_value = j2;
            this.mInstant_only = z;
            this.mExt_json = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AppLogCache getCacheInstance() {
        if (sInstance == null) {
            synchronized (AppLogCache.class) {
                if (sInstance == null) {
                    sInstance = new AppLogCache();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cacheEvent(String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        synchronized (this.mEventData) {
            if (this.mEventData.size() > 200) {
                AppLogEventData poll = this.mEventData.poll();
                LogTrace.notifyLogTrace(1, 1, null);
                if (poll != null) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CACHE_DROP_EVENT_COUNT);
                }
            }
            this.mEventData.add(new AppLogEventData(str, str2, str3, j, j2, z, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.common.applog.AppLogCache$1] */
    public void handleCacheEvent() {
        new ThreadPlus("handle_cached_events") { // from class: com.ss.android.common.applog.AppLogCache.1
            public void run() {
                super.run();
                AppLog.tryWaitDeviceInit();
                try {
                    LinkedList linkedList = new LinkedList();
                    synchronized (AppLogCache.this.mEventData) {
                        linkedList.addAll(AppLogCache.this.mEventData);
                        AppLogCache.this.mEventData.clear();
                    }
                    while (!linkedList.isEmpty()) {
                        AppLogEventData appLogEventData = (AppLogEventData) linkedList.poll();
                        AppLog.onEvent(null, appLogEventData.mCategory, appLogEventData.mTag, appLogEventData.mLabel, appLogEventData.mValue, appLogEventData.mExt_value, appLogEventData.mInstant_only, appLogEventData.mExt_json);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }.start();
    }
}
