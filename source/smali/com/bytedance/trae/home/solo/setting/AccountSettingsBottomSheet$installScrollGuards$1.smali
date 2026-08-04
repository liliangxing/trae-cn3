# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$installScrollGuards$1;
.super Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;
.source "AccountSettingsBottomSheet.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$installScrollGuards$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;-><init>()V
    return-void 
.end method

.method public onScrolled(androidx.recyclerview.widget.RecyclerView  int  int)void
    .registers 4
    # ins_size=4
    const-string v2, "recyclerView"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$installScrollGuards$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    check-cast v1, Landroid/view/View;
    invoke-static v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$updateHideable(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroid/view/View;)V
    return-void 
.end method
