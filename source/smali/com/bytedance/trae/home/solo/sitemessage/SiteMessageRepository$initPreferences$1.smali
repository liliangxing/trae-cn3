# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 3
    # ins_size=3
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/coroutines/Continuation;
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3fh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->createService()Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    move-result-object v6
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v3, "platform"
    const-string v4, "Android"
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 0
    aput-object v3, v1, v4
    const-string/jumbo v3, storeCountryCode
    sget-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->getPreferences(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    check-cast v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;->getPreferences()Ljava/util/Map;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;
    move-result-object v0
    if-eqz v0, +017h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;->getItems()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +011h
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +007h
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->saveItems(Ljava/util/List;)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;
    move-result-object v6
    if-eqz v6, +007h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;->getLastUpdatedBy()Ljava/lang/String;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    if-nez v6, +007h
    sget-object v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-static v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->access$migrateDefaultPreferences(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    :try_start_0xb
    :try_start_0x1a
.end method
