package com.bytedance.ies.bullet.service.base.resourceloader.config;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.model.URIQueryParamKeys;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: TaskConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020\u0000H\u0016J\t\u0010\u0090\u0001\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u0004R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001a\u0010'\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0011\"\u0004\b)\u0010\u0013R\u001c\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\u0004R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\u0004R \u00100\u001a\b\u0012\u0004\u0012\u00020\u000301X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\u0004R(\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\u0004R\u001a\u0010B\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013R\u001a\u0010D\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0011\"\u0004\bE\u0010\u0013R\u001a\u0010F\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0011\"\u0004\bS\u0010\u0013R\u001a\u0010T\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010H\"\u0004\b\\\u0010JR\u001a\u0010]\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\u0004R\u001a\u0010`\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0011\"\u0004\bb\u0010\u0013R\u001a\u0010c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\u0004R\u001a\u0010f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0011\"\u0004\bh\u0010\u0013R\u001a\u0010i\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\u0004R\u001a\u0010l\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\u0004R\u001a\u0010o\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010H\"\u0004\bq\u0010JR \u0010r\u001a\b\u0012\u0004\u0012\u00020\u00030sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u00103\"\u0004\bu\u00105R\u001c\u0010v\u001a\u0004\u0018\u00010wX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001a\u0010|\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0011\"\u0004\b~\u0010\u0013R\u001c\u0010\u007f\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0011\"\u0005\b\u0081\u0001\u0010\u0013R\u001d\u0010\u0082\u0001\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0011\"\u0005\b\u0084\u0001\u0010\u0013R\u001d\u0010\u0085\u0001\u001a\u00020\u001bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010H\"\u0005\b\u0087\u0001\u0010JR\"\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "", "accessKey", "", "(Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "setAccessKey", "bid", "getBid", "setBid", "bundle", "getBundle", "setBundle", "cdnNoCache", "", "getCdnNoCache", "()Z", "setCdnNoCache", "(Z)V", "cdnUrl", "getCdnUrl", "setCdnUrl", "channel", "getChannel", "setChannel", "customMaxAge", "", "getCustomMaxAge", "()Ljava/lang/Integer;", "setCustomMaxAge", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", URIQueryParamKeys.DYNAMIC, "getDynamic", "setDynamic", "enableCached", "getEnableCached", "setEnableCached", "enableNegotiation", "getEnableNegotiation", "setEnableNegotiation", "engineUrl", "getEngineUrl", "setEngineUrl", "engineViewHash", "getEngineViewHash", "setEngineViewHash", "fallbackDomains", "", "getFallbackDomains", "()Ljava/util/List;", "setFallbackDomains", "(Ljava/util/List;)V", "group", "getGroup", "setGroup", "injectedHttpHeaders", "", "getInjectedHttpHeaders", "()Ljava/util/Map;", "setInjectedHttpHeaders", "(Ljava/util/Map;)V", "injectedUserAgent", "getInjectedUserAgent", "setInjectedUserAgent", "isFromRemoteConfig", "setFromRemoteConfig", "isPreload", "setPreload", "loadRetryTimes", "getLoadRetryTimes", "()I", "setLoadRetryTimes", "(I)V", "loadTimeOut", "", "getLoadTimeOut", "()J", "setLoadTimeOut", "(J)V", "loadToMemory", "getLoadToMemory", "setLoadToMemory", "loaderConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", "getLoaderConfig", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;", "setLoaderConfig", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/CustomLoaderConfig;)V", "maxAttempt", "getMaxAttempt", "setMaxAttempt", "monitorBid", "getMonitorBid", "setMonitorBid", "onlyLocal", "getOnlyLocal", "setOnlyLocal", "pipelineInfo", "getPipelineInfo", "setPipelineInfo", "preloadHighPriority", "getPreloadHighPriority", "setPreloadHighPriority", "resTag", "getResTag", "setResTag", "resourceLoaderSession", "getResourceLoaderSession", "setResourceLoaderSession", "shuffle", "getShuffle", "setShuffle", "specifiedPrefix", "", "getSpecifiedPrefix", "setSpecifiedPrefix", "taskContext", "Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext;", "getTaskContext", "()Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext;", "setTaskContext", "(Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext;)V", "useAssetsLoader", "getUseAssetsLoader", "setUseAssetsLoader", "useCdnLoader", "getUseCdnLoader", "setUseCdnLoader", "useGeckoLoader", "getUseGeckoLoader", "setUseGeckoLoader", "useInteraction", "getUseInteraction", "setUseInteraction", "webRequest", "Landroid/webkit/WebResourceRequest;", "getWebRequest", "()Landroid/webkit/WebResourceRequest;", "setWebRequest", "(Landroid/webkit/WebResourceRequest;)V", "from", "config", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class TaskConfig {
    private String accessKey;
    private String bid;
    private String bundle;
    private boolean cdnNoCache;
    private String cdnUrl;
    private String channel;
    private Integer customMaxAge;
    private Integer dynamic;
    private boolean enableCached;
    private boolean enableNegotiation;
    private String engineUrl;
    private String engineViewHash;
    private List<String> fallbackDomains;
    private String group;
    private Map<String, String> injectedHttpHeaders;
    private String injectedUserAgent;
    private boolean isFromRemoteConfig;
    private boolean isPreload;
    private int loadRetryTimes;
    private long loadTimeOut;
    private boolean loadToMemory;
    private CustomLoaderConfig loaderConfig;
    private int maxAttempt;
    private String monitorBid;
    private boolean onlyLocal;
    private String pipelineInfo;
    private boolean preloadHighPriority;
    private String resTag;
    private String resourceLoaderSession;
    private int shuffle;
    private List<String> specifiedPrefix;
    private TaskContext taskContext;
    private boolean useAssetsLoader;
    private boolean useCdnLoader;
    private boolean useGeckoLoader;
    private int useInteraction;
    private WebResourceRequest webRequest;

    /* JADX WARN: Multi-variable type inference failed */
    public TaskConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TaskConfig(String accessKey) {
        Intrinsics.checkNotNullParameter(accessKey, "accessKey");
        this.accessKey = accessKey;
        this.loaderConfig = new CustomLoaderConfig(false);
        this.bid = "";
        this.loadTimeOut = 1000L;
        this.channel = "";
        this.bundle = "";
        this.cdnUrl = "";
        this.useCdnLoader = true;
        this.useAssetsLoader = true;
        this.useGeckoLoader = true;
        this.resTag = "";
        this.pipelineInfo = "";
        this.enableCached = true;
        this.fallbackDomains = new ArrayList();
        this.specifiedPrefix = CollectionsKt.emptyList();
        this.resourceLoaderSession = "";
        this.loadToMemory = true;
        this.monitorBid = "default_bid";
    }

    public /* synthetic */ TaskConfig(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getAccessKey() {
        return this.accessKey;
    }

    public final void setAccessKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessKey = str;
    }

    public final CustomLoaderConfig getLoaderConfig() {
        return this.loaderConfig;
    }

    public final void setLoaderConfig(CustomLoaderConfig customLoaderConfig) {
        Intrinsics.checkNotNullParameter(customLoaderConfig, "<set-?>");
        this.loaderConfig = customLoaderConfig;
    }

    public final int getLoadRetryTimes() {
        return this.loadRetryTimes;
    }

    public final void setLoadRetryTimes(int i) {
        this.loadRetryTimes = i;
    }

    public final String getBid() {
        return this.bid;
    }

    public final void setBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bid = str;
    }

    public final long getLoadTimeOut() {
        return this.loadTimeOut;
    }

    public final void setLoadTimeOut(long j) {
        this.loadTimeOut = j;
    }

    public final Integer getDynamic() {
        return this.dynamic;
    }

    public final void setDynamic(Integer num) {
        this.dynamic = num;
    }

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final void setOnlyLocal(boolean z) {
        this.onlyLocal = z;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public final String getBundle() {
        return this.bundle;
    }

    public final void setBundle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bundle = str;
    }

    public final String getGroup() {
        return this.group;
    }

    public final void setGroup(String str) {
        this.group = str;
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final void setCdnUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cdnUrl = str;
    }

    public final boolean getUseCdnLoader() {
        return this.useCdnLoader;
    }

    public final void setUseCdnLoader(boolean z) {
        this.useCdnLoader = z;
    }

    public final boolean getUseAssetsLoader() {
        return this.useAssetsLoader;
    }

    public final void setUseAssetsLoader(boolean z) {
        this.useAssetsLoader = z;
    }

    public final boolean getUseGeckoLoader() {
        return this.useGeckoLoader;
    }

    public final void setUseGeckoLoader(boolean z) {
        this.useGeckoLoader = z;
    }

    public final String getResTag() {
        return this.resTag;
    }

    public final void setResTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resTag = str;
    }

    public final String getPipelineInfo() {
        return this.pipelineInfo;
    }

    public final void setPipelineInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pipelineInfo = str;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final void setEnableNegotiation(boolean z) {
        this.enableNegotiation = z;
    }

    public final boolean getEnableCached() {
        return this.enableCached;
    }

    public final void setEnableCached(boolean z) {
        this.enableCached = z;
    }

    /* renamed from: isPreload, reason: from getter */
    public final boolean getIsPreload() {
        return this.isPreload;
    }

    public final void setPreload(boolean z) {
        this.isPreload = z;
    }

    public final boolean getPreloadHighPriority() {
        return this.preloadHighPriority;
    }

    public final void setPreloadHighPriority(boolean z) {
        this.preloadHighPriority = z;
    }

    public final List<String> getFallbackDomains() {
        return this.fallbackDomains;
    }

    public final void setFallbackDomains(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.fallbackDomains = list;
    }

    public final int getShuffle() {
        return this.shuffle;
    }

    public final void setShuffle(int i) {
        this.shuffle = i;
    }

    public final boolean getCdnNoCache() {
        return this.cdnNoCache;
    }

    public final void setCdnNoCache(boolean z) {
        this.cdnNoCache = z;
    }

    public final int getMaxAttempt() {
        return this.maxAttempt;
    }

    public final void setMaxAttempt(int i) {
        this.maxAttempt = i;
    }

    /* renamed from: isFromRemoteConfig, reason: from getter */
    public final boolean getIsFromRemoteConfig() {
        return this.isFromRemoteConfig;
    }

    public final void setFromRemoteConfig(boolean z) {
        this.isFromRemoteConfig = z;
    }

    public final int getUseInteraction() {
        return this.useInteraction;
    }

    public final void setUseInteraction(int i) {
        this.useInteraction = i;
    }

    public final TaskContext getTaskContext() {
        return this.taskContext;
    }

    public final void setTaskContext(TaskContext taskContext) {
        this.taskContext = taskContext;
    }

    public final List<String> getSpecifiedPrefix() {
        return this.specifiedPrefix;
    }

    public final void setSpecifiedPrefix(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.specifiedPrefix = list;
    }

    public final String getResourceLoaderSession() {
        return this.resourceLoaderSession;
    }

    public final void setResourceLoaderSession(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resourceLoaderSession = str;
    }

    public final String getInjectedUserAgent() {
        return this.injectedUserAgent;
    }

    public final void setInjectedUserAgent(String str) {
        this.injectedUserAgent = str;
    }

    public final WebResourceRequest getWebRequest() {
        return this.webRequest;
    }

    public final void setWebRequest(WebResourceRequest webResourceRequest) {
        this.webRequest = webResourceRequest;
    }

    public final Integer getCustomMaxAge() {
        return this.customMaxAge;
    }

    public final void setCustomMaxAge(Integer num) {
        this.customMaxAge = num;
    }

    public final Map<String, String> getInjectedHttpHeaders() {
        return this.injectedHttpHeaders;
    }

    public final void setInjectedHttpHeaders(Map<String, String> map) {
        this.injectedHttpHeaders = map;
    }

    public final boolean getLoadToMemory() {
        return this.loadToMemory;
    }

    public final void setLoadToMemory(boolean z) {
        this.loadToMemory = z;
    }

    public final String getEngineViewHash() {
        return this.engineViewHash;
    }

    public final void setEngineViewHash(String str) {
        this.engineViewHash = str;
    }

    public final String getEngineUrl() {
        return this.engineUrl;
    }

    public final void setEngineUrl(String str) {
        this.engineUrl = str;
    }

    public final String getMonitorBid() {
        return this.monitorBid;
    }

    public final void setMonitorBid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.monitorBid = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[accessKey=");
        sb.append(this.accessKey).append(", loaderConfig=").append(this.loaderConfig).append(", dynamic=").append(this.dynamic).append(",onlyLocal=").append(this.onlyLocal).append(", channel=").append(this.channel).append(",bundle=").append(this.bundle).append(", group=").append(this.group).append(",cdnUrl=").append(this.cdnUrl).append(",enableCached:").append(this.enableCached).append("]\n[fallbackDomains=").append(this.fallbackDomains).append(",shuffle = ").append(this.shuffle).append(",cdnNoCache=");
        sb.append(this.cdnNoCache).append("，maxAttempt=").append(this.maxAttempt).append("，isRemote=").append(this.isFromRemoteConfig).append(",useInteraction = ").append(this.useInteraction).append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public TaskConfig from(TaskConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.bid = config.bid;
        this.loaderConfig = config.loaderConfig;
        this.loadTimeOut = config.loadTimeOut;
        this.dynamic = config.dynamic;
        this.onlyLocal = config.onlyLocal;
        this.channel = config.channel;
        this.bundle = config.bundle;
        this.group = config.group;
        this.cdnUrl = config.cdnUrl;
        this.enableNegotiation = config.enableNegotiation;
        this.enableCached = config.enableCached;
        this.resTag = config.resTag;
        this.useGeckoLoader = config.useGeckoLoader;
        this.useAssetsLoader = config.useAssetsLoader;
        this.useCdnLoader = config.useCdnLoader;
        this.isPreload = config.isPreload;
        this.fallbackDomains = config.fallbackDomains;
        this.shuffle = config.shuffle;
        this.cdnNoCache = config.cdnNoCache;
        this.maxAttempt = config.maxAttempt;
        this.useInteraction = config.useInteraction;
        this.taskContext = config.taskContext;
        this.resourceLoaderSession = config.resourceLoaderSession;
        this.monitorBid = config.monitorBid;
        this.engineViewHash = config.engineViewHash;
        this.engineUrl = config.engineUrl;
        this.injectedHttpHeaders = config.injectedHttpHeaders;
        return this;
    }
}
