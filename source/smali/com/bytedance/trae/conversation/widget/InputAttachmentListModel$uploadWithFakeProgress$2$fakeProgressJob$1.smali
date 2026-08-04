# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "InputAttachmentListModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $backendProgress:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic $displayedProgress:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic $fakeProgress:Lkotlin/jvm/internal/Ref$IntRef;
.field final synthetic $itemUri:Landroid/net/Uri;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;


.method constructor <init>(kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef  com.bytedance.trae.conversation.widget.InputAttachmentListModel  android.net.Uri  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$fakeProgress Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$backendProgress Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$displayedProgress Lkotlin/jvm/internal/Ref$IntRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$itemUri Landroid/net/Uri;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$fakeProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$backendProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$displayedProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$itemUri Landroid/net/Uri;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;-><init>(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->label I
    const/16 v2, 30
    const/4 v3, 1
    if-eqz v1, +011h
    if-ne v1, v3, +007h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    goto +21h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v8
    iget-object v1, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$fakeProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget v1, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-ge v1, v2, +029h
    move-object v1, v9
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v3, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->label I
    const-wide/16 v4, 200
    invoke-static v4, v5, v1, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$fakeProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget v4, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    add-int/2addr v4, v3
    invoke-static v4, v2, Ljava/lang/Math;->min(I I)I
    move-result v4
    iput v4, v1, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget-object v1, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$backendProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v4, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$fakeProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$displayedProgress Lkotlin/jvm/internal/Ref$IntRef;
    iget-object v6, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel;
    iget-object v7, v9, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2$fakeProgressJob$1;->$itemUri Landroid/net/Uri;
    invoke-static v1, v4, v5, v6, v7, Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel$uploadWithFakeProgress$2;->access$invokeSuspend$updateDisplayedProgress(Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef; Lcom/bytedance/trae/conversation/widget/InputAttachmentListModel; Landroid/net/Uri;)V
    goto -2ch
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
