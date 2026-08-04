# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.super Ljava/lang/Enum;
.source "MobileDevice.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field public static final enum IDE:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field public static final enum WORK:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field private final cliTypeValue:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.devices.DeviceProductType[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    const-string v2, "WORK"
    const/4 v3, 0
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    const-string v2, "IDE"
    const/4 v3, 1
    invoke-direct v0, v2, v3, v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->$values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->$VALUES [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->cliTypeValue Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.devices.DeviceProductType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->$VALUES [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final getCliTypeValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->cliTypeValue Ljava/lang/String;
    return-object v0
.end method
