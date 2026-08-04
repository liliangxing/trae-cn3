# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "KmpArtifactIo.kt"

.field  J$0:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;


.method constructor <init>(com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->this$0 Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->result Ljava/lang/Object;
    iget v5, v4, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v5, v0
    iput v5, v4, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->label I
    iget-object v5, v4, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$touch$1;->this$0 Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    const-wide/16 v0, 0
    move-object v2, v4
    check-cast v2, Lkotlin/coroutines/Continuation;
    const/4 v3, 0
    invoke-virtual v5, v3, v0, v1, v2, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->touch(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    return-object v5
.end method
