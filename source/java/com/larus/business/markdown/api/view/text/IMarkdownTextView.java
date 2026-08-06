package com.larus.business.markdown.api.view.text;

import android.widget.TextView;
import com.larus.business.markdown.api.model.MarkdownContent;
import kotlin.Metadata;

/* compiled from: IMarkdownTextView.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0007H'J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H&J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "markdownWidth", "", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "asTextView", "Landroid/widget/TextView;", "getSelectedColor", "isSelected", "", "start", "end", "setMarkdown", "", "content", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IMarkdownTextView {
    TextView asTextView();

    MarkdownContent getMarkdownContent();

    int getMarkdownWidth();

    int getSelectedColor();

    boolean isSelected(int start, int end);

    void setMarkdown(MarkdownContent content);

    void setMarkdownWidth(int i);
}
