package com.bytedance.sync.p005v4.net;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.interfaze.IWsStatusChangedListener;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WsStatusKeeper implements IWsStatusChangedListener, IWsStatusService {
    private final Configuration configuration;
    private ConnectEvent currentEvent;
    private final List<OnWsStatusChangedListener> mListeners = new ArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnWsStatusChangedListener {
        void onWsStatusChanged(boolean z);
    }

    public WsStatusKeeper() {
        Configuration config = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
        this.configuration = config;
        config.wsService.registerOnWsStatusChangedListener(this);
    }

    @Override // com.bytedance.sync.interfaze.IWsStatusChangedListener
    public void onReceiveConnectEvent(ConnectEvent connectEvent) {
        if (connectEvent == null || connectEvent.mChannelId != this.configuration.channelId) {
            return;
        }
        ConnectEvent connectEvent2 = this.currentEvent;
        boolean z = connectEvent2 != null && connectEvent2.connectionState == ConnectionState.CONNECTED;
        boolean z2 = connectEvent.connectionState == ConnectionState.CONNECTED;
        this.currentEvent = connectEvent;
        if (z != z2) {
            synchronized (this) {
                int size = this.mListeners.size();
                OnWsStatusChangedListener[] onWsStatusChangedListenerArr = new OnWsStatusChangedListener[size];
                this.mListeners.toArray(onWsStatusChangedListenerArr);
                for (int i = 0; i < size; i++) {
                    onWsStatusChangedListenerArr[i].onWsStatusChanged(z2);
                }
            }
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IWsStatusService
    public void addWsStatusChangedListener(OnWsStatusChangedListener onWsStatusChangedListener) {
        synchronized (this) {
            this.mListeners.add(onWsStatusChangedListener);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IWsStatusService
    public void removeWsStatusChangedListener(OnWsStatusChangedListener onWsStatusChangedListener) {
        synchronized (this) {
            this.mListeners.remove(onWsStatusChangedListener);
        }
    }

    @Override // com.bytedance.sync.p005v4.intf.IWsStatusService
    public ConnectEvent getCurrentStatus() {
        return this.currentEvent;
    }

    @Override // com.bytedance.sync.p005v4.intf.IWsStatusService
    public boolean isConnect() {
        ConnectEvent connectEvent = this.currentEvent;
        if (connectEvent == null || connectEvent.connectionState != ConnectionState.CONNECTED) {
            return this.configuration.wsService.isConnect();
        }
        return true;
    }
}
