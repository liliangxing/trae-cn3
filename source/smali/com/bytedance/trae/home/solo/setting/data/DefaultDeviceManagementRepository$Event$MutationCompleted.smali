# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;

.field public static final $stable:I
.field private final cliId:Ljava/lang/String;
.field private final operationId:J
.field private final success:Z


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(long  java.lang.String  boolean)void
    .registers 6
    # ins_size=5
    const-string v0, "cliId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-wide v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    iput-boolean v5, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationCompleted  long  java.lang.String  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationCompleted
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-wide v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-boolean v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->copy(J Ljava/lang/String; Z)Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    move-result-object v0
    return-object v0
.end method

.method public final component1()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    return-wide v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    return v0
.end method

.method public final copy(long  java.lang.String  boolean)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationCompleted
    .registers 6
    # ins_size=5
    const-string v0, "cliId"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;-><init>(J Ljava/lang/String; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    cmp-long v1, v3, v5
    if-eqz v1, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-boolean v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    iget-boolean v8, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    if-eq v1, v8, +003h
    return v2
    return v0
.end method

.method public final getCliId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public final getOperationId()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    return-wide v0
.end method

.method public final getSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    invoke-static v0, v1, Ljava/lang/Long;->hashCode(J)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MutationCompleted(operationId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->operationId J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", cliId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->cliId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", success="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->success Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
