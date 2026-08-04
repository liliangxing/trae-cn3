# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageSettingsFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;


.method constructor <init>(com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    move-exception v4
    goto +6bh
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    move-object v1, v3
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->label I
    invoke-virtual v4, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->fetchPreferences(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v0, +003h
    return-object v0
    check-cast v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;->getPreferences()Ljava/util/Map;
    move-result-object v0
    if-eqz v0, +00ch
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-static v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$setPreferences$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/Map;)V
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->save(Ljava/util/Map;)V
    if-eqz v4, +01ch
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;->getItems()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +016h
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    move-object v1, v4
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v2
    if-eqz v1, +00ah
    invoke-static v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$setItems$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment; Ljava/util/List;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->saveItems(Ljava/util/List;)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-static v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$getLoadingView$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;)Landroid/widget/ProgressBar;
    move-result-object v4
    if-eqz v4, +007h
    const/16 v0, 8
    invoke-virtual v4, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-static v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$getScrollView$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;)Landroid/widget/ScrollView;
    move-result-object v4
    if-eqz v4, +006h
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/widget/ScrollView;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment$fetchLatest$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;
    invoke-static v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;->access$renderItems(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageSettingsFragment;)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    throw v4
    :try_start_0xb
    :try_start_0x1c
.end method
