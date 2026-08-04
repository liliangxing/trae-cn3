# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;
.super Ljava/lang/Object;
.source "BrainstormSessionHolder.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;
    return-void 
.end method

.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final emit(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder;->access$stampTerminalOnSnapshot(Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder; Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$startSubTaskTerminalCollect$1$2$1;->emit(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method
