package com.bytedance.ies.bullet.prefetchv2;

import android.app.Application;
import android.net.Uri;
import bolts.Task;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.prefetchv2.INetworkExecutor;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.network.AbsStreamConnection;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IStreamResponseCallback;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import com.bytedance.trae.network.FrontierIdGenerator;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: PrefetchRequest.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0001@BW\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB«\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013JA\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0002\b0JW\u00101\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0000¢\u0006\u0002\b2J\u0006\u00103\u001a\u00020\u0003J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0007J\u000e\u0010:\u001a\u0002052\u0006\u00108\u001a\u00020;J<\u0010<\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030=2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u00108\u001a\u00020;H\u0002J4\u0010>\u001a\u0002052\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030=2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0002J(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006*\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006H\u0002R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010&R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010&\"\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u000e\u0010,\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001a¨\u0006A"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "", "url", "", "method", "headers", "", "params", "body", "Lorg/json/JSONObject;", "needCommonParams", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lorg/json/JSONObject;Z)V", "extraHeaders", "extraParams", "isCustomizedCookie", "isStreamLoadType", "appendGlobalProps", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lorg/json/JSONObject;ZLjava/util/Map;Ljava/util/Map;ZZLjava/util/List;)V", "getAppendGlobalProps", "()Ljava/util/List;", "setAppendGlobalProps", "(Ljava/util/List;)V", "bid", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "getBody", "()Lorg/json/JSONObject;", "configFrom", "getConfigFrom", "setConfigFrom", "getExtraHeaders", "()Ljava/util/Map;", "getExtraParams", "getHeaders", "()Z", "setStreamLoadType", "(Z)V", "getMethod", "getNeedCommonParams", "getParams", "requestKey", "getUrl", "createApiUrl", "baseUrl", "createApiUrl$anniex_release", "createApiUrlWithGlobalProps", "createApiUrlWithGlobalProps$anniex_release", "getUniqueKey", "perform", "", "executor", "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor;", "callback", "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$Callback;", "performStream", "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$StreamCallback;", "performStreamRequest", "", "performWithCustomizedCookie", "keyToLowerCase", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<String> appendGlobalProps;
    private String bid;
    private final JSONObject body;
    private String configFrom;
    private final Map<String, String> extraHeaders;
    private final Map<String, String> extraParams;
    private final Map<String, String> headers;
    private final boolean isCustomizedCookie;
    private boolean isStreamLoadType;
    private final String method;
    private final boolean needCommonParams;
    private final Map<String, String> params;
    private String requestKey;
    private final String url;

    public PrefetchRequest(String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, boolean z, Map<String, String> map3, Map<String, String> map4, boolean z2, boolean z3, List<String> list) {
        Map<String, String> stringMap;
        Map<String, String> keyToLowerCase;
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "method");
        this.url = str;
        this.method = str2;
        this.headers = map;
        this.params = map2;
        this.body = jSONObject;
        this.needCommonParams = z;
        this.extraHeaders = map3;
        this.extraParams = map4;
        this.isCustomizedCookie = z2;
        this.isStreamLoadType = z3;
        this.appendGlobalProps = list;
        this.configFrom = "unknown";
        this.bid = "default_bid";
        String str3 = null;
        String sortedMap = (map == null || (keyToLowerCase = keyToLowerCase(map)) == null) ? null : MapsKt.toSortedMap(keyToLowerCase);
        String sortedMap2 = map2 != null ? MapsKt.toSortedMap(map2) : null;
        if (jSONObject != null && (stringMap = PrefetchConfigKt.toStringMap(jSONObject)) != null) {
            str3 = MapsKt.toSortedMap(stringMap);
        }
        StringBuilder append = new StringBuilder().append(str).append(StringListParam.SPLIT_DELIMITER);
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.requestKey = append.append(lowerCase).append(StringListParam.SPLIT_DELIMITER).append(sortedMap == null ? "{}" : sortedMap).append(StringListParam.SPLIT_DELIMITER).append(sortedMap2 == null ? "{}" : sortedMap2).append(StringListParam.SPLIT_DELIMITER).append(str3 == null ? "{}" : str3).append(StringListParam.SPLIT_DELIMITER).append(z).append(", ").append(z2).append(", ").append(this.isStreamLoadType).toString();
    }

    public /* synthetic */ PrefetchRequest(String str, String str2, Map map, Map map2, JSONObject jSONObject, boolean z, Map map3, Map map4, boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, map2, jSONObject, (i & 32) != 0 ? true : z, (i & 64) != 0 ? null : map3, (i & 128) != 0 ? null : map4, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? null : list);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final JSONObject getBody() {
        return this.body;
    }

    public final boolean getNeedCommonParams() {
        return this.needCommonParams;
    }

    public final Map<String, String> getExtraHeaders() {
        return this.extraHeaders;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    /* renamed from: isCustomizedCookie, reason: from getter */
    public final boolean getIsCustomizedCookie() {
        return this.isCustomizedCookie;
    }

    /* renamed from: isStreamLoadType, reason: from getter */
    public final boolean getIsStreamLoadType() {
        return this.isStreamLoadType;
    }

    public final void setStreamLoadType(boolean z) {
        this.isStreamLoadType = z;
    }

    public final List<String> getAppendGlobalProps() {
        return this.appendGlobalProps;
    }

    public final void setAppendGlobalProps(List<String> list) {
        this.appendGlobalProps = list;
    }

    public final String getConfigFrom() {
        return this.configFrom;
    }

    public final void setConfigFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.configFrom = str;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public /* synthetic */ PrefetchRequest(String str, String str2, Map map, Map map2, JSONObject jSONObject, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, map2, jSONObject, (i & 32) != 0 ? true : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PrefetchRequest(String str, String str2, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject, boolean z) {
        this(str, str2, map, map2, jSONObject, z, null, null, false, false, null, 1536, null);
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "method");
    }

    private final Map<String, String> keyToLowerCase(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = key.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            linkedHashMap.put(lowerCase, entry.getValue());
        }
        return linkedHashMap;
    }

    public final void perform(INetworkExecutor executor, INetworkExecutor.Callback callback) {
        String createApiUrlWithGlobalProps$anniex_release;
        String str;
        CommonConfig commonConfig;
        Boolean enablePrefetchNetworkParams;
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.appendGlobalProps == null) {
            createApiUrlWithGlobalProps$anniex_release = createApiUrl$anniex_release(this.url, this.params, this.extraParams);
        } else {
            String str2 = this.url;
            Map<String, String> map = this.params;
            Map<String, String> map2 = this.extraParams;
            GlobalPropsHelper globalPropsHelper = GlobalPropsHelper.INSTANCE;
            String str3 = this.bid;
            List<String> list = this.appendGlobalProps;
            Uri parse = Uri.parse(this.url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            createApiUrlWithGlobalProps$anniex_release = createApiUrlWithGlobalProps$anniex_release(str2, map, map2, globalPropsHelper.getGlobalPropsForAppend(str3, list, parse));
        }
        String str4 = createApiUrlWithGlobalProps$anniex_release;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map3 = this.headers;
        if (map3 != null) {
            linkedHashMap.putAll(map3);
        }
        Map<String, String> map4 = this.extraHeaders;
        if (map4 != null) {
            linkedHashMap.putAll(map4);
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if ((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePrefetchNetworkParams = commonConfig.getEnablePrefetchNetworkParams()) == null) ? true : enablePrefetchNetworkParams.booleanValue()) {
            linkedHashMap.put("Anniex-Prefetch", "1");
        }
        if (this.isCustomizedCookie) {
            performWithCustomizedCookie(str4, linkedHashMap, this.needCommonParams, callback);
            return;
        }
        String str5 = this.method;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (str5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str5.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, PrefetchRequestConfig.METHOD_GET)) {
            executor.get(str4, linkedHashMap, this.needCommonParams, null, callback);
            return;
        }
        String str6 = this.method;
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        if (str6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str6.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase2, PrefetchRequestConfig.METHOD_POST)) {
            Map<String, String> map5 = this.headers;
            if (map5 == null || (str = map5.get(XBridgeAPIRequestUtils.CONTENT_TYPE)) == null) {
                str = "application/x-www-form-urlencoded";
            }
            String str7 = str;
            JSONObject jSONObject = this.body;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            executor.post(str4, linkedHashMap, str7, jSONObject, this.needCommonParams, null, callback);
        }
    }

    public final void performStream(final INetworkExecutor.StreamCallback callback) {
        final String createApiUrlWithGlobalProps$anniex_release;
        CommonConfig commonConfig;
        Boolean enablePrefetchNetworkParams;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.appendGlobalProps == null) {
            createApiUrlWithGlobalProps$anniex_release = createApiUrl$anniex_release(this.url, this.params, this.extraParams);
        } else {
            String str = this.url;
            Map<String, String> map = this.params;
            Map<String, String> map2 = this.extraParams;
            GlobalPropsHelper globalPropsHelper = GlobalPropsHelper.INSTANCE;
            String str2 = this.bid;
            List<String> list = this.appendGlobalProps;
            Uri parse = Uri.parse(this.url);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
            createApiUrlWithGlobalProps$anniex_release = createApiUrlWithGlobalProps$anniex_release(str, map, map2, globalPropsHelper.getGlobalPropsForAppend(str2, list, parse));
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map3 = this.headers;
        if (map3 != null) {
            linkedHashMap.putAll(map3);
        }
        Map<String, String> map4 = this.extraHeaders;
        if (map4 != null) {
            linkedHashMap.putAll(map4);
        }
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if ((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null || (enablePrefetchNetworkParams = commonConfig.getEnablePrefetchNetworkParams()) == null) ? true : enablePrefetchNetworkParams.booleanValue()) {
            linkedHashMap.put("Anniex-Prefetch", "1");
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchRequest$performStream$3
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                PrefetchRequest prefetchRequest = PrefetchRequest.this;
                prefetchRequest.performStreamRequest(createApiUrlWithGlobalProps$anniex_release, linkedHashMap, prefetchRequest.getNeedCommonParams(), PrefetchRequest.this.getIsCustomizedCookie(), callback);
            }
        });
    }

    private final void performWithCustomizedCookie(String url, Map<String, String> headers, boolean needCommonParams, final INetworkExecutor.Callback callback) {
        IHostNetworkDepend pureNetworkDependInstance;
        String str;
        if (RuntimeHelper.INSTANCE.getNetworkDependInstanceV2((IBDXBridgeContext) null) != null) {
            IHostNetworkDependV2 networkDependInstanceV2 = RuntimeHelper.INSTANCE.getNetworkDependInstanceV2((IBDXBridgeContext) null);
            Intrinsics.checkNotNull(networkDependInstanceV2);
            pureNetworkDependInstance = (IHostNetworkDepend) networkDependInstanceV2;
        } else if (needCommonParams) {
            pureNetworkDependInstance = RuntimeHelper.INSTANCE.getNetworkDependInstance((IBDXBridgeContext) null);
        } else {
            pureNetworkDependInstance = RuntimeHelper.INSTANCE.getPureNetworkDependInstance((IBDXBridgeContext) null);
        }
        IHostNetworkDepend iHostNetworkDepend = pureNetworkDependInstance;
        IResponseCallback iResponseCallback = new IResponseCallback() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchRequest$performWithCustomizedCookie$responseCallback$1
            public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                Intrinsics.checkNotNullParameter(body, "body");
                Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                INetworkExecutor.HttpResponse httpResponse = new INetworkExecutor.HttpResponse();
                String jSONObject = body.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "body.toString()");
                Charset charset = Charsets.UTF_8;
                if (jSONObject == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                byte[] bytes = jSONObject.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                httpResponse.setBody(bytes);
                httpResponse.setHeaderMap(responseHeader);
                httpResponse.setStatusCode(statusCode != null ? statusCode.intValue() : -1);
                INetworkExecutor.Callback.this.onRequestSucceed(httpResponse);
            }

            public Unit onParsingFailed(JSONObject body, LinkedHashMap<String, String> responseHeader, String rawResponse, Throwable throwable, Integer statusCode, int clientCode) {
                Intrinsics.checkNotNullParameter(body, "body");
                Intrinsics.checkNotNullParameter(responseHeader, "responseHeader");
                Intrinsics.checkNotNullParameter(rawResponse, "rawResponse");
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                jSONObject.put("_raw", rawResponse);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errCode", XBridgeAPIRequestUtils.ERROR_CODE_408);
                String message = throwable.getMessage();
                if (message == null) {
                    message = "";
                }
                jSONObject2.put("message", message);
                jSONObject.put("respone", jSONObject2);
                INetworkExecutor.Callback.this.onRequestFailed(new Exception(jSONObject.toString()));
                return Unit.INSTANCE;
            }

            public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errCode", errorCode != null ? errorCode.intValue() : XBridgeAPIRequestUtils.ERROR_CODE_408);
                String message = throwable.getMessage();
                if (message == null) {
                    message = "";
                }
                jSONObject2.put("message", message);
                jSONObject.put("respone", jSONObject2);
                INetworkExecutor.Callback.this.onRequestFailed(new Exception(jSONObject.toString()));
            }
        };
        String str2 = this.method;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, PrefetchRequestConfig.METHOD_GET)) {
            com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.get$default(com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.INSTANCE, url, headers, iResponseCallback, iHostNetworkDepend, needCommonParams, true, 0, 64, (Object) null);
            return;
        }
        String str3 = this.method;
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        if (str3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str3.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase2, PrefetchRequestConfig.METHOD_POST)) {
            if (headers == null || (str = headers.get(XBridgeAPIRequestUtils.CONTENT_TYPE)) == null) {
                str = "application/x-www-form-urlencoded";
            }
            headers.put(XBridgeAPIRequestUtils.CONTENT_TYPE, str);
            com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils xBridgeAPIRequestUtils = com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.INSTANCE;
            JSONObject jSONObject = this.body;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.post$default(xBridgeAPIRequestUtils, url, headers, str, jSONObject, iResponseCallback, iHostNetworkDepend, needCommonParams, true, 0, 256, (Object) null);
        }
    }

    public final String createApiUrl$anniex_release(String baseUrl, Map<String, String> params, Map<String, String> extraParams) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Uri.Builder buildUpon = Uri.parse(baseUrl).buildUpon();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        if (extraParams != null) {
            for (Map.Entry<String, String> entry2 : extraParams.entrySet()) {
                buildUpon.appendQueryParameter(entry2.getKey(), entry2.getValue());
            }
        }
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performStreamRequest(String url, Map<String, String> headers, boolean needCommonParams, boolean isCustomizedCookie, final INetworkExecutor.StreamCallback callback) {
        IHostNetworkDepend pureNetworkDependInstance;
        if (RuntimeHelper.INSTANCE.getNetworkDependInstanceV2((IBDXBridgeContext) null) != null) {
            IHostNetworkDependV2 networkDependInstanceV2 = RuntimeHelper.INSTANCE.getNetworkDependInstanceV2((IBDXBridgeContext) null);
            Intrinsics.checkNotNull(networkDependInstanceV2);
            pureNetworkDependInstance = (IHostNetworkDepend) networkDependInstanceV2;
        } else if (needCommonParams) {
            pureNetworkDependInstance = RuntimeHelper.INSTANCE.getNetworkDependInstance((IBDXBridgeContext) null);
        } else {
            pureNetworkDependInstance = RuntimeHelper.INSTANCE.getPureNetworkDependInstance((IBDXBridgeContext) null);
        }
        IHostNetworkDepend iHostNetworkDepend = pureNetworkDependInstance;
        IStreamResponseCallback iStreamResponseCallback = new IStreamResponseCallback() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchRequest$performStreamRequest$responseCallback$1
            public void handleConnection(AbsStreamConnection connection) {
                Throwable th;
                BufferedInputStream bufferedInputStream;
                INetworkExecutor.StreamCallback streamCallback;
                Exception exc;
                BufferedInputStream bufferedInputStream2;
                int read;
                if (connection == null) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connection is null", null, null, 12, null);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("message", "connection failed");
                    INetworkExecutor.StreamCallback.this.onRequestFailed(new Exception(jSONObject.toString()));
                    return;
                }
                InputStream inputStreamResponseBody = connection.getInputStreamResponseBody();
                int responseCode = connection.getResponseCode();
                if (inputStreamResponseBody == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("code", 0);
                    jSONObject2.put("message", "body failed");
                    INetworkExecutor.StreamCallback.this.onRequestFailed(new Exception(jSONObject2.toString()));
                    return;
                }
                LinkedHashMap responseHeader = connection.getResponseHeader();
                BufferedInputStream bufferedInputStream3 = null;
                BufferedInputStream bufferedInputStream4 = null;
                try {
                    try {
                        HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect start stream", null, null, 12, null);
                        bufferedInputStream2 = new BufferedInputStream(inputStreamResponseBody);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream = bufferedInputStream3;
                    }
                } catch (Exception e) {
                    e = e;
                }
                try {
                    byte[] bArr = new byte[IConditionCallKt.annieXStreamPrefetchChunkSize()];
                    while (true) {
                        read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            try {
                                break;
                            } catch (IOException e2) {
                                HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally exp e:" + e2.getMessage(), null, null, 12, null);
                                e2.printStackTrace();
                                streamCallback = INetworkExecutor.StreamCallback.this;
                                exc = new Exception(e2.getMessage());
                                streamCallback.onRequestFailed(exc);
                            }
                        }
                        INetworkExecutor.StreamCallback streamCallback2 = INetworkExecutor.StreamCallback.this;
                        INetworkExecutor.HttpResponse httpResponse = new INetworkExecutor.HttpResponse();
                        httpResponse.setBody(ArraysKt.copyOfRange(bArr, 0, read));
                        httpResponse.setHeaderMap(responseHeader);
                        httpResponse.setStatusCode(responseCode);
                        streamCallback2.onReceiveResponse(httpResponse);
                    }
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally close", null, null, 12, null);
                    connection.cancel();
                    bufferedInputStream2.close();
                    INetworkExecutor.StreamCallback streamCallback3 = INetworkExecutor.StreamCallback.this;
                    INetworkExecutor.HttpResponse httpResponse2 = new INetworkExecutor.HttpResponse();
                    responseHeader = responseHeader;
                    httpResponse2.setHeaderMap(responseHeader);
                    httpResponse2.setStatusCode(responseCode);
                    streamCallback3.onRequestSucceed(httpResponse2);
                    bufferedInputStream3 = read;
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream4 = bufferedInputStream2;
                    HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect performStreamRequest error reason: " + e.getMessage(), null, null, 12, null);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", 0);
                    String message = e.getMessage();
                    if (message == null) {
                        message = "unknown error";
                    }
                    jSONObject3.put("message", message);
                    INetworkExecutor.StreamCallback.this.onRequestFailed(new Exception(jSONObject3.toString()));
                    try {
                        HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally close", null, null, 12, null);
                        connection.cancel();
                        if (bufferedInputStream4 != null) {
                            bufferedInputStream4.close();
                        }
                        INetworkExecutor.StreamCallback streamCallback4 = INetworkExecutor.StreamCallback.this;
                        INetworkExecutor.HttpResponse httpResponse3 = new INetworkExecutor.HttpResponse();
                        responseHeader = responseHeader;
                        httpResponse3.setHeaderMap(responseHeader);
                        httpResponse3.setStatusCode(responseCode);
                        streamCallback4.onRequestSucceed(httpResponse3);
                        bufferedInputStream3 = bufferedInputStream4;
                    } catch (IOException e4) {
                        HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally exp e:" + e4.getMessage(), null, null, 12, null);
                        e4.printStackTrace();
                        streamCallback = INetworkExecutor.StreamCallback.this;
                        exc = new Exception(e4.getMessage());
                        streamCallback.onRequestFailed(exc);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally close", null, null, 12, null);
                        connection.cancel();
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        INetworkExecutor.StreamCallback streamCallback5 = INetworkExecutor.StreamCallback.this;
                        INetworkExecutor.HttpResponse httpResponse4 = new INetworkExecutor.HttpResponse();
                        httpResponse4.setHeaderMap(responseHeader);
                        httpResponse4.setStatusCode(responseCode);
                        streamCallback5.onRequestSucceed(httpResponse4);
                        throw th;
                    } catch (IOException e5) {
                        HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "connect finally exp e:" + e5.getMessage(), null, null, 12, null);
                        e5.printStackTrace();
                        INetworkExecutor.StreamCallback.this.onRequestFailed(new Exception(e5.getMessage()));
                        throw th;
                    }
                }
            }
        };
        String str = this.method;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual(lowerCase, PrefetchRequestConfig.METHOD_GET)) {
            com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.doGetForStream$default(com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils.INSTANCE, url, new LinkedHashMap(headers), iStreamResponseCallback, iHostNetworkDepend, needCommonParams, isCustomizedCookie, 0L, 64, (Object) null);
        }
    }

    public final String createApiUrlWithGlobalProps$anniex_release(String baseUrl, Map<String, String> params, Map<String, String> extraParams, Map<String, String> appendGlobalProps) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Uri.Builder buildUpon = Uri.parse(baseUrl).buildUpon();
        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        if (extraParams != null) {
            for (Map.Entry<String, String> entry2 : extraParams.entrySet()) {
                buildUpon.appendQueryParameter(entry2.getKey(), entry2.getValue());
            }
        }
        if (appendGlobalProps != null) {
            buildUpon.appendQueryParameter(SchemaConstants.APPENDED_GLOBAL_PROPS, new JSONObject(appendGlobalProps).toString()).build();
        }
        String builder = buildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(builder, "builder.toString()");
        return builder;
    }

    /* renamed from: getUniqueKey, reason: from getter */
    public final String getRequestKey() {
        return this.requestKey;
    }

    /* compiled from: PrefetchRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J0\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J0\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0003¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest$Companion;", "", "()V", PraiseDialogConstant.FROM, "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "apiConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;", "schemaModel", "Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "prefetchConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "getBody", "Lorg/json/JSONObject;", "dataMap", "", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchParam;", "getBodyMap", "", "configMap", "getEnvInfo", "type", "getParamMap", "getStorageValue", "param", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PrefetchRequest from(PrefetchRequestConfig apiConfig, SchemaModel schemaModel, PrefetchConfig prefetchConfig) {
            Intrinsics.checkNotNullParameter(apiConfig, "apiConfig");
            Intrinsics.checkNotNullParameter(schemaModel, "schemaModel");
            Intrinsics.checkNotNullParameter(prefetchConfig, "prefetchConfig");
            String url = apiConfig.getUrl();
            String str = url;
            if (str == null || str.length() == 0) {
                return null;
            }
            String method = apiConfig.getMethod();
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            if (method == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = method.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!PrefetchConfigKt.isRequestMethodSupported(lowerCase)) {
                PrefetchLogger.INSTANCE.m37e("不支持的请求类型: " + lowerCase);
                return null;
            }
            try {
                if (!apiConfig.checkCondition(schemaModel)) {
                    PrefetchLogger.INSTANCE.m39w("不满足配置的条件，不发起prefetch请求，请检查condition配置：" + apiConfig.getUrl());
                    return null;
                }
                PrefetchRequest prefetchRequest = new PrefetchRequest(url, lowerCase, getParamMap(apiConfig.getHeaders(), schemaModel), getParamMap(apiConfig.getParams(), schemaModel), getBody(apiConfig.getData(), schemaModel), apiConfig.getNeedCommonParams(), getParamMap(apiConfig.getExtraHeaders(), schemaModel), getParamMap(apiConfig.getExtraParams(), schemaModel), apiConfig.getIsCustomizedCookie(), apiConfig.getStreamLoadType(), apiConfig.getAppendGlobalProps());
                prefetchRequest.setConfigFrom(prefetchConfig.getConfigFrom());
                prefetchRequest.setBid(prefetchConfig.getBid());
                return prefetchRequest;
            } catch (Exception e) {
                PrefetchLogger.INSTANCE.m37e(e.getMessage());
                return null;
            }
        }

        private final JSONObject getBody(Map<String, PrefetchParam> dataMap, SchemaModel schemaModel) {
            Map<String, Object> bodyMap = getBodyMap(dataMap, schemaModel);
            Intrinsics.checkNotNull(bodyMap, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any?, kotlin.Any?>");
            return new JSONObject(bodyMap);
        }

        private final Map<String, Object> getBodyMap(Map<String, PrefetchParam> configMap, SchemaModel schemaModel) {
            String envInfo;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, PrefetchParam> entry : configMap.entrySet()) {
                String key = entry.getKey();
                PrefetchParam value = entry.getValue();
                if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_STATIC)) {
                    linkedHashMap.put(key, value.getValue());
                } else if (Intrinsics.areEqual(value.getType(), "query")) {
                    String query = schemaModel.getQuery(value.getValue().toString());
                    if (query != null) {
                        linkedHashMap.put(key, query);
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_QUERY_OBJECT)) {
                    String queryFromObject = schemaModel.getQueryFromObject(value.getValue().toString());
                    if (queryFromObject != null) {
                        linkedHashMap.put(key, queryFromObject);
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_STORAGE)) {
                    Object storageValue = getStorageValue(value, schemaModel);
                    if (storageValue != null) {
                        linkedHashMap.put(key, storageValue);
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_ENV) && (envInfo = getEnvInfo(value.getValue().toString())) != null) {
                    linkedHashMap.put(key, envInfo);
                }
            }
            return linkedHashMap;
        }

        private final Map<String, String> getParamMap(Map<String, PrefetchParam> configMap, SchemaModel schemaModel) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, PrefetchParam> entry : configMap.entrySet()) {
                String key = entry.getKey();
                PrefetchParam value = entry.getValue();
                if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_STATIC)) {
                    linkedHashMap.put(key, value.getValue().toString());
                } else if (Intrinsics.areEqual(value.getType(), "query")) {
                    String query = schemaModel.getQuery(value.getValue().toString());
                    if (query != null) {
                        linkedHashMap.put(key, query);
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_QUERY_OBJECT)) {
                    String queryFromObject = schemaModel.getQueryFromObject(value.getValue().toString());
                    if (queryFromObject != null) {
                        linkedHashMap.put(key, queryFromObject);
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_STORAGE)) {
                    Object storageValue = getStorageValue(value, schemaModel);
                    if (storageValue != null) {
                        linkedHashMap.put(key, storageValue.toString());
                    }
                } else if (Intrinsics.areEqual(value.getType(), PrefetchRequestConfig.PARAM_TYPE_ENV)) {
                    String envInfo = getEnvInfo(value.getValue().toString());
                    if (envInfo != null) {
                        linkedHashMap.put(key, envInfo);
                    }
                } else if (value.getIsRawValue()) {
                    linkedHashMap.put(key, value.getRawValue());
                }
            }
            return linkedHashMap;
        }

        private final String getEnvInfo(String type) {
            if (type.equals(PrefetchRequestConfig.ENV_TYPE_AID)) {
                return BulletEnv.INSTANCE.getInstance().getAppId();
            }
            if (type.equals(PrefetchRequestConfig.ENV_TYPE_OS)) {
                return FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID;
            }
            if (type.equals(PrefetchRequestConfig.ENV_TYPE_APP_VERSION)) {
                return BulletEnv.INSTANCE.getInstance().getAppVersion();
            }
            if (type.equals(PrefetchRequestConfig.ENV_TYPE_DID)) {
                return BulletEnv.INSTANCE.getInstance().getDid();
            }
            return null;
        }

        private final Object getStorageValue(PrefetchParam param, SchemaModel schemaModel) {
            IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
            String userId = hostUserDepend != null ? hostUserDepend.getUserId() : null;
            String str = userId;
            if (str == null || str.length() == 0) {
                IHostUserDepend hostUserDepend2 = XBaseRuntime.INSTANCE.getHostUserDepend();
                PrefetchLogger.INSTANCE.m37e("UID 为空，当前登录状态: " + (hostUserDepend2 != null ? Boolean.valueOf(hostUserDepend2.hasLogin()) : null));
                return null;
            }
            if (param.getEnableAppIdIsolation()) {
                String query = schemaModel.getQuery("app_id");
                String str2 = query;
                if (str2 == null || str2.length() == 0) {
                    PrefetchLogger.INSTANCE.m37e("appId为空");
                    return null;
                }
                Application application = BulletEnv.INSTANCE.getInstance().getApplication();
                Intrinsics.checkNotNull(application);
                Triple userDomainStorageItem = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(application).getUserDomainStorageItem(userId + "appId_" + query, param.getValue().toString(), ErrorType.PREFETCH, "prefetch_session_id");
                boolean booleanValue = ((Boolean) userDomainStorageItem.component1()).booleanValue();
                boolean booleanValue2 = ((Boolean) userDomainStorageItem.component2()).booleanValue();
                Object component3 = userDomainStorageItem.component3();
                if (!booleanValue || booleanValue2) {
                    return null;
                }
                return component3;
            }
            Application application2 = BulletEnv.INSTANCE.getInstance().getApplication();
            Intrinsics.checkNotNull(application2);
            Triple userDomainStorageItem2 = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(application2).getUserDomainStorageItem(userId, param.getValue().toString(), ErrorType.PREFETCH, "prefetch_session_id");
            boolean booleanValue3 = ((Boolean) userDomainStorageItem2.component1()).booleanValue();
            boolean booleanValue4 = ((Boolean) userDomainStorageItem2.component2()).booleanValue();
            Object component32 = userDomainStorageItem2.component3();
            if (!booleanValue3 || booleanValue4) {
                return null;
            }
            return component32;
        }
    }
}
