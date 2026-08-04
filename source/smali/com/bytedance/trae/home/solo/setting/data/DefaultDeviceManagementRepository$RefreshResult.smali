# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.field private final devices:Ljava/util/List;
.field private final success:Z


.method public constructor <init>(boolean  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(boolean  java.util.List  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;-><init>(Z Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$RefreshResult  boolean  java.util.List  int  java.lang.Object)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$RefreshResult
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->copy(Z Ljava/util/List;)Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    return v0
.end method

.method public final component2()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    return-object v0
.end method

.method public final copy(boolean  java.util.List)com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$RefreshResult
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;-><init>(Z Ljava/util/List;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    iget-boolean v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    iget-boolean v3, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDevices()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    return-object v0
.end method

.method public final getSuccess()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    return v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RefreshResult(success="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->success Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", devices="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->devices Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
