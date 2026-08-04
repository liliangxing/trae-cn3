# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
.super Ljava/lang/Object;
.source "KmpArtifactIo.kt"

.field public static final $stable:I
.field private final modifiedAtMillis:J
.field private final size:J


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(long  long)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    iput-wide v3, v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifact.KmpFileMetadata  long  long  int  java.lang.Object)com.bytedance.trae.kmp.artifact.KmpFileMetadata
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    and-int/lit8 v5, v5, 2
    if-eqz v5, +004h
    iget-wide v3, v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->copy(J J)Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    return-wide v0
.end method

.method public final copy(long  long)com.bytedance.trae.kmp.artifact.KmpFileMetadata
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;-><init>(J J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getModifiedAtMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    return-wide v0
.end method

.method public final getSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "KmpFileMetadata(size="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->size J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", modifiedAtMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifact/KmpFileMetadata;->modifiedAtMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
