package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRTCUser;

/* loaded from: classes7.dex */
public class RtcUser {
    public String metaData;
    public String userId;

    public RtcUser() {
    }

    public RtcUser(InternalRTCUser user) {
        this.userId = user.userId;
        this.metaData = user.metaData;
    }

    public String toString() {
        return "RtcUser{uid='" + this.userId + "', metaData='" + this.metaData + "'}";
    }
}
