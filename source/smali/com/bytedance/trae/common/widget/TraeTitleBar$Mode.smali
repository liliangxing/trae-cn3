# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.super Ljava/lang/Enum;
.source "TraeTitleBar.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field public static final enum CONVERSATION_DETAIL:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field public static final enum NEW_CONVERSATION:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field public static final enum PAGE:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field public static final enum SHEET:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
.field public static final enum TASK_LIST:Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;


.method private static final synthetic $values()com.bytedance.trae.common.widget.TraeTitleBar$Mode[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->CONVERSATION_DETAIL Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->NEW_CONVERSATION Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const-string v1, "PAGE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->PAGE Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const-string v1, "SHEET"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const-string v1, "CONVERSATION_DETAIL"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->CONVERSATION_DETAIL Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const-string v1, "NEW_CONVERSATION"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->NEW_CONVERSATION Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const-string v1, "TASK_LIST"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->TASK_LIST Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    invoke-static Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->$values()[Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->$VALUES [Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.common.widget.TraeTitleBar$Mode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.common.widget.TraeTitleBar$Mode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->$VALUES [Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    return-object v0
.end method
