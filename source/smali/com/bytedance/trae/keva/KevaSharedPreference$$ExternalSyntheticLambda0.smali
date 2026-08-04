# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final synthetic Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(java.lang.String  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput v2, v0, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;->f$1 I
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget v1, v2, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;->f$1 I
    invoke-static v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->$r8$lambda$dx2bLNSfhkV7ViviWmo2IswxYvY(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method
