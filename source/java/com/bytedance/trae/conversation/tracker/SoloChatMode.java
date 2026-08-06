package com.bytedance.trae.conversation.tracker;

import com.bytedance.ies.xbridge.XBridge;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/SoloChatMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WORK", "CODE", XBridge.DEFAULT_NAMESPACE, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SoloChatMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SoloChatMode[] $VALUES;
    private final String value;
    public static final SoloChatMode WORK = new SoloChatMode("WORK", 0, "work");
    public static final SoloChatMode CODE = new SoloChatMode("CODE", 1, "code");
    public static final SoloChatMode DEFAULT = new SoloChatMode(XBridge.DEFAULT_NAMESPACE, 2, "default");

    private static final /* synthetic */ SoloChatMode[] $values() {
        return new SoloChatMode[]{WORK, CODE, DEFAULT};
    }

    public static EnumEntries<SoloChatMode> getEntries() {
        return $ENTRIES;
    }

    private SoloChatMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        SoloChatMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SoloChatMode valueOf(String str) {
        return (SoloChatMode) Enum.valueOf(SoloChatMode.class, str);
    }

    public static SoloChatMode[] values() {
        return (SoloChatMode[]) $VALUES.clone();
    }
}
