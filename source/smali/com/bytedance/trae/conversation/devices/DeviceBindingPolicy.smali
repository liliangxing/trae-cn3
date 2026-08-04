# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;
.super Ljava/lang/Object;
.source "DeviceBindingPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceBindingPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final findNewlyBoundDevice(com.bytedance.trae.conversation.devices.BindingTarget  java.util.List)com.bytedance.trae.conversation.devices.MobileDevice
    .registers 7
    # ins_size=3
    const-string/jumbo v0, target
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "devices"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +02dh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isPaired()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    if-ne v2, v3, +012h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->getExistingDeviceIds()Ljava/util/Set;
    move-result-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v2, v1, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, -02eh
    goto +2h
    const/4 v0, 0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    return-object v0
.end method
