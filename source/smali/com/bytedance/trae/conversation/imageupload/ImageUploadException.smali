# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;
.super Ljava/lang/RuntimeException;
.source "ImageUploadModels.kt"

.field private final code:Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;


.method public constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string v0, "code"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v4, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String; Ljava/lang/Throwable;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;->code Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode  java.lang.String  java.lang.Throwable  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;-><init>(Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public final getCode()com.bytedance.trae.conversation.imageupload.ImageUploadErrorCode
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;->code Lcom/bytedance/trae/conversation/imageupload/ImageUploadErrorCode;
    return-object v0
.end method
