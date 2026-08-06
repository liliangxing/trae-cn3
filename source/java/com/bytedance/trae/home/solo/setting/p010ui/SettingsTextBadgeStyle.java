package com.bytedance.trae.home.solo.setting.p010ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsEntry.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/ui/SettingsTextBadgeStyle;", "", "<init>", "(Ljava/lang/String;I)V", "Free", "PublicCloud", "Enterprise", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsTextBadgeStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsTextBadgeStyle[] $VALUES;
    public static final SettingsTextBadgeStyle Free = new SettingsTextBadgeStyle("Free", 0);
    public static final SettingsTextBadgeStyle PublicCloud = new SettingsTextBadgeStyle("PublicCloud", 1);
    public static final SettingsTextBadgeStyle Enterprise = new SettingsTextBadgeStyle("Enterprise", 2);

    private static final /* synthetic */ SettingsTextBadgeStyle[] $values() {
        return new SettingsTextBadgeStyle[]{Free, PublicCloud, Enterprise};
    }

    public static EnumEntries<SettingsTextBadgeStyle> getEntries() {
        return $ENTRIES;
    }

    private SettingsTextBadgeStyle(String str, int i) {
    }

    static {
        SettingsTextBadgeStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SettingsTextBadgeStyle valueOf(String str) {
        return (SettingsTextBadgeStyle) Enum.valueOf(SettingsTextBadgeStyle.class, str);
    }

    public static SettingsTextBadgeStyle[] values() {
        return (SettingsTextBadgeStyle[]) $VALUES.clone();
    }
}
