# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $payload:Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.subtitle.SubtitleBinaryProtocol$SubtitlePayload  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;-><init>(Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->label I
    if-nez v0, +140h
    invoke-static v12, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v12, v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->$payload Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitlePayload;->getData()Ljava/util/List;
    move-result-object v12
    check-cast v12, Ljava/lang/Iterable;
    iget-object v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$handleSubvMessage$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +126h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getDefinite()Z
    move-result v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getText()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getParagraph()Z
    move-result v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/voice/subtitle/SubtitleBinaryProtocol$SubtitleItem;->getUserId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$resolveRole(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    const-string/jumbo v6, substring(...)
    const/4 v7, 0
    const/4 v8, 2
    const/4 v9, 0
    const-string v10, ""
    if-ne v1, v5, +081h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    invoke-static v3, v1, v9, v8, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +012h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v3, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    if-eqz v2, +025h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getUserDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setUserDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getUserDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setCurrentUserRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastUserNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    goto +1ch
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getUserDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setCurrentUserRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastUserNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitSubtitleText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getCurrentUserRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitRecognizedText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    if-eqz v4, -095h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getCurrentUserRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->USER Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitFinalText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setUserDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setCurrentUserRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastUserNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    goto/16 -0a9h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    invoke-static v3, v1, v9, v8, v7, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +012h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v3, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v1, v3
    if-eqz v2, +025h
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getBotDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setBotDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getBotDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setBotRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    goto +1ch
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getBotDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v5
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setBotRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitSubtitleText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getBotRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitRecognizedText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    if-eqz v4, -114h
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getBotRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;->BOT Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitFinalText(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setBotDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setBotRecognizedText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    invoke-static v0, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setLastBotNonDefiniteText$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)V
    goto/16 -128h
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v12
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
.end method
