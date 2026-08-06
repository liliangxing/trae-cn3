package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.KTVPlayerErrorCode;
import com.ss.bytertc.ktv.data.PlayState;

/* loaded from: classes7.dex */
public abstract class IKTVPlayerEventHandler {
    public abstract void onPlayProgress(String musicId, long progress);

    public abstract void onPlayStateChanged(String musicId, PlayState playState, KTVPlayerErrorCode errorCode);
}
