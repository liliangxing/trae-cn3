package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IListEventsService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017Jn\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017¨\u0006*"}, d2 = {"Lcom/bytedance/trae/im/service/EventItem;", "", DBDefinition.TASK_ID, "", OnekeyLoginConstants.CU_KEY_SEQ, "", "type", "data", "newToolCall", "", "cleanThought", "thoughtFirstData", "toolcallFirstData", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getTaskId", "()Ljava/lang/String;", "getSeq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getType", "getData", "getNewToolCall", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCleanThought", "getThoughtFirstData", "getToolcallFirstData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/EventItem;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EventItem {

    @SerializedName("clean_thought")
    private final Boolean cleanThought;

    @SerializedName("data")
    private final String data;

    @SerializedName("new_tool_call")
    private final Boolean newToolCall;

    @SerializedName(OnekeyLoginConstants.CU_KEY_SEQ)
    private final Integer seq;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("thought_first_data")
    private final Boolean thoughtFirstData;

    @SerializedName("toolcall_first_data")
    private final Boolean toolcallFirstData;

    @SerializedName("type")
    private final String type;

    public EventItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getSeq() {
        return this.seq;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getNewToolCall() {
        return this.newToolCall;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getCleanThought() {
        return this.cleanThought;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getThoughtFirstData() {
        return this.thoughtFirstData;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getToolcallFirstData() {
        return this.toolcallFirstData;
    }

    public final EventItem copy(String taskId, Integer seq, String type, String data, Boolean newToolCall, Boolean cleanThought, Boolean thoughtFirstData, Boolean toolcallFirstData) {
        return new EventItem(taskId, seq, type, data, newToolCall, cleanThought, thoughtFirstData, toolcallFirstData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventItem)) {
            return false;
        }
        EventItem eventItem = (EventItem) other;
        return Intrinsics.areEqual(this.taskId, eventItem.taskId) && Intrinsics.areEqual(this.seq, eventItem.seq) && Intrinsics.areEqual(this.type, eventItem.type) && Intrinsics.areEqual(this.data, eventItem.data) && Intrinsics.areEqual(this.newToolCall, eventItem.newToolCall) && Intrinsics.areEqual(this.cleanThought, eventItem.cleanThought) && Intrinsics.areEqual(this.thoughtFirstData, eventItem.thoughtFirstData) && Intrinsics.areEqual(this.toolcallFirstData, eventItem.toolcallFirstData);
    }

    public int hashCode() {
        String str = this.taskId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.seq;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.data;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.newToolCall;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.cleanThought;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.thoughtFirstData;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.toolcallFirstData;
        return hashCode7 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "EventItem(taskId=" + this.taskId + ", seq=" + this.seq + ", type=" + this.type + ", data=" + this.data + ", newToolCall=" + this.newToolCall + ", cleanThought=" + this.cleanThought + ", thoughtFirstData=" + this.thoughtFirstData + ", toolcallFirstData=" + this.toolcallFirstData + ')';
    }

    public EventItem(String str, Integer num, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.taskId = str;
        this.seq = num;
        this.type = str2;
        this.data = str3;
        this.newToolCall = bool;
        this.cleanThought = bool2;
        this.thoughtFirstData = bool3;
        this.toolcallFirstData = bool4;
    }

    public /* synthetic */ EventItem(String str, Integer num, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : bool2, (i & 64) != 0 ? null : bool3, (i & 128) == 0 ? bool4 : null);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Integer getSeq() {
        return this.seq;
    }

    public final String getType() {
        return this.type;
    }

    public final String getData() {
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
