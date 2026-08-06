package com.bytedance.ies.bullet.service.base.resourceloader.config;

import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.ICommonService;
import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLReportInfo;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResourceLoaderConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b?\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u000e\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u0003J\b\u0010`\u001a\u00020\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\u001a\u0010>\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\u001a\u0010A\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00108\"\u0004\bC\u0010:R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010IR\u001a\u0010L\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001e\"\u0004\bN\u0010 R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0016\"\u0004\bP\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u00108\"\u0004\bQ\u0010:R\u001a\u0010R\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u001e\"\u0004\bT\u0010 R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0016\"\u0004\bZ\u0010\u0018R \u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010V\"\u0004\b]\u0010X¨\u0006a"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "", "host", "", "region", SchemaConstants.QUERY_KEY_PREFIX, "", "appId", "appVersion", CommonConstants.KEY_DEVICE_ID, "dftGeckoCfg", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "geckoConfigs", "", "downloadDepender", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;", "geckoNetworkImpl", "geckoXNetworkImpl", "isDebug", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;Ljava/util/Map;Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getAppVersion", "setAppVersion", "captureFrequency", "", "getCaptureFrequency", "()I", "setCaptureFrequency", "(I)V", "commonService", "Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/ICommonService;", "getCommonService", "()Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/ICommonService;", "setCommonService", "(Lcom/bytedance/ies/bullet/kit/resourceloader/monitor/ICommonService;)V", "defaultPrefix2Ak", "getDefaultPrefix2Ak", "()Ljava/util/Map;", "setDefaultPrefix2Ak", "(Ljava/util/Map;)V", "getDftGeckoCfg", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;", "setDftGeckoCfg", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;)V", "getDid", "setDid", "getDownloadDepender", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;", "setDownloadDepender", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;)V", "enableMemCache", "getEnableMemCache", "()Z", "setEnableMemCache", "(Z)V", "enableNegotiation", "getEnableNegotiation", "setEnableNegotiation", "enableParseInSingleCycle", "getEnableParseInSingleCycle", "setEnableParseInSingleCycle", "enableRemoteConfig", "getEnableRemoteConfig", "setEnableRemoteConfig", "getGeckoConfigs", "setGeckoConfigs", "getGeckoNetworkImpl", "()Ljava/lang/Object;", "setGeckoNetworkImpl", "(Ljava/lang/Object;)V", "getGeckoXNetworkImpl", "setGeckoXNetworkImpl", "highMaxMem", "getHighMaxMem", "setHighMaxMem", "getHost", "setHost", "setDebug", "maxMem", "getMaxMem", "setMaxMem", "getPrefix", "()Ljava/util/List;", "setPrefix", "(Ljava/util/List;)V", "getRegion", "setRegion", "sampleWhiteList", "getSampleWhiteList", "setSampleWhiteList", "getGeckoConfig", "ak", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceLoaderConfig {
    private String appId;
    private String appVersion;
    private int captureFrequency;
    private ICommonService commonService;
    private Map<String, String> defaultPrefix2Ak;
    private GeckoConfig dftGeckoCfg;
    private String did;
    private ICdnDownloadDepender downloadDepender;
    private boolean enableMemCache;
    private boolean enableNegotiation;
    private boolean enableParseInSingleCycle;
    private boolean enableRemoteConfig;
    private Map<String, GeckoConfig> geckoConfigs;
    private Object geckoNetworkImpl;
    private Object geckoXNetworkImpl;
    private int highMaxMem;
    private String host;
    private boolean isDebug;
    private int maxMem;
    private List<String> prefix;
    private String region;
    private List<String> sampleWhiteList;

    public ResourceLoaderConfig(String str, String str2, List<String> list, String str3, String str4, String str5, GeckoConfig geckoConfig, Map<String, GeckoConfig> map, ICdnDownloadDepender iCdnDownloadDepender, Object obj, Object obj2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "host");
        Intrinsics.checkNotNullParameter(str2, "region");
        Intrinsics.checkNotNullParameter(list, SchemaConstants.QUERY_KEY_PREFIX);
        Intrinsics.checkNotNullParameter(str3, "appId");
        Intrinsics.checkNotNullParameter(str4, "appVersion");
        Intrinsics.checkNotNullParameter(str5, CommonConstants.KEY_DEVICE_ID);
        Intrinsics.checkNotNullParameter(geckoConfig, "dftGeckoCfg");
        Intrinsics.checkNotNullParameter(map, "geckoConfigs");
        Intrinsics.checkNotNullParameter(iCdnDownloadDepender, "downloadDepender");
        this.host = str;
        this.region = str2;
        this.prefix = list;
        this.appId = str3;
        this.appVersion = str4;
        this.did = str5;
        this.dftGeckoCfg = geckoConfig;
        this.geckoConfigs = map;
        this.downloadDepender = iCdnDownloadDepender;
        this.geckoNetworkImpl = obj;
        this.geckoXNetworkImpl = obj2;
        this.isDebug = z;
        this.captureFrequency = 10;
        this.maxMem = ResourceLoaderConfigKt.DEFAULT_MEM_SIZE;
        this.highMaxMem = ResourceLoaderConfigKt.DEFAULT_MEM_SIZE;
        this.enableRemoteConfig = true;
        this.sampleWhiteList = new ArrayList();
        this.defaultPrefix2Ak = new LinkedHashMap();
        this.commonService = new ICommonService() { // from class: com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig$commonService$1
            @Override // com.bytedance.ies.bullet.kit.resourceloader.monitor.ICommonService
            public void report(TaskConfig config, RLReportInfo info) {
                Intrinsics.checkNotNullParameter(config, "config");
                Intrinsics.checkNotNullParameter(info, "info");
                RLLogger.INSTANCE.m24w("empty report: RLReportController not register");
            }
        };
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.region = str;
    }

    public final List<String> getPrefix() {
        return this.prefix;
    }

    public final void setPrefix(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.prefix = list;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final String getDid() {
        return this.did;
    }

    public final void setDid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.did = str;
    }

    public final GeckoConfig getDftGeckoCfg() {
        return this.dftGeckoCfg;
    }

    public final void setDftGeckoCfg(GeckoConfig geckoConfig) {
        Intrinsics.checkNotNullParameter(geckoConfig, "<set-?>");
        this.dftGeckoCfg = geckoConfig;
    }

    public /* synthetic */ ResourceLoaderConfig(String str, String str2, List list, String str3, String str4, String str5, GeckoConfig geckoConfig, Map map, ICdnDownloadDepender iCdnDownloadDepender, Object obj, Object obj2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, str3, str4, str5, geckoConfig, (i & 128) != 0 ? new LinkedHashMap() : map, iCdnDownloadDepender, (i & 512) != 0 ? null : obj, (i & 1024) != 0 ? null : obj2, (i & 2048) != 0 ? false : z);
    }

    public final Map<String, GeckoConfig> getGeckoConfigs() {
        return this.geckoConfigs;
    }

    public final void setGeckoConfigs(Map<String, GeckoConfig> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.geckoConfigs = map;
    }

    public final ICdnDownloadDepender getDownloadDepender() {
        return this.downloadDepender;
    }

    public final void setDownloadDepender(ICdnDownloadDepender iCdnDownloadDepender) {
        Intrinsics.checkNotNullParameter(iCdnDownloadDepender, "<set-?>");
        this.downloadDepender = iCdnDownloadDepender;
    }

    public final Object getGeckoNetworkImpl() {
        return this.geckoNetworkImpl;
    }

    public final void setGeckoNetworkImpl(Object obj) {
        this.geckoNetworkImpl = obj;
    }

    public final Object getGeckoXNetworkImpl() {
        return this.geckoXNetworkImpl;
    }

    public final void setGeckoXNetworkImpl(Object obj) {
        this.geckoXNetworkImpl = obj;
    }

    /* renamed from: isDebug, reason: from getter */
    public final boolean getIsDebug() {
        return this.isDebug;
    }

    public final void setDebug(boolean z) {
        this.isDebug = z;
    }

    public final int getCaptureFrequency() {
        return this.captureFrequency;
    }

    public final void setCaptureFrequency(int i) {
        this.captureFrequency = i;
    }

    public final int getMaxMem() {
        return this.maxMem;
    }

    public final void setMaxMem(int i) {
        this.maxMem = i;
    }

    public final int getHighMaxMem() {
        return this.highMaxMem;
    }

    public final void setHighMaxMem(int i) {
        this.highMaxMem = i;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final void setEnableNegotiation(boolean z) {
        this.enableNegotiation = z;
    }

    public final boolean getEnableMemCache() {
        return this.enableMemCache;
    }

    public final void setEnableMemCache(boolean z) {
        this.enableMemCache = z;
    }

    public final boolean getEnableRemoteConfig() {
        return this.enableRemoteConfig;
    }

    public final void setEnableRemoteConfig(boolean z) {
        this.enableRemoteConfig = z;
    }

    public final List<String> getSampleWhiteList() {
        return this.sampleWhiteList;
    }

    public final void setSampleWhiteList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sampleWhiteList = list;
    }

    public final Map<String, String> getDefaultPrefix2Ak() {
        return this.defaultPrefix2Ak;
    }

    public final void setDefaultPrefix2Ak(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.defaultPrefix2Ak = map;
    }

    public final ICommonService getCommonService() {
        return this.commonService;
    }

    public final void setCommonService(ICommonService iCommonService) {
        Intrinsics.checkNotNullParameter(iCommonService, "<set-?>");
        this.commonService = iCommonService;
    }

    public final boolean getEnableParseInSingleCycle() {
        return this.enableParseInSingleCycle;
    }

    public final void setEnableParseInSingleCycle(boolean z) {
        this.enableParseInSingleCycle = z;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("{[host]=").append(this.host).append(",[region]=").append(this.region).append(",[prefix]=");
        Object[] array = this.prefix.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        return append.append(arrays).append(",[appId]=").append(this.appId).append(",[appVersion]=").append(this.appVersion).append(",[did]=").append(this.did).append('}').toString();
    }

    public final GeckoConfig getGeckoConfig(String ak) {
        Intrinsics.checkNotNullParameter(ak, "ak");
        GeckoConfig geckoConfig = this.geckoConfigs.get(ak);
        return geckoConfig == null ? this.dftGeckoCfg : geckoConfig;
    }
}
