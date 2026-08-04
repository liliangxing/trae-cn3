# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;
.super Ljava/lang/Object;
.source "InitWebViewStartupTask.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;-><init>()V
    return-void 
.end method

.method public final getMAIN_HANDLER()android.os.Handler
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->access$getMAIN_HANDLER$cp()Landroid/os/Handler;
    move-result-object v0
    return-object v0
.end method
