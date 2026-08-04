# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogAppConfigImpl;
.super Ljava/lang/Object;
.source "PraiseDialogAppConfigImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAppConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
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

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getHost()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    const/4 v1, 1
    new-array v1, v1, [C
    const/4 v2, 0
    const/16 v3, 47
    aput-char v3, v1, v2
    invoke-static v0, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getHuaWeiAppId()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "117273863"
    return-object v0
.end method

.method public getPackageName()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getPackageName(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getTopActivity()android.app.Activity
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v0
    invoke-interface v0, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getCurrentActivity()Landroid/app/Activity;
    move-result-object v0
    return-object v0
.end method

.method public goToFeedback(android.content.Context  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "feedbackUrl"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public handleNoAppMarket()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public needShowDefaultDialog()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public onEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "eventName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, params
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v3
    const v0, 319288017
    if-eq v3, v0, +02ah
    const v0, 319638801
    if-eq v3, v0, +017h
    const v0, 841578353
    if-eq v3, v0, +003h
    goto +2ch
    const-string v3, "evaluate_pop_bad"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +23h
    sget-object v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->onLaterClicked()V
    goto +1dh
    const-string v3, "evaluate_pop_show"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +016h
    sget-object v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->onDialogShown()V
    goto +fh
    const-string v3, "evaluate_pop_good"
    invoke-virtual v2, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +6h
    sget-object v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v2, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->onRateClicked()V
    return-void 
.end method
