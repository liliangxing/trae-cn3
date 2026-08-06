package com.bytedance.apm.observer;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm6.util.log.Logger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LogObserver {
    private static final String TAG = "LogObserver";
    private static volatile LogObserver singleton;
    CopyOnWriteArraySet<IApmLogListener> logObserverList = new CopyOnWriteArraySet<>();

    private LogObserver() {
    }

    public static LogObserver getInstance() {
        if (singleton == null) {
            synchronized (LogObserver.class) {
                if (singleton == null) {
                    singleton = new LogObserver();
                }
            }
        }
        return singleton;
    }

    public void notifyObservers(final String str, final String str2, final JSONObject jSONObject) {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(TAG, "logObserverList:" + this.logObserverList.size());
        }
        if (this.logObserverList.size() == 0) {
            return;
        }
        AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.observer.LogObserver.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<IApmLogListener> it = LogObserver.this.logObserverList.iterator();
                while (it.hasNext()) {
                    it.next().onLog(str, str2, jSONObject);
                }
            }
        });
    }

    public void addLogObserver(IApmLogListener iApmLogListener) {
        if (iApmLogListener != null) {
            try {
                this.logObserverList.add(iApmLogListener);
            } catch (Throwable unused) {
            }
        }
    }

    public void removeLogObserver(IApmLogListener iApmLogListener) {
        if (iApmLogListener != null) {
            try {
                this.logObserverList.remove(iApmLogListener);
            } catch (Throwable unused) {
            }
        }
    }
}
