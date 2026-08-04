# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask$run$1;
.super Ljava/lang/Object;
.source "InitLoadRemoteHotPatchTask.kt"

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
    const-string v2, "iid"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, ssid
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->INSTANCE Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
    invoke-virtual v2, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->loadRemotePatch()V
    return-void 
.end method
