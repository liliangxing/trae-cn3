# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;
.super Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;
.source "AbsGoToSoloConversationMethodIDL.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$Companion;
.field private static final extensionMetaInfo:Ljava/util/Map;
.field private final access:Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;
.field private final name:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->Companion Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL$Companion;
    const-string v0, "TicketID"
    const-string v1, "0"
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->extensionMetaInfo Ljava/util/Map;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/sdk/xbridge/cn/registry/core/bridgeInterfaces/XCoreIDLBridgeMethod;-><init>()V
    const-string v0, "goToSoloConversation"
    iput-object v0, v1, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->name Ljava/lang/String;
    sget-object v0, Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;->PUBLIC Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;
    iput-object v0, v1, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->access Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;
    return-void 
.end method

.method public static final synthetic access$getExtensionMetaInfo$cp()java.util.Map
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->extensionMetaInfo Ljava/util/Map;
    return-object v0
.end method

.method public getAccess()com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod$Access
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->access Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$Access;
    return-object v0
.end method

.method public getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AbsGoToSoloConversationMethodIDL;->name Ljava/lang/String;
    return-object v0
.end method
