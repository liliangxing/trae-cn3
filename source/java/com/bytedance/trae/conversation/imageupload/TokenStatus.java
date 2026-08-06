package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/TokenStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Valid", "NeedAsyncRefresh", "NeedSyncRefresh", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TokenStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TokenStatus[] $VALUES;
    public static final TokenStatus Valid = new TokenStatus("Valid", 0);
    public static final TokenStatus NeedAsyncRefresh = new TokenStatus("NeedAsyncRefresh", 1);
    public static final TokenStatus NeedSyncRefresh = new TokenStatus("NeedSyncRefresh", 2);

    private static final /* synthetic */ TokenStatus[] $values() {
        return new TokenStatus[]{Valid, NeedAsyncRefresh, NeedSyncRefresh};
    }

    public static EnumEntries<TokenStatus> getEntries() {
        return $ENTRIES;
    }

    private TokenStatus(String str, int i) {
    }

    static {
        TokenStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TokenStatus valueOf(String str) {
        return (TokenStatus) Enum.valueOf(TokenStatus.class, str);
    }

    public static TokenStatus[] values() {
        return (TokenStatus[]) $VALUES.clone();
    }
}
