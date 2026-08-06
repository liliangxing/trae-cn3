package com.bytedance.sync.v4.recv;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.sync.v4.intf.IMsgReceiver;
import com.bytedance.sync.v4.intf.IReceiveWsMsg;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: MsgReceiverService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sync/v4/recv/MsgReceiverService;", "Lcom/bytedance/sync/v4/intf/IMsgReceiver;", "()V", "mWsChannelEventListener", "", "Lcom/bytedance/sync/v4/intf/IReceiveWsMsg;", "onReceiveWsEvent", "", "msg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "registerWsChannelEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class MsgReceiverService implements IMsgReceiver {
    private final List<IReceiveWsMsg> mWsChannelEventListener = new ArrayList();

    @Override // com.bytedance.sync.v4.intf.IMsgReceiver
    public void onReceiveWsEvent(WsChannelMsg msg) {
        for (IReceiveWsMsg iReceiveWsMsg : this.mWsChannelEventListener) {
            if (iReceiveWsMsg != null) {
                iReceiveWsMsg.onReceiveWsMsg(msg);
            }
        }
    }

    @Override // com.bytedance.sync.v4.intf.IMsgReceiver
    public void registerWsChannelEventListener(IReceiveWsMsg listener) {
        if (listener == null) {
            return;
        }
        this.mWsChannelEventListener.add(listener);
    }
}
