# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;
.super Ljava/lang/Object;
.source "DeviceTracker.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I
.field public static final synthetic $EnumSwitchMapping$1:[I
.field public static final synthetic $EnumSwitchMapping$2:[I


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v2
    aput v1, v0, v2
    const/4 v2, 2
    sget-object v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-static Lcom/bytedance/trae/im/service/CliType;->values()[Lcom/bytedance/trae/im/service/CliType;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v3
    aput v2, v0, v3
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v3
    const/4 v4, 3
    aput v4, v0, v3
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-static Lcom/bytedance/trae/conversation/widget/ChatMode;->values()[Lcom/bytedance/trae/conversation/widget/ChatMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v3
    aput v1, v0, v3
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->ordinal()I
    move-result v1
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTracker$WhenMappings;->$EnumSwitchMapping$2 [I
    return-void 
    :try_start_0x8
    :try_start_0x11
    :try_start_0x22
    :try_start_0x2a
    :try_start_0x32
    :try_start_0x44
    :try_start_0x4c
.end method
