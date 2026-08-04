# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "PluginsViewModel.kt"

.field private final _error:Landroidx/lifecycle/MutableLiveData;
.field private final _isLoading:Landroidx/lifecycle/MutableLiveData;
.field private final _plugins:Landroidx/lifecycle/MutableLiveData;
.field private cliId:Ljava/lang/String;
.field private final error:Landroidx/lifecycle/LiveData;
.field private final isLoading:Landroidx/lifecycle/LiveData;
.field private final plugins:Landroidx/lifecycle/LiveData;
.field private workspaceFolder:Ljava/lang/String;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_plugins Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->plugins Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->isLoading Landroidx/lifecycle/LiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_error Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->error Landroidx/lifecycle/LiveData;
    return-void 
.end method

.method public static final synthetic access$get_error$p(com.bytedance.trae.conversation.plugin.PluginsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_error Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isLoading$p(com.bytedance.trae.conversation.plugin.PluginsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_plugins$p(com.bytedance.trae.conversation.plugin.PluginsViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_plugins Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getError()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->error Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getPlugins()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->plugins Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getWorkspaceFolder()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->workspaceFolder Ljava/lang/String;
    return-object v0
.end method

.method public final isLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->isLoading Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final loadPlugins()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->INSTANCE Lcom/bytedance/trae/conversation/plugin/PluginListCache;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->cliId Ljava/lang/String;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->workspaceFolder Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/PluginListCache;->getCachedPlugins(Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v1, v8, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->_plugins Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v1, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel$loadPlugins$1;-><init>(Lcom/bytedance/trae/conversation/plugin/PluginsViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final setCliId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->cliId Ljava/lang/String;
    return-void 
.end method

.method public final setWorkspaceFolder(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsViewModel;->workspaceFolder Ljava/lang/String;
    return-void 
.end method
