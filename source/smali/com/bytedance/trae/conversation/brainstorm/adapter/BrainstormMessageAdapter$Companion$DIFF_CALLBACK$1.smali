# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;
.super Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
.source "BrainstormMessageAdapter.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;-><init>()V
    return-void 
.end method

.method public areContentsTheSame(com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage  com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage)boolean
    .registers 4
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public bridge synthetic areContentsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;->areContentsTheSame(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;)Z
    move-result v1
    return v1
.end method

.method public areItemsTheSame(com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage  com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage)boolean
    .registers 4
    # ins_size=3
    const-string v0, "oldItem"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newItem"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    return v2
.end method

.method public bridge synthetic areItemsTheSame(java.lang.Object  java.lang.Object)boolean
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    check-cast v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;->areItemsTheSame(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage; Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;)Z
    move-result v1
    return v1
.end method
