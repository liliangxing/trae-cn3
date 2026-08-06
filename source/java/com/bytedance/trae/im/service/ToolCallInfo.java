package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0016Jb\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/trae/im/service/ToolCallInfo;", "", "id", "", "name", "params", "Lcom/google/gson/JsonElement;", "result", IPiaCacheProvider.CacheConfig.FIELD_META, "alreadyEmittedGeneratingEvent", "", "alreadyEmittedRunEvent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/String;", "getName", "getParams", "()Lcom/google/gson/JsonElement;", "getResult", "getMeta", "getAlreadyEmittedGeneratingEvent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getAlreadyEmittedRunEvent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/ToolCallInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ToolCallInfo {

    @SerializedName("already_emitted_generating_event")
    private final Boolean alreadyEmittedGeneratingEvent;

    @SerializedName("already_emitted_run_event")
    private final Boolean alreadyEmittedRunEvent;

    @SerializedName("id")
    private final String id;

    @SerializedName(IPiaCacheProvider.CacheConfig.FIELD_META)
    private final JsonElement meta;

    @SerializedName("name")
    private final String name;

    @SerializedName("params")
    private final JsonElement params;

    @SerializedName("result")
    private final JsonElement result;

    public ToolCallInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ToolCallInfo copy$default(ToolCallInfo toolCallInfo, String str, String str2, JsonElement jsonElement, JsonElement jsonElement2, JsonElement jsonElement3, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolCallInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = toolCallInfo.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            jsonElement = toolCallInfo.params;
        }
        JsonElement jsonElement4 = jsonElement;
        if ((i & 8) != 0) {
            jsonElement2 = toolCallInfo.result;
        }
        JsonElement jsonElement5 = jsonElement2;
        if ((i & 16) != 0) {
            jsonElement3 = toolCallInfo.meta;
        }
        JsonElement jsonElement6 = jsonElement3;
        if ((i & 32) != 0) {
            bool = toolCallInfo.alreadyEmittedGeneratingEvent;
        }
        Boolean bool3 = bool;
        if ((i & 64) != 0) {
            bool2 = toolCallInfo.alreadyEmittedRunEvent;
        }
        return toolCallInfo.copy(str, str3, jsonElement4, jsonElement5, jsonElement6, bool3, bool2);
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
    public final JsonElement getParams() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final JsonElement getResult() {
        return this.result;
    }

    /* renamed from: component5, reason: from getter */
    public final JsonElement getMeta() {
        return this.meta;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getAlreadyEmittedGeneratingEvent() {
        return this.alreadyEmittedGeneratingEvent;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getAlreadyEmittedRunEvent() {
        return this.alreadyEmittedRunEvent;
    }

    public final ToolCallInfo copy(String id, String name, JsonElement params, JsonElement result, JsonElement meta, Boolean alreadyEmittedGeneratingEvent, Boolean alreadyEmittedRunEvent) {
        return new ToolCallInfo(id, name, params, result, meta, alreadyEmittedGeneratingEvent, alreadyEmittedRunEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallInfo)) {
            return false;
        }
        ToolCallInfo toolCallInfo = (ToolCallInfo) other;
        return Intrinsics.areEqual(this.id, toolCallInfo.id) && Intrinsics.areEqual(this.name, toolCallInfo.name) && Intrinsics.areEqual(this.params, toolCallInfo.params) && Intrinsics.areEqual(this.result, toolCallInfo.result) && Intrinsics.areEqual(this.meta, toolCallInfo.meta) && Intrinsics.areEqual(this.alreadyEmittedGeneratingEvent, toolCallInfo.alreadyEmittedGeneratingEvent) && Intrinsics.areEqual(this.alreadyEmittedRunEvent, toolCallInfo.alreadyEmittedRunEvent);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonElement jsonElement = this.params;
        int hashCode3 = (hashCode2 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
        JsonElement jsonElement2 = this.result;
        int hashCode4 = (hashCode3 + (jsonElement2 == null ? 0 : jsonElement2.hashCode())) * 31;
        JsonElement jsonElement3 = this.meta;
        int hashCode5 = (hashCode4 + (jsonElement3 == null ? 0 : jsonElement3.hashCode())) * 31;
        Boolean bool = this.alreadyEmittedGeneratingEvent;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.alreadyEmittedRunEvent;
        return hashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "ToolCallInfo(id=" + this.id + ", name=" + this.name + ", params=" + this.params + ", result=" + this.result + ", meta=" + this.meta + ", alreadyEmittedGeneratingEvent=" + this.alreadyEmittedGeneratingEvent + ", alreadyEmittedRunEvent=" + this.alreadyEmittedRunEvent + ')';
    }

    public ToolCallInfo(String str, String str2, JsonElement jsonElement, JsonElement jsonElement2, JsonElement jsonElement3, Boolean bool, Boolean bool2) {
        this.id = str;
        this.name = str2;
        this.params = jsonElement;
        this.result = jsonElement2;
        this.meta = jsonElement3;
        this.alreadyEmittedGeneratingEvent = bool;
        this.alreadyEmittedRunEvent = bool2;
    }

    public /* synthetic */ ToolCallInfo(String str, String str2, JsonElement jsonElement, JsonElement jsonElement2, JsonElement jsonElement3, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : jsonElement, (i & 8) != 0 ? null : jsonElement2, (i & 16) != 0 ? null : jsonElement3, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? null : bool2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final JsonElement getParams() {
        return this.params;
    }

    public final JsonElement getResult() {
        return this.result;
    }

    public final JsonElement getMeta() {
        return this.meta;
    }

    public final Boolean getAlreadyEmittedGeneratingEvent() {
        return this.alreadyEmittedGeneratingEvent;
    }

    public final Boolean getAlreadyEmittedRunEvent() {
        return this.alreadyEmittedRunEvent;
    }
}
