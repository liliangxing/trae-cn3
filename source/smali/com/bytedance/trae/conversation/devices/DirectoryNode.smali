# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryNode;
.super Ljava/lang/Object;
.source "DirectoryNode.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;
.field public static final DEFAULT_NEW_FOLDER_NAME:Ljava/lang/String;
.field private final childrenLoaded:Z
.field private final depth:I
.field private final hasChildren:Z
.field private final id:Ljava/lang/String;
.field private final isEditing:Z
.field private final isExpanded:Z
.field private final isLoading:Z
.field private final isSelected:Z
.field private final name:Ljava/lang/String;
.field private final parentId:Ljava/lang/String;
.field private final path:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->Companion Lcom/bytedance/trae/conversation/devices/DirectoryNode$Companion;
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean)void
    .registers 13
    # ins_size=12
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "path"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    iput v5, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    iput-object v6, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    iput-boolean v8, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    iput-boolean v9, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    iput-boolean v10, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    iput-boolean v11, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    iput-boolean v12, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 28
    # ins_size=14
    move/from16 v0, v26
    and-int/lit8 v1, v0, 4
    if-eqz v1, +006h
    const-string v1, ""
    move-object v5, v1
    goto +3h
    move-object/from16 v5, v17
    and-int/lit8 v1, v0, 8
    const/4 v2, 0
    if-eqz v1, +004h
    move v6, v2
    goto +3h
    move/from16 v6, v18
    and-int/lit8 v1, v0, 16
    if-eqz v1, +005h
    const/4 v1, 0
    move-object v7, v1
    goto +3h
    move-object/from16 v7, v19
    and-int/lit8 v1, v0, 32
    if-eqz v1, +005h
    const/4 v1, 1
    move v8, v1
    goto +3h
    move/from16 v8, v20
    and-int/lit8 v1, v0, 64
    if-eqz v1, +004h
    move v9, v2
    goto +3h
    move/from16 v9, v21
    and-int/lit16 v1, v0, 128
    if-eqz v1, +004h
    move v10, v2
    goto +3h
    move/from16 v10, v22
    and-int/lit16 v1, v0, 256
    if-eqz v1, +004h
    move v11, v2
    goto +3h
    move/from16 v11, v23
    and-int/lit16 v1, v0, 512
    if-eqz v1, +004h
    move v12, v2
    goto +3h
    move/from16 v12, v24
    and-int/lit16 v0, v0, 1024
    if-eqz v0, +004h
    move v13, v2
    goto +3h
    move/from16 v13, v25
    move-object v2, v14
    move-object v3, v15
    move-object/from16 v4, v16
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.DirectoryNode  java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.DirectoryNode
    .registers 26
    # ins_size=14
    move-object v0, v12
    move/from16 v1, v24
    and-int/lit8 v2, v1, 1
    if-eqz v2, +005h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    goto +2h
    move-object v2, v13
    and-int/lit8 v3, v1, 2
    if-eqz v3, +005h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    goto +2h
    move-object v3, v14
    and-int/lit8 v4, v1, 4
    if-eqz v4, +005h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    goto +2h
    move-object v4, v15
    and-int/lit8 v5, v1, 8
    if-eqz v5, +005h
    iget v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    goto +3h
    move/from16 v5, v16
    and-int/lit8 v6, v1, 16
    if-eqz v6, +005h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    goto +3h
    move-object/from16 v6, v17
    and-int/lit8 v7, v1, 32
    if-eqz v7, +005h
    iget-boolean v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    goto +3h
    move/from16 v7, v18
    and-int/lit8 v8, v1, 64
    if-eqz v8, +005h
    iget-boolean v8, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    goto +3h
    move/from16 v8, v19
    and-int/lit16 v9, v1, 128
    if-eqz v9, +005h
    iget-boolean v9, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    goto +3h
    move/from16 v9, v20
    and-int/lit16 v10, v1, 256
    if-eqz v10, +005h
    iget-boolean v10, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    goto +3h
    move/from16 v10, v21
    and-int/lit16 v11, v1, 512
    if-eqz v11, +005h
    iget-boolean v11, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    goto +3h
    move/from16 v11, v22
    and-int/lit16 v1, v1, 1024
    if-eqz v1, +005h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    goto +3h
    move/from16 v1, v23
    move-object v13, v2
    move-object v14, v3
    move-object v15, v4
    move/from16 v16, v5
    move-object/from16 v17, v6
    move/from16 v18, v7
    move/from16 v19, v8
    move/from16 v20, v9
    move/from16 v21, v10
    move/from16 v22, v11
    move/from16 v23, v1
    invoke-virtual/range v12 ... v23, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component10()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    return v0
.end method

.method public final component11()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    return-object v0
.end method

.method public final component4()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    return v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    return v0
.end method

.method public final component7()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    return v0
.end method

.method public final component8()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    return v0
.end method

.method public final component9()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  int  java.lang.String  boolean  boolean  boolean  boolean  boolean  boolean)com.bytedance.trae.conversation.devices.DirectoryNode
    .registers 25
    # ins_size=12
    const-string v0, "id"
    move-object v2, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    move-object v3, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "path"
    move-object/from16 v4, v16
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-object v1, v0
    move/from16 v5, v17
    move-object/from16 v6, v18
    move/from16 v7, v19
    move/from16 v8, v20
    move/from16 v9, v21
    move/from16 v10, v22
    move/from16 v11, v23
    move/from16 v12, v24
    invoke-direct/range v1 ... v12, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    iget v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getChildrenLoaded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    return v0
.end method

.method public final getDepth()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    return v0
.end method

.method public final getHasChildren()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    return v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getParentId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    return-object v0
.end method

.method public final getPath()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isEditing()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    return v0
.end method

.method public final isExpanded()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    return v0
.end method

.method public final isLoading()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    return v0
.end method

.method public final isSelected()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DirectoryNode(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", name="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->name Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", path="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->path Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", depth="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->depth I
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", parentId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->parentId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", hasChildren="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->hasChildren Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isExpanded="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isExpanded Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isLoading="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", childrenLoaded="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->childrenLoaded Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isEditing="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isEditing Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isSelected="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isSelected Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    const/16 v2, 41
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
