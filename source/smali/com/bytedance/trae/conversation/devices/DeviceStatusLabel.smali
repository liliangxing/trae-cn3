# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
.super Ljava/lang/Enum;
.source "DeviceStatusLabelPolicy.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
.field public static final enum OFFLINE:Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
.field public static final enum ONLINE:Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
.field public static final enum UNPAIRED:Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
.field private final textRes:I


.method private static final synthetic $values()com.bytedance.trae.conversation.devices.DeviceStatusLabel[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->ONLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->OFFLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->UNPAIRED Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    const/4 v1, 0
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_status_online I
    const-string v3, "ONLINE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->ONLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    const/4 v1, 1
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_status_offline I
    const-string v3, "OFFLINE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->OFFLINE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    const/4 v1, 2
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_device_status_unpaired I
    const-string v3, "UNPAIRED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;-><init>(Ljava/lang/String; I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->UNPAIRED Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->$values()[Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->$VALUES [Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->textRes I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.devices.DeviceStatusLabel
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.devices.DeviceStatusLabel[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->$VALUES [Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    return-object v0
.end method

.method public final getTextRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->textRes I
    return v0
.end method
