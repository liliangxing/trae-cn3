# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
.field public final synthetic f$1:Lkotlinx/coroutines/CancellableContinuation;


.method public synthetic constructor <init>(com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment  kotlinx.coroutines.CancellableContinuation)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;->f$1 Lkotlinx/coroutines/CancellableContinuation;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0;->f$1 Lkotlinx/coroutines/CancellableContinuation;
    check-cast v3, Ljava/lang/Throwable;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;->$r8$lambda$MvpVnefwwaoryWYaMqZSCatjMXs(Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment; Lkotlinx/coroutines/CancellableContinuation; Ljava/lang/Throwable;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
