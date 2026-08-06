package com.bytedance.trae.conversation.fileupload;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ResourceUploadModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/fileupload/BizType;", "", "<init>", "(Ljava/lang/String;I)V", "RemoteResource", "Image", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BizType[] $VALUES;

    @SerializedName("remote_resource")
    public static final BizType RemoteResource = new BizType("RemoteResource", 0);

    @SerializedName("image")
    public static final BizType Image = new BizType("Image", 1);

    private static final /* synthetic */ BizType[] $values() {
        return new BizType[]{RemoteResource, Image};
    }

    public static EnumEntries<BizType> getEntries() {
        return $ENTRIES;
    }

    private BizType(String str, int i) {
    }

    static {
        BizType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BizType valueOf(String str) {
        return (BizType) Enum.valueOf(BizType.class, str);
    }

    public static BizType[] values() {
        return (BizType[]) $VALUES.clone();
    }
}
