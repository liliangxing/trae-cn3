# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/lang/ref/WeakReference;
.field public final synthetic f$1:F
.field public final synthetic f$2:F
.field public final synthetic f$3:I
.field public final synthetic f$4:I


.method public synthetic constructor <init>(java.lang.ref.WeakReference  float  float  int  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$0 Ljava/lang/ref/WeakReference;
    iput v2, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$1 F
    iput v3, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$2 F
    iput v4, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$3 I
    iput v5, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$4 I
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$0 Ljava/lang/ref/WeakReference;
    iget v1, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$1 F
    iget v2, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$2 F
    iget v3, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$3 I
    iget v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;->f$4 I
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->$r8$lambda$7KHID-swcj4YZal5IIeHpRkmQC4(Ljava/lang/ref/WeakReference; F F I I)V
    return-void 
.end method
