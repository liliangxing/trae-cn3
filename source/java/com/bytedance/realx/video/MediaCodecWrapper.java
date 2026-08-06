package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public interface MediaCodecWrapper {
    void configure(MediaFormat format, Surface surface, MediaCrypto crypto, int flags);

    Surface createInputSurface();

    int dequeueInputBuffer(long timeoutUs);

    int dequeueOutputBuffer(MediaCodec.BufferInfo info, long timeoutUs);

    void flush();

    MediaCodecInfo getCodecInfo();

    ByteBuffer getInputBuffer(int index);

    ByteBuffer[] getInputBuffers();

    ByteBuffer getOutputBuffer(int index);

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    MediaFormat getOutputFormat(int index);

    MediaCodec getRealCodec();

    void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags);

    void release();

    void releaseOutputBuffer(int index, long renderTimestampNs);

    void releaseOutputBuffer(int index, boolean render);

    void setCallback(MediaCodec.Callback cb, Handler handler);

    void setOutputSurface(Surface surface);

    void setParameters(Bundle params);

    void start();

    void stop();
}
