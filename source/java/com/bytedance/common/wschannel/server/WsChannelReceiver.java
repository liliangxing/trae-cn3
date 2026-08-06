package com.bytedance.common.wschannel.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.server.NetworkUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelReceiver extends BroadcastReceiver {
    private static boolean sFrontierEnabled;
    private boolean mIsFirstTimeReceiveNetChangedAction = true;
    private ChannelManager mManager;
    private NetworkUtils.NetworkType mOnCreateNetworkType;

    @Deprecated
    public WsChannelReceiver() {
    }

    public WsChannelReceiver(Context context, ChannelManager channelManager) {
        this.mOnCreateNetworkType = NetworkUtils.getNetworkType(context);
        this.mManager = channelManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (context == null || intent == null || this.mManager == null || TextUtils.isEmpty(intent.getAction()) || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            return;
        }
        if (this.mIsFirstTimeReceiveNetChangedAction) {
            this.mIsFirstTimeReceiveNetChangedAction = false;
            if (NetworkUtils.getNetworkType(context) == this.mOnCreateNetworkType) {
                return;
            }
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.server.WsChannelReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                WsChannelReceiver.this.loadFrontierEnabled(context);
                if (WsChannelReceiver.sFrontierEnabled) {
                    try {
                        if (Logger.debug()) {
                            Logger.m190d("WsChannelReceiver", "ConnectivityReceiver");
                        }
                        int networkState = NetworkUtils.getNetworkState(context);
                        Message obtain = Message.obtain();
                        obtain.what = 3;
                        obtain.arg1 = networkState;
                        WsChannelReceiver.this.mManager.handleMsg(obtain);
                    } catch (Exception unused) {
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFrontierEnabled(Context context) {
        try {
            boolean isEnable = WsChannelSettings.inst(context).isEnable();
            if (isEnable != sFrontierEnabled) {
                sFrontierEnabled = isEnable;
            }
        } catch (Throwable unused) {
        }
    }
}
