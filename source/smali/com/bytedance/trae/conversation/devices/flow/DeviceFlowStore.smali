# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
.super Ljava/lang/Object;
.source "DeviceFlowStore.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
.field private static final requests:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->INSTANCE Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sput-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->requests Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final get(java.lang.String)com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->requests Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRequest;
    return-object v2
.end method

.method public final put(com.bytedance.trae.conversation.devices.flow.DeviceFlowRequest)java.lang.String
    .registers 4
    # ins_size=2
    const-string/jumbo v0, request
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/util/UUID;->randomUUID()Ljava/util/UUID;
    move-result-object v0
    invoke-virtual v0, Ljava/util/UUID;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toString(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->requests Ljava/util/Map;
    invoke-interface v1, v0, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v0
.end method

.method public final remove(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowStore;->requests Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
