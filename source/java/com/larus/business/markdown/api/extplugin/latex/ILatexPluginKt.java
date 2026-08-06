package com.larus.business.markdown.api.extplugin.latex;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: ILatexPlugin.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"latexPluginDelegate", "Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "getLatexPluginDelegate", "()Lcom/larus/business/markdown/api/extplugin/latex/ILatexPlugin;", "latexPluginDelegate$delegate", "Lkotlin/Lazy;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ILatexPluginKt {
    private static final Lazy latexPluginDelegate$delegate = LazyKt.lazy(new Function0<ILatexPlugin>() { // from class: com.larus.business.markdown.api.extplugin.latex.ILatexPluginKt$latexPluginDelegate$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ILatexPlugin m2812invoke() {
            try {
                Object newInstance = Class.forName("com.larus.bussiness.markdown.latex.LatexPluginImpl").newInstance();
                if (newInstance instanceof ILatexPlugin) {
                    return (ILatexPlugin) newInstance;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    });

    public static final ILatexPlugin getLatexPluginDelegate() {
        return (ILatexPlugin) latexPluginDelegate$delegate.getValue();
    }
}
