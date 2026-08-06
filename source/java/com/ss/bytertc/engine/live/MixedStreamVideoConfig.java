package com.ss.bytertc.engine.live;

import com.ss.ttm.player.MediaPlayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class MixedStreamVideoConfig {
    public MixedStreamVideoCodecType videoCodec = MixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
    public int fps = 15;
    public int gop = 2;
    public int bitrate = 500;
    public int width = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
    public int height = 640;
    public boolean enableBframe = false;

    public String toString() {
        return "MixedStreamVideoConfig{videoCodec='" + this.videoCodec + "', fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", width=" + this.width + ", height=" + this.height + ", enableBframe=" + this.enableBframe + AbstractJsonLexerKt.END_OBJ;
    }
}
