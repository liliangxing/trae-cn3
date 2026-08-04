# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
.super Ljava/lang/Enum;
.source "DeviceEvents.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
.field public static final enum CLOSE:Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
.field public static final enum GET_STARTED:Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.tracker.DeviceGuideAction[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->GET_STARTED Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->CLOSE Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    const/4 v1, 0
    const-string v2, "get_started"
    const-string v3, "GET_STARTED"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->GET_STARTED Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    const/4 v1, 1
    const-string v2, "close"
    const-string v3, "CLOSE"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->CLOSE Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    invoke-static Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->$values()[Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->$VALUES [Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.tracker.DeviceGuideAction
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.tracker.DeviceGuideAction[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->$VALUES [Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceGuideAction;->value Ljava/lang/String;
    return-object v0
.end method
