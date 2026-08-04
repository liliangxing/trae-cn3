# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
.super Ljava/lang/Object;
.source "TaskFragment.kt"

.field private final hasError:Z
.field private final isSearchLoading:Z
.field private final isSearchMode:Z
.field private final query:Ljava/lang/String;
.field private final searchResults:Ljava/util/List;
.field private final tasks:Ljava/util/List;


.method public constructor <init>(java.util.List  boolean  boolean  java.lang.String  java.util.List  boolean)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, tasks
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    iput-boolean v3, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    iput-boolean v4, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    iput-boolean v7, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState  java.util.List  boolean  boolean  java.lang.String  java.util.List  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-boolean v6, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    move v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-boolean v7, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    move v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    move v3, v10
    move-object v6, v4
    move-object v7, v5
    move v8, v12
    move v9, v0
    move-object v10, v1
    move-object v11, v2
    move v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->copy(Ljava/util/List; Z Z Ljava/lang/String; Ljava/util/List; Z)Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    return-object v0
.end method

.method public final component6()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    return v0
.end method

.method public final copy(java.util.List  boolean  boolean  java.lang.String  java.util.List  boolean)com.bytedance.trae.home.solo.task.TaskFragment$TaskContentState
    .registers 15
    # ins_size=7
    const-string/jumbo v0, tasks
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    move-object v1, v0
    move-object v2, v9
    move v3, v10
    move v4, v11
    move-object v5, v12
    move-object v6, v13
    move v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;-><init>(Ljava/util/List; Z Z Ljava/lang/String; Ljava/util/List; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    iget-boolean v5, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getHasError()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    return v0
.end method

.method public final getQuery()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    return-object v0
.end method

.method public final getSearchResults()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    return-object v0
.end method

.method public final getTasks()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSearchLoading()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    return v0
.end method

.method public final isSearchMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TaskContentState(tasks="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->tasks Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasError="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->hasError Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSearchMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", query="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->query Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", searchResults="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->searchResults Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSearchLoading="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
