# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;
.super Lkotlin/jvm/internal/Lambda;
.source "ActivityViewModelLazy.kt"

.implements Lkotlin/jvm/functions/Function0;

.field final synthetic $this_viewModels:Landroidx/activity/ComponentActivity;


.method public constructor <init>(androidx.activity.ComponentActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;->$this_viewModels Landroidx/activity/ComponentActivity;
    const/4 v1, 0
    invoke-direct v0, v1, Lkotlin/jvm/internal/Lambda;-><init>(I)V
    return-void 
.end method

.method public final invoke()androidx.lifecycle.ViewModelProvider$Factory
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;->$this_viewModels Landroidx/activity/ComponentActivity;
    invoke-virtual v0, Landroidx/activity/ComponentActivity;->getDefaultViewModelProviderFactory()Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v0
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$1;->invoke()Landroidx/lifecycle/ViewModelProvider$Factory;
    move-result-object v0
    return-object v0
.end method
