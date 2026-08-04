# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;
.super Ljava/lang/Object;
.source "PhoneLoginViewModel.kt"

.implements Lcom/bytedance/trae/login/IVerificationCodeCallback;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;


.method constructor <init>(com.bytedance.trae.login.fragment.PhoneLoginViewModel)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onSendFailure(int  java.lang.String  java.lang.Integer  java.lang.String)void
    .registers 5
    # ins_size=5
    iget-object v3, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    invoke-static v3, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->access$get_sendCodeState$p(Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;
    invoke-direct v4, v1, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;-><init>(I Ljava/lang/String;)V
    invoke-virtual v3, v4, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public onSendSuccess()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$sendVerificationCode$1;->this$0 Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;
    invoke-static v0, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;->access$get_sendCodeState$p(Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;)Landroidx/lifecycle/MutableLiveData;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Success;->INSTANCE Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Success;
    invoke-virtual v0, v1, Landroidx/lifecycle/MutableLiveData;->postValue(Ljava/lang/Object;)V
    return-void 
.end method
