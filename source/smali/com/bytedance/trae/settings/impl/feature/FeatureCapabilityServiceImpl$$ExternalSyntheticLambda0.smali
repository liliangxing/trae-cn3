# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/news/common/settings/SettingsUpdateListener;

.field public final synthetic f$0:Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;


.method public synthetic constructor <init>(com.bytedance.trae.settings.impl.feature.FeatureCapabilityServiceImpl)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;
    return-void 
.end method

.method public final onSettingsUpdate(com.bytedance.news.common.settings.api.SettingsData)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;
    invoke-static v0, v2, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;->$r8$lambda$rlyPTLkBa8eb71iIT8gx3WHYSYo(Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl; Lcom/bytedance/news/common/settings/api/SettingsData;)V
    return-void 
.end method
