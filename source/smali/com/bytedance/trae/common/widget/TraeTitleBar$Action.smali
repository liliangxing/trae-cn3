# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.super Ljava/lang/Enum;
.source "TraeTitleBar.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum BACK:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum CHAT_NEW:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum CLOSE:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum CONFIRM:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum DOWNLOAD:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum MORE:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum NONE:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field public static final enum SETTINGS:Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
.field private final iconRes:I
.field private final primary:Z


.method private static final synthetic $values()com.bytedance.trae.common.widget.TraeTitleBar$Action[]
    .registers 3
    # ins_size=0
    const/16 v0, 8
    new-array v0, v0, [Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->MORE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CONFIRM Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CHAT_NEW Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->DOWNLOAD Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    const/4 v1, 7
    sget-object v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->SETTINGS Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 6
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const-string v1, "NONE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, v2, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->NONE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_chevron_left I
    const-string v3, "BACK"
    const/4 v4, 1
    invoke-direct v0, v3, v4, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->BACK Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 2
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_close I
    const-string v5, "CLOSE"
    invoke-direct v0, v5, v1, v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 3
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_more I
    const-string v5, "MORE"
    invoke-direct v0, v5, v1, v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->MORE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 4
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_checkmark I
    const-string v5, "CONFIRM"
    invoke-direct v0, v5, v1, v3, v4, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CONFIRM Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 5
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_chat_new I
    const-string v4, "CHAT_NEW"
    invoke-direct v0, v4, v1, v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CHAT_NEW Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 6
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_download I
    const-string v4, "DOWNLOAD"
    invoke-direct v0, v4, v1, v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->DOWNLOAD Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    new-instance v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    const/4 v1, 7
    sget v3, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_title_bar_settings I
    const-string v4, "SETTINGS"
    invoke-direct v0, v4, v1, v3, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;-><init>(Ljava/lang/String; I I Z)V
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->SETTINGS Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-static Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->$values()[Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->$VALUES [Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int  boolean)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->iconRes I
    iput-boolean v4, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->primary Z
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.common.widget.TraeTitleBar$Action
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v1
.end method

.method public static values()com.bytedance.trae.common.widget.TraeTitleBar$Action[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->$VALUES [Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    return-object v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->iconRes I
    return v0
.end method

.method public final getPrimary()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->primary Z
    return v0
.end method
