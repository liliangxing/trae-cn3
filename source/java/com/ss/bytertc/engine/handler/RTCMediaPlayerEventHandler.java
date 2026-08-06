package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IMediaPlayerEventHandler;
import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerEvent;
import com.ss.bytertc.engine.data.PlayerState;

/* loaded from: classes7.dex */
public class RTCMediaPlayerEventHandler {
    private IMediaPlayerEventHandler mMediaPlayerHandler;

    public synchronized void setMediaPlayerEventHandler(IMediaPlayerEventHandler handler) {
        this.mMediaPlayerHandler = handler;
    }

    synchronized void onMediaPlayerStateChanged(int playerId, PlayerState state, PlayerError error) {
        IMediaPlayerEventHandler iMediaPlayerEventHandler = this.mMediaPlayerHandler;
        if (iMediaPlayerEventHandler != null) {
            iMediaPlayerEventHandler.onMediaPlayerStateChanged(playerId, state, error);
        }
    }

    synchronized void onMediaPlayerPlayingProgress(int playerId, long progress) {
        IMediaPlayerEventHandler iMediaPlayerEventHandler = this.mMediaPlayerHandler;
        if (iMediaPlayerEventHandler != null) {
            iMediaPlayerEventHandler.onMediaPlayerPlayingProgress(playerId, progress);
        }
    }

    synchronized void onMediaPlayerEvent(int playerId, PlayerEvent event, String message) {
        IMediaPlayerEventHandler iMediaPlayerEventHandler = this.mMediaPlayerHandler;
        if (iMediaPlayerEventHandler != null) {
            iMediaPlayerEventHandler.onMediaPlayerEvent(playerId, event, message);
        }
    }
}
