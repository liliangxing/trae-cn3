# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;
.super Ljava/lang/Object;
.source "HubNetConnection.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/SseState;->values()[Lcom/bytedance/trae/network/SseState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/SseState;->CONNECTED Lcom/bytedance/trae/network/SseState;
    invoke-virtual v2, Lcom/bytedance/trae/network/SseState;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/network/SseState;->DISCONNECTED Lcom/bytedance/trae/network/SseState;
    invoke-virtual v3, Lcom/bytedance/trae/network/SseState;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/network/SseState;->CONNECTING Lcom/bytedance/trae/network/SseState;
    invoke-virtual v4, Lcom/bytedance/trae/network/SseState;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sput-object v0, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/network/TransportMode;->values()[Lcom/bytedance/trae/network/TransportMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->WEBSOCKET Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->SSE Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    aput v2, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->HTTP_FALLBACK Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->IDLE Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    const/4 v5, 4
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->CONNECTING Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    const/4 v5, 5
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/TransportMode;->SHUTDOWN Lcom/bytedance/trae/network/TransportMode;
    invoke-virtual v4, Lcom/bytedance/trae/network/TransportMode;->ordinal()I
    move-result v4
    const/4 v5, 6
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/network/NetworkConnectState;->values()[Lcom/bytedance/trae/network/NetworkConnectState;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-virtual v4, Lcom/bytedance/trae/network/NetworkConnectState;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v1, Lcom/bytedance/trae/network/NetworkConnectState;->DISCONNECTED Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-virtual v1, Lcom/bytedance/trae/network/NetworkConnectState;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/network/NetworkConnectState;->CONNECTING Lcom/bytedance/trae/network/NetworkConnectState;
    invoke-virtual v1, Lcom/bytedance/trae/network/NetworkConnectState;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sput-object v0, Lcom/bytedance/trae/network/HubNetConnection$WhenMappings;->$EnumSwitchMapping$2 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x2b
    :try_start_0x33
    :try_start_0x3b
    :try_start_0x43
    :try_start_0x4c
    :try_start_0x55
    :try_start_0x67
    :try_start_0x6f
    :try_start_0x77
.end method
