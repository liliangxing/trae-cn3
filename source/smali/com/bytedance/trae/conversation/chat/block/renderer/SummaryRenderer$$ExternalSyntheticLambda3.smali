# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnLongClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$ObjectRef;
.field public final synthetic f$2:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$3:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$4:Ljava/lang/String;
.field public final synthetic f$5:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$6:Lkotlin/jvm/internal/Ref$FloatRef;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  java.lang.String  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$2 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$3 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$4 Ljava/lang/String;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$5 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$6 Lkotlin/jvm/internal/Ref$FloatRef;
    return-void 
.end method

.method public final onLongClick(android.view.View)boolean
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$0 Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    iget-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$2 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$3 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v4, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$4 Ljava/lang/String;
    iget-object v5, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$5 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v6, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda3;->f$6 Lkotlin/jvm/internal/Ref$FloatRef;
    move-object v7, v9
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->$r8$lambda$g2u90LXPMWZOEHyBDLvnInmqNT0(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Ljava/lang/String; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Landroid/view/View;)Z
    move-result v9
    return v9
.end method
