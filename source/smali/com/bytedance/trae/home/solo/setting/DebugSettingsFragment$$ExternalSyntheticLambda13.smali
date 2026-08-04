# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/RadioGroup$OnCheckedChangeListener;

.field public final synthetic f$0:Landroid/widget/RadioButton;
.field public final synthetic f$1:Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
.field public final synthetic f$2:Lcom/bytedance/trae/settings/api/feature/Feature;
.field public final synthetic f$3:Landroid/widget/RadioButton;
.field public final synthetic f$4:Landroid/widget/RadioButton;
.field public final synthetic f$5:Landroid/widget/TextView;


.method public synthetic constructor <init>(android.widget.RadioButton  com.bytedance.trae.settings.api.feature.IFeatureCapabilityService  com.bytedance.trae.settings.api.feature.Feature  android.widget.RadioButton  android.widget.RadioButton  android.widget.TextView)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$0 Landroid/widget/RadioButton;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$1 Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$2 Lcom/bytedance/trae/settings/api/feature/Feature;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$3 Landroid/widget/RadioButton;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$4 Landroid/widget/RadioButton;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$5 Landroid/widget/TextView;
    return-void 
.end method

.method public final onCheckedChanged(android.widget.RadioGroup  int)void
    .registers 11
    # ins_size=3
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$0 Landroid/widget/RadioButton;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$1 Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$2 Lcom/bytedance/trae/settings/api/feature/Feature;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$3 Landroid/widget/RadioButton;
    iget-object v4, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$4 Landroid/widget/RadioButton;
    iget-object v5, v8, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment$$ExternalSyntheticLambda13;->f$5 Landroid/widget/TextView;
    move-object v6, v9
    move v7, v10
    invoke-static/range v0 ... v7, Lcom/bytedance/trae/home/solo/setting/DebugSettingsFragment;->$r8$lambda$KFKCP8T9CcGmyq4xuMnNippq_2M(Landroid/widget/RadioButton; Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService; Lcom/bytedance/trae/settings/api/feature/Feature; Landroid/widget/RadioButton; Landroid/widget/RadioButton; Landroid/widget/TextView; Landroid/widget/RadioGroup; I)V
    return-void 
.end method
