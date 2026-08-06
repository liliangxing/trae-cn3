package com.bytedance.trae.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import com.bytedance.keva.Keva;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Locale;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocaleManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/utils/LocaleManager;", "", "<init>", "()V", "LANGUAGE_ZH", "", "LANGUAGE_EN", "LANGUAGE_JA", "REPO_NAME", "KEY_LANGUAGE", "VALUE_NOT_SET", "SUPPORTED_LANGUAGES", "", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "currentLanguage", EventConstants.PARAM_SOURCE_INIT, "", "getCurrentLanguage", "getEffectiveLanguage", "hasUserSelected", "", "setLanguage", "language", "getAppLocale", "Ljava/util/Locale;", "getDefaultCountry", "wrapContext", "Landroid/content/Context;", "base", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LocaleManager {
    private static final String KEY_LANGUAGE = "app_language";
    private static final String REPO_NAME = "trae_locale";
    private static final String VALUE_NOT_SET = "";
    public static final LocaleManager INSTANCE = new LocaleManager();
    public static final String LANGUAGE_ZH = "zh";
    public static final String LANGUAGE_EN = "en";
    public static final String LANGUAGE_JA = "ja";
    private static final Set<String> SUPPORTED_LANGUAGES = SetsKt.setOf(new String[]{LANGUAGE_ZH, LANGUAGE_EN, LANGUAGE_JA});

    /* renamed from: keva$delegate, reason: from kotlin metadata */
    private static final Lazy keva = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.utils.LocaleManager$$ExternalSyntheticLambda0
        public final Object invoke() {
            Keva keva_delegate$lambda$0;
            keva_delegate$lambda$0 = LocaleManager.keva_delegate$lambda$0();
            return keva_delegate$lambda$0;
        }
    });
    private static volatile String currentLanguage = "";

    private LocaleManager() {
    }

    private final Keva getKeva() {
        Object value = keva.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Keva) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Keva keva_delegate$lambda$0() {
        return Keva.getRepo(REPO_NAME, 0);
    }

    public final void init() {
        String string = getKeva().getString(KEY_LANGUAGE, "");
        currentLanguage = string != null ? string : "";
    }

    public final String getCurrentLanguage() {
        return currentLanguage;
    }

    public final String getEffectiveLanguage() {
        String str = currentLanguage;
        if (str.length() == 0) {
            str = INSTANCE.getAppLocale().getLanguage();
            Intrinsics.checkNotNullExpressionValue(str, "getLanguage(...)");
        }
        return str;
    }

    public final boolean hasUserSelected() {
        return currentLanguage.length() > 0;
    }

    public final void setLanguage(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        currentLanguage = language;
        getKeva().storeString(KEY_LANGUAGE, language);
    }

    public final Locale getAppLocale() {
        String defaultCountry;
        Locale sysLocale = AppLocaleUtils.INSTANCE.getSysLocale();
        if (!(currentLanguage.length() > 0)) {
            return SUPPORTED_LANGUAGES.contains(sysLocale.getLanguage()) ? sysLocale : new Locale(LANGUAGE_EN, sysLocale.getCountry());
        }
        if (Intrinsics.areEqual(sysLocale.getLanguage(), currentLanguage)) {
            defaultCountry = sysLocale.getCountry();
        } else {
            defaultCountry = getDefaultCountry(currentLanguage);
        }
        return new Locale(currentLanguage, defaultCountry);
    }

    private final String getDefaultCountry(String language) {
        int hashCode = language.hashCode();
        if (hashCode != 3241) {
            return hashCode != 3383 ? (hashCode == 3886 && language.equals(LANGUAGE_ZH)) ? "CN" : "US" : !language.equals(LANGUAGE_JA) ? "US" : "JP";
        }
        language.equals(LANGUAGE_EN);
        return "US";
    }

    public final Context wrapContext(Context base) {
        Intrinsics.checkNotNullParameter(base, "base");
        Locale appLocale = getAppLocale();
        Locale.setDefault(appLocale);
        Configuration configuration = new Configuration(base.getResources().getConfiguration());
        configuration.setLocale(appLocale);
        LocaleList localeList = new LocaleList(appLocale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        Context createConfigurationContext = base.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(createConfigurationContext, "createConfigurationContext(...)");
        return createConfigurationContext;
    }
}
