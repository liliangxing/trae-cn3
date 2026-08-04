# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/privacy/PrivacyExtensionKt;
.super Ljava/lang/Object;
.source "PrivacyExtension.kt"


.method public static final ifPrivacyNotAgree(kotlin.jvm.functions.Function0)java.lang.Object
    .registers 2
    # ins_size=1
    const-string v0, "block"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +007h
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    return-object v1
.end method
