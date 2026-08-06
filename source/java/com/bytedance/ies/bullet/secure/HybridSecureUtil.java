package com.bytedance.ies.bullet.secure;

import android.net.Uri;
import com.bytedance.ies.bullet.base.settings.LegacyWebcastConfig;
import com.bytedance.ies.bullet.base.settings.WebConfig;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.common.applog.AppLog;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: HybridSecureUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0010J\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u0006¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/secure/HybridSecureUtil;", "", "()V", "NOT_FOUND", "", "TAG", "", "innerSafeHostMap", "", "getInnerSafeHostMap", "()Ljava/util/Map;", "innerSafeHostMap$delegate", "Lkotlin/Lazy;", "appendCommonParams", "", "uri", "Landroid/net/Uri;", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "isApi", "", "findPortSeparator", "authority", "getActualHost", "getParentDomain", "domain", "inCommonParamsAllowList", "originUrl", "isSafeDomain", "url", "(Ljava/lang/String;)Ljava/lang/Boolean;", "parseHost", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HybridSecureUtil {
    private static final int NOT_FOUND = -1;
    private static final String TAG = "HybridSecureUtil";
    public static final HybridSecureUtil INSTANCE = new HybridSecureUtil();

    /* renamed from: innerSafeHostMap$delegate, reason: from kotlin metadata */
    private static final Lazy innerSafeHostMap = LazyKt.lazy(new Function0<Map<String, ? extends Integer>>() { // from class: com.bytedance.ies.bullet.secure.HybridSecureUtil$innerSafeHostMap$2
        public final Map<String, Integer> invoke() {
            ArrayList arrayListOf = CollectionsKt.arrayListOf(new String[]{"snssdk.com", "toutiao.com", "toutiaoapi.com ", "neihanshequ.com", "youdianyisi.com", "bytedance.com", "bytecdn.cn", "byted.org", "jinritemai.com", "chengzijianzhan.com", "bytedance.net", "amemv.com", "juliangyinqing.com", "huoshan.com", "ixigua.com", "pstatp.com", "xflapp.com", "itoutiaostatic.com", "idouyinstatic.com", "bytescm.com", "bytegecko.com", "bytegoofy.com", "bytetos.com", "goofy.app", "baohuaxia.com", "zijieapi.com", "shidianguji.com", "yilucaifu.com", "doupay.com", "byteimg.com", "open-douyin.com", "searchpstatp.com", "douyin.com", "scsjsd.com", "wasu.tv", "douyinhanyu.com", "fanqiesdk.com", "ugh5.cn", "cluerich.com", "bdxiguastatic.com", "dcarstatic.com", "changdunovel.com", "iaoligame.com", "douyinstatic.com", "toutiaopage.com", "zhuxiaobang.com", "ulikecam.com", "bytednsdoc.com", "xiaohe-jiankang.com", "duoshan.com", "zhilingxingchen.com", "chengzijianzhan.net", "juejin.cn", "obizkey.com", "baike.com", "toutiaoapi.com", "jishitailai.com", "chengzijianzhana.com", "bytesfield.com", "fqnovel.com", "yangyi07.com", "ecombdpage.com", "xingtu.cn", "dcdapp.com", "ugditui.cn", "magich5page.com", "coze.cn", "pipix.com", "draftstatic.com", "xiaohe.cn", "ulpay.com", "retouchpics.com", "oceanengin.com", "byteug.com", "dcarapi.com", "zlinkurl.cn", "hippoaixue.com", "byteky.com", "dailygn.com", "oceanengine.com", "douyinpay.com", "douyinec.com", "xsgtvacct.com", "oceancus.com", "feelgood.cn", "volcanicengine.com", "moonton.com", "activity04.com", "csjdeveloper.com", "fanqienovel.com", "druid.vip", "nextvid.net", "szxinghuoweimang.com", "feishu.cn", "iyincaishijiao.com", "chengzijianzhan.cc", "housengine.com", "editorjianying.com", "iccvlog.com", "life-partner.cn", "lifecreator.cn", "xingfulizhaofang.com", "chengzijianzhan.cn", "chengzijianzhanb.com", "shidianhanyu.com", "toutiao12.com", "lifexue.com", "volcengine.com", "bestv.com.cn", "stellarstock.com", "qishui.com"});
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayListOf, 10)), 16));
            for (Object obj : arrayListOf) {
                linkedHashMap.put(obj, 1);
            }
            return linkedHashMap;
        }
    });

    private HybridSecureUtil() {
    }

    public final Boolean isSafeDomain(String url) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        LegacyWebcastConfig webcastConfig = IConditionCallKt.getHybridSecureConfig().getWebcastConfig();
        if (!(webcastConfig != null && webcastConfig.getEnable())) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(new URI(url).getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str = (String) (Result.isFailure-impl(obj) ? null : obj);
        if (str == null) {
            return false;
        }
        Map plus = MapsKt.plus(getInnerSafeHostMap(), webcastConfig.getDomainWhiteMap());
        if (plus.containsKey(str)) {
            return true;
        }
        String parentDomain = getParentDomain(str);
        return Boolean.valueOf(parentDomain != null && plus.containsKey(parentDomain));
    }

    private final String getParentDomain(String domain) {
        List split$default = StringsKt.split$default(domain, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, (Object) null);
        if (split$default.size() > 2) {
            return CollectionsKt.joinToString$default(CollectionsKt.drop(split$default, 1), LibrarianImpl.Constants.DOT, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return null;
    }

    private final Map<String, Integer> getInnerSafeHostMap() {
        return (Map) innerSafeHostMap.getValue();
    }

    public final boolean inCommonParamsAllowList(Uri originUrl) {
        WebConfig webConfig;
        String cDN$default;
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService == null || (webConfig = (WebConfig) iBulletSettingsService.obtainSettings(WebConfig.class)) == null || !webConfig.getAndroidEnableCommonParamsCheck()) {
            return true;
        }
        List<String> appendCommonParamsHostAllowList = webConfig.getAppendCommonParamsHostAllowList();
        List<String> list = appendCommonParamsHostAllowList;
        if ((list == null || list.isEmpty()) || (cDN$default = ExtKt.getCDN$default(originUrl, null, 1, null)) == null) {
            return true;
        }
        Uri parse = Uri.parse(cDN$default);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        String actualHost = getActualHost(parse);
        if (actualHost == null) {
            return false;
        }
        for (String str : appendCommonParamsHostAllowList) {
            if (StringsKt.startsWith$default(str, LibrarianImpl.Constants.DOT, false, 2, (Object) null)) {
                if (StringsKt.endsWith$default(actualHost, str, false, 2, (Object) null)) {
                    return true;
                }
            } else if (Intrinsics.areEqual(actualHost, str) || StringsKt.endsWith$default(actualHost, LibrarianImpl.Constants.DOT + str, false, 2, (Object) null)) {
                return true;
            }
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, TAG, "host " + actualHost + " not in append common params allow list, origin url is " + originUrl, null, null, 12, null);
        return false;
    }

    public final void appendCommonParams(Uri uri, StringBuilder sb, boolean isApi) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(sb, "sb");
        if (inCommonParamsAllowList(uri)) {
            AppLog.appendCommonParams(sb, isApi);
        }
    }

    public final String getActualHost(Uri uri) {
        String encodedAuthority;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri parse = uri.isHierarchical() ? Uri.parse(uri.toString()) : uri;
        String host = parse.getHost();
        if (host == null || (encodedAuthority = parse.getEncodedAuthority()) == null) {
            return null;
        }
        String str = encodedAuthority;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            if (str.charAt(i) == '@') {
                i2++;
            }
            i++;
        }
        if (i2 <= 1 || (host = parseHost(uri)) != null) {
            return StringsKt.contains$default(host, '\\', false, 2, (Object) null) ? StringsKt.substringBefore$default(host, '\\', (String) null, 2, (Object) null) : host;
        }
        return null;
    }

    private final String parseHost(Uri uri) {
        String substring;
        String encodedAuthority = uri.getEncodedAuthority();
        if (encodedAuthority == null) {
            return null;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(encodedAuthority, '@', 0, false, 6, (Object) null);
        int findPortSeparator = findPortSeparator(encodedAuthority);
        if (findPortSeparator == -1) {
            substring = encodedAuthority.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        } else {
            substring = encodedAuthority.substring(lastIndexOf$default + 1, findPortSeparator);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        return Uri.decode(substring);
    }

    private final int findPortSeparator(String authority) {
        if (authority == null) {
            return -1;
        }
        for (int length = authority.length() - 1; -1 < length; length--) {
            char charAt = authority.charAt(length);
            if (':' == charAt) {
                return length;
            }
            if (charAt < '0' || charAt > '9') {
                break;
            }
        }
        return -1;
    }
}
