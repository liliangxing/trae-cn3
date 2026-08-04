# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
.field public final synthetic f$1:Landroid/widget/EditText;


.method public synthetic constructor <init>(com.bytedance.trae.login.fragment.PhoneLoginFragment  android.widget.EditText)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;->f$1 Landroid/widget/EditText;
    return-void 
.end method

.method public final run()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;
    iget-object v1, v2, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment$$ExternalSyntheticLambda7;->f$1 Landroid/widget/EditText;
    invoke-static v0, v1, Lcom/bytedance/trae/login/fragment/PhoneLoginFragment;->$r8$lambda$ROL7Wb4cJAJ8XpSj8LUM5nrDc3k(Lcom/bytedance/trae/login/fragment/PhoneLoginFragment; Landroid/widget/EditText;)V
    return-void 
.end method
