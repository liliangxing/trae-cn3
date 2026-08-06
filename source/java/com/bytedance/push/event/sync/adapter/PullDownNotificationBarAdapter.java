package com.bytedance.push.event.sync.adapter;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.interfaze.ISystemBroadcastService;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PullDownNotificationBarAdapter extends AbsSignalReporterAdapter implements ISystemBroadcastService.IBroadcastReceiver {
    private final String TAG = "PullDownNotificationBarAdapter";

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_PULL_DOWN_NOTIFICATION_BAR;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        PushSupporter.get().getSystemBroadcastService().addNotificationBarPullDownListener(this);
    }

    @Override // com.bytedance.push.interfaze.ISystemBroadcastService.IBroadcastReceiver
    public void onReceiveFromPushSystemBroadcastService(Intent intent) {
        Logger.m268d("PullDownNotificationBarAdapter", "[onReceiveFromPushSystemBroadcastService]action:" + intent.getAction());
        if (TextUtils.equals(intent.getAction(), ISystemBroadcastService.MIUI_NOTIFICATION_ACTION)) {
            PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.mSignalReportConfig, getSignalName(), this.mTriggerScene, null);
        }
    }
}
