# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"

.field private bytes:[B
.field private modifiedAtMillis:J


.method public constructor <init>(byte[]  long)void
    .registers 5
    # ins_size=4
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem$Entry  byte[]  long  int  java.lang.Object)com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem$Entry
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-wide v2, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->copy([B J)Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    move-result-object v0
    return-object v0
.end method

.method public final component1()byte[]
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    return-wide v0
.end method

.method public final copy(byte[]  long)com.bytedance.trae.kmp.artifact.InMemoryKmpArtifactFileSystem$Entry
    .registers 5
    # ins_size=4
    const-string v0, "bytes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;-><init>([B J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    iget-object v3, v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getBytes()byte[]
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    return-object v0
.end method

.method public final getModifiedAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    invoke-static v0, Ljava/util/Arrays;->hashCode([B)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final setBytes(byte[])void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    return-void 
.end method

.method public final setModifiedAtMillis(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    return-void 
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Entry(bytes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->bytes [B
    invoke-static v1, Ljava/util/Arrays;->toString([B)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modifiedAtMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifact/InMemoryKmpArtifactFileSystem$Entry;->modifiedAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
