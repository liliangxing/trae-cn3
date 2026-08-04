# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;
.super Ljava/lang/Object;
.source "DeviceFlowNestedFlowCallbacks.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;


.method public static synthetic $r8$lambda$-zVC47Q-dD-KHW3SRRWKQ4bechk(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function0  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->withCurrentRouteRefresh$lambda$1(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$2nS_WikWr3hZEXdnFDxgkt2R1x0(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->withCurrentRouteRefresh$lambda$2(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kRQlfEoCy7Po4jnBxjKkjLWKDkg(com.bytedance.trae.conversation.devices.MobileDevice)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->withCurrentRouteRefresh$lambda$0(Lcom/bytedance/trae/conversation/devices/MobileDevice;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic withCurrentRouteRefresh$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowNestedFlowCallbacks  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->withCurrentRouteRefresh(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v0
    return-object v0
.end method

.method private static final withCurrentRouteRefresh$lambda$0(com.bytedance.trae.conversation.devices.MobileDevice)boolean
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    return v1
.end method

.method private static final withCurrentRouteRefresh$lambda$1(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function0  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)kotlin.Unit
    .registers 4
    # ins_size=3
    iget-boolean v0, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-nez v0, +005h
    invoke-interface v2, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    const/4 v2, 0
    iput-boolean v2, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnConnectionSuccess()Lkotlin/jvm/functions/Function0;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final withCurrentRouteRefresh$lambda$2(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  com.bytedance.trae.conversation.devices.MobileDevice)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "device"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    iput-boolean v2, v1, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->getOnConnectionSuccessWithDevice()Lkotlin/jvm/functions/Function1;
    move-result-object v1
    if-eqz v1, +005h
    invoke-interface v1, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final withCurrentRouteRefresh(com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1)com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks
    .registers 14
    # ins_size=4
    const-string v0, "callbacks"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "refreshCurrentRoute"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onConnectedDevice"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lkotlin/jvm/internal/Ref$BooleanRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$BooleanRef;-><init>()V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    new-instance v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;
    invoke-direct v5, v0, v12, v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    new-instance v6, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;
    invoke-direct v6, v0, v13, v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    const/4 v7, 0
    const/16 v8, 39
    const/4 v9, 0
    move-object v1, v11
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->copy$default(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    move-result-object v11
    return-object v11
.end method
