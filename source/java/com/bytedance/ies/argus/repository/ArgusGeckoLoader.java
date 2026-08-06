package com.bytedance.ies.argus.repository;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.common.wschannel.channel.impl.p007ok.WsStatus;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson.GsonConverterFactory;
import com.bytedance.geckox.loader.GeckoResLoader;
import com.bytedance.ies.argus.api.interfaces.ArgusGeckoResponse;
import com.bytedance.ies.argus.api.interfaces.ArgusInitConfig;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderEnvData;
import com.bytedance.ies.bullet.kit.resourceloader.model.ResourceLoaderType;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.utils.IResponseCallback;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ArgusGeckoLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002!\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J9\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00160\u001bJ*\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00160\u001bJ\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006#"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusGeckoLoader;", "", "()V", "FETCH_CDN_CONFIG_VERSION_1", "", "FETCH_CDN_CONFIG_VERSION_2", "TAG", "ak", "getAk", "()Ljava/lang/String;", "ak$delegate", "Lkotlin/Lazy;", "createRetrofit", "Lcom/bytedance/retrofit2/Retrofit;", "getAccessKey", "getBuiltinResource", "Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse;", "context", "Landroid/content/Context;", "channel", "bundle", "getRemoteResource", "", "url", "retry", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", ApmTrafficStats.TTNET_RESPONSE, "getRemoteResourceV2", "tryRetryAddEnvParamsForCDNMultiVersion", "INetworkApi", "TTNetClient", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusGeckoLoader {
    public static final String FETCH_CDN_CONFIG_VERSION_1 = "v1";
    public static final String FETCH_CDN_CONFIG_VERSION_2 = "v2";
    public static final String TAG = "ArgusGeckoLoader";
    public static final ArgusGeckoLoader INSTANCE = new ArgusGeckoLoader();

    /* renamed from: ak$delegate, reason: from kotlin metadata */
    private static final Lazy ak = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.ies.argus.repository.ArgusGeckoLoader$ak$2
        public final String invoke() {
            String accessKey;
            accessKey = ArgusGeckoLoader.INSTANCE.getAccessKey();
            return accessKey;
        }
    });

    /* compiled from: ArgusGeckoLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusGeckoLoader$INetworkApi;", "", "get", "Lcom/bytedance/retrofit2/Call;", "", "url", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface INetworkApi {
        @GET
        Call<String> get(@Url String url);
    }

    /* compiled from: ArgusGeckoLoader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ResourceLoaderType.values().length];
            try {
                iArr[ResourceLoaderType.PPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResourceLoaderType.BOE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ArgusGeckoLoader() {
    }

    private final String getAk() {
        return (String) ak.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getAccessKey() {
        ResourceLoaderEnvData resourceLoaderEnvData = ResourceLoader.INSTANCE.getResourceLoaderEnvData();
        ResourceLoaderType type = resourceLoaderEnvData != null ? resourceLoaderEnvData.getType() : null;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        return i != 1 ? i != 2 ? ArgusSdkGeckoAppRegister.ONLINE_ACCESS_KEY : ArgusSdkGeckoAppRegister.BOE_ACCESS_KEY : ArgusSdkGeckoAppRegister.TEST_ACCESS_KEY;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007d A[Catch: Exception -> 0x002f, TryCatch #1 {Exception -> 0x002f, blocks: (B:36:0x0022, B:6:0x0037, B:19:0x007d, B:22:0x0084, B:23:0x0088, B:25:0x0091, B:26:0x0095, B:29:0x0077), top: B:35:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[Catch: Exception -> 0x002f, TryCatch #1 {Exception -> 0x002f, blocks: (B:36:0x0022, B:6:0x0037, B:19:0x007d, B:22:0x0084, B:23:0x0088, B:25:0x0091, B:26:0x0095, B:29:0x0077), top: B:35:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArgusGeckoResponse getBuiltinResource(Context context, String channel, String bundle) {
        Application application;
        InputStream inputStream;
        Long l;
        String exc;
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        ArgusGeckoResponse argusGeckoResponse = new ArgusGeckoResponse(false, null, null, null, null, null, null, false, null, 508, null);
        if (context == null) {
            try {
                application = BulletEnv.Companion.getInstance().getApplication();
            } catch (Exception e) {
                argusGeckoResponse.setMsg(argusGeckoResponse.getMsg() == null ? e.toString() : argusGeckoResponse.getMsg() + " -> run error: " + e);
            }
        } else {
            application = context;
        }
        if (application == null) {
            argusGeckoResponse.setSucceed(false);
            argusGeckoResponse.setMsg("client context is null, can't trigger fetch");
        } else {
            try {
                GeckoResLoader geckoResLoader = new GeckoResLoader(application, getAk());
                inputStream = geckoResLoader.getInputStream(channel + '/' + bundle);
                try {
                    l = geckoResLoader.getChannelVersion(channel);
                    try {
                        geckoResLoader.release();
                        exc = null;
                    } catch (Exception e2) {
                        e = e2;
                        exc = e.toString();
                        if (inputStream != null) {
                        }
                        return argusGeckoResponse;
                    }
                } catch (Exception e3) {
                    e = e3;
                    l = null;
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = null;
                l = null;
            }
            if (inputStream != null) {
                argusGeckoResponse.setSucceed(false);
                if (exc == null) {
                    exc = "gecko resource is null";
                }
                argusGeckoResponse.setMsg(exc);
            } else {
                argusGeckoResponse.setSucceed(true);
                argusGeckoResponse.setResponse(inputStream);
                argusGeckoResponse.setGeckoVersion(l != null ? l.toString() : null);
            }
        }
        return argusGeckoResponse;
    }

    public final void getRemoteResource(String url, final boolean retry, final Function1<? super ArgusGeckoResponse, Unit> callback) {
        String addCommonParamsForCDNMultiVersionURL;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        try {
            IHostNetworkDepend hostNetworkDepend = XBaseRuntime.INSTANCE.getHostNetworkDepend();
            if (hostNetworkDepend == null) {
                callback.invoke(new ArgusGeckoResponse(false, null, null, "host network depend is null", null, null, null, false, FETCH_CDN_CONFIG_VERSION_1, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null));
                return;
            }
            if (retry) {
                addCommonParamsForCDNMultiVersionURL = tryRetryAddEnvParamsForCDNMultiVersion(url);
            } else {
                addCommonParamsForCDNMultiVersionURL = GeckoXAdapter.INSTANCE.addCommonParamsForCDNMultiVersionURL(url);
            }
            final String str = addCommonParamsForCDNMultiVersionURL;
            XBridgeAPIRequestUtils.get$default(XBridgeAPIRequestUtils.INSTANCE, str, new LinkedHashMap(), new IResponseCallback(str, retry, callback) { // from class: com.bytedance.ies.argus.repository.ArgusGeckoLoader$getRemoteResource$responseCallback$1
                final /* synthetic */ Function1<ArgusGeckoResponse, Unit> $callback;
                private final ArgusGeckoResponse response;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.$callback = callback;
                    ArgusGeckoResponse argusGeckoResponse = new ArgusGeckoResponse(false, null, null, null, null, null, null, false, null, WsStatus.HandshakeStatus.INTERNAL_ERROR, null);
                    argusGeckoResponse.setFetchUrl(str);
                    argusGeckoResponse.setFromRetry(retry);
                    argusGeckoResponse.setNetworkLogicVersion(ArgusGeckoLoader.FETCH_CDN_CONFIG_VERSION_1);
                    this.response = argusGeckoResponse;
                }

                public Unit onParsingFailed(JSONObject jSONObject, LinkedHashMap<String, String> linkedHashMap, String str2, Throwable th, Integer num, int i) {
                    return IResponseCallback.DefaultImpls.onParsingFailed(this, jSONObject, linkedHashMap, str2, th, num, i);
                }

                public final ArgusGeckoResponse getResponse() {
                    return this.response;
                }

                public void onSuccess(JSONObject body, LinkedHashMap<String, String> responseHeader, Integer statusCode, int clientCode) {
                    Intrinsics.checkNotNullParameter(body, ReportConst.ValidationReport.BODY);
                    Intrinsics.checkNotNullParameter(responseHeader, SlardarSettingsConsts.EXT_RESPONSE_HEADER);
                    ArgusGeckoResponse argusGeckoResponse = this.response;
                    argusGeckoResponse.setSucceed(true);
                    argusGeckoResponse.setJsonResponse(body);
                    argusGeckoResponse.setGeckoVersion(responseHeader.get(CDNFetchDepender.KEY_VERSION));
                    argusGeckoResponse.setRequestLogId(responseHeader.get("x-tt-logid"));
                    this.$callback.invoke(argusGeckoResponse);
                }

                public void onFailed(Integer errorCode, LinkedHashMap<String, String> responseHeader, Throwable throwable, int clientCode) {
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    ArgusGeckoResponse argusGeckoResponse = this.response;
                    argusGeckoResponse.setSucceed(false);
                    argusGeckoResponse.setMsg("code=" + errorCode + ",msg=" + throwable.getMessage());
                    argusGeckoResponse.setRequestLogId(responseHeader != null ? responseHeader.get("x-tt-logid") : null);
                    this.$callback.invoke(argusGeckoResponse);
                }
            }, hostNetworkDepend, true, false, 0, 64, (Object) null);
        } catch (Exception e) {
            ArgusGeckoResponse argusGeckoResponse = new ArgusGeckoResponse(false, null, null, null, null, null, null, false, null, WsStatus.HandshakeStatus.INTERNAL_ERROR, null);
            argusGeckoResponse.setMsg("getRemoteResource error: " + e);
            argusGeckoResponse.setNetworkLogicVersion(FETCH_CDN_CONFIG_VERSION_1);
            callback.invoke(argusGeckoResponse);
        }
    }

    public final void getRemoteResourceV2(String url, boolean retry, Function1<? super ArgusGeckoResponse, Unit> callback) {
        String addCommonParamsForCDNMultiVersionURL;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, JsCallParser.VALUE_CALLBACK);
        try {
            if (retry) {
                addCommonParamsForCDNMultiVersionURL = tryRetryAddEnvParamsForCDNMultiVersion(url);
            } else {
                addCommonParamsForCDNMultiVersionURL = GeckoXAdapter.INSTANCE.addCommonParamsForCDNMultiVersionURL(url);
            }
            if (retry) {
                ArgusLog.w$default(ArgusLog.INSTANCE, TAG, "getRemoteResource retry: fetch cdn config, url: " + addCommonParamsForCDNMultiVersionURL, null, 4, null);
            }
            Call<String> call = ((INetworkApi) createRetrofit().create(INetworkApi.class)).get(addCommonParamsForCDNMultiVersionURL);
            if (call == null) {
                ArgusGeckoResponse argusGeckoResponse = new ArgusGeckoResponse(false, null, null, null, null, null, null, false, null, WsStatus.HandshakeStatus.INTERNAL_ERROR, null);
                argusGeckoResponse.setMsg("getRemoteResourceV2 error: retrofit call is null");
                argusGeckoResponse.setNetworkLogicVersion(FETCH_CDN_CONFIG_VERSION_2);
                callback.invoke(argusGeckoResponse);
                return;
            }
            SsResponse execute = call.execute();
            JSONObject jSONObject = new JSONObject((String) execute.body());
            ArgusGeckoResponse argusGeckoResponse2 = new ArgusGeckoResponse(true, null, null, null, null, null, null, false, null, WsStatus.HandshakeStatus.INTERNAL_ERROR, null);
            argusGeckoResponse2.setFetchUrl(addCommonParamsForCDNMultiVersionURL);
            argusGeckoResponse2.setFromRetry(retry);
            argusGeckoResponse2.setJsonResponse(jSONObject);
            List headers = execute.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "resp.headers()");
            Iterator it = headers.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (StringsKt.equals(((Header) obj).getName(), CDNFetchDepender.KEY_VERSION, true)) {
                        break;
                    }
                }
            }
            Header header = (Header) obj;
            argusGeckoResponse2.setGeckoVersion(header != null ? header.getValue() : null);
            List headers2 = execute.headers();
            Intrinsics.checkNotNullExpressionValue(headers2, "resp.headers()");
            Iterator it2 = headers2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it2.next();
                    if (StringsKt.equals(((Header) obj2).getName(), "x-tt-logid", true)) {
                        break;
                    }
                }
            }
            Header header2 = (Header) obj2;
            argusGeckoResponse2.setRequestLogId(header2 != null ? header2.getValue() : null);
            argusGeckoResponse2.setNetworkLogicVersion(FETCH_CDN_CONFIG_VERSION_2);
            callback.invoke(argusGeckoResponse2);
        } catch (Exception e) {
            ArgusGeckoResponse argusGeckoResponse3 = new ArgusGeckoResponse(false, null, null, null, null, null, null, false, null, WsStatus.HandshakeStatus.INTERNAL_ERROR, null);
            argusGeckoResponse3.setMsg("getRemoteResourceV2 error: " + e);
            argusGeckoResponse3.setNetworkLogicVersion(FETCH_CDN_CONFIG_VERSION_2);
            callback.invoke(argusGeckoResponse3);
        }
    }

    private final String tryRetryAddEnvParamsForCDNMultiVersion(String url) {
        String str;
        String appId;
        try {
            Pair[] pairArr = new Pair[2];
            ArgusInitConfig.AppEnv env = ArgusEnv.INSTANCE.getInstance().getEnv();
            String str2 = "";
            if (env == null || (str = env.getAppVersion()) == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.to("version_name", str);
            ArgusInitConfig.AppEnv env2 = ArgusEnv.INSTANCE.getInstance().getEnv();
            if (env2 != null && (appId = env2.getAppId()) != null) {
                str2 = appId;
            }
            pairArr[1] = TuplesKt.to("aid", str2);
            Map mapOf = MapsKt.mapOf(pairArr);
            Uri.Builder buildUpon = Uri.parse(url).buildUpon();
            for (Map.Entry entry : mapOf.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                if (str4.length() > 0) {
                    buildUpon.appendQueryParameter(str3, str4);
                }
            }
            String uri = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
            url = uri;
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, TAG, "getGeckoMultiplyCDNURL url=" + url + " got error: " + e, null, null, 12, null);
        }
        return GeckoXAdapter.INSTANCE.addCommonParamsForCDNMultiVersionURL(url);
    }

    private final Retrofit createRetrofit() {
        Retrofit build = new Retrofit.Builder().setEndpoint("https://placeholder.com/").addConverterFactory(GsonConverterFactory.create()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor()).client(new TTNetClient()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…t())\n            .build()");
        return build;
    }

    /* compiled from: ArgusGeckoLoader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/argus/repository/ArgusGeckoLoader$TTNetClient;", "Lcom/bytedance/retrofit2/client/Client$Provider;", "()V", "get", "Lcom/bytedance/retrofit2/client/Client;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class TTNetClient implements Client.Provider {
        public Client get() {
            return new SsRetrofitClient();
        }
    }
}
