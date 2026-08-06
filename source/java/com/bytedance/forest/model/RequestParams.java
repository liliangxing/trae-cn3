package com.bytedance.forest.model;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.pollyfill.NetWorker;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\"\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b \n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000eR\u001a\u0010&\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R'\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u001a\u00105\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013R\u001a\u0010;\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0011\"\u0004\b@\u0010\u0013R\u001e\u0010A\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010G\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u001e\u0010J\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bK\u0010C\"\u0004\bL\u0010ER\u001a\u0010M\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R \u0010P\u001a\b\u0012\u0004\u0012\u00020R0QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR\u001a\u0010Z\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0011\"\u0004\b\\\u0010\u0013R\u001d\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n00¢\u0006\b\n\u0000\u001a\u0004\b^\u00102R(\u0010`\u001a\u0004\u0018\u00010\n2\b\u0010_\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R\u001a\u0010e\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010,\"\u0004\bg\u0010.R\u001a\u0010h\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0011\"\u0004\bj\u0010\u0013R\u001a\u0010k\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0011\"\u0004\bm\u0010\u0013R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0011\"\u0004\bv\u0010\u0013R\u001a\u0010w\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0011\"\u0004\by\u0010\u0013R\"\u0010z\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010QX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010T\"\u0004\b|\u0010VR(\u0010}\u001a\u0004\u0018\u00010\n2\b\u0010_\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b~\u0010\f\"\u0004\b\u007f\u0010\u000eR%\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010QX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010T\"\u0005\b\u0082\u0001\u0010VR\u001d\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0005\b\u0085\u0001\u0010\bR\u001f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR\u001d\u0010\u0089\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0011\"\u0005\b\u008b\u0001\u0010\u0013R\u001d\u0010\u008c\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0011\"\u0005\b\u008e\u0001\u0010\u0013R\u001d\u0010\u008f\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0011\"\u0005\b\u0091\u0001\u0010\u0013R\u001d\u0010\u0092\u0001\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0011\"\u0005\b\u0094\u0001\u0010\u0013R\"\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/bytedance/forest/model/RequestParams;", "", "origin", "isPreload", "", "(Lcom/bytedance/forest/model/RequestParams;Z)V", "resourceScene", "Lcom/bytedance/forest/model/Scene;", "(Lcom/bytedance/forest/model/Scene;)V", "accessKey", "", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "(Ljava/lang/String;)V", "allowIOOnMainThread", "getAllowIOOnMainThread", "()Z", "setAllowIOOnMainThread", "(Z)V", "bundle", "getBundle", "setBundle", "cacheKeySensitiveQueries", "", "getCacheKeySensitiveQueries", "()Ljava/util/Set;", "setCacheKeySensitiveQueries", "(Ljava/util/Set;)V", "cacheKeyUASensitive", "getCacheKeyUASensitive", "setCacheKeyUASensitive", "cdnRegionRedirect", "getCdnRegionRedirect", "setCdnRegionRedirect", "channel", "getChannel", "setChannel", "checkGeckoFileAvailable", "getCheckGeckoFileAvailable", "setCheckGeckoFileAvailable", "customHttpMaxAge", "", "getCustomHttpMaxAge", "()I", "setCustomHttpMaxAge", "(I)V", "customParams", "", "getCustomParams", "()Ljava/util/Map;", "customParams$delegate", "Lkotlin/Lazy;", "disableBuiltin", "getDisableBuiltin", "setDisableBuiltin", "disableCdn", "getDisableCdn", "setDisableCdn", "disableGeckoUpdate", "getDisableGeckoUpdate", "setDisableGeckoUpdate", "disableOffline", "getDisableOffline", "setDisableOffline", "enableCDNCache", "getEnableCDNCache", "()Ljava/lang/Boolean;", "setEnableCDNCache", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableMemoryCache", "getEnableMemoryCache", "setEnableMemoryCache", "enableNegotiation", "getEnableNegotiation", "setEnableNegotiation", "enableRequestReuse", "getEnableRequestReuse", "setEnableRequestReuse", "fetcherSequence", "", "Lcom/bytedance/forest/model/FetcherType;", "getFetcherSequence", "()Ljava/util/List;", "setFetcherSequence", "(Ljava/util/List;)V", "groupId", "getGroupId", "setGroupId", "ignoreWaitReusedRequest", "getIgnoreWaitReusedRequest", "setIgnoreWaitReusedRequest", "injectedHttpHeaders", "getInjectedHttpHeaders", "value", "injectedUserAgent", "getInjectedUserAgent", "setInjectedUserAgent", "isPreload$forest_release", "setPreload$forest_release", "loadRetryTimes", "getLoadRetryTimes", "setLoadRetryTimes", "loadToMemory", "getLoadToMemory", "setLoadToMemory", "needLocalFile", "getNeedLocalFile", "setNeedLocalFile", "netWorker", "Lcom/bytedance/forest/pollyfill/NetWorker;", "getNetWorker", "()Lcom/bytedance/forest/pollyfill/NetWorker;", "setNetWorker", "(Lcom/bytedance/forest/pollyfill/NetWorker;)V", "onlyLocal", "getOnlyLocal", "setOnlyLocal", "onlyOnline", "getOnlyOnline", "setOnlyOnline", "prefixList", "getPrefixList", "setPrefixList", "preloadFrom", "getPreloadFrom", "setPreloadFrom", "redirectRegions", "getRedirectRegions", "setRedirectRegions", "getResourceScene", "()Lcom/bytedance/forest/model/Scene;", "setResourceScene", "sessionId", "getSessionId", "setSessionId", "streamingLoad", "getStreamingLoad", "setStreamingLoad", "useConcurrentBuffer", "getUseConcurrentBuffer", "setUseConcurrentBuffer", "useGeckoNewlyBuiltin", "getUseGeckoNewlyBuiltin", "setUseGeckoNewlyBuiltin", "waitGeckoUpdate", "getWaitGeckoUpdate", "setWaitGeckoUpdate", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "getWebResourceRequest", "()Landroid/webkit/WebResourceRequest;", "setWebResourceRequest", "(Landroid/webkit/WebResourceRequest;)V", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RequestParams {
    private String accessKey;
    private boolean allowIOOnMainThread;
    private String bundle;
    private Set<String> cacheKeySensitiveQueries;
    private boolean cacheKeyUASensitive;
    private boolean cdnRegionRedirect;
    private String channel;
    private boolean checkGeckoFileAvailable;
    private int customHttpMaxAge;

    /* renamed from: customParams$delegate, reason: from kotlin metadata */
    private final Lazy customParams;
    private boolean disableBuiltin;
    private boolean disableCdn;
    private boolean disableGeckoUpdate;
    private boolean disableOffline;
    private Boolean enableCDNCache;
    private Boolean enableMemoryCache;
    private Boolean enableNegotiation;
    private boolean enableRequestReuse;
    private List<? extends FetcherType> fetcherSequence;
    private String groupId;
    private boolean ignoreWaitReusedRequest;
    private final Map<String, String> injectedHttpHeaders;
    private boolean isPreload;
    private int loadRetryTimes;
    private boolean loadToMemory;
    private boolean needLocalFile;
    private NetWorker netWorker;
    private boolean onlyLocal;
    private boolean onlyOnline;
    private List<String> prefixList;
    private List<String> redirectRegions;
    private Scene resourceScene;
    private String sessionId;
    private boolean streamingLoad;
    private boolean useConcurrentBuffer;
    private boolean useGeckoNewlyBuiltin;
    private boolean waitGeckoUpdate;
    private WebResourceRequest webResourceRequest;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RequestParams() {
        this(r0, 1, r0);
        Scene scene = null;
    }

    public final Map<String, Object> getCustomParams() {
        return (Map) this.customParams.getValue();
    }

    public RequestParams(Scene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "resourceScene");
        this.resourceScene = scene;
        this.fetcherSequence = DefaultConfig.INSTANCE.getFETCHER_SEQUENCE();
        this.accessKey = "";
        this.checkGeckoFileAvailable = true;
        this.groupId = "";
        this.customParams = LazyKt.lazy(new Function0<ConcurrentHashMap<String, Object>>() { // from class: com.bytedance.forest.model.RequestParams$customParams$2
            public final ConcurrentHashMap<String, Object> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.injectedHttpHeaders = new LinkedHashMap();
    }

    public /* synthetic */ RequestParams(Scene scene, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Scene.OTHER : scene);
    }

    public final Scene getResourceScene() {
        return this.resourceScene;
    }

    public final void setResourceScene(Scene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "<set-?>");
        this.resourceScene = scene;
    }

    public /* synthetic */ RequestParams(RequestParams requestParams, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestParams, (i & 2) != 0 ? requestParams.isPreload : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RequestParams(RequestParams requestParams, boolean z) {
        this(requestParams.resourceScene);
        Intrinsics.checkParameterIsNotNull(requestParams, "origin");
        this.fetcherSequence = requestParams.fetcherSequence;
        this.accessKey = requestParams.accessKey;
        this.channel = requestParams.channel;
        this.bundle = requestParams.bundle;
        this.prefixList = requestParams.prefixList;
        this.waitGeckoUpdate = requestParams.waitGeckoUpdate;
        this.loadToMemory = requestParams.loadToMemory;
        this.useConcurrentBuffer = requestParams.useConcurrentBuffer;
        this.allowIOOnMainThread = requestParams.allowIOOnMainThread;
        this.checkGeckoFileAvailable = requestParams.checkGeckoFileAvailable;
        this.disableCdn = requestParams.disableCdn;
        this.disableBuiltin = requestParams.disableBuiltin;
        this.disableOffline = requestParams.disableOffline;
        this.disableGeckoUpdate = requestParams.disableGeckoUpdate;
        this.onlyLocal = requestParams.onlyLocal;
        this.onlyOnline = requestParams.onlyOnline;
        this.needLocalFile = requestParams.needLocalFile;
        this.loadRetryTimes = requestParams.loadRetryTimes;
        this.enableNegotiation = requestParams.enableNegotiation;
        this.enableMemoryCache = requestParams.enableMemoryCache;
        this.enableCDNCache = requestParams.enableCDNCache;
        this.groupId = requestParams.groupId;
        this.sessionId = requestParams.sessionId;
        getCustomParams().putAll(requestParams.getCustomParams());
        this.enableRequestReuse = requestParams.enableRequestReuse;
        this.ignoreWaitReusedRequest = requestParams.ignoreWaitReusedRequest;
        this.webResourceRequest = requestParams.webResourceRequest;
        this.netWorker = requestParams.netWorker;
        this.streamingLoad = requestParams.streamingLoad;
        this.customHttpMaxAge = requestParams.customHttpMaxAge;
        this.useGeckoNewlyBuiltin = requestParams.useGeckoNewlyBuiltin;
        this.isPreload = z;
        this.injectedHttpHeaders.putAll(requestParams.injectedHttpHeaders);
        this.cacheKeySensitiveQueries = requestParams.cacheKeySensitiveQueries;
        this.cacheKeyUASensitive = requestParams.cacheKeyUASensitive;
    }

    public final List<FetcherType> getFetcherSequence() {
        return this.fetcherSequence;
    }

    public final void setFetcherSequence(List<? extends FetcherType> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.fetcherSequence = list;
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.accessKey = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        this.channel = str;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final void setBundle(String str) {
        this.bundle = str;
    }

    public final List<String> getPrefixList() {
        return this.prefixList;
    }

    public final void setPrefixList(List<String> list) {
        this.prefixList = list;
    }

    public final boolean getWaitGeckoUpdate() {
        return this.waitGeckoUpdate;
    }

    public final void setWaitGeckoUpdate(boolean z) {
        this.waitGeckoUpdate = z;
    }

    public final boolean getLoadToMemory() {
        return this.loadToMemory;
    }

    public final void setLoadToMemory(boolean z) {
        this.loadToMemory = z;
    }

    public final boolean getUseConcurrentBuffer() {
        return this.useConcurrentBuffer;
    }

    public final void setUseConcurrentBuffer(boolean z) {
        this.useConcurrentBuffer = z;
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

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final void setOnlyLocal(boolean z) {
        this.onlyLocal = z;
    }

    public final boolean getOnlyOnline() {
        return this.onlyOnline;
    }

    public final void setOnlyOnline(boolean z) {
        this.onlyOnline = z;
    }

    public final boolean getNeedLocalFile() {
        return this.needLocalFile;
    }

    public final void setNeedLocalFile(boolean z) {
        this.needLocalFile = z;
    }

    public final int getLoadRetryTimes() {
        return this.loadRetryTimes;
    }

    public final void setLoadRetryTimes(int i) {
        this.loadRetryTimes = i;
    }

    public final Boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final void setEnableNegotiation(Boolean bool) {
        this.enableNegotiation = bool;
    }

    public final Boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public final void setEnableMemoryCache(Boolean bool) {
        this.enableMemoryCache = bool;
    }

    public final Boolean getEnableCDNCache() {
        return this.enableCDNCache;
    }

    public final void setEnableCDNCache(Boolean bool) {
        this.enableCDNCache = bool;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.groupId = str;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        this.sessionId = str;
    }

    /* renamed from: isPreload$forest_release, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    public final void setPreload$forest_release(boolean z) {
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

    public final WebResourceRequest getWebResourceRequest() {
        return this.webResourceRequest;
    }

    public final void setWebResourceRequest(WebResourceRequest webResourceRequest) {
        this.webResourceRequest = webResourceRequest;
    }

    public final NetWorker getNetWorker() {
        return this.netWorker;
    }

    public final void setNetWorker(NetWorker netWorker) {
        this.netWorker = netWorker;
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
        return this.injectedHttpHeaders;
    }

    public final Set<String> getCacheKeySensitiveQueries() {
        return this.cacheKeySensitiveQueries;
    }

    public final void setCacheKeySensitiveQueries(Set<String> set) {
        this.cacheKeySensitiveQueries = set;
    }

    public final boolean getCacheKeyUASensitive() {
        return this.cacheKeyUASensitive;
    }

    public final void setCacheKeyUASensitive(boolean z) {
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

    public final void setPreloadFrom(String str) {
        if (str == null) {
            str = "";
        }
        getCustomParams().put("x-forest-preload-from", str);
    }

    public final String getPreloadFrom() {
        Object obj = getCustomParams().get("x-forest-preload-from");
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }

    public final void setInjectedUserAgent(String str) {
        if (str == null) {
            str = "";
        }
        getCustomParams().put("x-forest-injected-ua", str);
    }

    public final String getInjectedUserAgent() {
        Object obj = getCustomParams().get("x-forest-injected-ua");
        if (!(obj instanceof String)) {
            obj = null;
        }
        return (String) obj;
    }
}
