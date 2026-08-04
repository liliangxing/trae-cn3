# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;
.super Ljava/lang/Object;
.source "KmpHttpClientFactory.kt"

.field public static final $stable:I
.field private final client$delegate:Lkotlin/Lazy;
.field private final eventReporter:Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
.field private final headerProvider:Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final rawClientFactory:Lkotlin/jvm/functions/Function0;


.method public static synthetic $r8$lambda$j6KxRkBp8SV97zhS459YXq117uU(com.bytedance.trae.kmp.network.KmpHttpClientFactory)com.bytedance.trae.kmp.network.TraeKmpHttpClient
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->client_delegate$lambda$0(Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;)Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.network.KmpHttpHeaderProvider  com.bytedance.trae.kmp.network.KmpHttpEventReporter  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, rawClientFactory
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headerProvider"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "eventReporter"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->rawClientFactory Lkotlin/jvm/functions/Function0;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->headerProvider Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
    iput-object v4, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->eventReporter Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
    iput-object v5, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    new-instance v2, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;)V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->client$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  com.bytedance.trae.kmp.network.KmpHttpHeaderProvider  com.bytedance.trae.kmp.network.KmpHttpEventReporter  com.bytedance.trae.kmp.host.KmpHostInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    sget-object v4, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    check-cast v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;-><init>(Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider; Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-void 
.end method

.method private static final client_delegate$lambda$0(com.bytedance.trae.kmp.network.KmpHttpClientFactory)com.bytedance.trae.kmp.network.TraeKmpHttpClient
    .registers 5
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;
    iget-object v1, v4, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->rawClientFactory Lkotlin/jvm/functions/Function0;
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/network/KmpRawHttpClient;
    iget-object v2, v4, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->headerProvider Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider;
    iget-object v3, v4, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->eventReporter Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter;
    iget-object v4, v4, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/network/TraeKmpHttpClient;-><init>(Lcom/bytedance/trae/kmp/network/KmpRawHttpClient; Lcom/bytedance/trae/kmp/network/KmpHttpHeaderProvider; Lcom/bytedance/trae/kmp/network/KmpHttpEventReporter; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-object v0
.end method

.method private final getClient()com.bytedance.trae.kmp.network.KmpHttpClient
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->client$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    return-object v0
.end method

.method public final get()com.bytedance.trae.kmp.network.KmpHttpClient
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/network/KmpHttpClientFactory;->getClient()Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    move-result-object v0
    return-object v0
.end method
