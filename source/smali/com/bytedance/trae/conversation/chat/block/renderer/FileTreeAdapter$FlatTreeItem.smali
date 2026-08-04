# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
.super Ljava/lang/Object;
.source "FileTreeAdapter.kt"

.field private final indentLevel:I
.field private final node:Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;


.method public constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  int)void
    .registers 4
    # ins_size=3
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$FlatTreeItem  com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  int  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$FlatTreeItem
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->copy(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; I)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    return-object v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  int)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$FlatTreeItem
    .registers 4
    # ins_size=3
    const-string v0, "node"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode; I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    iget v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getIndentLevel()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    return v0
.end method

.method public final getNode()com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "FlatTreeItem(node="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->node Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", indentLevel="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$FlatTreeItem;->indentLevel I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
