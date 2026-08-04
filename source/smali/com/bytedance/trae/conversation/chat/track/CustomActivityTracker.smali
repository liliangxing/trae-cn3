# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;
.super Ljava/lang/Object;
.source "CustomActivityTracker.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;->INSTANCE Lcom/bytedance/trae/conversation/chat/track/CustomActivityTracker;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final trackHomeEntryClick(java.lang.String)void
    .registers 4
    # ins_size=1
    const-string v0, "position"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v2, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "activity_home_entry_click"
    invoke-virtual v1, v0, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final trackHomeEntryShow(java.lang.String)void
    .registers 4
    # ins_size=1
    const-string v0, "position"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v2, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string v0, "activity_home_entry_show"
    invoke-virtual v1, v0, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public static final trackShareButtonClick(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, source
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, shareUrl
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, Lorg/json/JSONObject;-><init>()V
    invoke-virtual v2, v0, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string/jumbo v0, url
    invoke-virtual v3, v0, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    move-result-object v3
    const-string/jumbo v4, share_button_click
    invoke-virtual v1, v4, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
