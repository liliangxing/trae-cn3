package com.ss.ttm.player;

/* loaded from: classes7.dex */
public interface IPlayerNotifyer {
    void handleErrorNotify(long id, int type, int errorCode, String logInfo);

    void handlePlayerNotify(long id, int lifeId, int what, int parameter, String info);
}
