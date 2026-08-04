# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask;
.super Ljava/lang/Object;
.source "InitLoadRemoteHotPatchTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;

.field public static final $stable:I
.field private final TAG:Ljava/lang/String;
.field private final scene:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "LoadRemoteHotPatch"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask;->TAG Ljava/lang/String;
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask;->scene Ljava/lang/String;
    return-void 
.end method

.method public final getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +008h
    sget-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->INSTANCE Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->loadRemotePatch()V
    goto +dh
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask$run$1;
    invoke-direct v1, Lcom/bytedance/trae/init/task/InitLoadRemoteHotPatchTask$run$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method
