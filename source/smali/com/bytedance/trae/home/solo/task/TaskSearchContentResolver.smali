# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
.super Ljava/lang/Object;
.source "TaskSearchContentResolver.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final isSearching(boolean  java.lang.String)boolean
    .registers 4
    # ins_size=3
    const/4 v0, 0
    if-eqz v2, +01bh
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    if-lez v2, +004h
    move v2, v3
    goto +2h
    move v2, v0
    if-eqz v2, +003h
    move v0, v3
    return v0
.end method

.method public final displayTasks(java.util.List  boolean  java.lang.String  java.util.List)java.util.List
    .registers 6
    # ins_size=5
    const-string/jumbo v0, taskFlowTasks
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearching(Z Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +00ah
    if-nez v5, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    goto +2h
    move-object v2, v5
    return-object v2
.end method

.method public final isSearchPending(boolean  java.lang.String  boolean  java.util.List)boolean
    .registers 6
    # ins_size=5
    const-string v0, "query"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearching(Z Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +008h
    if-nez v4, +004h
    if-nez v5, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final shouldSuppressListItemAnimations(boolean  java.lang.String)boolean
    .registers 4
    # ins_size=3
    const-string v0, "query"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearching(Z Ljava/lang/String;)Z
    move-result v2
    return v2
.end method

.method public final shouldWaitForListCommitBeforeShowingContent(java.util.List  boolean  boolean  java.lang.String  boolean  java.util.List)boolean
    .registers 8
    # ins_size=7
    const-string/jumbo v0, tasks
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    if-eqz v3, +009h
    invoke-direct v1, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearching(Z Ljava/lang/String;)Z
    move-result v3
    if-nez v3, +003h
    return v0
    invoke-virtual v1, v4, v5, v6, v7, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearchPending(Z Ljava/lang/String; Z Ljava/util/List;)Z
    move-result v3
    if-eqz v3, +003h
    return v0
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    return v2
.end method
