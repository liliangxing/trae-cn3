package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "", "id", "", "name", "params", "Lcom/google/gson/JsonObject;", "result", "Lcom/bytedance/trae/im/model/ParsedToolCallResult;", IPiaCacheProvider.CacheConfig.FIELD_META, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;Lcom/bytedance/trae/im/model/ParsedToolCallResult;Lcom/google/gson/JsonObject;)V", "getId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getParams", "()Lcom/google/gson/JsonObject;", "setParams", "(Lcom/google/gson/JsonObject;)V", "getResult", "()Lcom/bytedance/trae/im/model/ParsedToolCallResult;", "setResult", "(Lcom/bytedance/trae/im/model/ParsedToolCallResult;)V", "getMeta", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParsedToolCallInfo {

    @SerializedName("id")
    private final String id;

    @SerializedName(IPiaCacheProvider.CacheConfig.FIELD_META)
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject meta;

    @SerializedName("name")
    private String name;

    @SerializedName("params")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private JsonObject params;

    @SerializedName("result")
    private ParsedToolCallResult result;

    public ParsedToolCallInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ParsedToolCallInfo copy$default(ParsedToolCallInfo parsedToolCallInfo, String str, String str2, JsonObject jsonObject, ParsedToolCallResult parsedToolCallResult, JsonObject jsonObject2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parsedToolCallInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = parsedToolCallInfo.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            jsonObject = parsedToolCallInfo.params;
        }
        JsonObject jsonObject3 = jsonObject;
        if ((i & 8) != 0) {
            parsedToolCallResult = parsedToolCallInfo.result;
        }
        ParsedToolCallResult parsedToolCallResult2 = parsedToolCallResult;
        if ((i & 16) != 0) {
            jsonObject2 = parsedToolCallInfo.meta;
        }
        return parsedToolCallInfo.copy(str, str3, jsonObject3, parsedToolCallResult2, jsonObject2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final JsonObject getParams() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final ParsedToolCallResult getResult() {
        return this.result;
    }

    /* renamed from: component5, reason: from getter */
    public final JsonObject getMeta() {
        return this.meta;
    }

    public final ParsedToolCallInfo copy(String id, String name, JsonObject params, ParsedToolCallResult result, JsonObject meta) {
        return new ParsedToolCallInfo(id, name, params, result, meta);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParsedToolCallInfo)) {
            return false;
        }
        ParsedToolCallInfo parsedToolCallInfo = (ParsedToolCallInfo) other;
        return Intrinsics.areEqual(this.id, parsedToolCallInfo.id) && Intrinsics.areEqual(this.name, parsedToolCallInfo.name) && Intrinsics.areEqual(this.params, parsedToolCallInfo.params) && Intrinsics.areEqual(this.result, parsedToolCallInfo.result) && Intrinsics.areEqual(this.meta, parsedToolCallInfo.meta);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonObject jsonObject = this.params;
        int hashCode3 = (hashCode2 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        ParsedToolCallResult parsedToolCallResult = this.result;
        int hashCode4 = (hashCode3 + (parsedToolCallResult == null ? 0 : parsedToolCallResult.hashCode())) * 31;
        JsonObject jsonObject2 = this.meta;
        return hashCode4 + (jsonObject2 != null ? jsonObject2.hashCode() : 0);
    }

    public String toString() {
        return "ParsedToolCallInfo(id=" + this.id + ", name=" + this.name + ", params=" + this.params + ", result=" + this.result + ", meta=" + this.meta + ')';
    }

    public ParsedToolCallInfo(String str, String str2, JsonObject jsonObject, ParsedToolCallResult parsedToolCallResult, JsonObject jsonObject2) {
        this.id = str;
        this.name = str2;
        this.params = jsonObject;
        this.result = parsedToolCallResult;
        this.meta = jsonObject2;
    }

    public /* synthetic */ ParsedToolCallInfo(String str, String str2, JsonObject jsonObject, ParsedToolCallResult parsedToolCallResult, JsonObject jsonObject2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonObject, (i & 8) != 0 ? null : parsedToolCallResult, (i & 16) != 0 ? null : jsonObject2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final JsonObject getParams() {
        return this.params;
    }

    public final void setParams(JsonObject jsonObject) {
        this.params = jsonObject;
    }

    public final ParsedToolCallResult getResult() {
        return this.result;
    }

    public final void setResult(ParsedToolCallResult parsedToolCallResult) {
        this.result = parsedToolCallResult;
    }

    public final JsonObject getMeta() {
        return this.meta;
    }
}
