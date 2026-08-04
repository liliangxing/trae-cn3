# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitHotPatchTask;
.super Ljava/lang/Object;
.source "InitHotPatchTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;

.field public static final $stable:I
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
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitHotPatchTask;->scene Ljava/lang/String;
    return-void 
.end method

.method public final getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitHotPatchTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->INSTANCE Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;
    invoke-virtual v0, Lcom/bytedance/trae/hotfix/ReparoHotPatchImpl;->init()V
    return-void 
.end method
