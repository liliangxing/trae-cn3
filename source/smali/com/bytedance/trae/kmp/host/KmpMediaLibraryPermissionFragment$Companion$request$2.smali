# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "AndroidKmpMediaLibraryHandler.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $activity:Landroidx/fragment/app/FragmentActivity;
.field  L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(androidx.fragment.app.FragmentActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->$activity Landroidx/fragment/app/FragmentActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;
    iget-object v0, v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->$activity Landroidx/fragment/app/FragmentActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;-><init>(Landroidx/fragment/app/FragmentActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->label I
    const/4 v2, 1
    if-eqz v1, +014h
    if-ne v1, v2, +00ah
    iget-object v0, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->L$0 Ljava/lang/Object;
    check-cast v0, Landroidx/fragment/app/FragmentActivity;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +63h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->$activity Landroidx/fragment/app/FragmentActivity;
    iput-object v8, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->L$0 Ljava/lang/Object;
    iput v2, v7, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;->label I
    move-object v1, v7
    check-cast v1, Lkotlin/coroutines/Continuation;
    new-instance v3, Lkotlinx/coroutines/CancellableContinuationImpl;
    invoke-static v1, Lkotlin/coroutines/intrinsics/IntrinsicsKt;->intercepted(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v4
    invoke-direct v3, v4, v2, Lkotlinx/coroutines/CancellableContinuationImpl;-><init>(Lkotlin/coroutines/Continuation; I)V
    invoke-virtual v3, Lkotlinx/coroutines/CancellableContinuationImpl;->initCancellability()V
    move-object v2, v3
    check-cast v2, Lkotlinx/coroutines/CancellableContinuation;
    invoke-virtual v8, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v8
    const-string v4, "getSupportFragmentManager(...)"
    invoke-static v8, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v4, "KmpMediaLibraryPermission"
    invoke-virtual v8, v4, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v5
    instance-of v6, v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
    if-eqz v6, +005h
    check-cast v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
    goto +2h
    const/4 v5, 0
    if-nez v5, +015h
    new-instance v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
    invoke-direct v5, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;-><init>()V
    invoke-virtual v8, Landroidx/fragment/app/FragmentManager;->beginTransaction()Landroidx/fragment/app/FragmentTransaction;
    move-result-object v8
    move-object v6, v5
    check-cast v6, Landroidx/fragment/app/Fragment;
    invoke-virtual v8, v6, v4, Landroidx/fragment/app/FragmentTransaction;->add(Landroidx/fragment/app/Fragment; Ljava/lang/String;)Landroidx/fragment/app/FragmentTransaction;
    move-result-object v8
    invoke-virtual v8, Landroidx/fragment/app/FragmentTransaction;->commitNow()V
    invoke-virtual v5, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->requestPermission(Lkotlinx/coroutines/CancellableContinuation;)V
    invoke-virtual v3, Lkotlinx/coroutines/CancellableContinuationImpl;->getResult()Ljava/lang/Object;
    move-result-object v8
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    if-ne v8, v2, +005h
    invoke-static v1, Lkotlin/coroutines/jvm/internal/DebugProbesKt;->probeCoroutineSuspended(Lkotlin/coroutines/Continuation;)V
    if-ne v8, v0, +003h
    return-object v0
    return-object v8
.end method
