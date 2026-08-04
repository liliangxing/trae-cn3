# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
.super Ljava/lang/Enum;
.source "DeviceEvents.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
.field public static final Companion:Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
.field public static final enum DEVICE_PICKER:Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
.field public static final enum NEW_FEATURE_PROMPT:Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
.field public static final enum SETTINGS:Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->NEW_FEATURE_PROMPT Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->DEVICE_PICKER Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->SETTINGS Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    const/4 v1, 0
    const-string v2, "new_feature_prompt"
    const-string v3, "NEW_FEATURE_PROMPT"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->NEW_FEATURE_PROMPT Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    const/4 v1, 1
    const-string v2, "device_picker"
    const-string v3, "DEVICE_PICKER"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->DEVICE_PICKER Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    const/4 v1, 2
    const-string/jumbo v2, settings
    const-string v3, "SETTINGS"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->SETTINGS Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-static Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->$values()[Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->$VALUES [Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->Companion Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom$Companion;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.tracker.DeviceTrackEnterFrom[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->$VALUES [Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceTrackEnterFrom;->value Ljava/lang/String;
    return-object v0
.end method
