# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;
.super Ljava/lang/Object;
.source "SettingsDeviceListViewModel.kt"

.implements Lcom/bytedance/trae/home/solo/setting/SettingsDeviceRepository;

.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;
.field private static final cliRepository:Lcom/bytedance/trae/conversation/CliListRepository;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->INSTANCE Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->cliRepository Lcom/bytedance/trae/conversation/CliListRepository;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public fetchDevices(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v0, v6, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;
    invoke-direct v0, v4, v6, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;-><init>(Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->cliRepository Lcom/bytedance/trae/conversation/CliListRepository;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository$fetchDevices$1;->label I
    invoke-virtual v6, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshDiscoverableDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;->getDevices()Ljava/util/List;
    move-result-object v6
    invoke-interface v5, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method public getCachedDevices()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->cliRepository Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository;->getCachedDiscoverableDevices()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public renameCli(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->cliRepository Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/conversation/CliListRepository;->renameCli(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method

.method public unregisterCli(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DefaultSettingsDeviceRepository;->cliRepository Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/conversation/CliListRepository;->unregisterCli(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
