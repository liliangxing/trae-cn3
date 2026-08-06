package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormMessage.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;", "", "<init>", "(Ljava/lang/String;I)V", "User", "Assistant", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageRole {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageRole[] $VALUES;
    public static final MessageRole User = new MessageRole("User", 0);
    public static final MessageRole Assistant = new MessageRole("Assistant", 1);

    private static final /* synthetic */ MessageRole[] $values() {
        return new MessageRole[]{User, Assistant};
    }

    public static EnumEntries<MessageRole> getEntries() {
        return $ENTRIES;
    }

    private MessageRole(String str, int i) {
    }

    static {
        MessageRole[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static MessageRole valueOf(String str) {
        return (MessageRole) Enum.valueOf(MessageRole.class, str);
    }

    public static MessageRole[] values() {
        return (MessageRole[]) $VALUES.clone();
    }
}
