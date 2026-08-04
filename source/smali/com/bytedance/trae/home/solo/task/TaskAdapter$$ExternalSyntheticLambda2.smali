# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskModel;
    check-cast v2, Ljava/lang/Float;
    invoke-virtual v2, Ljava/lang/Float;->floatValue()F
    move-result v2
    check-cast v3, Ljava/lang/Float;
    invoke-virtual v3, Ljava/lang/Float;->floatValue()F
    move-result v3
    invoke-static v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->$r8$lambda$LO4-WjoBFipRv2V_sTahTJfq0NU(Lcom/bytedance/trae/home/solo/task/TaskModel; F F)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
