package com.ss.bytertc.engine;

import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IWTNStream {
    void enableWTNRemoteAudioFrameCallback(boolean enable);

    int registerWTNAudioFrameObserver(IWTNAudioFrameObserver observer);

    int setWTNRemoteAudioPlaybackVolume(String streamId, int volume);

    int setWTNRemoteVideoCanvas(String streamId, VideoCanvas canvas);

    int setWTNRemoteVideoSink(String streamId, IVideoSink videoSink, RemoteVideoSinkConfig config);

    int setWTNStreamEventHandler(IWTNStreamEventHandler handler);

    int subscribeWTNAudioStream(String streamId, boolean subscribe);

    int subscribeWTNVideoStream(String streamId, boolean subscribe);
}
