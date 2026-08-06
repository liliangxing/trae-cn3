package com.bytedance.trae.conversation.debug;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationDebugInfoCopier.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;", "", "voiceRoomId", "", "voiceTaskId", "subTaskSessionId", "subTaskParentSessionId", "subTaskSourceTaskId", "subTaskLocalTaskId", "subTaskState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVoiceRoomId", "()Ljava/lang/String;", "getVoiceTaskId", "getSubTaskSessionId", "getSubTaskParentSessionId", "getSubTaskSourceTaskId", "getSubTaskLocalTaskId", "getSubTaskState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VoiceDiscussionDebugLogInfo {
    private final String subTaskLocalTaskId;
    private final String subTaskParentSessionId;
    private final String subTaskSessionId;
    private final String subTaskSourceTaskId;
    private final String subTaskState;
    private final String voiceRoomId;
    private final String voiceTaskId;

    public VoiceDiscussionDebugLogInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ VoiceDiscussionDebugLogInfo copy$default(VoiceDiscussionDebugLogInfo voiceDiscussionDebugLogInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceDiscussionDebugLogInfo.voiceRoomId;
        }
        if ((i & 2) != 0) {
            str2 = voiceDiscussionDebugLogInfo.voiceTaskId;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = voiceDiscussionDebugLogInfo.subTaskSessionId;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = voiceDiscussionDebugLogInfo.subTaskParentSessionId;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = voiceDiscussionDebugLogInfo.subTaskSourceTaskId;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = voiceDiscussionDebugLogInfo.subTaskLocalTaskId;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = voiceDiscussionDebugLogInfo.subTaskState;
        }
        return voiceDiscussionDebugLogInfo.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVoiceRoomId() {
        return this.voiceRoomId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVoiceTaskId() {
        return this.voiceTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSubTaskSessionId() {
        return this.subTaskSessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubTaskParentSessionId() {
        return this.subTaskParentSessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSubTaskSourceTaskId() {
        return this.subTaskSourceTaskId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSubTaskLocalTaskId() {
        return this.subTaskLocalTaskId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSubTaskState() {
        return this.subTaskState;
    }

    public final VoiceDiscussionDebugLogInfo copy(String voiceRoomId, String voiceTaskId, String subTaskSessionId, String subTaskParentSessionId, String subTaskSourceTaskId, String subTaskLocalTaskId, String subTaskState) {
        Intrinsics.checkNotNullParameter(voiceRoomId, "voiceRoomId");
        Intrinsics.checkNotNullParameter(voiceTaskId, "voiceTaskId");
        Intrinsics.checkNotNullParameter(subTaskSessionId, "subTaskSessionId");
        Intrinsics.checkNotNullParameter(subTaskParentSessionId, "subTaskParentSessionId");
        Intrinsics.checkNotNullParameter(subTaskSourceTaskId, "subTaskSourceTaskId");
        Intrinsics.checkNotNullParameter(subTaskLocalTaskId, "subTaskLocalTaskId");
        Intrinsics.checkNotNullParameter(subTaskState, "subTaskState");
        return new VoiceDiscussionDebugLogInfo(voiceRoomId, voiceTaskId, subTaskSessionId, subTaskParentSessionId, subTaskSourceTaskId, subTaskLocalTaskId, subTaskState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceDiscussionDebugLogInfo)) {
            return false;
        }
        VoiceDiscussionDebugLogInfo voiceDiscussionDebugLogInfo = (VoiceDiscussionDebugLogInfo) other;
        return Intrinsics.areEqual(this.voiceRoomId, voiceDiscussionDebugLogInfo.voiceRoomId) && Intrinsics.areEqual(this.voiceTaskId, voiceDiscussionDebugLogInfo.voiceTaskId) && Intrinsics.areEqual(this.subTaskSessionId, voiceDiscussionDebugLogInfo.subTaskSessionId) && Intrinsics.areEqual(this.subTaskParentSessionId, voiceDiscussionDebugLogInfo.subTaskParentSessionId) && Intrinsics.areEqual(this.subTaskSourceTaskId, voiceDiscussionDebugLogInfo.subTaskSourceTaskId) && Intrinsics.areEqual(this.subTaskLocalTaskId, voiceDiscussionDebugLogInfo.subTaskLocalTaskId) && Intrinsics.areEqual(this.subTaskState, voiceDiscussionDebugLogInfo.subTaskState);
    }

    public int hashCode() {
        return (((((((((((this.voiceRoomId.hashCode() * 31) + this.voiceTaskId.hashCode()) * 31) + this.subTaskSessionId.hashCode()) * 31) + this.subTaskParentSessionId.hashCode()) * 31) + this.subTaskSourceTaskId.hashCode()) * 31) + this.subTaskLocalTaskId.hashCode()) * 31) + this.subTaskState.hashCode();
    }

    public String toString() {
        return "VoiceDiscussionDebugLogInfo(voiceRoomId=" + this.voiceRoomId + ", voiceTaskId=" + this.voiceTaskId + ", subTaskSessionId=" + this.subTaskSessionId + ", subTaskParentSessionId=" + this.subTaskParentSessionId + ", subTaskSourceTaskId=" + this.subTaskSourceTaskId + ", subTaskLocalTaskId=" + this.subTaskLocalTaskId + ", subTaskState=" + this.subTaskState + ')';
    }

    public VoiceDiscussionDebugLogInfo(String voiceRoomId, String voiceTaskId, String subTaskSessionId, String subTaskParentSessionId, String subTaskSourceTaskId, String subTaskLocalTaskId, String subTaskState) {
        Intrinsics.checkNotNullParameter(voiceRoomId, "voiceRoomId");
        Intrinsics.checkNotNullParameter(voiceTaskId, "voiceTaskId");
        Intrinsics.checkNotNullParameter(subTaskSessionId, "subTaskSessionId");
        Intrinsics.checkNotNullParameter(subTaskParentSessionId, "subTaskParentSessionId");
        Intrinsics.checkNotNullParameter(subTaskSourceTaskId, "subTaskSourceTaskId");
        Intrinsics.checkNotNullParameter(subTaskLocalTaskId, "subTaskLocalTaskId");
        Intrinsics.checkNotNullParameter(subTaskState, "subTaskState");
        this.voiceRoomId = voiceRoomId;
        this.voiceTaskId = voiceTaskId;
        this.subTaskSessionId = subTaskSessionId;
        this.subTaskParentSessionId = subTaskParentSessionId;
        this.subTaskSourceTaskId = subTaskSourceTaskId;
        this.subTaskLocalTaskId = subTaskLocalTaskId;
        this.subTaskState = subTaskState;
    }

    public /* synthetic */ VoiceDiscussionDebugLogInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7);
    }

    public final String getVoiceRoomId() {
        return this.voiceRoomId;
    }

    public final String getVoiceTaskId() {
        return this.voiceTaskId;
    }

    public final String getSubTaskSessionId() {
        return this.subTaskSessionId;
    }

    public final String getSubTaskParentSessionId() {
        return this.subTaskParentSessionId;
    }

    public final String getSubTaskSourceTaskId() {
        return this.subTaskSourceTaskId;
    }

    public final String getSubTaskLocalTaskId() {
        return this.subTaskLocalTaskId;
    }

    public final String getSubTaskState() {
        return this.subTaskState;
    }
}
