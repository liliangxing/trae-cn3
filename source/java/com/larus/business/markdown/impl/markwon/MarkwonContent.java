package com.larus.business.markdown.impl.markwon;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.api.FullScreenDetailSpanClickListener;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManager;
import com.larus.business.markdown.api.depend.IMarkdownEnsureManagerKt;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import com.larus.business.markdown.api.model.CitationSpanClickListener;
import com.larus.business.markdown.api.model.CodeCopySpanClickListener;
import com.larus.business.markdown.api.model.CustomMarkDownInfo;
import com.larus.business.markdown.api.model.ICodeCopyInfoSpan;
import com.larus.business.markdown.api.model.ICustomCitationSpan;
import com.larus.business.markdown.api.model.IMarkwonStruct;
import com.larus.business.markdown.api.model.MarkdownContent;
import com.larus.business.markdown.api.model.MarkwonPerformance;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import com.larus.business.markdown.impl.common.MarkdownConfigManager;
import com.larus.business.markdown.impl.common.StreamOptimizeUtils;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CustomCitationClickSpan;
import com.larus.business.markdown.impl.markwon.custom.title.FullScreenDetailClickSpan;
import com.larus.business.markdown.impl.markwon.custom.title.FullScreenDetailInfoSpan;
import io.noties.markwon.RenderCallback;
import io.noties.markwon.core.spans.CodeBlockSpan;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.codeblock.CodeCopyClickSpan;
import io.noties.markwon.core.spans.codeblock.CodeCopyInfoSpan;
import io.noties.markwon.ext.tables.TableRowSpan2;
import io.noties.markwon.ext.tables.TableSpan;
import io.noties.markwon.html.CustomHtmlPlugin;
import io.noties.markwon.image.AsyncDrawableSpan;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* compiled from: MarkwonContent.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 X2\u00020\u0001:\u0001XB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012(\b\u0002\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005¢\u0006\u0002\u0010\u0014J*\u00108\u001a\u000209\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<2\f\u0010>\u001a\b\u0012\u0004\u0012\u0002H:0?H\u0002J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010B\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J\u0010\u0010C\u001a\u0002092\u0006\u0010A\u001a\u00020\u0017H\u0016J.\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u00102\f\u0010G\u001a\b\u0012\u0004\u0012\u0002090H2\u0006\u0010I\u001a\u00020JH\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u0018H\u0016J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0018H\u0016J\u000e\u0010O\u001a\b\u0012\u0004\u0012\u00020P0\u0018H\u0016J\u001a\u0010Q\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\u001a\u0010T\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010UH\u0016J\u001a\u0010V\u001a\u0002092\u0006\u0010A\u001a\u00020\u00172\b\u0010R\u001a\u0004\u0018\u00010WH\u0016R \u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00100\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u0014\u0010\u0013\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R4\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001b\u00101\u001a\u0002028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010$\u001a\u0004\b3\u00104R \u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "markdown", "Landroid/text/SpannableStringBuilder;", "hasTable", "", "hasHtml", "hasCodeBlock", "node", "Lorg/commonmark/node/Node;", "markwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "markwonPerformance", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "nodeInfo", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "isFinished", "(Landroid/text/SpannableStringBuilder;ZZZLorg/commonmark/node/Node;Lcom/larus/business/markdown/api/model/IMarkwonStruct;Lcom/larus/business/markdown/api/model/MarkwonPerformance;Ljava/util/HashMap;Z)V", "customCitationClickSpanMap", "Ljava/util/WeakHashMap;", "Landroid/view/View;", "", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CustomCitationClickSpan;", "fullScreenDetailClickSpanMap", "Lcom/larus/business/markdown/impl/markwon/custom/title/FullScreenDetailClickSpan;", "getHasCodeBlock", "()Z", "getHasHtml", "getHasTable", "imageUrls", "getImageUrls", "()Ljava/util/List;", "imageUrls$delegate", "Lkotlin/Lazy;", "getMarkdown", "()Landroid/text/SpannableStringBuilder;", "setMarkdown", "(Landroid/text/SpannableStringBuilder;)V", "getMarkwonPerformance", "()Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "getMarkwonStruct", "()Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "getNode", "()Lorg/commonmark/node/Node;", "getNodeInfo", "()Ljava/util/HashMap;", "readText", "", "getReadText", "()Ljava/lang/CharSequence;", "readText$delegate", "viewCodeCopyClickSpanMap", "Lio/noties/markwon/core/spans/codeblock/CodeCopyClickSpan;", "appendSpannedIndex", "", "T", "spanIndexList", "", "Lcom/larus/business/markdown/impl/markwon/SpannedIndex;", "clazz", "Ljava/lang/Class;", "clearCodeCopySpanClickListener", "view", "clearCustomCitationSpansListener", "clearFullScreenDetailSpanClickListener", "findCustomLinkSpan", "queryKey", "queryValue", "callback", "Lkotlin/Function0;", "onClick", "Landroid/view/View$OnClickListener;", "getCopyInfoSpans", "Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;", "getCustomCitationSpans", "Lcom/larus/business/markdown/api/model/ICustomCitationSpan;", "getFormulaSpans", "Lio/noties/markwon/image/AsyncDrawableSpan;", "setCodeCopySpanClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;", "setCustomCitationSpansListener", "Lcom/larus/business/markdown/api/model/CitationSpanClickListener;", "setFullScreenDetailSpanClickListener", "Lcom/larus/business/markdown/api/FullScreenDetailSpanClickListener;", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class MarkwonContent implements MarkdownContent {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object locker = new Object();
    private final WeakHashMap<View, List<CustomCitationClickSpan>> customCitationClickSpanMap;
    private final WeakHashMap<View, List<FullScreenDetailClickSpan>> fullScreenDetailClickSpanMap;
    private final boolean hasCodeBlock;
    private final boolean hasHtml;
    private final boolean hasTable;

    /* renamed from: imageUrls$delegate, reason: from kotlin metadata */
    private final Lazy imageUrls;
    private final boolean isFinished;
    private SpannableStringBuilder markdown;
    private final MarkwonPerformance markwonPerformance;
    private final IMarkwonStruct markwonStruct;
    private final Node node;
    private final HashMap<String, Integer> nodeInfo;

    /* renamed from: readText$delegate, reason: from kotlin metadata */
    private final Lazy readText;
    private final WeakHashMap<View, List<CodeCopyClickSpan>> viewCodeCopyClickSpanMap;

    public MarkwonContent(SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, Node node, IMarkwonStruct iMarkwonStruct, MarkwonPerformance markwonPerformance, HashMap<String, Integer> hashMap, boolean z4) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "markdown");
        this.markdown = spannableStringBuilder;
        this.hasTable = z;
        this.hasHtml = z2;
        this.hasCodeBlock = z3;
        this.node = node;
        this.markwonStruct = iMarkwonStruct;
        this.markwonPerformance = markwonPerformance;
        this.nodeInfo = hashMap;
        this.isFinished = z4;
        this.viewCodeCopyClickSpanMap = new WeakHashMap<>();
        this.customCitationClickSpanMap = new WeakHashMap<>();
        this.fullScreenDetailClickSpanMap = new WeakHashMap<>();
        this.readText = LazyKt.lazy(new Function0<String>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$readText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final String invoke() {
                ArrayList<SpannedIndex> arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                if (MarkwonContent.this.getHasTable()) {
                    MarkwonContent.this.appendSpannedIndex(arrayList, TableSpan.class);
                }
                if (MarkwonContent.this.getHasCodeBlock()) {
                    MarkwonContent.this.appendSpannedIndex(arrayList, CodeBlockSpan.class);
                }
                if (arrayList.size() > 1) {
                    CollectionsKt.sortWith(arrayList, new Comparator<T>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$readText$2$invoke$$inlined$sortBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(Integer.valueOf(((SpannedIndex) t).getStart()), Integer.valueOf(((SpannedIndex) t2).getStart()));
                        }
                    });
                }
                MarkwonContent markwonContent = MarkwonContent.this;
                int i = 0;
                for (SpannedIndex spannedIndex : arrayList) {
                    if (spannedIndex.getStart() > i) {
                        sb.append(markwonContent.getMarkdown().subSequence(i, spannedIndex.getStart()));
                    }
                    int end = spannedIndex.getEnd() - spannedIndex.getStart();
                    for (int i2 = 0; i2 < end; i2++) {
                        sb.append(" ");
                    }
                    i = spannedIndex.getEnd();
                }
                if (i < MarkwonContent.this.getMarkdown().length()) {
                    sb.append(MarkwonContent.this.getMarkdown().subSequence(i, MarkwonContent.this.getMarkdown().length()));
                }
                return sb.toString();
            }
        });
        this.imageUrls = LazyKt.lazy(new Function0<List<? extends String>>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$imageUrls$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final List<String> invoke() {
                Object[] spans = MarkwonContent.this.getMarkdown().getSpans(0, MarkwonContent.this.getMarkdown().length(), ICustomImgSpan.class);
                Intrinsics.checkNotNullExpressionValue(spans, "markdown.getSpans(0, mar…ustomImgSpan::class.java)");
                ArrayList arrayList = new ArrayList(spans.length);
                for (Object obj : spans) {
                    arrayList.add(((ICustomImgSpan) obj).getUrl());
                }
                return CollectionsKt.reversed(arrayList);
            }
        });
    }

    public /* synthetic */ MarkwonContent(SpannableStringBuilder spannableStringBuilder, boolean z, boolean z2, boolean z3, Node node, IMarkwonStruct iMarkwonStruct, MarkwonPerformance markwonPerformance, HashMap hashMap, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(spannableStringBuilder, z, z2, z3, (i & 16) != 0 ? null : node, (i & 32) != 0 ? null : iMarkwonStruct, (i & 64) != 0 ? null : markwonPerformance, (i & 128) != 0 ? null : hashMap, (i & 256) != 0 ? true : z4);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public SpannableStringBuilder getMarkdown() {
        return this.markdown;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void setMarkdown(SpannableStringBuilder spannableStringBuilder) {
        Intrinsics.checkNotNullParameter(spannableStringBuilder, "<set-?>");
        this.markdown = spannableStringBuilder;
    }

    public final boolean getHasTable() {
        return this.hasTable;
    }

    public final boolean getHasHtml() {
        return this.hasHtml;
    }

    public final boolean getHasCodeBlock() {
        return this.hasCodeBlock;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public Node getNode() {
        return this.node;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public IMarkwonStruct getMarkwonStruct() {
        return this.markwonStruct;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public MarkwonPerformance getMarkwonPerformance() {
        return this.markwonPerformance;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public HashMap<String, Integer> getNodeInfo() {
        return this.nodeInfo;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    /* renamed from: isFinished, reason: from getter */
    public boolean getIsFinished() {
        return this.isFinished;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public CharSequence getReadText() {
        Object value = this.readText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-readText>(...)");
        return (CharSequence) value;
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void findCustomLinkSpan(String queryKey, String queryValue, Function0<Unit> callback, View.OnClickListener onClick) {
        Intrinsics.checkNotNullParameter(queryKey, "queryKey");
        Intrinsics.checkNotNullParameter(queryValue, "queryValue");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        String str = queryKey + '=' + queryValue;
        try {
            Result.Companion companion = Result.Companion;
            SpannableStringBuilder markdown = getMarkdown();
            Object[] spans = markdown.getSpans(0, markdown.length(), CustomLinkSpan.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
            for (Object obj : spans) {
                CustomLinkSpan customLinkSpan = (CustomLinkSpan) obj;
                String link = customLinkSpan.getLink();
                Intrinsics.checkNotNullExpressionValue(link, "span.link");
                if (StringsKt.lastIndexOf$default(link, str, 0, false, 6, (Object) null) >= 0) {
                    callback.invoke();
                    customLinkSpan.setClickListener(onClick);
                }
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void setCodeCopySpanClickListener(View view, CodeCopySpanClickListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        clearCodeCopySpanClickListener(view);
        if (listener != null) {
            CodeCopyInfoSpan[] codeCopyInfoSpanArr = (CodeCopyInfoSpan[]) getMarkdown().getSpans(0, getMarkdown().length(), CodeCopyInfoSpan.class);
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(codeCopyInfoSpanArr, "copyInfoSpans");
            for (CodeCopyInfoSpan codeCopyInfoSpan : codeCopyInfoSpanArr) {
                int spanStart = getMarkdown().getSpanStart(codeCopyInfoSpan);
                int spanEnd = getMarkdown().getSpanEnd(codeCopyInfoSpan);
                int spanFlags = getMarkdown().getSpanFlags(codeCopyInfoSpan);
                Intrinsics.checkNotNullExpressionValue(codeCopyInfoSpan, "span");
                CodeCopyClickSpan codeCopyClickSpan = new CodeCopyClickSpan(this, codeCopyInfoSpan, listener);
                arrayList.add(codeCopyClickSpan);
                getMarkdown().setSpan(codeCopyClickSpan, spanStart, spanEnd, spanFlags);
            }
            this.viewCodeCopyClickSpanMap.put(view, arrayList);
        }
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void clearCodeCopySpanClickListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        List<CodeCopyClickSpan> remove = this.viewCodeCopyClickSpanMap.remove(view);
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                getMarkdown().removeSpan((CodeCopyClickSpan) it.next());
            }
        }
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void setCustomCitationSpansListener(View view, final CitationSpanClickListener listener) {
        Object obj;
        Throwable cause;
        String message;
        IMarkdownEnsureManager markdownEnsureManagerDelegate;
        Intrinsics.checkNotNullParameter(view, "view");
        clearCustomCitationSpansListener(view);
        try {
            Result.Companion companion = Result.Companion;
            Object[] spans = getMarkdown().getSpans(0, getMarkdown().length(), TableRowSpan2.class);
            Intrinsics.checkNotNullExpressionValue(spans, "markdown.getSpans(0, mar…ableRowSpan2::class.java)");
            for (Object obj2 : spans) {
                ((TableRowSpan2) obj2).setSpansInTable(CustomCitationSpan.class, new Function1<CustomCitationSpan, CustomCitationClickSpan>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$setCustomCitationSpansListener$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public final CustomCitationClickSpan invoke(CustomCitationSpan customCitationSpan) {
                        Intrinsics.checkNotNullParameter(customCitationSpan, "it");
                        return new CustomCitationClickSpan(customCitationSpan, CitationSpanClickListener.this);
                    }
                });
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null && (cause = th2.getCause()) != null && (message = th2.getMessage()) != null && (markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate()) != null) {
            markdownEnsureManagerDelegate.ensureNotReachHere(cause, message);
        }
        CustomCitationSpan[] customCitationSpanArr = (CustomCitationSpan[]) getMarkdown().getSpans(0, getMarkdown().length(), CustomCitationSpan.class);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(customCitationSpanArr, "customCitationSpans");
        for (CustomCitationSpan customCitationSpan : customCitationSpanArr) {
            int spanStart = getMarkdown().getSpanStart(customCitationSpan);
            int spanEnd = getMarkdown().getSpanEnd(customCitationSpan);
            int spanFlags = getMarkdown().getSpanFlags(customCitationSpan);
            Intrinsics.checkNotNullExpressionValue(customCitationSpan, "span");
            CustomCitationClickSpan customCitationClickSpan = new CustomCitationClickSpan(customCitationSpan, listener);
            arrayList.add(customCitationClickSpan);
            getMarkdown().setSpan(customCitationClickSpan, spanStart, spanEnd, spanFlags);
        }
        this.customCitationClickSpanMap.put(view, arrayList);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void clearCustomCitationSpansListener(View view) {
        Object obj;
        Throwable cause;
        String message;
        IMarkdownEnsureManager markdownEnsureManagerDelegate;
        Intrinsics.checkNotNullParameter(view, "view");
        List<CustomCitationClickSpan> remove = this.customCitationClickSpanMap.remove(view);
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                getMarkdown().removeSpan((CustomCitationClickSpan) it.next());
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            Object[] spans = getMarkdown().getSpans(0, getMarkdown().length(), TableRowSpan2.class);
            Intrinsics.checkNotNullExpressionValue(spans, "markdown.getSpans(0, mar…ableRowSpan2::class.java)");
            for (Object obj2 : spans) {
                ((TableRowSpan2) obj2).clearSpansInTable(CustomCitationClickSpan.class);
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 == null || (cause = th2.getCause()) == null || (message = th2.getMessage()) == null || (markdownEnsureManagerDelegate = IMarkdownEnsureManagerKt.getMarkdownEnsureManagerDelegate()) == null) {
            return;
        }
        markdownEnsureManagerDelegate.ensureNotReachHere(cause, message);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public List<ICodeCopyInfoSpan> getCopyInfoSpans() {
        SpannableStringBuilder markdown = getMarkdown();
        Object[] spans = markdown.getSpans(0, markdown.length(), ICodeCopyInfoSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        return ArraysKt.toList(spans);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public List<ICustomCitationSpan> getCustomCitationSpans() {
        SpannableStringBuilder markdown = getMarkdown();
        Object[] spans = markdown.getSpans(0, markdown.length(), ICustomCitationSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        return ArraysKt.toList(spans);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public List<AsyncDrawableSpan> getFormulaSpans() {
        SpannableStringBuilder markdown = getMarkdown();
        Object[] spans = markdown.getSpans(0, markdown.length(), AsyncDrawableSpan.class);
        Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        return ArraysKt.toList(spans);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void setFullScreenDetailSpanClickListener(View view, FullScreenDetailSpanClickListener listener) {
        Intrinsics.checkNotNullParameter(view, "view");
        clearFullScreenDetailSpanClickListener(view);
        if (listener == null) {
            return;
        }
        FullScreenDetailInfoSpan[] fullScreenDetailInfoSpanArr = (FullScreenDetailInfoSpan[]) getMarkdown().getSpans(0, getMarkdown().length(), FullScreenDetailInfoSpan.class);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(fullScreenDetailInfoSpanArr, "infoSpans");
        for (FullScreenDetailInfoSpan fullScreenDetailInfoSpan : fullScreenDetailInfoSpanArr) {
            int spanStart = getMarkdown().getSpanStart(fullScreenDetailInfoSpan);
            int spanEnd = getMarkdown().getSpanEnd(fullScreenDetailInfoSpan);
            int spanFlags = getMarkdown().getSpanFlags(fullScreenDetailInfoSpan);
            Intrinsics.checkNotNullExpressionValue(fullScreenDetailInfoSpan, "span");
            FullScreenDetailClickSpan fullScreenDetailClickSpan = new FullScreenDetailClickSpan(this, fullScreenDetailInfoSpan, listener);
            arrayList.add(fullScreenDetailClickSpan);
            getMarkdown().setSpan(fullScreenDetailClickSpan, spanStart, spanEnd, spanFlags);
        }
        this.fullScreenDetailClickSpanMap.put(view, arrayList);
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public void clearFullScreenDetailSpanClickListener(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        List<FullScreenDetailClickSpan> remove = this.fullScreenDetailClickSpanMap.remove(view);
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                getMarkdown().removeSpan((FullScreenDetailClickSpan) it.next());
            }
        }
    }

    @Override // com.larus.business.markdown.api.model.MarkdownContent
    public List<String> getImageUrls() {
        return (List) this.imageUrls.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void appendSpannedIndex(List<SpannedIndex> spanIndexList, Class<T> clazz) {
        Object[] spans = getMarkdown().getSpans(0, getMarkdown().length(), clazz);
        Intrinsics.checkNotNullExpressionValue(spans, "spans");
        int length = spans.length;
        for (int i = 0; i < length; i++) {
            int spanStart = getMarkdown().getSpanStart(spans[i]);
            int spanEnd = getMarkdown().getSpanEnd(spans[i]);
            if ((spanStart >= 0 && spanStart <= spanEnd) && spanEnd <= getMarkdown().length()) {
                Object obj = spans[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Any");
                spanIndexList.add(new SpannedIndex(obj, spanStart, spanEnd));
            }
        }
    }

    /* compiled from: MarkwonContent.kt */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0017H\u0007Jx\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eJ`\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00172\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eH\u0007JR\u0010!\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eJ\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010#\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010$\u001a\u00020%2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ)\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\u0006\u0010\b\u001a\u00020\t2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)H\u0002¢\u0006\u0002\u0010*J \u0010+\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010+\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020-H\u0002J \u00100\u001a\u00020\u000f\"\u0004\b\u0000\u0010'*\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H'03H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/MarkwonContent$Companion;", "", "()V", "locker", "create", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "context", "Landroid/content/Context;", "markdownConfigManager", "Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;", "maxContentWidth", "", "content", "", "finished", "", "customMarkDownInfo", "Lcom/larus/business/markdown/api/model/CustomMarkDownInfo;", "markwonStructCache", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "reuseCharSequence", "", "payload", "", "markdownTextView", "Lcom/larus/business/markdown/api/view/text/IMarkdownTextView;", "createFromNode", "node", "Lorg/commonmark/node/Node;", "callBack", "Lkotlin/Function1;", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "", "createNode", "optLatexInLineContent", "optimizeContent", "raw", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "synchronizedHandle", "T", "execute", "Lkotlin/Function0;", "(Lcom/larus/business/markdown/impl/common/MarkdownConfigManager;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "updateImageSize", "imageSize", "Landroid/graphics/Rect;", "textView", "Landroid/widget/TextView;", "hasSpanned", "Landroid/text/Spanned;", "clazz", "Ljava/lang/Class;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final <T> T synchronizedHandle(MarkdownConfigManager markdownConfigManager, Function0<? extends T> execute) {
            T t;
            if (!markdownConfigManager.getSettings().removeSynchronized()) {
                synchronized (MarkwonContent.locker) {
                    t = (T) execute.invoke();
                }
                return t;
            }
            return (T) execute.invoke();
        }

        public final MarkdownContent raw(MarkdownConfigManager markdownConfigManager, String content) {
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(content, "content");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            Node node = null;
            Application application = MarkdownService.INSTANCE.getApplication();
            return new MarkwonContent(spannableStringBuilder, z, z2, z3, node, application != null ? MarkwonExtKt.createMarkwonStruct$default(application, markdownConfigManager, null, new CustomMarkDownInfo(MarkdownUnitExtKt.dp2px((Number) 12), null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, -2, 31, null), null, 2, null) : null, null, null, false, 464, null);
        }

        @Deprecated(message = "尽量使用不包含TextView的同名类")
        public final MarkwonContent create(final MarkdownConfigManager markdownConfigManager, final IMarkdownTextView markdownTextView, final String content, final boolean finished, final CustomMarkDownInfo customMarkDownInfo, final Map<String, ? extends Object> payload) {
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
            return (MarkwonContent) synchronizedHandle(markdownConfigManager, new Function0<MarkwonContent>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$create$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MarkwonContent m2872invoke() {
                    Application application;
                    MarkwonStruct createStreamMarkwonStruct;
                    String optimizeContent;
                    boolean hasSpanned;
                    boolean hasSpanned2;
                    TextView asTextView;
                    IMarkdownTextView iMarkdownTextView = IMarkdownTextView.this;
                    Integer num = null;
                    TextView asTextView2 = iMarkdownTextView != null ? iMarkdownTextView.asTextView() : null;
                    if (asTextView2 == null || (application = asTextView2.getContext()) == null) {
                        Application application2 = MarkdownService.INSTANCE.getApplication();
                        if (application2 == null) {
                            MarkdownContent raw = MarkwonContent.INSTANCE.raw(markdownConfigManager, content);
                            Intrinsics.checkNotNull(raw, "null cannot be cast to non-null type com.larus.business.markdown.impl.markwon.MarkwonContent");
                            return (MarkwonContent) raw;
                        }
                        application = application2;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    IMarkdownTextView iMarkdownTextView2 = IMarkdownTextView.this;
                    if (iMarkdownTextView2 != null && (asTextView = iMarkdownTextView2.asTextView()) != null) {
                        num = Integer.valueOf((IMarkdownTextView.this.getMarkdownWidth() - asTextView.getPaddingStart()) - asTextView.getPaddingEnd());
                    }
                    if (finished) {
                        createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(application, markdownConfigManager, num, customMarkDownInfo, payload);
                    } else {
                        createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(application, markdownConfigManager, num, customMarkDownInfo, payload);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    CustomHtmlPlugin.Companion.setSHasHtml(false);
                    MarkwonContent.INSTANCE.updateImageSize(asTextView2, markdownConfigManager.getImageSize());
                    optimizeContent = MarkwonContent.INSTANCE.optimizeContent(content, finished, markdownConfigManager);
                    if (markdownConfigManager.getAstModifier().getLatexOptEnable() && !finished) {
                        optimizeContent = MarkwonContent.INSTANCE.optLatexInLineContent(optimizeContent);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Node parse = createStreamMarkwonStruct.getMarkwon().parse(optimizeContent, finished);
                    Intrinsics.checkNotNullExpressionValue(parse, "lmd.markwon.parse(optLatexInLineContent, finished)");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (!finished) {
                        markdownConfigManager.getAstModifier().modifyLastNode(parse);
                    }
                    long currentTimeMillis5 = System.currentTimeMillis();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Spanned render = createStreamMarkwonStruct.getMarkwon().render(parse, asTextView2, new RenderCallback() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$create$1$markdownSpan$1
                        @Override // io.noties.markwon.RenderCallback
                        public void handle(HashMap<String, Integer> nodeInfo) {
                            objectRef.element = nodeInfo;
                        }
                    });
                    Intrinsics.checkNotNull(render, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) render;
                    long currentTimeMillis6 = System.currentTimeMillis();
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    hasSpanned = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, TableSpan.class);
                    boolean sHasHtml = CustomHtmlPlugin.Companion.getSHasHtml();
                    hasSpanned2 = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, CodeBlockSpan.class);
                    return new MarkwonContent(spannableStringBuilder, hasSpanned, sHasHtml, hasSpanned2, parse, createStreamMarkwonStruct, new MarkwonPerformance(Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis4 - currentTimeMillis3), Long.valueOf(currentTimeMillis6 - currentTimeMillis5)), (HashMap) objectRef.element, finished);
                }
            });
        }

        public final MarkwonContent create(final Context context, final MarkdownConfigManager markdownConfigManager, final int maxContentWidth, final String content, final boolean finished, final CustomMarkDownInfo customMarkDownInfo, final IMarkwonStruct markwonStructCache, final CharSequence reuseCharSequence, final Map<String, ? extends Object> payload) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
            return (MarkwonContent) synchronizedHandle(markdownConfigManager, new Function0<MarkwonContent>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$create$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MarkwonContent m2873invoke() {
                    String optimizeContent;
                    boolean hasSpanned;
                    boolean hasSpanned2;
                    MarkwonStruct createStreamMarkwonStruct;
                    long currentTimeMillis = System.currentTimeMillis();
                    MarkwonStruct markwonStruct = IMarkwonStruct.this;
                    if (markwonStruct == null) {
                        if (finished) {
                            createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(context, markdownConfigManager, Integer.valueOf(maxContentWidth), customMarkDownInfo, payload);
                        } else {
                            createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(context, markdownConfigManager, Integer.valueOf(maxContentWidth), customMarkDownInfo, payload);
                        }
                        markwonStruct = createStreamMarkwonStruct;
                    }
                    IMarkwonStruct iMarkwonStruct = markwonStruct;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    CustomHtmlPlugin.Companion.setSHasHtml(false);
                    MarkwonContent.INSTANCE.updateImageSize(context, maxContentWidth, markdownConfigManager.getImageSize());
                    optimizeContent = MarkwonContent.INSTANCE.optimizeContent(content, finished, markdownConfigManager);
                    if (markdownConfigManager.getAstModifier().getLatexOptEnable() && !finished) {
                        optimizeContent = MarkwonContent.INSTANCE.optLatexInLineContent(optimizeContent);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Node parse = iMarkwonStruct.getMarkwon().parse(optimizeContent, finished);
                    Intrinsics.checkNotNullExpressionValue(parse, "lmd.markwon.parse(optLatexInLineContent, finished)");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (!finished) {
                        markdownConfigManager.getAstModifier().modifyLastNode(parse);
                    }
                    long currentTimeMillis5 = System.currentTimeMillis();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Spanned render = iMarkwonStruct.getMarkwon().render(parse, reuseCharSequence, new RenderCallback() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$create$2$markdownSpan$1
                        @Override // io.noties.markwon.RenderCallback
                        public void handle(HashMap<String, Integer> nodeInfo) {
                            objectRef.element = nodeInfo;
                        }
                    });
                    Intrinsics.checkNotNull(render, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) render;
                    long currentTimeMillis6 = System.currentTimeMillis();
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    hasSpanned = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, TableSpan.class);
                    boolean sHasHtml = CustomHtmlPlugin.Companion.getSHasHtml();
                    hasSpanned2 = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, CodeBlockSpan.class);
                    return new MarkwonContent(spannableStringBuilder, hasSpanned, sHasHtml, hasSpanned2, parse, iMarkwonStruct, new MarkwonPerformance(Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis4 - currentTimeMillis3), Long.valueOf(currentTimeMillis6 - currentTimeMillis5)), (HashMap) objectRef.element, finished);
                }
            });
        }

        public final Node createNode(final Context context, final MarkdownConfigManager markdownConfigManager, final String content, final boolean finished, final CustomMarkDownInfo customMarkDownInfo, final IMarkwonStruct markwonStructCache, final Function1<? super MarkwonPerformance, Unit> callBack) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(content, "content");
            return (Node) synchronizedHandle(markdownConfigManager, new Function0<Node>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$createNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public final Node invoke() {
                    String optimizeContent;
                    MarkwonStruct createStreamMarkwonStruct;
                    long currentTimeMillis = System.currentTimeMillis();
                    MarkwonStruct markwonStruct = IMarkwonStruct.this;
                    if (markwonStruct == null) {
                        if (finished) {
                            Context context2 = context;
                            MarkdownConfigManager markdownConfigManager2 = markdownConfigManager;
                            CustomMarkDownInfo customMarkDownInfo2 = customMarkDownInfo;
                            if (customMarkDownInfo2 == null) {
                                customMarkDownInfo2 = new CustomMarkDownInfo(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, -1, 31, null);
                            }
                            createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(context2, markdownConfigManager2, null, customMarkDownInfo2, null);
                        } else {
                            Context context3 = context;
                            MarkdownConfigManager markdownConfigManager3 = markdownConfigManager;
                            CustomMarkDownInfo customMarkDownInfo3 = customMarkDownInfo;
                            if (customMarkDownInfo3 == null) {
                                customMarkDownInfo3 = new CustomMarkDownInfo(0, null, null, null, false, false, null, 0, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, false, -1, 31, null);
                            }
                            createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(context3, markdownConfigManager3, null, customMarkDownInfo3, null);
                        }
                        markwonStruct = createStreamMarkwonStruct;
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    optimizeContent = MarkwonContent.INSTANCE.optimizeContent(content, finished, markdownConfigManager);
                    if (markdownConfigManager.getAstModifier().getLatexOptEnable() && !finished) {
                        optimizeContent = MarkwonContent.INSTANCE.optLatexInLineContent(optimizeContent);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Node parse = markwonStruct.getMarkwon().parse(optimizeContent, finished);
                    Intrinsics.checkNotNullExpressionValue(parse, "lmd.markwon.parse(optLatexInLineContent, finished)");
                    long currentTimeMillis4 = System.currentTimeMillis();
                    if (!finished) {
                        markdownConfigManager.getAstModifier().modifyLastNode(parse);
                    }
                    Function1<MarkwonPerformance, Unit> function1 = callBack;
                    if (function1 != null) {
                        function1.invoke(new MarkwonPerformance(Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis4 - currentTimeMillis3), null, 4, null));
                    }
                    return parse;
                }
            });
        }

        @Deprecated(message = "尽量使用不包含TextView的同名类")
        public final MarkwonContent createFromNode(final MarkdownConfigManager markdownConfigManager, final IMarkdownTextView markdownTextView, final Node node, final boolean finished, final CustomMarkDownInfo customMarkDownInfo, final Map<String, ? extends Object> payload, final Function1<? super MarkwonPerformance, Unit> callBack) {
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
            return (MarkwonContent) synchronizedHandle(markdownConfigManager, new Function0<MarkwonContent>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$createFromNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MarkwonContent m2874invoke() {
                    Application application;
                    MarkwonStruct createStreamMarkwonStruct;
                    boolean hasSpanned;
                    boolean hasSpanned2;
                    TextView asTextView;
                    IMarkdownTextView iMarkdownTextView = IMarkdownTextView.this;
                    Integer num = null;
                    TextView asTextView2 = iMarkdownTextView != null ? iMarkdownTextView.asTextView() : null;
                    if (asTextView2 == null || (application = asTextView2.getContext()) == null) {
                        Application application2 = MarkdownService.INSTANCE.getApplication();
                        if (application2 == null) {
                            MarkdownContent raw = MarkwonContent.INSTANCE.raw(markdownConfigManager, "");
                            Intrinsics.checkNotNull(raw, "null cannot be cast to non-null type com.larus.business.markdown.impl.markwon.MarkwonContent");
                            return (MarkwonContent) raw;
                        }
                        application = application2;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    IMarkdownTextView iMarkdownTextView2 = IMarkdownTextView.this;
                    if (iMarkdownTextView2 != null && (asTextView = iMarkdownTextView2.asTextView()) != null) {
                        num = Integer.valueOf((IMarkdownTextView.this.getMarkdownWidth() - asTextView.getPaddingStart()) - asTextView.getPaddingEnd());
                    }
                    if (finished) {
                        createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(application, markdownConfigManager, num, customMarkDownInfo, payload);
                    } else {
                        createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(application, markdownConfigManager, num, customMarkDownInfo, payload);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    CustomHtmlPlugin.Companion.setSHasHtml(false);
                    MarkwonContent.INSTANCE.updateImageSize(asTextView2, markdownConfigManager.getImageSize());
                    if (!finished) {
                        markdownConfigManager.getAstModifier().modifyLastNode(node);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Spanned render = createStreamMarkwonStruct.getMarkwon().render(node, asTextView2, new RenderCallback() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$createFromNode$1$markdownSpan$1
                        @Override // io.noties.markwon.RenderCallback
                        public void handle(HashMap<String, Integer> nodeInfo) {
                            objectRef.element = nodeInfo;
                        }
                    });
                    Intrinsics.checkNotNull(render, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) render;
                    long currentTimeMillis4 = System.currentTimeMillis();
                    Function1<MarkwonPerformance, Unit> function1 = callBack;
                    if (function1 != null) {
                        function1.invoke(new MarkwonPerformance(Long.valueOf(currentTimeMillis2 - currentTimeMillis), null, Long.valueOf(currentTimeMillis4 - currentTimeMillis3), 2, null));
                    }
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    hasSpanned = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, TableSpan.class);
                    boolean sHasHtml = CustomHtmlPlugin.Companion.getSHasHtml();
                    hasSpanned2 = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, CodeBlockSpan.class);
                    return new MarkwonContent(spannableStringBuilder, hasSpanned, sHasHtml, hasSpanned2, node, createStreamMarkwonStruct, null, (HashMap) objectRef.element, finished);
                }
            });
        }

        public final MarkwonContent createFromNode(final Context context, final MarkdownConfigManager markdownConfigManager, final int maxContentWidth, final Node node, final boolean finished, final CustomMarkDownInfo customMarkDownInfo, final CharSequence reuseCharSequence, final Map<String, ? extends Object> payload, final IMarkwonStruct markwonStructCache, final Function1<? super MarkwonPerformance, Unit> callBack) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(markdownConfigManager, "markdownConfigManager");
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(customMarkDownInfo, "customMarkDownInfo");
            return (MarkwonContent) synchronizedHandle(markdownConfigManager, new Function0<MarkwonContent>() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$createFromNode$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MarkwonContent m2875invoke() {
                    boolean hasSpanned;
                    boolean hasSpanned2;
                    MarkwonStruct createStreamMarkwonStruct;
                    long currentTimeMillis = System.currentTimeMillis();
                    MarkwonStruct markwonStruct = IMarkwonStruct.this;
                    if (markwonStruct == null) {
                        if (finished) {
                            createStreamMarkwonStruct = MarkwonExtKt.createMarkwonStruct(context, markdownConfigManager, Integer.valueOf(maxContentWidth), customMarkDownInfo, payload);
                        } else {
                            createStreamMarkwonStruct = MarkwonExtKt.createStreamMarkwonStruct(context, markdownConfigManager, Integer.valueOf(maxContentWidth), customMarkDownInfo, payload);
                        }
                        markwonStruct = createStreamMarkwonStruct;
                    }
                    IMarkwonStruct iMarkwonStruct = markwonStruct;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    CustomHtmlPlugin.Companion.setSHasHtml(false);
                    MarkwonContent.INSTANCE.updateImageSize(context, maxContentWidth, markdownConfigManager.getImageSize());
                    if (!finished) {
                        markdownConfigManager.getAstModifier().modifyLastNode(node);
                    }
                    long currentTimeMillis3 = System.currentTimeMillis();
                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Spanned render = iMarkwonStruct.getMarkwon().render(node, reuseCharSequence, new RenderCallback() { // from class: com.larus.business.markdown.impl.markwon.MarkwonContent$Companion$createFromNode$2$markdownSpan$1
                        @Override // io.noties.markwon.RenderCallback
                        public void handle(HashMap<String, Integer> nodeInfo) {
                            objectRef.element = nodeInfo;
                        }
                    });
                    Intrinsics.checkNotNull(render, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) render;
                    long currentTimeMillis4 = System.currentTimeMillis();
                    Function1<MarkwonPerformance, Unit> function1 = callBack;
                    if (function1 != null) {
                        function1.invoke(new MarkwonPerformance(Long.valueOf(currentTimeMillis2 - currentTimeMillis), null, Long.valueOf(currentTimeMillis4 - currentTimeMillis3), 2, null));
                    }
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    hasSpanned = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, TableSpan.class);
                    boolean sHasHtml = CustomHtmlPlugin.Companion.getSHasHtml();
                    hasSpanned2 = MarkwonContent.INSTANCE.hasSpanned(spannableStringBuilder2, CodeBlockSpan.class);
                    return new MarkwonContent(spannableStringBuilder, hasSpanned, sHasHtml, hasSpanned2, node, iMarkwonStruct, null, (HashMap) objectRef.element, finished);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String optLatexInLineContent(String content) {
            String str;
            String str2 = content;
            if (StringsKt.endsWith$default(str2, '\\', false, 2, (Object) null)) {
                int length = content.length() - 1;
                if (content == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring = content.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                str = substring;
            } else {
                str = content;
            }
            int lastIndexOf$default = StringsKt.lastIndexOf$default(str2, "\\(", 0, false, 6, (Object) null);
            int lastIndexOf$default2 = StringsKt.lastIndexOf$default(str2, ")", 0, false, 6, (Object) null);
            int lastIndexOf$default3 = StringsKt.lastIndexOf$default(str2, "\\[", 0, false, 6, (Object) null);
            int lastIndexOf$default4 = StringsKt.lastIndexOf$default(str2, "]", 0, false, 6, (Object) null);
            if (lastIndexOf$default2 < lastIndexOf$default) {
                if (content == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = content.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring2;
            }
            if (lastIndexOf$default4 >= lastIndexOf$default3) {
                return str;
            }
            if (content == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring3 = content.substring(0, lastIndexOf$default3);
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String optimizeContent(String content, boolean finished, MarkdownConfigManager markdownConfigManager) {
            String substring;
            if (StringsKt.endsWith$default(content, "\n", false, 2, (Object) null) || StringsKt.endsWith$default(content, "\r", false, 2, (Object) null)) {
                int length = content.length() - 1;
                if (content == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                substring = content.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else if (StringsKt.endsWith$default(content, "\r\n", false, 2, (Object) null)) {
                int length2 = content.length() - 2;
                if (content == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                substring = content.substring(0, length2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                substring = content;
            }
            if (!markdownConfigManager.getSettings().isMarkdownStringStreamOptimized() || finished) {
                return substring;
            }
            StringBuilder sb = new StringBuilder(content);
            StreamOptimizeUtils.INSTANCE.tryCompleteLink(sb);
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "{\n                val op….toString()\n            }");
            return sb2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void updateImageSize(TextView textView, Rect imageSize) {
            int maxWidth;
            if (textView == 0) {
                return;
            }
            if (textView instanceof IMarkdownTextView) {
                maxWidth = ((IMarkdownTextView) textView).getMarkdownWidth();
            } else {
                maxWidth = textView.getMaxWidth();
            }
            if (maxWidth <= 0 || maxWidth == Integer.MAX_VALUE) {
                maxWidth = textView.getWidth();
            }
            int max = Math.max(0, (maxWidth - textView.getPaddingStart()) - textView.getPaddingEnd());
            imageSize.set(0, 0, max, (max * 2) / 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateImageSize(Context context, int maxContentWidth, Rect imageSize) {
            if (maxContentWidth <= 0 || maxContentWidth == Integer.MAX_VALUE) {
                maxContentWidth = context.getResources().getDisplayMetrics().widthPixels;
            }
            imageSize.set(0, 0, maxContentWidth, (maxContentWidth * 2) / 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final <T> boolean hasSpanned(Spanned spanned, Class<T> cls) {
            Object[] spans = spanned.getSpans(0, spanned.length(), cls);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, clazz)");
            return !(spans.length == 0);
        }
    }
}
