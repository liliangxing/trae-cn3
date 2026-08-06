package com.bytedance.trae.conversation.chat.viewholder;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE_ID", "REMOTE_RESOURCE", "LOCAL_ARTIFACT", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPreviewImageKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UserPreviewImageKind[] $VALUES;
    public static final UserPreviewImageKind IMAGE_ID = new UserPreviewImageKind("IMAGE_ID", 0);
    public static final UserPreviewImageKind REMOTE_RESOURCE = new UserPreviewImageKind("REMOTE_RESOURCE", 1);
    public static final UserPreviewImageKind LOCAL_ARTIFACT = new UserPreviewImageKind("LOCAL_ARTIFACT", 2);

    private static final /* synthetic */ UserPreviewImageKind[] $values() {
        return new UserPreviewImageKind[]{IMAGE_ID, REMOTE_RESOURCE, LOCAL_ARTIFACT};
    }

    public static EnumEntries<UserPreviewImageKind> getEntries() {
        return $ENTRIES;
    }

    private UserPreviewImageKind(String str, int i) {
    }

    static {
        UserPreviewImageKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static UserPreviewImageKind valueOf(String str) {
        return (UserPreviewImageKind) Enum.valueOf(UserPreviewImageKind.class, str);
    }

    public static UserPreviewImageKind[] values() {
        return (UserPreviewImageKind[]) $VALUES.clone();
    }
}
