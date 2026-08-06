package com.bytedance.forest.chain.fetchers;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.DynamicType;
import com.bytedance.forest.model.FetcherType;
import com.bytedance.forest.model.ForestConfig;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.ForestEnvType;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.GeckoSource;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.forest.utils.UriParser;
import com.bytedance.forest.utils.UriParserKt;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.GeckoClientManager;
import com.bytedance.geckox.GeckoConfig;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.loader.GeckoResLoader;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.statistic.IStatisticMonitor;
import com.bytedance.iesgurd.IESGurdKit;
import com.bytedance.iesgurd.IESGurdResData;
import com.bytedance.iesgurd.IESGurdResError;
import com.bytedance.iesgurd.IESGurdResFrom;
import com.bytedance.iesgurd.IESGurdResParams;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: GeckoXAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fJ/\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001a0\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\b\u001bJM\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001d0%H\u0007¢\u0006\u0002\u0010'J\u0017\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u000fH\u0000¢\u0006\u0002\b)J\u0012\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u001e\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u000200R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "", "app", "Landroid/app/Application;", "forest", "Lcom/bytedance/forest/Forest;", "(Landroid/app/Application;Lcom/bytedance/forest/Forest;)V", "getApp", "()Landroid/app/Application;", "appFileDir", "Ljava/io/File;", "forestConfig", "Lcom/bytedance/forest/model/ForestConfig;", "geckoClients", "Ljava/util/HashMap;", "", "Lcom/bytedance/geckox/GeckoClient;", "mStatisticMonitor", "Lcom/bytedance/geckox/statistic/IStatisticMonitor;", "checkChannelExists", "", "accessKey", "channel", "getChannelVersion", "", "getCustomParams", "", "getCustomParams$forest_release", "getGeckoResourceData", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "bundle", "channelVersion", "loaderConfig", "Lcom/bytedance/forest/model/GeckoConfig;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "Lcom/bytedance/iesgurd/IESGurdResData;", "(Lcom/bytedance/forest/model/Response;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/forest/model/GeckoConfig;Lkotlin/jvm/functions/Function1;)V", "getNormalGeckoXClient", "getNormalGeckoXClient$forest_release", "initGeckoXMultiClient", "isGeckoCDNAndMergeConfig", "uri", "Landroid/net/Uri;", "url", "request", "Lcom/bytedance/forest/model/Request;", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoXAdapter {
    private static Map<String, String> CDNMultiVersionCommonParamsDelegate = null;
    private static final String DEFAULT_BUCKET_ID = "9";
    public static final String TAG = "GeckoXAdapter";
    private final Application app;
    private File appFileDir;
    private final Forest forest;
    private final ForestConfig forestConfig;
    private final HashMap<String, GeckoClient> geckoClients;
    private final IStatisticMonitor mStatisticMonitor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> fallbackCDNMultiVersionDomains = new ArrayList();
    private static final String INVALID_BUCKET_ID = "-1";
    private static String geckoBucketId = INVALID_BUCKET_ID;

    public final void getGeckoResourceData(Response response, String str, String str2, GeckoConfig geckoConfig, Function1<? super IESGurdResData, Unit> function1) {
        getGeckoResourceData$default(this, response, str, str2, null, geckoConfig, function1, 8, null);
    }

    public GeckoXAdapter(Application application, Forest forest) {
        Intrinsics.checkParameterIsNotNull(application, "app");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        this.app = application;
        this.forest = forest;
        this.forestConfig = forest.getConfig();
        this.geckoClients = new HashMap<>();
        this.mStatisticMonitor = new IStatisticMonitor() { // from class: com.bytedance.forest.chain.fetchers.GeckoXAdapter$mStatisticMonitor$1
            @Override // com.bytedance.geckox.statistic.IStatisticMonitor
            public final void upload(String str, JSONObject jSONObject) {
                if (TextUtils.isEmpty(str) || jSONObject == null) {
                    return;
                }
                LogUtils.i$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, "event:" + str + ",data:" + jSONObject, false, null, null, null, 60, null);
            }
        };
    }

    public final Application getApp() {
        return this.app;
    }

    /* compiled from: GeckoXAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010!\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter$Companion;", "", "()V", "CDNMultiVersionCommonParams", "", "", "getCDNMultiVersionCommonParams", "()Ljava/util/Map;", "CDNMultiVersionCommonParamsDelegate", "DEFAULT_BUCKET_ID", "INVALID_BUCKET_ID", "TAG", "fallbackCDNMultiVersionDomains", "", "geckoBucketId", "addCommonParamsForCDNMultiVersionURL", "url", "addDefaultCDNMultiVersionDomains", "", "domains", "", "canParsed", "", "uri", "Landroid/net/Uri;", "dealWithBoeDomainIfNeed", "host", "getGeckoBucketId", "deviceId", "", "(Ljava/lang/Long;)Ljava/lang/String;", "getPrefixAsGeckoCDN", "path", "isCDNMultiVersionResource", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final /* synthetic */ Map access$getCDNMultiVersionCommonParamsDelegate$li(Companion companion) {
            return GeckoXAdapter.CDNMultiVersionCommonParamsDelegate;
        }

        public final Map<String, String> getCDNMultiVersionCommonParams() {
            if (access$getCDNMultiVersionCommonParamsDelegate$li(GeckoXAdapter.INSTANCE) != null) {
                Map<String, String> map = GeckoXAdapter.CDNMultiVersionCommonParamsDelegate;
                if (map == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
                }
                return map;
            }
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            if (inst.getGlobalConfig() != null) {
                Pair[] pairArr = new Pair[5];
                GeckoGlobalManager inst2 = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst2, "GeckoGlobalManager.inst()");
                GeckoGlobalConfig globalConfig = inst2.getGlobalConfig();
                pairArr[0] = TuplesKt.to("version_name", globalConfig != null ? globalConfig.getAppVersion() : null);
                pairArr[1] = TuplesKt.to("device_platform", Consts.OS_NAME);
                pairArr[2] = TuplesKt.to("os", Consts.OS_NAME);
                GeckoGlobalManager inst3 = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst3, "GeckoGlobalManager.inst()");
                GeckoGlobalConfig globalConfig2 = inst3.getGlobalConfig();
                pairArr[3] = TuplesKt.to("aid", globalConfig2 != null ? String.valueOf(globalConfig2.getAppId()) : null);
                pairArr[4] = TuplesKt.to("gecko_bkt", getGeckoBucketId$default(GeckoXAdapter.INSTANCE, null, 1, null));
                GeckoXAdapter.CDNMultiVersionCommonParamsDelegate = MapsKt.mapOf(pairArr);
                Map<String, String> map2 = GeckoXAdapter.CDNMultiVersionCommonParamsDelegate;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
                }
                return map2;
            }
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("version_name", ""), TuplesKt.to("device_platform", Consts.OS_NAME), TuplesKt.to("os", Consts.OS_NAME), TuplesKt.to("aid", ""), TuplesKt.to("gecko_bkt", GeckoXAdapter.DEFAULT_BUCKET_ID)});
        }

        public final boolean canParsed(String url) {
            Object obj;
            Intrinsics.checkParameterIsNotNull(url, "url");
            if (url.length() == 0) {
                return false;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Uri.parse(url));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Uri uri = (Uri) obj;
            if (uri != null) {
                return canParsed(uri);
            }
            return false;
        }

        public final boolean canParsed(Uri uri) {
            Intrinsics.checkParameterIsNotNull(uri, "uri");
            if (!UriParserKt.isHttpProtocol(uri)) {
                return false;
            }
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            GlobalConfigSettings globalSettings = inst.getGlobalSettings();
            GlobalConfigSettings.ResourceMeta resourceMeta = globalSettings != null ? globalSettings.getResourceMeta() : null;
            if (resourceMeta == null) {
                LogUtils.e$default(LogUtils.INSTANCE, null, "could not get any valid resource meta", null, 5, null);
                return false;
            }
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            String prefixAsGeckoCDN = getPrefixAsGeckoCDN(path);
            if (prefixAsGeckoCDN.length() == 0) {
                return false;
            }
            GlobalConfigSettings.CurrentLevelConfig config = resourceMeta.getConfig();
            if (config == null) {
                LogUtils.e$default(LogUtils.INSTANCE, null, "could not get any valid config", null, 5, null);
                return false;
            }
            LoaderUtils loaderUtils = LoaderUtils.INSTANCE;
            Map<String, String> prefix2AccessKey = config.getPrefix2AccessKey();
            return loaderUtils.isNotNullOrEmpty(prefix2AccessKey != null ? prefix2AccessKey.get(prefixAsGeckoCDN) : null);
        }

        public final String addCommonParamsForCDNMultiVersionURL(String url) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            if (!isCDNMultiVersionResource(url)) {
                LogUtils.i$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, url + " is not a cdn-multiple-version url", false, null, null, null, 60, null);
                return url;
            }
            Map<String, String> cDNMultiVersionCommonParams = getCDNMultiVersionCommonParams();
            if (cDNMultiVersionCommonParams.isEmpty()) {
                LogUtils.i$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, "no cdn-multiple-version params need to add on " + url, false, null, null, null, 60, null);
            }
            try {
                Uri parse = Uri.parse(url);
                Uri.Builder buildUpon = parse.buildUpon();
                for (Map.Entry<String, String> entry : cDNMultiVersionCommonParams.entrySet()) {
                    if (parse.getQueryParameter(entry.getKey()) == null) {
                        buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    } else {
                        LogUtils.i$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, "Parameter " + entry.getKey() + " of cdn-multiple-version already exists, value is:" + entry.getValue() + '.', false, null, null, null, 60, null);
                    }
                }
                ForestEnvData envData$forest_release = Forest.INSTANCE.getEnvData$forest_release();
                if (envData$forest_release != null) {
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = TuplesKt.to(envData$forest_release.getType() == ForestEnvType.PPE ? UriParserKt.PPE_ENABLE : UriParserKt.BOE_ENABLE, "1");
                    pairArr[1] = TuplesKt.to(UriParserKt.ENV_LANE, envData$forest_release.getName());
                    for (Map.Entry entry2 : MapsKt.mapOf(pairArr).entrySet()) {
                        if (parse.getQueryParameter((String) entry2.getKey()) == null) {
                            buildUpon.appendQueryParameter((String) entry2.getKey(), (String) entry2.getValue());
                        } else {
                            LogUtils.i$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, "Parameter " + ((String) entry2.getKey()) + " of cdn-multiple-version already exists for " + url + ", except:" + ((String) entry2.getValue()) + ", current:" + parse.getQueryParameter((String) entry2.getKey()) + '.', false, null, null, null, 60, null);
                        }
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(parse, "uri");
                String host = parse.getHost();
                if (host == null) {
                    Intrinsics.throwNpe();
                }
                Companion companion = this;
                String dealWithBoeDomainIfNeed = dealWithBoeDomainIfNeed(host);
                if (Intrinsics.areEqual(dealWithBoeDomainIfNeed, host)) {
                    String uri = buildUpon.build().toString();
                    Intrinsics.checkExpressionValueIsNotNull(uri, "builder.build().toString()");
                    return StringsKt.replace$default(uri, host, dealWithBoeDomainIfNeed, false, 4, (Object) null);
                }
                String uri2 = buildUpon.build().toString();
                Intrinsics.checkExpressionValueIsNotNull(uri2, "builder.build().toString()");
                return uri2;
            } catch (Throwable th) {
                LogUtils.e$default(LogUtils.INSTANCE, GeckoXAdapter.TAG, "build cdn-multiple-version for " + url + " failed, error: " + th.getMessage(), null, 4, null);
                return url;
            }
        }

        private final String dealWithBoeDomainIfNeed(String host) {
            ForestEnvData envData$forest_release = Forest.INSTANCE.getEnvData$forest_release();
            return ((envData$forest_release != null ? envData$forest_release.getType() : null) != ForestEnvType.BOE || StringsKt.contains$default(host, ".boe-gateway.byted.org", false, 2, (Object) null)) ? host : host + ".boe-gateway.byted.org";
        }

        public final boolean isCDNMultiVersionResource(String url) {
            List<String> list;
            GlobalConfigSettings.CDNMultiVersion cDNMultiVersion;
            GlobalConfigSettings.ResourceMeta resourceMeta;
            String str = url;
            if (str == null || StringsKt.isBlank(str)) {
                return false;
            }
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            GlobalConfigSettings globalSettings = inst.getGlobalSettings();
            Object obj = null;
            GlobalConfigSettings.CurrentLevelConfig config = (globalSettings == null || (resourceMeta = globalSettings.getResourceMeta()) == null) ? null : resourceMeta.getConfig();
            if (config == null || (cDNMultiVersion = config.getCDNMultiVersion()) == null || (list = cDNMultiVersion.getDomains()) == null) {
                list = GeckoXAdapter.fallbackCDNMultiVersionDomains;
            }
            if (list.isEmpty()) {
                return StringsKt.contains$default(str, "gr-sourcecdn.bytegecko.com", false, 2, (Object) null);
            }
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String str2 = (String) next;
                Intrinsics.checkExpressionValueIsNotNull(str2, "it");
                if (StringsKt.contains$default(str, str2, false, 2, (Object) null)) {
                    obj = next;
                    break;
                }
            }
            return obj != null;
        }

        public static /* synthetic */ String getGeckoBucketId$default(Companion companion, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            return companion.getGeckoBucketId(l);
        }

        public final String getGeckoBucketId(Long deviceId) {
            String valueOf;
            String deviceId2;
            if (!Intrinsics.areEqual(GeckoXAdapter.geckoBucketId, GeckoXAdapter.INVALID_BUCKET_ID)) {
                return GeckoXAdapter.geckoBucketId;
            }
            if (deviceId == null) {
                GeckoGlobalManager inst = GeckoGlobalManager.inst();
                Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
                GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
                deviceId = (globalConfig == null || (deviceId2 = globalConfig.getDeviceId()) == null) ? null : StringsKt.toLongOrNull(deviceId2);
            }
            if (deviceId == null) {
                return GeckoXAdapter.DEFAULT_BUCKET_ID;
            }
            int longValue = (int) (deviceId.longValue() % 100);
            if (longValue == 0) {
                valueOf = "s01";
            } else if (1 <= longValue && 4 >= longValue) {
                valueOf = "s05";
            } else {
                valueOf = (5 <= longValue && 9 >= longValue) ? "0" : String.valueOf(longValue / 10);
            }
            GeckoXAdapter.geckoBucketId = valueOf;
            return GeckoXAdapter.geckoBucketId;
        }

        public final void addDefaultCDNMultiVersionDomains(List<String> domains) {
            Intrinsics.checkParameterIsNotNull(domains, "domains");
            GeckoXAdapter.fallbackCDNMultiVersionDomains.addAll(domains);
        }

        public final String getPrefixAsGeckoCDN(String path) {
            Intrinsics.checkParameterIsNotNull(path, "path");
            List split$default = StringsKt.split$default(path, new String[]{"/"}, false, 0, 6, (Object) null);
            return (split$default.isEmpty() || split$default.size() < 6) ? "" : "/" + ((String) split$default.get(1)) + '/' + ((String) split$default.get(2)) + '/' + ((String) split$default.get(3)) + '/' + ((String) split$default.get(4)) + '/' + ((String) split$default.get(5));
        }
    }

    public final boolean isGeckoCDNAndMergeConfig(Uri uri, String url, Request request) {
        List<GlobalConfigSettings.PipelineStep> pipeline;
        GlobalConfigSettings.CDNFallBackConfig cdnFallback;
        Map<String, GlobalConfigSettings.ChannelMetaInfo> channels;
        GlobalConfigSettings.ChannelMetaInfo channelMetaInfo;
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(request, "request");
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GlobalConfigSettings globalSettings = inst.getGlobalSettings();
        GlobalConfigSettings.CDNFallBackConfig cDNFallBackConfig = null;
        GlobalConfigSettings.ResourceMeta resourceMeta = globalSettings != null ? globalSettings.getResourceMeta() : null;
        if (resourceMeta == null) {
            LogUtils.e$default(LogUtils.INSTANCE, null, "could not get any valid resource meta", null, 5, null);
            return false;
        }
        Companion companion = INSTANCE;
        String path = uri.getPath();
        if (path == null) {
            path = "";
        }
        String prefixAsGeckoCDN = companion.getPrefixAsGeckoCDN(path);
        GlobalConfigSettings.CurrentLevelConfig config = resourceMeta.getConfig();
        if (config == null) {
            LogUtils.e$default(LogUtils.INSTANCE, null, "could not get any valid config", null, 5, null);
            return false;
        }
        Map<String, String> prefix2AccessKey = config.getPrefix2AccessKey();
        String str = prefix2AccessKey != null ? prefix2AccessKey.get(prefixAsGeckoCDN) : null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            LogUtils.e$default(LogUtils.INSTANCE, null, "could not get any valid access key from remote settings", null, 5, null);
            return false;
        }
        request.getGeckoModel().setAccessKey(str);
        GlobalConfigSettings.AccessKeyMetaInfo accessKeyMetaInfo = resourceMeta.getAccessKeys().get(str);
        GlobalConfigSettings.CurrentLevelConfig config2 = accessKeyMetaInfo != null ? accessKeyMetaInfo.getConfig() : null;
        GeckoModel parseChannelBundleByPrefix = UriParser.INSTANCE.parseChannelBundleByPrefix(url, prefixAsGeckoCDN);
        if (parseChannelBundleByPrefix != null && !parseChannelBundleByPrefix.isChannelOrBundleBlank()) {
            request.setGeckoSource(GeckoSource.REMOTE_SETTING);
            request.getGeckoModel().setChannel(parseChannelBundleByPrefix.getChannel());
            request.getGeckoModel().setBundle(parseChannelBundleByPrefix.getBundle());
        }
        GlobalConfigSettings.AccessKeyMetaInfo accessKeyMetaInfo2 = resourceMeta.getAccessKeys().get(str);
        GlobalConfigSettings.CurrentLevelConfig config3 = (accessKeyMetaInfo2 == null || (channels = accessKeyMetaInfo2.getChannels()) == null || (channelMetaInfo = channels.get(request.getGeckoModel().getChannel())) == null) ? null : channelMetaInfo.getConfig();
        if (config3 == null || (pipeline = config3.getPipeline()) == null) {
            pipeline = config2 != null ? config2.getPipeline() : null;
        }
        if (pipeline == null) {
            pipeline = config.getPipeline();
        }
        if (pipeline != null && (!pipeline.isEmpty())) {
            List<FetcherType> fetcherSequence = request.getFetcherSequence();
            fetcherSequence.clear();
            for (GlobalConfigSettings.PipelineStep pipelineStep : pipeline) {
                if (pipelineStep != null) {
                    int type = pipelineStep.getType();
                    if (type == 1) {
                        fetcherSequence.add(FetcherType.GECKO);
                        request.setWaitGeckoUpdate(DynamicType.INSTANCE.asWaitGeckoUpdate(pipelineStep.getUpdate()));
                    } else if (type == 2) {
                        fetcherSequence.add(FetcherType.CDN);
                        request.setEnableCDNCache(pipelineStep.getNoCache() != 1);
                    } else if (type == 3) {
                        fetcherSequence.add(FetcherType.BUILTIN);
                    }
                }
            }
        }
        if (config3 != null && (cdnFallback = config3.getCdnFallback()) != null) {
            cDNFallBackConfig = cdnFallback;
        } else if (config2 != null) {
            cDNFallBackConfig = config2.getCdnFallback();
        }
        if (cDNFallBackConfig == null) {
            cDNFallBackConfig = config.getCdnFallback();
        }
        if (cDNFallBackConfig != null && cDNFallBackConfig.getDomains() != null) {
            List<String> domains = cDNFallBackConfig.getDomains();
            Iterator<String> it = domains.iterator();
            while (it.hasNext()) {
                request.getRemainedFallbackDomains$forest_release().add(it.next());
            }
            Intrinsics.checkExpressionValueIsNotNull(domains, "fallbackConfig.domains.a…          }\n            }");
            request.setFallbackDomains(domains);
            request.setLoadRetryTimes(RangesKt.coerceAtLeast(cDNFallBackConfig.getMaxAttempts(), 1) - 1);
            request.setSupportShuffle(cDNFallBackConfig.getShuffle() == 1);
        }
        return true;
    }

    public final Map<String, Map<String, String>> getCustomParams$forest_release(String accessKey) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = accessKey != null ? accessKey : "";
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        GeckoConfig geckoConfig = this.forestConfig.getGeckoConfig(accessKey);
        if (geckoConfig != null) {
            String businessVersion = geckoConfig.getBusinessVersion();
            if (businessVersion == null) {
                businessVersion = geckoConfig.getAppVersion();
            }
        }
        linkedHashMap.put(str, linkedHashMap2);
        return linkedHashMap;
    }

    public final GeckoClient getNormalGeckoXClient$forest_release(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        GeckoClient geckoClient = this.geckoClients.get(accessKey);
        if (geckoClient != null) {
            return geckoClient;
        }
        GeckoClient initGeckoXMultiClient = initGeckoXMultiClient(accessKey);
        this.geckoClients.put(accessKey, initGeckoXMultiClient);
        return initGeckoXMultiClient;
    }

    private final GeckoClient initGeckoXMultiClient(String accessKey) {
        GeckoClient geckoClientFromRegister = GeckoClientManager.INSTANCE.getGeckoClientFromRegister(accessKey);
        if (geckoClientFromRegister != null) {
            return geckoClientFromRegister;
        }
        GeckoConfig geckoConfig = this.forestConfig.getGeckoConfig(accessKey);
        if (geckoConfig == null) {
            return null;
        }
        try {
            return GeckoClient.create(new GeckoConfig.Builder(this.app).host(this.forestConfig.getHost()).appId(geckoConfig.getAppId()).appVersion(geckoConfig.getAppVersion()).netStack(geckoConfig.getNetworkImpl()).cacheConfig(geckoConfig.getCacheConfig()).statisticMonitor(this.mStatisticMonitor).region(geckoConfig.getRegion()).accessKey(accessKey).allLocalAccessKeys(accessKey).deviceId(geckoConfig.getDid()).resRootDir(geckoConfig.getRootDir(this.app)).build());
        } catch (Exception e) {
            LogUtils.INSTANCE.m289e(TAG, "GeckoClient.create error", e);
            return null;
        }
    }

    public final long getChannelVersion(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (TextUtils.isEmpty(accessKey) || TextUtils.isEmpty(channel)) {
            return 0L;
        }
        return IESGurdKit.INSTANCE.getResVersionOnlyOffline(accessKey, channel);
    }

    public static /* synthetic */ void getGeckoResourceData$default(GeckoXAdapter geckoXAdapter, Response response, String str, String str2, Long l, com.bytedance.forest.model.GeckoConfig geckoConfig, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            l = null;
        }
        geckoXAdapter.getGeckoResourceData(response, str, str2, l, geckoConfig, function1);
    }

    public final void getGeckoResourceData(Response response, String channel, String bundle, Long channelVersion, com.bytedance.forest.model.GeckoConfig loaderConfig, Function1<? super IESGurdResData, Unit> callback) {
        IESGurdResData iESGurdResData;
        String bundlePath;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        Intrinsics.checkParameterIsNotNull(loaderConfig, "loaderConfig");
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        String accessKey = loaderConfig.getAccessKey();
        boolean z = true;
        if (!(accessKey.length() == 0)) {
            if (!(channel.length() == 0)) {
                if (!(bundle.length() == 0)) {
                    File rootDir = loaderConfig.getRootDir(this.app);
                    Request request = response.getRequest();
                    String sessionId = request.getSessionId();
                    String str = sessionId;
                    if (str != null && str.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        GeckoResLoader geckoResLoader = this.forest.getSessionManager().getGeckoResLoader(sessionId, accessKey, rootDir);
                        try {
                            bundlePath = geckoResLoader.getBundlePath(channel + File.separator + bundle);
                        } catch (Throwable th) {
                            try {
                                LogUtils.INSTANCE.m289e(TAG, "get file data for " + accessKey + '/' + channel + '/' + bundle + " from gecko failed", th);
                                IESGurdResData iESGurdResData2 = new IESGurdResData(new IESGurdResError(Integer.MIN_VALUE, th.getMessage(), 0, (String) null, 12, (DefaultConstructorMarker) null), IESGurdResFrom.NONE, 0L, (String) null, (InputStream) null, 28, (DefaultConstructorMarker) null);
                                geckoResLoader.release();
                                iESGurdResData = iESGurdResData2;
                            } finally {
                                geckoResLoader.release();
                            }
                        }
                        if (bundlePath != null) {
                            IESGurdResFrom iESGurdResFrom = IESGurdResFrom.OFFLINE;
                            Long channelVersion2 = channelVersion != null ? channelVersion : geckoResLoader.getChannelVersion(channel);
                            iESGurdResData = new IESGurdResData((IESGurdResError) null, iESGurdResFrom, channelVersion2 != null ? channelVersion2.longValue() : 0L, bundlePath, (InputStream) null, 17, (DefaultConstructorMarker) null);
                            callback.invoke(iESGurdResData);
                            return;
                        }
                        throw new IllegalStateException("can not get file path from gecko");
                    }
                    IESGurdResParams iESGurdResParams = new IESGurdResParams(GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG, loaderConfig.getAccessKey(), channel, bundle, false, false, rootDir.getAbsolutePath(), 48, (DefaultConstructorMarker) null);
                    if (!request.getLoadToMemory() || request.getNeedLocalFile() || request.getOnlyLocal() || request.getDisableCdn()) {
                        IESGurdKit.INSTANCE.getResPath(IESGurdResParams.copy$default(iESGurdResParams, (String) null, (String) null, (String) null, (String) null, true, false, (String) null, 111, (Object) null), callback);
                        return;
                    } else {
                        IESGurdKit.INSTANCE.getResData(iESGurdResParams, callback);
                        return;
                    }
                }
            }
        }
        callback.invoke(new IESGurdResData(new IESGurdResError(Integer.MIN_VALUE, "ak/channel/bundle is empty", 0, (String) null, 12, (DefaultConstructorMarker) null), IESGurdResFrom.NONE, 0L, (String) null, (InputStream) null, 28, (DefaultConstructorMarker) null));
    }

    public final boolean checkChannelExists(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (TextUtils.isEmpty(accessKey) || TextUtils.isEmpty(channel)) {
            return false;
        }
        return IESGurdKit.INSTANCE.checkResExistOnlyOffline(accessKey, channel);
    }
}
