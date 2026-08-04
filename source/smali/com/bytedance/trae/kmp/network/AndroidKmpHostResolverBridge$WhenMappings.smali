# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$WhenMappings;
.super Ljava/lang/Object;
.source "AndroidKmpHttpClientFactory.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I


.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/HostType;->values()[Lcom/bytedance/trae/network/HostType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v2, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v3, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    const/4 v3, 3
    sget-object v4, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    aput v3, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->REMOTE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/4 v5, 4
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->IMAGEX Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/4 v5, 5
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->MSSDK Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/4 v5, 6
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->PASSPORT Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/4 v5, 7
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->SETTINGS Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 8
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->PRAISE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 9
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->NOTIFICATION Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 10
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->MARKETPLACE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 11
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->WEBSITE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 12
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->DOCS Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 13
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->COMMUNITY Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 14
    aput v5, v0, v4
    sget-object v4, Lcom/bytedance/trae/network/HostType;->PLUGIN_WEB Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, Lcom/bytedance/trae/network/HostType;->ordinal()I
    move-result v4
    const/16 v5, 15
    aput v5, v0, v4
    sput-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/network/AiRegion;->values()[Lcom/bytedance/trae/network/AiRegion;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v4, Lcom/bytedance/trae/network/AiRegion;->CN Lcom/bytedance/trae/network/AiRegion;
    invoke-virtual v4, Lcom/bytedance/trae/network/AiRegion;->ordinal()I
    move-result v4
    aput v1, v0, v4
    sget-object v1, Lcom/bytedance/trae/network/AiRegion;->SG Lcom/bytedance/trae/network/AiRegion;
    invoke-virtual v1, Lcom/bytedance/trae/network/AiRegion;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/network/AiRegion;->US Lcom/bytedance/trae/network/AiRegion;
    invoke-virtual v1, Lcom/bytedance/trae/network/AiRegion;->ordinal()I
    move-result v1
    aput v3, v0, v1
    sput-object v0, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$WhenMappings;->$EnumSwitchMapping$1 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x1a
    :try_start_0x22
    :try_start_0x2b
    :try_start_0x34
    :try_start_0x3d
    :try_start_0x46
    :try_start_0x50
    :try_start_0x5a
    :try_start_0x64
    :try_start_0x6e
    :try_start_0x78
    :try_start_0x82
    :try_start_0x8c
    :try_start_0x9f
    :try_start_0xa7
    :try_start_0xaf
.end method
