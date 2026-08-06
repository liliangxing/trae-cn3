package io.noties.markwon.html.customdata;

import android.view.View;
import io.noties.markwon.html.C1562R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: CustomDataLynxWidgetExt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Lio/noties/markwon/html/customdata/CustomDataLynxWidgetExt;", "", "()V", "obtainWidget", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", "view", "Landroid/view/View;", "startIndex", "", "endIndex", "dataType", "", "dataValue", "dataValueId", "dataTag", "recycleWidget", "", "widget", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomDataLynxWidgetExt {
    public static final CustomDataLynxWidgetExt INSTANCE = new CustomDataLynxWidgetExt();

    private CustomDataLynxWidgetExt() {
    }

    public final void recycleWidget(View view, int startIndex, int endIndex, String dataType, String dataValue, String dataValueId, String dataTag, ICustomDataWidget widget) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(dataType, "dataType");
        Intrinsics.checkParameterIsNotNull(dataValue, "dataValue");
        Intrinsics.checkParameterIsNotNull(dataValueId, "dataValueId");
        Intrinsics.checkParameterIsNotNull(dataTag, "dataTag");
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        Object tag = view.getTag(C1562R.id.markwon_cached_lynx_widget_list);
        if (!TypeIntrinsics.isMutableList(tag)) {
            tag = null;
        }
        ArrayList arrayList = (List) tag;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(new CachedWidget(startIndex, endIndex, dataType, dataValue, dataValueId, dataTag, widget));
        view.setTag(C1562R.id.markwon_cached_lynx_widget_list, arrayList);
    }

    public final ICustomDataWidget obtainWidget(View view, int startIndex, int endIndex, String dataType, String dataValue, String dataValueId, String dataTag) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(dataType, "dataType");
        Intrinsics.checkParameterIsNotNull(dataValue, "dataValue");
        Intrinsics.checkParameterIsNotNull(dataValueId, "dataValueId");
        Intrinsics.checkParameterIsNotNull(dataTag, "dataTag");
        Object tag = view.getTag(C1562R.id.markwon_cached_lynx_widget_list);
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
            if (cachedWidget.getStartIndex() == startIndex && cachedWidget.getEndIndex() == endIndex && Intrinsics.areEqual(cachedWidget.getDataType(), dataType) && Intrinsics.areEqual(cachedWidget.getDataValue(), dataValue) && Intrinsics.areEqual(cachedWidget.getDataValueId(), dataValueId) && Intrinsics.areEqual(cachedWidget.getDataTag(), dataTag)) {
                break;
            }
        }
        CachedWidget cachedWidget2 = (CachedWidget) obj;
        if (cachedWidget2 != null) {
            return cachedWidget2.getWidget();
        }
        return null;
    }
}
