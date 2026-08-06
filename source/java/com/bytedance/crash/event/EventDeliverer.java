package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventDeliverer {
    private static final int MAX_VALUE = 100;
    private ConcurrentLinkedQueue<EventReportData> cache;
    private EventConfig config;
    private ConcurrentLinkedQueue<EventReportData> queue;
    private static ConcurrentHashMap<EventMonitor, ConcurrentLinkedQueue<EventReportData>> queues = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<EventMonitor, ConcurrentLinkedQueue<EventReportData>> caches = new ConcurrentHashMap<>();
    private static CopyOnWriteArrayList<EventDeliverer> sEventList = new CopyOnWriteArrayList<>();
    private static AtomicInteger totalCount = new AtomicInteger(0);
    private static AtomicInteger cacheCount = new AtomicInteger(0);
    private static volatile boolean isWorking = false;

    public EventDeliverer(EventMonitor eventMonitor) {
        ConcurrentLinkedQueue<EventReportData> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.queue = concurrentLinkedQueue;
        queues.put(eventMonitor, concurrentLinkedQueue);
        this.cache = new ConcurrentLinkedQueue<>();
        caches.put(eventMonitor, this.queue);
        sEventList.add(this);
        UploadManager.getInstance().start();
    }

    public static void clean() {
        try {
            sEventList.clear();
            caches.clear();
            Iterator<EventDeliverer> it = sEventList.iterator();
            while (it.hasNext()) {
                EventDeliverer next = it.next();
                next.queue.clear();
                next.cache.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public void updateConfig(EventConfig eventConfig) {
        if (eventConfig == null) {
            return;
        }
        while (!this.cache.isEmpty()) {
            EventReportData poll = this.cache.poll();
            cacheCount.decrementAndGet();
            if (eventConfig.isSampled(poll.getServiceName())) {
                this.queue.add(poll);
                totalCount.addAndGet(1);
            }
        }
        work();
        this.config = eventConfig;
    }

    public void reportEvent(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.config != null || cacheCount.get() <= 100) {
            EventConfig eventConfig = this.config;
            if (eventConfig == null || eventConfig.isSampled(str)) {
                EventReportData eventReportData = new EventReportData(Thread.currentThread().getName(), System.currentTimeMillis(), str, i, jSONObject, jSONObject2);
                if (this.config == null) {
                    this.cache.add(eventReportData);
                    cacheCount.addAndGet(1);
                } else {
                    this.queue.add(eventReportData);
                    totalCount.addAndGet(1);
                }
                work();
            }
        }
    }

    private void work() {
        if (isWorking) {
            return;
        }
        UploadManager.getInstance().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class UploadManager implements Runnable {
        private static UploadManager manager = new UploadManager();
        private volatile boolean isStarted;

        private UploadManager() {
        }

        public static UploadManager getInstance() {
            return manager;
        }

        public void work() {
            start();
            if (EventDeliverer.isWorking) {
                return;
            }
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, 30000L);
            boolean unused = EventDeliverer.isWorking = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            if (this.isStarted) {
                return;
            }
            this.isStarted = true;
            boolean unused = EventDeliverer.isWorking = true;
            DefaultWorkThread.removeCallbacks(this);
            DefaultWorkThread.postDelayed(this, 30000L);
        }

        @Override // java.lang.Runnable
        public void run() {
            uploadEvent();
            if (EventDeliverer.totalCount.get() <= 0 && EventDeliverer.cacheCount.get() <= 0) {
                boolean unused = EventDeliverer.isWorking = false;
            } else {
                DefaultWorkThread.postDelayed(this, 30000L);
                boolean unused2 = EventDeliverer.isWorking = true;
            }
        }

        private void uploadEvent() {
            try {
                JSONArray jSONArray = new JSONArray();
                int myPid = Process.myPid();
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = EventDeliverer.queues.keySet().iterator();
                int i = 0;
                boolean z = false;
                String str = "0";
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    EventMonitor eventMonitor = (EventMonitor) it.next();
                    ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) EventDeliverer.queues.get(eventMonitor);
                    if (concurrentLinkedQueue != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        while (true) {
                            if (concurrentLinkedQueue.isEmpty()) {
                                break;
                            }
                            jSONArray2.put(((EventReportData) concurrentLinkedQueue.poll()).toJsonObject());
                            EventDeliverer.totalCount.decrementAndGet();
                            i++;
                            if (i > 100) {
                                z = true;
                                break;
                            }
                        }
                        if (jSONArray2.length() != 0) {
                            JSONObject jSONObject = new JSONObject();
                            String deviceId = eventMonitor.getDeviceId("0");
                            jSONObject.put("data", jSONArray2);
                            JSONObject json = Header.createEventHeader(eventMonitor, currentTimeMillis, CrashType.ENSURE, myPid).getJson();
                            json.put("from", "npth");
                            jSONObject.put("header", json);
                            jSONArray.put(jSONObject);
                            if (z) {
                                str = deviceId;
                                break;
                            }
                            str = deviceId;
                        }
                    }
                }
                if (JSONUtils.isEmpty(jSONArray)) {
                    return;
                }
                String eventUploadUrl = NetConfig.getEventUploadUrl();
                HashMap hashMap = new HashMap();
                hashMap.put("device_id", str);
                hashMap.put("os", "Android");
                hashMap.put("sdk_version", NpthBuildConfig.VERSION_NAME);
                hashMap.put("from", "npth");
                String appendParamsToURL = UploaderUrl.appendParamsToURL(eventUploadUrl, hashMap);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("list", jSONArray);
                CrashUploader.uploadEvent(appendParamsToURL, jSONObject2);
            } catch (Throwable th) {
                NpthLog.m239w(th);
            }
        }
    }
}
