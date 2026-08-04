# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/widget/TextView;
.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
.field public final synthetic f$2:Landroid/widget/ImageView;


.method public synthetic constructor <init>(android.widget.TextView  com.bytedance.trae.home.solo.setting.SettingsMainFragment  android.widget.ImageView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$0 Landroid/widget/TextView;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$2 Landroid/widget/ImageView;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$0 Landroid/widget/TextView;
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$1 Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment$$ExternalSyntheticLambda4;->f$2 Landroid/widget/ImageView;
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment;->$r8$lambda$Pbcy_gSWoBq0YMx-khzBjY1r7_E(Landroid/widget/TextView; Lcom/bytedance/trae/home/solo/setting/SettingsMainFragment; Landroid/widget/ImageView; Lcom/bytedance/trae/home/solo/setting/CNUserPayStatusData;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
