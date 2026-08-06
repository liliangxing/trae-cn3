package com.bytedance.forest.model;

import android.net.Uri;
import com.bytedance.apm6.cpu.collect.ProcessCpuTracer;
import com.bytedance.forest.Forest;
import com.bytedance.forest.pollyfill.INetDepender;
import com.bytedance.forest.utils.CacheIdentifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Request.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b&\b\u0017\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B\u0099\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!\u0012\b\b\u0002\u0010#\u001a\u00020\r\u0012\b\b\u0002\u0010$\u001a\u00020\r\u0012\b\b\u0002\u0010%\u001a\u00020\r\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\b\b\u0002\u0010*\u001a\u00020\u0018\u0012\b\b\u0002\u0010+\u001a\u00020\r\u0012\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t\u0012\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.\u0012\b\b\u0002\u0010/\u001a\u00020\r\u0012\b\b\u0002\u00100\u001a\u00020\r\u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000102¢\u0006\u0002\u00103J\u0007\u0010¼\u0001\u001a\u00020\rJ\t\u0010½\u0001\u001a\u00020\u0005H\u0016R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001d\u00108\u001a\u0004\u0018\u0001098@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u001c\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001a\u0010/\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00105\"\u0004\bA\u00107R\u001a\u00100\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001a\u0010\u0016\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00105\"\u0004\bE\u00107R\u001a\u0010*\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00105\"\u0004\bS\u00107R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00105\"\u0004\bU\u00107R\u001a\u0010\u001f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u00107R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00105\"\u0004\b[\u00107R\u001a\u0010$\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00105\"\u0004\b]\u00107R \u0010^\u001a\b\u0012\u0004\u0012\u00020\u000502X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010`\"\u0004\bd\u0010bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010%\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00105\"\u0004\bt\u00107R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\bu\u0010KR(\u0010w\u001a\u0004\u0018\u00010\u00052\b\u0010v\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bx\u0010p\"\u0004\by\u0010rR\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u00105\"\u0004\bz\u00107R\u001a\u0010#\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u00105\"\u0004\b{\u00107R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010G\"\u0004\b}\u0010IR\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00105\"\u0004\b\u007f\u00107R\u001c\u0010(\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00105\"\u0005\b\u0081\u0001\u00107R \u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0080.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u00105\"\u0005\b\u0089\u0001\u00107R\u001d\u0010\u008a\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u00105\"\u0005\b\u008c\u0001\u00107R\u0015\u0010\u008d\u0001\u001a\u00030\u008e\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0012\u0010\u0004\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010pR+\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010v\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0093\u0001\u0010p\"\u0005\b\u0094\u0001\u0010rR$\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000102X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010`\"\u0005\b\u0096\u0001\u0010bR&\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0098\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001e\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R\u001e\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¡\u0001\u0010p\"\u0005\b¢\u0001\u0010rR\u001c\u0010)\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u00105\"\u0005\b¤\u0001\u00107R\u001d\u0010¥\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u00105\"\u0005\b§\u0001\u00107R \u0010¨\u0001\u001a\u00030\u008e\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010\u0090\u0001\"\u0006\bª\u0001\u0010«\u0001R'\u0010¬\u0001\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010p\"\u0005\b®\u0001\u0010rR\u001c\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u00105\"\u0005\b°\u0001\u00107R\u001c\u0010+\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u00105\"\u0005\b²\u0001\u00107R\u001d\u0010³\u0001\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u00105\"\u0005\bµ\u0001\u00107R\u001c\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u00105\"\u0005\b·\u0001\u00107R \u0010'\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001¨\u0006¾\u0001"}, d2 = {"Lcom/bytedance/forest/model/Request;", "", "request", "(Lcom/bytedance/forest/model/Request;)V", "originUrl", "", "forest", "Lcom/bytedance/forest/Forest;", "customParams", "", "geckoModel", "Lcom/bytedance/forest/model/GeckoModel;", "waitGeckoUpdate", "", "onlyLocal", "disableCdn", "disableBuiltin", "disableOffline", "disableGeckoUpdate", "loadToMemory", "useConcurrentBuffer", "allowIOOnMainThread", "checkGeckoFileAvailable", "loadRetryTimes", "", "scene", "Lcom/bytedance/forest/model/Scene;", "isASync", "groupId", "enableNegotiation", "enableMemoryCache", "enableCDNCache", "fetcherSequence", "", "Lcom/bytedance/forest/model/FetcherType;", "isPreload", "enableRequestReuse", "ignoreWaitReusedRequest", "sessionId", "webResourceRequest", "needLocalFile", "streamingLoad", "customHttpMaxAge", "useGeckoNewlyBuiltin", "injectedHttpHeaders", "cacheKeySensitiveQueries", "", "cacheKeyUASensitive", "cdnRegionRedirect", "redirectRegions", "", "(Ljava/lang/String;Lcom/bytedance/forest/Forest;Ljava/util/Map;Lcom/bytedance/forest/model/GeckoModel;ZZZZZZZZZZILcom/bytedance/forest/model/Scene;ZLjava/lang/String;ZZZLjava/util/List;ZZZLjava/lang/String;Ljava/lang/Object;ZZIZLjava/util/Map;Ljava/util/Set;ZZLjava/util/List;)V", "getAllowIOOnMainThread", "()Z", "setAllowIOOnMainThread", "(Z)V", "cacheKey", "Lcom/bytedance/forest/utils/CacheIdentifier;", "getCacheKey$forest_release", "()Lcom/bytedance/forest/utils/CacheIdentifier;", "cacheKey$delegate", "Lkotlin/Lazy;", "getCacheKeySensitiveQueries$forest_release", "()Ljava/util/Set;", "getCacheKeyUASensitive$forest_release", "setCacheKeyUASensitive$forest_release", "getCdnRegionRedirect", "setCdnRegionRedirect", "getCheckGeckoFileAvailable", "setCheckGeckoFileAvailable", "getCustomHttpMaxAge", "()I", "setCustomHttpMaxAge", "(I)V", "getCustomParams", "()Ljava/util/Map;", "setCustomParams", "(Ljava/util/Map;)V", "getDisableBuiltin", "setDisableBuiltin", "getDisableCdn", "setDisableCdn", "getDisableGeckoUpdate", "setDisableGeckoUpdate", "getDisableOffline", "setDisableOffline", "getEnableCDNCache", "setEnableCDNCache", "getEnableMemoryCache", "setEnableMemoryCache", "getEnableNegotiation", "setEnableNegotiation", "getEnableRequestReuse", "setEnableRequestReuse", "fallbackDomains", "getFallbackDomains", "()Ljava/util/List;", "setFallbackDomains", "(Ljava/util/List;)V", "getFetcherSequence", "setFetcherSequence", "getForest", "()Lcom/bytedance/forest/Forest;", "getGeckoModel", "()Lcom/bytedance/forest/model/GeckoModel;", "geckoSource", "Lcom/bytedance/forest/model/GeckoSource;", "getGeckoSource", "()Lcom/bytedance/forest/model/GeckoSource;", "setGeckoSource", "(Lcom/bytedance/forest/model/GeckoSource;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getIgnoreWaitReusedRequest", "setIgnoreWaitReusedRequest", "getInjectedHttpHeaders", "value", "injectedUserAgent", "getInjectedUserAgent", "setInjectedUserAgent", "setASync", "setPreload", "getLoadRetryTimes", "setLoadRetryTimes", "getLoadToMemory", "setLoadToMemory", "getNeedLocalFile", "setNeedLocalFile", "netDepender", "Lcom/bytedance/forest/pollyfill/INetDepender;", "getNetDepender$forest_release", "()Lcom/bytedance/forest/pollyfill/INetDepender;", "setNetDepender$forest_release", "(Lcom/bytedance/forest/pollyfill/INetDepender;)V", "getOnlyLocal", "setOnlyLocal", "onlyOnline", "getOnlyOnline", "setOnlyOnline", "originUri", "Landroid/net/Uri;", "getOriginUri", "()Landroid/net/Uri;", "getOriginUrl", "preloadFrom", "getPreloadFrom", "setPreloadFrom", "getRedirectRegions", "setRedirectRegions", "remainedFallbackDomains", "Ljava/util/LinkedList;", "getRemainedFallbackDomains$forest_release", "()Ljava/util/LinkedList;", "setRemainedFallbackDomains$forest_release", "(Ljava/util/LinkedList;)V", "getScene", "()Lcom/bytedance/forest/model/Scene;", "setScene", "(Lcom/bytedance/forest/model/Scene;)V", "getSessionId", "setSessionId", "getStreamingLoad", "setStreamingLoad", "supportShuffle", "getSupportShuffle", "setSupportShuffle", "uri", "getUri$forest_release", "setUri$forest_release", "(Landroid/net/Uri;)V", "url", "getUrl", "setUrl", "getUseConcurrentBuffer", "setUseConcurrentBuffer", "getUseGeckoNewlyBuiltin", "setUseGeckoNewlyBuiltin", "useInteraction", "getUseInteraction", "setUseInteraction", "getWaitGeckoUpdate", "setWaitGeckoUpdate", "getWebResourceRequest", "()Ljava/lang/Object;", "setWebResourceRequest", "(Ljava/lang/Object;)V", "isWebRequest", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Request {
    private boolean allowIOOnMainThread;

    /* renamed from: cacheKey$delegate, reason: from kotlin metadata */
    private final Lazy cacheKey;
    private final Set<String> cacheKeySensitiveQueries;
    private boolean cacheKeyUASensitive;
    private boolean cdnRegionRedirect;
    private boolean checkGeckoFileAvailable;
    private int customHttpMaxAge;
    private Map<String, Object> customParams;
    private boolean disableBuiltin;
    private boolean disableCdn;
    private boolean disableGeckoUpdate;
    private boolean disableOffline;
    private boolean enableCDNCache;
    private boolean enableMemoryCache;
    private boolean enableNegotiation;
    private boolean enableRequestReuse;
    private List<String> fallbackDomains;
    private List<FetcherType> fetcherSequence;
    private final Forest forest;
    private final GeckoModel geckoModel;
    private GeckoSource geckoSource;
    private String groupId;
    private boolean ignoreWaitReusedRequest;

    /* renamed from: injectedHttpHeaders, reason: from kotlin metadata and from toString */
    private final Map<String, String> requestHeaders;
    private boolean isASync;
    private boolean isPreload;
    private int loadRetryTimes;
    private boolean loadToMemory;
    private boolean needLocalFile;
    public INetDepender netDepender;
    private boolean onlyLocal;
    private boolean onlyOnline;
    private final Uri originUri;
    private final String originUrl;
    private List<String> redirectRegions;
    private LinkedList<String> remainedFallbackDomains;
    private Scene scene;
    private String sessionId;
    private boolean streamingLoad;
    private boolean supportShuffle;
    private Uri uri;
    private String url;

    /* renamed from: useConcurrentBuffer, reason: from kotlin metadata and from toString */
    private boolean ioConcurrency;
    private boolean useGeckoNewlyBuiltin;
    private boolean useInteraction;
    private boolean waitGeckoUpdate;
    private Object webResourceRequest;

    public final CacheIdentifier getCacheKey$forest_release() {
        return (CacheIdentifier) this.cacheKey.getValue();
    }

    public Request(String str, Forest forest, Map<String, Object> map, GeckoModel geckoModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Scene scene, boolean z11, String str2, boolean z12, boolean z13, boolean z14, List<FetcherType> list, boolean z15, boolean z16, boolean z17, String str3, Object obj, boolean z18, boolean z19, int i2, boolean z20, Map<String, String> map2, Set<String> set, boolean z21, boolean z22, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(str, "originUrl");
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(map, "customParams");
        Intrinsics.checkParameterIsNotNull(geckoModel, "geckoModel");
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(str2, "groupId");
        Intrinsics.checkParameterIsNotNull(list, "fetcherSequence");
        Intrinsics.checkParameterIsNotNull(map2, "injectedHttpHeaders");
        this.originUrl = str;
        this.forest = forest;
        this.customParams = map;
        this.geckoModel = geckoModel;
        this.waitGeckoUpdate = z;
        this.onlyLocal = z2;
        this.disableCdn = z3;
        this.disableBuiltin = z4;
        this.disableOffline = z5;
        this.disableGeckoUpdate = z6;
        this.loadToMemory = z7;
        this.ioConcurrency = z8;
        this.allowIOOnMainThread = z9;
        this.checkGeckoFileAvailable = z10;
        this.loadRetryTimes = i;
        this.scene = scene;
        this.isASync = z11;
        this.groupId = str2;
        this.enableNegotiation = z12;
        this.enableMemoryCache = z13;
        this.enableCDNCache = z14;
        this.fetcherSequence = list;
        this.isPreload = z15;
        this.enableRequestReuse = z16;
        this.ignoreWaitReusedRequest = z17;
        this.sessionId = str3;
        this.webResourceRequest = obj;
        this.needLocalFile = z18;
        this.streamingLoad = z19;
        this.customHttpMaxAge = i2;
        this.useGeckoNewlyBuiltin = z20;
        this.requestHeaders = map2;
        this.cacheKeySensitiveQueries = set;
        this.cacheKeyUASensitive = z21;
        this.cdnRegionRedirect = z22;
        this.redirectRegions = list2;
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(originUrl)");
        this.originUri = parse;
        this.geckoSource = GeckoSource.CLIENT_CONFIG;
        this.fallbackDomains = CollectionsKt.emptyList();
        this.remainedFallbackDomains = new LinkedList<>();
        this.url = str;
        this.uri = parse;
        this.cacheKey = LazyKt.lazy(new Function0<CacheIdentifier>() { // from class: com.bytedance.forest.model.Request$cacheKey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final CacheIdentifier m493invoke() {
                return CacheIdentifier.INSTANCE.obtain(Request.this);
            }
        });
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final Forest getForest() {
        return this.forest;
    }

    public final Map<String, Object> getCustomParams() {
        return this.customParams;
    }

    public final void setCustomParams(Map<String, Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.customParams = map;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Request(String str, Forest forest, Map map, GeckoModel geckoModel, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, Scene scene, boolean z11, String str2, boolean z12, boolean z13, boolean z14, List list, boolean z15, boolean z16, boolean z17, String str3, Object obj, boolean z18, boolean z19, int i2, boolean z20, Map map2, Set set, boolean z21, boolean z22, List list2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, forest, map, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);
        String str4;
        Set set2;
        List list3;
        GeckoModel geckoModel2 = (i3 & 8) != 0 ? new GeckoModel("", "", "") : geckoModel;
        boolean z23 = (i3 & 16) != 0 ? false : z;
        boolean z24 = (i3 & 32) != 0 ? false : z2;
        boolean z25 = (i3 & 64) != 0 ? false : z3;
        boolean z26 = (i3 & 128) != 0 ? false : z4;
        boolean z27 = (i3 & 256) != 0 ? false : z5;
        boolean z28 = (i3 & 512) != 0 ? false : z6;
        boolean z29 = (i3 & 1024) != 0 ? false : z7;
        boolean z30 = (i3 & 2048) != 0 ? false : z8;
        boolean z31 = (i3 & 4096) != 0 ? false : z9;
        boolean z32 = (i3 & 8192) != 0 ? true : z10;
        int i5 = (i3 & ProcessCpuTracer.PROC_OUT_FLOAT) != 0 ? 0 : i;
        Scene scene2 = (32768 & i3) != 0 ? Scene.OTHER : scene;
        boolean z33 = (65536 & i3) != 0 ? false : z11;
        String str5 = (131072 & i3) != 0 ? "" : str2;
        boolean z34 = (262144 & i3) != 0 ? false : z12;
        boolean enable_mem_cache = (524288 & i3) != 0 ? DefaultConfig.INSTANCE.getENABLE_MEM_CACHE() : z13;
        boolean enable_cdn_cache = (1048576 & i3) != 0 ? DefaultConfig.INSTANCE.getENABLE_CDN_CACHE() : z14;
        List arrayList = (2097152 & i3) != 0 ? new ArrayList() : list;
        boolean z35 = (4194304 & i3) != 0 ? false : z15;
        boolean z36 = (8388608 & i3) != 0 ? false : z16;
        boolean z37 = (16777216 & i3) != 0 ? false : z17;
        if ((33554432 & i3) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        Object obj2 = (67108864 & i3) != 0 ? null : obj;
        boolean z38 = (134217728 & i3) != 0 ? false : z18;
        boolean z39 = (268435456 & i3) != 0 ? false : z19;
        int i6 = (536870912 & i3) != 0 ? 0 : i2;
        boolean z40 = (1073741824 & i3) != 0 ? false : z20;
        Map linkedHashMap = (i3 & Integer.MIN_VALUE) != 0 ? new LinkedHashMap() : map2;
        if ((i4 & 1) != 0) {
            set2 = null;
        } else {
            set2 = set;
        }
        boolean z41 = (i4 & 2) != 0 ? false : z21;
        boolean z42 = (i4 & 4) != 0 ? false : z22;
        if ((i4 & 8) != 0) {
            list3 = null;
        } else {
            list3 = list2;
        }
    }

    public final GeckoModel getGeckoModel() {
        return this.geckoModel;
    }

    public final boolean getWaitGeckoUpdate() {
        return this.waitGeckoUpdate;
    }

    public final void setWaitGeckoUpdate(boolean z) {
        this.waitGeckoUpdate = z;
    }

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final void setOnlyLocal(boolean z) {
        this.onlyLocal = z;
    }

    public final boolean getDisableCdn() {
        return this.disableCdn;
    }

    public final void setDisableCdn(boolean z) {
        this.disableCdn = z;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final void setDisableBuiltin(boolean z) {
        this.disableBuiltin = z;
    }

    public final boolean getDisableOffline() {
        return this.disableOffline;
    }

    public final void setDisableOffline(boolean z) {
        this.disableOffline = z;
    }

    public final boolean getDisableGeckoUpdate() {
        return this.disableGeckoUpdate;
    }

    public final void setDisableGeckoUpdate(boolean z) {
        this.disableGeckoUpdate = z;
    }

    public final boolean getLoadToMemory() {
        return this.loadToMemory;
    }

    public final void setLoadToMemory(boolean z) {
        this.loadToMemory = z;
    }

    /* renamed from: getUseConcurrentBuffer, reason: from getter */
    public final boolean getIoConcurrency() {
        return this.ioConcurrency;
    }

    public final void setUseConcurrentBuffer(boolean z) {
        this.ioConcurrency = z;
    }

    public final boolean getAllowIOOnMainThread() {
        return this.allowIOOnMainThread;
    }

    public final void setAllowIOOnMainThread(boolean z) {
        this.allowIOOnMainThread = z;
    }

    public final boolean getCheckGeckoFileAvailable() {
        return this.checkGeckoFileAvailable;
    }

    public final void setCheckGeckoFileAvailable(boolean z) {
        this.checkGeckoFileAvailable = z;
    }

    public final int getLoadRetryTimes() {
        return this.loadRetryTimes;
    }

    public final void setLoadRetryTimes(int i) {
        this.loadRetryTimes = i;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final void setScene(Scene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "<set-?>");
        this.scene = scene;
    }

    /* renamed from: isASync, reason: from getter */
    public final boolean getIsASync() {
        return this.isASync;
    }

    public final void setASync(boolean z) {
        this.isASync = z;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.groupId = str;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final void setEnableNegotiation(boolean z) {
        this.enableNegotiation = z;
    }

    public final boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public final void setEnableMemoryCache(boolean z) {
        this.enableMemoryCache = z;
    }

    public final boolean getEnableCDNCache() {
        return this.enableCDNCache;
    }

    public final void setEnableCDNCache(boolean z) {
        this.enableCDNCache = z;
    }

    public final List<FetcherType> getFetcherSequence() {
        return this.fetcherSequence;
    }

    public final void setFetcherSequence(List<FetcherType> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.fetcherSequence = list;
    }

    /* renamed from: isPreload, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    public final void setPreload(boolean z) {
        this.isPreload = z;
    }

    public final boolean getEnableRequestReuse() {
        return this.enableRequestReuse;
    }

    public final void setEnableRequestReuse(boolean z) {
        this.enableRequestReuse = z;
    }

    public final boolean getIgnoreWaitReusedRequest() {
        return this.ignoreWaitReusedRequest;
    }

    public final void setIgnoreWaitReusedRequest(boolean z) {
        this.ignoreWaitReusedRequest = z;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    public final Object getWebResourceRequest() {
        return this.webResourceRequest;
    }

    public final void setWebResourceRequest(Object obj) {
        this.webResourceRequest = obj;
    }

    public final boolean getNeedLocalFile() {
        return this.needLocalFile;
    }

    public final void setNeedLocalFile(boolean z) {
        this.needLocalFile = z;
    }

    public final boolean getStreamingLoad() {
        return this.streamingLoad;
    }

    public final void setStreamingLoad(boolean z) {
        this.streamingLoad = z;
    }

    public final int getCustomHttpMaxAge() {
        return this.customHttpMaxAge;
    }

    public final void setCustomHttpMaxAge(int i) {
        this.customHttpMaxAge = i;
    }

    public final boolean getUseGeckoNewlyBuiltin() {
        return this.useGeckoNewlyBuiltin;
    }

    public final void setUseGeckoNewlyBuiltin(boolean z) {
        this.useGeckoNewlyBuiltin = z;
    }

    public final Map<String, String> getInjectedHttpHeaders() {
        return this.requestHeaders;
    }

    public final Set<String> getCacheKeySensitiveQueries$forest_release() {
        return this.cacheKeySensitiveQueries;
    }

    /* renamed from: getCacheKeyUASensitive$forest_release, reason: from getter */
    public final boolean getCacheKeyUASensitive() {
        return this.cacheKeyUASensitive;
    }

    public final void setCacheKeyUASensitive$forest_release(boolean z) {
        this.cacheKeyUASensitive = z;
    }

    public final boolean getCdnRegionRedirect() {
        return this.cdnRegionRedirect;
    }

    public final void setCdnRegionRedirect(boolean z) {
        this.cdnRegionRedirect = z;
    }

    public final List<String> getRedirectRegions() {
        return this.redirectRegions;
    }

    public final void setRedirectRegions(List<String> list) {
        this.redirectRegions = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Request(Request request) {
        this(request.originUrl, request.forest, request.customParams, request.geckoModel, request.waitGeckoUpdate, request.onlyLocal, request.disableCdn, request.disableBuiltin, request.disableOffline, request.disableGeckoUpdate, request.loadToMemory, request.ioConcurrency, request.allowIOOnMainThread, request.checkGeckoFileAvailable, request.loadRetryTimes, request.scene, request.isASync, request.groupId, request.enableNegotiation, request.enableMemoryCache, request.enableCDNCache, request.fetcherSequence, request.isPreload, request.enableRequestReuse, request.ignoreWaitReusedRequest, request.sessionId, request.webResourceRequest, request.needLocalFile, request.streamingLoad, request.customHttpMaxAge, request.useGeckoNewlyBuiltin, request.requestHeaders, request.cacheKeySensitiveQueries, request.cacheKeyUASensitive, request.cdnRegionRedirect, request.redirectRegions);
        Intrinsics.checkParameterIsNotNull(request, "request");
        this.geckoSource = request.geckoSource;
        this.useInteraction = request.useInteraction;
        this.onlyOnline = request.onlyOnline;
        INetDepender iNetDepender = request.netDepender;
        if (iNetDepender == null) {
            Intrinsics.throwUninitializedPropertyAccessException("netDepender");
        }
        this.netDepender = iNetDepender;
        this.fallbackDomains = request.fallbackDomains;
        this.supportShuffle = request.supportShuffle;
        this.remainedFallbackDomains.addAll(request.remainedFallbackDomains);
    }

    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final GeckoSource getGeckoSource() {
        return this.geckoSource;
    }

    public final void setGeckoSource(GeckoSource geckoSource) {
        Intrinsics.checkParameterIsNotNull(geckoSource, "<set-?>");
        this.geckoSource = geckoSource;
    }

    public final boolean getUseInteraction() {
        return this.useInteraction;
    }

    public final void setUseInteraction(boolean z) {
        this.useInteraction = z;
    }

    public final boolean getOnlyOnline() {
        return this.onlyOnline;
    }

    public final void setOnlyOnline(boolean z) {
        this.onlyOnline = z;
    }

    public final INetDepender getNetDepender$forest_release() {
        INetDepender iNetDepender = this.netDepender;
        if (iNetDepender == null) {
            Intrinsics.throwUninitializedPropertyAccessException("netDepender");
        }
        return iNetDepender;
    }

    public final void setNetDepender$forest_release(INetDepender iNetDepender) {
        Intrinsics.checkParameterIsNotNull(iNetDepender, "<set-?>");
        this.netDepender = iNetDepender;
    }

    public final List<String> getFallbackDomains() {
        return this.fallbackDomains;
    }

    public final void setFallbackDomains(List<String> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.fallbackDomains = list;
    }

    public final boolean getSupportShuffle() {
        return this.supportShuffle;
    }

    public final void setSupportShuffle(boolean z) {
        this.supportShuffle = z;
    }

    public final LinkedList<String> getRemainedFallbackDomains$forest_release() {
        return this.remainedFallbackDomains;
    }

    public final void setRemainedFallbackDomains$forest_release(LinkedList<String> linkedList) {
        Intrinsics.checkParameterIsNotNull(linkedList, "<set-?>");
        this.remainedFallbackDomains = linkedList;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        if (Intrinsics.areEqual(this.url, str)) {
            return;
        }
        this.url = str;
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(value)");
        this.uri = parse;
    }

    /* renamed from: getUri$forest_release, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri$forest_release(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "<set-?>");
        this.uri = uri;
    }

    public String toString() {
        return super.toString() + "(geckoModel=" + this.geckoModel + ", waitGeckoUpdate=" + this.waitGeckoUpdate + ", disableGeckoUpdate=" + this.disableGeckoUpdate + ",  onlyLocal=" + this.onlyLocal + ", disableCdn=" + this.disableCdn + ", disableBuiltin=" + this.disableBuiltin + ", disableOffline=" + this.disableOffline + ", loadToMemory=" + this.loadToMemory + ", ioConcurrency=" + this.ioConcurrency + ", allowIOOnMainThread=" + this.allowIOOnMainThread + ", checkGeckoFileAvailable=" + this.checkGeckoFileAvailable + ", loadRetryTimes=" + this.loadRetryTimes + ", scene=" + this.scene + ", isASync=" + this.isASync + ", groupId='" + this.groupId + "', enableNegotiation=" + this.enableNegotiation + ", enableMemoryCache=" + this.enableMemoryCache + ", enableCDNCache=" + this.enableCDNCache + ", fetcherSequence=" + this.fetcherSequence + ", isPreload=" + this.isPreload + ", enableRequestReuse=" + this.enableRequestReuse + ", ignoreWaitReusedRequest=" + this.ignoreWaitReusedRequest + ",sessionId=" + this.sessionId + ", geckoSource=" + this.geckoSource + ", useInteraction=" + this.useInteraction + ", onlyOnline=" + this.onlyOnline + ", customHttpMaxAge=" + this.customHttpMaxAge + ", useGeckoNewlyBuiltin=" + this.useGeckoNewlyBuiltin + ", requestHeaders=" + this.requestHeaders + ", cacheKeyUASensitive=" + this.cacheKeyUASensitive + ", cacheKeySensitiveQueries=" + this.cacheKeySensitiveQueries + " originUrl='" + this.originUrl + "', customParams=" + this.customParams + ')';
    }

    public final boolean isWebRequest() {
        return this.webResourceRequest != null || this.scene == Scene.WEB_CHILD_RESOURCE || this.scene == Scene.WEB_MAIN_DOCUMENT;
    }

    public final void setPreloadFrom(String str) {
        if (str == null) {
            str = "";
        }
        this.customParams.put("x-forest-preload-from", str);
    }

    public final String getPreloadFrom() {
        Object obj = this.customParams.get("x-forest-preload-from");
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }

    public final void setInjectedUserAgent(String str) {
        if (str == null) {
            str = "";
        }
        this.customParams.put("x-forest-injected-ua", str);
    }

    public final String getInjectedUserAgent() {
        Object obj = this.customParams.get("x-forest-injected-ua");
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }
}
