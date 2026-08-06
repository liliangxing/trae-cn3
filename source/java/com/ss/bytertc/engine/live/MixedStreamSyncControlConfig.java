package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class MixedStreamSyncControlConfig {
    public MixedStreamSyncStrategy syncStrategy = MixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
    public int maxCacheTimeMs = 2000;
    public boolean videoNeedSdkMix = true;
    public String baseUserID = "";
    public String baseRoomID = "";
    public MixedStreamVideoType baseStreamType = MixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_MAIN;
    public int baseStreamStartDelayMs = 0;
}
