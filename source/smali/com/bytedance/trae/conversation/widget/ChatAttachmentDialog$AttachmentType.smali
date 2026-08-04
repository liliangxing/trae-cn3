# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.super Ljava/lang/Enum;
.source "ChatAttachmentDialog.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field public static final enum CAMERA:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field public static final enum FILES:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field public static final enum PHOTO:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field public static final enum PLUGINS:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
.field public static final enum SKILLS:Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;


.method private static final synthetic $values()com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType[]
    .registers 3
    # ins_size=0
    const/4 v0, 5
    new-array v0, v0, [Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->SKILLS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PLUGINS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const-string v1, "CAMERA"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->CAMERA Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const-string v1, "PHOTO"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PHOTO Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const-string v1, "FILES"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->FILES Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const-string v1, "SKILLS"
    const/4 v2, 3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->SKILLS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    const-string v1, "PLUGINS"
    const/4 v2, 4
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->PLUGINS Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-static Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->$values()[Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->$VALUES [Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.widget.ChatAttachmentDialog$AttachmentType[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;->$VALUES [Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;
    return-object v0
.end method
