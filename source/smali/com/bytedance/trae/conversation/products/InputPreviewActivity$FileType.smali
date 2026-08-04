# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final enum Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.super Ljava/lang/Enum;
.source "InputPreviewActivity.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum CODE:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum HTML:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum IMAGE:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum MARKDOWN:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum OTHER:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
.field public static final enum TXT:Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;


.method private static final synthetic $values()com.bytedance.trae.conversation.products.InputPreviewActivity$FileType[]
    .registers 3
    # ins_size=0
    const/4 v0, 6
    new-array v0, v0, [Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->IMAGE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->MARKDOWN Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->CODE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->TXT Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->HTML Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "IMAGE"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->IMAGE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "MARKDOWN"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->MARKDOWN Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "CODE"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->CODE Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "TXT"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->TXT Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "HTML"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->HTML Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    new-instance v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    const-string v1, "OTHER"
    const/4 v2, 5
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->OTHER Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    invoke-static Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->$values()[Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->$VALUES [Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.products.InputPreviewActivity$FileType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.products.InputPreviewActivity$FileType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;->$VALUES [Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/products/InputPreviewActivity$FileType;
    return-object v0
.end method
