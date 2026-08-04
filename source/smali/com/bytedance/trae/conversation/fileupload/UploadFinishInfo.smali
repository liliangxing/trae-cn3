# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
.super Ljava/lang/Object;
.source "ResourceUploadModels.kt"

.field private final error:Ljava/lang/String;
.field private final stage:Lcom/bytedance/trae/conversation/fileupload/UploadStage;
.field private final success:Z
.field private final timings:Lcom/bytedance/trae/conversation/fileupload/UploadTimings;


.method public constructor <init>(boolean  com.bytedance.trae.conversation.fileupload.UploadStage  java.lang.String  com.bytedance.trae.conversation.fileupload.UploadTimings)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    iput-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  com.bytedance.trae.conversation.fileupload.UploadStage  java.lang.String  com.bytedance.trae.conversation.fileupload.UploadTimings  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.fileupload.UploadFinishInfo  boolean  com.bytedance.trae.conversation.fileupload.UploadStage  java.lang.String  com.bytedance.trae.conversation.fileupload.UploadTimings  int  java.lang.Object)com.bytedance.trae.conversation.fileupload.UploadFinishInfo
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->copy(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings;)Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    return v0
.end method

.method public final component2()com.bytedance.trae.conversation.fileupload.UploadStage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.fileupload.UploadTimings
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    return-object v0
.end method

.method public final copy(boolean  com.bytedance.trae.conversation.fileupload.UploadStage  java.lang.String  com.bytedance.trae.conversation.fileupload.UploadTimings)com.bytedance.trae.conversation.fileupload.UploadFinishInfo
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;-><init>(Z Lcom/bytedance/trae/conversation/fileupload/UploadStage; Ljava/lang/String; Lcom/bytedance/trae/conversation/fileupload/UploadTimings;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getError()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    return-object v0
.end method

.method public final getStage()com.bytedance.trae.conversation.fileupload.UploadStage
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    return-object v0
.end method

.method public final getSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    return v0
.end method

.method public final getTimings()com.bytedance.trae.conversation.fileupload.UploadTimings
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadStage;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/fileupload/UploadTimings;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UploadFinishInfo(success="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->success Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", stage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->stage Lcom/bytedance/trae/conversation/fileupload/UploadStage;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", error="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->error Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", timings="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/fileupload/UploadFinishInfo;->timings Lcom/bytedance/trae/conversation/fileupload/UploadTimings;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
