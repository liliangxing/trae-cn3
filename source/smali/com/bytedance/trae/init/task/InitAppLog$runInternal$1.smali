# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAppLog$runInternal$1;
.super Ljava/lang/Object;
.source "InitAppLog.kt"

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
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    return-void 
    invoke-static Lcom/bytedance/trae/login/traeauth/LazyLoginBindDevice;->onDidGet()V
    return-void 
.end method
