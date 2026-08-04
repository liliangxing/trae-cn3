# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;
.super Lkotlin/jvm/internal/Lambda;
.source "FragmentViewModelLazy.kt"

.implements Lkotlin/jvm/functions/Function0;

.field final synthetic $this_viewModels:Landroidx/fragment/app/Fragment;


.method public constructor <init>(androidx.fragment.app.Fragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;->$this_viewModels Landroidx/fragment/app/Fragment;
    const/4 v1, 0
    invoke-direct v0, v1, Lkotlin/jvm/internal/Lambda;-><init>(I)V
    return-void 
.end method

.method public final invoke()androidx.fragment.app.Fragment
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;->$this_viewModels Landroidx/fragment/app/Fragment;
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$1;->invoke()Landroidx/fragment/app/Fragment;
    move-result-object v0
    return-object v0
.end method
