package com.bytedance.ies.argus.util;

import android.app.Application;
import android.net.Uri;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.ForceHttpsSetting;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ttnet.config.AppConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ForceHttpsUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\n\u0010\r\u001a\u00020\u0005*\u00020\u0005R#\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/util/ForceHttpsUtil;", "", "()V", "shareCookieDomainList", "", "", "getShareCookieDomainList", "()Ljava/util/List;", "shareCookieDomainList$delegate", "Lkotlin/Lazy;", "shouldForceHttps", "", "url", "forceToHttps", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForceHttpsUtil {
    public static final ForceHttpsUtil INSTANCE = new ForceHttpsUtil();

    /* renamed from: shareCookieDomainList$delegate, reason: from kotlin metadata */
    private static final Lazy shareCookieDomainList = LazyKt.lazy(new Function0<List<String>>() { // from class: com.bytedance.ies.argus.util.ForceHttpsUtil$shareCookieDomainList$2
        public final List<String> invoke() {
            Application application = ArgusEnv.INSTANCE.getInstance().getApplication();
            if (application != null) {
                return AppConfig.getInstance(application).getShareCookieHostList();
            }
            return null;
        }
    });

    private ForceHttpsUtil() {
    }

    private final List<String> getShareCookieDomainList() {
        return (List) shareCookieDomainList.getValue();
    }

    private final boolean shouldForceHttps(String url) {
        List<String> shareCookieDomainList2;
        ArgusGlobalCommonConfig argusSecuritySettingConfig = ArgusConfigManager.INSTANCE.getInstance().getArgusSecuritySettingConfig();
        ForceHttpsSetting forceHttpsSetting = argusSecuritySettingConfig != null ? argusSecuritySettingConfig.getForceHttpsSetting() : null;
        if (forceHttpsSetting != null && forceHttpsSetting.getEnable()) {
            Uri parse = Uri.parse(url);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
            String host = parse.getHost();
            if (host == null) {
                return false;
            }
            if (forceHttpsSetting.getEnableShareCookieDomainForceHttps() && (shareCookieDomainList2 = getShareCookieDomainList()) != null && CommonUtils.INSTANCE.matchPlainHostList(host, shareCookieDomainList2)) {
                return true;
            }
            List<String> forceHttpsHostList = forceHttpsSetting.getForceHttpsHostList();
            if (forceHttpsHostList == null) {
                forceHttpsHostList = CollectionsKt.emptyList();
            }
            if (CommonUtils.INSTANCE.matchPlainHostList(host, forceHttpsHostList)) {
                return true;
            }
        }
        return false;
    }

    public final String forceToHttps(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return (StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && shouldForceHttps(str)) ? StringsKt.replaceFirst$default(str, "http://", "https://", false, 4, (Object) null) : str;
    }
}
