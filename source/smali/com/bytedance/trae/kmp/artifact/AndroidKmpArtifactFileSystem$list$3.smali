# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final synthetic Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$3;
.super Lkotlin/jvm/internal/FunctionReferenceImpl;
.source "AndroidKmpArtifactIo.kt"

.implements Lkotlin/jvm/functions/Function1;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 1
    const-class v3, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
    const-string/jumbo v4, reference
    const-string/jumbo v5, reference(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/FunctionReferenceImpl;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public final invoke(java.io.File)com.bytedance.trae.kmp.artifact.KmpFileReference
    .registers 3
    # ins_size=2
    const-string/jumbo v0, p0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$3;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;
    invoke-static v0, v2, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem;->access$reference(Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem; Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Ljava/io/File;
    invoke-virtual v0, v1, Lcom/bytedance/trae/kmp/artifact/AndroidKmpArtifactFileSystem$list$3;->invoke(Ljava/io/File;)Lcom/bytedance/trae/kmp/artifact/KmpFileReference;
    move-result-object v1
    return-object v1
.end method
