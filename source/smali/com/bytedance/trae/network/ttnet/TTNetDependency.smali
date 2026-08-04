# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/TTNetDependency;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.implements Lcom/bytedance/ttnet/ITTNetDepend;

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/TTNetDependency;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/TTNetDependency;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/TTNetDependency;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetDependency;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetDependency;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public checkHttpRequestException(java.lang.Throwable  java.lang.String[])int
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tr
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, remoteIp
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public executeGet(int  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    const-string/jumbo v1, url
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    return-object v1
.end method

.method public getApiIHostPrefix()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getAppId()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    return v0
.end method

.method public getCdnHostSuffix()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "byteimg.com"
    return-object v0
.end method

.method public getConfigServers()java.lang.String[]
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getConfigServersArray()[Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getContext()android.content.Context
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    return-object v0
.end method

.method public getCookieFlushPathList()java.util.ArrayList
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getHostReverseMap()java.util.Map
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getHostSuffix()java.lang.String
    .registers 2
    # ins_size=1
    const-string/jumbo v0, www.trae.cn
    return-object v0
.end method

.method public getProviderInt(android.content.Context  java.lang.String  int)int
    .registers 4
    # ins_size=4
    const-string v3, "context"
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "key"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    return v1
.end method

.method public getProviderString(android.content.Context  java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=4
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "key"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "defaultValue"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, ""
    return-object v2
.end method

.method public getShareCookieMainDomain()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getTTNetServiceDomainMap()java.util.Map
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getServiceDomainMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public isCronetPluginInstalled()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isPrivateApiAccessEnabled()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public mobOnEvent(android.content.Context  java.lang.String  java.lang.String  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "eventName"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "labelName"
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "extraJson"
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public monitorLogSend(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "logType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "json"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/apm/ApmAgent;->monitorCommonLog(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public onAppConfigUpdated(android.content.Context  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "ext_json"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->INSTANCE Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;
    sget-object v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->CUSTOMER_SECOND_STRATEGY Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager;->startAppState(Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;)V
    return-void 
.end method

.method public onColdStartFinish()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onNetConfigUpdate(org.json.JSONObject  boolean)void
    .registers 3
    # ins_size=3
    const-string v2, "config"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onShareCookieConfigUpdated(java.lang.String)void
    .registers 9
    # ins_size=2
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-nez v1, +063h
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    move-object v6, v1
    check-cast v6, Ljava/util/List;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v8, ","
    filled-new-array v8, [Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v8
    move-object v0, v8
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    if-eqz v0, +03fh
    invoke-interface v8, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +035h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto -15h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v2
    if-le v2, v1, +01bh
    const/4 v2, 2
    const/4 v3, 0
    const-string v4, "."
    const/4 v5, 0
    invoke-static v0, v4, v5, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +010h
    invoke-virtual v0, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, substring(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v6, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -34h
    invoke-interface v6, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -38h
    return-void 
.end method

.method public saveMapToProvider(android.content.Context  java.util.Map)void
    .registers 3
    # ins_size=3
    const-string v2, "context"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
