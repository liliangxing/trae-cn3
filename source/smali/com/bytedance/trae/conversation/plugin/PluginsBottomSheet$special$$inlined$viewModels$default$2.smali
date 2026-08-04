# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;
.super Lkotlin/jvm/internal/Lambda;
.source "FragmentViewModelLazy.kt"

.implements Lkotlin/jvm/functions/Function0;

.field final synthetic $ownerProducer:Lkotlin/jvm/functions/Function0;


.method public constructor <init>(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;->$ownerProducer Lkotlin/jvm/functions/Function0;
    const/4 v1, 0
    invoke-direct v0, v1, Lkotlin/jvm/internal/Lambda;-><init>(I)V
    return-void 
.end method

.method public final invoke()androidx.lifecycle.ViewModelStore
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;->$ownerProducer Lkotlin/jvm/functions/Function0;
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;
    invoke-interface v0, Landroidx/lifecycle/ViewModelStoreOwner;->getViewModelStore()Landroidx/lifecycle/ViewModelStore;
    move-result-object v0
    const-string v1, "ownerProducer().viewModelStore"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/plugin/PluginsBottomSheet$special$$inlined$viewModels$default$2;->invoke()Landroidx/lifecycle/ViewModelStore;
    move-result-object v0
    return-object v0
.end method
