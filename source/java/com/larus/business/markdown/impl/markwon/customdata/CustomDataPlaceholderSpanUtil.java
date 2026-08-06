package com.larus.business.markdown.impl.markwon.customdata;

import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.spans.OrderedListItemSpan2;
import io.noties.markwon.html.tag.ImageGridHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDataPlaceholderSpanUtil.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/customdata/CustomDataPlaceholderSpanUtil;", "", "()V", "isLeadingMarginSame", "", "currentSpanned", "Landroid/text/Spanned;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", ImageGridHandler.Index, "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataPlaceholderSpanUtil {
    public static final CustomDataPlaceholderSpanUtil INSTANCE = new CustomDataPlaceholderSpanUtil();

    private CustomDataPlaceholderSpanUtil() {
    }

    public final boolean isLeadingMarginSame(Spanned currentSpanned, MarkwonVisitor visitor, int index) {
        Intrinsics.checkNotNullParameter(currentSpanned, "currentSpanned");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Object[] spans = currentSpanned.getSpans(0, index, LeadingMarginSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "currentSpanned.getSpans(…ngMarginSpan::class.java)");
        ArrayList<LeadingMarginSpan> arrayList = new ArrayList();
        int length = spans.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Object obj = spans[i];
            LeadingMarginSpan leadingMarginSpan = (LeadingMarginSpan) obj;
            if (currentSpanned.getSpanStart(leadingMarginSpan) <= index && index <= currentSpanned.getSpanEnd(leadingMarginSpan)) {
                arrayList.add(obj);
            }
            i++;
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (LeadingMarginSpan leadingMarginSpan2 : arrayList) {
            if (leadingMarginSpan2 instanceof OrderedListItemSpan2) {
                hashSet.add(((OrderedListItemSpan2) leadingMarginSpan2).orderNumber);
            } else {
                i2 += leadingMarginSpan2.getLeadingMargin(false);
            }
        }
        List<SpannableBuilder.Span> spans2 = visitor.builder().getSpans(0, index);
        Intrinsics.checkNotNullExpressionValue(spans2, "visitor.builder().getSpans(0, index)");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : spans2) {
            SpannableBuilder.Span span = (SpannableBuilder.Span) obj2;
            if (span.start < index && index < span.end && (span.what instanceof LeadingMarginSpan)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList<LeadingMarginSpan> arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            Object obj3 = ((SpannableBuilder.Span) it.next()).what;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.text.style.LeadingMarginSpan");
            arrayList4.add((LeadingMarginSpan) obj3);
        }
        HashSet hashSet2 = new HashSet();
        int i3 = 0;
        for (LeadingMarginSpan leadingMarginSpan3 : arrayList4) {
            if (leadingMarginSpan3 instanceof OrderedListItemSpan2) {
                hashSet2.add(((OrderedListItemSpan2) leadingMarginSpan3).orderNumber);
            } else {
                i3 += leadingMarginSpan3.getLeadingMargin(false);
            }
        }
        return i2 == i3 && Intrinsics.areEqual(hashSet, hashSet2);
    }
}
