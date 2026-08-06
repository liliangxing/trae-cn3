package com.bytedance.realx.video;

import com.bytedance.vcloud.strategy.StrategyCenter;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: classes4.dex */
public enum VideoCodecStatus {
    OK(0),
    ERR_PARAMETER(3001),
    ERR_SIZE(3001),
    LEVEL_EXCEEDED(3001),
    UNINITIALIZED(4002),
    MEMORY(4003),
    ERROR(4003),
    TIMEOUT(MediaPlayer.MEDIA_PLAYER_OPTION_DECODERRENDER_VC2PRE_CREATE_RENDER),
    NO_OUTPUT(2002),
    FALLBACK_SOFTWARE(MediaPlayer.MEDIA_PLAYER_OPTION_LOWER_AUDIOMEM_CAPACITY),
    MEDIACODEC_EXCEPTION(2006),
    USING_INTERNAL_SURFACE(2007),
    OVERLOAD(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODERRENDER_VC2RENDER_LATENCY),
    MEDIACODEC_OUT_OF_RESOLUTION(StrategyCenter.EVENT_ADAPTIVE_RANGE_ENABLED),
    DROP_DECODED_FRAME(2002);

    private final int number;

    VideoCodecStatus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
