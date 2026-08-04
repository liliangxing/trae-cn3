# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
.super Ljava/lang/Object;
.source "DeviceManagementViewModel.kt"

.implements Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction;

.field public static final $stable:I
.field private final device:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field private final name:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$SubmitRename  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$SubmitRename
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->copy(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String)com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction$SubmitRename
    .registers 4
    # ins_size=3
    const-string v0, "device"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "name"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDevice()com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SubmitRename(device="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
