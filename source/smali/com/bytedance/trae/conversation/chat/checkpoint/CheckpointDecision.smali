# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;
.super Ljava/lang/Object;
.source "CheckpointInteraction.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDecision;-><init>()V
    return-void 
.end method

.method public abstract getConversationId()java.lang.String
    # abstract or native
.end method

.method public abstract getPlanItemId()java.lang.String
    # abstract or native
.end method

.method public abstract getTaskId()java.lang.String
    # abstract or native
.end method

.method public abstract getToolName()java.lang.String
    # abstract or native
.end method
