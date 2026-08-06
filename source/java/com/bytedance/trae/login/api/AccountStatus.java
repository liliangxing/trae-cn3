package com.bytedance.trae.login.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AccountStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/login/api/AccountStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOGGED_IN", "LOGGED_OUT", "LOGGED_FAIL", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccountStatus[] $VALUES;
    public static final AccountStatus LOGGED_IN = new AccountStatus("LOGGED_IN", 0);
    public static final AccountStatus LOGGED_OUT = new AccountStatus("LOGGED_OUT", 1);
    public static final AccountStatus LOGGED_FAIL = new AccountStatus("LOGGED_FAIL", 2);

    private static final /* synthetic */ AccountStatus[] $values() {
        return new AccountStatus[]{LOGGED_IN, LOGGED_OUT, LOGGED_FAIL};
    }

    public static EnumEntries<AccountStatus> getEntries() {
        return $ENTRIES;
    }

    private AccountStatus(String str, int i) {
    }

    static {
        AccountStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AccountStatus valueOf(String str) {
        return (AccountStatus) Enum.valueOf(AccountStatus.class, str);
    }

    public static AccountStatus[] values() {
        return (AccountStatus[]) $VALUES.clone();
    }
}
