package com.bytedance.android.anniex.utils;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: UrlExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\t"}, d2 = {"getIdentifierUrl", "", "Landroid/net/Uri;", "getIsEnablePrefetch", "", "getLynxSSRRequestUrl", "bid", "sessionId", "getSubUrl", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class UrlExtKt {
    public static final String getSubUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), ProxyConfig.MATCH_HTTPS)) {
            return uri.toString();
        }
        String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "a_surl");
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "surl");
        return safeGetQueryParameter2 == null ? ExtKt.safeGetQueryParameter(uri, StreamTrafficObservable.STREAM_URL) : safeGetQueryParameter2;
    }

    public static /* synthetic */ String getLynxSSRRequestUrl$default(Uri uri, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getLynxSSRRequestUrl(uri, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:6:0x0027, B:8:0x003f, B:10:0x0047, B:16:0x0059, B:17:0x006f, B:19:0x0074, B:24:0x0080, B:26:0x0088, B:31:0x009a, B:33:0x00ab, B:36:0x00b7, B:38:0x00c1, B:39:0x00cf), top: B:5:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String getLynxSSRRequestUrl(Uri uri, String str, String str2) {
        Object obj;
        List<String> list;
        List<String> list2;
        boolean z;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "ssr_url");
        if (safeGetQueryParameter == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(safeGetQueryParameter);
            Uri.Builder buildUpon = parse.buildUpon();
            Intrinsics.checkNotNullExpressionValue(parse, "ssrUri");
            boolean z2 = true;
            if (ExtKt.safeGetQueryParameter(parse, "appended_global_props") == null) {
                String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "append_global_props");
                if (safeGetQueryParameter2 != null) {
                    if (!(safeGetQueryParameter2.length() > 0)) {
                        safeGetQueryParameter2 = null;
                    }
                    if (safeGetQueryParameter2 != null) {
                        list = StringsKt.split$default(safeGetQueryParameter2, new String[]{","}, false, 0, 6, (Object) null);
                        list2 = list;
                        if (list2 != null && !list2.isEmpty()) {
                            z = false;
                            if (!z && HybridSecureUtil.INSTANCE.inCommonParamsAllowList(parse)) {
                                buildUpon.appendQueryParameter("appended_global_props", new JSONObject(GlobalPropsHelper.INSTANCE.getStaticGlobalPropsForAppend(uri, str, str2, list)).toString());
                            }
                        }
                        z = true;
                        if (!z) {
                            buildUpon.appendQueryParameter("appended_global_props", new JSONObject(GlobalPropsHelper.INSTANCE.getStaticGlobalPropsForAppend(uri, str, str2, list)).toString());
                        }
                    }
                }
                list = null;
                list2 = list;
                if (list2 != null) {
                    z = false;
                    if (!z) {
                    }
                }
                z = true;
                if (!z) {
                }
            }
            buildUpon.appendQueryParameter("disable_offline", DiskLruCache.VERSION);
            if (Intrinsics.areEqual(ExtKt.safeGetQueryParameter(parse, "append_common_params"), "0") || !Intrinsics.areEqual(ExtKt.safeGetQueryParameter(uri, "append_common_params"), DiskLruCache.VERSION)) {
                z2 = false;
            }
            String uri2 = buildUpon.build().toString();
            if (z2) {
                StringBuilder sb = new StringBuilder(uri2);
                HybridSecureUtil.INSTANCE.appendCommonParams(parse, sb, false);
                uri2 = sb.toString();
            }
            obj = Result.constructor-impl(uri2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str3 = (String) (Result.isFailure-impl(obj) ? null : obj);
        return str3 == null ? safeGetQueryParameter : str3;
    }

    public static final String getIdentifierUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String subUrl = getSubUrl(uri);
        if (subUrl == null) {
            subUrl = "";
        }
        String str = subUrl;
        if (str.length() == 0) {
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "channel");
            String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "bundle");
            String str2 = safeGetQueryParameter;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = safeGetQueryParameter2;
                if (!(str3 == null || str3.length() == 0)) {
                    return safeGetQueryParameter + '_' + safeGetQueryParameter2;
                }
            }
            if (!(str.length() == 0)) {
                return subUrl;
            }
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "this.toString()");
            return uri2;
        }
        String builder = Uri.parse(subUrl).buildUpon().clearQuery().toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(result).buildUpon().clearQuery().toString()");
        return builder;
    }

    public static final boolean getIsEnablePrefetch(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return StringsKt.equals$default(ExtKt.safeGetQueryParameter(uri, "enable_prefetch"), DiskLruCache.VERSION, false, 2, (Object) null);
    }
}
