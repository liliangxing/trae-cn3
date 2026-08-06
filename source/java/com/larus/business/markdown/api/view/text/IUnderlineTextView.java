package com.larus.business.markdown.api.view.text;

import kotlin.Metadata;

/* compiled from: IUnderlineTextView.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/api/view/text/IUnderlineTextView;", "", "drawLine", "", "getDrawLine", "()Z", "setDrawLine", "(Z)V", "lineColor", "", "getLineColor", "()I", "setLineColor", "(I)V", "setBottomLineWeight", "", "weight", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IUnderlineTextView {
    boolean getDrawLine();

    int getLineColor();

    void setBottomLineWeight(float weight);

    void setDrawLine(boolean z);

    void setLineColor(int i);
}
