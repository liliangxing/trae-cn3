# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
.super Ljava/lang/Object;
.source "ImageCompressor.kt"

.field private final maxDimension:I
.field private final maxSizeBytes:J
.field private final minQuality:F
.field private final preserveFormat:Z


.method public constructor <init>()void
    .registers 9
    # ins_size=1
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v0, v8
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;-><init>(J I F Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(long  int  float  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    iput v3, v0, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    iput v4, v0, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    return-void 
.end method

.method public synthetic constructor <init>(long  int  float  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +005h
    const-wide/32 v7, 1048576
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    const/16 v9, 2048
    move v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +005h
    const v10, 1050253722
    move v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +003h
    const/4 v11, 0
    move v5, v11
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;-><init>(J I F Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.imageupload.ImageCompressor$Config  long  int  float  boolean  int  java.lang.Object)com.bytedance.trae.conversation.imageupload.ImageCompressor$Config
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget v9, v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    move v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget v10, v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    move v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    iget-boolean v11, v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    move v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->copy(J I F Z)Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    return-wide v0
.end method

.method public final component2()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    return v0
.end method

.method public final component3()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    return v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    return v0
.end method

.method public final copy(long  int  float  boolean)com.bytedance.trae.conversation.imageupload.ImageCompressor$Config
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    move-object v0, v6
    move-wide v1, v8
    move v3, v10
    move v4, v11
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;-><init>(J I F Z)V
    return-object v6
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    iget v3, v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    if-eq v1, v3, +003h
    return v2
    iget v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    iget v3, v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    iget-boolean v8, v8, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getMaxDimension()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    return v0
.end method

.method public final getMaxSizeBytes()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    return-wide v0
.end method

.method public final getMinQuality()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    return v0
.end method

.method public final getPreserveFormat()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    invoke-static v1, Ljava/lang/Integer;->hashCode(I)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Config(maxSizeBytes="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxSizeBytes J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", maxDimension="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->maxDimension I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", minQuality="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->minQuality F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", preserveFormat="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;->preserveFormat Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
