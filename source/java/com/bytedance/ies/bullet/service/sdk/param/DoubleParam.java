package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/DoubleParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/Double;)V", "value", "(Ljava/lang/Double;)V", "objectToValue", "", "(Ljava/lang/Object;)Ljava/lang/Double;", "stringToValue", "string", "(Ljava/lang/String;)Ljava/lang/Double;", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class DoubleParam extends Param<Double> {
    public DoubleParam(Double d) {
        super(d);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoubleParam(ISchemaData data, String key, Double d) {
        this(null);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        super.initWithData(data, key, d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Double stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            return Double.valueOf(Double.parseDouble(string));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Double objectToValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Double d = value instanceof Double ? (Double) value : null;
        return d == null ? (Double) super.objectToValue(value) : d;
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        Double value = getValue();
        if (value != null) {
            return value.toString();
        }
        return null;
    }
}
