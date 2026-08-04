# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Landroid/content/Context;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
.field public final synthetic f$2:Lcom/google/android/material/bottomsheet/BottomSheetDialog;


.method public synthetic constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefSource  com.google.android.material.bottomsheet.BottomSheetDialog)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$0 Landroid/content/Context;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$2 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$0 Landroid/content/Context;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog$$ExternalSyntheticLambda4;->f$2 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->$r8$lambda$3mjuXAgolDLvgkR6aalwm084wAw(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource; Lcom/google/android/material/bottomsheet/BottomSheetDialog;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
