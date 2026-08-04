# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/content/DialogInterface$OnKeyListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    return-void 
.end method

.method public final onKey(android.content.DialogInterface  int  android.view.KeyEvent)boolean
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->$r8$lambda$CzHSX2l_h6VnF3xNacMiodFICcI(Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet; Landroid/content/DialogInterface; I Landroid/view/KeyEvent;)Z
    move-result v2
    return v2
.end method
