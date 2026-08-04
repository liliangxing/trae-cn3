# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;
.super Lkotlin/jvm/internal/Lambda;
.source "ActivityViewModelLazy.kt"

.implements Lkotlin/jvm/functions/Function0;

.field final synthetic $this_viewModels:Landroidx/activity/ComponentActivity;


.method public constructor <init>(androidx.activity.ComponentActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;->$this_viewModels Landroidx/activity/ComponentActivity;
    const/4 v1, 0
    invoke-direct v0, v1, Lkotlin/jvm/internal/Lambda;-><init>(I)V
    return-void 
.end method

.method public final invoke()androidx.lifecycle.ViewModelStore
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;->$this_viewModels Landroidx/activity/ComponentActivity;
    invoke-virtual v0, Landroidx/activity/ComponentActivity;->getViewModelStore()Landroidx/lifecycle/ViewModelStore;
    move-result-object v0
    const-string/jumbo v1, viewModelStore
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/activity/VerifyCodeActivity$special$$inlined$viewModels$default$2;->invoke()Landroidx/lifecycle/ViewModelStore;
    move-result-object v0
    return-object v0
.end method
