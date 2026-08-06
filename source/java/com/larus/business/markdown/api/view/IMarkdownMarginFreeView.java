package com.larus.business.markdown.api.view;

import kotlin.Metadata;

/* compiled from: IMarkdownMarginFreeView.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J=\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/business/markdown/api/view/IMarkdownMarginFreeView;", "", "onMarkdownMarginChanged", "", "left", "", "top", "right", "bottom", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IMarkdownMarginFreeView {
    void onMarkdownMarginChanged(Integer left, Integer top, Integer right, Integer bottom);

    /* compiled from: IMarkdownMarginFreeView.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onMarkdownMarginChanged$default(IMarkdownMarginFreeView iMarkdownMarginFreeView, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMarkdownMarginChanged");
            }
            if ((i & 1) != 0) {
                num = null;
            }
            if ((i & 2) != 0) {
                num2 = null;
            }
            if ((i & 4) != 0) {
                num3 = null;
            }
            if ((i & 8) != 0) {
                num4 = null;
            }
            iMarkdownMarginFreeView.onMarkdownMarginChanged(num, num2, num3, num4);
        }
    }
}
