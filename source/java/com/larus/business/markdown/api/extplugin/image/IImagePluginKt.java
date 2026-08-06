package com.larus.business.markdown.api.extplugin.image;

import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: IImagePlugin.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"imagePluginClassNames", "", "", "imagePluginDelegate", "Lcom/larus/business/markdown/api/extplugin/image/IImagePlugin;", "getImagePluginDelegate", "()Lcom/larus/business/markdown/api/extplugin/image/IImagePlugin;", "imagePluginDelegate$delegate", "Lkotlin/Lazy;", "markdown-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class IImagePluginKt {
    private static final List<String> imagePluginClassNames = CollectionsKt.listOf(new String[]{"com.larus.business.markdown.fresco.ImagePluginImpl", "com.ss.android.lark.knowledgeai.markdown.image.ImagePluginImpl"});
    private static final Lazy imagePluginDelegate$delegate = LazyKt.lazy(new Function0<IImagePlugin>() { // from class: com.larus.business.markdown.api.extplugin.image.IImagePluginKt$imagePluginDelegate$2
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IImagePlugin m2811invoke() {
            List list;
            IImagePlugin iImagePlugin;
            IImagePlugin iImagePlugin2;
            list = IImagePluginKt.imagePluginClassNames;
            Iterator it = list.iterator();
            do {
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                try {
                    Result.Companion companion = Result.Companion;
                    Object newInstance = Class.forName(str).newInstance();
                    iImagePlugin2 = Result.constructor-impl(newInstance instanceof IImagePlugin ? (IImagePlugin) newInstance : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    iImagePlugin2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                iImagePlugin = Result.isFailure-impl(iImagePlugin2) ? null : iImagePlugin2;
            } while (iImagePlugin == null);
            return iImagePlugin;
        }
    });

    public static final IImagePlugin getImagePluginDelegate() {
        return (IImagePlugin) imagePluginDelegate$delegate.getValue();
    }
}
