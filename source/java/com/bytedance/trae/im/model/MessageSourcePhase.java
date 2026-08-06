package com.bytedance.trae.im.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/im/model/MessageSourcePhase;", "", "<init>", "(Ljava/lang/String;I)V", "FETCHED", "STREAMING", "STREAM_DONE", "STREAM_ERROR", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageSourcePhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MessageSourcePhase[] $VALUES;
    public static final MessageSourcePhase FETCHED = new MessageSourcePhase("FETCHED", 0);
    public static final MessageSourcePhase STREAMING = new MessageSourcePhase("STREAMING", 1);
    public static final MessageSourcePhase STREAM_DONE = new MessageSourcePhase("STREAM_DONE", 2);
    public static final MessageSourcePhase STREAM_ERROR = new MessageSourcePhase("STREAM_ERROR", 3);

    private static final /* synthetic */ MessageSourcePhase[] $values() {
        return new MessageSourcePhase[]{FETCHED, STREAMING, STREAM_DONE, STREAM_ERROR};
    }

    public static EnumEntries<MessageSourcePhase> getEntries() {
        return $ENTRIES;
    }

    private MessageSourcePhase(String str, int i) {
    }

    static {
        MessageSourcePhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static MessageSourcePhase valueOf(String str) {
        return (MessageSourcePhase) Enum.valueOf(MessageSourcePhase.class, str);
    }

    public static MessageSourcePhase[] values() {
        return (MessageSourcePhase[]) $VALUES.clone();
    }
}
