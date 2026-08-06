package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IClientMixedStreamObserver {
    void onCacheSyncVideoFrames(String taskId, String[] userIds, IVideoFrame[] videoFrame, byte[][] dataFrame, int count);

    void onClientMixedStreamEvent(MixedStreamTaskInfo info, MixedStreamType type, MixedStreamTaskEvent event, MixedStreamTaskErrorCode error);

    void onMixedAudioFrame(String taskId, byte[] audioFrame, int frameNum, long timeStampMs);

    void onMixedDataFrame(String taskId, byte[] dataFrame, long time);

    void onMixedFirstAudioFrame(String taskId);

    void onMixedFirstVideoFrame(String taskId);

    void onMixedVideoFrame(String taskId, IVideoFrame videoFrame);
}
