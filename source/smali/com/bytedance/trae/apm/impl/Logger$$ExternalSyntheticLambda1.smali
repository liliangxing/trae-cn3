# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/apm/alog/IALogActiveUploadObserver;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function3;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function3;
    return-void 
.end method

.method public final flushAlogDataToFile()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/functions/Function1;
    iget-object v1, v2, Lcom/bytedance/trae/apm/impl/Logger$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function3;
    invoke-static v0, v1, Lcom/bytedance/trae/apm/impl/Logger;->$r8$lambda$sgFSyVuqCP_kQYF3JASp4XSt3jI(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method
