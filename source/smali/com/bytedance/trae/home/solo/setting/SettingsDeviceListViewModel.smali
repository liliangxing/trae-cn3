# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "SettingsDeviceListViewModel.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$Companion;
.field private static final POLL_INTERVAL_MS:J
.field private final _devices:Landroidx/lifecycle/MutableLiveData;
.field private final _isLoading:Landroidx/lifecycle/MutableLiveData;
.field private final _newOnlineDevice:Landroidx/lifecycle/MutableLiveData;
.field private final _renameFailed:Landroidx/lifecycle/MutableLiveData;
.field private final _unbindFailed:Landroidx/lifecycle/MutableLiveData;
.field private bridge newDeviceNotificationsEnabled:Z
.field private nextRenameRequestId:J
.field private nextUnbindRequestId:J
.field private final pendingRenames:Ljava/util/Map;
.field private final pendingUnbinds:Ljava/util/Map;
.field private pollingJob:Lkotlinx/coroutines/Job;
.field private previousPairedDeviceIds:Ljava/util/Set;
.field private final repository:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;


.method public static synthetic $r8$lambda$eOTQaS64DXdvJQbCgGuQS9-c04o(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->refreshDevicesAfterMutation$lambda$2(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->Companion Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->INSTANCE Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    const/4 v1, 1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository; Z)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceRepository  boolean)void
    .registers 5
    # ins_size=3
    const-string/jumbo v0, repository
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->repository Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    new-instance v3, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v3, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    new-instance v3, Landroidx/lifecycle/MutableLiveData;
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v3, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    new-instance v3, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v3, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_newOnlineDevice Landroidx/lifecycle/MutableLiveData;
    new-instance v3, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v3, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_renameFailed Landroidx/lifecycle/MutableLiveData;
    new-instance v3, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v3, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_unbindFailed Landroidx/lifecycle/MutableLiveData;
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v3, Ljava/util/Map;
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingRenames Ljava/util/Map;
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v3, Ljava/util/Map;
    iput-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    iput-boolean v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->newDeviceNotificationsEnabled Z
    if-eqz v4, +005h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->fetchDevices()V
    return-void 
.end method

.method public static final synthetic access$getNewDeviceNotificationsEnabled$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->newDeviceNotificationsEnabled Z
    return v0
.end method

.method public static final synthetic access$getPendingRenames$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingRenames Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getPendingUnbinds$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getPreviousPairedDeviceIds$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getRepository$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)com.bytedance.trae.home.solo.setting.SettingsDeviceRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->repository Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    return-object v0
.end method

.method public static final synthetic access$get_devices$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isLoading$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_newOnlineDevice$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_newOnlineDevice Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_renameFailed$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_renameFailed Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_unbindFailed$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_unbindFailed Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$mapDevices(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->mapDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$refreshDevicesAfterMutation(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->refreshDevicesAfterMutation(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$restorePairing(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.lang.String  com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$PendingUnbind)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->restorePairing(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;)V
    return-void 
.end method

.method public static final synthetic access$setPreviousPairedDeviceIds$p(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.Set)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    return-void 
.end method

.method public static final synthetic access$updateDeviceName(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->updateDeviceName(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final applyPendingRenames(java.util.List)java.util.List
    .registers 13
    # ins_size=2
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    check-cast v12, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v12, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +041h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    iget-object v2, v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingRenames Ljava/util/Map;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;
    if-nez v2, +003h
    goto +26h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;->getNewName()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +00ah
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +10h
    const/4 v4, 0
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;->getNewName()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 29
    const/4 v10, 0
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -44h
    check-cast v1, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    iget-object v12, v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingRenames Ljava/util/Map;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v12, v2, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    return-object v1
.end method

.method private final applyPendingUnbinds(java.util.List)java.util.List
    .registers 14
    # ins_size=2
    check-cast v13, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 0
    if-eqz v2, +022h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v5
    if-nez v5, +00fh
    iget-object v5, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v5, v4, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    const/4 v3, 1
    if-eqz v3, -021h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -26h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +00ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v0, v4, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    goto -fh
    new-instance v0, Ljava/util/ArrayList;
    invoke-static v13, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    invoke-interface v13, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +025h
    invoke-interface v13, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00eh
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 15
    const/4 v11, 0
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v13
    move-object v0, v13
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/LinkedHashSet;
    invoke-direct v1, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v1, Ljava/util/Set;
    check-cast v1, Ljava/util/Collection;
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
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/Set;
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$applyPendingUnbinds$$inlined$sortedBy$1;
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$applyPendingUnbinds$$inlined$sortedBy$1;-><init>()V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v0, v2, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getOptimisticItem()Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -018h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getOriginalIndex()I
    move-result v4
    invoke-interface v13, Ljava/util/List;->size()I
    move-result v5
    invoke-static v4, v3, v5, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v4
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getOptimisticItem()Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v2
    invoke-interface v13, v4, v2, Ljava/util/List;->add(I Ljava/lang/Object;)V
    goto -2dh
    return-object v13
.end method

.method private final mapDevices(java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->toSettingsDeviceItems(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->applyPendingRenames(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->applyPendingUnbinds(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private final refreshDevicesAfterMutation(kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->repository Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;)V
    invoke-interface v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;->fetchDevices(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    if-ne v3, v0, +003h
    return-object v3
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v3
.end method

.method private static final refreshDevicesAfterMutation$lambda$2(com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel  java.util.List)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "devices"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->mapDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceMapperKt;->pairedDeviceIds(Ljava/util/List;)Ljava/util/Set;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-virtual v1, v2, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final restorePairing(java.lang.String  com.bytedance.trae.home.solo.setting.SettingsDeviceListViewModel$PendingUnbind)void
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    move v3, v2
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v3, v3, 1
    goto -19h
    const/4 v3, -1
    if-ltz v3, +019h
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v13
    move-object v4, v13
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 1
    const/16 v10, 15
    const/4 v11, 0
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v13
    invoke-interface v0, v3, v13, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    goto +20h
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getOriginalIndex()I
    move-result v13
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v1
    invoke-static v13, v2, v1, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v13
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;->getOptimisticItem()Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    const/16 v7, 15
    const/4 v8, 0
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v14
    invoke-interface v0, v13, v14, Ljava/util/List;->add(I Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v13, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final updateDeviceName(java.lang.String  java.lang.String)void
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +023h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00eh
    const/4 v5, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 29
    const/4 v11, 0
    move-object v6, v14
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -26h
    check-cast v2, Ljava/util/List;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final updateDevicePairing(java.lang.String  boolean)void
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +023h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +00eh
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v10, 15
    const/4 v11, 0
    move v9, v14
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -26h
    check-cast v2, Ljava/util/List;
    invoke-virtual v0, v2, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final fetchDevices()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$fetchDevices$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getDevices()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getNewOnlineDevice()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_newOnlineDevice Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getRenameFailed()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_renameFailed Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getUnbindFailed()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_unbindFailed Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final isLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method protected onCleared()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/lifecycle/ViewModel;->onCleared()V
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    return-void 
.end method

.method public final onNewDeviceToastShown()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_newOnlineDevice Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onRenameFailureToastShown()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_renameFailed Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final onUnbindFailureToastShown()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_unbindFailed Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final renameDevice(java.lang.String  java.lang.String)void
    .registers 16
    # ins_size=3
    const-string v0, "cliId"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newName"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -015h
    goto +2h
    const/4 v1, 0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-wide v2, v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->nextRenameRequestId J
    const-wide/16 v4, 1
    add-long v10, v2, v4
    iput-wide v10, v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->nextRenameRequestId J
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingRenames Ljava/util/Map;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v1
    invoke-direct v2, v1, v15, v10, v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingRename;-><init>(Ljava/lang/String; Ljava/lang/String; J)V
    invoke-interface v0, v14, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v13, v14, v15, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->updateDeviceName(Ljava/lang/String; Ljava/lang/String;)V
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$renameDevice$1;
    const/4 v12, 0
    move-object v6, v0
    move-object v7, v13
    move-object v8, v14
    move-object v9, v15
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$renameDevice$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final setNewDeviceNotificationsEnabled(boolean)void
    .registers 3
    # ins_size=2
    iput-boolean v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->newDeviceNotificationsEnabled Z
    if-nez v2, +008h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_newOnlineDevice Landroidx/lifecycle/MutableLiveData;
    const/4 v0, 0
    invoke-virtual v2, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final startPolling()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->stopPolling()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$startPolling$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stopPolling()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final unbindDevice(java.lang.String)void
    .registers 16
    # ins_size=2
    const-string v0, "cliId"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    move v3, v2
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v3, v3, 1
    goto -19h
    const/4 v3, -1
    if-gez v3, +003h
    return-void 
    invoke-interface v0, v3, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    iget-wide v0, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->nextUnbindRequestId J
    const-wide/16 v5, 1
    add-long/2addr v0, v5
    iput-wide v0, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->nextUnbindRequestId J
    iget-object v12, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->pendingUnbinds Ljava/util/Map;
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 15
    const/4 v11, 0
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->copy$default(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    move-result-object v4
    invoke-direct v13, v4, v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$PendingUnbind;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem; I J)V
    invoke-interface v12, v15, v13, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v14, v15, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->updateDevicePairing(Ljava/lang/String; Z)V
    iget-object v2, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    invoke-static v2, v15, Lkotlin/collections/SetsKt;->minus(Ljava/util/Set; Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v2
    iput-object v2, v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel;->previousPairedDeviceIds Ljava/util/Set;
    move-object v2, v14
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;
    const/4 v12, 0
    move-object v7, v2
    move-object v8, v14
    move-object v9, v15
    move-wide v10, v0
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel$unbindDevice$1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceListViewModel; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)V
    move-object v6, v2
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
