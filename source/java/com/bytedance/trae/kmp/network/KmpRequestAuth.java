package com.bytedance.trae.kmp.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KmpHttpClient.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpRequestAuth;", "", "<init>", "(Ljava/lang/String;I)V", "None", "CloudIdeJwtAuthorization", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpRequestAuth {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmpRequestAuth[] $VALUES;
    public static final KmpRequestAuth None = new KmpRequestAuth("None", 0);
    public static final KmpRequestAuth CloudIdeJwtAuthorization = new KmpRequestAuth("CloudIdeJwtAuthorization", 1);

    private static final /* synthetic */ KmpRequestAuth[] $values() {
        return new KmpRequestAuth[]{None, CloudIdeJwtAuthorization};
    }

    public static EnumEntries<KmpRequestAuth> getEntries() {
        return $ENTRIES;
    }

    private KmpRequestAuth(String str, int i) {
    }

    static {
        KmpRequestAuth[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static KmpRequestAuth valueOf(String str) {
        return (KmpRequestAuth) Enum.valueOf(KmpRequestAuth.class, str);
    }

    public static KmpRequestAuth[] values() {
        return (KmpRequestAuth[]) $VALUES.clone();
    }
}
