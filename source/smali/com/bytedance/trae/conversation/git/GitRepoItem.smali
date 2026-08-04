# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/git/GitRepoItem;
.super Ljava/lang/Object;
.source "GitRepoItem.kt"

.field private final id:Ljava/lang/String;
.field private final isEnabled:Z
.field private final isSelected:Z
.field private final repoUrl:Ljava/lang/String;
.field private final subtitle:Ljava/lang/String;
.field private final title:Ljava/lang/String;


.method public constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean)void
    .registers 8
    # ins_size=7
    const-string v0, "id"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, subtitle
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repoUrl
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    iput-boolean v6, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    iput-boolean v7, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 8
    if-eqz v15, +004h
    const-string v11, ""
    move-object v4, v11
    and-int/lit8 v11, v14, 16
    if-eqz v11, +003h
    const/4 v12, 0
    move v5, v12
    and-int/lit8 v11, v14, 32
    if-eqz v11, +003h
    const/4 v13, 1
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.git.GitRepoItem  java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean  int  java.lang.Object)com.bytedance.trae.conversation.git.GitRepoItem
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-boolean v9, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    move v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    move v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move v11, v2
    move v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/git/GitRepoItem;->copy(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    return v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    return v0
.end method

.method public final copy(java.lang.String  java.lang.String  java.lang.String  java.lang.String  boolean  boolean)com.bytedance.trae.conversation.git.GitRepoItem
    .registers 15
    # ins_size=7
    const-string v0, "id"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, title
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, subtitle
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repoUrl
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move v6, v13
    move v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/git/GitRepoItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getRepoUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getSubtitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    return-object v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isEnabled()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    return v0
.end method

.method public final isSelected()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GitRepoItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", title="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->title Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", subtitle="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->subtitle Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", repoUrl="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->repoUrl Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSelected="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isSelected Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isEnabled="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/git/GitRepoItem;->isEnabled Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
