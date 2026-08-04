# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;
.super Ljava/lang/Object;
.source "DeviceOfflineRecoveryPolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final findRecoveredDevice(com.bytedance.trae.conversation.devices.OfflineDeviceTarget  java.util.List)com.bytedance.trae.conversation.devices.MobileDevice
    .registers 8
    # ins_size=3
    const-string/jumbo v0, target
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "devices"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +02dh
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getDeviceId()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +014h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    if-ne v3, v4, +00ah
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isOnline()Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -02eh
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    return-object v1
.end method

.method public final isRecovered(com.bytedance.trae.conversation.devices.OfflineDeviceTarget  java.util.List)boolean
    .registers 4
    # ins_size=3
    const-string/jumbo v0, target
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "devices"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceOfflineRecoveryPolicy;->findRecoveredDevice(Lcom/bytedance/trae/conversation/devices/OfflineDeviceTarget; Ljava/util/List;)Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
