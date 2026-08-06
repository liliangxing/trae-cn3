package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u000eB'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u0015\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/StringListParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/util/List;)V", "value", "(Ljava/util/List;)V", "stringToValue", "string", "valueToString", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StringListParam extends Param<List<? extends String>> {
    public static final char SPLIT_DELIMITER = ',';

    public StringListParam(List<String> list) {
        super(list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StringListParam(ISchemaData iSchemaData, String str, List<String> list) {
        this(null);
        Intrinsics.checkNotNullParameter(iSchemaData, "data");
        Intrinsics.checkNotNullParameter(str, "key");
        super.initWithData(iSchemaData, str, list);
    }

    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public List<? extends String> stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        ArrayList arrayList = new ArrayList();
        for (String str : StringsKt.split$default(string, new char[]{SPLIT_DELIMITER}, false, 0, 6, (Object) null)) {
            if (str.length() > 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        StringBuilder sb = new StringBuilder();
        List<? extends String> value = getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append(SPLIT_DELIMITER);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
