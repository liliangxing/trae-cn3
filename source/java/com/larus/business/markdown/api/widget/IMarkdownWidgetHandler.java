package com.larus.business.markdown.api.widget;

import android.content.Context;
import android.view.ViewGroup;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import kotlin.Metadata;
import org.commonmark.node.Node;

/* compiled from: IMarkdownWidgetHandler.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JI\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000bH&JO\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "", "canHandle", "", "node", "Lorg/commonmark/node/Node;", "generateMarkdownWidget", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "context", "Landroid/content/Context;", "maxContentWidth", "", "prevNode", "isLastNode", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "(Landroid/content/Context;ILorg/commonmark/node/Node;Lorg/commonmark/node/Node;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "priority", "updateMarkdownWidget", "index", "currentViewGroup", "Landroid/view/ViewGroup;", "(Landroid/content/Context;IILandroid/view/ViewGroup;Lorg/commonmark/node/Node;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface IMarkdownWidgetHandler {
    boolean canHandle(Node node);

    IMarkdownWidgetCallback generateMarkdownWidget(Context context, int maxContentWidth, Node prevNode, Node node, Boolean isLastNode, IMarkwonStruct markwonStructCache);

    int priority();

    IMarkdownWidgetCallback updateMarkdownWidget(Context context, int maxContentWidth, int index, ViewGroup currentViewGroup, Node node, Boolean isLastNode, IMarkwonStruct markwonStructCache);

    /* compiled from: IMarkdownWidgetHandler.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ IMarkdownWidgetCallback generateMarkdownWidget$default(IMarkdownWidgetHandler iMarkdownWidgetHandler, Context context, int i, Node node, Node node2, Boolean bool, IMarkwonStruct iMarkwonStruct, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateMarkdownWidget");
            }
            if ((i2 & 16) != 0) {
                bool = false;
            }
            Boolean bool2 = bool;
            if ((i2 & 32) != 0) {
                iMarkwonStruct = null;
            }
            return iMarkdownWidgetHandler.generateMarkdownWidget(context, i, node, node2, bool2, iMarkwonStruct);
        }

        public static /* synthetic */ IMarkdownWidgetCallback updateMarkdownWidget$default(IMarkdownWidgetHandler iMarkdownWidgetHandler, Context context, int i, int i2, ViewGroup viewGroup, Node node, Boolean bool, IMarkwonStruct iMarkwonStruct, int i3, Object obj) {
            if (obj == null) {
                return iMarkdownWidgetHandler.updateMarkdownWidget(context, i, i2, viewGroup, node, (i3 & 32) != 0 ? false : bool, (i3 & 64) != 0 ? null : iMarkwonStruct);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMarkdownWidget");
        }
    }
}
