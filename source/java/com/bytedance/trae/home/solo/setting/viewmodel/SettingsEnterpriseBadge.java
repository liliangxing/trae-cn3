package com.bytedance.trae.home.solo.setting.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;", "", "<init>", "(Ljava/lang/String;I)V", "Team", "Enterprise", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsEnterpriseBadge {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsEnterpriseBadge[] $VALUES;
    public static final SettingsEnterpriseBadge Team = new SettingsEnterpriseBadge("Team", 0);
    public static final SettingsEnterpriseBadge Enterprise = new SettingsEnterpriseBadge("Enterprise", 1);

    private static final /* synthetic */ SettingsEnterpriseBadge[] $values() {
        return new SettingsEnterpriseBadge[]{Team, Enterprise};
    }

    public static EnumEntries<SettingsEnterpriseBadge> getEntries() {
        return $ENTRIES;
    }

    private SettingsEnterpriseBadge(String str, int i) {
    }

    static {
        SettingsEnterpriseBadge[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SettingsEnterpriseBadge valueOf(String str) {
        return (SettingsEnterpriseBadge) Enum.valueOf(SettingsEnterpriseBadge.class, str);
    }

    public static SettingsEnterpriseBadge[] values() {
        return (SettingsEnterpriseBadge[]) $VALUES.clone();
    }
}
