package com.bytedance.push.event.sync.adapter;

import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.INotificationDeleteListener;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationClearReporter extends AbsSignalReporterAdapter implements INotificationDeleteListener {
    private volatile boolean hasReportCurBatchClearSignal;
    private long lastNotificationDeleteTime;
    private final String TAG = "NotificationClearReporter";
    private final long NOTIFICATION_CLEAR_MIN_INTERVAL_IN_MILL = 1000;

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_CLEAR_NOTIFICATION;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        PushSupporter.get().getSignalReportService().registerNotificationDeleteListener(this);
    }

    @Override // com.bytedance.push.event.sync.INotificationDeleteListener
    public void onNotificationDelete(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.lastNotificationDeleteTime;
        Logger.m268d("NotificationClearReporter", "[onNotificationDelete]notificationId:" + j + " currentTimeMillis:" + currentTimeMillis + " lastNotificationDeleteTime:" + this.lastNotificationDeleteTime + " gap:" + j2);
        if (j2 <= 1000) {
            if (this.hasReportCurBatchClearSignal) {
                Logger.m268d("NotificationClearReporter", "[onNotificationDelete]do nothing because cur batch clear signal has reported");
            } else {
                Logger.m268d("NotificationClearReporter", "[onNotificationDelete]find all type notification clear");
                reportNotificationClearSignal("all");
            }
            this.hasReportCurBatchClearSignal = true;
        } else {
            Logger.m268d("NotificationClearReporter", "[onNotificationDelete]find single notification clear");
            this.hasReportCurBatchClearSignal = false;
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.NotificationClearReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!NotificationClearReporter.this.hasReportCurBatchClearSignal) {
                        Logger.m268d("NotificationClearReporter", "[onNotificationDelete]find single type notification clear");
                        NotificationClearReporter.this.reportNotificationClearSignal(ISignalReportConstants.CLEAR_TYPE_SINGLE);
                    } else {
                        Logger.m268d("NotificationClearReporter", "[onNotificationDelete]hasReportCurBatchClearSignal is true so cur notification clear is an all type clear,not report single clear");
                    }
                }
            }, 1000L);
        }
        this.lastNotificationDeleteTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportNotificationClearSignal(String str) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, ISignalReportConstants.KEY_CLEAR_TYPE, str);
        PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.mSignalReportConfig, getSignalName(), this.mTriggerScene, jSONObject);
    }
}
