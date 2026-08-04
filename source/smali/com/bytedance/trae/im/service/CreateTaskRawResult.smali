# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/CreateTaskRawResult;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field private final errorData:Lcom/google/gson/JsonObject;
.field private final errorDetail:Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
.field private final result:Lcom/bytedance/trae/network/response/HttpDataResult;


.method public constructor <init>(com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.im.service.CreateTaskErrorDetail  com.google.gson.JsonObject)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    iput-object v4, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.CreateTaskRawResult  com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.im.service.CreateTaskErrorDetail  com.google.gson.JsonObject  int  java.lang.Object)com.bytedance.trae.im.service.CreateTaskRawResult
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->copy(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/im/service/CreateTaskErrorDetail; Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.service.CreateTaskErrorDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    return-object v0
.end method

.method public final component3()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.response.HttpDataResult  com.bytedance.trae.im.service.CreateTaskErrorDetail  com.google.gson.JsonObject)com.bytedance.trae.im.service.CreateTaskRawResult
    .registers 5
    # ins_size=4
    const-string/jumbo v0, result
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;-><init>(Lcom/bytedance/trae/network/response/HttpDataResult; Lcom/bytedance/trae/im/service/CreateTaskErrorDetail; Lcom/google/gson/JsonObject;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/CreateTaskRawResult;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getErrorData()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getErrorDetail()com.bytedance.trae.im.service.CreateTaskErrorDetail
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    return-object v0
.end method

.method public final getResult()com.bytedance.trae.network.response.HttpDataResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CreateTaskRawResult(result="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->result Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorDetail="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorDetail Lcom/bytedance/trae/im/service/CreateTaskErrorDetail;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorData="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/CreateTaskRawResult;->errorData Lcom/google/gson/JsonObject;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
