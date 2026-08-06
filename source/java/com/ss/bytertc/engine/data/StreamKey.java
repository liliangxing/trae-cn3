package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class StreamKey {
    private String roomId;
    private StreamIndex streamIndex;
    private String userId;

    public StreamKey(String roomId, String userId, StreamIndex index) {
        this.roomId = roomId;
        this.userId = userId;
        this.streamIndex = index;
    }

    public static StreamKey create(String roomId, String userId, StreamIndex streamIndex) {
        return new StreamKey(roomId, userId, streamIndex);
    }

    public String toString() {
        return "RemoteStreamKey{roomId='" + this.roomId + "', userId='" + this.userId + "', streamIndex=" + this.streamIndex + AbstractJsonLexerKt.END_OBJ;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getUserId() {
        return this.userId;
    }

    public StreamIndex getStreamIndex() {
        return this.streamIndex;
    }

    public boolean hasNullProperty() {
        return this.roomId == null || this.userId == null || this.streamIndex == null;
    }
}
