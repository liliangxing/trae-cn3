# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
.super Ljava/lang/Object;
.source "TaskFragment.kt"

.field private final hasError:Z
.field private final isSearchLoading:Z
.field private final isSearchMode:Z
.field private final query:Ljava/lang/String;
.field private final tasks:Ljava/util/List;


.method public constructor <init>(java.util.List  boolean  boolean  java.lang.String  boolean)void
    .registers 7
    # ins_size=6
    const-string/jumbo v0, tasks
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    iput-boolean v3, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    iput-boolean v4, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    iput-boolean v6, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.task.TaskFragment$RawTaskContentState  java.util.List  boolean  boolean  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.task.TaskFragment$RawTaskContentState
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-boolean v5, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    move v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-boolean v6, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    move v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-object v7, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    move-object v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-boolean v8, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    move v2, v8
    move-object v5, v3
    move-object v6, v4
    move v7, v10
    move v8, v0
    move-object v9, v1
    move v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->copy(Ljava/util/List; Z Z Ljava/lang/String; Z)Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    return v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    return v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    return-object v0
.end method

.method public final component5()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    return v0
.end method

.method public final copy(java.util.List  boolean  boolean  java.lang.String  boolean)com.bytedance.trae.home.solo.task.TaskFragment$RawTaskContentState
    .registers 13
    # ins_size=6
    const-string/jumbo v0, tasks
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    move-object v1, v0
    move-object v2, v8
    move v3, v9
    move v4, v10
    move-object v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;-><init>(Ljava/util/List; Z Z Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    iget-boolean v5, v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getHasError()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    return v0
.end method

.method public final getQuery()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    return-object v0
.end method

.method public final getTasks()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isSearchLoading()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    return v0
.end method

.method public final isSearchMode()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RawTaskContentState(tasks="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->tasks Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", hasError="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->hasError Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSearchMode="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchMode Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", query="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->query Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isSearchLoading="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;->isSearchLoading Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
