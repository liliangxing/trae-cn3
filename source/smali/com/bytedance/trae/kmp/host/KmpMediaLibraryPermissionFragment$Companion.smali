# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;
.super Ljava/lang/Object;
.source "AndroidKmpMediaLibraryHandler.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;-><init>()V
    return-void 
.end method

.method public final request(androidx.fragment.app.FragmentActivity  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    invoke-virtual v0, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion$request$2;-><init>(Landroidx/fragment/app/FragmentActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method
