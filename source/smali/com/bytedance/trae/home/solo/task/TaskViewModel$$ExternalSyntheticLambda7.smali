# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/util/Comparator;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function2)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda7;->f$0 Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public final compare(java.lang.Object  java.lang.Object)int
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda7;->f$0 Lkotlin/jvm/functions/Function2;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->$r8$lambda$jli5S0q6-Z1e5UHN5ISAW6BDctk(Lkotlin/jvm/functions/Function2; Ljava/lang/Object; Ljava/lang/Object;)I
    move-result v2
    return v2
.end method
