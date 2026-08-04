# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;
.super Ljava/lang/Object;
.source "NpthImpl.kt"

.implements Lcom/bytedance/crash/ICommonParams;

.field final synthetic this$0:Lcom/bytedance/trae/apm/impl/NpthImpl;


.method constructor <init>(com.bytedance.trae.apm.impl.NpthImpl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;->this$0 Lcom/bytedance/trae/apm/impl/NpthImpl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getCommonParams()java.util.Map
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "aid"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    const-string v2, "channel"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "app_version"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v2, version_code
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v2, update_version_code
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v1
    invoke-virtual v1, Ljava/util/Locale;->getCountry()Ljava/lang/String;
    move-result-object v1
    const-string v2, "getCountry(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-nez v2, +00ah
    const-string v2, "region"
    invoke-static v2, v1, Lcom/bytedance/crash/Npth;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getAppVariant()Ljava/lang/String;
    move-result-object v1
    const-string v2, "flow_app_variant"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;->this$0 Lcom/bytedance/trae/apm/impl/NpthImpl;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/NpthImpl;->access$getDeviceIdForNpth(Lcom/bytedance/trae/apm/impl/NpthImpl;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getPatchInfo()java.util.List
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getPluginInfo()java.util.Map
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getSessionId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUserId()long
    .registers 5
    # ins_size=1
    const-wide/16 v0, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/apm/impl/NpthImpl$init$1;
    sget-object v2, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Long;->longValue()J
    move-result-wide v2
    goto +2h
    move-wide v2, v0
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v2, v0
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
    :try_start_0x2
.end method
