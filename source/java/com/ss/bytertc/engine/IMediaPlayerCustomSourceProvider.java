package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public interface IMediaPlayerCustomSourceProvider {
    int onReadData(ByteBuffer buffer, int bufferSize);

    long onSeek(long offset, MediaPlayerCustomSourceSeekWhence whence);
}
