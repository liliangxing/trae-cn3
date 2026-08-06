package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRoomEventInfo;

/* loaded from: classes7.dex */
public class RoomEventInfo {
    public long forbiddenTime;

    public RoomEventInfo(InternalRoomEventInfo info) {
        this.forbiddenTime = 0L;
        this.forbiddenTime = info.forbiddenTime;
    }
}
