package com.ss.bytertc.engine.data;

import android.view.View;

/* loaded from: classes7.dex */
public class EchoTestConfig {
    public int audioReportInterval;
    public boolean enableAudio;
    public boolean enableVideo;
    public String roomId;
    public String token;
    public String uid;
    public View view;

    public EchoTestConfig(View view, String uid, String roomid, String token, boolean enableAudio, boolean enableVideo, int interval) {
        this.view = view;
        this.uid = uid;
        this.roomId = roomid;
        this.token = token;
        this.enableAudio = enableAudio;
        this.enableVideo = enableVideo;
        this.audioReportInterval = interval;
    }

    public String toString() {
        return "EchoTestConfig{view='" + this.view + "'uid='" + this.uid + "', roomId='" + this.roomId + "', token='" + this.token + "', enableAudio='" + this.enableAudio + "', enableVideo='" + this.enableVideo + "', audioReportInterval='" + this.audioReportInterval + "'}";
    }

    public View getEchoRenderView() {
        return this.view;
    }

    public String getEchoUid() {
        return this.uid;
    }

    public String getEchoRoomId() {
        return this.roomId;
    }

    public String getEchoToken() {
        return this.token;
    }

    public boolean getEchoEnabledAudio() {
        return this.enableAudio;
    }

    public boolean getEchoEnabledVideo() {
        return this.enableVideo;
    }

    public int getAudioReportInterval() {
        return this.audioReportInterval;
    }
}
