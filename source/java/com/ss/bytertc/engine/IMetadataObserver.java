package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public interface IMetadataObserver {
    void onMetadataReceived(byte[] buffer, String uid, long timeStampMs);

    byte[] onReadyToSendMetadata(long timeStampMs);
}
