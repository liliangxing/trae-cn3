# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AppInfoBridgeMethod;
.super Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL;
.source "AppInfoBridgeMethod.kt"

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL;-><init>()V
    return-void 
.end method

.method private final getStatusBarHeight()int
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    const-string v1, "dimen"
    const-string v2, "android"
    const-string/jumbo v3, status_bar_height
    invoke-virtual v0, v3, v1, v2, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)I
    move-result v0
    if-lez v0, +011h
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public canRunInBackground()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public bridge synthetic handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 4
    # ins_size=4
    check-cast v2, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/anniex/AppInfoBridgeMethod;->handle(Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext; Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;)V
    return-void 
.end method

.method public handle(com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext  com.bytedance.trae.anniex.AbsAppGetAppInfoMethodIDL$AppGetAppInfoParamModel  com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock)void
    .registers 10
    # ins_size=4
    const-string v0, "bridgeContext"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v8, "callback"
    invoke-static v9, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;->getBridgeCall()Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;->getUrl()Ljava/lang/String;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/utils/TrustedDomainUtils;->INSTANCE Lcom/bytedance/trae/utils/TrustedDomainUtils;
    invoke-virtual v8, v7, Lcom/bytedance/trae/utils/TrustedDomainUtils;->isTrustedUrl(Ljava/lang/String;)Z
    move-result v7
    if-nez v7, +00eh
    const/4 v1, 0
    const-string/jumbo v2, untrusted domain
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v9
    invoke-static/range v0 ... v5, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onFailure$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; I Ljava/lang/String; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; I Ljava/lang/Object;)V
    return-void 
    const-class v7, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;
    invoke-static v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/utils/XBridgeKTXKt;->createXModel(Ljava/lang/Class;)Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setAid(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setUser_id(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setDevice_id(Ljava/lang/String;)V
    invoke-direct v6, Lcom/bytedance/trae/anniex/AppInfoBridgeMethod;->getStatusBarHeight()I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setStatusBarHeight(Ljava/lang/Number;)V
    sget-object v0, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v0, Lcom/bytedance/trae/network/NetworkMonitor;->isNetworkAvailable()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, unknown
    goto +3h
    const-string v0, "none"
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setNetType(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setAppVersion(Ljava/lang/String;)V
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setOs_version(Ljava/lang/String;)V
    sget-object v0, Landroid/os/Build;->MODEL Ljava/lang/String;
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setDevice_model(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setInstall_id(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getOpenUDid()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setOpen_udid(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setInnerAppName(Ljava/lang/String;)V
    const-string v0, ""
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setCarrier(Ljava/lang/String;)V
    const-string v0, "android"
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setDevice_platform(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setAppVersonCode(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setChannel(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setAppName(Ljava/lang/String;)V
    sget-object v0, Landroid/os/Build;->MODEL Ljava/lang/String;
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setDevice_type(Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-interface v8, v0, Lcom/bytedance/trae/anniex/AbsAppGetAppInfoMethodIDL$AppGetAppInfoResultModel;->setVersionCode(Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel;
    const/4 v8, 2
    const/4 v0, 0
    invoke-static v9, v7, v0, v8, v0, Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock$DefaultImpls;->onSuccess$default(Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock; Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseResultModel; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method
