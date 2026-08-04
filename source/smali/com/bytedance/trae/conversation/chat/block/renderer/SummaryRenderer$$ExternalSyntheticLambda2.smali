# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnTouchListener;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$2:Lkotlin/jvm/internal/Ref$FloatRef;
.field public final synthetic f$3:Lkotlin/jvm/internal/Ref$FloatRef;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef  kotlin.jvm.internal.Ref$FloatRef)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$0 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$2 Lkotlin/jvm/internal/Ref$FloatRef;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$3 Lkotlin/jvm/internal/Ref$FloatRef;
    return-void 
.end method

.method public final onTouch(android.view.View  android.view.MotionEvent)boolean
    .registers 9
    # ins_size=3
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$0 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$2 Lkotlin/jvm/internal/Ref$FloatRef;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$$ExternalSyntheticLambda2;->f$3 Lkotlin/jvm/internal/Ref$FloatRef;
    move-object v4, v7
    move-object v5, v8
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;->$r8$lambda$Rgu47JAdUDbmo9DeQVmUqZKF83Y(Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Lkotlin/jvm/internal/Ref$FloatRef; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v7
    return v7
.end method
