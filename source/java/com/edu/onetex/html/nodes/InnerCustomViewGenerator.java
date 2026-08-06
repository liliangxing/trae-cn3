package com.edu.onetex.html.nodes;

import com.edu.onetex.html.HtmlEngine;
import com.edu.onetex.html.HtmlNodeCustomViewGenerator;
import com.edu.onetex.html.HtmlTagImageData;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.TexSize;
import com.edu.onetex.latex.view.ILaTeXView;
import com.lynx.tasm.DefaultLogicExecutor;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InnerCustomViewGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0011\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0086 J\u0011\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\rH\u0086 R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Lcom/edu/onetex/html/nodes/InnerCustomViewGenerator;", "Lcom/edu/onetex/html/nodes/MultipleCustomViewGenerator;", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(Lcom/edu/onetex/latex/LaTeXParam;)V", "customViewList", "Ljava/util/LinkedList;", "Lcom/edu/onetex/latex/view/ILaTeXView;", "getCustomViewList", "()Ljava/util/LinkedList;", "getLatexParam", "()Lcom/edu/onetex/latex/LaTeXParam;", "<set-?>", "", "nPtr", "getNPtr", "()J", "outerViewGenerator", "Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "getOuterViewGenerator", "()Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "setOuterViewGenerator", "(Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;)V", "createView", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "attribute", "", "data", "", "finalize", "", "interceptTag", "", "nCreate", "innerCustomViewGenerator", "nFinalize", "ptr", "ImageNodeCustomViewCreator", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class InnerCustomViewGenerator extends MultipleCustomViewGenerator {
    private final LinkedList<ILaTeXView> customViewList;
    private final LaTeXParam latexParam;
    private long nPtr;
    private HtmlNodeCustomViewGenerator outerViewGenerator;

    public final native long nCreate(HtmlNodeCustomViewGenerator innerCustomViewGenerator);

    public final native void nFinalize(long ptr);

    public InnerCustomViewGenerator(LaTeXParam laTeXParam) {
        Intrinsics.checkNotNullParameter(laTeXParam, "latexParam");
        this.latexParam = laTeXParam;
        this.customViewList = new LinkedList<>();
        this.nPtr = nCreate(this);
        registerGenerator("img", new ImageNodeCustomViewCreator(laTeXParam));
    }

    public final LaTeXParam getLatexParam() {
        return this.latexParam;
    }

    public final long getNPtr() {
        return this.nPtr;
    }

    public final HtmlNodeCustomViewGenerator getOuterViewGenerator() {
        return this.outerViewGenerator;
    }

    public final void setOuterViewGenerator(HtmlNodeCustomViewGenerator htmlNodeCustomViewGenerator) {
        this.outerViewGenerator = htmlNodeCustomViewGenerator;
    }

    public final LinkedList<ILaTeXView> getCustomViewList() {
        return this.customViewList;
    }

    @Override // com.edu.onetex.html.nodes.MultipleCustomViewGenerator, com.edu.onetex.html.HtmlNodeCustomViewGenerator
    public ILaTeXView createView(String name, Map<String, String> attribute, Object data) {
        Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        HtmlNodeCustomViewGenerator htmlNodeCustomViewGenerator = this.outerViewGenerator;
        boolean interceptTag = htmlNodeCustomViewGenerator != null ? htmlNodeCustomViewGenerator.interceptTag(name) : false;
        boolean interceptTag2 = super.interceptTag(name);
        ILaTeXView iLaTeXView = null;
        if (interceptTag) {
            HtmlNodeCustomViewGenerator htmlNodeCustomViewGenerator2 = this.outerViewGenerator;
            if (htmlNodeCustomViewGenerator2 != null) {
                iLaTeXView = htmlNodeCustomViewGenerator2.createView(name, attribute, data);
            }
        } else if (interceptTag2) {
            iLaTeXView = super.createView(name, attribute, data);
        }
        if (iLaTeXView != null) {
            this.customViewList.add(iLaTeXView);
        }
        return iLaTeXView;
    }

    @Override // com.edu.onetex.html.nodes.MultipleCustomViewGenerator, com.edu.onetex.html.HtmlNodeCustomViewGenerator
    public boolean interceptTag(String name) {
        Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
        HtmlNodeCustomViewGenerator htmlNodeCustomViewGenerator = this.outerViewGenerator;
        return (htmlNodeCustomViewGenerator != null ? htmlNodeCustomViewGenerator.interceptTag(name) : false) || super.interceptTag(name);
    }

    public final void finalize() {
        long j = this.nPtr;
        if (j != 0) {
            nFinalize(j);
            this.nPtr = 0L;
        }
    }

    /* compiled from: InnerCustomViewGenerator.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002[\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0004\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001j\u0002`\nB\r\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ1\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/edu/onetex/html/nodes/InnerCustomViewGenerator$ImageNodeCustomViewCreator;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "", "attribute", "", "data", "Lcom/edu/onetex/html/nodes/AbsHtmlNodeCustomView;", "Lcom/edu/onetex/html/nodes/HtmlNodeCustomViewCreator;", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(Lcom/edu/onetex/latex/LaTeXParam;)V", "getLatexParam", "()Lcom/edu/onetex/latex/LaTeXParam;", "invoke", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class ImageNodeCustomViewCreator implements Function3<String, Map<String, ? extends String>, Object, AbsHtmlNodeCustomView> {
        private final LaTeXParam latexParam;

        public ImageNodeCustomViewCreator(LaTeXParam laTeXParam) {
            Intrinsics.checkNotNullParameter(laTeXParam, "latexParam");
            this.latexParam = laTeXParam;
        }

        public final LaTeXParam getLatexParam() {
            return this.latexParam;
        }

        public AbsHtmlNodeCustomView invoke(String name, Map<String, String> attribute, Object data) {
            Intrinsics.checkNotNullParameter(name, DefaultLogicExecutor.GLOBAL_EVENT_NAME);
            Intrinsics.checkNotNullParameter(attribute, "attribute");
            if (!(data instanceof HtmlTagImageData)) {
                return null;
            }
            HtmlTagImageData htmlTagImageData = (HtmlTagImageData) data;
            return new ImageNodeCustomView(new TexSize((float) htmlTagImageData.getWidth(), 1), new TexSize((float) htmlTagImageData.getHeight(), 1), htmlTagImageData.getSrc(), HtmlEngine.INSTANCE.getImageUrlDomain());
        }
    }
}
