# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
.super Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;
.source "HtmlArtifactPreviewActivity.kt"

.field private final archiveFile:Ljava/io/File;
.field private final extractDir:Ljava/io/File;


.method public constructor <init>(java.io.File  java.io.File)void
    .registers 4
    # ins_size=3
    const-string v0, "extractDir"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "archiveFile"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.ArchiveExtractionResult$Success  java.io.File  java.io.File  int  java.lang.Object)com.bytedance.trae.conversation.products.ArchiveExtractionResult$Success
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->copy(Ljava/io/File; Ljava/io/File;)Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    return-object v0
.end method

.method public final component2()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    return-object v0
.end method

.method public final copy(java.io.File  java.io.File)com.bytedance.trae.conversation.products.ArchiveExtractionResult$Success
    .registers 4
    # ins_size=3
    const-string v0, "extractDir"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "archiveFile"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;-><init>(Ljava/io/File; Ljava/io/File;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getArchiveFile()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    return-object v0
.end method

.method public final getExtractDir()java.io.File
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    invoke-virtual v0, Ljava/io/File;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    invoke-virtual v1, Ljava/io/File;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Success(extractDir="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->extractDir Ljava/io/File;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", archiveFile="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArchiveExtractionResult$Success;->archiveFile Ljava/io/File;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
