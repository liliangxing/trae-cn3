package com.bytedance.apm6.frequency;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.applog.sampling.EventSamplingLoader;
import com.bytedance.applog.server.Api;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.bdturing.EventReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FrequencyMonitor {
    private static final String COMMAND_CHANGE_TO_BACKGROUND = "command_change_to_background";
    private static final String COMMAND_CHANGE_TO_FRONT = "command_change_to_front";
    private static final String COMMAND_CHECK_BACKGROUND_EXCEPTION = "command_check_background_exception";
    private static final String COMMAND_CHECK_FRONT_EXCEPTION = "command_check_front_exception";
    private static final String COMMAND_REPORT_DATA = "command_report_data";
    private static final int MAX_ERROR_COUNT = 5;
    private static final String TAG = "APM-HighFrequency";
    private static final String THREAD_NAME = "APM-FrequencyMonitor";
    private static volatile FrequencyMonitor mIns;
    private AsyncTask mBackgroundExceptionCheckTask;
    private AsyncTask mFrontExceptionCheckTask;
    private DummyLifecycleListener mLifecycleListener;
    private FrequencyMonitorConfig mMonitorConfig;
    private BlockingQueue<RecordItem> mQueue;
    private AsyncTask mReportTimerTask;
    private HashMap<String, HashMap<String, Counter>> mUsingExceptionRecordingMap;
    private HashMap<String, HashMap<String, Counter>> mUsingRecordingMap;
    private volatile boolean mIsQueueWorking = false;
    private volatile boolean mInitSuccess = false;
    private final HashMap<String, HashMap<String, Counter>> mFrontExceptionRecordingData = new HashMap<>();
    private final HashMap<String, HashMap<String, Counter>> mBackgroundExceptionRecordingData = new HashMap<>();
    private final HashMap<String, HashMap<String, Counter>> mFrontRecordingData = new HashMap<>();
    private final HashMap<String, HashMap<String, Counter>> mBackgroundRecordingData = new HashMap<>();
    private long mFrontDuration = 0;
    private long mBackgroundDuration = 0;
    private long mLastRecordDurationTime = 0;
    private long mLastCheckExceptionTime = 0;
    private int mErrorCount = 0;
    private volatile boolean showNotInitRemind = true;

    static /* synthetic */ int access$508(FrequencyMonitor frequencyMonitor) {
        int i = frequencyMonitor.mErrorCount;
        frequencyMonitor.mErrorCount = i + 1;
        return i;
    }

    private FrequencyMonitor() {
    }

    public static FrequencyMonitor getInstance() {
        if (mIns == null) {
            synchronized (FrequencyMonitor.class) {
                if (mIns == null) {
                    mIns = new FrequencyMonitor();
                }
            }
        }
        return mIns;
    }

    public void init() {
        ServiceManager.getService(FrequencyMonitorConfigService.class);
    }

    public void monitorFrequency(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        if (!this.mInitSuccess) {
            if (ApmContext.isDebugMode() && this.showNotInitRemind) {
                this.showNotInitRemind = false;
                Log.i(TAG, "Not init finished,will not record");
                return;
            }
            return;
        }
        if (this.mMonitorConfig.getEventSamplingRate() >= 10000 || System.nanoTime() % GWorker.INTERVAL < this.mMonitorConfig.getEventSamplingRate()) {
            RecordItem cacheItem = RecordItemCache.getCacheItem();
            if (cacheItem == null) {
                cacheItem = new RecordItem(str, str2);
            } else {
                cacheItem.setCategory(str);
                cacheItem.setKey(str2);
            }
            cacheItem.setUsing(true);
            enqueue(cacheItem);
        }
    }

    public void updateConfig(FrequencyMonitorConfig frequencyMonitorConfig) {
        if (frequencyMonitorConfig == null || this.mMonitorConfig == frequencyMonitorConfig) {
            return;
        }
        stopMonitor();
        startMonitor(frequencyMonitorConfig);
    }

    public synchronized void stopMonitor() {
        DummyLifecycleListener dummyLifecycleListener;
        this.mInitSuccess = false;
        if (this.mReportTimerTask != null) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mReportTimerTask);
        }
        if (this.mFrontExceptionCheckTask != null) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mFrontExceptionCheckTask);
        }
        if (this.mBackgroundExceptionCheckTask != null) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mBackgroundExceptionCheckTask);
        }
        ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        if (activityLifecycleService != null && (dummyLifecycleListener = this.mLifecycleListener) != null) {
            activityLifecycleService.unregister(dummyLifecycleListener);
        }
        BlockingQueue<RecordItem> blockingQueue = this.mQueue;
        if (blockingQueue != null) {
            blockingQueue.clear();
        }
    }

    private synchronized void startMonitor(FrequencyMonitorConfig frequencyMonitorConfig) {
        if (frequencyMonitorConfig != null) {
            if ((frequencyMonitorConfig.enableFrequencyMonitor() || frequencyMonitorConfig.enableFrequencyMonitor()) && !this.mInitSuccess) {
                if (ApmContext.isDebugMode()) {
                    Log.i(TAG, "init:" + frequencyMonitorConfig);
                }
                this.mMonitorConfig = frequencyMonitorConfig;
                this.mQueue = new LinkedTransferQueue();
                if (frequencyMonitorConfig.enableFrequencyMonitor()) {
                    sendReportTask();
                }
                this.mLastRecordDurationTime = System.currentTimeMillis();
                ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
                if (activityLifecycleService != null) {
                    boolean isForeground = activityLifecycleService.isForeground();
                    this.mUsingRecordingMap = isForeground ? this.mFrontRecordingData : this.mBackgroundRecordingData;
                    this.mUsingExceptionRecordingMap = isForeground ? this.mFrontExceptionRecordingData : this.mBackgroundExceptionRecordingData;
                    DummyLifecycleListener dummyLifecycleListener = new DummyLifecycleListener() { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.1
                        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                        public void onFront(Activity activity) {
                            FrequencyMonitor.this.onFront();
                        }

                        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
                        public void onBackground(Activity activity) {
                            FrequencyMonitor.this.onBackground();
                        }
                    };
                    this.mLifecycleListener = dummyLifecycleListener;
                    activityLifecycleService.register(dummyLifecycleListener);
                    if (frequencyMonitorConfig.enableExceptionMonitor()) {
                        sendCheckExceptionTask(isForeground);
                    }
                    this.mInitSuccess = true;
                    return;
                }
                if (ApmContext.isDebugMode()) {
                    Log.i(TAG, "init error");
                }
            }
        }
    }

    private void sendReportTask() {
        if (this.mReportTimerTask == null) {
            this.mReportTimerTask = new AsyncTask(this.mMonitorConfig.getReportInterval(), this.mMonitorConfig.getReportInterval()) { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    FrequencyMonitor.this.checkReport();
                }
            };
        }
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.mReportTimerTask);
    }

    private void sendCheckExceptionTask(boolean z) {
        if (this.mBackgroundExceptionCheckTask == null || this.mFrontExceptionCheckTask == null) {
            this.mBackgroundExceptionCheckTask = new AsyncTask(this.mMonitorConfig.getExceptionCheckInterval(false), this.mMonitorConfig.getExceptionCheckInterval(false)) { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    FrequencyMonitor.this.checkHasException(false);
                }
            };
            this.mFrontExceptionCheckTask = new AsyncTask(this.mMonitorConfig.getExceptionCheckInterval(true), this.mMonitorConfig.getExceptionCheckInterval(true)) { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    FrequencyMonitor.this.checkHasException(true);
                }
            };
        } else {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(z ? this.mBackgroundExceptionCheckTask : this.mFrontExceptionCheckTask);
        }
        this.mLastCheckExceptionTime = System.currentTimeMillis();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(z ? this.mFrontExceptionCheckTask : this.mBackgroundExceptionCheckTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHasException(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastCheckExceptionTime;
        this.mLastCheckExceptionTime = currentTimeMillis;
        enqueue(new RecordItem(z ? COMMAND_CHECK_FRONT_EXCEPTION : COMMAND_CHECK_BACKGROUND_EXCEPTION, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReport() {
        long currentTimeMillis = System.currentTimeMillis();
        enqueue(new RecordItem(COMMAND_REPORT_DATA, currentTimeMillis - this.mLastRecordDurationTime));
        this.mLastRecordDurationTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFront() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = currentTimeMillis;
        if (this.mMonitorConfig.enableExceptionMonitor()) {
            sendCheckExceptionTask(true);
        }
        enqueue(new RecordItem(COMMAND_CHANGE_TO_FRONT, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackground() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = currentTimeMillis;
        if (this.mMonitorConfig.enableExceptionMonitor()) {
            sendCheckExceptionTask(false);
        }
        enqueue(new RecordItem(COMMAND_CHANGE_TO_BACKGROUND, j));
    }

    private void enqueue(RecordItem recordItem) {
        if (!this.mQueue.offer(recordItem) && ApmContext.isDebugMode()) {
            Log.i(TAG, "enqueue error,data:" + recordItem + " size:" + this.mQueue.size());
        }
        if (this.mIsQueueWorking) {
            return;
        }
        startWork();
    }

    private synchronized void startWork() {
        if (this.mIsQueueWorking) {
            return;
        }
        this.mIsQueueWorking = true;
        new Thread(new Runnable() { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.5
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        FrequencyMonitor.this.dispatchMessage();
                    } catch (Throwable th) {
                        if (ApmContext.isDebugMode()) {
                            Log.e(FrequencyMonitor.TAG, "FrequencyMonitorError", th);
                        }
                        FrequencyMonitor.access$508(FrequencyMonitor.this);
                        if (FrequencyMonitor.this.mErrorCount >= 5) {
                            FrequencyMonitor.this.stopMonitor();
                            return;
                        }
                    }
                }
            }
        }, THREAD_NAME).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchMessage() throws InterruptedException, JSONException {
        RecordItem take = this.mQueue.take();
        if (take.getCommand() != null) {
            long duration = take.getDuration();
            if (take.getCommand().startsWith(COMMAND_CHANGE_TO_FRONT)) {
                changeState(true, duration);
            } else if (take.getCommand().startsWith(COMMAND_CHANGE_TO_BACKGROUND)) {
                changeState(false, duration);
            } else if (take.getCommand().startsWith(COMMAND_CHECK_FRONT_EXCEPTION)) {
                checkAndReportException(true, duration);
            } else if (take.getCommand().startsWith(COMMAND_CHECK_BACKGROUND_EXCEPTION)) {
                checkAndReportException(false, duration);
            } else if (take.getCommand().startsWith(COMMAND_REPORT_DATA)) {
                reportDataInner(duration);
            }
        } else {
            saveDataToRecoding(take.getCategory(), take.getKey());
        }
        take.setUsing(false);
    }

    private void saveDataToRecoding(String str, String str2) {
        if (this.mMonitorConfig.enableFrequencyMonitor()) {
            HashMap<String, Counter> hashMap = this.mUsingRecordingMap.get(str);
            if (hashMap == null) {
                HashMap<String, Counter> hashMap2 = new HashMap<>();
                this.mUsingRecordingMap.put(str, hashMap2);
                hashMap2.put(str2, new Counter(1));
            } else {
                Counter counter = hashMap.get(str2);
                if (counter == null) {
                    hashMap.put(str2, new Counter(1));
                } else {
                    counter.addCount(1);
                }
            }
        }
        if (this.mMonitorConfig.enableExceptionMonitor()) {
            HashMap<String, Counter> hashMap3 = this.mUsingExceptionRecordingMap.get(str);
            if (hashMap3 == null) {
                HashMap<String, Counter> hashMap4 = new HashMap<>();
                this.mUsingExceptionRecordingMap.put(str, hashMap4);
                hashMap4.put(str2, new Counter(1));
            } else {
                Counter counter2 = hashMap3.get(str2);
                if (counter2 == null) {
                    hashMap3.put(str2, new Counter(1));
                } else {
                    counter2.addCount(1);
                }
            }
        }
    }

    private void changeState(boolean z, long j) {
        this.mFrontExceptionRecordingData.clear();
        this.mBackgroundExceptionRecordingData.clear();
        if (z) {
            this.mBackgroundDuration += j;
            this.mUsingRecordingMap = this.mFrontRecordingData;
            this.mUsingExceptionRecordingMap = this.mFrontExceptionRecordingData;
        } else {
            this.mFrontDuration += j;
            this.mUsingRecordingMap = this.mBackgroundRecordingData;
            this.mUsingExceptionRecordingMap = this.mBackgroundExceptionRecordingData;
        }
    }

    private void checkAndReportException(boolean z, long j) throws JSONException {
        int exceptionReportTopCount;
        int i;
        Iterator it;
        Iterator it2;
        boolean z2 = z ? 1 : 0;
        HashMap<String, HashMap<String, Counter>> hashMap = z2 ? this.mFrontExceptionRecordingData : this.mBackgroundExceptionRecordingData;
        if (!hashMap.isEmpty() && (exceptionReportTopCount = this.mMonitorConfig.getExceptionReportTopCount()) > 0) {
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, HashMap<String, Counter>> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                List list = (List) hashMap3.get(key);
                if (list == null) {
                    list = new ArrayList();
                    hashMap3.put(key, list);
                }
                for (Map.Entry<String, Counter> entry2 : entry.getValue().entrySet()) {
                    String key2 = entry2.getKey();
                    int count = entry2.getValue().getCount();
                    list.add(new Pair(key2, Integer.valueOf(count)));
                    Counter counter = (Counter) hashMap2.get(key);
                    if (counter == null) {
                        hashMap2.put(key, new Counter(count));
                    } else {
                        counter.addCount(count);
                    }
                }
            }
            Iterator it3 = hashMap2.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry entry3 = (Map.Entry) it3.next();
                if ((10000.0f * (((Counter) entry3.getValue()).getCount() / (((float) j) * 1.6666667E-5f))) / this.mMonitorConfig.getEventSamplingRate() > this.mMonitorConfig.getExceptionThresholdOfCategory((String) entry3.getKey(), z2)) {
                    List list2 = (List) hashMap3.get(entry3.getKey());
                    Collections.sort(list2, new Comparator<Pair<String, Integer>>() { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.6
                        @Override // java.util.Comparator
                        public int compare(Pair<String, Integer> pair, Pair<String, Integer> pair2) {
                            return ((Integer) pair2.second).intValue() - ((Integer) pair.second).intValue();
                        }
                    });
                    final JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 0;
                    while (i2 < Math.min(exceptionReportTopCount, list2.size())) {
                        JSONObject jSONObject2 = new JSONObject();
                        Pair pair = (Pair) list2.get(i2);
                        int i3 = exceptionReportTopCount;
                        if (i2 == 0) {
                            it2 = it3;
                            jSONObject.putOpt("exception_reason", pair.first);
                        } else {
                            it2 = it3;
                        }
                        jSONObject2.putOpt(Api.KEY_ENCRYPT_RESP_KEY, pair.first);
                        jSONObject2.putOpt("count", pair.second);
                        jSONArray.put(jSONObject2);
                        i2++;
                        exceptionReportTopCount = i3;
                        it3 = it2;
                    }
                    i = exceptionReportTopCount;
                    it = it3;
                    jSONObject.putOpt(CommonKey.KEY_IS_FRONT, Integer.valueOf(z ? 1 : 0));
                    jSONObject.putOpt("category", entry3.getKey());
                    jSONObject.putOpt("total_count", Integer.valueOf(((Counter) entry3.getValue()).getCount()));
                    jSONObject.putOpt("duration", Long.valueOf(j));
                    jSONObject.putOpt("frequency_per_min", Float.valueOf(Math.round(r7 * 100.0f) / 100.0f));
                    jSONObject.putOpt("frequency_reduction", Float.valueOf(Math.round(r10 * 100.0f) / 100.0f));
                    jSONObject.putOpt(EventSamplingLoader.KEY_SAMPLING_ITEM_RATE, Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
                    jSONObject.putOpt("top_data", jSONArray);
                    jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                    AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.7
                        @Override // java.lang.Runnable
                        public void run() {
                            CommonEventDeliverer.monitorCommonLog("apm_frequency_exception_monitor", jSONObject);
                        }
                    });
                    if (ApmContext.isDebugMode()) {
                        Log.i(TAG, "Report Exception:" + jSONObject);
                    }
                } else {
                    i = exceptionReportTopCount;
                    it = it3;
                }
                z2 = z ? 1 : 0;
                exceptionReportTopCount = i;
                it3 = it;
            }
            hashMap.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void reportDataInner(long j) throws JSONException {
        boolean z;
        HashMap<String, HashMap<String, Counter>> hashMap = this.mUsingRecordingMap;
        HashMap<String, HashMap<String, Counter>> hashMap2 = this.mFrontRecordingData;
        if (hashMap == hashMap2) {
            this.mFrontDuration += j;
        } else {
            this.mBackgroundDuration += j;
        }
        if (hashMap2.isEmpty() && this.mBackgroundRecordingData.isEmpty()) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        boolean z2 = true;
        if (!this.mFrontRecordingData.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject();
            if (appendJsonArray(this.mFrontRecordingData, this.mFrontDuration, jSONObject2, true)) {
                jSONObject2.putOpt("duration", Long.valueOf(this.mFrontDuration));
                jSONObject.putOpt("front", jSONObject2);
                z = true;
                if (!this.mBackgroundRecordingData.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject();
                    if (appendJsonArray(this.mBackgroundRecordingData, this.mBackgroundDuration, jSONObject3, false)) {
                        jSONObject3.putOpt("duration", Long.valueOf(this.mBackgroundDuration));
                        jSONObject.putOpt(EventReport.DIALOG_BACKGROUND, jSONObject3);
                        if (z2) {
                            jSONObject.putOpt(EventSamplingLoader.KEY_SAMPLING_ITEM_RATE, Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
                            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
                            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm6.frequency.FrequencyMonitor.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    CommonEventDeliverer.monitorCommonLog("apm_frequency_monitor", jSONObject);
                                }
                            });
                            if (ApmContext.isDebugMode()) {
                                Log.i(TAG, "Report Data:" + jSONObject);
                            }
                        }
                        this.mFrontRecordingData.clear();
                        this.mBackgroundRecordingData.clear();
                        this.mFrontDuration = 0L;
                        this.mBackgroundDuration = 0L;
                    }
                }
                z2 = z;
                if (z2) {
                }
                this.mFrontRecordingData.clear();
                this.mBackgroundRecordingData.clear();
                this.mFrontDuration = 0L;
                this.mBackgroundDuration = 0L;
            }
        }
        z = false;
        if (!this.mBackgroundRecordingData.isEmpty()) {
        }
        z2 = z;
        if (z2) {
        }
        this.mFrontRecordingData.clear();
        this.mBackgroundRecordingData.clear();
        this.mFrontDuration = 0L;
        this.mBackgroundDuration = 0L;
    }

    private boolean appendJsonArray(HashMap<String, HashMap<String, Counter>> hashMap, long j, JSONObject jSONObject, boolean z) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, HashMap<String, Counter>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, Counter> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                int count = entry2.getValue().getCount();
                if ((10000.0f * (count / (((float) j) * 1.6666667E-5f))) / this.mMonitorConfig.getEventSamplingRate() > this.mMonitorConfig.getReportThresholdOfCategory(key, z)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("category", key);
                    jSONObject2.putOpt(Api.KEY_ENCRYPT_RESP_KEY, key2);
                    jSONObject2.putOpt("count", Integer.valueOf(count));
                    jSONObject2.putOpt("frequency_per_min", Float.valueOf(Math.round(r5 * 100.0f) / 100.0f));
                    jSONObject2.putOpt("frequency_reduction", Float.valueOf(Math.round(r6 * 100.0f) / 100.0f));
                    jSONArray.put(jSONObject2);
                }
            }
        }
        jSONObject.putOpt("details", jSONArray);
        return jSONArray.length() > 0;
    }
}
