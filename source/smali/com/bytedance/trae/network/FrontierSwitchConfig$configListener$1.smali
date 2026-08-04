# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
.super Ljava/lang/Object;
.source "FrontierSwitchConfig.kt"

.implements Lcom/bytedance/services/slardar/config/IConfigListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onReady()void
    .registers 5
    # ins_size=1
    const-string v0, "disable_frontier_reconnect"
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    invoke-static Lcom/bytedance/apm/internal/ApmDelegate;->getInstance()Lcom/bytedance/apm/internal/ApmDelegate;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/apm/internal/ApmDelegate;->getLogTypeSwitch(Ljava/lang/String;)Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v1, v2
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    sget-object v2, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-static v2, Lcom/bytedance/trae/network/FrontierSwitchConfig;->access$getRepo(Lcom/bytedance/trae/network/FrontierSwitchConfig;)Lcom/bytedance/keva/Keva;
    move-result-object v2
    if-eqz v1, +005h
    const-string v1, "1"
    goto +3h
    const-string v1, "0"
    invoke-virtual v2, v0, v1, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x2
    :try_start_0x35
.end method

.method public onRefresh(org.json.JSONObject  boolean)void
    .registers 5
    # ins_size=3
    if-eqz v3, +011h
    const-string v4, "custom_event_settings"
    invoke-virtual v3, v4, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v3
    if-eqz v3, +009h
    const-string v4, "allow_log_type"
    invoke-virtual v3, v4, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    const-string v4, "disable_frontier_reconnect"
    const/4 v0, 0
    if-eqz v3, +00ah
    invoke-virtual v3, v4, v0, Lorg/json/JSONObject;->optInt(Ljava/lang/String; I)I
    move-result v3
    const/4 v1, 1
    if-ne v3, v1, +003h
    move v0, v1
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    sget-object v3, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-static v3, Lcom/bytedance/trae/network/FrontierSwitchConfig;->access$getRepo(Lcom/bytedance/trae/network/FrontierSwitchConfig;)Lcom/bytedance/keva/Keva;
    move-result-object v3
    if-eqz v0, +005h
    const-string v0, "1"
    goto +3h
    const-string v0, "0"
    invoke-virtual v3, v4, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v3
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x1f
.end method
