# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
.super Ljava/lang/Object;
.source "IArtifactsRendererSettings.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getArtifactsRendererSettings()com.bytedance.trae.conversation.chat.block.renderer.settings.ArtifactsRendererSettings
    .registers 7
    # ins_size=1
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettingsService;
    const-class v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/IArtifactsRendererSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/IArtifactsRendererSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/IArtifactsRendererSettings;->getSettings()Ljava/lang/String;
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
    const-string v4, "ArtifactsRendererSettings"
    const-string v5, "obtain model list settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    const/4 v1, 0
    if-eqz v0, +01fh
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v0, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v0, "image_preview"
    invoke-virtual v2, v0, v1, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v0
    const-string v3, "html_preview"
    invoke-virtual v2, v3, v1, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v3
    const-string v4, "file_preview"
    invoke-virtual v2, v4, v1, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String; Z)Z
    move-result v2
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
    invoke-direct v4, v0, v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;-><init>(Z Z Z)V
    return-object v4
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;
    invoke-direct v0, v1, v1, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/settings/ArtifactsRendererSettings;-><init>(Z Z Z)V
    return-object v0
    :try_start_0x1
    :try_start_0x42
.end method
