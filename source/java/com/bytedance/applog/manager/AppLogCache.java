package com.bytedance.applog.manager;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.store.BaseData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppLogCache {
    private static final List<String> logTags = Collections.singletonList("AppLogCache");
    private final AppLogInstance appLogInstance;
    private final LinkedList<BaseData> sDatas = new LinkedList<>();
    private final LinkedList<String> sStrings = new LinkedList<>();
    private volatile int maxCacheEventNum = 1000;

    public AppLogCache(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    public void cache(BaseData baseData) {
        BaseData poll;
        synchronized (this.sDatas) {
            if (this.sDatas.size() > this.maxCacheEventNum && (poll = this.sDatas.poll()) != null) {
                if (poll.sentryStained > 0) {
                    MonitorUtils.stageEvent(this.appLogInstance.getMonitorHelper(), EventStage.CACHE_DROP_BEFORE_HANDLE, baseData);
                }
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.CACHE_DROP_EVENT_COUNT);
                String baseData2 = poll.toString();
                this.appLogInstance.getMonitorHelper().sendError("cache drop event", new Throwable(baseData2), false);
                this.appLogInstance.getLogger().warn(logTags, "AppLogCache overflow remove data: {}", poll);
                AppLogExceptionManager.getInstance().dispatchCacheOverflow(baseData2);
            }
            this.sDatas.add(baseData);
        }
    }

    public void cache(String[] strArr) {
        synchronized (this.sStrings) {
            if (this.sStrings.size() > this.maxCacheEventNum) {
                String poll = this.sStrings.poll();
                this.appLogInstance.getLogger().warn(logTags, "AppLogCache overflow2 remove data: {}", poll);
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.CACHE_DROP_EVENT_COUNT);
                AppLogExceptionManager.getInstance().dispatchCacheOverflow(poll);
            }
            this.sStrings.addAll(Arrays.asList(strArr));
        }
    }

    public int dumpData(ArrayList<BaseData> arrayList) {
        int size;
        synchronized (this.sDatas) {
            size = this.sDatas.size();
            arrayList.addAll(this.sDatas);
            Iterator<BaseData> it = this.sDatas.iterator();
            while (it.hasNext()) {
                BaseData next = it.next();
                if (next.sentryStained > 0) {
                    MonitorUtils.stageEvent(this.appLogInstance.getMonitorHelper(), EventStage.DATA_LIST_ADDED, next);
                }
            }
            this.sDatas.clear();
        }
        return size;
    }

    public String[] getArray() {
        int size = this.sStrings.size();
        if (size <= 0) {
            return null;
        }
        String[] strArr = new String[size];
        this.sStrings.toArray(strArr);
        this.sStrings.clear();
        return strArr;
    }

    public void setMaxCacheEventNum(int i) {
        this.maxCacheEventNum = Math.min(i, 200);
    }
}
