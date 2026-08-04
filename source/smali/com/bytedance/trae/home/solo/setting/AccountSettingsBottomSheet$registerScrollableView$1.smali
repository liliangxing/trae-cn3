# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;
.super Ljava/lang/Object;
.source "AccountSettingsBottomSheet.kt"

.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;

.field final synthetic $view:Landroid/view/View;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;


.method constructor <init>(android.view.View  com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->$view Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGlobalLayout()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->$view Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->isAttachedToWindow()Z
    move-result v0
    if-nez v0, +01ch
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->$view Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    move-object v1, v2
    check-cast v1, Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$getScrollableViews$p(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)Ljava/util/Set;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->$view Landroid/view/View;
    invoke-interface v0, v1, Ljava/util/Collection;->remove(Ljava/lang/Object;)Z
    return-void 
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$registerScrollableView$1;->$view Landroid/view/View;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$updateHideable(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroid/view/View;)V
    return-void 
.end method
