# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
.super Ljava/lang/Enum;
.source "ManagedPromptArbitrationPolicy.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
.field public static final enum NotShown:Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
.field public static final enum Shown:Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
.field public static final enum TemporarilyBlocked:Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;


.method private static final synthetic $values()com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->TemporarilyBlocked Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    const-string v1, "Shown"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->Shown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    const-string v1, "TemporarilyBlocked"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->TemporarilyBlocked Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    new-instance v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    const-string v1, "NotShown"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->NotShown Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    invoke-static Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->$values()[Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->$VALUES [Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.prompt.ManagedPromptDisplayOutcome[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;->$VALUES [Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/prompt/ManagedPromptDisplayOutcome;
    return-object v0
.end method
