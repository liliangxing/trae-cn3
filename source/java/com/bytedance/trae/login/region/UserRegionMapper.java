package com.bytedance.trae.login.region;

import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelperKt;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRegionMapper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/region/UserRegionMapper;", "", "<init>", "()V", "ttpCountries", "", "", "vaCountries", "regionForStoreCountry", "country", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserRegionMapper {
    public static final UserRegionMapper INSTANCE = new UserRegionMapper();
    private static final Set<String> ttpCountries = SetsKt.setOf((Object[]) new String[]{"AS", "GU", "MP", "PR", "UM", "US", "VI"});
    private static final Set<String> vaCountries = SetsKt.setOf((Object[]) new String[]{"AD", "AG", "AI", "AL", "AR", "AT", "AW", "BA", "BB", "BE", "BG", "BL", "BM", "BO", "BQ", "BR", "BS", "BZ", "CA", "CH", "CL", "CO", "CR", "CW", "CZ", "DE", "DK", "DM", "DO", TeeKeyHelperKt.KEY_PAIR_ALGORITHM, "ES", "FI", "FK", "FO", "FR", "GB", "GD", "GF", "GG", "GI", "GL", "GP", "GR", "GT", "GY", "HN", "HR", "HT", "HU", "IE", "IM", "IS", "IT", "JE", "JM", "KN", "KY", "LC", "LI", "LT", "LU", "LV", "MC", "MD", "ME", "MF", "MK", "MQ", "MS", "MT", "MX", "NI", "NL", "NO", "PA", "PE", "PL", "PM", "PT", "PY", "RO", "RS", "SE", "SI", "SJ", "SK", "SM", "SR", "SV", "SX", "TC", "TT", "UA", "UY", "VA", "VC", "VG", "XK"});

    private UserRegionMapper() {
    }

    public final String regionForStoreCountry(String country) {
        Intrinsics.checkNotNullParameter(country, "country");
        String upperCase = country.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return ttpCountries.contains(upperCase) ? "TTP" : vaCountries.contains(upperCase) ? "VA" : "SG";
    }
}
