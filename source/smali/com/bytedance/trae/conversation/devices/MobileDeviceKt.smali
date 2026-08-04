# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/MobileDeviceKt;
.super Ljava/lang/Object;
.source "MobileDevice.kt"

.field private static final DEFAULT_IDE_DEVICE_NAME:Ljava/lang/String;
.field private static final DEFAULT_WORK_DEVICE_NAME:Ljava/lang/String;


.method public static final hasBoundDevice(java.util.List  com.bytedance.trae.conversation.devices.DeviceProductType)boolean
    .registers 5
    # ins_size=2
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "productType"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    instance-of v0, v3, Ljava/util/Collection;
    const/4 v1, 0
    if-eqz v0, +00ch
    move-object v0, v3
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +1eh
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +015h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    const/4 v2, 1
    if-ne v0, v4, +004h
    move v0, v2
    goto +2h
    move v0, v1
    if-eqz v0, -016h
    move v1, v2
    return v1
.end method

.method public static final toMobileDeviceOrNull(com.bytedance.trae.im.service.Cli  boolean)com.bytedance.trae.conversation.devices.MobileDevice
    .registers 13
    # ins_size=2
    const-string v0, "<this>"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +07ch
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    const/4 v3, 1
    xor-int/2addr v2, v3
    if-eqz v2, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v1
    if-nez v5, +004h
    goto/16 +06ah
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v0
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +006h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-object v7, v0
    goto +10h
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +04ah
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    goto -10h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Cli;->getName()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +012h
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v3
    if-eqz v2, +003h
    move-object v1, v0
    if-nez v1, +003h
    goto +3h
    move-object v6, v1
    goto +1ah
    sget-object v0, Lcom/bytedance/trae/conversation/devices/MobileDeviceKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v1
    aget v0, v0, v1
    if-eq v0, v3, +00eh
    const/4 v1, 2
    if-ne v0, v1, +005h
    const-string v0, "TRAE IDE PC"
    goto +9h
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    const-string v0, "TRAE Work PC"
    move-object v6, v0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v1
    const-string v2, "online"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v9
    move-object v4, v0
    move v10, v12
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/conversation/devices/MobileDevice;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z Ljava/lang/String; Z)V
    return-object v0
    return-object v1
.end method

.method public static synthetic toMobileDeviceOrNull$default(com.bytedance.trae.im.service.Cli  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.MobileDevice
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/MobileDeviceKt;->toMobileDeviceOrNull(Lcom/bytedance/trae/im/service/Cli; Z)Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v0
    return-object v0
.end method
