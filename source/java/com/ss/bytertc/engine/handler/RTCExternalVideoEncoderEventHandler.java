package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCExternalVideoEncoderEventHandler {
    private static final String TAG = "RTCExternalVideoEncoderEventHandler";
    private WeakReference<RTCEngineImpl> mRtcVideoImpl;

    public RTCExternalVideoEncoderEventHandler(RTCEngineImpl rtcVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rtcVideoImpl);
    }

    void OnStart(int index) {
        RTCEngineImpl rTCEngineImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCEngineImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCEngineImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onStart(StreamIndex.fromId(index));
    }

    void OnStop(int index) {
        RTCEngineImpl rTCEngineImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCEngineImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCEngineImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onStop(StreamIndex.fromId(index));
    }

    void OnRateUpdate(int stream_index, int video_index, int fps, int bitrateKbps) {
        RTCEngineImpl rTCEngineImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCEngineImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCEngineImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onRateUpdate(StreamIndex.fromId(stream_index), video_index, fps, bitrateKbps);
    }

    void OnRequestKeyFrame(int stream_index, int video_index) {
        RTCEngineImpl rTCEngineImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCEngineImpl = weakReference.get()) == null || (externalVideoEncoderEventHandler = rTCEngineImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onRequestKeyFrame(StreamIndex.fromId(stream_index), video_index);
    }

    void OnActiveVideoLayer(int stream_index, int video_index, boolean active) {
        RTCEngineImpl rTCEngineImpl;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler;
        RTCEngineImpl rTCEngineImpl2;
        IExternalVideoEncoderEventHandler externalVideoEncoderEventHandler2;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference != null && (rTCEngineImpl2 = weakReference.get()) != null && (externalVideoEncoderEventHandler2 = rTCEngineImpl2.getExternalVideoEncoderEventHandler()) != null) {
            externalVideoEncoderEventHandler2.onActiveVideoLayer(StreamIndex.fromId(stream_index), video_index, active);
        }
        WeakReference<RTCEngineImpl> weakReference2 = this.mRtcVideoImpl;
        if (weakReference2 == null || (rTCEngineImpl = weakReference2.get()) == null || (externalVideoEncoderEventHandler = rTCEngineImpl.getExternalVideoEncoderEventHandler()) == null) {
            return;
        }
        externalVideoEncoderEventHandler.onActiveVideoLayer(StreamIndex.fromId(stream_index), video_index, active);
    }
}
