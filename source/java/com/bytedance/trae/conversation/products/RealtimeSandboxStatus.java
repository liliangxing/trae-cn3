package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "SUBMITTED", "INITIALIZING", "READY", "TERMINATING", "TERMINATED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealtimeSandboxStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RealtimeSandboxStatus[] $VALUES;
    private final int value;
    public static final RealtimeSandboxStatus UNKNOWN = new RealtimeSandboxStatus("UNKNOWN", 0, 0);
    public static final RealtimeSandboxStatus SUBMITTED = new RealtimeSandboxStatus("SUBMITTED", 1, 1);
    public static final RealtimeSandboxStatus INITIALIZING = new RealtimeSandboxStatus("INITIALIZING", 2, 2);
    public static final RealtimeSandboxStatus READY = new RealtimeSandboxStatus("READY", 3, 3);
    public static final RealtimeSandboxStatus TERMINATING = new RealtimeSandboxStatus("TERMINATING", 4, 4);
    public static final RealtimeSandboxStatus TERMINATED = new RealtimeSandboxStatus("TERMINATED", 5, 5);

    private static final /* synthetic */ RealtimeSandboxStatus[] $values() {
        return new RealtimeSandboxStatus[]{UNKNOWN, SUBMITTED, INITIALIZING, READY, TERMINATING, TERMINATED};
    }

    public static EnumEntries<RealtimeSandboxStatus> getEntries() {
        return $ENTRIES;
    }

    private RealtimeSandboxStatus(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        RealtimeSandboxStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RealtimeSandboxStatus valueOf(String str) {
        return (RealtimeSandboxStatus) Enum.valueOf(RealtimeSandboxStatus.class, str);
    }

    public static RealtimeSandboxStatus[] values() {
        return (RealtimeSandboxStatus[]) $VALUES.clone();
    }
}
