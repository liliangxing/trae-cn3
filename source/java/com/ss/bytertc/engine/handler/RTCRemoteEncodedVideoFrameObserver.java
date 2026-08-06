package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.VideoCodecType;
import com.ss.bytertc.engine.data.VideoPictureType;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import com.ss.bytertc.engine.mediaio.IRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.video.VideoStream;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCRemoteEncodedVideoFrameObserver {
    private static final String TAG = "RTCRemoteEncodedVideoFrameObserver";
    private WeakReference<RTCEngineImpl> mRtcVideoImpl;

    public RTCRemoteEncodedVideoFrameObserver(RTCEngineImpl rtcVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rtcVideoImpl);
    }

    void onRemoteEncodedVideoFrame(String roomId, String userId, int streamIndex, VideoStream videoStream, long timestampUs, long timestampDtsUs, int videoCodecType, int videoPictureType, int videoRotation) {
        RTCEngineImpl rTCEngineImpl;
        IRemoteEncodedVideoFrameObserver remoteEncodedVideoFrameObserver;
        if (videoStream == null) {
            return;
        }
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference != null && (rTCEngineImpl = weakReference.get()) != null && (remoteEncodedVideoFrameObserver = rTCEngineImpl.getRemoteEncodedVideoFrameObserver()) != null) {
            remoteEncodedVideoFrameObserver.onRemoteEncodedVideoFrame(new RemoteStreamKey(roomId, userId, StreamIndex.fromId(streamIndex)), new RTCEncodedVideoFrame(videoStream.getBuffer().getData(), timestampUs, timestampDtsUs, videoStream.getWidth(), videoStream.getHeight(), VideoCodecType.fromId(videoCodecType), VideoPictureType.fromId(videoPictureType), VideoRotation.fromId(videoRotation)));
        }
        videoStream.release();
    }
}
