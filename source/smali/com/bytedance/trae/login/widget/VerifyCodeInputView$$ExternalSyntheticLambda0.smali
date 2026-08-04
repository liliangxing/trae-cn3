# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/text/InputFilter;

.field public final synthetic f$0:Lcom/bytedance/trae/login/widget/VerifyCodeInputView;


.method public synthetic constructor <init>(com.bytedance.trae.login.widget.VerifyCodeInputView)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    return-void 
.end method

.method public final filter(java.lang.CharSequence  int  int  android.text.Spanned  int  int)java.lang.CharSequence
    .registers 14
    # ins_size=7
    iget-object v0, v7, Lcom/bytedance/trae/login/widget/VerifyCodeInputView$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/login/widget/VerifyCodeInputView;
    move-object v1, v8
    move v2, v9
    move v3, v10
    move-object v4, v11
    move v5, v12
    move v6, v13
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/login/widget/VerifyCodeInputView;->$r8$lambda$KFLEvp2YoLgoRTmtScaZrRXNkPA(Lcom/bytedance/trae/login/widget/VerifyCodeInputView; Ljava/lang/CharSequence; I I Landroid/text/Spanned; I I)Ljava/lang/CharSequence;
    move-result-object v8
    return-object v8
.end method
