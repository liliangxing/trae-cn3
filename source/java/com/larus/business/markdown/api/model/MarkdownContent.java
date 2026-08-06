package com.larus.business.markdown.api.model;

import android.text.SpannableStringBuilder;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.larus.business.markdown.api.FullScreenDetailSpanClickListener;
import io.noties.markwon.image.AsyncDrawableSpan;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.commonmark.node.Node;

/* compiled from: MarkdownContent.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J\u0010\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J.\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020'002\u0006\u00101\u001a\u000202H&J\u000e\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0003H&J\u000e\u00105\u001a\b\u0012\u0004\u0012\u0002060\u0003H&J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0003H&J\u001a\u00109\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010;H&J\u001a\u0010<\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010=H&J\u001a\u0010>\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010?H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR2\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006@"}, d2 = {"Lcom/larus/business/markdown/api/model/MarkdownContent;", "", "imageUrls", "", "", "getImageUrls", "()Ljava/util/List;", "isFinished", "", "()Z", "markdown", "Landroid/text/SpannableStringBuilder;", "getMarkdown", "()Landroid/text/SpannableStringBuilder;", "setMarkdown", "(Landroid/text/SpannableStringBuilder;)V", "markwonPerformance", "Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "getMarkwonPerformance", "()Lcom/larus/business/markdown/api/model/MarkwonPerformance;", "markwonStruct", "Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "getMarkwonStruct", "()Lcom/larus/business/markdown/api/model/IMarkwonStruct;", "node", "Lorg/commonmark/node/Node;", "getNode", "()Lorg/commonmark/node/Node;", "nodeInfo", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getNodeInfo", "()Ljava/util/HashMap;", "readText", "", "getReadText", "()Ljava/lang/CharSequence;", "clearCodeCopySpanClickListener", "", "view", "Landroid/view/View;", "clearCustomCitationSpansListener", "clearFullScreenDetailSpanClickListener", "findCustomLinkSpan", "queryKey", "queryValue", "callback", "Lkotlin/Function0;", "onClick", "Landroid/view/View$OnClickListener;", "getCopyInfoSpans", "Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;", "getCustomCitationSpans", "Lcom/larus/business/markdown/api/model/ICustomCitationSpan;", "getFormulaSpans", "Lio/noties/markwon/image/AsyncDrawableSpan;", "setCodeCopySpanClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;", "setCustomCitationSpansListener", "Lcom/larus/business/markdown/api/model/CitationSpanClickListener;", "setFullScreenDetailSpanClickListener", "Lcom/larus/business/markdown/api/FullScreenDetailSpanClickListener;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface MarkdownContent {
    void clearCodeCopySpanClickListener(View view);

    void clearCustomCitationSpansListener(View view);

    void clearFullScreenDetailSpanClickListener(View view);

    void findCustomLinkSpan(String queryKey, String queryValue, Function0<Unit> callback, View.OnClickListener onClick);

    List<ICodeCopyInfoSpan> getCopyInfoSpans();

    List<ICustomCitationSpan> getCustomCitationSpans();

    List<AsyncDrawableSpan> getFormulaSpans();

    List<String> getImageUrls();

    SpannableStringBuilder getMarkdown();

    MarkwonPerformance getMarkwonPerformance();

    IMarkwonStruct getMarkwonStruct();

    Node getNode();

    HashMap<String, Integer> getNodeInfo();

    CharSequence getReadText();

    /* renamed from: isFinished */
    boolean getIsFinished();

    void setCodeCopySpanClickListener(View view, CodeCopySpanClickListener listener);

    void setCustomCitationSpansListener(View view, CitationSpanClickListener listener);

    void setFullScreenDetailSpanClickListener(View view, FullScreenDetailSpanClickListener listener);

    void setMarkdown(SpannableStringBuilder spannableStringBuilder);
}
