package io.noties.markwon.core.listblock;

import com.larus.business.markdown.impl.common.utils.ExtrasKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.ListBlock;

/* compiled from: ListBlockExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"KEY_LIST_BLOCK_INDENT", "", "getIndent", "", "Lorg/commonmark/node/ListBlock;", "setIndent", "", "indent", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ListBlockExtKt {
    public static final String KEY_LIST_BLOCK_INDENT = "key_list_block_indent";

    public static final void setIndent(ListBlock listBlock, int i) {
        Intrinsics.checkNotNullParameter(listBlock, "<this>");
        ExtrasKt.putExtra(listBlock, KEY_LIST_BLOCK_INDENT, Integer.valueOf(i));
    }

    public static final int getIndent(ListBlock listBlock) {
        Intrinsics.checkNotNullParameter(listBlock, "<this>");
        Integer num = (Integer) ExtrasKt.getExtra(listBlock, KEY_LIST_BLOCK_INDENT);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
