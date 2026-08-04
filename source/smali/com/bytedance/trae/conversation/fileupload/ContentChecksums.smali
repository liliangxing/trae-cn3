# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
.super Ljava/lang/Object;
.source "ResourceUploadUtil.kt"

.field private final crc32Hex:Ljava/lang/String;
.field private final sha256Hex:Ljava/lang/String;
.field private final sizeBytes:J


.method public constructor <init>(java.lang.String  java.lang.String  long)void
    .registers 6
    # ins_size=5
    const-string v0, "crc32Hex"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sha256Hex
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    iput-wide v4, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.ContentChecksums  java.lang.String  java.lang.String  long  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.ContentChecksums
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->copy(Ljava/lang/String; Ljava/lang/String; J)Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    return-wide v0
.end method

.method public final copy(java.lang.String  java.lang.String  long)com.bytedance.trae.conversation.fileupload.ContentChecksums
    .registers 6
    # ins_size=5
    const-string v0, "crc32Hex"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sha256Hex
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;-><init>(Ljava/lang/String; Ljava/lang/String; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getCrc32Hex()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    return-object v0
.end method

.method public final getSha256Hex()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    return-object v0
.end method

.method public final getSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ContentChecksums(crc32Hex="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->crc32Hex Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sha256Hex="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sha256Hex Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", sizeBytes="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/ContentChecksums;->sizeBytes J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
