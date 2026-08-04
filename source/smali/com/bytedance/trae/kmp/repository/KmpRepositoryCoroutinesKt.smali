# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;
.super Ljava/lang/Object;
.source "KmpRepositoryCoroutines.kt"


.method public static final repositoryScope(kotlinx.coroutines.CoroutineScope  kotlinx.coroutines.CoroutineDispatcher)kotlinx.coroutines.CoroutineScope
    .registers 3
    # ins_size=2
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "dispatcher"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Lkotlinx/coroutines/CoroutineScope;->getCoroutineContext()Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v1, v2, Lkotlin/coroutines/CoroutineContext;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v1
    invoke-static v1, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    return-object v1
.end method

.method public static synthetic repositoryScope$default(kotlinx.coroutines.CoroutineScope  kotlinx.coroutines.CoroutineDispatcher  int  java.lang.Object)kotlinx.coroutines.CoroutineScope
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    invoke-static v0, v1, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->repositoryScope(Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    return-object v0
.end method

.method public static final withRepositoryContext(kotlinx.coroutines.CoroutineDispatcher  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    invoke-static v0, v1, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic withRepositoryContext$default(kotlinx.coroutines.CoroutineDispatcher  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->withRepositoryContext(Lkotlinx/coroutines/CoroutineDispatcher; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
