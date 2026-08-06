package com.bytedance.common.wschannel.app;

import com.bytedance.common.wschannel.event.MessageAckEvent;

/* loaded from: classes3.dex */
public interface OnMessageAckListener {
    void onReceiveMsgAck(MessageAckEvent messageAckEvent);
}
