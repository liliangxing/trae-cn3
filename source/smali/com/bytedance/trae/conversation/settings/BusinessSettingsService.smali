# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
.super Ljava/lang/Object;
.source "ICNBusinessSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getSettings()com.bytedance.trae.conversation.settings.BusinessSettings
    .registers 11
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v10
    check-cast v1, Lcom/bytedance/trae/conversation/settings/BusinessSettingsService;
    const-class v1, Lcom/bytedance/trae/conversation/settings/ICNBusinessSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/settings/ICNBusinessSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/settings/ICNBusinessSettings;->getSettings()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +00bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "BusinessSettingsService"
    const-string v5, "obtain model list settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    const-wide/16 v1, 72
    const-wide/16 v3, 10
    if-eqz v0, +019h
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct v5, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v0, "fast_pass_notify_count"
    invoke-virtual v5, v0, v3, v4, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v6
    const-string v0, "fast_pass_notify_interval"
    invoke-virtual v5, v0, v1, v2, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v8
    new-instance v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;
    invoke-direct v0, v6, v7, v8, v9, Lcom/bytedance/trae/conversation/settings/BusinessSettings;-><init>(J J)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/conversation/settings/BusinessSettings;-><init>(J J)V
    return-object v0
    :try_start_0x1
    :try_start_0x45
.end method
