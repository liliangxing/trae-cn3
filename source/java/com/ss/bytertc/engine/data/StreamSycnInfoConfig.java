package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class StreamSycnInfoConfig {
    public int repeatCount;
    public StreamIndex streamIndex;
    public SyncInfoStreamType streamType;

    /* loaded from: classes7.dex */
    public enum SyncInfoStreamType {
        SYNC_INFO_STREAM_TYPE_AUDIO
    }

    public StreamSycnInfoConfig(StreamIndex streamIndex, int repeatCount, SyncInfoStreamType streamType) {
        this.streamIndex = streamIndex;
        this.repeatCount = repeatCount;
        this.streamType = streamType;
    }

    public String toString() {
        return "StreamSycnInfoConfig{ streamIndex='" + this.streamIndex.toString() + "'repeatCount='" + this.repeatCount + "'streamType=Audio }";
    }
}
