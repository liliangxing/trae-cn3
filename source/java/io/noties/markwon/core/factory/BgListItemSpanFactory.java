package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.BgOrderedListItemSpan;
import io.noties.markwon.core.spans.OrderedListItemSpan2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BgListItemSpanFactory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/core/factory/BgListItemSpanFactory;", "Lio/noties/markwon/core/factory/ListItemSpanFactory;", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Ljava/lang/Float;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "props", "Lio/noties/markwon/RenderProps;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class BgListItemSpanFactory extends ListItemSpanFactory {
    private final Integer bgColor;
    private final Integer bgMargin;
    private final Float bgRadius;
    private final Integer leading;

    public BgListItemSpanFactory(Integer num, Integer num2, Float f, Integer num3) {
        this.bgColor = num;
        this.bgMargin = num2;
        this.bgRadius = f;
        this.leading = num3;
    }

    @Override // io.noties.markwon.core.factory.ListItemSpanFactory, io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(props)) {
            return super.getSpans(configuration, props);
        }
        if (this.bgColor != null && this.bgMargin != null) {
            String sb = new StringBuilder().append(CoreProps.ORDERED_LIST_ITEM_NUMBER.require(props).intValue()).append((char) 160).toString();
            MarkwonTheme theme = configuration.theme();
            Intrinsics.checkNotNullExpressionValue(theme, "configuration.theme()");
            return new BgOrderedListItemSpan(theme, sb, this.bgColor.intValue(), this.bgMargin.intValue(), this.bgRadius, this.leading);
        }
        return new OrderedListItemSpan2(configuration.theme(), null, CoreProps.ORDERED_LIST_ITEM_NUMBER.require(props).intValue() + ". ", 0, true);
    }
}
