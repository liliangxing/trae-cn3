# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
.super Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;
.source "TTNetExt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
.field private static final TAG:Ljava/lang/String;
.field private static auto4GStartTime:J
.field private static final multiNetworkState:Landroidx/lifecycle/MutableLiveData;
.field private static trafficBytesStart:J
.field private static final ttSwitcherObserver:Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    sget-object v1, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->STOPPED Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;
    invoke-virtual v1, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$State;->code()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->multiNetworkState Landroidx/lifecycle/MutableLiveData;
    new-instance v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->ttSwitcherObserver Lcom/bytedance/trae/network/ttnet/CronetDependAdapter$ttSwitcherObserver$1;
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static Lcom/bytedance/ttnet/TTWiFiCellSwitcher;->inst()Lcom/bytedance/ttnet/TTWiFiCellSwitcher;
    move-result-object v1
    check-cast v0, Lcom/bytedance/ttnet/TTWiFiCellSwitcher$Observer;
    const/4 v2, 0
    invoke-virtual v1, v0, v2, Lcom/bytedance/ttnet/TTWiFiCellSwitcher;->registerObserver(Lcom/bytedance/ttnet/TTWiFiCellSwitcher$Observer; Landroid/os/Handler;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x1f
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getAuto4GStartTime$p()long
    .registers 2
    # ins_size=0
    sget-wide v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->auto4GStartTime J
    return-wide v0
.end method

.method public static final synthetic access$getTrafficBytesStart$p()long
    .registers 2
    # ins_size=0
    sget-wide v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->trafficBytesStart J
    return-wide v0
.end method

.method public static final synthetic access$nowBytes(com.bytedance.trae.network.ttnet.CronetDependAdapter)long
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->nowBytes()J
    move-result-wide v0
    return-wide v0
.end method

.method public static final synthetic access$setAuto4GStartTime$p(long)void
    .registers 2
    # ins_size=2
    sput-wide v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->auto4GStartTime J
    return-void 
.end method

.method public static final synthetic access$setTrafficBytesStart$p(long)void
    .registers 2
    # ins_size=2
    sput-wide v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->trafficBytesStart J
    return-void 
.end method

.method private final nowBytes()long
    .registers 5
    # ins_size=1
    invoke-static Landroid/os/Process;->myUid()I
    move-result v0
    invoke-static v0, Landroid/net/TrafficStats;->getUidRxBytes(I)J
    move-result-wide v0
    invoke-static Landroid/os/Process;->myUid()I
    move-result v2
    invoke-static v2, Landroid/net/TrafficStats;->getUidTxBytes(I)J
    move-result-wide v2
    add-long/2addr v0, v2
    return-wide v0
.end method

.method public doLoadLibrary(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, s
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public getAppId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getAppName()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getCarrierRegion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getCarrierRegion()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getGetDomainDefaultJSON()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, {"data":{"tnc_update_interval":300,"chromium_open":1,"http_dns_enabled":1,"ttnet_http_dns_enabled":1,"ttnet_tt_http_dns":1,"ttnet_http_dns_timeout":5,"opaque_data_enabled":0,"wpad_enabled":0,"pac_enabled":1,"clear_pool_enabled":1,"get_domain_default_json":1,"md5_check":0},"message":"success"}
    return-object v0
    const-string/jumbo v0, {}
    return-object v0
.end method

.method public getIId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getLanguage()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getLanguage(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getManifestVersionCode()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getManifestVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getMultiNetworkState()androidx.lifecycle.MutableLiveData
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->multiNetworkState Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public getOpaqueData()java.util.ArrayList
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v0
    if-nez v0, +00ah
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getEnableAntiSniffing()Z
    move-result v0
    if-nez v0, +00fh
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getOpaqueDataEnable()Z
    move-result v0
    if-nez v0, +007h
    invoke-super v1, Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;->getOpaqueData()Ljava/util/ArrayList;
    move-result-object v0
    goto +7h
    sget-object v0, Lcom/bytedance/trae/network/ttnet/OpaqueData;->Companion Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;->getOpaqueDataList()Ljava/util/ArrayList;
    move-result-object v0
    return-object v0
.end method

.method public getRegion()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getAppLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getCountry(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getSdkAppId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getSdkVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getStoreIdcRuleJSON()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +01fh
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, {"update_store_idc_path_list": ["/service/*/device_register/", "/service/*/device_register_only/", "/passport/*"],"add_store_idc_host_list": ["*.
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    invoke-virtual v1, Lcom/bytedance/trae/network/HttpConst;->getONLINE_BASE_HOST_API()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ""]}"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto +5h
    invoke-super v2, Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;->getStoreIdcRuleJSON()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getSysRegion()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->INSTANCE Lcom/bytedance/trae/utils/AppLocaleUtils;
    invoke-virtual v0, Lcom/bytedance/trae/utils/AppLocaleUtils;->getSysLocale()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getCountry(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getUpdateVersionCode()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUserId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getVersionCode()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public loggerDebug()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v1, 1
    if-nez v0, +012h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    const-string v2, "local_test"
    invoke-static v2, v0, v1, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method public onEffectiveConnectionTypeChanged(int)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getConnectionTypeListeners()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/network/ConnectionTypeListener;
    invoke-interface v1, v3, Lcom/bytedance/trae/network/ConnectionTypeListener;->onEffectiveConnectionTypeChanged(I)V
    goto -fh
    return-void 
.end method

.method public onServerConfigUpdated(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lcom/bytedance/ttnet/cronet/AbsCronetDependAdapter;->onServerConfigUpdated(Ljava/lang/String;)V
    return-void 
.end method

.method public sendAppMonitorEvent(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "logContent"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "logType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v2, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-static v3, v0, Lcom/bytedance/apm/ApmAgent;->monitorCommonLog(Ljava/lang/String; Lorg/json/JSONObject;)V
    goto +5h
    move-exception v2
    invoke-virtual v2, Ljava/lang/Throwable;->printStackTrace()V
    return-void 
    :try_start_0xa
.end method
