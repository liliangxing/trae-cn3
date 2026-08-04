# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;
.super Ljava/lang/Object;
.source "TraeViewMinimizedVoiceBarBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnMaximize:Landroidx/appcompat/widget/AppCompatImageButton;
.field public final ivChatIcon:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
.field private final rootView:Landroid/view/View;
.field public final tvTimer:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(android.view.View  androidx.appcompat.widget.AppCompatImageButton  com.bytedance.trae.conversation.brainstorm.widget.VoiceStatusWaveIconView  android.widget.TextView  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->rootView Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->btnMaximize Landroidx/appcompat/widget/AppCompatImageButton;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->ivChatIcon Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->tvTimer Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeViewMinimizedVoiceBarBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_maximize I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroidx/appcompat/widget/AppCompatImageButton;
    if-eqz v4, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_chat_icon I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView;
    if-eqz v5, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_timer I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +015h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;
    move-object v2, v0
    move-object v3, v8
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;-><init>(Landroid/view/View; Landroidx/appcompat/widget/AppCompatImageButton; Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceStatusWaveIconView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup)com.bytedance.trae.conversation.databinding.TraeViewMinimizedVoiceBarBinding
    .registers 3
    # ins_size=2
    if-eqz v2, +00ch
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_view_minimized_voice_bar I
    invoke-virtual v1, v0, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;
    move-result-object v1
    return-object v1
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "parent"
    invoke-direct v1, v2, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public getRoot()android.view.View
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeViewMinimizedVoiceBarBinding;->rootView Landroid/view/View;
    return-object v0
.end method
