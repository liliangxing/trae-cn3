package com.bytedance.common.wschannel;

import com.bytedance.common.wschannel.model.WsChannelMsg;

/* loaded from: classes3.dex */
final class MainProcessMsg extends WsChannelMsg {
    private final MsgSendListener mListener;
    private final WsChannelMsg origin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MainProcessMsg(WsChannelMsg wsChannelMsg, MsgSendListener msgSendListener) {
        super(wsChannelMsg);
        this.origin = wsChannelMsg;
        this.mListener = msgSendListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsChannelMsg getOrigin() {
        return this.origin;
    }

    public MsgSendListener getListener() {
        return this.mListener;
    }
}
