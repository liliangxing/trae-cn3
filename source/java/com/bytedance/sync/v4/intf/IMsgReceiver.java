package com.bytedance.sync.v4.intf;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ss.android.ug.bus.IUgBusService;
import kotlin.Metadata;

/* compiled from: IMsgReceiver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/sync/v4/intf/IMsgReceiver;", "Lcom/ss/android/ug/bus/IUgBusService;", "onReceiveWsEvent", "", "msg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "registerWsChannelEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/sync/v4/intf/IReceiveWsMsg;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public interface IMsgReceiver extends IUgBusService {
    void onReceiveWsEvent(WsChannelMsg msg);

    void registerWsChannelEventListener(IReceiveWsMsg listener);
}
