package com.bytedance.forest.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.DynamicType;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.URIQueryParamKeys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UriParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u0018\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t*\u00020\u0007\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0007H\u0000\u001a\f\u0010\u000e\u001a\u00020\r*\u00020\u0001H\u0000\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"BOE_ENABLE", "", "ENV_LANE", "PPE_ENABLE", "appendExtraPart", "Landroid/net/Uri$Builder;", "sourceUri", "Landroid/net/Uri;", "getEnvParameters", "", "getGeckoBundle", "getGeckoChannel", "isHttpProtocol", "", "isHttpUrl", "parseUriParams", "", "Lcom/bytedance/forest/model/Request;", "safeGetQueryParameter", Api.KEY_ENCRYPT_RESP_KEY, "withoutQueries", "forest_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UriParserKt {
    public static final String BOE_ENABLE = "x-use-boe";
    public static final String ENV_LANE = "x-tt-env";
    public static final String PPE_ENABLE = "x-use-ppe";

    public static final Map<String, String> getEnvParameters(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$getEnvParameters");
        String[] strArr = {PPE_ENABLE, BOE_ENABLE, ENV_LANE};
        ArrayList arrayList = new ArrayList(3);
        for (int i = 0; i < 3; i++) {
            String str = strArr[i];
            arrayList.add(TuplesKt.to(str, safeGetQueryParameter(uri, str)));
        }
        Map map = MapsKt.toMap(arrayList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final String safeGetQueryParameter(Uri uri, String str) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$safeGetQueryParameter");
        Intrinsics.checkParameterIsNotNull(str, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            return uri.getQueryParameter(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ Uri.Builder appendExtraPart$default(Uri.Builder builder, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = null;
        }
        return appendExtraPart(builder, uri);
    }

    public static final Uri.Builder appendExtraPart(Uri.Builder builder, Uri uri) {
        Intrinsics.checkParameterIsNotNull(builder, "$this$appendExtraPart");
        if (uri != null) {
            builder.encodedQuery(uri.getEncodedQuery());
        }
        return builder;
    }

    public static final void parseUriParams(Request request) {
        Boolean valueOf;
        Integer intOrNull;
        Intrinsics.checkParameterIsNotNull(request, "$this$parseUriParams");
        Uri originUri = request.getOriginUri();
        String safeGetQueryParameter = safeGetQueryParameter(originUri, URIQueryParamKeys.ONLY_ONLINE);
        if (safeGetQueryParameter != null) {
            request.setOnlyOnline(Intrinsics.areEqual(safeGetQueryParameter, "1"));
        }
        if (request.getGeckoSource() != GeckoSource.REMOTE_SETTING) {
            String safeGetQueryParameter2 = safeGetQueryParameter(originUri, URIQueryParamKeys.WAIT_GECKO_UPDATE);
            if (safeGetQueryParameter2 != null) {
                valueOf = Boolean.valueOf(Intrinsics.areEqual(safeGetQueryParameter2, "1"));
            } else {
                String safeGetQueryParameter3 = safeGetQueryParameter(originUri, URIQueryParamKeys.DYNAMIC);
                valueOf = (safeGetQueryParameter3 == null || (intOrNull = StringsKt.toIntOrNull(safeGetQueryParameter3)) == null) ? null : Boolean.valueOf(DynamicType.INSTANCE.asWaitGeckoUpdate(intOrNull.intValue()));
            }
            request.setWaitGeckoUpdate(valueOf != null ? valueOf.booleanValue() : request.getWaitGeckoUpdate());
        }
    }

    public static final String getGeckoBundle(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$getGeckoBundle");
        String safeGetQueryParameter = safeGetQueryParameter(uri, URIQueryParamKeys.KEY_BUNDLE);
        return safeGetQueryParameter != null ? safeGetQueryParameter : safeGetQueryParameter(uri, "bundle");
    }

    public static final String getGeckoChannel(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$getGeckoChannel");
        String safeGetQueryParameter = safeGetQueryParameter(uri, URIQueryParamKeys.KEY_CHANNEL);
        return safeGetQueryParameter != null ? safeGetQueryParameter : safeGetQueryParameter(uri, "channel");
    }

    public static final String withoutQueries(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$withoutQueries");
        Integer valueOf = Integer.valueOf(StringsKt.indexOf$default(str, "?", 0, false, 6, (Object) null));
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return str;
        }
        String substring = str.substring(0, valueOf.intValue());
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring != null ? substring : str;
    }

    public static final boolean isHttpProtocol(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$isHttpProtocol");
        return Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https");
    }

    public static final boolean isHttpUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$isHttpUrl");
        return StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null);
    }
}
