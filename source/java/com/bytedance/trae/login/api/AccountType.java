package com.bytedance.trae.login.api;

import com.bytedance.ies.bullet.kit.web.jsbridge.WebJsBridge;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AccountInfo.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/api/AccountType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNKNOWN", "TOC", "TOB", "BYTEDANCE", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AccountType[] $VALUES;
    private final String value;
    public static final AccountType UNKNOWN = new AccountType("UNKNOWN", 0, "unknown");
    public static final AccountType TOC = new AccountType("TOC", 1, "toc");
    public static final AccountType TOB = new AccountType("TOB", 2, "tob");
    public static final AccountType BYTEDANCE = new AccountType("BYTEDANCE", 3, WebJsBridge.BRIDGE_SCHEME);

    private static final /* synthetic */ AccountType[] $values() {
        return new AccountType[]{UNKNOWN, TOC, TOB, BYTEDANCE};
    }

    public static EnumEntries<AccountType> getEntries() {
        return $ENTRIES;
    }

    private AccountType(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AccountType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AccountType valueOf(String str) {
        return (AccountType) Enum.valueOf(AccountType.class, str);
    }

    public static AccountType[] values() {
        return (AccountType[]) $VALUES.clone();
    }
}
