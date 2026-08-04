# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
.super Ljava/lang/Enum;
.source "StreamBannerView.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
.field public static final enum ERROR:Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
.field public static final enum TIPS:Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
.field public static final enum WARNING:Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
.field private final bgColorRes:I
.field private final borderColorRes:I
.field private final iconRes:I
.field private final tintColorRes:I


.method private static final synthetic $values()com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style[]
    .registers 3
    # ins_size=0
    const/4 v0, 3
    new-array v0, v0, [Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->ERROR Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->TIPS Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->WARNING Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 15
    # ins_size=0
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    const-string v1, "ERROR"
    const/4 v2, 0
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_surface_l1 I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_surface_l2 I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;-><init>(Ljava/lang/String; I I I I I)V
    sput-object v7, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->ERROR Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    const-string v9, "TIPS"
    const/4 v10, 1
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_surface_l1 I
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_status_primary_surface_l2 I
    sget v13, Lcom/bytedance/trae/common_ui/R$color;->trae_status_info_default I
    const/4 v14, 0
    move-object v8, v0
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;-><init>(Ljava/lang/String; I I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->TIPS Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    const-string v2, "WARNING"
    const/4 v3, 2
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_surface_l1 I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_surface_l2 I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;-><init>(Ljava/lang/String; I I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->WARNING Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->$values()[Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int  int  int  int)void
    .registers 7
    # ins_size=7
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->bgColorRes I
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->borderColorRes I
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->tintColorRes I
    iput v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->iconRes I
    return-void 
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->$VALUES [Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    return-object v0
.end method

.method public final getBgColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->bgColorRes I
    return v0
.end method

.method public final getBorderColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->borderColorRes I
    return v0
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->iconRes I
    return v0
.end method

.method public final getTintColorRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->tintColorRes I
    return v0
.end method
