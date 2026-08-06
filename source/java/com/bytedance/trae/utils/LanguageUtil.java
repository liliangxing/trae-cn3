package com.bytedance.trae.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageUtil.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/utils/LanguageUtil;", "", "<init>", "()V", "currentSysLanguage", "", "getLanguageForCommonParameters", "language", "convert2OldISOCodes", "convert2StarlingLanguage", "isTraditionalChinese", "", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LanguageUtil {
    public static final LanguageUtil INSTANCE = new LanguageUtil();
    private static final String currentSysLanguage;

    private LanguageUtil() {
    }

    static {
        String language = AppLocaleUtils.INSTANCE.getSysLocale().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        currentSysLanguage = language;
    }

    public final String getLanguageForCommonParameters() {
        return convert2StarlingLanguage(convert2OldISOCodes());
    }

    public final String getLanguageForCommonParameters(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return convert2StarlingLanguage(convert2OldISOCodes(language));
    }

    private final String convert2OldISOCodes() {
        String str = currentSysLanguage;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return convert2OldISOCodes(lowerCase);
    }

    private final String convert2OldISOCodes(String language) {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = language.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase == "iw" ? "he" : lowerCase == "ji" ? "yi" : lowerCase == "in" ? "id" : lowerCase;
    }

    private final String convert2StarlingLanguage(String language) {
        return language == "th" ? "th-TH" : language == "ms" ? "ms-MY" : isTraditionalChinese() ? "zh-Hant" : language;
    }

    private final boolean isTraditionalChinese() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String script = locale.getScript();
        if (script == null) {
            script = "";
        }
        String country = locale.getCountry();
        if (script.length() == 0) {
            if (language.equals(LocaleManager.LANGUAGE_ZH) && (country.equals("TW") || country.equals("HK"))) {
                return true;
            }
        } else if (language.equals(LocaleManager.LANGUAGE_ZH) && script.equals("Hant")) {
            return true;
        }
        return false;
    }
}
