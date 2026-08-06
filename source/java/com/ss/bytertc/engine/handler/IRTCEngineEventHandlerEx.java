package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamKey;
import com.ss.bytertc.engine.type.FirstFramePlayState;
import com.ss.bytertc.engine.type.FirstFrameSendState;
import com.ss.bytertc.engine.type.LocalStreamStats;
import com.ss.bytertc.engine.type.PerformanceAlarmMode;
import com.ss.bytertc.engine.type.PerformanceAlarmReason;
import com.ss.bytertc.engine.type.RemoteStreamStats;
import com.ss.bytertc.engine.type.RemoteStreamSwitch;
import com.ss.bytertc.engine.type.SourceWantedData;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class IRTCEngineEventHandlerEx {
    public void onAudioFramePlayStateChanged(StreamKey streamKey, String metaData, FirstFramePlayState state) {
    }

    public void onAudioFrameSendStateChanged(StreamKey streamKey, String metaData, FirstFrameSendState state) {
    }

    public void onLocalStreamStats(StreamIndex index, LocalStreamStats stats) {
    }

    public void onPerformanceAlarms(StreamIndex streamIndex, PerformanceAlarmMode mode, PerformanceAlarmReason reason, SourceWantedData data) {
    }

    public void onRemoteStreamStats(StreamKey streamKey, RemoteStreamStats stats) {
    }

    public void onSimulcastSubscribeFallback(StreamKey streamKey, RemoteStreamSwitch event) {
    }

    public void onVideoFramePlayStateChanged(StreamKey streamKey, String metaData, FirstFramePlayState state) {
    }

    public void onVideoFrameSendStateChanged(StreamKey streamKey, String metaData, FirstFrameSendState state) {
    }
}
