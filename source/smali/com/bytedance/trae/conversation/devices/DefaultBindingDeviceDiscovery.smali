# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;
.super Ljava/lang/Object;
.source "ConnectComputerGuideViewModel.kt"

.implements Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery;

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;->INSTANCE Lcom/bytedance/trae/conversation/devices/DefaultBindingDeviceDiscovery;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public refresh(kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/CliListRepository;->refreshDiscoverableDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
