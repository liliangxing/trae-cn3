package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedError;", "", "code", "", "message", "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/im/model/ParsedError;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedError {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject data;

    @SerializedName("message")
    private final String message;

    public ParsedError() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ParsedError copy$default(ParsedError parsedError, Integer num, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            num = parsedError.code;
        }
        if ((i & 2) != 0) {
            str = parsedError.message;
        }
        if ((i & 4) != 0) {
            jsonObject = parsedError.data;
        }
        return parsedError.copy(num, str, jsonObject);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getData() {
        return this.data;
    }

    public final ParsedError copy(Integer code, String message, JsonObject data) {
        return new ParsedError(code, message, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedError)) {
            return false;
        }
        ParsedError parsedError = (ParsedError) other;
        return Intrinsics.areEqual(this.code, parsedError.code) && Intrinsics.areEqual(this.message, parsedError.message) && Intrinsics.areEqual(this.data, parsedError.data);
    }

    public int hashCode() {
        Integer num = this.code;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.message;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonObject jsonObject = this.data;
        return hashCode2 + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "ParsedError(code=" + this.code + ", message=" + this.message + ", data=" + this.data + ')';
    }

    public ParsedError(Integer num, String str, JsonObject jsonObject) {
        this.code = num;
        this.message = str;
        this.data = jsonObject;
    }

    public /* synthetic */ ParsedError(Integer num, String str, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : jsonObject);
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final JsonObject getData() {
        return this.data;
    }
}
