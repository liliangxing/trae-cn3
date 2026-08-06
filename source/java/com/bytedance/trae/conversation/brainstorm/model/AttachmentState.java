package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormAttachment.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/AttachmentState;", "", "<init>", "(Ljava/lang/String;I)V", "Uploading", "Uploaded", "Failed", "Cancelled", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AttachmentState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AttachmentState[] $VALUES;
    public static final AttachmentState Uploading = new AttachmentState("Uploading", 0);
    public static final AttachmentState Uploaded = new AttachmentState("Uploaded", 1);
    public static final AttachmentState Failed = new AttachmentState("Failed", 2);
    public static final AttachmentState Cancelled = new AttachmentState("Cancelled", 3);

    private static final /* synthetic */ AttachmentState[] $values() {
        return new AttachmentState[]{Uploading, Uploaded, Failed, Cancelled};
    }

    public static EnumEntries<AttachmentState> getEntries() {
        return $ENTRIES;
    }

    private AttachmentState(String str, int i) {
    }

    static {
        AttachmentState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AttachmentState valueOf(String str) {
        return (AttachmentState) Enum.valueOf(AttachmentState.class, str);
    }

    public static AttachmentState[] values() {
        return (AttachmentState[]) $VALUES.clone();
    }
}
