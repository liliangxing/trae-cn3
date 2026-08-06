package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ForwardStreamInfo;

/* loaded from: classes7.dex */
public class InternalForwardStreamInfo {
    public String roomId;
    public String token;

    public InternalForwardStreamInfo(String roomId, String token) {
        this.roomId = roomId;
        this.token = token;
    }

    public InternalForwardStreamInfo(ForwardStreamInfo info) {
        this.roomId = info.roomId;
        this.token = info.token;
    }

    public String getRoomId() {
        String str = this.roomId;
        return str == null ? "" : str;
    }

    public String getToken() {
        String str = this.token;
        return str == null ? "" : str;
    }
}
