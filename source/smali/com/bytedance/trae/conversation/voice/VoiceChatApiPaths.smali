# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
.super Ljava/lang/Object;
.source "VoiceChatApiPaths.kt"

.field public static final GET_VOICE_CHAT_HISTORY:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
.field public static final START_VOICE_CHAT:Ljava/lang/String;
.field public static final STOP_VOICE_CHAT:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->INSTANCE Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic buildHeaders$default(com.bytedance.trae.conversation.voice.VoiceChatApiPaths  java.lang.String  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)java.util.Map
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    const-string v3, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    const-string v4, ""
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;->buildHeaders(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final buildHeaders(java.lang.String  java.lang.String  java.lang.String  java.lang.String)java.util.Map
    .registers 7
    # ins_size=5
    const-string v0, "conversationId"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sceneId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, xAppId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ppeEnv"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 6
    new-array v6, v6, [Lkotlin/Pair;
    const-string v0, "Content-Type"
    const-string v1, "application/json"
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v1, 0
    aput-object v0, v6, v1
    const-string v0, "X-Scene-Id"
    invoke-static v0, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v0, 1
    aput-object v4, v6, v0
    const-string v4, "X-App-Id"
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v6, v5
    const-string/jumbo v4, x-conversation-id
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 3
    aput-object v3, v6, v4
    const-string v3, "X-IDE-Version-Code"
    const-string v4, "20260623"
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 4
    aput-object v3, v6, v4
    const-string/jumbo v3, x-audio-source
    const-string v4, "mobile"
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 5
    aput-object v3, v6, v4
    invoke-static v6, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    return-object v3
.end method

.method public final getHOST()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
