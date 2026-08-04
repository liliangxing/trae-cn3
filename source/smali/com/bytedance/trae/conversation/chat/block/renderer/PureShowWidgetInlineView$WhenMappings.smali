# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$WhenMappings;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"

.field public static final synthetic $EnumSwitchMapping$0:[I


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->values()[Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    move-result-object v0
    array-length v0, v0
    new-array v0, v0, [I
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_LOADING Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->ordinal()I
    move-result v1
    const/4 v2, 1
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->ordinal()I
    move-result v1
    const/4 v2, 2
    aput v2, v0, v1
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->KEEP_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->ordinal()I
    move-result v1
    const/4 v2, 3
    aput v2, v0, v1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$WhenMappings;->$EnumSwitchMapping$0 [I
    return-void 
    :try_start_0x7
    :try_start_0x10
    :try_start_0x19
.end method
