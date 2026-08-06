package com.edu.onetex.html.nodes;

import com.edu.onetex.html.HtmlNodeCustomViewGenerator;
import com.edu.onetex.latex.view.ILaTeXView;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultipleCustomViewGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0005H\u0016Jo\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052_\u0010\u0016\u001a[\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006j\u0002`\u000eRÝ\u0001\u0010\u0003\u001aÐ\u0001\u0012\u0004\u0012\u00020\u0005\u0012]\u0012[\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006j\u0002`\u000e0\u0004jg\u0012\u0004\u0012\u00020\u0005\u0012]\u0012[\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0006j\u0002`\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/edu/onetex/html/nodes/MultipleCustomViewGenerator;", "Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "()V", "creatorMap", "Ljava/util/HashMap;", "", "Lkotlin/Function3;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "attribute", "", "data", "Lcom/edu/onetex/html/nodes/AbsHtmlNodeCustomView;", "Lcom/edu/onetex/html/nodes/HtmlNodeCustomViewCreator;", "Lkotlin/collections/HashMap;", "createView", "Lcom/edu/onetex/latex/view/ILaTeXView;", "interceptTag", "", "registerGenerator", "", "generator", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MultipleCustomViewGenerator implements HtmlNodeCustomViewGenerator {
    private final HashMap<String, Function3<String, Map<String, String>, Object, AbsHtmlNodeCustomView>> creatorMap = new HashMap<>();

    public final void registerGenerator(String name, Function3<? super String, ? super Map<String, String>, Object, ? extends AbsHtmlNodeCustomView> generator) {
        Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        Intrinsics.checkNotNullParameter(generator, "generator");
        this.creatorMap.put(name, generator);
    }

    @Override // com.edu.onetex.html.HtmlNodeCustomViewGenerator
    public ILaTeXView createView(String name, Map<String, String> attribute, Object data) {
        Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Function3<String, Map<String, String>, Object, AbsHtmlNodeCustomView> function3 = this.creatorMap.get(name);
        if (function3 == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(function3, "creatorMap[name] ?: return null");
        return (ILaTeXView) function3.invoke(name, attribute, data);
    }

    @Override // com.edu.onetex.html.HtmlNodeCustomViewGenerator
    public boolean interceptTag(String name) {
        Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        return this.creatorMap.containsKey(name);
    }
}
