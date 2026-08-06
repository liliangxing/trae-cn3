package com.bytedance.trae.home.solo.setting.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutItemKey;", "", "<init>", "(Ljava/lang/String;I)V", "Terms", "Privacy", "OpenSource", "Help", "Community", "Contact", "PersonalInfoList", "ShareList", "BusinessLicense", "IcpFiling", "PermissionUsage", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsAboutItemKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsAboutItemKey[] $VALUES;
    public static final SettingsAboutItemKey Terms = new SettingsAboutItemKey("Terms", 0);
    public static final SettingsAboutItemKey Privacy = new SettingsAboutItemKey("Privacy", 1);
    public static final SettingsAboutItemKey OpenSource = new SettingsAboutItemKey("OpenSource", 2);
    public static final SettingsAboutItemKey Help = new SettingsAboutItemKey("Help", 3);
    public static final SettingsAboutItemKey Community = new SettingsAboutItemKey("Community", 4);
    public static final SettingsAboutItemKey Contact = new SettingsAboutItemKey("Contact", 5);
    public static final SettingsAboutItemKey PersonalInfoList = new SettingsAboutItemKey("PersonalInfoList", 6);
    public static final SettingsAboutItemKey ShareList = new SettingsAboutItemKey("ShareList", 7);
    public static final SettingsAboutItemKey BusinessLicense = new SettingsAboutItemKey("BusinessLicense", 8);
    public static final SettingsAboutItemKey IcpFiling = new SettingsAboutItemKey("IcpFiling", 9);
    public static final SettingsAboutItemKey PermissionUsage = new SettingsAboutItemKey("PermissionUsage", 10);

    private static final /* synthetic */ SettingsAboutItemKey[] $values() {
        return new SettingsAboutItemKey[]{Terms, Privacy, OpenSource, Help, Community, Contact, PersonalInfoList, ShareList, BusinessLicense, IcpFiling, PermissionUsage};
    }

    public static EnumEntries<SettingsAboutItemKey> getEntries() {
        return $ENTRIES;
    }

    private SettingsAboutItemKey(String str, int i) {
    }

    static {
        SettingsAboutItemKey[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SettingsAboutItemKey valueOf(String str) {
        return (SettingsAboutItemKey) Enum.valueOf(SettingsAboutItemKey.class, str);
    }

    public static SettingsAboutItemKey[] values() {
        return (SettingsAboutItemKey[]) $VALUES.clone();
    }
}
