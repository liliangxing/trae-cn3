# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlinx/coroutines/CoroutineScope;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$2:Ljava/lang/StringBuilder;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
.field public final synthetic f$4:Ljava/lang/StringBuilder;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormSummaryRepository  java.lang.StringBuilder  kotlin.jvm.functions.Function1)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/CoroutineScope;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$2 Ljava/lang/StringBuilder;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$4 Ljava/lang/StringBuilder;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$5 Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/CoroutineScope;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$2 Ljava/lang/StringBuilder;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$4 Ljava/lang/StringBuilder;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2$$ExternalSyntheticLambda0;->f$5 Lkotlin/jvm/functions/Function1;
    move-object v6, v8
    check-cast v6, Ljava/lang/String;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository$subscribeSseAndCollect$2;->$r8$lambda$7kD54-dQJSHlxUR8lUZPxWNj_Uk(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormSummaryRepository; Ljava/lang/StringBuilder; Lkotlin/jvm/functions/Function1; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
