# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
.super Ljava/lang/Object;
.source "IQuerySettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getWorkAttachmentSettings()com.bytedance.trae.conversation.settings.WorkAttachmentSettings
    .registers 31
    # ins_size=1
    const/4 v1, 0
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object/from16 v0, v30
    check-cast v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettingsService;
    const-class v0, Lcom/bytedance/trae/conversation/settings/IQuerySettings;
    invoke-static v0, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/settings/IQuerySettings;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/conversation/settings/IQuerySettings;->getWorkAttachmentSettings()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +00bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "WorkAttachmentSettings"
    const-string v5, "obtain model list settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +04eh
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v1, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string/jumbo v1, work_attachment_total_count
    const-wide/16 v2, 20
    invoke-virtual v0, v1, v2, v3, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v5
    const-string/jumbo v1, work_attachment_total_size_MB
    const-wide/16 v7, 1024
    invoke-virtual v0, v1, v7, v8, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v7
    const/16 v1, 1024
    int-to-long v9, v1
    mul-long/2addr v7, v9
    mul-long/2addr v7, v9
    const-string/jumbo v1, work_attachment_single_image_size_MB
    const-wide/16 v11, 100
    invoke-virtual v0, v1, v11, v12, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v11
    mul-long/2addr v11, v9
    mul-long/2addr v11, v9
    const-string/jumbo v1, work_attachment_single_file_size_MB
    const-wide/16 v13, 200
    invoke-virtual v0, v1, v13, v14, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v13
    mul-long/2addr v13, v9
    mul-long/2addr v13, v9
    const-string v1, "code_attachment_single_file_size_MB"
    invoke-virtual v0, v1, v2, v3, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v1
    mul-long/2addr v1, v9
    mul-long/2addr v1, v9
    const-string v3, "code_attachment_imgae_total_count"
    const-wide/16 v9, 5
    invoke-virtual v0, v3, v9, v10, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v15
    new-instance v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    move-object v4, v0
    move-wide v9, v11
    move-wide v11, v13
    move-wide v13, v1
    invoke-direct/range v4 ... v16, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;-><init>(J J J J J J)V
    return-object v0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;
    const-wide/16 v18, 20
    const-wide/32 v20, 1073741824
    const-wide/32 v22, 104857600
    const-wide/32 v24, 209715200
    const-wide/32 v26, 20971520
    const-wide/16 v28, 5
    move-object/from16 v17, v0
    invoke-direct/range v17 ... v29, Lcom/bytedance/trae/conversation/settings/WorkAttachmentSettings;-><init>(J J J J J J)V
    return-object v0
    :try_start_0x1
    :try_start_0x42
.end method
