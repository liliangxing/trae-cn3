# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
.super Ljava/lang/Object;
.source "CNBillingVersionApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
.field private static final ANDROID_REQUEST_SOURCE:I
.field private static final PATH:Ljava/lang/String;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$Iwld5EiYdYTEWoyj4WWicZzGdl4(com.bytedance.trae.home.solo.setting.SwitchCnBillingVersionRequest  com.bytedance.trae.home.solo.setting.ICNBillingVersionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->switchCnBillingVersionRawCall$lambda$1(Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest; Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$pqImBZiOjsmLAdBI-JWyLlaZW1I(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->switchCnBillingVersionRawCall$lambda$0(Ljava/lang/String; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final switchCnBillingVersionRawCall$lambda$0(java.lang.String  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.network.response.BizResponse
    .registers 3
    # ins_size=2
    const-string v0, "body"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->INSTANCE Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;
    invoke-virtual v2, v1, Lcom/bytedance/trae/home/solo/setting/CNCommercialApiParser;->parseBillingSwitch(Ljava/lang/String;)Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    return-object v1
.end method

.method private static final switchCnBillingVersionRawCall$lambda$1(com.bytedance.trae.home.solo.setting.SwitchCnBillingVersionRequest  com.bytedance.trae.home.solo.setting.ICNBillingVersionApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;->switchCnBillingVersionRaw(Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final switchCnBillingVersionRawCall(kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 5
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest;-><init>(I Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-class v5, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi;
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v7
    sget-object v10, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const-string/jumbo v4, switch_cn_billing_version
    const-string v6, "/trae/api/v2/pay/switch_cn_billing_version"
    const/4 v8, 0
    const/4 v9, 0
    const/4 v11, 1
    const/4 v12, 1
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion$$ExternalSyntheticLambda0;
    invoke-direct v13, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion$$ExternalSyntheticLambda0;-><init>()V
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion$$ExternalSyntheticLambda1;
    invoke-direct v14, v0, Lcom/bytedance/trae/home/solo/setting/ICNBillingVersionApi$Companion$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/SwitchCnBillingVersionRequest;)V
    const/16 v16, 48
    const/16 v17, 0
    move-object/from16 v15, v19
    invoke-static/range v3 ... v17, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Z Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
