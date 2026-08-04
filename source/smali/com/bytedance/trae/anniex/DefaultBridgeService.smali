# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/DefaultBridgeService;
.super Lcom/bytedance/ies/bullet/core/kit/service/BaseBridgeService;
.source "DefaultBridgeService.kt"

.field public static final $stable:I


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/ies/bullet/core/kit/service/BaseBridgeService;-><init>()V
    return-void 
.end method

.method public createBridges(com.bytedance.ies.bullet.core.model.context.ContextProviderFactory)java.util.List
    .registers 3
    # ins_size=2
    const-string v0, "providerFactory"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public initialize()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public useWebXBridge3()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public useXBridge3()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method
