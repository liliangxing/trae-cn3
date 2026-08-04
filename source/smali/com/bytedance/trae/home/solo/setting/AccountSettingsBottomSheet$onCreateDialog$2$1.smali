# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;
.super Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;
.source "AccountSettingsBottomSheet.kt"

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;


.method constructor <init>(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-direct v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior$BottomSheetCallback;-><init>()V
    return-void 
.end method

.method public onSlide(android.view.View  float)void
    .registers 3
    # ins_size=3
    const-string v2, "bottomSheet"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public onStateChanged(android.view.View  int)void
    .registers 4
    # ins_size=3
    const-string v0, "bottomSheet"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 4
    if-eq v3, v2, +00ch
    const/4 v2, 5
    if-eq v3, v2, +003h
    goto +1bh
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->dismissSafely()V
    goto +15h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$getContentCanScrollUp$p(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)Z
    move-result v2
    if-eqz v2, +00eh
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$onCreateDialog$2$1;->this$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->access$getBehavior$p(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v2
    if-eqz v2, +006h
    const/4 v3, 3
    invoke-virtual v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method
