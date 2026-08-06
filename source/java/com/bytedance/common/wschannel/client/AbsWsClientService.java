package com.bytedance.common.wschannel.client;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.ClientMsgParser;
import com.bytedance.common.wschannel.model.ClientServiceTrace;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.TimeCompactUtil;
import com.bytedance.ies.argus.bean.ArgusConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsWsClientService extends Service implements WeakHandler.IHandler, ClientMsgParser.ParserListener {
    public static final String TAG = "AbsWsClientService";
    private Messenger mMessenger;
    private final Handler mHandler = new WeakHandler(this);
    private final ClientMsgParser parser = new ClientMsgParser(this);

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onReceive(WsChannelMsg wsChannelMsg) {
    }

    @Override // com.bytedance.common.wschannel.client.ClientMsgParser.ParserListener
    public void onSendResult(String str, boolean z) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mMessenger = new Messenger(this.mHandler);
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, int i, int i2) {
        if (Logger.debug()) {
            Logger.m190d(TAG, "onStartCommand intent = " + (intent != null ? intent.toString() : ArgusConstants.NULL_PLACE_HOLDER));
        }
        final long timeStampNanos = TimeCompactUtil.getTimeStampNanos();
        SocketHandler.inst().postRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.AbsWsClientService.1
            @Override // java.lang.Runnable
            public void run() {
                AbsWsClientService.this.handleIntent(intent, timeStampNanos);
            }
        });
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (Logger.debug()) {
            Logger.m190d(TAG, "onDestroy");
        }
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message message) {
        try {
            final long timeStampNanos = TimeCompactUtil.getTimeStampNanos();
            if (message == null || message.what != 10123) {
                return;
            }
            final Intent intent = (Intent) message.getData().getParcelable(WsConstants.DATA_INTENT);
            if (Logger.debug()) {
                Logger.m190d(TAG, "handleMsg = " + intent);
            }
            if (intent != null) {
                SocketHandler.inst().postRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.AbsWsClientService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsWsClientService.this.handleIntent(intent, timeStampNanos);
                    }
                });
            } else {
                Logger.m193e(TAG, "handleMsg but intent isnull");
            }
        } catch (Exception e) {
            Logger.m192e(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIntent(Intent intent, long j) {
        if (intent == null) {
            return;
        }
        this.parser.parse(intent, new ClientServiceTrace(j));
    }
}
