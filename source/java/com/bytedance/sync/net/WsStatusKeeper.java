package com.bytedance.sync.net;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.interfaze.IWsStatusChangedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WsStatusKeeper implements IWsStatusChangedListener {
    private final Configuration configuration;
    private ConnectEvent currentEvent;
    private final List<onWsStatusChangedListener> listeners = new ArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface onWsStatusChangedListener {
        void onWsStatusChanged(boolean z);
    }

    public WsStatusKeeper(Configuration configuration) {
        this.configuration = configuration;
        configuration.wsService.registerOnWsStatusChangedListener(this);
    }

    @Override // com.bytedance.sync.interfaze.IWsStatusChangedListener
    public void onReceiveConnectEvent(ConnectEvent connectEvent) {
        if (connectEvent == null || connectEvent.mChannelId != this.configuration.channelId) {
            return;
        }
        ConnectEvent connectEvent2 = this.currentEvent;
        boolean z = connectEvent2 != null && connectEvent2.connectionState == ConnectionState.CONNECTED;
        boolean z2 = connectEvent != null && connectEvent.connectionState == ConnectionState.CONNECTED;
        this.currentEvent = connectEvent;
        if (z != z2) {
            synchronized (this) {
                Iterator<onWsStatusChangedListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onWsStatusChanged(z2);
                }
            }
        }
    }

    public void addWsStatusChangedListener(onWsStatusChangedListener onwsstatuschangedlistener) {
        synchronized (this) {
            this.listeners.add(onwsstatuschangedlistener);
        }
    }

    public void removeWsStatusChangedListener(onWsStatusChangedListener onwsstatuschangedlistener) {
        synchronized (this) {
            this.listeners.remove(onwsstatuschangedlistener);
        }
    }

    public ConnectEvent getCurrentStatus() {
        return this.currentEvent;
    }

    public boolean isConnect() {
        ConnectEvent connectEvent = this.currentEvent;
        if (connectEvent == null || connectEvent.connectionState != ConnectionState.CONNECTED) {
            return this.configuration.wsService.isConnect();
        }
        return true;
    }
}
