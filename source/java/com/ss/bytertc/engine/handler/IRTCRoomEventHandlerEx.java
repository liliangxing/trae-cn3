package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.SubscribeConfig;
import com.ss.bytertc.engine.data.AVSyncEvent;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.MediaStreamType;
import com.ss.bytertc.engine.type.StreamRemoveReason;

/* loaded from: classes7.dex */
public abstract class IRTCRoomEventHandlerEx {
    public void onAVSyncEvent(StreamKey key, AVSyncEvent eventCode) {
    }

    public void onStreamPublishSuccess(String uid, StreamIndex streamIndex, boolean isScreen) {
    }

    public void onStreamStateChanged(StreamKey streamKey, int state, String extraInfo) {
    }

    public void onStreamSubscribed(int stateCode, String userId, StreamIndex streamIndex, SubscribeConfig info) {
    }

    public void onUserPublishStream(RemoteStreamKey streamKey, boolean isScreen, MediaStreamType type) {
    }

    public void onUserUnpublishStream(RemoteStreamKey streamKey, MediaStreamType type, StreamRemoveReason reason) {
    }
}
