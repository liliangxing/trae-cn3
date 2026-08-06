package com.bytedance.trae.conversation.voice;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceDiscussionAttemptTracker.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptContext;", "", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "mode", "Lcom/bytedance/trae/im/service/Mode;", "conversationId", "", "roomId", "isNewSession", "", "hasSeenIntro", "<init>", "(Lcom/bytedance/trae/im/service/CliType;Lcom/bytedance/trae/im/service/Mode;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCliType", "()Lcom/bytedance/trae/im/service/CliType;", "getMode", "()Lcom/bytedance/trae/im/service/Mode;", "getConversationId", "()Ljava/lang/String;", "getRoomId", "()Z", "getHasSeenIntro", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VoiceDiscussionAttemptContext {
    private final CliType cliType;
    private final String conversationId;
    private final boolean hasSeenIntro;
    private final boolean isNewSession;
    private final Mode mode;
    private final String roomId;

    public VoiceDiscussionAttemptContext() {
        this(null, null, null, null, false, false, 63, null);
    }

    public static /* synthetic */ VoiceDiscussionAttemptContext copy$default(VoiceDiscussionAttemptContext voiceDiscussionAttemptContext, CliType cliType, Mode mode, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            cliType = voiceDiscussionAttemptContext.cliType;
        }
        if ((i & 2) != 0) {
            mode = voiceDiscussionAttemptContext.mode;
        }
        Mode mode2 = mode;
        if ((i & 4) != 0) {
            str = voiceDiscussionAttemptContext.conversationId;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            str2 = voiceDiscussionAttemptContext.roomId;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            z = voiceDiscussionAttemptContext.isNewSession;
        }
        boolean z3 = z;
        if ((i & 32) != 0) {
            z2 = voiceDiscussionAttemptContext.hasSeenIntro;
        }
        return voiceDiscussionAttemptContext.copy(cliType, mode2, str3, str4, z3, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final CliType getCliType() {
        return this.cliType;
    }

    /* renamed from: component2, reason: from getter */
    public final Mode getMode() {
        return this.mode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsNewSession() {
        return this.isNewSession;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasSeenIntro() {
        return this.hasSeenIntro;
    }

    public final VoiceDiscussionAttemptContext copy(CliType cliType, Mode mode, String conversationId, String roomId, boolean isNewSession, boolean hasSeenIntro) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return new VoiceDiscussionAttemptContext(cliType, mode, conversationId, roomId, isNewSession, hasSeenIntro);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceDiscussionAttemptContext)) {
            return false;
        }
        VoiceDiscussionAttemptContext voiceDiscussionAttemptContext = (VoiceDiscussionAttemptContext) other;
        return this.cliType == voiceDiscussionAttemptContext.cliType && this.mode == voiceDiscussionAttemptContext.mode && Intrinsics.areEqual(this.conversationId, voiceDiscussionAttemptContext.conversationId) && Intrinsics.areEqual(this.roomId, voiceDiscussionAttemptContext.roomId) && this.isNewSession == voiceDiscussionAttemptContext.isNewSession && this.hasSeenIntro == voiceDiscussionAttemptContext.hasSeenIntro;
    }

    public int hashCode() {
        return (((((((((this.cliType.hashCode() * 31) + this.mode.hashCode()) * 31) + this.conversationId.hashCode()) * 31) + this.roomId.hashCode()) * 31) + Boolean.hashCode(this.isNewSession)) * 31) + Boolean.hashCode(this.hasSeenIntro);
    }

    public String toString() {
        return "VoiceDiscussionAttemptContext(cliType=" + this.cliType + ", mode=" + this.mode + ", conversationId=" + this.conversationId + ", roomId=" + this.roomId + ", isNewSession=" + this.isNewSession + ", hasSeenIntro=" + this.hasSeenIntro + ')';
    }

    public VoiceDiscussionAttemptContext(CliType cliType, Mode mode, String conversationId, String roomId, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(cliType, "cliType");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.cliType = cliType;
        this.mode = mode;
        this.conversationId = conversationId;
        this.roomId = roomId;
        this.isNewSession = z;
        this.hasSeenIntro = z2;
    }

    public /* synthetic */ VoiceDiscussionAttemptContext(CliType cliType, Mode mode, String str, String str2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CliType.LOCAL : cliType, (i & 2) != 0 ? Mode.WORK : mode, (i & 4) != 0 ? "" : str, (i & 8) == 0 ? str2 : "", (i & 16) != 0 ? true : z, (i & 32) != 0 ? false : z2);
    }

    public final CliType getCliType() {
        return this.cliType;
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final boolean isNewSession() {
        return this.isNewSession;
    }

    public final boolean getHasSeenIntro() {
        return this.hasSeenIntro;
    }
}
