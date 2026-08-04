# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
.super Ljava/lang/Enum;
.source "PureShowWidgetPresentationState.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
.field public static final enum KEEP_COMPLETED:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
.field public static final enum SHOW_COMPLETED:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
.field public static final enum SHOW_LOADING:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPresentationMode[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_LOADING Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->KEEP_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    const-string v1, "SHOW_LOADING"
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_LOADING Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    const-string v1, "SHOW_COMPLETED"
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    const-string v1, "KEEP_COMPLETED"
    const/4 v2, 2
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;-><init>(Ljava/lang/String; I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->KEEP_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->$values()[Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->$ENTRIES Lkotlin/enums/EnumEntries;
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
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPresentationMode
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPresentationMode[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    return-object v0
.end method
