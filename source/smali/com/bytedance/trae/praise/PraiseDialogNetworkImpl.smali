# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;
.super Ljava/lang/Object;
.source "PraiseDialogNetworkImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogNetworkConfig;

.field private final api$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$_pu34VCFM9ApzlfAwzLJGZcWNzM()com.bytedance.trae.praise.PraiseDialogNetworkImpl$PraiseApi
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;->api_delegate$lambda$0()Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;->api$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final api_delegate$lambda$0()com.bytedance.trae.praise.PraiseDialogNetworkImpl$PraiseApi
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    const/4 v2, 0
    invoke-static v0, v1, v2, Lcom/bytedance/ttnet/utils/RetrofitUtils;->createSsRetrofit(Ljava/lang/String; Ljava/util/List; Lcom/bytedance/retrofit2/Converter$Factory;)Lcom/bytedance/retrofit2/Retrofit;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    invoke-virtual v0, v1, Lcom/bytedance/retrofit2/Retrofit;->create(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    return-object v0
.end method

.method private final getApi()com.bytedance.trae.praise.PraiseDialogNetworkImpl$PraiseApi
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;->api$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    return-object v0
.end method

.method public checkResponseException(java.lang.Throwable)int
    .registers 3
    # ins_size=2
    const-string v0, "e"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    return v2
.end method

.method public executeGet(int  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    const-string/jumbo v1, url
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;->getApi()Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    move-result-object v1
    invoke-interface v1, v2, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;->get(Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method

.method public executePost(int  java.lang.String  java.util.Map)java.lang.String
    .registers 4
    # ins_size=4
    const-string/jumbo v1, url
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, params
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl;->getApi()Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;
    move-result-object v1
    invoke-interface v1, v2, v3, Lcom/bytedance/trae/praise/PraiseDialogNetworkImpl$PraiseApi;->post(Ljava/lang/String; Ljava/util/Map;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v1
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    goto +2h
    const/4 v1, 0
    return-object v1
.end method
