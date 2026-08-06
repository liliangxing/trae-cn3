package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Pending", "Compressing", "Uploading", "Success", "Error", "Checking", "CheckFailed", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageUploadStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImageUploadStatus[] $VALUES;
    public static final ImageUploadStatus Pending = new ImageUploadStatus("Pending", 0);
    public static final ImageUploadStatus Compressing = new ImageUploadStatus("Compressing", 1);
    public static final ImageUploadStatus Uploading = new ImageUploadStatus("Uploading", 2);
    public static final ImageUploadStatus Success = new ImageUploadStatus("Success", 3);
    public static final ImageUploadStatus Error = new ImageUploadStatus("Error", 4);
    public static final ImageUploadStatus Checking = new ImageUploadStatus("Checking", 5);
    public static final ImageUploadStatus CheckFailed = new ImageUploadStatus("CheckFailed", 6);

    private static final /* synthetic */ ImageUploadStatus[] $values() {
        return new ImageUploadStatus[]{Pending, Compressing, Uploading, Success, Error, Checking, CheckFailed};
    }

    public static EnumEntries<ImageUploadStatus> getEntries() {
        return $ENTRIES;
    }

    private ImageUploadStatus(String str, int i) {
    }

    static {
        ImageUploadStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ImageUploadStatus valueOf(String str) {
        return (ImageUploadStatus) Enum.valueOf(ImageUploadStatus.class, str);
    }

    public static ImageUploadStatus[] values() {
        return (ImageUploadStatus[]) $VALUES.clone();
    }
}
