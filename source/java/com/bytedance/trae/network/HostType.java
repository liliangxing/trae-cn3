package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/network/HostType;", "", "<init>", "(Ljava/lang/String;I)V", DebugSettings.ENTERPRISE_ENV_ONLINE, "LOGIN", "AI", "REMOTE", "IMAGEX", "MSSDK", "PASSPORT", "SETTINGS", "PRAISE", "NOTIFICATION", "MARKETPLACE", "WEBSITE", "DOCS", "COMMUNITY", "PLUGIN_WEB", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HostType[] $VALUES;
    public static final HostType ONLINE = new HostType(DebugSettings.ENTERPRISE_ENV_ONLINE, 0);
    public static final HostType LOGIN = new HostType("LOGIN", 1);
    public static final HostType AI = new HostType("AI", 2);
    public static final HostType REMOTE = new HostType("REMOTE", 3);
    public static final HostType IMAGEX = new HostType("IMAGEX", 4);
    public static final HostType MSSDK = new HostType("MSSDK", 5);
    public static final HostType PASSPORT = new HostType("PASSPORT", 6);
    public static final HostType SETTINGS = new HostType("SETTINGS", 7);
    public static final HostType PRAISE = new HostType("PRAISE", 8);
    public static final HostType NOTIFICATION = new HostType("NOTIFICATION", 9);
    public static final HostType MARKETPLACE = new HostType("MARKETPLACE", 10);
    public static final HostType WEBSITE = new HostType("WEBSITE", 11);
    public static final HostType DOCS = new HostType("DOCS", 12);
    public static final HostType COMMUNITY = new HostType("COMMUNITY", 13);
    public static final HostType PLUGIN_WEB = new HostType("PLUGIN_WEB", 14);

    private static final /* synthetic */ HostType[] $values() {
        return new HostType[]{ONLINE, LOGIN, AI, REMOTE, IMAGEX, MSSDK, PASSPORT, SETTINGS, PRAISE, NOTIFICATION, MARKETPLACE, WEBSITE, DOCS, COMMUNITY, PLUGIN_WEB};
    }

    public static EnumEntries<HostType> getEntries() {
        return $ENTRIES;
    }

    private HostType(String str, int i) {
    }

    static {
        HostType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static HostType valueOf(String str) {
        return (HostType) Enum.valueOf(HostType.class, str);
    }

    public static HostType[] values() {
        return (HostType[]) $VALUES.clone();
    }
}
