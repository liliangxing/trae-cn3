# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;
.super Ljava/lang/Object;
.source "SubTaskProtocol.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor$Companion;-><init>()V
    return-void 
.end method

.method public final fromProtocol(java.lang.String)com.bytedance.trae.conversation.voice.subtask.SubTaskExecutor
    .registers 3
    # ins_size=2
    const-string/jumbo v0, server
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ServerClosedLoop Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;->ClientProxy Lcom/bytedance/trae/conversation/voice/subtask/SubTaskExecutor;
    return-object v2
.end method
