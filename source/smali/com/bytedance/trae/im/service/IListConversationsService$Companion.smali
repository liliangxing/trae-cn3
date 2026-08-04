# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
.super Ljava/lang/Object;
.source "IListConversationsService.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$gtYzrPBCyZs59AaqQTpec5nFJVU(java.lang.String  int  int  long  long  com.bytedance.trae.im.service.IListConversationsService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 9
    # ins_size=9
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->searchRawCall$lambda$1(Ljava/lang/String; I I J J Lcom/bytedance/trae/im/service/IListConversationsService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pUibCL-cb6_-tKttlnDcoxewGJE(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  com.bytedance.trae.im.service.IListConversationsService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 11
    # ins_size=11
    invoke-static/range v0 ... v10, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->listConversationsRawCall$lambda$0(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lcom/bytedance/trae/im/service/IListConversationsService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListConversationsService$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getDEFAULT_HEADERS()java.util.Map
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders$default(Lcom/bytedance/trae/network/DebugSettings; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic listConversationsRawCall$default(com.bytedance.trae.im.service.IListConversationsService$Companion  int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=13
    move/from16 v0, v24
    and-int/lit8 v1, v0, 1
    if-eqz v1, +006h
    const/16 v1, 300
    move v3, v1
    goto +2h
    move v3, v14
    and-int/lit8 v1, v0, 2
    if-eqz v1, +005h
    const/4 v1, 0
    move v4, v1
    goto +2h
    move v4, v15
    and-int/lit8 v1, v0, 4
    if-eqz v1, +007h
    const-string/jumbo v1, updated_at
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v16
    and-int/lit8 v1, v0, 8
    if-eqz v1, +006h
    const-string v1, "desc"
    move-object v6, v1
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v1, v0, 16
    const/4 v2, 1
    if-eqz v1, +004h
    move v7, v2
    goto +3h
    move/from16 v7, v18
    and-int/lit8 v1, v0, 32
    if-eqz v1, +008h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v19
    and-int/lit8 v1, v0, 64
    if-eqz v1, +008h
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    move-object v9, v1
    goto +3h
    move-object/from16 v9, v20
    and-int/lit16 v1, v0, 128
    if-eqz v1, +006h
    const-string v1, ""
    move-object v10, v1
    goto +3h
    move-object/from16 v10, v21
    and-int/lit16 v0, v0, 256
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v11, v0
    goto +3h
    move-object/from16 v11, v22
    move-object v2, v13
    move-object/from16 v12, v23
    invoke-virtual/range v2 ... v12, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->listConversationsRawCall(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private static final listConversationsRawCall$lambda$0(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  com.bytedance.trae.im.service.IListConversationsService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 23
    # ins_size=11
    const-string v0, "$this$rawBizCall"
    move-object/from16 v1, v21
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    move-object/from16 v11, v22
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move v2, v12
    move v3, v13
    move-object v4, v14
    move-object v5, v15
    move/from16 v6, v16
    move-object/from16 v7, v17
    move-object/from16 v8, v18
    move-object/from16 v9, v19
    move-object/from16 v10, v20
    invoke-interface/range v1 ... v11, Lcom/bytedance/trae/im/service/IListConversationsService;->listConversationsRaw(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic searchRawCall$default(com.bytedance.trae.im.service.IListConversationsService$Companion  java.lang.String  int  int  long  long  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 21
    # ins_size=11
    and-int/lit8 v0, v19, 2
    if-eqz v0, +006h
    const/16 v0, 20
    move v3, v0
    goto +2h
    move v3, v12
    and-int/lit8 v0, v19, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v13
    and-int/lit8 v0, v19, 8
    const-wide/16 v1, 0
    if-eqz v0, +004h
    move-wide v5, v1
    goto +2h
    move-wide v5, v14
    and-int/lit8 v0, v19, 16
    if-eqz v0, +004h
    move-wide v7, v1
    goto +3h
    move-wide/from16 v7, v16
    move-object v1, v10
    move-object v2, v11
    move-object/from16 v9, v18
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->searchRawCall(Ljava/lang/String; I I J J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private static final searchRawCall$lambda$1(java.lang.String  int  int  long  long  com.bytedance.trae.im.service.IListConversationsService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 19
    # ins_size=9
    const-string v0, "$this$rawBizCall"
    move-object/from16 v1, v17
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    move-object/from16 v9, v18
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v2, v10
    move v3, v11
    move v4, v12
    move-wide v5, v13
    move-wide v7, v15
    invoke-interface/range v1 ... v9, Lcom/bytedance/trae/im/service/IListConversationsService;->searchConversationsRaw(Ljava/lang/String; I I J J Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public final listConversationsRawCall(int  int  java.lang.String  java.lang.String  boolean  java.lang.Integer  java.lang.Integer  java.lang.String  java.util.List  kotlin.coroutines.Continuation)java.lang.Object
    .registers 32
    # ins_size=11
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "base"
    const-class v2, Lcom/bytedance/trae/im/service/IListConversationsService;
    const-class v3, Lcom/bytedance/trae/im/service/ListConversationsResponse;
    check-cast v3, Ljava/lang/reflect/Type;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct/range v21, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v6
    const/4 v7, 1
    sget-object v8, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v9, 1
    new-instance v20, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v10, v20
    move/from16 v11, v22
    move/from16 v12, v23
    move-object/from16 v13, v24
    move-object/from16 v14, v25
    move/from16 v15, v26
    move-object/from16 v16, v27
    move-object/from16 v17, v28
    move-object/from16 v18, v29
    move-object/from16 v19, v30
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda0;-><init>(I I Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/util/List;)V
    const/16 v12, 24
    const/4 v13, 0
    move-object/from16 v11, v31
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final searchRawCall(java.lang.String  int  int  long  long  kotlin.coroutines.Continuation)java.lang.Object
    .registers 28
    # ins_size=9
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "base"
    const-class v2, Lcom/bytedance/trae/im/service/IListConversationsService;
    const-class v3, Lcom/bytedance/trae/im/service/SearchConversationsResponse;
    check-cast v3, Ljava/lang/reflect/Type;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct/range v19, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v6
    const/4 v7, 1
    sget-object v8, Lcom/bytedance/trae/im/service/IListConversationsService$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v9, 1
    new-instance v18, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;
    move-object/from16 v10, v18
    move-object/from16 v11, v20
    move/from16 v12, v21
    move/from16 v13, v22
    move-wide/from16 v14, v23
    move-wide/from16 v16, v25
    invoke-direct/range v10 ... v17, Lcom/bytedance/trae/im/service/IListConversationsService$Companion$$ExternalSyntheticLambda1;-><init>(Ljava/lang/String; I I J J)V
    const/16 v12, 24
    const/4 v13, 0
    move-object/from16 v11, v27
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
