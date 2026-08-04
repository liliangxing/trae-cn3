# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
.super Ljava/lang/Object;
.source "DeviceManagementViewModel.kt"

.implements Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public equals(java.lang.Object)boolean
    .registers 4
    # ins_size=2
    const/4 v0, 1
    if-ne v2, v3, +003h
    return v0
    instance-of v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    if-nez v1, +004h
    const/4 v3, 0
    return v3
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementEffect$ShowCopySuccessToast;
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    const v0, 135819830
    return v0
.end method

.method public toString()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "ShowCopySuccessToast"
    return-object v0
.end method
