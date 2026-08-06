package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavBtnParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnType;", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnType;)V", "value", "(Lcom/bytedance/ies/bullet/service/sdk/param/NavBtnType;)V", "objectToValue", "", "stringToValue", "string", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class NavBtnParam extends Param<NavBtnType> {
    public NavBtnParam(NavBtnType navBtnType) {
        super(navBtnType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavBtnParam(ISchemaData data, String key, NavBtnType navBtnType) {
        this(null);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        super.initWithData(data, key, navBtnType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public NavBtnType stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        for (NavBtnType navBtnType : NavBtnType.values()) {
            if (Intrinsics.areEqual(string, navBtnType.getValue()) || Intrinsics.areEqual(string, navBtnType.getAliasValue())) {
                return navBtnType;
            }
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public NavBtnType objectToValue(Object value) {
        NavBtnType stringToValue;
        Intrinsics.checkNotNullParameter(value, "value");
        Integer num = value instanceof Integer ? (Integer) value : null;
        return (num == null || (stringToValue = stringToValue(String.valueOf(num.intValue()))) == null) ? (NavBtnType) super.objectToValue(value) : stringToValue;
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        NavBtnType value = getValue();
        if (value != null) {
            return value.getValue();
        }
        return null;
    }
}
