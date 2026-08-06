package com.bytedance.trae.conversation.chat.viewholder;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;", "", "kind", "Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;", "sourceId", "", "displayName", "<init>", "(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;Ljava/lang/String;Ljava/lang/String;)V", "getKind", "()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;", "getSourceId", "()Ljava/lang/String;", "getDisplayName", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserPreviewImageItem {
    private final String displayName;
    private final UserPreviewImageKind kind;
    private final String sourceId;

    public static /* synthetic */ UserPreviewImageItem copy$default(UserPreviewImageItem userPreviewImageItem, UserPreviewImageKind userPreviewImageKind, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            userPreviewImageKind = userPreviewImageItem.kind;
        }
        if ((i & 2) != 0) {
            str = userPreviewImageItem.sourceId;
        }
        if ((i & 4) != 0) {
            str2 = userPreviewImageItem.displayName;
        }
        return userPreviewImageItem.copy(userPreviewImageKind, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final UserPreviewImageKind getKind() {
        return this.kind;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSourceId() {
        return this.sourceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final UserPreviewImageItem copy(UserPreviewImageKind kind, String sourceId, String displayName) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        return new UserPreviewImageItem(kind, sourceId, displayName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserPreviewImageItem)) {
            return false;
        }
        UserPreviewImageItem userPreviewImageItem = (UserPreviewImageItem) other;
        return this.kind == userPreviewImageItem.kind && Intrinsics.areEqual(this.sourceId, userPreviewImageItem.sourceId) && Intrinsics.areEqual(this.displayName, userPreviewImageItem.displayName);
    }

    public int hashCode() {
        int hashCode = ((this.kind.hashCode() * 31) + this.sourceId.hashCode()) * 31;
        String str = this.displayName;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "UserPreviewImageItem(kind=" + this.kind + ", sourceId=" + this.sourceId + ", displayName=" + this.displayName + ')';
    }

    public UserPreviewImageItem(UserPreviewImageKind kind, String sourceId, String str) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        this.kind = kind;
        this.sourceId = sourceId;
        this.displayName = str;
    }

    public /* synthetic */ UserPreviewImageItem(UserPreviewImageKind userPreviewImageKind, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userPreviewImageKind, str, (i & 4) != 0 ? null : str2);
    }

    public final UserPreviewImageKind getKind() {
        return this.kind;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
