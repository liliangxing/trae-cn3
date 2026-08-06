package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public abstract class AudioProcessor extends NativeObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int RELEASE_REASEON_OSPLAYER_CREATED = 1;
    public static final int RELEASE_REASEON_TTPLAYER_NORMAL_CALL = 2;

    public abstract void audioClose();

    public abstract void audioOpen(int samplerate, int channels, int duration, int format);

    public abstract void audioProcess(ByteBuffer[] inout, int samples, long timestamp);

    public abstract void audioRelease(int reason);
}
