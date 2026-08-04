# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactResourceLease;

.field private final leaseId:J
.field private final resource:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;


.method public constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository$SharedTemporaryFile  long)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, resource
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;->resource Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;->leaseId J
    return-void 
.end method

.method public release()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;->resource Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$TemporaryFileLease;->leaseId J
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$SharedTemporaryFile;->release(J)V
    return-void 
.end method
