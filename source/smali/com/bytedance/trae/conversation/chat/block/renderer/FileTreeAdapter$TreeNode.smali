# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
.super Ljava/lang/Object;
.source "FileTreeAdapter.kt"

.field private final children:Ljava/util/List;
.field private expanded:Z
.field private final fileAction:Ljava/lang/String;
.field private final filePath:Ljava/lang/String;
.field private final indentLevel:I
.field private final isFolder:Z
.field private final name:Ljava/lang/String;


.method public constructor <init>(java.lang.String  boolean  java.lang.String  int  boolean  java.lang.String  java.util.List)void
    .registers 9
    # ins_size=8
    const-string v0, "name"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    iput-object v8, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  boolean  java.lang.String  int  boolean  java.lang.String  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 4
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v18, 8
    if-eqz v0, +005h
    const/4 v0, 0
    move v6, v0
    goto +2h
    move v6, v14
    and-int/lit8 v0, v18, 16
    if-eqz v0, +005h
    const/4 v0, 1
    move v7, v0
    goto +2h
    move v7, v15
    and-int/lit8 v0, v18, 32
    if-eqz v0, +004h
    move-object v8, v1
    goto +3h
    move-object/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +00bh
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    move-object v9, v0
    goto +3h
    move-object/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move v4, v12
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode  java.lang.String  boolean  java.lang.String  int  boolean  java.lang.String  java.util.List  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-boolean v7, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    move v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget v9, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    move v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-boolean v10, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    move v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move v9, v14
    move-object v10, v0
    move v11, v1
    move v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->copy(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    return v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    return v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    return v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final component7()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    return-object v0
.end method

.method public final copy(java.lang.String  boolean  java.lang.String  int  boolean  java.lang.String  java.util.List)com.bytedance.trae.conversation.chat.block.renderer.FileTreeAdapter$TreeNode
    .registers 17
    # ins_size=8
    const-string v0, "name"
    move-object v2, v10
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "children"
    move-object/from16 v8, v16
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    move-object v1, v0
    move v3, v11
    move-object v4, v12
    move v5, v13
    move v6, v14
    move-object v7, v15
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;-><init>(Ljava/lang/String; Z Ljava/lang/String; I Z Ljava/lang/String; Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getChildren()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    return-object v0
.end method

.method public final getExpanded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    return v0
.end method

.method public final getFileAction()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    return-object v0
.end method

.method public final getFilePath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    return-object v0
.end method

.method public final getIndentLevel()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    return v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isFolder()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    return v0
.end method

.method public final setExpanded(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    return-void 
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TreeNode(name="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isFolder="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->isFolder Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fileAction="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->fileAction Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", indentLevel="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->indentLevel I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", expanded="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->expanded Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", filePath="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->filePath Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", children="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter$TreeNode;->children Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
