# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;
.super Ljava/lang/Object;
.source "InputFragment.kt"

.implements Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/widget/InputFragment;


.method constructor <init>(com.bytedance.trae.conversation.widget.InputFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onError(java.lang.Throwable)void
    .registers 6
    # ins_size=2
    const-string v0, "error"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$currentInputStateNameForMetrics(Lcom/bytedance/trae/conversation/widget/InputFragment;)Ljava/lang/String;
    move-result-object v1
    iget-object v2, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v2, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v2
    if-nez v2, +009h
    const-string/jumbo v2, voiceChatSessionManager
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v2, 0
    sget-object v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->Companion Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Companion;->failureReasonFor(Ljava/lang/Throwable;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v0, v1, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$get_binding$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v5, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +00fh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_voice_error I
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v5
    const-string v1, "getString(...)"
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v1, 0
    invoke-static v0, v5, v1, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v5
    invoke-virtual v5, Landroid/widget/Toast;->show()V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$hideVoiceLoading(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$resetInputBar(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public onFinalText(java.lang.String)void
    .registers 11
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onFinalText:"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 32
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getNeedTranscript$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Z
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "VoiceChatSession"
    invoke-static v1, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$currentInputStateNameForMetrics(Lcom/bytedance/trae/conversation/widget/InputFragment;)Ljava/lang/String;
    move-result-object v4
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$get_binding$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v0
    const/4 v2, 0
    const-string/jumbo v3, voiceChatSessionManager
    if-nez v0, +017h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v10, "error"
    const-string v0, "binding_missing"
    invoke-virtual v2, v10, v4, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/TraeAITracker;
    const-string v5, "asr_recog_end"
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/tracker/TraeAITracker;->trackAsrRecog(Ljava/lang/String;)V
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v5
    const/4 v6, 0
    const/4 v7, 1
    if-lez v5, +004h
    move v5, v7
    goto +2h
    move v5, v6
    if-eqz v5, +0d0h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getNeedTranscript$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Z
    move-result v5
    if-eqz v5, +0b2h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getAsrCount()I
    move-result v5
    iget-object v8, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    add-int/2addr v5, v7
    invoke-static v8, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$setAsrCount$p(Lcom/bytedance/trae/conversation/widget/InputFragment; I)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentInputState()Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v5
    sget-object v8, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sending Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v5, v8, +030h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentInputState()Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v5
    sget-object v8, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Sended Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v5, v8, +026h
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getCurrentInputState()Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    move-result-object v5
    sget-object v8, Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;->Stopped Lcom/bytedance/trae/conversation/widget/InputFragment$InputState;
    if-eq v5, v8, +01ch
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->isTaskRunning()Lkotlin/jvm/functions/Function0;
    move-result-object v5
    if-eqz v5, +010h
    invoke-interface v5, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Boolean;
    invoke-virtual v5, Ljava/lang/Boolean;->booleanValue()Z
    move-result v5
    if-ne v5, v7, +004h
    move v5, v7
    goto +2h
    move v5, v6
    if-nez v5, +003h
    move v6, v7
    if-eqz v6, +039h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->getQuery(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->hideKeyboard()V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, v7, Lcom/bytedance/trae/conversation/widget/InputFragment;->setSendingState(Z)V
    iget-object v5, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->getOnSendAudioText()Lkotlin/jvm/functions/Function2;
    move-result-object v5
    if-eqz v5, +005h
    invoke-interface v5, v0, v10, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v3, "auto_send"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const-string v10, "onSendAudioText"
    invoke-static v1, v10, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    goto/16 +095h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget-object v5, Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;->Normal Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;
    invoke-static v10, v5, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$setHoldToTalkState$p(Lcom/bytedance/trae/conversation/widget/InputFragment; Lcom/bytedance/trae/conversation/widget/InputFragment$HoldToTalkState;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$updateHoldToTalkUI(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getBinding(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;
    move-result-object v10
    iget-object v10, v10, Lcom/bytedance/trae/conversation/databinding/TraeFragmentInputBinding;->etInput Lcom/bytedance/trae/conversation/widget/TranscriptEditText;
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/widget/TranscriptEditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v3, "fill_input"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    const-string/jumbo v10, setText
    invoke-static v1, v10, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    goto +61h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v3, "cancel"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +4bh
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getNeedTranscript$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Z
    move-result v10
    if-eqz v10, +02fh
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->requireContext()Landroid/content/Context;
    move-result-object v10
    iget-object v0, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->voice_no_text_recognized I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v10, v0, v6, Landroid/widget/Toast;->makeText(Landroid/content/Context; Ljava/lang/CharSequence; I)Landroid/widget/Toast;
    move-result-object v10
    invoke-virtual v10, Landroid/widget/Toast;->show()V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v3, "empty_text"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    goto +16h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$getVoiceChatSessionManager$p(Lcom/bytedance/trae/conversation/widget/InputFragment;)Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    move-result-object v10
    if-nez v10, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v2, v10
    const-string v3, "cancel"
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->reportAttemptOutcome$default(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$hideVoiceLoading(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-static v10, Lcom/bytedance/trae/conversation/widget/InputFragment;->access$resetInputBar(Lcom/bytedance/trae/conversation/widget/InputFragment;)V
    return-void 
.end method

.method public onLocalAudioVolume(float)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/InputFragment$voiceChatListener$1;->this$0 Lcom/bytedance/trae/conversation/widget/InputFragment;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/InputFragment;->getVoiceRecordingOverlay()Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/widget/VoiceRecordingOverlay;->updateVolume(F)V
    return-void 
.end method

.method public onRecognizedText(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onRecognizedText:"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "VoiceChatSession"
    invoke-static v0, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public onStatus(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$Status)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onStatus:"
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "VoiceChatSession"
    invoke-static v0, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method
