package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TokenRefreshTrigger;", "", "<init>", "(Ljava/lang/String;I)V", "COLD_LAUNCH", "FOREGROUND_HEARTBEAT", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TokenRefreshTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TokenRefreshTrigger[] $VALUES;
    public static final TokenRefreshTrigger COLD_LAUNCH = new TokenRefreshTrigger("COLD_LAUNCH", 0);
    public static final TokenRefreshTrigger FOREGROUND_HEARTBEAT = new TokenRefreshTrigger("FOREGROUND_HEARTBEAT", 1);

    private static final /* synthetic */ TokenRefreshTrigger[] $values() {
        return new TokenRefreshTrigger[]{COLD_LAUNCH, FOREGROUND_HEARTBEAT};
    }

    public static EnumEntries<TokenRefreshTrigger> getEntries() {
        return $ENTRIES;
    }

    private TokenRefreshTrigger(String str, int i) {
    }

    static {
        TokenRefreshTrigger[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static TokenRefreshTrigger valueOf(String str) {
        return (TokenRefreshTrigger) Enum.valueOf(TokenRefreshTrigger.class, str);
    }

    public static TokenRefreshTrigger[] values() {
        return (TokenRefreshTrigger[]) $VALUES.clone();
    }
}
