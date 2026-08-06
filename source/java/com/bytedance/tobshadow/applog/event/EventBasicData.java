package com.bytedance.tobshadow.applog.event;

import com.bytedance.tobshadow.bdtracker.a;
import com.bytedance.tobshadow.bdtracker.n4;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class EventBasicData {
    public final String abSdkVersion;
    public final long eventCreateTime;
    public final long eventIndex;
    public final String sessionId;
    public final String ssid;
    public final String uuid;
    public final String uuidType;

    public EventBasicData(n4 n4Var) {
        this.eventIndex = n4Var.d;
        this.eventCreateTime = n4Var.c;
        this.sessionId = n4Var.e;
        this.uuid = n4Var.g;
        this.uuidType = n4Var.h;
        this.ssid = n4Var.i;
        this.abSdkVersion = n4Var.j;
    }

    public String getAbSdkVersion() {
        return this.abSdkVersion;
    }

    public long getEventCreateTime() {
        return this.eventCreateTime;
    }

    public long getEventIndex() {
        return this.eventIndex;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getUuidType() {
        return this.uuidType;
    }

    public String toString() {
        return a.a("EventBasisData{eventIndex=").append(this.eventIndex).append(", eventCreateTime=").append(this.eventCreateTime).append(", sessionId='").append(this.sessionId).append('\'').append(", uuid='").append(this.uuid).append('\'').append(", uuidType='").append(this.uuidType).append('\'').append(", ssid='").append(this.ssid).append('\'').append(", abSdkVersion='").append(this.abSdkVersion).append('\'').append(AbstractJsonLexerKt.END_OBJ).toString();
    }
}
