# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;

.field private final cleanupScope:Lkotlinx/coroutines/CoroutineScope;
.field private final lease:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;


.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache$Lease  kotlinx.coroutines.CoroutineScope)void
    .registers 4
    # ins_size=3
    const-string v0, "lease"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cleanupScope"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;->lease Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    return-void 
.end method

.method public static final synthetic access$getLease$p(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$CacheLease)com.bytedance.trae.kmp.artifacts.artifact.ArtifactDiskCache$Lease
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;->lease Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactDiskCache$Lease;
    return-object v0
.end method

.method public release()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease;->cleanupScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease$release$1;
    const/4 v4, 0
    invoke-direct v3, v6, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease$release$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$CacheLease; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
