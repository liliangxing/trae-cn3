# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
.super Ljava/lang/Object;
.source "ICreateTaskCheck.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;
.field private static final TAG:Ljava/lang/String;


.method public static synthetic $r8$lambda$XyZQnrCcX53IG26-27X6oQ2EJp0(com.bytedance.trae.im.service.CreateTaskCheckRequest  com.bytedance.trae.im.service.ICreateTaskCheck  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->createTaskCheckRawCall$lambda$0(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest; Lcom/bytedance/trae/im/service/ICreateTaskCheck; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final createTaskCheckRawCall$lambda$0(com.bytedance.trae.im.service.CreateTaskCheckRequest  com.bytedance.trae.im.service.ICreateTaskCheck  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/ICreateTaskCheck;->createTaskCheckRaw(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
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

.method public final createTaskCheckRawCall(com.bytedance.trae.im.service.CreateTaskCheckRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "POST /api/solo_hub/v1/conversations/tasks/create_check rawCall: conversationId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ICreateTaskCheck"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v4, "base"
    const-class v5, Lcom/bytedance/trae/im/service/ICreateTaskCheck;
    const-class v0, Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;
    move-object v6, v0
    check-cast v6, Ljava/lang/reflect/Type;
    const/4 v7, 0
    const/4 v8, 0
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v9
    const/4 v10, 1
    sget-object v11, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v0, v18
    invoke-direct v13, v0, Lcom/bytedance/trae/im/service/ICreateTaskCheck$Companion$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/CreateTaskCheckRequest;)V
    const/16 v15, 280
    const/16 v16, 0
    move-object/from16 v14, v19
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
