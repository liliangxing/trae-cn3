# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptLifecycleKt;
.super Ljava/lang/Object;
.source "BillingUpgradePromptLifecycle.kt"


.method public static final launchManagedPromptResolutionWhenResumed(kotlinx.coroutines.CoroutineScope  androidx.lifecycle.Lifecycle  kotlin.jvm.functions.Function1)kotlinx.coroutines.Job
    .registers 10
    # ins_size=3
    const-string v0, "<this>"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "lifecycle"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, resolveWhileResumed
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptLifecycleKt$launchManagedPromptResolutionWhenResumed$1;
    const/4 v1, 0
    invoke-direct v0, v8, v9, v1, Lcom/bytedance/trae/conversation/billing/BillingUpgradePromptLifecycleKt$launchManagedPromptResolutionWhenResumed$1;-><init>(Landroidx/lifecycle/Lifecycle; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    move-object v1, v7
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v7
    return-object v7
.end method
