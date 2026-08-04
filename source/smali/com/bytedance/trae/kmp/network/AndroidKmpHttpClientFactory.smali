# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
.super Ljava/lang/Object;
.source "AndroidKmpHttpClientFactory.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
.field private static final factory:Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;


.method public static synthetic $r8$lambda$XVQsdUDKt5WdEXB3Yq76zwy3bxw()com.bytedance.trae.kmp.network.KmpRawHttpClient
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->factory$lambda$0()Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 9
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;-><init>()V
    sput-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;
    new-instance v2, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory$$ExternalSyntheticLambda0;-><init>()V
    new-instance v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 7
    const/4 v8, 0
    move-object v3, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function3; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
    new-instance v1, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;
    const/4 v5, 1
    invoke-direct v1, v4, v5, v4, Lcom/bytedance/trae/kmp/network/NativeKmpHttpEventReporter;-><init>(Lkotlin/jvm/functions/Function5; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
    const/4 v5, 0
    const/16 v6, 8
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;-><init>(Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider; Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter; Lcom/bytedance/trae/kmp/host/KmpHostInfo; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->factory Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final factory$lambda$0()com.bytedance.trae.kmp.network.KmpRawHttpClient
    .registers 3
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->INSTANCE Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpNetworkInitializer;->ensureRegistered()V
    new-instance v0, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;
    const/4 v1, 0
    const/4 v2, 3
    invoke-direct v0, v1, v1, v2, v1, Lcom/bytedance/trae/kmp/network/AndroidKmpRawHttpClient;-><init>(Lcom/bytedance/trae/kmp/network/AndroidKmpRequestFactory; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    return-object v0
.end method

.method public final get()com.bytedance.trae.kmp.network.KmpHttpClient
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->factory Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->get()Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    move-result-object v0
    return-object v0
.end method
