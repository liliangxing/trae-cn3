package com.bytedance.common.wschannel.server;

import android.content.Intent;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.MemTrimListener;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.AbsMessengerService;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelService extends AbsMessengerService {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getClientKey(IWsApp iWsApp) {
        if (iWsApp == null) {
            return Integer.MIN_VALUE;
        }
        return iWsApp.getChannelId();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onCreate() {
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "onCreate");
        }
        super.onCreate();
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "onStartCommand");
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.server.WsChannelService.1
            @Override // java.lang.Runnable
            public void run() {
                WsChannelService.this.handleIntent(intent);
            }
        });
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (WsConstants.APP_STATE_ACTION.equals(action)) {
            int intExtra = intent.getIntExtra(WsConstants.KEY_APP_STATE, -1);
            Message message = new Message();
            message.what = 2;
            message.arg1 = intExtra;
            handleMsg(message);
            return;
        }
        if (WsConstants.NETWORK_STATE_ACTION.equals(action)) {
            int intExtra2 = intent.getIntExtra(WsConstants.KEY_NETWORK_STATE, -1);
            Message message2 = new Message();
            message2.what = 3;
            message2.arg1 = intExtra2;
            handleMsg(message2);
            return;
        }
        if (WsConstants.MEM_TRIM_ACTION.equals(action)) {
            int intExtra3 = intent.getIntExtra(WsConstants.KEY_MEM_TRIM, -1);
            MemTrimListener memTrimListener = WsChannelSdk.getMemTrimListener();
            if (memTrimListener != null) {
                memTrimListener.onTrimMemory(intExtra3);
            }
        }
    }

    @Override // com.bytedance.common.wschannel.app.AbsMessengerService, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        super.handleMsg(message);
        if (message == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelService", "handleMsg msg.what = " + message.what);
        }
        PushChannelManager.inst(this).handleMsg(message);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Msg {
        final int channelId;
        final byte[] data;
        final WsChannelMsg message;

        /* renamed from: ts */
        final long f132ts;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Msg(int i, byte[] bArr, long j) {
            this.channelId = i;
            this.data = bArr;
            this.f132ts = j;
            this.message = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Msg(int i, WsChannelMsg wsChannelMsg, long j) {
            this.channelId = i;
            this.message = wsChannelMsg;
            this.f132ts = j;
            this.data = null;
        }
    }
}
