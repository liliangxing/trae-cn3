package com.bytedance.sync.p005v4.intf;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.ss.android.ug.bus.IUgBusService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IWsStatusService extends IUgBusService {
    void addWsStatusChangedListener(WsStatusKeeper.OnWsStatusChangedListener onWsStatusChangedListener);

    ConnectEvent getCurrentStatus();

    boolean isConnect();

    void removeWsStatusChangedListener(WsStatusKeeper.OnWsStatusChangedListener onWsStatusChangedListener);
}
