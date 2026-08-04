# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.super Ljava/lang/Enum;
.source "BrainstormSessionHolder.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.field public static final enum ACTIVE_FG:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.field public static final enum ACTIVE_MIN:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.field public static final enum ENDING:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.field public static final enum IDLE:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
.field public static final enum TERMINATED:Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;


.method private static final synthetic $values()com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$HolderState[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_FG Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_MIN Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ENDING Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->TERMINATED Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const-string v1, "IDLE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->IDLE Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const-string v1, "ACTIVE_FG"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_FG Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const-string v1, "ACTIVE_MIN"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ACTIVE_MIN Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const-string v1, "ENDING"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->ENDING Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    const-string v1, "TERMINATED"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->TERMINATED Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->$values()[Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$HolderState
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$HolderState[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$HolderState;
    return-object v0
.end method
