# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceListMapperKt;
.super Ljava/lang/Object;
.source "DeviceListMapper.kt"


.method public static final toSelectableDeviceItems(java.util.List  boolean  int)java.util.List
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    const-string v1, "<this>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +028h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/devices/DeviceListMapperKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v5
    aget v5, v6, v5
    if-eq v5, v4, +00dh
    if-ne v5, v3, +005h
    move/from16 v4, v19
    goto +7h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    if-eqz v4, -028h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2dh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +04ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/devices/DeviceListMapperKt$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v5
    aget v5, v6, v5
    if-eq v5, v4, +00dh
    if-ne v5, v3, +005h
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    goto +9h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v13, v5
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isOnline()Z
    move-result v11
    const/4 v12, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getIdeVersion()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isPaired()Z
    move-result v15
    const/16 v16, 4
    const/16 v17, 0
    move-object v6, v5
    move/from16 v10, v20
    invoke-direct/range v6 ... v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v0, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -4dh
    check-cast v0, Ljava/util/List;
    return-object v0
.end method
