# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
.super Ljava/lang/Object;
.source "DeviceManagementViewModel.kt"

.implements Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;

.field public static final $stable:I
.field private final anchorX:F
.field private final anchorY:F
.field private final device:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field private final source:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource  float  float)void
    .registers 6
    # ins_size=5
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, source
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    iput v4, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    iput v5, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$OpenMenu  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource  float  float  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$OpenMenu
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget v4, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->copy(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource; F F)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    return-object v0
.end method

.method public final component3()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    return v0
.end method

.method public final component4()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    return v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource  float  float)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$OpenMenu
    .registers 6
    # ins_size=5
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, source
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource; F F)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    if-eq v1, v3, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    iget v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    invoke-static v1, v3, Ljava/lang/Float;->compare(F F)I
    move-result v1
    if-eqz v1, +003h
    return v2
    iget v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    iget v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    invoke-static v1, v5, Ljava/lang/Float;->compare(F F)I
    move-result v5
    if-eqz v5, +003h
    return v2
    return v0
.end method

.method public final getAnchorX()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    return v0
.end method

.method public final getAnchorY()float
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    return v0
.end method

.method public final getDevice()com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    return-object v0
.end method

.method public final getSource()com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementMenuSource
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    invoke-static v1, Ljava/lang/Float;->hashCode(F)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OpenMenu(device="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", source="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->source Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", anchorX="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorX F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", anchorY="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->anchorY F
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
