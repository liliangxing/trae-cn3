# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "TraePressableIcon.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $clickFeedbackActive$delegate:Landroidx/compose/runtime/MutableState;
.field final synthetic $clickFeedbackDurationMillis:J
.field  label:I


.method constructor <init>(long  androidx.compose.runtime.MutableState  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-wide v1, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackDurationMillis J
    iput-object v3, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackActive$delegate Landroidx/compose/runtime/MutableState;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;
    iget-wide v0, v3, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackDurationMillis J
    iget-object v2, v3, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackActive$delegate Landroidx/compose/runtime/MutableState;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;-><init>(J Landroidx/compose/runtime/MutableState; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-wide v3, v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackDurationMillis J
    move-object v6, v5
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->label I
    invoke-static v3, v4, v6, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    iget-object v6, v5, Lcom/bytedance/trae/design/compose/TraePressableIconKt$TraePressableIcon$1$1$1;->$clickFeedbackActive$delegate Landroidx/compose/runtime/MutableState;
    const/4 v0, 0
    invoke-static v6, v0, Lcom/bytedance/trae/design/compose/TraePressableIconKt;->access$TraePressableIcon_v_nKSRU$lambda$4(Landroidx/compose/runtime/MutableState; Z)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
