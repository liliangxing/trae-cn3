# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
.super Ljava/lang/Object;
.source "IListMessagesService.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$-RjA4HzYHAuqVbUqtyVJ9DU-Oho(java.lang.String  java.lang.String  int  int  boolean  com.bytedance.trae.im.service.IListMessagesService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->listMessagesByAnchorRawCall$lambda$0(Ljava/lang/String; Ljava/lang/String; I I Z Lcom/bytedance/trae/im/service/IListMessagesService; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IListMessagesService$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->SUCCESS_CODES Ljava/util/Set;
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

.method public static synthetic listMessagesByAnchorRawCall$default(com.bytedance.trae.im.service.IListMessagesService$Companion  java.lang.String  java.lang.String  int  int  boolean  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 2
    if-eqz v15, +003h
    const/4 v9, 0
    move-object v2, v9
    and-int/lit8 v9, v14, 4
    if-eqz v9, +004h
    const/16 v10, 10
    move v3, v10
    and-int/lit8 v9, v14, 8
    const/4 v10, 0
    if-eqz v9, +004h
    move v4, v10
    goto +2h
    move v4, v11
    and-int/lit8 v9, v14, 16
    if-eqz v9, +004h
    move v5, v10
    goto +2h
    move v5, v12
    move-object v0, v7
    move-object v1, v8
    move-object v6, v13
    invoke-virtual/range v0 ... v6, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->listMessagesByAnchorRawCall(Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private static final listMessagesByAnchorRawCall$lambda$0(java.lang.String  java.lang.String  int  int  boolean  com.bytedance.trae.im.service.IListMessagesService  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 16
    # ins_size=7
    const-string v0, "$this$rawBizCall"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v7, 52428800
    move-object v1, v14
    move-object v2, v9
    move-object v3, v10
    move v4, v11
    move v5, v12
    move v6, v13
    move-object v8, v15
    invoke-interface/range v1 ... v8, Lcom/bytedance/trae/im/service/IListMessagesService;->listMessagesByAnchorRaw(Ljava/lang/String; Ljava/lang/String; I I Z I Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v9
    return-object v9
.end method

.method public final listMessagesByAnchorRawCall(java.lang.String  java.lang.String  int  int  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=7
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "base"
    const-class v2, Lcom/bytedance/trae/im/service/IListMessagesService;
    const-class v3, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    check-cast v3, Ljava/lang/reflect/Type;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v6
    const/4 v7, 1
    sget-object v8, Lcom/bytedance/trae/im/service/IListMessagesService$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v9, 1
    new-instance v16, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v10, v16
    move-object/from16 v11, v18
    move-object/from16 v12, v19
    move/from16 v13, v20
    move/from16 v14, v21
    move/from16 v15, v22
    invoke-direct/range v10 ... v15, Lcom/bytedance/trae/im/service/IListMessagesService$Companion$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; Ljava/lang/String; I I Z)V
    const/16 v12, 24
    const/4 v13, 0
    move-object/from16 v11, v23
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
