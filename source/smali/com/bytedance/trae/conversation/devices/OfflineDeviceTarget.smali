# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
.super Ljava/lang/Object;
.source "DeviceOfflineRecoveryPolicy.kt"

.field private final deviceId:Ljava/lang/String;
.field private final deviceName:Ljava/lang/String;
.field private final enterFrom:Ljava/lang/String;
.field private final isPaired:Z
.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;


.method public constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  java.lang.String)void
    .registers 7
    # ins_size=6
    const-string v0, "deviceId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-boolean v5, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    iput-object v6, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 8
    if-eqz v13, +003h
    const/4 v10, 1
    move v4, v10
    and-int/lit8 v10, v12, 16
    if-eqz v10, +004h
    const-string v11, "device_list"
    move-object v5, v11
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.OfflineDeviceTarget  java.lang.String  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.OfflineDeviceTarget
    .registers 11
    # ins_size=8
    and-int/lit8 v10, v9, 1
    if-eqz v10, +004h
    iget-object v4, v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    and-int/lit8 v10, v9, 2
    if-eqz v10, +004h
    iget-object v5, v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    move-object v10, v5
    and-int/lit8 v5, v9, 4
    if-eqz v5, +004h
    iget-object v6, v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v0, v6
    and-int/lit8 v5, v9, 8
    if-eqz v5, +004h
    iget-boolean v7, v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    move v1, v7
    and-int/lit8 v5, v9, 16
    if-eqz v5, +004h
    iget-object v8, v3, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    move-object v2, v8
    move-object v5, v3
    move-object v6, v4
    move-object v7, v10
    move-object v8, v0
    move v9, v1
    move-object v10, v2
    invoke-virtual/range v5 ... v10, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-result-object v3
    return-object v3
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component4()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    return v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  java.lang.String)com.bytedance.trae.conversation.devices.OfflineDeviceTarget
    .registers 13
    # ins_size=6
    const-string v0, "deviceId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceName"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    move-object v1, v0
    move-object v2, v8
    move-object v3, v9
    move-object v4, v10
    move v5, v11
    move-object v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    iget-boolean v3, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final getEnterFrom()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isPaired()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OfflineDeviceTarget(deviceId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->deviceName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", productType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isPaired="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->isPaired Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterFrom="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->enterFrom Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
