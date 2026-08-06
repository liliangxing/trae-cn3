package com.bytedance.upc.common.utils;

import android.content.res.Resources;
import android.os.Build;
import com.bytedance.upc.BuildConfig;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0003J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\b\u0010\u0013\u001a\u00020\tH\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/upc/common/utils/DeviceUtils;", "", "()V", "getBrand", "", "getCountry", "getLanguage", "getModel", "getOsApi", "", "getOsVersion", "getProduct", "getRegion", "getRom", "getSystemProperty", "key", "defaultValue", "getSystemVersion", "getTzName", "getTzOffset", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();

    private DeviceUtils() {
    }

    @JvmStatic
    public static final String getBrand() {
        String str = Build.BRAND;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.BRAND");
        return str;
    }

    @JvmStatic
    public static final String getRom() {
        String str = Build.DISPLAY;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.DISPLAY");
        return str;
    }

    @JvmStatic
    public static final String getModel() {
        String str = Build.MODEL;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.MODEL");
        return str;
    }

    @JvmStatic
    public static final String getProduct() {
        String str = Build.PRODUCT;
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.PRODUCT");
        return str;
    }

    @JvmStatic
    public static final String getOsVersion() {
        String ov = Build.VERSION.RELEASE;
        if (ov != null && ov.length() > 10) {
            ov = ov.substring(0, 10);
            Intrinsics.checkExpressionValueIsNotNull(ov, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        Intrinsics.checkExpressionValueIsNotNull(ov, "ov");
        return ov;
    }

    @JvmStatic
    public static final int getOsApi() {
        return Build.VERSION.SDK_INT;
    }

    @JvmStatic
    public static final String getCountry() {
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        Locale locale = system.getConfiguration().locale;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Resources.getSystem().configuration.locale");
        String country = locale.getCountry();
        Intrinsics.checkExpressionValueIsNotNull(country, "Resources.getSystem().configuration.locale.country");
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ROOT");
        if (country == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = country.toUpperCase(locale2);
        Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @JvmStatic
    public static final String getRegion() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
        String country = locale.getCountry();
        Intrinsics.checkExpressionValueIsNotNull(country, "Locale.getDefault().country");
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ROOT");
        if (country == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = country.toLowerCase(locale2);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @JvmStatic
    public static final String getLanguage() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
        String language = locale.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Locale.getDefault().language");
        return language;
    }

    @JvmStatic
    public static final String getTzName() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance()");
        TimeZone timeZone = calendar.getTimeZone();
        Intrinsics.checkExpressionValueIsNotNull(timeZone, "timeZone");
        String id = timeZone.getID();
        Intrinsics.checkExpressionValueIsNotNull(id, "timeZone.id");
        return id;
    }

    @JvmStatic
    public static final int getTzOffset() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(calendar, "Calendar.getInstance()");
        return calendar.getTimeZone().getOffset(System.currentTimeMillis()) / 1000;
    }

    @JvmStatic
    public static final String getSystemVersion() {
        return getSystemProperty("ro.pvr.internal.version", "");
    }

    @JvmStatic
    private static final String getSystemProperty(String key, String defaultValue) {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class);
            Intrinsics.checkExpressionValueIsNotNull(method, "systemProperties.getMeth…:class.java\n            )");
            Object invoke = method.invoke(null, key, defaultValue);
            if (invoke != null) {
                return (String) invoke;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return defaultValue;
        }
    }
}
