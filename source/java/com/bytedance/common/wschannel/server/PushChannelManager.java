package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushChannelManager {
    private static volatile ChannelManager sInstance;

    private PushChannelManager() {
    }

    public static ChannelManager inst(Context context) {
        if (sInstance == null) {
            synchronized (ChannelManager.class) {
                if (sInstance == null) {
                    sInstance = createChannelManager(context);
                }
            }
        }
        return sInstance;
    }

    private static ChannelManager createChannelManager(Context context) {
        HandlerThread handlerThread = new HandlerThread("wschannel");
        handlerThread.start();
        ChannelKeeper channelKeeper = new ChannelKeeper();
        WsChannelMsgHandler wsChannelMsgHandler = new WsChannelMsgHandler(context, channelKeeper);
        ChannelManager channelManager = new ChannelManager(context, handlerThread.getLooper(), new WsChannelSaver(context), channelKeeper, wsChannelMsgHandler, new WsChannelEnableObserver(context, new WeakHandler(handlerThread.getLooper(), new WeakHandler.IHandler() { // from class: com.bytedance.common.wschannel.server.PushChannelManager.1
            @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
            public void handleMsg(Message message) {
            }
        })));
        wsChannelMsgHandler.setChannelManager(channelManager);
        return channelManager;
    }
}
