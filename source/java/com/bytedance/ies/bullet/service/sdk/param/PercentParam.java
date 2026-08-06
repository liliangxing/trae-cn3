package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/PercentParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/Integer;)V", "value", "(Ljava/lang/Integer;)V", "objectToValue", "", "(Ljava/lang/Object;)Ljava/lang/Integer;", "stringToValue", "string", "(Ljava/lang/String;)Ljava/lang/Integer;", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PercentParam extends Param<Integer> {
    public PercentParam(Integer num) {
        super(num);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PercentParam(ISchemaData iSchemaData, String str, Integer num) {
        this(null);
        Intrinsics.checkNotNullParameter(iSchemaData, "data");
        Intrinsics.checkNotNullParameter(str, "key");
        super.initWithData(iSchemaData, str, num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Integer stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            int parseInt = Integer.parseInt(string);
            boolean z = false;
            if (parseInt >= 0 && parseInt < 101) {
                z = true;
            }
            if (z) {
                return Integer.valueOf(parseInt);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Integer objectToValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Integer num = value instanceof Integer ? (Integer) value : null;
        boolean z = false;
        IntRange intRange = new IntRange(0, 100);
        if (num != null && intRange.contains(num.intValue())) {
            z = true;
        }
        Integer num2 = z ? num : null;
        return num2 == null ? (Integer) super.objectToValue(value) : num2;
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        Integer value = getValue();
        if (value != null) {
            return value.toString();
        }
        return null;
    }
}
