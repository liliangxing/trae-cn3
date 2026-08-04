# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
.super Ljava/lang/Enum;
.source "TocCreditsObservation.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
.field public static final enum Close:Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
.field public static final enum Primary:Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
.field private final value:Ljava/lang/String;


.method private static final synthetic $values()com.bytedance.trae.conversation.tracker.BillingPopupAction[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Close Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Primary Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 4
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    const/4 v1, 0
    const-string v2, "close"
    const-string v3, "Close"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Close Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    const/4 v1, 1
    const-string v2, "primary"
    const-string v3, "Primary"
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->Primary Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    invoke-static Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->$values()[Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->$VALUES [Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->value Ljava/lang/String;
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.tracker.BillingPopupAction
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.tracker.BillingPopupAction[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->$VALUES [Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;
    return-object v0
.end method

.method public final getValue$conversation_mainlandRelease()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/tracker/BillingPopupAction;->value Ljava/lang/String;
    return-object v0
.end method
