# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final enum Lcom/bytedance/trae/push/impl/PushTrackerType;
.super Ljava/lang/Enum;
.source "PushEventManager.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/push/impl/PushTrackerType;
.field public static final enum FAIL:Lcom/bytedance/trae/push/impl/PushTrackerType;
.field public static final enum START:Lcom/bytedance/trae/push/impl/PushTrackerType;
.field public static final enum TOUCHED_ROUTER:Lcom/bytedance/trae/push/impl/PushTrackerType;
.field public static final enum VALIDATE_FAIL:Lcom/bytedance/trae/push/impl/PushTrackerType;
.field private final actionName:Ljava/lang/String;
.field private final eventName:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.push.impl.PushTrackerType[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/push/impl/PushTrackerType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/push/impl/PushTrackerType;->START Lcom/bytedance/trae/push/impl/PushTrackerType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/push/impl/PushTrackerType;->FAIL Lcom/bytedance/trae/push/impl/PushTrackerType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/push/impl/PushTrackerType;->TOUCHED_ROUTER Lcom/bytedance/trae/push/impl/PushTrackerType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/push/impl/PushTrackerType;->VALIDATE_FAIL Lcom/bytedance/trae/push/impl/PushTrackerType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/push/impl/PushTrackerType;
    const-string/jumbo v1, rd_push_process_start
    const-string/jumbo v2, process_start
    const-string v3, "START"
    const/4 v4, 0
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/push/impl/PushTrackerType;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->START Lcom/bytedance/trae/push/impl/PushTrackerType;
    new-instance v0, Lcom/bytedance/trae/push/impl/PushTrackerType;
    const-string/jumbo v1, rd_push_process_fail
    const-string/jumbo v2, process_fail
    const-string v3, "FAIL"
    const/4 v4, 1
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/push/impl/PushTrackerType;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->FAIL Lcom/bytedance/trae/push/impl/PushTrackerType;
    new-instance v0, Lcom/bytedance/trae/push/impl/PushTrackerType;
    const-string/jumbo v1, rd_push_process_touch_router
    const-string/jumbo v2, process_touch_router
    const-string v3, "TOUCHED_ROUTER"
    const/4 v4, 2
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/push/impl/PushTrackerType;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->TOUCHED_ROUTER Lcom/bytedance/trae/push/impl/PushTrackerType;
    new-instance v0, Lcom/bytedance/trae/push/impl/PushTrackerType;
    const-string/jumbo v1, rd_push_params_validate_fail
    const-string/jumbo v2, process_validate_fail
    const-string v3, "VALIDATE_FAIL"
    const/4 v4, 3
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/push/impl/PushTrackerType;-><init>(Ljava/lang/String; I Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->VALIDATE_FAIL Lcom/bytedance/trae/push/impl/PushTrackerType;
    invoke-static Lcom/bytedance/trae/push/impl/PushTrackerType;->$values()[Lcom/bytedance/trae/push/impl/PushTrackerType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->$VALUES [Lcom/bytedance/trae/push/impl/PushTrackerType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->eventName Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->actionName Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.push.impl.PushTrackerType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/push/impl/PushTrackerType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/push/impl/PushTrackerType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.push.impl.PushTrackerType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/push/impl/PushTrackerType;->$VALUES [Lcom/bytedance/trae/push/impl/PushTrackerType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/push/impl/PushTrackerType;
    return-object v0
.end method

.method public final getActionName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/impl/PushTrackerType;->actionName Ljava/lang/String;
    return-object v0
.end method

.method public final getEventName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/push/impl/PushTrackerType;->eventName Ljava/lang/String;
    return-object v0
.end method
