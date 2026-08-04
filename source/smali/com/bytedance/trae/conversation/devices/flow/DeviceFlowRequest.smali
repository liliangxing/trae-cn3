# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
.super Ljava/lang/Object;
.source "DeviceFlowCallbacks.kt"

.field private final callbacks:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
.field private final initialRoute:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;


.method public constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)void
    .registers 4
    # ins_size=3
    const-string v0, "initialRoute"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callbacks"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 14
    # ins_size=5
    and-int/lit8 v12, v12, 2
    if-eqz v12, +011h
    new-instance v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v11
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest  com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->copy(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest
    .registers 4
    # ins_size=3
    const-string v0, "initialRoute"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callbacks"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;-><init>(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getCallbacks()com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-object v0
.end method

.method public final getInitialRoute()com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "DeviceFlowRequest(initialRoute="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->initialRoute Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", callbacks="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;->callbacks Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
