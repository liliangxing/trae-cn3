package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedToolCallResult;", "", "status", "", "errorMessage", "data", "Lcom/google/gson/JsonObject;", "isTruncated", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Boolean;)V", "getStatus", "()Ljava/lang/String;", "getErrorMessage", "getData", "()Lcom/google/gson/JsonObject;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/model/ParsedToolCallResult;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedToolCallResult {

    @SerializedName("data")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject data;

    @SerializedName("error_message")
    private final String errorMessage;

    @SerializedName("is_truncated")
    private final Boolean isTruncated;

    @SerializedName("status")
    private final String status;

    public ParsedToolCallResult() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ParsedToolCallResult copy$default(ParsedToolCallResult parsedToolCallResult, String str, String str2, JsonObject jsonObject, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedToolCallResult.status;
        }
        if ((i & 2) != 0) {
            str2 = parsedToolCallResult.errorMessage;
        }
        if ((i & 4) != 0) {
            jsonObject = parsedToolCallResult.data;
        }
        if ((i & 8) != 0) {
            bool = parsedToolCallResult.isTruncated;
        }
        return parsedToolCallResult.copy(str, str2, jsonObject, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getData() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIsTruncated() {
        return this.isTruncated;
    }

    public final ParsedToolCallResult copy(String status, String errorMessage, JsonObject data, Boolean isTruncated) {
        return new ParsedToolCallResult(status, errorMessage, data, isTruncated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedToolCallResult)) {
            return false;
        }
        ParsedToolCallResult parsedToolCallResult = (ParsedToolCallResult) other;
        return Intrinsics.areEqual(this.status, parsedToolCallResult.status) && Intrinsics.areEqual(this.errorMessage, parsedToolCallResult.errorMessage) && Intrinsics.areEqual(this.data, parsedToolCallResult.data) && Intrinsics.areEqual(this.isTruncated, parsedToolCallResult.isTruncated);
    }

    public int hashCode() {
        String str = this.status;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonObject jsonObject = this.data;
        int hashCode3 = (hashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        Boolean bool = this.isTruncated;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ParsedToolCallResult(status=" + this.status + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ", isTruncated=" + this.isTruncated + ')';
    }

    public ParsedToolCallResult(String str, String str2, JsonObject jsonObject, Boolean bool) {
        this.status = str;
        this.errorMessage = str2;
        this.data = jsonObject;
        this.isTruncated = bool;
    }

    public /* synthetic */ ParsedToolCallResult(String str, String str2, JsonObject jsonObject, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonObject, (i & 8) != 0 ? null : bool);
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final JsonObject getData() {
        return this.data;
    }

    public final Boolean isTruncated() {
        return this.isTruncated;
    }
}
