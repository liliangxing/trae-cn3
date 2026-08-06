package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0007B\u000f\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/String;)V", "value", "(Ljava/lang/String;)V", "stringToValue", "string", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class StringParam extends Param<String> {
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public String stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return string;
    }

    public StringParam(String str) {
        super(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StringParam(ISchemaData data, String key, String str) {
        this(null);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        super.initWithData(data, key, str);
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        return getValue();
    }
}
