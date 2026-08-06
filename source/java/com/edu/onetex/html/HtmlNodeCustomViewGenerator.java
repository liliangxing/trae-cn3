package com.edu.onetex.html;

import com.edu.onetex.latex.view.ILaTeXView;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: HtmlNodeCustomViewGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/edu/onetex/html/HtmlNodeCustomViewGenerator;", "", "createView", "Lcom/edu/onetex/latex/view/ILaTeXView;", "name", "", "attribute", "", "data", "interceptTag", "", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public interface HtmlNodeCustomViewGenerator {
    ILaTeXView createView(String name, Map<String, String> attribute, Object data);

    boolean interceptTag(String name);
}
