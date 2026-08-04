# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;
.super Ljava/lang/Object;
.source "SoloHubRawResponseParser.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;
    invoke-direct v0, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;->INSTANCE Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic parseBizResponse$default(com.bytedance.trae.im.service.SoloHubRawResponseParser  java.lang.String  java.lang.reflect.Type  com.bytedance.retrofit2.SsResponse  int  java.lang.Object)com.bytedance.trae.network.response.BizResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;->parseBizResponse(Ljava/lang/String; Ljava/lang/reflect/Type; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method public final parseBizResponse(java.lang.String  java.lang.reflect.Type  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 8
    # ins_size=4
    const-string v0, "body"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "dataType"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/network/response/BizResponse;
    check-cast v1, Ljava/lang/reflect/Type;
    const/4 v2, 1
    new-array v2, v2, [Ljava/lang/reflect/Type;
    const/4 v3, 0
    aput-object v6, v2, v3
    invoke-static v1, v2, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v6
    invoke-virtual v0, v5, v6, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/network/response/BizResponse;
    if-eqz v7, +005h
    invoke-virtual v5, v7, Lcom/bytedance/trae/network/response/BizResponse;->setupSSResponse(Lcom/bytedance/retrofit2/SsResponse;)V
    sget-object v6, Lcom/bytedance/trae/im/service/SoloHubRawResponseParser;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v5, v6, Lcom/bytedance/trae/network/response/BizResponse;->setupSuccessCodes(Ljava/util/Set;)V
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v5
.end method
