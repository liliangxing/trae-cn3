package com.bytedance.trae.conversation.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AttachmentItem.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AttachmentUploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Pending", "Uploading", "Success", "Error", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AttachmentUploadStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AttachmentUploadStatus[] $VALUES;
    public static final AttachmentUploadStatus Pending = new AttachmentUploadStatus("Pending", 0);
    public static final AttachmentUploadStatus Uploading = new AttachmentUploadStatus("Uploading", 1);
    public static final AttachmentUploadStatus Success = new AttachmentUploadStatus("Success", 2);
    public static final AttachmentUploadStatus Error = new AttachmentUploadStatus("Error", 3);

    private static final /* synthetic */ AttachmentUploadStatus[] $values() {
        return new AttachmentUploadStatus[]{Pending, Uploading, Success, Error};
    }

    public static EnumEntries<AttachmentUploadStatus> getEntries() {
        return $ENTRIES;
    }

    private AttachmentUploadStatus(String str, int i) {
    }

    static {
        AttachmentUploadStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AttachmentUploadStatus valueOf(String str) {
        return (AttachmentUploadStatus) Enum.valueOf(AttachmentUploadStatus.class, str);
    }

    public static AttachmentUploadStatus[] values() {
        return (AttachmentUploadStatus[]) $VALUES.clone();
    }
}
