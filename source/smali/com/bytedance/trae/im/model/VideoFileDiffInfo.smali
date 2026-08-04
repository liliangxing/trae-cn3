# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
.super Ljava/lang/Object;
.source "FinishCardResult.kt"

.field private final fileAction:Lcom/google/gson/JsonElement;
.field private final filePath:Lcom/google/gson/JsonElement;
.field private final videoInfo:Lcom/bytedance/trae/im/model/VideoInfoData;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;-><init>(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/bytedance/trae/im/model/VideoInfoData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.google.gson.JsonElement  com.google.gson.JsonElement  com.bytedance.trae.im.model.VideoInfoData)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    return-void 
.end method

.method public synthetic constructor <init>(com.google.gson.JsonElement  com.google.gson.JsonElement  com.bytedance.trae.im.model.VideoInfoData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;-><init>(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/bytedance/trae/im/model/VideoInfoData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.VideoFileDiffInfo  com.google.gson.JsonElement  com.google.gson.JsonElement  com.bytedance.trae.im.model.VideoInfoData  int  java.lang.Object)com.bytedance.trae.im.model.VideoFileDiffInfo
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->copy(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/bytedance/trae/im/model/VideoInfoData;)Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final component2()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.im.model.VideoInfoData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    return-object v0
.end method

.method public final copy(com.google.gson.JsonElement  com.google.gson.JsonElement  com.bytedance.trae.im.model.VideoInfoData)com.bytedance.trae.im.model.VideoFileDiffInfo
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;-><init>(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/bytedance/trae/im/model/VideoInfoData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getFileAction()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final getFilePath()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final getVideoInfo()com.bytedance.trae.im.model.VideoInfoData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/im/model/VideoInfoData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "VideoFileDiffInfo(filePath="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->filePath Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", fileAction="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->fileAction Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", videoInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/VideoFileDiffInfo;->videoInfo Lcom/bytedance/trae/im/model/VideoInfoData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
