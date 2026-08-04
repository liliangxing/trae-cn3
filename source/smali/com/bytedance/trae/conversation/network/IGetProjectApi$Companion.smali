# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
.super Ljava/lang/Object;
.source "IGetProjectApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
.field private static final RAW_SUCCESS_CODES:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$2NoBOySwuM6zqChe19YTXuoLV-o(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->getUserProjectFoldersRawCall$lambda$0(Ljava/util/Map; Lcom/bytedance/trae/conversation/network/IGetProjectApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$IFS5llW5C1gL2MjQKSmj_eZ9_pc(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->listFolderRawCall$lambda$1(Ljava/util/Map; Lcom/bytedance/trae/conversation/network/IGetProjectApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$cX-vOwupIwoAi7_shvTjKqxFs78(com.bytedance.trae.conversation.network.CreateFolderRequest  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->createFolderRawCall$lambda$2(Lcom/bytedance/trae/conversation/network/CreateFolderRequest; Lcom/bytedance/trae/conversation/network/IGetProjectApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hgvVlO3KA5Eq6mp3pdCVrhKgAi0(com.bytedance.trae.conversation.network.AuthorizationResultRequest  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->authorizationResultRawCall$lambda$4(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest; Lcom/bytedance/trae/conversation/network/IGetProjectApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hkAKjNVvGfhr19dwFnPIZFxsULs(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->checkNeedAuthorizationRawCall$lambda$3(Ljava/util/Map; Lcom/bytedance/trae/conversation/network/IGetProjectApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$o2d9ZJ1udB1OTe611HRYpB8ma14(java.lang.Class  java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser$lambda$5(Ljava/lang/Class; Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final authorizationResultRawCall$lambda$4(com.bytedance.trae.conversation.network.AuthorizationResultRequest  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->authorizationResultRaw(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final checkNeedAuthorizationRawCall$lambda$3(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->checkNeedAuthorizationRaw(Ljava/util/Map; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final createFolderRawCall$lambda$2(com.bytedance.trae.conversation.network.CreateFolderRequest  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->createFolderRaw(Lcom/bytedance/trae/conversation/network/CreateFolderRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final getUserProjectFoldersRawCall$lambda$0(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->getUserProjectFoldersRaw(Ljava/util/Map; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private static final listFolderRawCall$lambda$1(java.util.Map  com.bytedance.trae.conversation.network.IGetProjectApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->listFolderRaw(Ljava/util/Map; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method private final remoteResponseParser(java.lang.Class)kotlin.jvm.functions.Function2
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda1;-><init>(Ljava/lang/Class;)V
    return-object v0
.end method

.method private static final remoteResponseParser$lambda$5(java.lang.Class  java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 13
    # ins_size=3
    const-string v0, "body"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v12, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v12
    const-class v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    check-cast v0, Ljava/lang/reflect/Type;
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/reflect/Type;
    const/4 v2, 0
    aput-object v10, v1, v2
    invoke-static v0, v1, Lcom/google/gson/reflect/TypeToken;->getParameterized(Ljava/lang/reflect/Type; [Ljava/lang/reflect/Type;)Lcom/google/gson/reflect/TypeToken;
    move-result-object v10
    invoke-virtual v10, Lcom/google/gson/reflect/TypeToken;->getType()Ljava/lang/reflect/Type;
    move-result-object v10
    invoke-virtual v12, v11, v10, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/reflect/Type;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    new-instance v11, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getCode()J
    move-result-wide v1
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 44
    const/4 v9, 0
    move-object v0, v11
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v11
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.conversation.network.IGetProjectApi$Companion  java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 1
    if-eqz v4, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->safeCall(Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final authorizationResultRawCall(com.bytedance.trae.conversation.network.AuthorizationResultRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "project"
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    const-class v10, Lkotlin/Unit;
    move-object/from16 v15, v16
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser(Ljava/lang/Class;)Lkotlin/jvm/functions/Function2;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda2;
    move-object/from16 v12, v17
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/network/AuthorizationResultRequest;)V
    const/16 v13, 444
    const/4 v14, 0
    move-object/from16 v12, v18
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final checkNeedAuthorizationRawCall(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "project"
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    const-class v10, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
    move-object/from16 v15, v16
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser(Ljava/lang/Class;)Lkotlin/jvm/functions/Function2;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda3;
    move-object/from16 v12, v17
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda3;-><init>(Ljava/util/Map;)V
    const/16 v13, 444
    const/4 v14, 0
    move-object/from16 v12, v18
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final createFolderRawCall(com.bytedance.trae.conversation.network.CreateFolderRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "project"
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    const-class v10, Lcom/bytedance/trae/conversation/network/CreateFolderData;
    move-object/from16 v15, v16
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser(Ljava/lang/Class;)Lkotlin/jvm/functions/Function2;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda4;
    move-object/from16 v12, v17
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/network/CreateFolderRequest;)V
    const/16 v13, 444
    const/4 v14, 0
    move-object/from16 v12, v18
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final getUserProjectFoldersRawCall(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "project"
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    const-class v10, Lcom/bytedance/trae/conversation/network/UserProjectFoldersData;
    move-object/from16 v15, v16
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser(Ljava/lang/Class;)Lkotlin/jvm/functions/Function2;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v12, v17
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda0;-><init>(Ljava/util/Map;)V
    const/16 v13, 444
    const/4 v14, 0
    move-object/from16 v12, v18
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final listFolderRawCall(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "project"
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->RAW_SUCCESS_CODES Ljava/util/Set;
    const/4 v8, 0
    const/4 v9, 0
    const-class v10, Lcom/bytedance/trae/conversation/network/ListFolderData;
    move-object/from16 v15, v16
    invoke-direct v15, v10, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->remoteResponseParser(Ljava/lang/Class;)Lkotlin/jvm/functions/Function2;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda5;
    move-object/from16 v12, v17
    invoke-direct v11, v12, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$$ExternalSyntheticLambda5;-><init>(Ljava/util/Map;)V
    const/16 v13, 444
    const/4 v14, 0
    move-object/from16 v12, v18
    invoke-static/range v0 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final safeCall(java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=4
    move-object/from16 v0, v19
    instance-of v1, v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->label I
    move-object/from16 v2, v16
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;
    move-object/from16 v2, v16
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->label I
    const-string v5, "IGetProjectApi"
    const/4 v6, 1
    if-eqz v4, +017h
    if-ne v4, v6, +00dh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +31h
    move-exception v0
    move-object v6, v0
    goto/16 +07dh
    move-exception v0
    goto/16 +090h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v8, "project"
    const-class v9, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 60
    const/4 v15, 0
    invoke-static/range v7 ... v15, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/IGetProjectApi;
    iput v6, v1, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion$safeCall$1;->label I
    move-object/from16 v4, v18
    invoke-interface v4, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    if-nez v0, +01dh
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v7, -1005
    const-string v8, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v3, "BizResponse is null"
    invoke-direct v1, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v9, v1
    check-cast v9, Ljava/lang/Throwable;
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +5fh
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v3, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getCode()J
    move-result-wide v6
    const-wide/16 v8, 200
    cmp-long v4, v6, v8
    if-nez v4, +005h
    const-wide/16 v6, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getCode()J
    move-result-wide v6
    move-wide v7, v6
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getMsg()Ljava/lang/String;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    const/4 v13, 0
    const/16 v14, 44
    const/4 v15, 0
    move-object v6, v3
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v0, 0
    invoke-direct v1, v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +2fh
    const-string v0, "Error"
    invoke-static v5, v0, v6, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1000
    const-string v5, ""
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v0
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +19h
    move-object v9, v0
    check-cast v9, Ljava/lang/Throwable;
    const-string v0, "CancellationException"
    invoke-static v5, v0, v9, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v7, -1001
    const-string v8, ""
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x2e
    :try_start_0x44
.end method
