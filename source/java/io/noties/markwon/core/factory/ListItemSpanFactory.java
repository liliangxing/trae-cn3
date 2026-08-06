package io.noties.markwon.core.factory;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.BulletListItemSpan;
import io.noties.markwon.core.spans.ListMarginInfo;
import io.noties.markwon.core.spans.OrderedListItemSpan;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ListItemSpanFactory implements SpanFactory {
    private final ListMarginInfo info;

    public ListItemSpanFactory() {
        this.info = null;
    }

    public ListItemSpanFactory(ListMarginInfo listMarginInfo) {
        this.info = listMarginInfo;
    }

    @Override // io.noties.markwon.SpanFactory
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        int listItemExtraMargin = getListItemExtraMargin(markwonConfiguration, renderProps, this.info);
        boolean booleanValue = CoreProps.LIST_ITEM_REAL_SELF.require(renderProps).booleanValue();
        if (CoreProps.ListItemType.BULLET == CoreProps.LIST_ITEM_TYPE.require(renderProps)) {
            return new BulletListItemSpan(markwonConfiguration.theme(), this.info, getListItemLevel(renderProps), listItemExtraMargin, booleanValue);
        }
        return new OrderedListItemSpan(markwonConfiguration.theme(), this.info, CoreProps.ORDERED_LIST_ITEM_NUMBER.require(renderProps) + ". ", listItemExtraMargin, booleanValue);
    }

    private int getListItemLevel(RenderProps renderProps) {
        int intValue = ((Integer) renderProps.get(CoreProps.LIST_ITEM_REAL_LEVEL, -1)).intValue();
        return (intValue == 0 || intValue == -1) ? CoreProps.BULLET_LIST_ITEM_LEVEL.require(renderProps).intValue() : intValue;
    }

    public int getListItemExtraMargin(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, ListMarginInfo listMarginInfo) {
        try {
            int intValue = ((Integer) renderProps.get(CoreProps.BULLET_LIST_ITEM_LEVEL, -1)).intValue();
            int intValue2 = ((Integer) renderProps.get(CoreProps.LIST_ITEM_REAL_LEVEL, -1)).intValue();
            if (intValue != -1 && intValue2 != -1) {
                int listMargin = listMarginInfo != null ? listMarginInfo.getListMargin() : markwonConfiguration.theme().getBlockMargin();
                if (intValue != 0 || intValue2 == 0) {
                    return 0;
                }
                return intValue2 * listMargin;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
