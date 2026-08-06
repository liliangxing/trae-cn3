package com.bytedance.trae.conversation.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: InputTagProtectWatcher.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J*\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015*\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/widget/InputTagProtectWatcher;", "Landroid/text/TextWatcher;", "editText", "Landroid/widget/EditText;", "<init>", "(Landroid/widget/EditText;)V", "isProcessing", "", "beforeTextChanged", "", "s", "", "start", "", "count", "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "getTagSpans", "", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputTagProtectWatcher implements TextWatcher {
    private final EditText editText;
    private boolean isProcessing;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public InputTagProtectWatcher(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.editText = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s) {
        if (this.isProcessing || s == null) {
            return;
        }
        Object obj = this.editText;
        if ((obj instanceof TranscriptEditText) && ((TranscriptEditText) obj).getIsInternalUpdate()) {
            return;
        }
        List<Object> tagSpans = getTagSpans(s);
        if (tagSpans.isEmpty()) {
            return;
        }
        for (Object obj2 : tagSpans) {
            int spanStart = s.getSpanStart(obj2);
            int spanEnd = s.getSpanEnd(obj2);
            if (spanStart < 0 || spanEnd < 0 || spanEnd <= spanStart) {
                this.isProcessing = true;
                s.removeSpan(obj2);
                if (spanStart >= 0 && spanEnd >= 0) {
                    s.delete(RangesKt.coerceAtMost(spanStart, s.length()), RangesKt.coerceAtMost(spanEnd, s.length()));
                }
                this.isProcessing = false;
            }
        }
        int selectionStart = this.editText.getSelectionStart();
        for (Object obj3 : getTagSpans(s)) {
            int spanStart2 = s.getSpanStart(obj3);
            int spanEnd2 = s.getSpanEnd(obj3);
            if (spanStart2 + 1 <= selectionStart && selectionStart < spanEnd2) {
                this.editText.setSelection(spanEnd2);
                return;
            }
        }
    }

    private final List<Object> getTagSpans(final Editable editable) {
        List createListBuilder = CollectionsKt.createListBuilder();
        List list = createListBuilder;
        Object[] spans = editable.getSpans(0, editable.length(), SkillTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        CollectionsKt.addAll(list, spans);
        Object[] spans2 = editable.getSpans(0, editable.length(), PluginTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
        CollectionsKt.addAll(list, spans2);
        return CollectionsKt.sortedWith(CollectionsKt.build(createListBuilder), new Comparator() { // from class: com.bytedance.trae.conversation.widget.InputTagProtectWatcher$getTagSpans$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(editable.getSpanStart(t)), Integer.valueOf(editable.getSpanStart(t2)));
            }
        });
    }
}
