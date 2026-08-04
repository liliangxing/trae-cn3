# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
.super Ljava/lang/Object;
.source "IMarketplaceApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
.field private static final PAGE_SIZE:I


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final fetchMarketplacePlugins(kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=2
    instance-of v0, v15, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;
    invoke-direct v0, v14, v15, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;-><init>(Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->label I
    const/4 v3, 1
    if-eqz v2, +020h
    if-ne v2, v3, +016h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$3 Ljava/lang/Object;
    check-cast v2, Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/util/Set;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$1 Ljava/lang/Object;
    check-cast v5, Ljava/util/List;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +68h
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "marketplace"
    const-class v6, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;
    const/4 v7, 0
    sget-object v15, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->MARKETPLACE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v15, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 52
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    new-instance v4, Ljava/util/LinkedHashSet;
    invoke-direct v4, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v4, Ljava/util/Set;
    new-instance v5, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v5, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    move-object v6, v15
    move-object v13, v5
    move-object v5, v2
    move-object v2, v13
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v15
    const-string v7, "page_size"
    const-string v8, "200"
    invoke-interface v15, v7, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v7, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    if-eqz v7, +007h
    const-string v8, "page_token"
    invoke-interface v15, v8, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v15, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v15
    iput-object v6, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$1 Ljava/lang/Object;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$2 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->L$3 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi$Companion$fetchMarketplacePlugins$1;->label I
    invoke-interface v6, v15, v0, Lcom/bytedance/trae/conversation/network/IMarketplaceApi;->listPlugins(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v1, +003h
    return-object v1
    check-cast v15, Lcom/bytedance/trae/conversation/network/MarketplaceResponse;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/MarketplaceResponse;->isSuccess()Z
    move-result v7
    if-nez v7, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v15
    return-object v15
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/MarketplaceResponse;->getData()Lcom/bytedance/trae/conversation/network/MarketplacePluginsData;
    move-result-object v15
    if-nez v15, +003h
    goto +31h
    move-object v7, v5
    check-cast v7, Ljava/util/Collection;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/MarketplacePluginsData;->getAllPlugins()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-static v7, v8, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/MarketplacePluginsData;->getNextPageToken()Ljava/lang/String;
    move-result-object v15
    const/4 v7, 0
    if-eqz v15, +00dh
    move-object v8, v15
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v3
    if-eqz v8, +003h
    goto +2h
    move-object v15, v7
    iput-object v15, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    iget-object v15, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-eqz v15, +00dh
    iget-object v15, v2, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v15, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v4, v15, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v15
    if-nez v15, -06dh
    check-cast v5, Ljava/lang/Iterable;
    new-instance v15, Ljava/util/ArrayList;
    invoke-direct v15, Ljava/util/ArrayList;-><init>()V
    check-cast v15, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +022h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v3
    xor-int/2addr v2, v3
    if-eqz v2, -020h
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -25h
    check-cast v15, Ljava/util/List;
    check-cast v15, Ljava/lang/Iterable;
    const/16 v0, 10
    invoke-static v15, v0, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v0
    const/16 v1, 16
    invoke-static v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, v0, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v1, Ljava/util/Map;
    invoke-interface v15, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +018h
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/MarketplacePluginItem;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v1, v2, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    return-object v1
    new-instance v15, Ljava/util/concurrent/CancellationException;
    invoke-direct v15, Ljava/util/concurrent/CancellationException;-><init>()V
    throw v15
    :try_start_0x36
    :try_start_0x45
.end method
