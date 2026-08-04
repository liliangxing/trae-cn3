# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
.super Ljava/lang/Object;
.source "IFixCrashSettings.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;->INSTANCE Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final isFixSuspendByPeerCrashEnable()boolean
    .registers 7
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;
    const-class v1, Lcom/bytedance/trae/home/solo/task/IFixCrashSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/task/IFixCrashSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/home/solo/task/IFixCrashSettings;->getFixSuspendByPeerCrash()Ljava/lang/String;
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
    const-string v4, "FixCrashSettings"
    const-string v5, "obtain fix crash settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-eqz v0, +00dh
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v0, "fix_suspend_by_peer_crash"
    invoke-virtual v2, v0, v1, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v1
    return v1
    :try_start_0x1
    :try_start_0x42
.end method
