package com.bytedance.trae.im.service;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/im/service/CliType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LOCAL", "REMOTE", "IDE", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CliType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CliType[] $VALUES;
    private final String value;

    @SerializedName(ImagesContract.LOCAL)
    public static final CliType LOCAL = new CliType("LOCAL", 0, ImagesContract.LOCAL);

    @SerializedName("remote")
    public static final CliType REMOTE = new CliType("REMOTE", 1, "remote");

    @SerializedName("local_ide")
    public static final CliType IDE = new CliType("IDE", 2, "local_ide");

    private static final /* synthetic */ CliType[] $values() {
        return new CliType[]{LOCAL, REMOTE, IDE};
    }

    public static EnumEntries<CliType> getEntries() {
        return $ENTRIES;
    }

    private CliType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        CliType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CliType valueOf(String str) {
        return (CliType) Enum.valueOf(CliType.class, str);
    }

    public static CliType[] values() {
        return (CliType[]) $VALUES.clone();
    }
}
