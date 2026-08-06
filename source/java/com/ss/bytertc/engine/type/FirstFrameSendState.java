package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum FirstFrameSendState {
    FIRST_FRAME_SEND_STATE_SENDING(0),
    FIRST_FRAME_SEND_STATE_SENT(1),
    FIRST_FRAME_SEND_STAT_END(2);

    private int state;

    FirstFrameSendState(int state) {
        this.state = state;
    }

    public int value() {
        return this.state;
    }

    public static FirstFrameSendState fromId(int type) {
        for (FirstFrameSendState firstFrameSendState : values()) {
            if (firstFrameSendState.value() == type) {
                return firstFrameSendState;
            }
        }
        return FIRST_FRAME_SEND_STATE_SENDING;
    }
}
