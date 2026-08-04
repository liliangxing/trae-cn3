# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Z
.field public final synthetic f$4:Z
.field public final synthetic f$5:Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
.field public final synthetic f$6:Ljava/lang/String;
.field public final synthetic f$7:Ljava/lang/String;
.field public final synthetic f$8:J


.method public synthetic constructor <init>(java.lang.String  java.lang.String  java.lang.String  boolean  boolean  com.bytedance.trae.init.task.base.TaskDurationCollector$AppInitStage  java.lang.String  java.lang.String  long)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iput-boolean v4, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$3 Z
    iput-boolean v5, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$4 Z
    iput-object v6, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$5 Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    iput-object v7, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$6 Ljava/lang/String;
    iput-object v8, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$7 Ljava/lang/String;
    iput-wide v9, v0, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$8 J
    return-void 
.end method

.method public final run()void
    .registers 11
    # ins_size=1
    iget-object v0, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$0 Ljava/lang/String;
    iget-object v1, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$1 Ljava/lang/String;
    iget-object v2, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$2 Ljava/lang/String;
    iget-boolean v3, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$3 Z
    iget-boolean v4, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$4 Z
    iget-object v5, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$5 Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;
    iget-object v6, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$6 Ljava/lang/String;
    iget-object v7, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$7 Ljava/lang/String;
    iget-wide v8, v10, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt$$ExternalSyntheticLambda2;->f$8 J
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/init/task/base/InitTaskHelperKt;->$r8$lambda$3l0fl6-mbPPaCRzpSuUBLNAKrIg(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage; Ljava/lang/String; Ljava/lang/String; J)V
    return-void 
.end method
