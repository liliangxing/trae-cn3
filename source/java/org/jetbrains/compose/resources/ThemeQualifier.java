package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Qualifier.kt */
@InternalResourceApi
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00072\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lorg/jetbrains/compose/resources/ThemeQualifier;", "Lorg/jetbrains/compose/resources/Qualifier;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "Companion", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class ThemeQualifier implements Qualifier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ThemeQualifier[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ThemeQualifier LIGHT = new ThemeQualifier("LIGHT", 0);
    public static final ThemeQualifier DARK = new ThemeQualifier("DARK", 1);

    private static final /* synthetic */ ThemeQualifier[] $values() {
        return new ThemeQualifier[]{LIGHT, DARK};
    }

    public static EnumEntries<ThemeQualifier> getEntries() {
        return $ENTRIES;
    }

    private ThemeQualifier(String str, int i) {
    }

    static {
        ThemeQualifier[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: Qualifier.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lorg/jetbrains/compose/resources/ThemeQualifier$Companion;", "", "<init>", "()V", "selectByValue", "Lorg/jetbrains/compose/resources/ThemeQualifier;", "isDark", "", "library_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThemeQualifier selectByValue(boolean isDark) {
            return isDark ? ThemeQualifier.DARK : ThemeQualifier.LIGHT;
        }
    }

    public static ThemeQualifier valueOf(String str) {
        return (ThemeQualifier) Enum.valueOf(ThemeQualifier.class, str);
    }

    public static ThemeQualifier[] values() {
        return (ThemeQualifier[]) $VALUES.clone();
    }
}
