# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;
.super Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;
.source "PreviewActivity.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.PreviewActivity)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;
    invoke-direct v0, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;-><init>()V
    return-void 
.end method

.method public onPageSelected(int)void
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;->onPageSelected(I)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->access$getAdapter$p(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;
    move-result-object v0
    if-nez v0, +008h
    const-string v0, "adapter"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewPagerAdapter;->onPageSelected(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity$onCreate$8;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;
    invoke-static v2, Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;->access$updateControls(Lcom/bytedance/trae/conversation/mediachoose/ui/PreviewActivity;)V
    return-void 
.end method
