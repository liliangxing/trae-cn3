package com.lynx.animax.player;

import android.media.MediaFormat;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes6.dex */
public class VideoAsset {
    private static final String TAG = "VideoAsset";
    private String mFileUrl;
    private boolean mIsValid;
    private VideoRawData mRawData;
    private VideoInfo mVideoInfo;

    private VideoAsset() {
    }

    public static VideoAsset create() {
        return new VideoAsset();
    }

    public String getFileUrl() {
        return this.mFileUrl;
    }

    public MediaFormat getFormat() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return null;
        }
        return videoInfo.getFormat();
    }

    public int getWidth() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return 0;
        }
        return videoInfo.getWidth();
    }

    public int getHeight() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return 0;
        }
        return videoInfo.getHeight();
    }

    public int getFrameCount() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return 0;
        }
        return videoInfo.getFrameCount();
    }

    public float getFrameRate() {
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return 0.0f;
        }
        return videoInfo.getFrameRate();
    }

    public boolean isValid() {
        return this.mIsValid;
    }

    public boolean loadLocal(String str) {
        boolean z = false;
        if (str == null || str.isEmpty()) {
            AnimaXLog.e(TAG, "video file path is empty");
            this.mIsValid = false;
            return false;
        }
        VideoInfo extractVideoInfo = VideoAssetExtractor.extractVideoInfo(str);
        this.mVideoInfo = extractVideoInfo;
        if (extractVideoInfo != null && extractVideoInfo.getWidth() > 0 && this.mVideoInfo.getHeight() > 0 && this.mVideoInfo.getFrameCount() > 0 && this.mVideoInfo.getFrameRate() > 0.0f) {
            z = true;
        }
        this.mIsValid = z;
        if (z) {
            this.mFileUrl = str;
            prepareFrameBufferIfNecessary();
        } else {
            this.mVideoInfo = null;
        }
        return this.mIsValid;
    }

    public boolean prepareFrameBufferIfNecessary() {
        if (this.mRawData == null) {
            prepareFrameBuffer();
        }
        return IsKeyFramesValid();
    }

    private void prepareFrameBuffer() {
        AnimaXLog.i(TAG, "prepareFrameBuffer");
        VideoInfo videoInfo = this.mVideoInfo;
        if (videoInfo == null) {
            return;
        }
        VideoRawData extractVideoRawData = VideoAssetExtractor.extractVideoRawData(this.mFileUrl, videoInfo.getVideoTrackIndex());
        this.mRawData = extractVideoRawData;
        if (extractVideoRawData == null || !IsKeyFramesValid()) {
            return;
        }
        ArrayList<FrameInfo> frameInfos = this.mRawData.getFrameInfos();
        if (this.mVideoInfo.getFrameCount() != frameInfos.size()) {
            AnimaXLog.e(TAG, "prepareFrameBuffer: frameCount change from " + this.mVideoInfo.getFrameCount() + " to " + frameInfos.size());
            this.mVideoInfo.setFrameCount(frameInfos.size());
        }
    }

    private boolean IsKeyFramesValid() {
        VideoRawData videoRawData = this.mRawData;
        if (videoRawData == null) {
            return false;
        }
        ArrayList<Integer> keyFrames = videoRawData.getKeyFrames();
        return !keyFrames.isEmpty() && keyFrames.get(0).intValue() == 0;
    }

    public int getPrevKeyFrame(int i) {
        ArrayList<Integer> keyFrames = this.mRawData.getKeyFrames();
        int binarySearch = Collections.binarySearch(keyFrames, Integer.valueOf(i));
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return keyFrames.get(binarySearch).intValue();
    }

    public FrameInfo getFrameInfo(int i) {
        VideoRawData videoRawData = this.mRawData;
        if (videoRawData == null) {
            return null;
        }
        ArrayList<FrameInfo> frameInfos = videoRawData.getFrameInfos();
        if (i < 0 || i >= frameInfos.size()) {
            return null;
        }
        return frameInfos.get(i);
    }

    public ByteBuffer getFrameData(int i) {
        return getFrameData(getFrameInfo(i));
    }

    public ByteBuffer getFrameData(FrameInfo frameInfo) {
        VideoRawData videoRawData;
        ByteBuffer frameBuffer;
        if (frameInfo == null || (videoRawData = this.mRawData) == null || (frameBuffer = videoRawData.getFrameBuffer()) == null) {
            return null;
        }
        frameBuffer.position(0);
        frameBuffer.limit(frameInfo.end());
        frameBuffer.position(frameInfo.begin());
        return frameBuffer;
    }
}
