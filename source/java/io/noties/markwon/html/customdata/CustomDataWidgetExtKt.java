package io.noties.markwon.html.customdata;

import android.view.ViewGroup;
import io.noties.markwon.html.C1562R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: CustomDataWidgetExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a4\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u001a:\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000e"}, d2 = {"clearWidgetCache", "", "Landroid/view/ViewGroup;", "obtainWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "recycleWidget", "widget", "markwon-html_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataWidgetExtKt {
    public static final void recycleWidget(ViewGroup viewGroup, int i, int i2, String str, String str2, String str3, ICustomDataWidget iCustomDataWidget) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$recycleWidget");
        Intrinsics.checkParameterIsNotNull(str, "dataType");
        Intrinsics.checkParameterIsNotNull(str2, "dataValue");
        Intrinsics.checkParameterIsNotNull(str3, "dataValueId");
        Intrinsics.checkParameterIsNotNull(iCustomDataWidget, "widget");
        Object tag = viewGroup.getTag(C1562R.id.markwon_cached_widget_list);
        if (!TypeIntrinsics.isMutableList(tag)) {
            tag = null;
        }
        ArrayList arrayList = (List) tag;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(new CachedWidget(i, i2, str, str2, str3, null, iCustomDataWidget, 32, null));
        viewGroup.setTag(C1562R.id.markwon_cached_widget_list, arrayList);
    }

    public static final ICustomDataWidget obtainWidget(ViewGroup viewGroup, int i, int i2, String str, String str2, String str3) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$obtainWidget");
        Intrinsics.checkParameterIsNotNull(str, "dataType");
        Intrinsics.checkParameterIsNotNull(str2, "dataValue");
        Intrinsics.checkParameterIsNotNull(str3, "dataValueId");
        Object tag = viewGroup.getTag(C1562R.id.markwon_cached_widget_list);
        if (!TypeIntrinsics.isMutableList(tag)) {
            tag = null;
        }
        List list = (List) tag;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CachedWidget cachedWidget = (CachedWidget) obj;
            if (cachedWidget.getStartIndex() == i && cachedWidget.getEndIndex() == i2 && Intrinsics.areEqual(cachedWidget.getDataType(), str) && Intrinsics.areEqual(cachedWidget.getDataValue(), str2) && Intrinsics.areEqual(cachedWidget.getDataValueId(), str3)) {
                break;
            }
        }
        CachedWidget cachedWidget2 = (CachedWidget) obj;
        if (cachedWidget2 == null) {
            return null;
        }
        list.remove(cachedWidget2);
        viewGroup.setTag(C1562R.id.markwon_cached_widget_list, list);
        return cachedWidget2.getWidget();
    }

    public static final void clearWidgetCache(ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$this$clearWidgetCache");
        viewGroup.setTag(C1562R.id.markwon_cached_widget_list, null);
    }
}
