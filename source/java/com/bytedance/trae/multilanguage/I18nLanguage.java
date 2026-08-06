package com.bytedance.trae.multilanguage;

import com.bytedance.trae.utils.LocaleManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: I18nTextProvider.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/multilanguage/I18nLanguage;", "", "code", "", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Locale;)V", "getCode", "()Ljava/lang/String;", "getLocale", "()Ljava/util/Locale;", "EN", "ZH", "JA", "Companion", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class I18nLanguage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ I18nLanguage[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final I18nLanguage EN;
    public static final I18nLanguage JA;
    public static final I18nLanguage ZH;
    private final String code;
    private final Locale locale;

    private static final /* synthetic */ I18nLanguage[] $values() {
        return new I18nLanguage[]{EN, ZH, JA};
    }

    public static EnumEntries<I18nLanguage> getEntries() {
        return $ENTRIES;
    }

    private I18nLanguage(String str, int i, String str2, Locale locale) {
        this.code = str2;
        this.locale = locale;
    }

    public final String getCode() {
        return this.code;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    static {
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        EN = new I18nLanguage("EN", 0, "en", ENGLISH);
        Locale SIMPLIFIED_CHINESE = Locale.SIMPLIFIED_CHINESE;
        Intrinsics.checkNotNullExpressionValue(SIMPLIFIED_CHINESE, "SIMPLIFIED_CHINESE");
        ZH = new I18nLanguage("ZH", 1, LocaleManager.LANGUAGE_ZH, SIMPLIFIED_CHINESE);
        Locale JAPANESE = Locale.JAPANESE;
        Intrinsics.checkNotNullExpressionValue(JAPANESE, "JAPANESE");
        JA = new I18nLanguage("JA", 2, LocaleManager.LANGUAGE_JA, JAPANESE);
        I18nLanguage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    /* compiled from: I18nTextProvider.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/multilanguage/I18nLanguage$Companion;", "", "<init>", "()V", "fromCode", "Lcom/bytedance/trae/multilanguage/I18nLanguage;", "code", "", "fromLocale", "locale", "Ljava/util/Locale;", "multilanguage_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final I18nLanguage fromCode(String code) {
            String substringBefore$default;
            String substringBefore$default2;
            String str = null;
            if (code != null && (substringBefore$default = StringsKt.substringBefore$default(code, '-', (String) null, 2, (Object) null)) != null && (substringBefore$default2 = StringsKt.substringBefore$default(substringBefore$default, '_', (String) null, 2, (Object) null)) != null) {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                str = substringBefore$default2.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            }
            return Intrinsics.areEqual(str, I18nLanguage.ZH.getCode()) ? I18nLanguage.ZH : Intrinsics.areEqual(str, I18nLanguage.JA.getCode()) ? I18nLanguage.JA : I18nLanguage.EN;
        }

        public final I18nLanguage fromLocale(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            return fromCode(locale.getLanguage());
        }
    }

    public static I18nLanguage valueOf(String str) {
        return (I18nLanguage) Enum.valueOf(I18nLanguage.class, str);
    }

    public static I18nLanguage[] values() {
        return (I18nLanguage[]) $VALUES.clone();
    }
}
