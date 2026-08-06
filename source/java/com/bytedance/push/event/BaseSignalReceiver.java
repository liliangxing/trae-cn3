package com.bytedance.push.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.bytedance.android.service.manager.alliance.SmpProcessInitCallback;
import com.bytedance.push.BDPush;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;

/* loaded from: classes4.dex */
public class BaseSignalReceiver extends BroadcastReceiver {
    private final String COMPONENT_START_REASON_SIGNAL = IAllianceService.LAUNCH_FROM_SIGNAL;
    private final String TAG = "BaseSignalReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        Logger.d("BaseSignalReceiver", "[onReceive]" + intent.getAction());
        if (ToolUtils.isSmpProcess(context)) {
            BDPush.getPushService().onSmpProcessStart(context, this, IAllianceService.LAUNCH_FROM_SIGNAL, new SmpProcessInitCallback() { // from class: com.bytedance.push.event.BaseSignalReceiver.1
                @Override // com.bytedance.android.service.manager.alliance.SmpProcessInitCallback
                public void onFinishInit() {
                    PushSupporter.get().getSignalReportService().onReceiveSignal(intent);
                }
            });
        } else {
            PushSupporter.get().getSignalReportService().onReceiveSignal(intent);
        }
    }
}
