# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DeleteAccountFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $countdown:Lkotlin/jvm/internal/Ref$IntRef;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;


.method constructor <init>(kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.home.solo.setting.DeleteAccountFragment  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;-><init>(Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->label I
    const/4 v2, 1
    if-eqz v1, +011h
    if-ne v1, v2, +007h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    goto +21h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    iget v1, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-lez v1, +04eh
    move-object v1, v9
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->label I
    const-wide/16 v3, 1000
    invoke-static v3, v4, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    iget v1, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    add-int/lit8 v1, v1, -1
    iput v1, v3, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->isAdded()Z
    move-result v1
    if-nez v1, +005h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    iget-object v1, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$getBtnOkCountdown$p(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)Landroid/widget/TextView;
    move-result-object v1
    if-nez v1, +008h
    const-string v1, "btnOkCountdown"
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v1, 0
    iget-object v3, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    sget v4, Lcom/bytedance/trae/home/R$string;->trae_delete_ok_countdown I
    new-array v5, v2, [Ljava/lang/Object;
    iget-object v6, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->$countdown Lkotlin/jvm/internal/Ref$IntRef;
    iget v6, v6, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-static v6, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    const/4 v7, 0
    aput-object v6, v5, v7
    invoke-virtual v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto -51h
    iget-object v9, v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$startFinishCountdown$1;->this$0 Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;
    invoke-static v9, Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;->access$navigateToLogin(Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
