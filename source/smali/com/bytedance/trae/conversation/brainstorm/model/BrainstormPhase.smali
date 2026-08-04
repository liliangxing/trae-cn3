# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
.super Ljava/lang/Enum;
.source "BrainstormUiState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
.field public static final enum Discussing:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
.field public static final enum Intro:Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;


.method private static final synthetic $values()com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase[]
    .registers 3
    # ins_size=0
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Intro Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    const-string v1, "Intro"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Intro Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    const-string v1, "Discussing"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->Discussing Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->$values()[Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.brainstorm.model.BrainstormPhase[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;
    return-object v0
.end method
