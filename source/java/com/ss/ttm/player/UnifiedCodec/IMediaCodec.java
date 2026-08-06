package com.ss.ttm.player.UnifiedCodec;

import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.io.IOException;

/* loaded from: classes7.dex */
public interface IMediaCodec {
    void configure(MediaFormat mediaFormat, Surface surface, int flags, MediaDescrambler mediaDescrambler) throws IOException;

    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int flags) throws IOException;

    void release();

    void releaseOutputBuffer(int index, long releaseNanoTime);

    void releaseOutputBuffer(int index, boolean render);

    void reset();

    void setParameters(Bundle bundle);

    void start();

    void stop();
}
