package com.larus.business.markdown.impl.widget;

import android.content.Context;
import android.os.Looper;
import android.view.ViewGroup;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.widget.IMarkdownWidgetCallback;
import com.larus.business.markdown.api.widget.IMarkdownWidgetHandler;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.commonmark.node.Node;

/* compiled from: MarkdownMultiWidgetHelper.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fJH\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\bJN\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH\u0002JI\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper;", "", "()V", "TAG", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "cutIntoNodeList", "", "Lorg/commonmark/node/Node;", "currentNode", "cutStrategy", "Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper$CutStrategy;", "generateMarkdownWidget", "", "context", "Landroid/content/Context;", "maxContentWidth", "", "isLastNode", "", "rootNode", "currentParentViewGroup", "Landroid/view/ViewGroup;", "lastRecordNode", "widgetHandlerList", "Lcom/larus/business/markdown/api/widget/IMarkdownWidgetHandler;", "generateWidgetFromNode", "node", "beforeUiRunnable", "Lkotlin/Function0;", "updateWidgetFromNode", "(Landroid/content/Context;ILorg/commonmark/node/Node;Ljava/util/List;Landroid/view/ViewGroup;Ljava/lang/Boolean;)V", "CutStrategy", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkdownMultiWidgetHelper {
    public static final MarkdownMultiWidgetHelper INSTANCE = new MarkdownMultiWidgetHelper();
    private static final String TAG = "MarkdownMultiWidgetHelper";
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    /* compiled from: MarkdownMultiWidgetHelper.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/impl/widget/MarkdownMultiWidgetHelper$CutStrategy;", "", "(Ljava/lang/String;I)V", "DoubleCut", "LeftCut", "RightCut", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum CutStrategy {
        DoubleCut,
        LeftCut,
        RightCut
    }

    private MarkdownMultiWidgetHelper() {
    }

    public static /* synthetic */ List cutIntoNodeList$default(MarkdownMultiWidgetHelper markdownMultiWidgetHelper, Node node, CutStrategy cutStrategy, int i, Object obj) {
        if ((i & 2) != 0) {
            cutStrategy = CutStrategy.DoubleCut;
        }
        return markdownMultiWidgetHelper.cutIntoNodeList(node, cutStrategy);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Node> cutIntoNodeList(Node currentNode, CutStrategy cutStrategy) {
        List<Node> nodeList;
        Node node;
        Node copy;
        Node node2;
        Node node3;
        Intrinsics.checkNotNullParameter(currentNode, "currentNode");
        Intrinsics.checkNotNullParameter(cutStrategy, "cutStrategy");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        WidgetUtils.INSTANCE.preorderTraversal(currentNode, linkedHashSet);
        LinkedHashSet<Node> linkedHashSet2 = linkedHashSet;
        Iterator it = linkedHashSet2.iterator();
        while (true) {
            int i = 0;
            Node node4 = null;
            if (!it.hasNext()) {
                break;
            }
            Node node5 = (Node) it.next();
            ArrayList arrayList = new ArrayList();
            Node node6 = null;
            Node node7 = null;
            do {
                Intrinsics.checkNotNull(node5);
                arrayList.add(node5);
                if (node5.getPrevious() != null && node6 == null) {
                    node6 = node5.parent;
                }
                if (node5.next != null && node7 == null) {
                    node7 = node5.parent;
                }
                node5 = node5.parent;
            } while (node5 != null);
            Node node8 = null;
            Node node9 = null;
            for (Object obj : CollectionsKt.toMutableList(CollectionsKt.reversed(arrayList))) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Node node10 = (Node) obj;
                if (cutStrategy != CutStrategy.LeftCut && cutStrategy != CutStrategy.DoubleCut) {
                    node = node4;
                } else if (node6 != null) {
                    Node copy2 = WidgetUtils.INSTANCE.copy(node10);
                    if (copy2 != null) {
                        Map map = copy2.extraInfoMap;
                        Intrinsics.checkNotNullExpressionValue(map, "this.extraInfoMap");
                        map.put("start_self", node10.extraInfoMap.get("start_self"));
                        Map map2 = node10.extraInfoMap;
                        Intrinsics.checkNotNullExpressionValue(map2, "lineNode.extraInfoMap");
                        map2.put("start_self", copy2);
                        node4 = copy2;
                        node = null;
                    } else {
                        node = null;
                        node4 = null;
                    }
                } else {
                    node = node4;
                    node4 = node;
                }
                if (cutStrategy == CutStrategy.RightCut || cutStrategy == CutStrategy.DoubleCut) {
                    if (node7 != null) {
                        copy = WidgetUtils.INSTANCE.copy(node10);
                        if (copy != null) {
                            Map map3 = copy.extraInfoMap;
                            Intrinsics.checkNotNullExpressionValue(map3, "this.extraInfoMap");
                            map3.put("start_self", node10);
                            if (Intrinsics.areEqual(node6, node10)) {
                                node6 = null;
                            }
                            if (Intrinsics.areEqual(node7, node10)) {
                                node7 = null;
                            }
                            if (node4 != null) {
                                WidgetUtils.INSTANCE.insertBeforeMod(node10, node4);
                            }
                            if (copy != null) {
                                WidgetUtils.INSTANCE.insertAfterMod(node10, copy);
                            }
                            if (cutStrategy != CutStrategy.LeftCut || cutStrategy == CutStrategy.DoubleCut) {
                                node2 = node10.prev;
                                while (node2 != null) {
                                    Node node11 = node2.prev;
                                    if (node8 != null) {
                                        WidgetUtils.INSTANCE.prependChildMod(node8, node2);
                                    }
                                    node2 = node11;
                                }
                            }
                            if (cutStrategy != CutStrategy.RightCut || cutStrategy == CutStrategy.DoubleCut) {
                                node3 = node10.next;
                                while (node3 != null) {
                                    Node node12 = node3.next;
                                    if (node9 != null) {
                                        WidgetUtils.INSTANCE.appendChildMod(node9, node3);
                                    }
                                    node3 = node12;
                                }
                            }
                            node9 = copy;
                            node8 = node4;
                            i = i2;
                            node4 = null;
                        }
                    }
                }
                copy = null;
                if (Intrinsics.areEqual(node6, node10)) {
                }
                if (Intrinsics.areEqual(node7, node10)) {
                }
                if (node4 != null) {
                }
                if (copy != null) {
                }
                if (cutStrategy != CutStrategy.LeftCut) {
                }
                node2 = node10.prev;
                while (node2 != null) {
                }
                if (cutStrategy != CutStrategy.RightCut) {
                }
                node3 = node10.next;
                while (node3 != null) {
                }
                node9 = copy;
                node8 = node4;
                i = i2;
                node4 = null;
            }
        }
        ArrayList<Node> arrayList2 = new ArrayList();
        arrayList2.add(currentNode);
        for (Node node13 = currentNode.prev; node13 != null; node13 = node13.prev) {
            arrayList2.add(0, node13);
        }
        for (Node node14 = currentNode.next; node14 != null; node14 = node14.next) {
            arrayList2.add(node14);
        }
        for (Node node15 : arrayList2) {
            node15.prev = null;
            node15.next = null;
        }
        for (Node node16 : linkedHashSet2) {
            boolean z = node16 instanceof WidgetNode;
            WidgetNode widgetNode = z ? (WidgetNode) node16 : null;
            if (widgetNode != null && (nodeList = widgetNode.getNodeList()) != null) {
                Iterator<T> it2 = nodeList.iterator();
                while (it2.hasNext()) {
                    WidgetUtils.INSTANCE.insertBeforeMod(node16, (Node) it2.next());
                }
            }
            WidgetNode widgetNode2 = z ? (WidgetNode) node16 : null;
            if (widgetNode2 != null) {
                widgetNode2.unlink();
            }
        }
        return arrayList2;
    }

    public final void generateMarkdownWidget(Context context, int maxContentWidth, boolean isLastNode, Node rootNode, final ViewGroup currentParentViewGroup, Node lastRecordNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        Intrinsics.checkNotNullParameter(currentParentViewGroup, "currentParentViewGroup");
        if (lastRecordNode == null) {
            generateWidgetFromNode(context, maxContentWidth, rootNode, isLastNode, widgetHandlerList, currentParentViewGroup, new Function0<Unit>() { // from class: com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper$generateMarkdownWidget$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2899invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2899invoke() {
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
        updateWidgetFromNode(context, maxContentWidth, rootNode, widgetHandlerList, currentParentViewGroup, Boolean.valueOf(isLastNode));
    }

    private final void generateWidgetFromNode(Context context, int maxContentWidth, Node node, boolean isLastNode, List<? extends IMarkdownWidgetHandler> widgetHandlerList, final ViewGroup currentParentViewGroup, final Function0<Unit> beforeUiRunnable) {
        List sortedWith;
        List reversed;
        Object obj;
        final IMarkdownWidgetCallback generateMarkdownWidget$default;
        if (widgetHandlerList == null || (sortedWith = CollectionsKt.sortedWith(widgetHandlerList, new Comparator<T>() { // from class: com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper$generateWidgetFromNode$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((IMarkdownWidgetHandler) t).priority()), Integer.valueOf(((IMarkdownWidgetHandler) t2).priority()));
            }
        })) == null || (reversed = CollectionsKt.reversed(sortedWith)) == null) {
            return;
        }
        Iterator it = reversed.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((IMarkdownWidgetHandler) obj).canHandle(node)) {
                    break;
                }
            }
        }
        IMarkdownWidgetHandler iMarkdownWidgetHandler = (IMarkdownWidgetHandler) obj;
        if (iMarkdownWidgetHandler == null || (generateMarkdownWidget$default = IMarkdownWidgetHandler.DefaultImpls.generateMarkdownWidget$default(iMarkdownWidgetHandler, context, maxContentWidth, null, node, Boolean.valueOf(isLastNode), null, 32, null)) == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MarkdownMultiWidgetHelper.generateWidgetFromNode$lambda$13(beforeUiRunnable, generateMarkdownWidget$default, currentParentViewGroup);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            BuildersKt.launch$default(mainScope, (CoroutineContext) null, (CoroutineStart) null, new MarkdownMultiWidgetHelper$generateWidgetFromNode$1(runnable, null), 3, (Object) null);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void generateWidgetFromNode$lambda$13(Function0 function0, IMarkdownWidgetCallback iMarkdownWidgetCallback, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(function0, "$beforeUiRunnable");
        Intrinsics.checkNotNullParameter(iMarkdownWidgetCallback, "$callback");
        Intrinsics.checkNotNullParameter(viewGroup, "$currentParentViewGroup");
        function0.invoke();
        iMarkdownWidgetCallback.handle(viewGroup);
    }

    static /* synthetic */ void updateWidgetFromNode$default(MarkdownMultiWidgetHelper markdownMultiWidgetHelper, Context context, int i, Node node, List list, ViewGroup viewGroup, Boolean bool, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            bool = false;
        }
        markdownMultiWidgetHelper.updateWidgetFromNode(context, i, node, list, viewGroup, bool);
    }

    private final void updateWidgetFromNode(Context context, int maxContentWidth, Node node, List<? extends IMarkdownWidgetHandler> widgetHandlerList, ViewGroup currentParentViewGroup, Boolean isLastNode) {
        Object obj;
        IMarkdownLogger markdownLoggerDelegate;
        IMarkdownWidgetHandler iMarkdownWidgetHandler;
        List sortedWith;
        List reversed;
        Object obj2;
        if (currentParentViewGroup.getChildCount() < 1) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            Job job = null;
            if (widgetHandlerList == null || (sortedWith = CollectionsKt.sortedWith(widgetHandlerList, new Comparator<T>() { // from class: com.larus.business.markdown.impl.widget.MarkdownMultiWidgetHelper$updateWidgetFromNode$lambda$16$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((IMarkdownWidgetHandler) t).priority()), Integer.valueOf(((IMarkdownWidgetHandler) t2).priority()));
                }
            })) == null || (reversed = CollectionsKt.reversed(sortedWith)) == null) {
                iMarkdownWidgetHandler = null;
            } else {
                Iterator it = reversed.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = it.next();
                        if (((IMarkdownWidgetHandler) obj2).canHandle(node)) {
                            break;
                        }
                    }
                }
                iMarkdownWidgetHandler = (IMarkdownWidgetHandler) obj2;
            }
            IMarkdownWidgetCallback updateMarkdownWidget$default = iMarkdownWidgetHandler != null ? IMarkdownWidgetHandler.DefaultImpls.updateMarkdownWidget$default(iMarkdownWidgetHandler, context, maxContentWidth, 0, currentParentViewGroup, node, isLastNode, null, 64, null) : null;
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                job = BuildersKt.launch$default(mainScope, (CoroutineContext) null, (CoroutineStart) null, new MarkdownMultiWidgetHelper$updateWidgetFromNode$1$1(updateMarkdownWidget$default, currentParentViewGroup, null), 3, (Object) null);
            } else if (updateMarkdownWidget$default != null) {
                updateMarkdownWidget$default.updateHandle(0, currentParentViewGroup);
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
}
