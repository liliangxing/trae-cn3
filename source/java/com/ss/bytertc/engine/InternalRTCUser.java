package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRTCUser {
    public String metaData;
    public String userId;

    public InternalRTCUser(String userId, String metaData) {
        this.userId = userId;
        this.metaData = metaData;
    }

    private static InternalRTCUser create(String userId, String metaData) {
        return new InternalRTCUser(userId, metaData);
    }

    public String toString() {
        return "InternalRtcUser{userId='" + this.userId + "', metaData='" + this.metaData + "'}";
    }
}
