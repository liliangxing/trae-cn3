# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "ArtifactRepository.kt"

.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;


.method constructor <init>(com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->result Ljava/lang/Object;
    iget v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v2, v0
    iput v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->label I
    iget-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$initializeInRepositoryContext$1;->this$0 Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    invoke-static v2, v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->access$initializeInRepositoryContext(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
