package com.bytedance.push.monitor.multiprocess;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.push.monitor.PushMonitor;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushMultiProcessMonitor implements Handler.Callback {
    private static volatile PushMultiProcessMonitor pushMultiProcessMonitor;
    private final String TAG = "PushMultiProcessMonitor";
    private final int MSG_WHAT_REPORT_EVENT = 4171758;
    private final long REPORT_EVENT_INTERVAL = 60000;
    private final long REPORT_EVENT_INTERVAL_BACKGROUND = 600000;
    private final int BATCH_NUM = 10;

    public static PushMultiProcessMonitor getInstance() {
        if (pushMultiProcessMonitor == null) {
            synchronized (PushMultiProcessMonitor.class) {
                if (pushMultiProcessMonitor == null) {
                    pushMultiProcessMonitor = new PushMultiProcessMonitor();
                }
            }
        }
        return pushMultiProcessMonitor;
    }

    private PushMultiProcessMonitor() {
    }

    public void monitorEvent(final String str, final JSONObject jSONObject, final JSONObject jSONObject2, final JSONObject jSONObject3) {
        final Application app = AppProvider.getApp();
        if (ToolUtils.isMainProcess(app)) {
            Logger.m268d("PushMultiProcessMonitor", "on main process monitor event,report now:" + str);
            PushMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        } else {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.monitor.multiprocess.PushMultiProcessMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MonitorEvent monitorEvent = new MonitorEvent(str, jSONObject, jSONObject2, jSONObject3);
                        Logger.m268d("PushMultiProcessMonitor", String.format("on child process monitor event,insert to db:%s", monitorEvent));
                        MultiProcessMonitorDBHelper multiProcessMonitorDBHelper = MultiProcessMonitorDBHelper.getInstance(app);
                        if (multiProcessMonitorDBHelper != null) {
                            long insertEvent = multiProcessMonitorDBHelper.insertEvent(monitorEvent);
                            if (insertEvent < 0) {
                                Logger.m278w("PushMultiProcessMonitor", String.format("failed to insert event to monitor db, insert result:%s", Long.valueOf(insertEvent)));
                            } else {
                                Logger.m268d("PushMultiProcessMonitor", String.format("success to insert event to monitor db, insert result:%s", Long.valueOf(insertEvent)));
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void startReport() {
        Logger.m268d("PushMultiProcessMonitor", "startReport");
        PushThreadHandlerManager.inst().addHandlerCallback(this);
        PushThreadHandlerManager.inst().getHandler().sendEmptyMessage(4171758);
    }

    private void reportEvent() {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.monitor.multiprocess.PushMultiProcessMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.m268d("PushMultiProcessMonitor", "reportEvent now");
                MultiProcessMonitorDBHelper multiProcessMonitorDBHelper = MultiProcessMonitorDBHelper.getInstance(AppProvider.getApp());
                List<MonitorEvent> events = multiProcessMonitorDBHelper.getEvents(10);
                Logger.m268d("PushMultiProcessMonitor", "events len is :" + events.size());
                while (!events.isEmpty()) {
                    Iterator<MonitorEvent> it = events.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            MonitorEvent next = it.next();
                            Logger.m268d("PushMultiProcessMonitor", "report:" + next.serviceName);
                            PushMonitor.monitorEvent(next.serviceName, next.getCategory(), next.getMetric(), next.getExtra());
                            if (!multiProcessMonitorDBHelper.deleteEvent(next.f91id)) {
                                Logger.m278w("PushMultiProcessMonitor", "error when delete monitor event,break now");
                                break;
                            }
                        }
                    }
                    events = multiProcessMonitorDBHelper.getEvents(10);
                }
                PushThreadHandlerManager.inst().getHandler().sendEmptyMessageDelayed(4171758, ActivityLifecycleObserver.getIns().isBackGround() ? 600000L : 60000L);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 4171758) {
            return false;
        }
        reportEvent();
        return true;
    }
}
