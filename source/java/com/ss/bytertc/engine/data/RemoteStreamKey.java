package com.ss.bytertc.engine.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RemoteStreamKey {
    public String roomId;
    public StreamIndex streamIndex;
    public String userId;

    public RemoteStreamKey(String roomId, String userId, StreamIndex streamIndex) {
        this.roomId = roomId;
        this.userId = userId;
        this.streamIndex = streamIndex;
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
