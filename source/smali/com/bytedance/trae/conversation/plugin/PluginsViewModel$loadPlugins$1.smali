# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginsViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cached:Ljava/util/List;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;


.method constructor <init>(com.bytedance.trae.conversation.plugin.PluginsViewModel  java.util.List  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->$cached Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->$cached Ljava/util/List;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    const-string v0, "load_error:"
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +019h
    if-ne v2, v4, +00fh
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4ch
    move-exception v9
    goto/16 +0c2h
    move-exception v9
    goto/16 +077h
    move-exception v9
    goto/16 +0bbh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v9
    iget-object v2, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->$cached Ljava/util/List;
    if-nez v2, +004h
    move v2, v4
    goto +2h
    move v2, v5
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v9, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v9
    invoke-virtual v9, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->getCliId()Ljava/lang/String;
    move-result-object v2
    iget-object v6, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->getWorkspaceFolder()Ljava/lang/String;
    move-result-object v6
    move-object v7, v8
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v4, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->label I
    invoke-virtual v9, v2, v6, v7, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getPlugins(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    check-cast v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_plugins$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;->getPlugins()Ljava/util/List;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/plugin/PluginListCache$PluginListResult;->getPlugins()Ljava/util/List;
    move-result-object v9
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v9
    if-eqz v9, +00bh
    iget-object v9, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v9
    invoke-virtual v9, v3, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v9
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v9, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    goto +45h
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_plugins$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    invoke-virtual v1, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v4, v5
    if-eqz v4, +00dh
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_error$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v1
    const-string v2, "Failed to load plugins"
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    const-string v2, "plugin_list"
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v9, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v9
    if-eqz v9, +008h
    const/16 v0, 100
    invoke-static v9, v0, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v1, v2, v9, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    goto -51h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    throw v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;->this$0 Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
    invoke-static v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->access$get_isLoading$p(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    throw v9
    :try_start_0xf
    :try_start_0x44
    :try_start_0x8e
    :try_start_0xd5
.end method
