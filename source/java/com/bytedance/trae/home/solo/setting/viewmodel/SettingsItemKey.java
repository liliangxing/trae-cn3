package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;", "", "<init>", "(Ljava/lang/String;I)V", "Subscribe", "Usage", "Account", ServiceType.IM, "Points", "Theme", "Language", "Notification", "DeviceManagement", "Connectors", "PrivacyPermission", "Update", "About", "Debug", "Logout", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsItemKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsItemKey[] $VALUES;
    public static final SettingsItemKey Subscribe = new SettingsItemKey("Subscribe", 0);
    public static final SettingsItemKey Usage = new SettingsItemKey("Usage", 1);
    public static final SettingsItemKey Account = new SettingsItemKey("Account", 2);
    public static final SettingsItemKey Message = new SettingsItemKey(ServiceType.IM, 3);
    public static final SettingsItemKey Points = new SettingsItemKey("Points", 4);
    public static final SettingsItemKey Theme = new SettingsItemKey("Theme", 5);
    public static final SettingsItemKey Language = new SettingsItemKey("Language", 6);
    public static final SettingsItemKey Notification = new SettingsItemKey("Notification", 7);
    public static final SettingsItemKey DeviceManagement = new SettingsItemKey("DeviceManagement", 8);
    public static final SettingsItemKey Connectors = new SettingsItemKey("Connectors", 9);
    public static final SettingsItemKey PrivacyPermission = new SettingsItemKey("PrivacyPermission", 10);
    public static final SettingsItemKey Update = new SettingsItemKey("Update", 11);
    public static final SettingsItemKey About = new SettingsItemKey("About", 12);
    public static final SettingsItemKey Debug = new SettingsItemKey("Debug", 13);
    public static final SettingsItemKey Logout = new SettingsItemKey("Logout", 14);

    private static final /* synthetic */ SettingsItemKey[] $values() {
        return new SettingsItemKey[]{Subscribe, Usage, Account, Message, Points, Theme, Language, Notification, DeviceManagement, Connectors, PrivacyPermission, Update, About, Debug, Logout};
    }

    public static EnumEntries<SettingsItemKey> getEntries() {
        return $ENTRIES;
    }

    private SettingsItemKey(String str, int i) {
    }

    static {
        SettingsItemKey[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SettingsItemKey valueOf(String str) {
        return (SettingsItemKey) Enum.valueOf(SettingsItemKey.class, str);
    }

    public static SettingsItemKey[] values() {
        return (SettingsItemKey[]) $VALUES.clone();
    }
}
