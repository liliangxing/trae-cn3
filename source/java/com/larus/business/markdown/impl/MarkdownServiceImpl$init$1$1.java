package com.larus.business.markdown.impl;

import android.app.Application;
import com.larus.business.markdown.api.depend.IMarkdownConfig;
import com.larus.business.markdown.api.depend.IMarkdownSettings;
import com.larus.business.markdown.api.extplugin.latex.ILatexPlugin;
import com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MarkdownServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.impl.MarkdownServiceImpl$init$1$1", f = "MarkdownServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class MarkdownServiceImpl$init$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMarkdownConfig $config;
    final /* synthetic */ Application $context;
    int label;
    final /* synthetic */ MarkdownServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkdownServiceImpl$init$1$1(Application application, IMarkdownConfig iMarkdownConfig, MarkdownServiceImpl markdownServiceImpl, Continuation<? super MarkdownServiceImpl$init$1$1> continuation) {
        super(2, continuation);
        this.$context = application;
        this.$config = iMarkdownConfig;
        this.this$0 = markdownServiceImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarkdownServiceImpl$init$1$1(this.$context, this.$config, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MarkdownConfigManager markdownConfigManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ILatexPlugin latexPluginDelegate = ILatexPluginKt.getLatexPluginDelegate();
        if (latexPluginDelegate != null) {
            Application application = this.$context;
            IMarkdownSettings markdownSettings = this.$config.getMarkdownSettings();
            latexPluginDelegate.init(application, markdownSettings != null ? markdownSettings.latexGlobalConfig() : null);
        }
        MarkwonContent.Companion companion = MarkwonContent.INSTANCE;
        markdownConfigManager = this.this$0.getMarkdownConfigManager();
        companion.raw(markdownConfigManager, "");
        return Unit.INSTANCE;
    }
}
