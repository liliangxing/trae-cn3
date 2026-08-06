package io.noties.markwon.ext.tables;

import android.text.style.ReplacementSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsTableRowSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016J(\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0010\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&J=\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0012\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH&¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\nH\u0014J\u0012\u0010\u0003\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J>\u0010\u0018\u001a\u00020\n\"\b\b\u0000\u0010\u0019*\u00020\f\"\b\b\u0001\u0010\u001a*\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lio/noties/markwon/ext/tables/AbsTableRowSpan;", "Landroid/text/style/ReplacementSpan;", "()V", "invalidator", "Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "getInvalidator", "()Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "setInvalidator", "(Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;)V", "clearSpansInTable", "", "Span", "", "span", "Ljava/lang/Class;", "findSpanInRow", "", "findSpanInTable", "", "x", "", "y", "(IILjava/lang/Class;)[Ljava/lang/Object;", "invalidateSelf", "setSpansInTable", "coveredSpan", "setSpan", "toCoveredSpan", "getToSetSpan", "Lkotlin/Function1;", "Invalidator", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public abstract class AbsTableRowSpan extends ReplacementSpan {
    private Invalidator invalidator;

    /* compiled from: AbsTableRowSpan.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lio/noties/markwon/ext/tables/AbsTableRowSpan$Invalidator;", "", "invalidate", "", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes7.dex */
    public interface Invalidator {
        void invalidate();
    }

    public <Span> void clearSpansInTable(Class<Span> span) {
        Intrinsics.checkParameterIsNotNull(span, "span");
    }

    public abstract <Span> List<Span> findSpanInRow(Class<Span> span);

    public abstract <Span> Span[] findSpanInTable(int x, int y, Class<Span> span);

    public <coveredSpan, setSpan> void setSpansInTable(Class<coveredSpan> toCoveredSpan, Function1<? super coveredSpan, ? extends setSpan> getToSetSpan) {
        Intrinsics.checkParameterIsNotNull(toCoveredSpan, "toCoveredSpan");
        Intrinsics.checkParameterIsNotNull(getToSetSpan, "getToSetSpan");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Invalidator getInvalidator() {
        return this.invalidator;
    }

    protected final void setInvalidator(Invalidator invalidator) {
        this.invalidator = invalidator;
    }

    public void invalidator(Invalidator invalidator) {
        this.invalidator = invalidator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidateSelf() {
        Invalidator invalidator = this.invalidator;
        if (invalidator != null) {
            invalidator.invalidate();
        }
    }
}
