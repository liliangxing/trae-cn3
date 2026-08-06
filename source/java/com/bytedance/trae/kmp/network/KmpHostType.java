package com.bytedance.trae.kmp.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: KmpHostResolver.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/kmp/network/KmpHostType;", "", "<init>", "(Ljava/lang/String;I)V", "Online", "Login", "Ai", "Remote", "Imagex", "Mssdk", "Passport", "Settings", "Praise", "Notification", "Marketplace", "Website", "Docs", "Community", "PluginWeb", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KmpHostType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmpHostType[] $VALUES;
    public static final KmpHostType Online = new KmpHostType("Online", 0);
    public static final KmpHostType Login = new KmpHostType("Login", 1);
    public static final KmpHostType Ai = new KmpHostType("Ai", 2);
    public static final KmpHostType Remote = new KmpHostType("Remote", 3);
    public static final KmpHostType Imagex = new KmpHostType("Imagex", 4);
    public static final KmpHostType Mssdk = new KmpHostType("Mssdk", 5);
    public static final KmpHostType Passport = new KmpHostType("Passport", 6);
    public static final KmpHostType Settings = new KmpHostType("Settings", 7);
    public static final KmpHostType Praise = new KmpHostType("Praise", 8);
    public static final KmpHostType Notification = new KmpHostType("Notification", 9);
    public static final KmpHostType Marketplace = new KmpHostType("Marketplace", 10);
    public static final KmpHostType Website = new KmpHostType("Website", 11);
    public static final KmpHostType Docs = new KmpHostType("Docs", 12);
    public static final KmpHostType Community = new KmpHostType("Community", 13);
    public static final KmpHostType PluginWeb = new KmpHostType("PluginWeb", 14);

    private static final /* synthetic */ KmpHostType[] $values() {
        return new KmpHostType[]{Online, Login, Ai, Remote, Imagex, Mssdk, Passport, Settings, Praise, Notification, Marketplace, Website, Docs, Community, PluginWeb};
    }

    public static EnumEntries<KmpHostType> getEntries() {
        return $ENTRIES;
    }

    private KmpHostType(String str, int i) {
    }

    static {
        KmpHostType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static KmpHostType valueOf(String str) {
        return (KmpHostType) Enum.valueOf(KmpHostType.class, str);
    }

    public static KmpHostType[] values() {
        return (KmpHostType[]) $VALUES.clone();
    }
}
