package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoCodecType;
import com.ss.bytertc.engine.data.VideoPictureType;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import com.ss.bytertc.engine.mediaio.ILocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.video.VideoStream;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCLocalEncodedVideoFrameObserver {
    private static final String TAG = "RTCLocalEncodedVideoFrameObserver";
    private WeakReference<RTCEngineImpl> mRtcVideoImpl;

    public RTCLocalEncodedVideoFrameObserver(RTCEngineImpl rtcVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rtcVideoImpl);
    }

    void onLocalEncodedVideoFrame(int streamIndex, VideoStream videoStream, long timestampUs, long timestampDtsUs, int videoCodecType, int videoPictureType, int videoRotation) {
        RTCEngineImpl rTCEngineImpl;
        ILocalEncodedVideoFrameObserver encodedVideoFrameObserver;
        if (videoStream == null) {
            return;
        }
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference != null && (rTCEngineImpl = weakReference.get()) != null && (encodedVideoFrameObserver = rTCEngineImpl.getEncodedVideoFrameObserver()) != null) {
            encodedVideoFrameObserver.onLocalEncodedVideoFrame(StreamIndex.fromId(streamIndex), new RTCEncodedVideoFrame(videoStream.getBuffer().getData(), timestampUs, timestampDtsUs, videoStream.getWidth(), videoStream.getHeight(), VideoCodecType.fromId(videoCodecType), VideoPictureType.fromId(videoPictureType), VideoRotation.fromId(videoRotation)));
        }
        videoStream.release();
    }
}
