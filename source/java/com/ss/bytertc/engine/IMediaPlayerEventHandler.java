package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerEvent;
import com.ss.bytertc.engine.data.PlayerState;

/* loaded from: classes7.dex */
public interface IMediaPlayerEventHandler {
    void onMediaPlayerEvent(int playerId, PlayerEvent event, String message);

    void onMediaPlayerPlayingProgress(int playerId, long progress);

    void onMediaPlayerStateChanged(int playerId, PlayerState state, PlayerError error);
}
