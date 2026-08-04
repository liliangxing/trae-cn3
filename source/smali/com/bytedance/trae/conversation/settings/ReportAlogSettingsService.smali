# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
.super Ljava/lang/Object;
.source "IReportAlogSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final shouldUploadAlog(java.lang.String  long)boolean
    .registers 11
    # ins_size=4
    const-string v0, "api"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/LoginUtils;->isEnterpriseLogin()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return v1
    const/4 v0, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/conversation/settings/ReportAlogSettingsService;
    const-class v2, Lcom/bytedance/trae/conversation/settings/IReportAlogSettings;
    invoke-static v2, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/settings/IReportAlogSettings;
    if-eqz v2, +007h
    invoke-interface v2, Lcom/bytedance/trae/conversation/settings/IReportAlogSettings;->getReportAlogConfig()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v3
    if-eqz v3, +00bh
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v5, "ReportAlogSettings"
    const-string v6, "obtain report_alog settings failed"
    invoke-virtual v4, v5, v6, v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +016h
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v8, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v8
    if-nez v8, +003h
    return v1
    invoke-static v9, v10, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, v1, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v1
    return v1
    :try_start_0x10
    :try_start_0x50
.end method
