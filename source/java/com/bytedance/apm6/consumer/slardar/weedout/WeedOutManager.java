package com.bytedance.apm6.consumer.slardar.weedout;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WeedOutManager {
    private static final int MINIMUM_OF_MB_TODAY = 80;
    private static final long WEED_OUT_INTERVAL = 14400000;
    private static volatile WeedOutManager instance = new WeedOutManager();
    private WeedOutListener listener;
    private Set<WeedOutStrategy> strategies = new HashSet();
    private int maxSizeMB = 80;
    private int keepDays = 5;
    private int maxSizeMBToday = -1;

    public static WeedOutManager getInstance() {
        return instance;
    }

    public void setWeedOutConfig(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.maxSizeMB = i;
        this.keepDays = i2;
        this.maxSizeMBToday = i3 != -1 ? Math.max(i3, 80) : -1;
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "weed out config:maxSizeMB:" + i + " keepDays:" + i2);
        }
    }

    public synchronized void addStrategy(WeedOutStrategy weedOutStrategy) {
        if (weedOutStrategy == null) {
            return;
        }
        this.strategies.add(weedOutStrategy);
    }

    public synchronized void register(WeedOutListener weedOutListener) {
        this.listener = weedOutListener;
    }

    public void init() {
        if (ApmContext.isMainProcess()) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AsyncTask(0L, WEED_OUT_INTERVAL) { // from class: com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager.1
                @Override // java.lang.Runnable
                public void run() {
                    long j;
                    Iterator it;
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = WeedOutManager.this.keepDays;
                    long j2 = WeedOutManager.this.maxSizeMB * 1024 * 1024;
                    HashMap hashMap = new HashMap();
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "start weedOut:" + (currentTimeMillis - (i * 86400000)));
                    }
                    Iterator it2 = WeedOutManager.this.strategies.iterator();
                    long j3 = 0;
                    while (it2.hasNext()) {
                        WeedOutStrategy weedOutStrategy = (WeedOutStrategy) it2.next();
                        WeedOutItem weedOutItem = new WeedOutItem();
                        hashMap.put(weedOutStrategy.getName(), weedOutItem);
                        weedOutItem.setName(weedOutStrategy.getName());
                        weedOutItem.setBeforeSize(weedOutStrategy.getSize());
                        if (ApmContext.isDebugMode()) {
                            it = it2;
                            j = j2;
                            Logger.m119d(Constants.TAG, "weedOut:name:" + weedOutItem.getName() + " beforeSize:" + weedOutItem.getBeforeSize());
                        } else {
                            j = j2;
                            it = it2;
                        }
                        weedOutStrategy.doWeedOut(currentTimeMillis - (i * 86400000));
                        long size = weedOutStrategy.getSize();
                        weedOutItem.setAfterSize(size);
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "weedOut:name:" + weedOutItem.getName() + " afterSize:" + weedOutItem.getAfterSize());
                        }
                        j3 += size;
                        it2 = it;
                        j2 = j;
                    }
                    long j4 = j2;
                    for (int i2 = i - 1; j3 > j4 && i2 > 0; i2--) {
                        j3 = 0;
                        for (WeedOutStrategy weedOutStrategy2 : WeedOutManager.this.strategies) {
                            weedOutStrategy2.doWeedOut(currentTimeMillis - (i2 * 86400000));
                            long size2 = weedOutStrategy2.getSize();
                            WeedOutItem weedOutItem2 = (WeedOutItem) hashMap.get(weedOutStrategy2.getName());
                            if (weedOutItem2 != null) {
                                weedOutItem2.setAfterSize(size2);
                            }
                            j3 += weedOutStrategy2.getSize();
                        }
                    }
                    if (WeedOutManager.this.maxSizeMBToday > 0) {
                        long j5 = WeedOutManager.this.maxSizeMBToday * 1024 * 1024;
                        if (j3 > j5) {
                            for (WeedOutStrategy weedOutStrategy3 : WeedOutManager.this.strategies) {
                                long size3 = weedOutStrategy3.getSize();
                                if (size3 > 0) {
                                    weedOutStrategy3.doWeedOutSize(j5);
                                    long size4 = weedOutStrategy3.getSize();
                                    WeedOutItem weedOutItem3 = (WeedOutItem) hashMap.get(weedOutStrategy3.getName());
                                    if (weedOutItem3 != null) {
                                        if (ApmContext.isDebugMode()) {
                                            Logger.m119d(Constants.TAG, "weedOut:name:" + weedOutItem3.getName() + " afterSize:" + size4 + " maxBytesToday clean: " + (size3 - size4));
                                        }
                                        weedOutItem3.setReachTopOfToday(true);
                                        weedOutItem3.setAfterSize(size4);
                                    }
                                }
                            }
                        }
                    }
                    if (WeedOutManager.this.listener != null) {
                        WeedOutManager.this.listener.onWeedOut(new ArrayList(hashMap.values()));
                    }
                }
            });
        }
    }
}
