package com.bytedance.trae.im.service;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J`\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016¨\u0006("}, d2 = {"Lcom/bytedance/trae/im/service/ChatEvent;", "", DBData.FIELD_TYPE, "", OnekeyLoginConstants.CU_KEY_SEQ, "", "data", "Lcom/bytedance/trae/im/service/ChatEventPayload;", "newToolCall", "", "cleanThought", "thoughtFirstData", "toolcallFirstData", "<init>", "(Ljava/lang/String;ILcom/bytedance/trae/im/service/ChatEventPayload;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getType", "()Ljava/lang/String;", "getSeq", "()I", "getData", "()Lcom/bytedance/trae/im/service/ChatEventPayload;", "getNewToolCall", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCleanThought", "getThoughtFirstData", "getToolcallFirstData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;ILcom/bytedance/trae/im/service/ChatEventPayload;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/ChatEvent;", "equals", "other", "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class ChatEvent {

    @SerializedName("clean_thought")
    private final Boolean cleanThought;

    @SerializedName("data")
    private final ChatEventPayload data;

    @SerializedName("new_tool_call")
    private final Boolean newToolCall;

    @SerializedName(OnekeyLoginConstants.CU_KEY_SEQ)
    private final int seq;

    @SerializedName("thought_first_data")
    private final Boolean thoughtFirstData;

    @SerializedName("toolcall_first_data")
    private final Boolean toolcallFirstData;

    @SerializedName(DBData.FIELD_TYPE)
    private final String type;

    public ChatEvent() {
        this(null, 0, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ChatEvent copy$default(ChatEvent chatEvent, String str, int i, ChatEventPayload chatEventPayload, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = chatEvent.type;
        }
        if ((i2 & 2) != 0) {
            i = chatEvent.seq;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            chatEventPayload = chatEvent.data;
        }
        ChatEventPayload chatEventPayload2 = chatEventPayload;
        if ((i2 & 8) != 0) {
            bool = chatEvent.newToolCall;
        }
        Boolean bool5 = bool;
        if ((i2 & 16) != 0) {
            bool2 = chatEvent.cleanThought;
        }
        Boolean bool6 = bool2;
        if ((i2 & 32) != 0) {
            bool3 = chatEvent.thoughtFirstData;
        }
        Boolean bool7 = bool3;
        if ((i2 & 64) != 0) {
            bool4 = chatEvent.toolcallFirstData;
        }
        return chatEvent.copy(str, i3, chatEventPayload2, bool5, bool6, bool7, bool4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSeq() {
        return this.seq;
    }

    /* renamed from: component3, reason: from getter */
    public final ChatEventPayload getData() {
        return this.data;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getNewToolCall() {
        return this.newToolCall;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getCleanThought() {
        return this.cleanThought;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getThoughtFirstData() {
        return this.thoughtFirstData;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getToolcallFirstData() {
        return this.toolcallFirstData;
    }

    public final ChatEvent copy(String type, int seq, ChatEventPayload data, Boolean newToolCall, Boolean cleanThought, Boolean thoughtFirstData, Boolean toolcallFirstData) {
        return new ChatEvent(type, seq, data, newToolCall, cleanThought, thoughtFirstData, toolcallFirstData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatEvent)) {
            return false;
        }
        ChatEvent chatEvent = (ChatEvent) other;
        return Intrinsics.areEqual(this.type, chatEvent.type) && this.seq == chatEvent.seq && Intrinsics.areEqual(this.data, chatEvent.data) && Intrinsics.areEqual(this.newToolCall, chatEvent.newToolCall) && Intrinsics.areEqual(this.cleanThought, chatEvent.cleanThought) && Intrinsics.areEqual(this.thoughtFirstData, chatEvent.thoughtFirstData) && Intrinsics.areEqual(this.toolcallFirstData, chatEvent.toolcallFirstData);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.seq)) * 31;
        ChatEventPayload chatEventPayload = this.data;
        int hashCode2 = (hashCode + (chatEventPayload == null ? 0 : chatEventPayload.hashCode())) * 31;
        Boolean bool = this.newToolCall;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.cleanThought;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.thoughtFirstData;
        int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.toolcallFirstData;
        return hashCode5 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "ChatEvent(type=" + this.type + ", seq=" + this.seq + ", data=" + this.data + ", newToolCall=" + this.newToolCall + ", cleanThought=" + this.cleanThought + ", thoughtFirstData=" + this.thoughtFirstData + ", toolcallFirstData=" + this.toolcallFirstData + ')';
    }

    public ChatEvent(String str, int i, ChatEventPayload chatEventPayload, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.type = str;
        this.seq = i;
        this.data = chatEventPayload;
        this.newToolCall = bool;
        this.cleanThought = bool2;
        this.thoughtFirstData = bool3;
        this.toolcallFirstData = bool4;
    }

    public /* synthetic */ ChatEvent(String str, int i, ChatEventPayload chatEventPayload, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : chatEventPayload, (i2 & 8) != 0 ? null : bool, (i2 & 16) != 0 ? null : bool2, (i2 & 32) != 0 ? null : bool3, (i2 & 64) != 0 ? null : bool4);
    }

    public final String getType() {
        return this.type;
    }

    public final int getSeq() {
        return this.seq;
    }

    public final ChatEventPayload getData() {
        return this.data;
    }

    public final Boolean getNewToolCall() {
        return this.newToolCall;
    }

    public final Boolean getCleanThought() {
        return this.cleanThought;
    }

    public final Boolean getThoughtFirstData() {
        return this.thoughtFirstData;
    }

    public final Boolean getToolcallFirstData() {
        return this.toolcallFirstData;
    }
}
