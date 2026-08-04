# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
.super Ljava/lang/Object;
.source "ArtifactDiskCache.kt"

.field public static final $stable:I
.field private final lastAccessMillis:J
.field private final reference:Ljava/lang/String;
.field private final size:J
.field private final temporaryOversized:Z


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.lang.String  long  long  boolean)void
    .registers 8
    # ins_size=7
    const-string/jumbo v0, reference
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    iput-wide v5, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    iput-boolean v7, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  long  long  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v14, v14, 8
    if-eqz v14, +003h
    const/4 v13, 0
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move-wide v2, v9
    move-wide v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;-><init>(Ljava/lang/String; J J Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheEntry  java.lang.String  long  long  boolean  int  java.lang.Object)com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheEntry
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-wide v6, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    move-wide v0, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-wide v8, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    move-wide v2, v8
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-boolean v10, v4, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    move v12, v10
    move-object v6, v4
    move-object v7, v5
    move-wide v8, v0
    move-wide v10, v2
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->copy(Ljava/lang/String; J J Z)Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    return-wide v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    return v0
.end method

.method public final copy(java.lang.String  long  long  boolean)com.bytedance.trae.kmp.artifacts.artifact.ArtifactCacheEntry
    .registers 15
    # ins_size=7
    const-string/jumbo v0, reference
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    move-object v1, v0
    move-object v2, v9
    move-wide v3, v10
    move-wide v5, v12
    move v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;-><init>(Ljava/lang/String; J J Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;
    iget-object v1, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    iget-wide v5, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    iget-boolean v8, v8, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getLastAccessMillis()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    return-wide v0
.end method

.method public final getReference()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    return-object v0
.end method

.method public final getSize()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    return-wide v0
.end method

.method public final getTemporaryOversized()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    return v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ArtifactCacheEntry(reference="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->reference Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", size="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->size J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", lastAccessMillis="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->lastAccessMillis J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", temporaryOversized="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactCacheEntry;->temporaryOversized Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
