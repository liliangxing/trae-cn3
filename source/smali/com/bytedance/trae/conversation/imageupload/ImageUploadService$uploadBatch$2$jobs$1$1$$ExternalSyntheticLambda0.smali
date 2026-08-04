# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function2;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function2;
    iput v2, v0, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;->f$1 I
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function2;
    iget v1, v2, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0;->f$1 I
    check-cast v3, Ljava/lang/Integer;
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadService$uploadBatch$2$jobs$1$1;->$r8$lambda$OBrCqpbe1biJamS127c7JIY2fN8(Lkotlin/jvm/functions/Function2; I I)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
