# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;
.super Ljava/lang/Object;
.source "SettingsDeviceMapper.kt"


.method public static final deviceIdsByProduct(java.util.List)java.util.Map
    .registers 5
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +00ch
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -29h
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-interface v0, Ljava/util/Map;->size()I
    move-result v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v1
    invoke-direct v4, v1, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v4, Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v1
    invoke-interface v4, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1dh
    return-object v4
.end method

.method public static final findNewlyBoundDeviceName(java.util.List  java.util.Set)java.lang.String
    .registers 6
    # ins_size=2
    const-string v0, "<this>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "previousDeviceIds"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +01fh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v3
    if-eqz v3, +00eh
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v5, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, -021h
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public static final pairedDeviceIds(java.util.List)java.util.Set
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +013h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v2
    if-eqz v2, -011h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v0, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v3, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v3
    return-object v3
.end method

.method public static final pairedDeviceIdsByProduct(java.util.List)java.util.Map
    .registers 5
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +013h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v2
    if-eqz v2, -011h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -16h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/LinkedHashMap;
    invoke-direct v4, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v4, Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v2
    invoke-interface v4, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +00ch
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/List;
    invoke-interface v4, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v3, Ljava/util/List;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v3, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -29h
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-interface v4, Ljava/util/Map;->size()I
    move-result v1
    invoke-static v1, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/LinkedHashMap;-><init>(I)V
    check-cast v0, Ljava/util/Map;
    invoke-interface v4, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v1
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1dh
    return-object v0
.end method

.method public static final toSettingsDeviceItems(java.util.List)java.util.List
    .registers 10
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v1, 10
    invoke-static v9, v1, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isOnline()Z
    move-result v5
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/MobileDevice;->isPaired()Z
    move-result v7
    move-object v2, v8
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z)V
    invoke-interface v0, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -29h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method public static final unpairedBindingRoute(com.bytedance.trae.home.solo.setting.SettingsDeviceItem  java.util.List  java.lang.String)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ConnectGuide
    .registers 10
    # ins_size=3
    const-string v0, "<this>"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "currentDevices"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v7, 0
    return-object v7
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v1
    check-cast v8, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v3
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v4
    if-ne v3, v4, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, -01ah
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v8, Ljava/util/LinkedHashSet;
    invoke-direct v8, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v8, Ljava/util/Set;
    check-cast v8, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v8, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    move-object v2, v8
    check-cast v2, Ljava/util/Set;
    sget-object v4, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->UNBOUND_DEVICE Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v6
    new-instance v7, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-object v0, v7
    move-object v3, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)V
    new-instance v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    invoke-direct v8, v7, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    return-object v8
.end method
