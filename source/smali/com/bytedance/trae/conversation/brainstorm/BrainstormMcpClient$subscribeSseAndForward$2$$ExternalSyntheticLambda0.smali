# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlinx/coroutines/CoroutineScope;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$2:Ljava/lang/StringBuilder;
.field public final synthetic f$3:Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
.field public final synthetic f$4:Ljava/lang/String;


.method public synthetic constructor <init>(kotlinx.coroutines.CoroutineScope  kotlin.jvm.internal.Ref$ObjectRef  java.lang.StringBuilder  com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient  java.lang.String)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/CoroutineScope;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$2 Ljava/lang/StringBuilder;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$0 Lkotlinx/coroutines/CoroutineScope;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$2 Ljava/lang/StringBuilder;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2$$ExternalSyntheticLambda0;->f$4 Ljava/lang/String;
    move-object v5, v7
    check-cast v5, Ljava/lang/String;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient$subscribeSseAndForward$2;->$r8$lambda$g0meyLnSLs-xVVfKV0G-VFXOfCA(Lkotlinx/coroutines/CoroutineScope; Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/StringBuilder; Lcom/bytedance/trae/conversation/brainstorm/BrainstormMcpClient; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v7
    return-object v7
.end method
