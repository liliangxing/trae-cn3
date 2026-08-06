package com.bytedance.trae.conversation.fileupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/UploadStage;", "", "<init>", "(Ljava/lang/String;I)V", "Prepare", "Upload", "Commit", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadStage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UploadStage[] $VALUES;
    public static final UploadStage Prepare = new UploadStage("Prepare", 0);
    public static final UploadStage Upload = new UploadStage("Upload", 1);
    public static final UploadStage Commit = new UploadStage("Commit", 2);

    private static final /* synthetic */ UploadStage[] $values() {
        return new UploadStage[]{Prepare, Upload, Commit};
    }

    public static EnumEntries<UploadStage> getEntries() {
        return $ENTRIES;
    }

    private UploadStage(String str, int i) {
    }

    static {
        UploadStage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static UploadStage valueOf(String str) {
        return (UploadStage) Enum.valueOf(UploadStage.class, str);
    }

    public static UploadStage[] values() {
        return (UploadStage[]) $VALUES.clone();
    }
}
