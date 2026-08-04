# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $deviceId:Ljava/lang/String;
.field final synthetic $error:I
.field final synthetic $l:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.field final synthetic $state:I
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  java.lang.String  int  int  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$deviceId Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$state I
    iput v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$error I
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$deviceId Ljava/lang/String;
    iget v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$state I
    iget v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$error I
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Ljava/lang/String; I I Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->label I
    if-nez v0, +013h
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$deviceId Ljava/lang/String;
    iget v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$state I
    iget v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitRtcAudioInputDeviceStateChanged$1;->$error I
    invoke-interface v4, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;->onRtcAudioInputDeviceStateChanged(Ljava/lang/String; I I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
.end method
