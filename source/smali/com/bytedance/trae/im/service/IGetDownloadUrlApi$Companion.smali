# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
.super Ljava/lang/Object;
.source "IGetDownloadUrlApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$WdBi8RCfWvt1ZKAeIVFptdScx5A(com.bytedance.trae.im.service.GetDownloadUrlRequest  com.bytedance.trae.im.service.IGetDownloadUrlApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall$lambda$0(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lcom/bytedance/trae/im/service/IGetDownloadUrlApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->SUCCESS_CODES Ljava/util/Set;
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

.method private static final getDownloadUrlRawCall$lambda$0(com.bytedance.trae.im.service.GetDownloadUrlRequest  com.bytedance.trae.im.service.IGetDownloadUrlApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->getDownloadUrlRaw(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final getDownloadUrlRawCall(com.bytedance.trae.im.service.GetDownloadUrlRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 17
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "download_url"
    const-class v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;
    const-class v3, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    check-cast v3, Ljava/lang/reflect/Type;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct v14, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v6
    const/4 v7, 1
    sget-object v8, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v9, 0
    new-instance v10, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0;
    move-object v11, v15
    invoke-direct v10, v15, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;)V
    const/16 v12, 280
    const/4 v13, 0
    move-object/from16 v11, v16
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "download_url"
    const-class v2, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;
    invoke-direct v10, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/16 v8, 48
    const/4 v9, 0
    move-object v4, v11
    move-object v7, v12
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method
