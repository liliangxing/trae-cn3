# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnTouchListener;

.field public final synthetic f$0:Landroid/view/GestureDetector;


.method public synthetic constructor <init>(android.view.GestureDetector)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda0;->f$0 Landroid/view/GestureDetector;
    return-void 
.end method

.method public final onTouch(android.view.View  android.view.MotionEvent)boolean
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda0;->f$0 Landroid/view/GestureDetector;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->$r8$lambda$XXHGHxeFEA1P9t9JXVF_Ii1IcAk(Landroid/view/GestureDetector; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v2
    return v2
.end method
