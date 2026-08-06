package com.lynx.tasm.event;

import java.util.Map;

/* loaded from: classes7.dex */
public class LynxInternalEvent {
    public static final int NEED_VALIDATE = 0;
    private int mInternalEventId;
    private int mTag;

    public Map<String, Object> getParams() {
        return null;
    }

    public LynxInternalEvent(int i, int i2) {
        this.mTag = i;
        this.mInternalEventId = i2;
    }

    public int getTag() {
        return this.mTag;
    }

    public int getEventId() {
        return this.mInternalEventId;
    }
}
