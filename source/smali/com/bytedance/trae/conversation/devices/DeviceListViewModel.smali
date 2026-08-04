# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "DeviceListViewModel.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$Companion;
.field private static final MAX_LOG_ITEMS:I
.field private static final TAG:Ljava/lang/String;
.field private final _devices:Landroidx/lifecycle/MutableLiveData;
.field private final _isLoading:Landroidx/lifecycle/MutableLiveData;
.field private deviceListRevision:I
.field private dispatchedDeviceListRevision:I
.field private preselectedDeviceId:Ljava/lang/String;
.field private final repository:Lcom/bytedance/trae/conversation/CliListRepository;
.field private sessionSelectedDeviceId:Ljava/lang/String;


.method public static synthetic $r8$lambda$HzPSH9THu7IFzhpvJhKWjsok_BI(com.bytedance.trae.conversation.devices.DeviceItem)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->logFetchResult$lambda$4(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->Companion Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Landroidx/lifecycle/ViewModel;-><init>()V
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    invoke-direct v0, Landroidx/lifecycle/MutableLiveData;-><init>()V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    new-instance v0, Landroidx/lifecycle/MutableLiveData;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-direct v0, v1, Landroidx/lifecycle/MutableLiveData;-><init>(Ljava/lang/Object;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->repository Lcom/bytedance/trae/conversation/CliListRepository;
    return-void 
.end method

.method public static final synthetic access$getDeviceListRevision$p(com.bytedance.trae.conversation.devices.DeviceListViewModel)int
    .registers 1
    # ins_size=1
    iget v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->deviceListRevision I
    return v0
.end method

.method public static final synthetic access$getRepository$p(com.bytedance.trae.conversation.devices.DeviceListViewModel)com.bytedance.trae.conversation.CliListRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->repository Lcom/bytedance/trae/conversation/CliListRepository;
    return-object v0
.end method

.method public static final synthetic access$getSessionSelectedDeviceId$p(com.bytedance.trae.conversation.devices.DeviceListViewModel)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->sessionSelectedDeviceId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$get_devices$p(com.bytedance.trae.conversation.devices.DeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$get_isLoading$p(com.bytedance.trae.conversation.devices.DeviceListViewModel)androidx.lifecycle.MutableLiveData
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    return-object v0
.end method

.method public static final synthetic access$logFetchResult(com.bytedance.trae.conversation.devices.DeviceListViewModel  boolean  int  java.util.List)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->logFetchResult(Z I Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$setDeviceListRevision$p(com.bytedance.trae.conversation.devices.DeviceListViewModel  int)void
    .registers 2
    # ins_size=2
    iput v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->deviceListRevision I
    return-void 
.end method

.method public static final synthetic access$setSessionSelectedDeviceId$p(com.bytedance.trae.conversation.devices.DeviceListViewModel  java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->sessionSelectedDeviceId Ljava/lang/String;
    return-void 
.end method

.method public static synthetic fetchDevices$default(com.bytedance.trae.conversation.devices.DeviceListViewModel  android.content.Context  boolean  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices(Landroid/content/Context; Z Ljava/lang/String;)V
    return-void 
.end method

.method private final logFetchResult(boolean  int  java.util.List)void
    .registers 19
    # ins_size=4
    move-object/from16 v0, v18
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v3, +01fh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-eq v7, v8, +009h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v6
    if-nez v6, +003h
    goto +2h
    move v4, v5
    if-eqz v4, -01fh
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    const/4 v2, 5
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Ljava/lang/Iterable;
    const/4 v7, 0
    const-string v1, "["
    move-object v8, v1
    check-cast v8, Ljava/lang/CharSequence;
    const-string v1, "]"
    move-object v9, v1
    check-cast v9, Ljava/lang/CharSequence;
    const/4 v10, 0
    const/4 v11, 0
    new-instance v12, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$$ExternalSyntheticLambda0;
    invoke-direct v12, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$$ExternalSyntheticLambda0;-><init>()V
    const/16 v13, 25
    const/4 v14, 0
    invoke-static/range v6 ... v14, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    const/4 v6, 0
    if-eqz v3, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v7, v3
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isSelected()Z
    move-result v7
    if-eqz v7, -012h
    goto +2h
    move-object v3, v6
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    if-eqz v3, +006h
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +004h
    const-string v6, ""
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v7, "offline_device_fetch_result: isCodeMode="
    invoke-direct v3, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move/from16 v7, v16
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", rawCliCount="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move/from16 v7, v17
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", total="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-interface/range v18, Ljava/util/List;->size()I
    move-result v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v7, ", remote="
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    instance-of v7, v0, Ljava/util/Collection;
    if-eqz v7, +00dh
    move-object v8, v0
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v9, v5
    goto +27h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    move v9, v5
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +01dh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v10, v11, +004h
    move v10, v4
    goto +2h
    move v10, v5
    if-eqz v10, -017h
    add-int/lit8 v9, v9, 1
    if-gez v9, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, ", local="
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v7, +00dh
    move-object v8, v0
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v9, v5
    goto +27h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    move v9, v5
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +01dh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v10, v11, +004h
    move v10, v4
    goto +2h
    move v10, v5
    if-eqz v10, -017h
    add-int/lit8 v9, v9, 1
    if-gez v9, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, ", ide="
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v7, +00dh
    move-object v8, v0
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +004h
    move v9, v5
    goto +27h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    move v9, v5
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +01dh
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v10
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v10, v11, +004h
    move v10, v4
    goto +2h
    move v10, v5
    if-eqz v10, -017h
    add-int/lit8 v9, v9, 1
    if-gez v9, -01bh
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -20h
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v8, ", offline="
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    if-eqz v7, +00ch
    move-object v7, v0
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +003h
    goto +2eh
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    move v7, v5
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +023h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getType()Lcom/bytedance/trae/im/service/CliType;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-eq v9, v10, +00ah
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DeviceItem;->isOnline()Z
    move-result v8
    if-nez v8, +004h
    move v8, v4
    goto +2h
    move v8, v5
    if-eqz v8, -01dh
    add-int/lit8 v7, v7, 1
    if-gez v7, -021h
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -26h
    move v5, v7
    invoke-virtual v3, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", selected="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v3, ", offlineCandidates="
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "DeviceListViewModel"
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final logFetchResult$lambda$4(com.bytedance.trae.conversation.devices.DeviceItem)java.lang.CharSequence
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogSummary(Lcom/bytedance/trae/conversation/devices/DeviceItem;)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    return-object v1
.end method

.method public static synthetic selectLocation$default(com.bytedance.trae.conversation.devices.DeviceListViewModel  java.lang.String  boolean  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->selectLocation(Ljava/lang/String; Z)V
    return-void 
.end method

.method public final ensureDevicesLoaded(android.content.Context  boolean)void
    .registers 9
    # ins_size=3
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v0, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v0
    if-eqz v0, +00dh
    iget-object v7, v6, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    const/4 v8, 0
    invoke-static v8, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-virtual v7, v8, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
    const/4 v3, 0
    const/4 v4, 4
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    move v2, v8
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->fetchDevices$default(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method

.method public final fetchDevices(android.content.Context  boolean  java.lang.String)void
    .registers 12
    # ins_size=4
    const-string v0, "context"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v11, +012h
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/2addr v2, v0
    if-eqz v2, +003h
    goto +2h
    move-object v11, v1
    if-eqz v11, +004h
    iput-object v11, v8, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->sessionSelectedDeviceId Ljava/lang/String;
    iget-object v11, v8, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v11, v0, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "offline_device_fetch_start: isCodeMode="
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", preselectedId="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v2, v8, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->preselectedDeviceId Ljava/lang/String;
    if-eqz v2, +007h
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DeviceItemKt;->toDeviceLogId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v2, "DeviceListViewModel"
    invoke-virtual v11, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object v11, v8
    check-cast v11, Landroidx/lifecycle/ViewModel;
    invoke-static v11, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v11, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;
    invoke-direct v11, v8, v9, v10, v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel$fetchDevices$3;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceListViewModel; Landroid/content/Context; Z Lkotlin/coroutines/Continuation;)V
    move-object v5, v11
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final getLocations()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final getPreselectedDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->preselectedDeviceId Ljava/lang/String;
    return-object v0
.end method

.method public final isLoading()androidx.lifecycle.LiveData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_isLoading Landroidx/lifecycle/MutableLiveData;
    check-cast v0, Landroidx/lifecycle/LiveData;
    return-object v0
.end method

.method public final selectLocation(java.lang.String  boolean)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    const-string v2, "id"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    invoke-virtual v2, Landroidx/lifecycle/MutableLiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    if-nez v2, +003h
    return-void 
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->sessionSelectedDeviceId Ljava/lang/String;
    if-eqz v20, +008h
    iget v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->deviceListRevision I
    add-int/lit8 v3, v3, 1
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->deviceListRevision I
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->_devices Landroidx/lifecycle/MutableLiveData;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v2, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +025h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/devices/DeviceItem;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 479
    const/16 v17, 0
    invoke-static/range v6 ... v17, Lcom/bytedance/trae/conversation/devices/DeviceItem;->copy$default(Lcom/bytedance/trae/conversation/devices/DeviceItem; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Z Z Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DeviceItem;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v4, Ljava/util/List;
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final setPreselectedDeviceId(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->preselectedDeviceId Ljava/lang/String;
    return-void 
.end method

.method public final shouldDispatchDeviceListChanged()boolean
    .registers 3
    # ins_size=1
    iget v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->dispatchedDeviceListRevision I
    iget v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->deviceListRevision I
    if-ne v0, v1, +004h
    const/4 v0, 0
    return v0
    iput v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceListViewModel;->dispatchedDeviceListRevision I
    const/4 v0, 1
    return v0
.end method
