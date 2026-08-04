# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$WhenMappings;
.super Ljava/lang/Object;
.source "SpringNetwokStrategyManager.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->values()[Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->CUSTOMER_SECOND_STRATEGY Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;
    invoke-virtual v1, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$SpringNetworkStrategy;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/network/util/SpringNetworkStrategyManager$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
.end method
