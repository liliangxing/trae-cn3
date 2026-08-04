# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;
.super Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
.source "AccountSettingsBottomSheet.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-direct v0, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;-><init>()V
    return-void 
.end method

.method public onFragmentViewCreated(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment  android.view.View  android.os.Bundle)void
    .registers 5
    # ins_size=5
    const-string v4, "fm"
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v1, "f"
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, v
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-static v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$installScrollGuards(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroid/view/View;)V
    return-void 
.end method
