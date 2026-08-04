# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/webkit/ValueCallback;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
.field public final synthetic f$1:Landroid/webkit/WebView;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView  android.webkit.WebView  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$1 Landroid/webkit/WebView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final onReceiveValue(java.lang.Object)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$1 Landroid/webkit/WebView;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    check-cast v4, Ljava/lang/String;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->$r8$lambda$ZI1_J1HLsvsac03FDgxyvwsSMXY(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView; Landroid/webkit/WebView; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
