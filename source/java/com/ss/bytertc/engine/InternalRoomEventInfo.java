package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRoomEventInfo {
    public long forbiddenTime;

    public InternalRoomEventInfo(long forbiddenTime) {
        this.forbiddenTime = forbiddenTime;
    }

    private static InternalRoomEventInfo create(long forbiddenTime) {
        return new InternalRoomEventInfo(forbiddenTime);
    }
}
