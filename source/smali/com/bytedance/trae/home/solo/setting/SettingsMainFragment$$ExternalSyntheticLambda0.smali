# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final synthetic f$2:Z
.field public final synthetic f$3:Landroid/widget/TextView;
.field public final synthetic f$4:Landroid/widget/TextView;
.field public final synthetic f$5:Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;


.method public synthetic constructor <init>(android.widget.TextView  com.facebook.drawee.view.SimpleDraweeView  boolean  android.widget.TextView  android.widget.TextView  com.bytedance.trae.home.solo.setting.SettingsMainFragment)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$1 Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-boolean v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$2 Z
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$3 Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$4 Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$5 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$0 Landroid/widget/TextView;
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$1 Lcom/facebook/drawee/view/SimpleDraweeView;
    iget-boolean v2, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$2 Z
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$3 Landroid/widget/TextView;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$4 Landroid/widget/TextView;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda0;->f$5 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    move-object v6, v8
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->$r8$lambda$yhxRQFDKPsuwBwb5Uho9lisOjHI(Landroid/widget/TextView; Lcom/facebook/drawee/view/SimpleDraweeView; Z Landroid/widget/TextView; Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
