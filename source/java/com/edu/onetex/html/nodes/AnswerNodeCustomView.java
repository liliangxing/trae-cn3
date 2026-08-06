package com.edu.onetex.html.nodes;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.edu.onetex.latex.TexSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnswerNodeCustomView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/edu/onetex/html/nodes/AnswerNodeCustomView;", "Lcom/edu/onetex/html/nodes/AbsHtmlNodeCustomView;", "width", "Lcom/edu/onetex/latex/TexSize;", "height", "(Lcom/edu/onetex/latex/TexSize;Lcom/edu/onetex/latex/TexSize;)V", "createAndroidView", "Landroid/view/View;", "context", "Landroid/content/Context;", "onetex_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AnswerNodeCustomView extends AbsHtmlNodeCustomView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnswerNodeCustomView(TexSize width, TexSize height) {
        super(width, height);
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
    }

    @Override // com.edu.onetex.html.nodes.AbsHtmlNodeCustomView
    public View createAndroidView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new EditText(context);
    }
}
