# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
.super Ljava/lang/Enum;
.source "TocCreditsObservation.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
.field public static final enum PromptEligible:Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
.field public static final enum SilentRecovery:Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.tracker.BillingSwitchPreparationMode[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    const/4 v1, 0
    const-string v2, "prompt_eligible"
    const-string v3, "PromptEligible"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->PromptEligible Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    const/4 v1, 1
    const-string/jumbo v2, silent_recovery
    const-string v3, "SilentRecovery"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->SilentRecovery Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    invoke-static Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->$values()[Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->$VALUES [Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.tracker.BillingSwitchPreparationMode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.tracker.BillingSwitchPreparationMode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->$VALUES [Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;
    return-object v0
.end method

.method public final getValue()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/BillingSwitchPreparationMode;->value Ljava/lang/String;
    return-object v0
.end method
