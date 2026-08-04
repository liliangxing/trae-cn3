# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MinimizedVoiceBar.kt"

.implements Lkotlin/jvm/functions/Function2;

.field synthetic F$0:F
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;


.method constructor <init>(com.bytedance.trae.conversation.widget.MinimizedVoiceBar  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;-><init>(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->floatValue()F
    move-result v3
    iput v3, v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->F$0 F
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(float  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->floatValue()F
    move-result v1
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->invoke(F Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->label I
    if-nez v0, +02eh
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget v2, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->F$0 F
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->isMicMuted()Z
    move-result v0
    if-eqz v0, +00ch
    iget-object v2, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->access$getWaveIcon$p(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;)Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->stopAnimating()V
    goto +13h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->access$getWaveIcon$p(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;)Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->startAnimating()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar$bindHolder$2$1;->this$0 Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;->access$getWaveIcon$p(Lcom/bytedance/trae/conversation/widget/MinimizedVoiceBar;)Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;->updateVolume(F)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
