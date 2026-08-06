package com.bytedance.sync.p005v4.intf;

import com.bytedance.common.wschannel.model.WsChannelMsg;
import kotlin.Metadata;

/* compiled from: IReceiveWsMsg.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sync/v4/intf/IReceiveWsMsg;", "", "onReceiveWsMsg", "", "msg", "Lcom/bytedance/common/wschannel/model/WsChannelMsg;", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IReceiveWsMsg {
    void onReceiveWsMsg(WsChannelMsg msg);
}
