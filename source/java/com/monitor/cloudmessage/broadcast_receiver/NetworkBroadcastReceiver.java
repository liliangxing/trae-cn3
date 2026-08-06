package com.monitor.cloudmessage.broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.util.NetUtils;
import com.monitor.cloudmessage.CloudMessageManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.monitor.cloudmessage.broadcast_receiver.NetworkBroadcastReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                if (NetUtils.isNetworkAvailable(context)) {
                    CloudMessageManager.getInstance().fetchCommandImmediately();
                }
            }
        });
    }
}
