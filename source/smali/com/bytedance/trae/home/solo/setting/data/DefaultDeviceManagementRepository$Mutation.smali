# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field private final cliId:Ljava/lang/String;
.field private final operationId:J
.field private final result:Lkotlinx/coroutines/CompletableDeferred;
.field private final type:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;


.method public constructor <init>(long  java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred)void
    .registers 7
    # ins_size=6
    const-string v0, "cliId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation  long  java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 1
    if-eqz v13, +004h
    iget-wide v7, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    move-wide v1, v7
    and-int/lit8 v7, v12, 2
    if-eqz v7, +004h
    iget-object v9, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    move-object v3, v9
    and-int/lit8 v7, v12, 4
    if-eqz v7, +004h
    iget-object v10, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-object v4, v10
    and-int/lit8 v7, v12, 8
    if-eqz v7, +004h
    iget-object v11, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    move-object v5, v11
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->copy(J Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    move-result-object v6
    return-object v6
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    return-object v0
.end method

.method public final component4()kotlinx.coroutines.CompletableDeferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    return-object v0
.end method

.method public final copy(long  java.lang.String  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType  kotlinx.coroutines.CompletableDeferred)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation
    .registers 13
    # ins_size=6
    const-string v0, "cliId"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, type
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, result
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    move-object v1, v0
    move-wide v2, v8
    move-object v4, v10
    move-object v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;-><init>(J Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    iget-object v8, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getOperationId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    return-wide v0
.end method

.method public final getResult()kotlinx.coroutines.CompletableDeferred
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    return-object v0
.end method

.method public final getType()com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$MutationType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Mutation(operationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->operationId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", type="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->type Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->result Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
