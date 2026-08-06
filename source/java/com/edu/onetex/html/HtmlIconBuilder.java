package com.edu.onetex.html;

import com.edu.onetex.html.nodes.InnerCustomViewGenerator;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.edu.onetex.utils.LaTeXLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlIconBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/edu/onetex/html/HtmlIconBuilder;", "", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "(Lcom/edu/onetex/latex/LaTeXParam;)V", "innerCustomViewGenerator", "Lcom/edu/onetex/html/nodes/InnerCustomViewGenerator;", "nHtmlIconBuilder", "", "build", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "customViewGenerator", "Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "finalize", "", "Companion", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class HtmlIconBuilder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final InnerCustomViewGenerator innerCustomViewGenerator;
    private final LaTeXParam latexParam;
    private long nHtmlIconBuilder;

    public HtmlIconBuilder(LaTeXParam laTeXParam) {
        Intrinsics.checkNotNullParameter(laTeXParam, "latexParam");
        this.latexParam = laTeXParam;
        this.innerCustomViewGenerator = new InnerCustomViewGenerator(laTeXParam);
    }

    public final HtmlIconBuilder customViewGenerator(HtmlNodeCustomViewGenerator customViewGenerator) {
        Intrinsics.checkNotNullParameter(customViewGenerator, "customViewGenerator");
        this.innerCustomViewGenerator.setOuterViewGenerator(customViewGenerator);
        return this;
    }

    public final LaTeXIcon build() {
        Companion companion = INSTANCE;
        long nParse = companion.nParse(this.latexParam, this.innerCustomViewGenerator.getNPtr());
        this.nHtmlIconBuilder = nParse;
        long nBuild = companion.nBuild(nParse, this.latexParam.getContent());
        if (nBuild == 0) {
            return null;
        }
        LaTeXIcon laTeXIcon = new LaTeXIcon(nBuild, this.latexParam);
        laTeXIcon.setITeXViewList(this.innerCustomViewGenerator.getCustomViewList());
        LaTeXLogger.INSTANCE.mo408d("HtmlIconBuilder", "HtmlIconBuilder build called! hashCode=" + laTeXIcon);
        return laTeXIcon;
    }

    public final void finalize() {
        LaTeXLogger.INSTANCE.mo408d("HtmlIconBuilder", "HtmlIconBuilder finalize called! hashCode=" + this);
        this.innerCustomViewGenerator.finalize();
    }

    /* compiled from: HtmlIconBuilder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0082 J\u0019\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0082 ¨\u0006\f"}, d2 = {"Lcom/edu/onetex/html/HtmlIconBuilder$Companion;", "", "()V", "nBuild", "", "nBuilder", "content", "", "nParse", "latexParam", "Lcom/edu/onetex/latex/LaTeXParam;", "generatorPtr", "onetex_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        /* JADX INFO: Access modifiers changed from: private */
        public final native long nBuild(long nBuilder, String content);

        /* JADX INFO: Access modifiers changed from: private */
        public final native long nParse(LaTeXParam latexParam, long generatorPtr);

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
