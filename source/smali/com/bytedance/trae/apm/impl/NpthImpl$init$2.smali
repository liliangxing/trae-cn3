# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthImpl$init$2;
.super Ljava/lang/Object;
.source "NpthImpl.kt"

.implements Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onGetId(java.lang.String  java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=4
    const-string v0, "did"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "iid"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v3, ssid
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/crash/NpthBus;->getSettingManager()Lcom/bytedance/crash/runtime/SettingManager;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/crash/runtime/SettingManager;->isDidSet()Z
    move-result v3
    if-nez v3, +01ah
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-nez v3, +011h
    const-string v3, "0"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +009h
    invoke-static Lcom/bytedance/crash/NpthBus;->getSettingManager()Lcom/bytedance/crash/runtime/SettingManager;
    move-result-object v3
    invoke-virtual v3, v2, Lcom/bytedance/crash/runtime/SettingManager;->setDeviceId(Ljava/lang/String;)V
    return-void 
.end method
