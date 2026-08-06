package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class PushSingleStreamParam {
    public boolean isScreen;
    public String roomId;
    public String url;
    public String userId;

    public PushSingleStreamParam() {
        this.isScreen = false;
    }

    public PushSingleStreamParam(String rid, String uid, String url, boolean isScreen) {
        this.roomId = rid;
        this.userId = uid;
        this.url = url;
        this.isScreen = isScreen;
    }
}
