package com.bytedance.trae.conversation.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ChatMode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ChatMode;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "MTC", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChatMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChatMode[] $VALUES;
    public static final ChatMode CODE = new ChatMode("CODE", 0);
    public static final ChatMode MTC = new ChatMode("MTC", 1);

    private static final /* synthetic */ ChatMode[] $values() {
        return new ChatMode[]{CODE, MTC};
    }

    public static EnumEntries<ChatMode> getEntries() {
        return $ENTRIES;
    }

    private ChatMode(String str, int i) {
    }

    static {
        ChatMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ChatMode valueOf(String str) {
        return (ChatMode) Enum.valueOf(ChatMode.class, str);
    }

    public static ChatMode[] values() {
        return (ChatMode[]) $VALUES.clone();
    }
}
