# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "KmpArtifactIo.kt"

.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  Z$0:Z
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;


.method constructor <init>(com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->this$0 Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iput-object v4, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->result Ljava/lang/Object;
    iget v4, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v4, v0
    iput v4, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->label I
    iget-object v4, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$write$1;->this$0 Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;
    const/4 v0, 0
    move-object v1, v3
    check-cast v1, Lkotlin/coroutines/Continuation;
    const/4 v2, 0
    invoke-virtual v4, v2, v2, v0, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem;->write(Lcom/bytedance/trae/kmp/artifact/KmpFileReference; [B Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method
