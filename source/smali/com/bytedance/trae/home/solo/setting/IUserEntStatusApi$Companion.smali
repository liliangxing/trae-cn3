# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
.super Ljava/lang/Object;
.source "UserEntStatusApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
.field private static final PATH:Ljava/lang/String;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$FCFiZ8stM3QfHseiSX7a_PehOAg(com.bytedance.trae.home.solo.setting.UserEntUsageRequest  com.bytedance.trae.home.solo.setting.IUserEntStatusApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->fetchEntUsageRawCall$lambda$1(Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest; Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$y6naBgfPe3dmhSIXsEebjObY2oQ(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->fetchEntUsageRawCall$lambda$0(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final fetchEntUsageRawCall$lambda$0(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->INSTANCE Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->parseUsage(Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final fetchEntUsageRawCall$lambda$1(com.bytedance.trae.home.solo.setting.UserEntUsageRequest  com.bytedance.trae.home.solo.setting.IUserEntStatusApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;->getUserEntUsageRaw(Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final fetchEntUsageRawCall(kotlin.coroutines.Continuation)java.lang.Object
    .registers 21
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;
    const/4 v1, 3
    const/4 v2, 0
    const/4 v3, 0
    invoke-direct v0, v3, v3, v1, v2, Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;-><init>(Z I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-class v6, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi;
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v8
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const-string/jumbo v5, user_ent_status
    const-string v7, "/trae/api/v2/pay/ide_user_ent_usage"
    const/4 v9, 0
    const/4 v10, 1
    const/4 v12, 0
    const/4 v13, 0
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion$$ExternalSyntheticLambda0;
    invoke-direct v14, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion$$ExternalSyntheticLambda0;-><init>()V
    new-instance v15, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion$$ExternalSyntheticLambda1;
    invoke-direct v15, v0, Lcom/bytedance/trae/home/solo/setting/IUserEntStatusApi$Companion$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/UserEntUsageRequest;)V
    const/16 v17, 400
    const/16 v18, 0
    move-object/from16 v16, v20
    invoke-static/range v4 ... v18, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
