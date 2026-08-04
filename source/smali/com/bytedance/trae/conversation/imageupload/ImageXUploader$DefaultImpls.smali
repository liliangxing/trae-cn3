# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageXUploader$DefaultImpls;
.super Ljava/lang/Object;
.source "BduploaderImageXUploader.kt"


.method public static synthetic $r8$lambda$dluSPv6OSYx_kQoHaTWBh5xRuyE(int)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader$DefaultImpls;->upload$lambda$0(I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static close(com.bytedance.trae.conversation.imageupload.ImageXUploader)void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public static synthetic upload$default(com.bytedance.trae.conversation.imageupload.ImageXUploader  java.io.File  java.lang.String  com.bytedance.trae.conversation.imageupload.StsTokenData  com.bytedance.trae.conversation.imageupload.UploaderConfig  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=9
    if-nez v15, +017h
    and-int/lit8 v14, v14, 16
    if-eqz v14, +007h
    new-instance v12, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader$DefaultImpls$$ExternalSyntheticLambda0;
    invoke-direct v12, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader$DefaultImpls$$ExternalSyntheticLambda0;-><init>()V
    move-object v5, v12
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v6, v13
    invoke-interface/range v0 ... v6, Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;->upload(Ljava/io/File; Ljava/lang/String; Lcom/bytedance/trae/conversation/imageupload/StsTokenData; Lcom/bytedance/trae/conversation/imageupload/UploaderConfig; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
    new-instance v7, Ljava/lang/UnsupportedOperationException;
    const-string v8, "Super calls with default arguments not supported in this target, function: upload"
    invoke-direct v7, v8, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v7
.end method

.method private static upload$lambda$0(int)kotlin.Unit
    .registers 1
    # ins_size=1
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method
