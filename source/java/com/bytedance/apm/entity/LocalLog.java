package com.bytedance.apm.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LocalLog {
    public long createTime;
    public JSONObject data;
    public long id;
    public boolean isSampled;
    public String type;
    public String type2;
    public long versionId;

    public LocalLog() {
    }

    public LocalLog(long j, String str, long j2, JSONObject jSONObject) {
        this.id = j;
        this.type = str;
        this.data = jSONObject;
        this.versionId = j2;
    }

    public LocalLog(long j, String str, long j2, String str2) {
        this.id = j;
        this.type = str;
        try {
            this.data = new JSONObject(str2);
        } catch (Exception unused) {
        }
        this.versionId = j2;
    }

    public LocalLog setId(long j) {
        this.id = j;
        return this;
    }

    public LocalLog setType(String str) {
        this.type = str;
        return this;
    }

    public LocalLog setType2(String str) {
        this.type2 = str;
        return this;
    }

    public LocalLog setData(JSONObject jSONObject) {
        this.data = jSONObject;
        return this;
    }

    public LocalLog setIsSampled(boolean z) {
        this.isSampled = z;
        return this;
    }

    public LocalLog setVersionId(long j) {
        this.versionId = j;
        return this;
    }

    public LocalLog setTimestamp(long j) {
        this.createTime = j;
        return this;
    }

    public static LocalLog newLocalLog(String str) {
        str.hashCode();
        if (str.equals("api_all")) {
            return new ApiAllLocalLog().setType(str);
        }
        return new LocalLog().setType(str);
    }

    public String toString() {
        return "LocalLog{id=" + this.id + ", type='" + this.type + "', type2='" + this.type2 + "', data='" + this.data + "', versionId=" + this.versionId + ", createTime=" + this.createTime + ", isSampled=" + this.isSampled + AbstractJsonLexerKt.END_OBJ;
    }
}
