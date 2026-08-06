package com.bytedance.trae.home.solo.setting.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsEntry.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ui/SettingsPopupType;", "", "<init>", "(Ljava/lang/String;I)V", "Theme", "Language", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsPopupType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsPopupType[] $VALUES;
    public static final SettingsPopupType Theme = new SettingsPopupType("Theme", 0);
    public static final SettingsPopupType Language = new SettingsPopupType("Language", 1);

    private static final /* synthetic */ SettingsPopupType[] $values() {
        return new SettingsPopupType[]{Theme, Language};
    }

    public static EnumEntries<SettingsPopupType> getEntries() {
        return $ENTRIES;
    }

    private SettingsPopupType(String str, int i) {
    }

    static {
        SettingsPopupType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SettingsPopupType valueOf(String str) {
        return (SettingsPopupType) Enum.valueOf(SettingsPopupType.class, str);
    }

    public static SettingsPopupType[] values() {
        return (SettingsPopupType[]) $VALUES.clone();
    }
}
