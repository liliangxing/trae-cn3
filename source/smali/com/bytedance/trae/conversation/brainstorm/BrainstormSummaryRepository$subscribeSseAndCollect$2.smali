# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormSummaryRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $messageId:Ljava/lang/String;
.field final synthetic $onChunk:Lkotlin/jvm/functions/Function1;
.field final synthetic $sessionId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;


.method public static synthetic $r8$lambda$7kD54-dQJSHlxUR8lUZPxWNj_Uk(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  java.lang.StringBuilder  kotlin.jvm.functions.Function1  java.lang.String)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->invokeSuspend$lambda$1(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Ljava/lang/StringBuilder; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$sessionId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$messageId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$onChunk Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$1(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  java.lang.StringBuilder  kotlin.jvm.functions.Function1  java.lang.String)kotlin.Unit
    .registers 11
    # ins_size=7
    invoke-static v4, Lkotlinx/coroutines/CoroutineScopeKt;->isActive(Lkotlinx/coroutines/CoroutineScope;)Z
    move-result v4
    if-nez v4, +005h
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
    const-string v4, "event:"
    const/4 v0, 0
    const/4 v1, 2
    const/4 v2, 0
    invoke-static v10, v4, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +016h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v10, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    iput-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    goto/16 +097h
    const-string v4, "data:"
    invoke-static v10, v4, v0, v1, v2, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +027h
    move-object v5, v6
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +003h
    move v0, v2
    if-eqz v0, +007h
    const-string v5, "
"
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v10, v4, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto +68h
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +061h
    move-object v4, v6
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v2, v0
    if-eqz v2, +054h
    iget-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v1, toString(...)
    invoke-static v10, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v7, v4, v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->access$extractTextFromEvent(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    if-eqz v9, +00ch
    invoke-virtual v8, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v9, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v8, "SSE event: type="
    invoke-direct v7, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v8, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", chunkLen="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    if-eqz v4, +006h
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v0
    invoke-virtual v7, v0, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string v7, "BrainstormSummaryRepo"
    invoke-static v7, v4, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    const-string v4, ""
    iput-object v4, v5, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-static v6, Lkotlin/text/StringsKt;->clear(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$sessionId Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$messageId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$onChunk Lkotlin/jvm/functions/Function1;
    move-object v0, v6
    move-object v5, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlin/coroutines/Continuation;
    return-object v6
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v1, v16
    const-string/jumbo v0, toString(...)
    const-string v2, "BrainstormSummaryRepo"
    const-string/jumbo v3, subscribeSse failed: 
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->label I
    if-nez v4, +0d8h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->L$0 Ljava/lang/Object;
    move-object v6, v4
    check-cast v6, Lkotlinx/coroutines/CoroutineScope;
    sget-object v4, Lcom/bytedance/trae/im/service/ISendMessageService;->Companion Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    const-string v5, "Accept"
    const-string/jumbo v7, text/event-stream
    invoke-static v5, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->createService(Ljava/util/Map;)Lcom/bytedance/trae/im/service/ISendMessageService;
    move-result-object v4
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$sessionId Ljava/lang/String;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$messageId Ljava/lang/String;
    invoke-interface v4, v5, v7, Lcom/bytedance/trae/im/service/ISendMessageService;->subscribeSseEvents(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/retrofit2/Call;
    move-result-object v4
    const/4 v12, 0
    invoke-interface v4, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->isSuccessful()Z
    move-result v7
    if-nez v7, +017h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v2, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-object v12
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->raw()Lcom/bytedance/retrofit2/client/Response;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/retrofit2/client/Response;->getBody()Lcom/bytedance/retrofit2/mime/TypedInput;
    move-result-object v3
    if-nez v3, +009h
    const-string/jumbo v0, subscribeSse: response body is null
    invoke-static v2, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-object v12
    new-instance v5, Ljava/io/BufferedReader;
    new-instance v7, Ljava/io/InputStreamReader;
    invoke-interface v3, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v3
    sget-object v8, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v7, v3, v8, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v7, Ljava/io/Reader;
    invoke-direct v5, v7, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    new-instance v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    const-string v7, ""
    iput-object v7, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, Ljava/lang/StringBuilder;-><init>()V
    move-object v15, v5
    check-cast v15, Ljava/io/Reader;
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$onChunk Lkotlin/jvm/functions/Function1;
    new-instance v10, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;
    move-object v5, v10
    move-object v7, v13
    move-object v8, v14
    move-object v12, v10
    move-object v10, v3
    invoke-direct/range v5 ... v11, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Ljava/lang/StringBuilder; Lkotlin/jvm/functions/Function1;)V
    invoke-static v15, v12, Lkotlin/io/TextStreamsKt;->forEachLine(Ljava/io/Reader; Lkotlin/jvm/functions/Function1;)V
    move-object v5, v14
    check-cast v5, Ljava/lang/CharSequence;
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-lez v5, +004h
    const/4 v5, 1
    goto +2h
    const/4 v5, 0
    if-eqz v5, +026h
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iget-object v6, v13, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v6, Ljava/lang/String;
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, v6, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;->access$extractTextFromEvent(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +013h
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$onChunk Lkotlin/jvm/functions/Function1;
    if-eqz v5, +00ch
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v5, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v12
    goto +12h
    move-exception v0
    const-string/jumbo v3, subscribeSse error
    invoke-static v2, v3, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    goto +9h
    const-string v0, "SSE subscription cancelled"
    invoke-static v2, v0, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    invoke-interface v4, Lcom/bytedance/retrofit2/Call;->cancel()V
    const/4 v12, 0
    return-object v12
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    :try_start_0x35
.end method
