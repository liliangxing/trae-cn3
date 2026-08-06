package com.bytedance.bdturing.livedetect.camera;

import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes3.dex */
public class OrientationHelper {
    private int mCameraFacing;
    private int mCameraSensorOrientation;
    private int mRotateDegree;
    private int mScreenOrientation;

    public synchronized void setScreenOrientation(int i) {
        this.mScreenOrientation = i;
    }

    public synchronized void setCameraSensorOrientation(int i) {
        this.mCameraSensorOrientation = i;
    }

    public synchronized void setCameraFacing(int i) {
        this.mCameraFacing = i;
    }

    public synchronized void computeRotateDegree() {
        if (this.mCameraFacing == 0) {
            this.mRotateDegree = ((this.mCameraSensorOrientation - this.mScreenOrientation) + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        } else {
            int i = this.mScreenOrientation;
            if (i != 0) {
                if (i != 90) {
                    if (i != 180) {
                        if (i != 270) {
                        }
                    }
                }
                this.mRotateDegree = (360 - ((this.mCameraSensorOrientation + i) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL)) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
            }
            this.mRotateDegree = ((this.mCameraSensorOrientation - i) + MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL) % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        }
    }

    public synchronized int getRotateDegree() {
        return this.mRotateDegree;
    }
}
