# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final commitMs:J
.field private final prepareMs:J
.field private final totalMs:J
.field private final uploadMs:J


.method public constructor <init>(long  long  long  long)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    iput-wide v5, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    iput-wide v7, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.UploadTimings  long  long  long  long  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.UploadTimings
    .registers 20
    # ins_size=11
    move-object v0, v9
    and-int/lit8 v1, v18, 1
    if-eqz v1, +005h
    iget-wide v1, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    goto +2h
    move-wide v1, v10
    and-int/lit8 v3, v18, 2
    if-eqz v3, +005h
    iget-wide v3, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    goto +2h
    move-wide v3, v12
    and-int/lit8 v5, v18, 4
    if-eqz v5, +005h
    iget-wide v5, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    goto +2h
    move-wide v5, v14
    and-int/lit8 v7, v18, 8
    if-eqz v7, +005h
    iget-wide v7, v0, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    goto +3h
    move-wide/from16 v7, v16
    move-wide v10, v1
    move-wide v12, v3
    move-wide v14, v5
    move-wide/from16 v16, v7
    invoke-virtual/range v9 ... v17, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->copy(J J J J)Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    return-wide v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    return-wide v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    return-wide v0
.end method

.method public final component4()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    return-wide v0
.end method

.method public final copy(long  long  long  long)com.bytedance.trae.conversation.fileupload.UploadTimings
    .registers 19
    # ins_size=9
    new-instance v9, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    move-object v0, v9
    move-wide v1, v11
    move-wide v3, v13
    move-wide v5, v15
    move-wide/from16 v7, v17
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;-><init>(J J J J)V
    return-object v9
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getCommitMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    return-wide v0
.end method

.method public final getPrepareMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    return-wide v0
.end method

.method public final getTotalMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    return-wide v0
.end method

.method public final getUploadMs()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-wide v0, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UploadTimings(prepareMs="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->prepareMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", uploadMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->uploadMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", commitMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->commitMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", totalMs="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->totalMs J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
