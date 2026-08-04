# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.super Ljava/lang/Enum;
.source "VoiceCheckTrigger.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.field public static final enum APP_RESUMED:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.field public static final enum DISCUSSING_ENTERED:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.field public static final enum INTRO_ENTERED:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.field public static final enum INTRO_START_CLICK:Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
.field private final checkPermission:Z


.method private static final synthetic $values()com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger[]
    .registers 3
    # ins_size=0
    const/4 v0, 4
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_START_CLICK Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->DISCUSSING_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->APP_RESUMED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    const-string v1, "INTRO_ENTERED"
    const/4 v2, 0
    const/4 v3, 1
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;-><init>(Ljava/lang/String; I Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    const-string v1, "INTRO_START_CLICK"
    invoke-direct v0, v1, v3, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;-><init>(Ljava/lang/String; I Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->INTRO_START_CLICK Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    const-string v1, "DISCUSSING_ENTERED"
    const/4 v2, 2
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;-><init>(Ljava/lang/String; I Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->DISCUSSING_ENTERED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    const-string v1, "APP_RESUMED"
    const/4 v2, 3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;-><init>(Ljava/lang/String; I Z)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->APP_RESUMED Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->$values()[Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->checkPermission Z
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.brainstorm.health.VoiceCheckTrigger[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;
    return-object v0
.end method

.method public final getCheckPermission()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;->checkPermission Z
    return v0
.end method
