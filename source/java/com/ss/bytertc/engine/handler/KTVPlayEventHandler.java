package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.IKTVPlayerEventHandler;
import com.ss.bytertc.ktv.data.KTVPlayerErrorCode;
import com.ss.bytertc.ktv.data.PlayState;

/* loaded from: classes7.dex */
public class KTVPlayEventHandler extends IKTVPlayerEventHandler {
    private static final String TAG = "KTVPlayEventHandler";
    private final IKTVPlayerEventHandler mHandler;

    public KTVPlayEventHandler(IKTVPlayerEventHandler handler) {
        this.mHandler = handler;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayerEventHandler
    public void onPlayProgress(String musicId, long progress) {
        LogUtil.d(TAG, "onPlayProgress...musicId: " + musicId + ",progress:" + progress);
        try {
            IKTVPlayerEventHandler iKTVPlayerEventHandler = this.mHandler;
            if (iKTVPlayerEventHandler != null) {
                iKTVPlayerEventHandler.onPlayProgress(musicId, progress);
            }
        } catch (Exception e) {
            LogUtil.e(TAG, "onPlayProgress callback catch exception.\n" + e.getMessage());
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayerEventHandler
    public void onPlayStateChanged(String musicId, PlayState playState, KTVPlayerErrorCode errorCode) {
        LogUtil.d(TAG, "onPlayStateChanged...musicId: " + musicId + ",playState:" + playState.toString());
        try {
            IKTVPlayerEventHandler iKTVPlayerEventHandler = this.mHandler;
            if (iKTVPlayerEventHandler != null) {
                iKTVPlayerEventHandler.onPlayStateChanged(musicId, playState, errorCode);
            }
        } catch (Exception e) {
            LogUtil.e(TAG, "onPlayStateChanged callback catch exception.\n" + e.getMessage());
        }
    }
}
