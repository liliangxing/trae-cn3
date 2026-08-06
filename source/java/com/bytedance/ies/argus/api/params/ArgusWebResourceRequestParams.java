package com.bytedance.ies.argus.api.params;

import android.webkit.WebResourceRequest;
import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.ies.argus.util.UrlListVerifyHelper;
import java.net.URI;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* compiled from: ArgusWebResourceRequestParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010'\u001a\u00020\u0002H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestRewritePayload;", "url", "", "request", "Landroid/webkit/WebResourceRequest;", "networkType", "Lcom/bytedance/ies/argus/api/params/ArgusRequestNetworkType;", "(Ljava/lang/String;Landroid/webkit/WebResourceRequest;Lcom/bytedance/ies/argus/api/params/ArgusRequestNetworkType;)V", "canIgnoreVerify", "", "getCanIgnoreVerify$anniex_release", "()Z", "headers", "", "isForMainFrame", "Ljava/lang/Boolean;", "isHighApi", "isInnerHost", "isInnerHost$delegate", "Lkotlin/Lazy;", "isRedirect", "method", "getNetworkType", "()Lcom/bytedance/ies/argus/api/params/ArgusRequestNetworkType;", "type", "getType$anniex_release", "()Ljava/lang/String;", "type$delegate", "urlHost", "getUrlHost$anniex_release", "urlParentHost", "getUrlParentHost$anniex_release", "urlParentHost$delegate", "viewUrl", "getViewUrl$anniex_release", "setViewUrl$anniex_release", "(Ljava/lang/String;)V", "initRewritePayload", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "ttmGetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusWebResourceRequestParams extends BaseAspectParams<ArgusWebResourceRequestRewritePayload> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Integer> IGNORE_RESOURCE_TYPE;
    private static final Map<String, Integer> IGNORE_URL_HOST;
    public static final String RESOURCE_KEY_NAME = "Sec-Fetch-Dest";
    private final Map<String, String> headers;
    private final Boolean isForMainFrame;
    private final boolean isHighApi;

    /* renamed from: isInnerHost$delegate, reason: from kotlin metadata */
    private final Lazy isInnerHost;
    private final Boolean isRedirect;
    private final String method;
    private final ArgusRequestNetworkType networkType;

    /* renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;
    private final String url;
    private final String urlHost;

    /* renamed from: urlParentHost$delegate, reason: from kotlin metadata */
    private final Lazy urlParentHost;
    private String viewUrl;

    public final ArgusRequestNetworkType getNetworkType() {
        return this.networkType;
    }

    public ArgusWebResourceRequestParams(final String str, WebResourceRequest webResourceRequest, ArgusRequestNetworkType argusRequestNetworkType) {
        String str2;
        Object obj;
        Intrinsics.checkNotNullParameter(argusRequestNetworkType, "networkType");
        this.networkType = argusRequestNetworkType;
        this.isHighApi = true;
        if (str == null) {
            str2 = String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        } else {
            str2 = str;
        }
        this.url = str2;
        this.isForMainFrame = webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isForMainFrame()) : null;
        this.isRedirect = webResourceRequest != null ? Boolean.valueOf(webResourceRequest.isRedirect()) : null;
        this.method = webResourceRequest != null ? webResourceRequest.getMethod() : null;
        this.headers = webResourceRequest != null ? webResourceRequest.getRequestHeaders() : null;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(new URI(str).getHost());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        this.urlHost = (String) (Result.isFailure-impl(obj) ? null : obj);
        this.urlParentHost = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams$urlParentHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                String urlHost = ArgusWebResourceRequestParams.this.getUrlHost();
                if (urlHost != null) {
                    return CommonUtils.INSTANCE.getParentHostBaseHost(urlHost);
                }
                return null;
            }
        });
        this.type = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams$type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                Map map;
                map = ArgusWebResourceRequestParams.this.headers;
                if (map != null) {
                    return (String) map.get(ArgusWebResourceRequestParams.RESOURCE_KEY_NAME);
                }
                return null;
            }
        });
        this.isInnerHost = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.ies.argus.api.params.ArgusWebResourceRequestParams$isInnerHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m582invoke() {
                return Boolean.valueOf((str == null || this.getUrlHost() == null) ? false : new UrlListVerifyHelper.InnerDomainVerifier().verify(str, this.getUrlHost(), this.getUrlParentHost$anniex_release()));
            }
        });
    }

    /* renamed from: getViewUrl$anniex_release, reason: from getter */
    public final String getViewUrl() {
        return this.viewUrl;
    }

    public final void setViewUrl$anniex_release(String str) {
        this.viewUrl = str;
    }

    /* renamed from: getUrlHost$anniex_release, reason: from getter */
    public final String getUrlHost() {
        return this.urlHost;
    }

    public final String getUrlParentHost$anniex_release() {
        return (String) this.urlParentHost.getValue();
    }

    public final String getType$anniex_release() {
        return (String) this.type.getValue();
    }

    private final boolean isInnerHost() {
        return ((Boolean) this.isInnerHost.getValue()).booleanValue();
    }

    public final boolean getCanIgnoreVerify$anniex_release() {
        Map<String, Integer> map = IGNORE_RESOURCE_TYPE;
        String type$anniex_release = getType$anniex_release();
        if (map == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        }
        if (map.containsKey(type$anniex_release)) {
            return true;
        }
        String str = this.urlHost;
        return str != null && IGNORE_URL_HOST.containsKey(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public ArgusWebResourceRequestRewritePayload initRewritePayload() {
        return new ArgusWebResourceRequestRewritePayload(null, 1, null);
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject safelyPut = JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(new JSONObject(), "url_host", this.urlHost), "url", this.url), "is_for_main_frame", this.isForMainFrame), "is_redirect", this.isRedirect), "method", this.method), "type", getType$anniex_release());
        Map<String, String> map = this.headers;
        return JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(JSONUtilsKt.safelyPut(safelyPut, "header_keys", map != null ? map.keySet() : null), "network_type", this.networkType.getStr()), "is_inner_host", Boolean.valueOf(isInnerHost())), "view_url", this.viewUrl);
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return JSONUtilsKt.safelyPut(new JSONObject(), "url", this.url);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public Object ttmGetValue(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        switch (key.hashCode()) {
            case -1511175343:
                if (key.equals("is_redirect")) {
                    return this.isRedirect;
                }
                return null;
            case -1166331866:
                if (key.equals("is_inner_host")) {
                    return Boolean.valueOf(isInnerHost());
                }
                return null;
            case -1077554975:
                if (key.equals("method")) {
                    return this.method;
                }
                return null;
            case -970525064:
                if (key.equals("url_host")) {
                    return this.urlHost;
                }
                return null;
            case -19457365:
                if (key.equals("network_type")) {
                    return this.networkType.getStr();
                }
                return null;
            case 116079:
                if (key.equals("url")) {
                    return this.url;
                }
                return null;
            case 3575610:
                if (key.equals("type")) {
                    return getType$anniex_release();
                }
                return null;
            case 154299474:
                if (key.equals("is_for_main_frame")) {
                    return this.isForMainFrame;
                }
                return null;
            case 795307910:
                if (key.equals("headers")) {
                    return this.headers;
                }
                return null;
            case 1196184789:
                if (key.equals("view_url")) {
                    return this.viewUrl;
                }
                return null;
            default:
                return null;
        }
    }

    /* compiled from: ArgusWebResourceRequestParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/api/params/ArgusWebResourceRequestParams$Companion;", "", "()V", "IGNORE_RESOURCE_TYPE", "", "", "", "getIGNORE_RESOURCE_TYPE", "()Ljava/util/Map;", "IGNORE_URL_HOST", "getIGNORE_URL_HOST", "RESOURCE_KEY_NAME", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Integer> getIGNORE_RESOURCE_TYPE() {
            return ArgusWebResourceRequestParams.IGNORE_RESOURCE_TYPE;
        }

        public final Map<String, Integer> getIGNORE_URL_HOST() {
            return ArgusWebResourceRequestParams.IGNORE_URL_HOST;
        }
    }

    static {
        List listOf = CollectionsKt.listOf(new String[]{"audio", "video", "image", "style", "audioworklet", "paintworklet", PreloadConfig.KEY_FONT, "track", "report"});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
        for (Object obj : listOf) {
            linkedHashMap.put(obj, 1);
        }
        IGNORE_RESOURCE_TYPE = linkedHashMap;
        List listOf2 = CollectionsKt.listOf(new String[]{"mcs.snssdk.com", "mon.zijieapi.com"});
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf2, 10)), 16));
        for (Object obj2 : listOf2) {
            linkedHashMap2.put(obj2, 1);
        }
        IGNORE_URL_HOST = linkedHashMap2;
    }
}
