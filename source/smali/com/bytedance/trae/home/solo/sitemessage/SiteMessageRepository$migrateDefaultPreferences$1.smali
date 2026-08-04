# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $defaults:Ljava/util/Map;
.field  label:I


.method constructor <init>(java.util.Map  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->$defaults Ljava/util/Map;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->$defaults Ljava/util/Map;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;-><init>(Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->$defaults Ljava/util/Map;
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;->label I
    invoke-virtual v5, v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updatePreferences(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    check-cast v5, Ljava/util/Map;
    if-eqz v5, +007h
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    :try_start_0xb
    :try_start_0x1a
.end method
