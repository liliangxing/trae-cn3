# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/FrontierConnection$WhenMappings;
.super Ljava/lang/Object;
.source "FrontierConnection.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/common/wschannel/event/ConnectionState;->values()[Lcom/bytedance/common/wschannel/event/ConnectionState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECTING Lcom/bytedance/common/wschannel/event/ConnectionState;
    invoke-virtual v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECTED Lcom/bytedance/common/wschannel/event/ConnectionState;
    invoke-virtual v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECT_CLOSED Lcom/bytedance/common/wschannel/event/ConnectionState;
    invoke-virtual v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->CONNECT_FAILED Lcom/bytedance/common/wschannel/event/ConnectionState;
    invoke-virtual v1, Lcom/bytedance/common/wschannel/event/ConnectionState;->ordinal()I
    move-result v1
    const/4 v2, 4
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/network/FrontierConnection$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
    :try_start_0x22
.end method
