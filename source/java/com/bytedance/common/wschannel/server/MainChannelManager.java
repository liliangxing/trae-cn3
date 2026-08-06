package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.server.IEnableObserver;
import java.util.Collections;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MainChannelManager {
    private static volatile ChannelManager sInstance;

    private MainChannelManager() {
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
        MainMsgHandler mainMsgHandler = new MainMsgHandler(context, channelKeeper);
        ChannelManager channelManager = new ChannelManager(context, handlerThread.getLooper(), new IWsChannelSaver() { // from class: com.bytedance.common.wschannel.server.MainChannelManager.2
            @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
            public void saveWsChannels(Map<Integer, IWsApp> map) {
            }

            @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
            public Map<Integer, IWsApp> loadWsChannels() {
                return Collections.emptyMap();
            }
        }, channelKeeper, mainMsgHandler, new IEnableObserver() { // from class: com.bytedance.common.wschannel.server.MainChannelManager.1
            @Override // com.bytedance.common.wschannel.server.IEnableObserver
            public boolean isEnable() {
                return true;
            }

            @Override // com.bytedance.common.wschannel.server.IEnableObserver
            public void setEnableListener(IEnableObserver.OnWsChannelEnableChangedObserver onWsChannelEnableChangedObserver) {
            }

            @Override // com.bytedance.common.wschannel.server.IEnableObserver
            public void startLoad() {
            }
        });
        mainMsgHandler.setChannelManager(channelManager);
        return channelManager;
    }
}
