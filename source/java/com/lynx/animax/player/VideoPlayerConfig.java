package com.lynx.animax.player;

import com.lynx.animax.service.ServiceRegistry;

/* loaded from: classes6.dex */
public class VideoPlayerConfig {
    private final ServiceRegistry mServiceRegistry;
    private VideoPlayerType mPlayerType = VideoPlayerType.DEFAULT;
    private long mVideoFrameTimeout = 0;
    private long mSurfaceDestroyTimeout = 0;

    public VideoPlayerConfig(ServiceRegistry serviceRegistry) {
        this.mServiceRegistry = serviceRegistry;
    }

    public void setPlayerType(VideoPlayerType videoPlayerType) {
        this.mPlayerType = videoPlayerType;
    }

    public void setVideoFrameTimeout(long j) {
        this.mVideoFrameTimeout = j;
    }

    public void setSurfaceDestroyTimeout(long j) {
        this.mSurfaceDestroyTimeout = j;
    }

    public VideoPlayerType getPlayerType() {
        return this.mPlayerType;
    }

    public long getVideoFrameTimeout() {
        return this.mVideoFrameTimeout;
    }

    public long getSurfaceDestroyTimeout() {
        return this.mSurfaceDestroyTimeout;
    }

    public ServiceRegistry getServiceRegistry() {
        return this.mServiceRegistry;
    }
}
