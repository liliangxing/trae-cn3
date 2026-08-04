# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
.super Lcom/bytedance/trae/keva/SyncWeakListenerRegister;
.source "KevaSharedPreference.kt"

.field final synthetic this$0:Lcom/bytedance/trae/keva/KevaSharedPreference;


.method constructor <init>(com.bytedance.trae.keva.KevaSharedPreference)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->this$0 Lcom/bytedance/trae/keva/KevaSharedPreference;
    invoke-direct v0, Lcom/bytedance/trae/keva/SyncWeakListenerRegister;-><init>()V
    return-void 
.end method

.method protected onListenerCountChanged(int)void
    .registers 3
    # ins_size=2
    if-eqz v2, +014h
    const/4 v0, 1
    if-eq v2, v0, +003h
    goto +1ch
    iget-object v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->this$0 Lcom/bytedance/trae/keva/KevaSharedPreference;
    invoke-static v2, Lcom/bytedance/trae/keva/KevaSharedPreference;->access$getKeva(Lcom/bytedance/trae/keva/KevaSharedPreference;)Lcom/bytedance/keva/Keva;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->this$0 Lcom/bytedance/trae/keva/KevaSharedPreference;
    check-cast v0, Lcom/bytedance/keva/Keva$OnChangeListener;
    invoke-virtual v2, v0, Lcom/bytedance/keva/Keva;->registerChangeListener(Lcom/bytedance/keva/Keva$OnChangeListener;)V
    goto +eh
    iget-object v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->this$0 Lcom/bytedance/trae/keva/KevaSharedPreference;
    invoke-static v2, Lcom/bytedance/trae/keva/KevaSharedPreference;->access$getKeva(Lcom/bytedance/trae/keva/KevaSharedPreference;)Lcom/bytedance/keva/Keva;
    move-result-object v2
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->this$0 Lcom/bytedance/trae/keva/KevaSharedPreference;
    check-cast v0, Lcom/bytedance/keva/Keva$OnChangeListener;
    invoke-virtual v2, v0, Lcom/bytedance/keva/Keva;->unRegisterChangeListener(Lcom/bytedance/keva/Keva$OnChangeListener;)V
    return-void 
.end method
