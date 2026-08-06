package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMetadataObserver;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCMetadataObserver {
    private static final String TAG = "RtcMetadataObserver";
    private WeakReference<RTCEngineImpl> mRtcVideoImpl;

    public RTCMetadataObserver(RTCEngineImpl rtcVideoImpl) {
        this.mRtcVideoImpl = new WeakReference<>(rtcVideoImpl);
    }

    void onMetadataReceived(byte[] metadata, String uid, long timestampMs) {
        RTCEngineImpl rTCEngineImpl;
        IMetadataObserver metadataObserver;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        if (weakReference == null || (rTCEngineImpl = weakReference.get()) == null || (metadataObserver = rTCEngineImpl.getMetadataObserver()) == null) {
            return;
        }
        metadataObserver.onMetadataReceived(metadata, uid, timestampMs);
    }

    byte[] onReadyToSendMetadata(long timestampMs) {
        RTCEngineImpl rTCEngineImpl;
        WeakReference<RTCEngineImpl> weakReference = this.mRtcVideoImpl;
        IMetadataObserver metadataObserver = (weakReference == null || (rTCEngineImpl = weakReference.get()) == null) ? null : rTCEngineImpl.getMetadataObserver();
        if (metadataObserver != null) {
            return metadataObserver.onReadyToSendMetadata(timestampMs);
        }
        return null;
    }
}
