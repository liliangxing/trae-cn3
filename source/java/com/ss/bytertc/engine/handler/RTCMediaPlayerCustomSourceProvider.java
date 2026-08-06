package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.data.MediaPlayerCustomSourceSeekWhence;
import com.ss.bytertc.engine.data.ReturnStatus;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class RTCMediaPlayerCustomSourceProvider {
    private IMediaPlayerCustomSourceProvider mCustomSourceProvider;

    public void setCustomSourceProvider(IMediaPlayerCustomSourceProvider provider) {
        this.mCustomSourceProvider = provider;
    }

    int onReadData(ByteBuffer buffer, int bufferSize) {
        IMediaPlayerCustomSourceProvider iMediaPlayerCustomSourceProvider = this.mCustomSourceProvider;
        if (iMediaPlayerCustomSourceProvider != null) {
            return iMediaPlayerCustomSourceProvider.onReadData(buffer, bufferSize);
        }
        return ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
    }

    long onSeek(long offset, int whence) {
        IMediaPlayerCustomSourceProvider iMediaPlayerCustomSourceProvider = this.mCustomSourceProvider;
        if (iMediaPlayerCustomSourceProvider != null) {
            return iMediaPlayerCustomSourceProvider.onSeek(offset, MediaPlayerCustomSourceSeekWhence.fromId(whence));
        }
        return ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
    }
}
