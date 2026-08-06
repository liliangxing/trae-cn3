package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.ViewGroup;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.widget.IMarkdownWidgetCallback;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandler;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.larus.business.markdown.impl.markwon.MarkwonExtKt;
import com.larus.business.markdown.impl.markwon.MarkwonStruct;
import io.noties.markwon.Markwon;
import io.noties.markwon.html.tag.ImageGridHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Node;

/* compiled from: MarkdownWidgetHelper.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0002J8\u0010\u000f\u001a\u00020\b2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u008c\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010(\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004JY\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u00101Jb\u00102\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a05H\u0002J\u0018\u00106\u001a\u00020\b2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0002J]\u0010:\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010;\u001a\u00020\n2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010<\u001a\u00020 2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownWidgetHelper;", "", "()V", "TAG", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "checkHTMLBlockSame", "", "lastNode", "Lorg/commonmark/node/Node;", "currentNode", "compositeNodeList", "nodeList", "", "currentNodeListContainsAllLastNodeList", "lastNodeList", "currentNodeList", "md", "Lio/noties/markwon/Markwon;", "enableOptimizeWidgetCompare", "cutIntoNodeListFromFirstDeep", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "generateFinalNodeList", "generateMarkdownWidgets", "", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "context", "Landroid/content/Context;", "maxContentWidth", "", "lastRecordNodeList", "finished", "lastFinishedStatus", "currentParentViewGroup", "Landroid/view/ViewGroup;", "widgetHandlerList", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "forceUpdateAndIgnoreNew", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "originText", "generateWidgetFromNode", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "node", "prevNode", "isLastNode", "(Landroid/content/Context;ILorg/commonmark/node/Node;Lorg/commonmark/node/Node;Ljava/util/List;Ljava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)Lcom/larus/business/markdown/api/widget/IMarkdownWidgetCallback;", "generateWidgetFromNodeList", "preNode", "beforeUiRunnable", "Lkotlin/Function0;", "isSameSpannableString", "lastSpannedString", "Landroid/text/SpannableStringBuilder;", "currentSpannableString", "updateWidgetFromNode", "it", ImageGridHandler.Index, "(Landroid/content/Context;ILorg/commonmark/node/Node;Ljava/util/List;Landroid/view/ViewGroup;ILjava/lang/Boolean;Lcom/larus/business/markdown/api/model/IMarkwonStruct;)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownWidgetHelper {
    public static final MarkdownWidgetHelper INSTANCE = new MarkdownWidgetHelper();
    private static final String TAG = "MarkdownWidgetHelper";
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    private MarkdownWidgetHelper() {
    }

    public final List<Node> cutIntoNodeListFromFirstDeep(Node currentNode, CustomMarkDownInfo customMarkDownInfo) {
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        if (currentNode != null) {
            ArrayList arrayList = new ArrayList();
            if (currentNode.firstChild != null) {
                Node node = currentNode.firstChild;
                Intrinsics.checkNotNullExpressionValue(node, "childNode");
                arrayList.add(node);
                while (node.next != null) {
                    Node node2 = node.next;
                    Intrinsics.checkNotNullExpressionValue(node2, "childNode.next");
                    arrayList.add(node2);
                    node = node.next;
                }
            }
            return INSTANCE.generateFinalNodeList(arrayList, customMarkDownInfo);
        }
        return CollectionsKt.emptyList();
    }

    public final void generateMarkdownWidgets(MarkdownConfigManager markdownConfigManager, Context context, int maxContentWidth, List<? extends Node> currentNodeList, List<? extends Node> lastRecordNodeList, boolean finished, boolean lastFinishedStatus, CustomMarkDownInfo customMarkDownInfo, final ViewGroup currentParentViewGroup, List<? extends IMarkdownWidgetHandler> widgetHandlerList, boolean forceUpdateAndIgnoreNew, IMarkwonStruct markwonStructCache, String originText) {
        MarkwonStruct markwonStruct;
        MarkwonStruct createStreamMarkwonStruct;
        Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(currentNodeList, "currentNodeList");
        Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
        Intrinsics.checkNotNullParameter(currentParentViewGroup, "currentParentViewGroup");
        if (markwonStructCache == null) {
            if (finished) {
                createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(context, markdownConfigManager, null, customMarkDownInfo, null);
            } else {
                createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(context, markdownConfigManager, null, customMarkDownInfo, null);
            }
            markwonStruct = createStreamMarkwonStruct;
        } else {
            markwonStruct = markwonStructCache;
        }
        final ArrayList arrayList = lastRecordNodeList != null ? new ArrayList(lastRecordNodeList) : null;
        ArrayList arrayList2 = new ArrayList(currentNodeList);
        ArrayList arrayList3 = arrayList2;
        if (!arrayList3.isEmpty()) {
            ((Node) arrayList2.get(0)).originText = originText;
        }
        ArrayList arrayList4 = arrayList;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            generateWidgetFromNodeList(context, maxContentWidth, arrayList2, null, widgetHandlerList, currentParentViewGroup, markwonStructCache, new Function0<Unit>() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$generateMarkdownWidgets$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2900invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2900invoke() {
                    currentParentViewGroup.removeAllViews();
                }
            });
            IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
            if (markdownLoggerDelegate != null) {
                markdownLoggerDelegate.mo2528d(TAG, "lastNodeList == null , generateAllWidgets!!");
                return;
            }
            return;
        }
        if (!forceUpdateAndIgnoreNew) {
            if (arrayList2.size() == arrayList.size() && finished && lastFinishedStatus && (!arrayList3.isEmpty()) && (!arrayList4.isEmpty()) && currentNodeListContainsAllLastNodeList(arrayList.subList(0, RangesKt.coerceAtLeast(arrayList.size(), 0)), arrayList2.subList(0, RangesKt.coerceAtLeast(arrayList2.size(), 0)), markwonStruct.getMarkwon(), markdownConfigManager.getSettings().enableOptimizeWidgetCompare())) {
                return;
            }
            if (arrayList2.size() == arrayList.size() && (!arrayList3.isEmpty()) && (!arrayList4.isEmpty()) && currentNodeListContainsAllLastNodeList(arrayList.subList(0, RangesKt.coerceAtLeast(arrayList.size() - 1, 0)), arrayList2.subList(0, RangesKt.coerceAtLeast(arrayList2.size() - 1, 0)), markwonStruct.getMarkwon(), markdownConfigManager.getSettings().enableOptimizeWidgetCompare())) {
                updateWidgetFromNode(context, maxContentWidth, (Node) CollectionsKt.last(arrayList2), widgetHandlerList, currentParentViewGroup, arrayList2.size() - 1, true, markwonStructCache);
                return;
            }
            if (arrayList2.size() > arrayList.size()) {
                ArrayList arrayList5 = arrayList2;
                if (currentNodeListContainsAllLastNodeList(arrayList.subList(0, RangesKt.coerceAtLeast(arrayList.size() - 1, 0)), arrayList5, markwonStruct.getMarkwon(), markdownConfigManager.getSettings().enableOptimizeWidgetCompare())) {
                    List<? extends Node> subList = arrayList2.subList(arrayList.size() - 1, arrayList2.size());
                    Intrinsics.checkNotNullExpressionValue(subList, "nodeList.subList(lastNod…size - 1 , nodeList.size)");
                    Object orNull = CollectionsKt.getOrNull(arrayList5, arrayList.size() - 2);
                    generateWidgetFromNodeList(context, maxContentWidth, subList, (Node) (arrayList.size() > 1 ? orNull : null), widgetHandlerList, currentParentViewGroup, markwonStructCache, new Function0<Unit>() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$generateMarkdownWidgets$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2901invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2901invoke() {
                            currentParentViewGroup.removeViewAt(RangesKt.coerceAtLeast(arrayList.size() - 1, 0));
                        }
                    });
                    return;
                }
            }
            generateWidgetFromNodeList(context, maxContentWidth, arrayList2, null, widgetHandlerList, currentParentViewGroup, markwonStructCache, new Function0<Unit>() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$generateMarkdownWidgets$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2902invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2902invoke() {
                    currentParentViewGroup.removeAllViews();
                }
            });
            return;
        }
        int i = 0;
        for (Object obj : arrayList2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Node node = (Node) obj;
            if (i < currentParentViewGroup.getChildCount()) {
                INSTANCE.updateWidgetFromNode(context, maxContentWidth, node, widgetHandlerList, currentParentViewGroup, i, Boolean.valueOf(i == arrayList2.size() - 1), markwonStructCache);
            }
            i = i2;
        }
    }

    private final boolean currentNodeListContainsAllLastNodeList(List<? extends Node> lastNodeList, List<? extends Node> currentNodeList, Markwon md, boolean enableOptimizeWidgetCompare) {
        boolean isSameSpannableString;
        Node node;
        Node node2;
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2528d(TAG, "currentNodeListContainsAllLastNodeList \n lastNodeList size " + (lastNodeList != null ? Integer.valueOf(lastNodeList.size()) : null) + ", currentNodeList size " + (currentNodeList != null ? Integer.valueOf(currentNodeList.size()) : null));
        }
        if (lastNodeList == null || currentNodeList == null) {
            return false;
        }
        Iterator<T> it = lastNodeList.iterator();
        while (it.hasNext()) {
            int indexOf = lastNodeList.indexOf((Node) it.next());
            if (enableOptimizeWidgetCompare) {
                isSameSpannableString = WidgetUtils.INSTANCE.checkTreeSame(lastNodeList.get(indexOf), currentNodeList.get(indexOf));
            } else {
                Spanned render = md.render(lastNodeList.get(indexOf));
                Intrinsics.checkNotNull(render, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                Spanned render2 = md.render(currentNodeList.get(indexOf));
                Intrinsics.checkNotNull(render2, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                isSameSpannableString = INSTANCE.isSameSpannableString((SpannableStringBuilder) render, (SpannableStringBuilder) render2);
            }
            if (!Intrinsics.areEqual(lastNodeList.get(indexOf).getClass(), currentNodeList.get(indexOf).getClass()) || !isSameSpannableString) {
                IMarkdownLogger markdownLoggerDelegate2 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
                if (markdownLoggerDelegate2 != null) {
                    markdownLoggerDelegate2.mo2528d(TAG, "not equal node with : lastNodeList[index].javaClass = " + lastNodeList.get(indexOf).getClass() + " , currentNodeList[index].javaClass = " + currentNodeList.get(indexOf).getClass());
                }
                return false;
            }
            Node node3 = lastNodeList.get(indexOf);
            Node node4 = currentNodeList.get(indexOf);
            MarkdownWidgetHelper markdownWidgetHelper = INSTANCE;
            if (!markdownWidgetHelper.checkHTMLBlockSame(node3, node4)) {
                return false;
            }
            Node node5 = lastNodeList.get(indexOf);
            Node node6 = (node5 == null || (node2 = node5.firstChild) == null) ? null : node2.firstChild;
            Node node7 = currentNodeList.get(indexOf);
            if (!markdownWidgetHelper.checkHTMLBlockSame(node6, (node7 == null || (node = node7.firstChild) == null) ? null : node.firstChild)) {
                return false;
            }
        }
        IMarkdownLogger markdownLoggerDelegate3 = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate3 == null) {
            return true;
        }
        markdownLoggerDelegate3.mo2528d(TAG, "size =  " + lastNodeList.size() + " contains all node list");
        return true;
    }

    private final boolean checkHTMLBlockSame(Node lastNode, Node currentNode) {
        return ((lastNode instanceof HtmlBlock) && (currentNode instanceof HtmlBlock) && !Intrinsics.areEqual(((HtmlBlock) lastNode).getLiteral(), ((HtmlBlock) currentNode).getLiteral())) ? false : true;
    }

    private final boolean isSameSpannableString(SpannableStringBuilder lastSpannedString, SpannableStringBuilder currentSpannableString) {
        if (!Intrinsics.areEqual(lastSpannedString.toString(), currentSpannableString.toString())) {
            return false;
        }
        Object[] spans = lastSpannedString.getSpans(0, lastSpannedString.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        Object[] spans2 = currentSpannableString.getSpans(0, currentSpannableString.length(), Object.class);
        Intrinsics.checkExpressionValueIsNotNull(spans2, "getSpans(start, end, T::class.java)");
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2528d(TAG, "lastSpanCount = " + spans.length + " , currentSpanCount = " + spans2.length);
        }
        if (spans.length != spans2.length) {
            return false;
        }
        int length = spans.length;
        for (int i = 0; i < length; i++) {
            if (lastSpannedString.getSpanStart(spans[i]) != currentSpannableString.getSpanStart(spans2[i]) || lastSpannedString.getSpanEnd(spans[i]) != currentSpannableString.getSpanEnd(spans2[i]) || lastSpannedString.getSpanFlags(spans[i]) != currentSpannableString.getSpanFlags(spans2[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWidgetFromNode(Context context, int maxContentWidth, Node it, List<? extends IMarkdownWidgetHandler> widgetHandlerList, ViewGroup currentParentViewGroup, int index, Boolean isLastNode, IMarkwonStruct markwonStructCache) {
        Object obj;
        IMarkdownLogger markdownLoggerDelegate;
        IMarkdownWidgetHandler iMarkdownWidgetHandler;
        List sortedWith;
        List reversed;
        Object obj2;
        try {
            Result.Companion companion = Result.Companion;
            Job job = null;
            if (widgetHandlerList == null || (sortedWith = CollectionsKt.sortedWith(widgetHandlerList, new Comparator<T>() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$updateWidgetFromNode$lambda$7$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((IMarkdownWidgetHandler) t).priority()), Integer.valueOf(((IMarkdownWidgetHandler) t2).priority()));
                }
            })) == null || (reversed = CollectionsKt.reversed(sortedWith)) == null) {
                iMarkdownWidgetHandler = null;
            } else {
                Iterator it2 = reversed.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it2.next();
                        if (((IMarkdownWidgetHandler) obj2).canHandle(it)) {
                            break;
                        }
                    }
                }
                iMarkdownWidgetHandler = (IMarkdownWidgetHandler) obj2;
            }
            IMarkdownWidgetCallback updateMarkdownWidget = iMarkdownWidgetHandler != null ? iMarkdownWidgetHandler.updateMarkdownWidget(context, maxContentWidth, index, currentParentViewGroup, it, isLastNode, markwonStructCache) : null;
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                job = BuildersKt.launch$default(mainScope, (CoroutineContext) null, (CoroutineStart) null, new MarkdownWidgetHelper$updateWidgetFromNode$1$1(updateMarkdownWidget, index, currentParentViewGroup, null), 3, (Object) null);
            } else if (updateMarkdownWidget != null) {
                updateMarkdownWidget.updateHandle(index, currentParentViewGroup);
                job = Unit.INSTANCE;
            }
            obj = Result.constructor-impl(job);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate()) == null) {
            return;
        }
        markdownLoggerDelegate.mo2531i(TAG, th2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void generateWidgetFromNodeList(Context context, int maxContentWidth, List<? extends Node> nodeList, Node preNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList, final ViewGroup currentParentViewGroup, IMarkwonStruct markwonStructCache, final Function0<Unit> beforeUiRunnable) {
        List<? extends Node> list = nodeList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Node node = preNode;
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Node node2 = (Node) obj;
            MarkdownWidgetHelper markdownWidgetHelper = INSTANCE;
            boolean z = true;
            if (nodeList.indexOf(node2) != nodeList.size() - 1) {
                z = false;
            }
            arrayList.add(markdownWidgetHelper.generateWidgetFromNode(context, maxContentWidth, node2, node, widgetHandlerList, Boolean.valueOf(z), markwonStructCache));
            i = i2;
            node = node2;
        }
        final List filterNotNull = CollectionsKt.filterNotNull(arrayList);
        Runnable runnable = new Runnable() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MarkdownWidgetHelper.generateWidgetFromNodeList$lambda$12(beforeUiRunnable, filterNotNull, currentParentViewGroup);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            BuildersKt.launch$default(mainScope, (CoroutineContext) null, (CoroutineStart) null, new MarkdownWidgetHelper$generateWidgetFromNodeList$1(runnable, null), 3, (Object) null);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateWidgetFromNodeList$lambda$12(Function0 function0, List list, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(function0, "$beforeUiRunnable");
        Intrinsics.checkNotNullParameter(list, "$callbackList");
        Intrinsics.checkNotNullParameter(viewGroup, "$currentParentViewGroup");
        function0.invoke();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((IMarkdownWidgetCallback) it.next()).handle(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IMarkdownWidgetCallback generateWidgetFromNode(Context context, int maxContentWidth, Node node, Node prevNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList, Boolean isLastNode, IMarkwonStruct markwonStructCache) {
        List sortedWith;
        List reversed;
        Object obj;
        if (widgetHandlerList == null || (sortedWith = CollectionsKt.sortedWith(widgetHandlerList, new Comparator<T>() { // from class: com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$generateWidgetFromNode$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((IMarkdownWidgetHandler) t).priority()), Integer.valueOf(((IMarkdownWidgetHandler) t2).priority()));
            }
        })) == null || (reversed = CollectionsKt.reversed(sortedWith)) == null) {
            return null;
        }
        Iterator it = reversed.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IMarkdownWidgetHandler) obj).canHandle(node)) {
                break;
            }
        }
        IMarkdownWidgetHandler iMarkdownWidgetHandler = (IMarkdownWidgetHandler) obj;
        if (iMarkdownWidgetHandler != null) {
            return iMarkdownWidgetHandler.generateMarkdownWidget(context, maxContentWidth, prevNode, node, isLastNode, markwonStructCache);
        }
        return null;
    }

    private final List<Node> generateFinalNodeList(List<? extends Node> nodeList, CustomMarkDownInfo customMarkDownInfo) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (Object obj : nodeList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Node node = (Node) obj;
            if ((node instanceof HtmlBlock) || ((node instanceof FencedCodeBlock) && Intrinsics.areEqual(customMarkDownInfo.getSplitCodeBlock(), true))) {
                arrayList2.add(Integer.valueOf(i2));
                node.unlink();
            }
            i2 = i3;
        }
        int size = nodeList.size();
        if (arrayList2.isEmpty()) {
            arrayList.add(compositeNodeList(nodeList));
            return arrayList;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (i < intValue) {
                arrayList.add(INSTANCE.compositeNodeList(nodeList.subList(i, intValue)));
                arrayList.add(nodeList.get(intValue));
                i = intValue + 1;
            } else if (i == intValue) {
                arrayList.add(nodeList.get(intValue));
                i++;
            } else if (size == intValue) {
                arrayList.add(nodeList.get(intValue));
            } else if (i > intValue && intValue < size) {
                arrayList.add(INSTANCE.compositeNodeList(nodeList.subList(intValue + 1, size)));
            }
        }
        if (i <= size) {
            List<? extends Node> subList = nodeList.subList(i, size);
            if (!subList.isEmpty()) {
                arrayList.add(compositeNodeList(subList));
            }
        }
        return arrayList;
    }

    private final Node compositeNodeList(List<? extends Node> nodeList) {
        Node document = new Document();
        Iterator<T> it = nodeList.iterator();
        while (it.hasNext()) {
            document.appendChild((Node) it.next());
        }
        return document;
    }
}
