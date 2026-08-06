package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.video.IVideoFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushMixedStreamToCDNObserver {
    private IClientMixedStreamObserver mLiveTransObserver = null;

    public void onClientMixedStreamEvent(MixedStreamTaskInfo info, MixedStreamType type, MixedStreamTaskEvent event, MixedStreamTaskErrorCode error) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onClientMixedStreamEvent(info, type, event, error);
        }
    }

    public void onMixedAudioFrame(String taskId, byte[] audioFrame, int frameNum, long timeStampe) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onMixedAudioFrame(taskId, audioFrame, frameNum, timeStampe);
        }
    }

    public void onMixedVideoFrame(String taskId, IVideoFrame videoFrame) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onMixedVideoFrame(taskId, videoFrame);
        }
    }

    public void onMixedFirstAudioFrame(String taskId) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onMixedFirstAudioFrame(taskId);
        }
    }

    public void onMixedFirstVideoFrame(String taskId) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onMixedFirstVideoFrame(taskId);
        }
    }

    public void onMixedDataFrame(String taskId, byte[] dataFrame, long time) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onMixedDataFrame(taskId, dataFrame, time);
        }
    }

    public void onCacheSyncVideoFrames(String taskId, String[] userIds, IVideoFrame[] videoFrame, byte[][] dataFrame, int count) {
        IClientMixedStreamObserver iClientMixedStreamObserver = this.mLiveTransObserver;
        if (iClientMixedStreamObserver != null) {
            iClientMixedStreamObserver.onCacheSyncVideoFrames(taskId, userIds, videoFrame, dataFrame, count);
        }
    }

    public void setUserObserver(IClientMixedStreamObserver liveTranscodingObserver) {
        this.mLiveTransObserver = liveTranscodingObserver;
    }
}
