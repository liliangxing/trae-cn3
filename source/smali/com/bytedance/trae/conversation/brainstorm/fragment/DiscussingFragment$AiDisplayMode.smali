# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
.super Ljava/lang/Enum;
.source "DiscussingFragment.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
.field public static final enum HIDDEN:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
.field public static final enum STATUS:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
.field public static final enum SUBTITLE:Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;


.method private static final synthetic $values()com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$AiDisplayMode[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->HIDDEN Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->STATUS Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->SUBTITLE Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    const-string v1, "HIDDEN"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->HIDDEN Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    const-string v1, "STATUS"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->STATUS Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    const-string v1, "SUBTITLE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->SUBTITLE Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->$values()[Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$AiDisplayMode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.brainstorm.fragment.DiscussingFragment$AiDisplayMode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;->$VALUES [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/brainstorm/fragment/DiscussingFragment$AiDisplayMode;
    return-object v0
.end method
