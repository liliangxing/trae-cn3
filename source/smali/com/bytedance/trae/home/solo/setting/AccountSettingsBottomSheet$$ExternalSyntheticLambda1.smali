# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnShowListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
.field public final synthetic f$1:Lcom/google/android/material/bottomsheet/BottomSheetDialog;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet  com.google.android.material.bottomsheet.BottomSheetDialog  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$1 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$2 I
    return-void 
.end method

.method public final onShow(android.content.DialogInterface)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$1 Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    iget v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda1;->f$2 I
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->$r8$lambda$AB_6dh0OoKveQkX3NBNfh1UJBMo(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Lcom/google/android/material/bottomsheet/BottomSheetDialog; I Landroid/content/DialogInterface;)V
    return-void 
.end method
