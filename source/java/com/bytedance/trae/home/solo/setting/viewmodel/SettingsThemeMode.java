package com.bytedance.trae.home.solo.setting.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Light", "Dark", "System", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsThemeMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SettingsThemeMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final SettingsThemeMode Light = new SettingsThemeMode("Light", 0, "light");
    public static final SettingsThemeMode Dark = new SettingsThemeMode("Dark", 1, "dark");
    public static final SettingsThemeMode System = new SettingsThemeMode("System", 2, "system");

    private static final /* synthetic */ SettingsThemeMode[] $values() {
        return new SettingsThemeMode[]{Light, Dark, System};
    }

    public static EnumEntries<SettingsThemeMode> getEntries() {
        return $ENTRIES;
    }

    private SettingsThemeMode(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        SettingsThemeMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: SettingsUiState.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;", "", "<init>", "()V", "fromValue", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "value", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SettingsThemeMode fromValue(String value) {
            return Intrinsics.areEqual(value, SettingsThemeMode.Dark.getValue()) ? SettingsThemeMode.Dark : Intrinsics.areEqual(value, SettingsThemeMode.System.getValue()) ? SettingsThemeMode.System : SettingsThemeMode.Light;
        }
    }

    public static SettingsThemeMode valueOf(String str) {
        return (SettingsThemeMode) Enum.valueOf(SettingsThemeMode.class, str);
    }

    public static SettingsThemeMode[] values() {
        return (SettingsThemeMode[]) $VALUES.clone();
    }
}
