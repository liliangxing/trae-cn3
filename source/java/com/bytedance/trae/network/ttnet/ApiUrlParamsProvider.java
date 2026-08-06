package com.bytedance.trae.network.ttnet;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.Level;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.bytedance.trae.utils.LocaleManager;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApiUrlParamsProvider.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;", "", "<init>", "()V", "getCommonQueryParams", "Ljava/util/HashMap;", "", "level", "", "getRomInfo", "getLanguageForCommonParameters", "language", "convert2OldISOCodes", "convert2StarlingLanguage", "isTraditionalChinese", "", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApiUrlParamsProvider {
    public static final ApiUrlParamsProvider INSTANCE = new ApiUrlParamsProvider();

    private ApiUrlParamsProvider() {
    }

    public final HashMap<String, String> getCommonQueryParams(int level) {
        HashMap<String, String> hashMap = new HashMap<>();
        Locale appLocale = AppLocaleUtils.INSTANCE.getAppLocale();
        String carrierRegion = AppLocaleUtils.INSTANCE.getCarrierRegion();
        hashMap.put("region", appLocale.getCountry());
        hashMap.put("sys_region", AppLocaleUtils.INSTANCE.getSysLocale().getCountry());
        ApiUrlParamsProvider apiUrlParamsProvider = INSTANCE;
        String language = appLocale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        hashMap.put("lang", apiUrlParamsProvider.getLanguageForCommonParameters(language));
        if (carrierRegion != null) {
            hashMap.put("carrier_region", carrierRegion);
        }
        hashMap.put("tz_name", AppLocaleUtils.INSTANCE.getTimeZone().getID());
        String language2 = appLocale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language2, "getLanguage(...)");
        NetUtil.addCustomParamsWithLevel("language", apiUrlParamsProvider.getLanguageForCommonParameters(language2), Level.L1);
        return hashMap;
    }

    private final String getRomInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            if (ToolUtils.isMiui()) {
                sb.append("MIUI-");
            } else if (ToolUtils.isFlyme()) {
                sb.append("FLYME-");
            } else {
                String emuiInfo = ToolUtils.getEmuiInfo();
                if (RomUtils.isHwOrHonor(emuiInfo)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(emuiInfo)) {
                    sb.append(emuiInfo).append("-");
                }
                Unit unit = Unit.INSTANCE;
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return sb2;
            }
        } catch (Throwable unused) {
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        return sb3;
    }

    public final String getLanguageForCommonParameters(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return convert2StarlingLanguage(convert2OldISOCodes(language));
    }

    private final String convert2OldISOCodes(String language) {
        String lowerCase = language.toLowerCase();
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
        String country = locale.getCountry();
        String str = script;
        if (str == null || str.length() == 0) {
            if (!language.equals(LocaleManager.LANGUAGE_ZH)) {
                return false;
            }
            if (!country.equals("TW") && !country.equals("HK")) {
                return false;
            }
        } else if (!language.equals(LocaleManager.LANGUAGE_ZH) || !script.equals("Hant")) {
            return false;
        }
        return true;
    }
}
