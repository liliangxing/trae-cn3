package com.bytedance.trae.utils;

import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.TelephonyManager;
import com.bytedance.trae.common.apphost.AppHost;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppLocaleUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/utils/AppLocaleUtils;", "", "<init>", "()V", "isMIUIBuild", "", "getSysLocale", "Ljava/util/Locale;", "getLocaleFromMIUIIBuild", "getAppLocale", "carrierRegion", "", "getCarrierRegion", "getTimeZone", "Ljava/util/TimeZone;", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AppLocaleUtils {
    private static String carrierRegion;
    public static final AppLocaleUtils INSTANCE = new AppLocaleUtils();
    private static final boolean isMIUIBuild = StringsKt.equals(Build.BRAND, "Xiaomi", true);

    private AppLocaleUtils() {
    }

    public final Locale getSysLocale() {
        Locale locale;
        if (isMIUIBuild) {
            return getLocaleFromMIUIIBuild();
        }
        LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
        Intrinsics.checkNotNullExpressionValue(locales, "getLocales(...)");
        if (locales.isEmpty()) {
            locale = Locale.getDefault();
        } else {
            locale = locales.get(0);
        }
        Intrinsics.checkNotNull(locale);
        return locale;
    }

    private final Locale getLocaleFromMIUIIBuild() {
        String country;
        try {
            Method declaredMethod = Class.forName("miui.os.Build").getDeclaredMethod("getRegion", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "getDeclaredMethod(...)");
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            country = (String) invoke;
        } catch (Exception unused) {
            country = Locale.getDefault().getCountry();
        }
        return new Locale(Locale.getDefault().getLanguage(), country);
    }

    public final Locale getAppLocale() {
        return LocaleManager.INSTANCE.getAppLocale();
    }

    public final String getCarrierRegion() {
        String simCountryIso;
        String str = carrierRegion;
        if (str == null) {
            str = null;
            try {
                Object systemService = AppHost.INSTANCE.getApplication().getSystemService("phone");
                TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
                if (telephonyManager != null && (simCountryIso = telephonyManager.getSimCountryIso()) != null) {
                    if (!StringsKt.isBlank(simCountryIso)) {
                        str = simCountryIso;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            carrierRegion = str;
        }
        return str;
    }

    public final TimeZone getTimeZone() {
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(...)");
        return timeZone;
    }
}
