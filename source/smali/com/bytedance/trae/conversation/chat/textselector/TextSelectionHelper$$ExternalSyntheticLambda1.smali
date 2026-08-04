# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:F
.field public final synthetic f$2:F


.method public synthetic constructor <init>(android.widget.TextView  float  float)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$0 Landroid/widget/TextView;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$1 F
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$2 F
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$0 Landroid/widget/TextView;
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$1 F
    iget v2, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;->f$2 F
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->$r8$lambda$2lvOV8S-tkhEwJNN24kOczT--b8(Landroid/widget/TextView; F F)V
    return-void 
.end method
