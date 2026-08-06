package io.noties.markwon.core.factory;

import com.larus.business.markdown.api.model.BlockQuoteConfig;
import com.larus.business.markdown.api.model.ListStyle;
import com.larus.business.markdown.api.model.OrderedSymbol;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.BulletListItemSpan2;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.OrderedListItemSpan2;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Node;

/* compiled from: ListItemSpanFactory2.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/core/factory/ListItemSpanFactory2;", "Lio/noties/markwon/core/factory/ListItemSpanFactory;", "listMarginInfo", "Lio/noties/markwon/core/spans/ListMarginInfo;", "listStyle", "Lcom/larus/business/markdown/api/model/ListStyle;", "(Lio/noties/markwon/core/spans/ListMarginInfo;Lcom/larus/business/markdown/api/model/ListStyle;)V", "getListItemLevel", "", "props", "Lio/noties/markwon/RenderProps;", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "blockQuoteConfig", "Lcom/larus/business/markdown/api/model/BlockQuoteConfig;", "node", "Lorg/commonmark/node/Node;", "getSymbolText", "", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "number", "intToAlphabet", "num", "intToRoman", "isNodeInQuote", "", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ListItemSpanFactory2 extends ListItemSpanFactory {
    private final ListMarginInfo listMarginInfo;
    private final ListStyle listStyle;
    private static final String[] mValues = {"", "M", "MM", "MMM"};
    private static final String[] cValues = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] xValues = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] iValues = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    /* compiled from: ListItemSpanFactory2.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderedSymbol.values().length];
            try {
                iArr[OrderedSymbol.DECIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OrderedSymbol.LOWERCASE_ALPHABET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OrderedSymbol.LOWERCASE_ROMAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListItemSpanFactory2() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ListItemSpanFactory2(ListMarginInfo listMarginInfo, ListStyle listStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : listMarginInfo, (i & 2) != 0 ? null : listStyle);
    }

    public ListItemSpanFactory2(ListMarginInfo listMarginInfo, ListStyle listStyle) {
        this.listMarginInfo = listMarginInfo;
        this.listStyle = listStyle;
    }

    @Override // io.noties.markwon.core.factory.ListItemSpanFactory, io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration configuration, RenderProps props) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        return getSpans(configuration, props, null, null);
    }

    public final Object getSpans(MarkwonConfiguration configuration, RenderProps props, BlockQuoteConfig blockQuoteConfig, Node node) {
        Integer orderedListItemColorInQuote;
        Integer bulletListItemColorInQuote;
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(props, "props");
        ListStyle listStyle = this.listStyle;
        int i = 0;
        if (listStyle == null) {
            listStyle = new ListStyle(null, false, 3, null);
        }
        int listItemExtraMargin = getListItemExtraMargin(configuration, props, this.listMarginInfo);
        Boolean require = CoreProps.LIST_ITEM_REAL_SELF.require(props);
        Intrinsics.checkNotNullExpressionValue(require, "LIST_ITEM_REAL_SELF.require(props)");
        boolean booleanValue = require.booleanValue();
        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(props)) {
            BulletListItemSpan2 bulletListItemSpan2 = new BulletListItemSpan2(configuration.theme(), this.listMarginInfo, getListItemLevel(props), listItemExtraMargin, booleanValue);
            bulletListItemSpan2.listSymbolStrategy = listStyle.getSymbolStrategy();
            if (isNodeInQuote(node)) {
                if (blockQuoteConfig != null && (bulletListItemColorInQuote = blockQuoteConfig.getBulletListItemColorInQuote()) != null) {
                    i = bulletListItemColorInQuote.intValue();
                }
                bulletListItemSpan2.setAdjustedListItemColor(i);
            }
            return bulletListItemSpan2;
        }
        OrderedSymbol orderedSymbol = listStyle.getSymbolStrategy().orderedSymbol(getListItemLevel(props));
        Integer require2 = CoreProps.ORDERED_LIST_ITEM_NUMBER.require(props);
        Intrinsics.checkNotNullExpressionValue(require2, "ORDERED_LIST_ITEM_NUMBER.require(props)");
        OrderedListItemSpan2 orderedListItemSpan2 = new OrderedListItemSpan2(configuration.theme(), this.listMarginInfo, getSymbolText(orderedSymbol, require2.intValue()), listItemExtraMargin, booleanValue);
        if (isNodeInQuote(node)) {
            if (blockQuoteConfig != null && (orderedListItemColorInQuote = blockQuoteConfig.getOrderedListItemColorInQuote()) != null) {
                i = orderedListItemColorInQuote.intValue();
            }
            orderedListItemSpan2.setAdjustedListItemColor(i);
        }
        return orderedListItemSpan2;
    }

    private final String getSymbolText(OrderedSymbol orderedSymbol, int number) {
        Object valueOf;
        int i = WhenMappings.$EnumSwitchMapping$0[orderedSymbol.ordinal()];
        if (i == 1) {
            valueOf = Integer.valueOf(number);
        } else if (i == 2) {
            valueOf = intToAlphabet(number);
        } else if (i == 3) {
            valueOf = intToRoman(number);
        } else {
            valueOf = Integer.valueOf(number);
        }
        return valueOf + ". ";
    }

    private final String intToAlphabet(int num) {
        StringBuilder sb = new StringBuilder();
        int max = Math.max(1, num);
        while (max > 0) {
            int i = max - 1;
            sb.insert(0, String.valueOf((char) ((i % 26) + 1 + 96)));
            max = i / 26;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    private final String intToRoman(int num) {
        if (num == 0) {
            return "";
        }
        String str = mValues[num / 1000] + cValues[(num % 1000) / 100] + xValues[(num % 100) / 10] + iValues[num % 10];
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    private final int getListItemLevel(RenderProps props) {
        Object obj = props.get(CoreProps.LIST_ITEM_REAL_LEVEL, -1);
        Intrinsics.checkNotNullExpressionValue(obj, "props.get(CoreProps.LIST_ITEM_REAL_LEVEL, -1)");
        int intValue = ((Number) obj).intValue();
        if (intValue != 0 && intValue != -1) {
            return intValue;
        }
        Integer require = CoreProps.BULLET_LIST_ITEM_LEVEL.require(props);
        Intrinsics.checkNotNullExpressionValue(require, "BULLET_LIST_ITEM_LEVEL.require(props)");
        return require.intValue();
    }

    private final boolean isNodeInQuote(Node node) {
        if (node == null) {
            return false;
        }
        if (node instanceof BlockQuote) {
            return true;
        }
        for (Node node2 = node.parent; node2 != null; node2 = node2.parent) {
            if (node2 instanceof BlockQuote) {
                return true;
            }
        }
        return false;
    }
}
