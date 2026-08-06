package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssistantAvatarDisplayConfig.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;", "", "displayName", "", "avatarKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getAvatarKey", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AssistantAvatarDisplay {
    private final String avatarKey;
    private final String displayName;

    public static /* synthetic */ AssistantAvatarDisplay copy$default(AssistantAvatarDisplay assistantAvatarDisplay, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assistantAvatarDisplay.displayName;
        }
        if ((i & 2) != 0) {
            str2 = assistantAvatarDisplay.avatarKey;
        }
        return assistantAvatarDisplay.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final AssistantAvatarDisplay copy(String displayName, String avatarKey) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(avatarKey, "avatarKey");
        return new AssistantAvatarDisplay(displayName, avatarKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssistantAvatarDisplay)) {
            return false;
        }
        AssistantAvatarDisplay assistantAvatarDisplay = (AssistantAvatarDisplay) other;
        return Intrinsics.areEqual(this.displayName, assistantAvatarDisplay.displayName) && Intrinsics.areEqual(this.avatarKey, assistantAvatarDisplay.avatarKey);
    }

    public int hashCode() {
        return (this.displayName.hashCode() * 31) + this.avatarKey.hashCode();
    }

    public String toString() {
        return "AssistantAvatarDisplay(displayName=" + this.displayName + ", avatarKey=" + this.avatarKey + ')';
    }

    public AssistantAvatarDisplay(String displayName, String avatarKey) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(avatarKey, "avatarKey");
        this.displayName = displayName;
        this.avatarKey = avatarKey;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }
}
