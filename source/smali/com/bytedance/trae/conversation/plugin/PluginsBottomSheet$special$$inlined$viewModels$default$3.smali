# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;
.super Lkotlin/jvm/internal/Lambda;
.source "FragmentViewModelLazy.kt"

.implements Lkotlin/jvm/functions/Function0;

.field final synthetic $ownerProducer:Lkotlin/jvm/functions/Function0;
.field final synthetic $this_viewModels:Landroidx/fragment/app/Fragment;


.method public constructor <init>(kotlin.jvm.functions.Function0  androidx.fragment.app.Fragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;->$ownerProducer Lkotlin/jvm/functions/Function0;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;->$this_viewModels Landroidx/fragment/app/Fragment;
    const/4 v1, 0
    invoke-direct v0, v1, Lkotlin/jvm/internal/Lambda;-><init>(I)V
    return-void 
.end method

.method public final invoke()androidx.lifecycle.ViewModelProvider$Factory
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;->$ownerProducer Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroidx/lifecycle/HasDefaultViewModelProviderFactory;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Landroidx/lifecycle/HasDefaultViewModelProviderFactory;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    goto +5h
    invoke-interface v0, Landroidx/lifecycle/HasDefaultViewModelProviderFactory;->getDefaultViewModelProviderFactory()Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v2
    if-nez v2, +008h
    iget-object v0, v3, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;->$this_viewModels Landroidx/fragment/app/Fragment;
    invoke-virtual v0, Landroidx/fragment/app/Fragment;->getDefaultViewModelProviderFactory()Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v2
    const-string v0, "(ownerProducer() as? Has…tViewModelProviderFactory"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$3;->invoke()Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v0
    return-object v0
.end method
