package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0010J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/Boolean;)V", "value", "(Ljava/lang/Boolean;)V", "objectToValue", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "stringToValue", "string", "(Ljava/lang/String;)Ljava/lang/Boolean;", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BooleanParam extends Param<Boolean> {
    public BooleanParam(Boolean bool) {
        super(bool);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BooleanParam(ISchemaData data, String key, Boolean bool) {
        this(null);
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        super.initWithData(data, key, bool);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r3.equals("false") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r3.equals(com.bytedance.ies.bullet.service.router.RouterConstants.TRUE) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r3.equals("1") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (r3.equals("0") == false) goto L23;
     */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        int hashCode = string.hashCode();
        if (hashCode != 48) {
            if (hashCode != 49) {
                if (hashCode != 3569038) {
                    if (hashCode == 97196323) {
                    }
                }
                return null;
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Boolean objectToValue(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Boolean bool = value instanceof Boolean ? (Boolean) value : null;
        return bool == null ? (Boolean) super.objectToValue(value) : bool;
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        Boolean value = getValue();
        if (value != null) {
            return value.booleanValue() ? "1" : "0";
        }
        return null;
    }
}
