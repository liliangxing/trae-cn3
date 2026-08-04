# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/io/Closeable;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
    return-void 
.end method

.method public final close()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->$r8$lambda$LhoWLP0uVfWMLBVU96kCyt-o4Ew(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;)V
    return-void 
.end method
