package com.bytedance.ies.bullet.service.sdk.param;

import android.graphics.Color;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: UIColorParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\nJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "Lcom/bytedance/ies/bullet/service/sdk/param/Param;", "", "data", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "key", "", "defaultValue", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/String;Ljava/lang/Integer;)V", "value", "(Ljava/lang/Integer;)V", "useArgb", "", "getUseArgb", "()Ljava/lang/Boolean;", "setUseArgb", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "stringToValue", "string", "(Ljava/lang/String;)Ljava/lang/Integer;", "valueToString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UIColorParam extends Param<Integer> {
    private Boolean useArgb;

    public UIColorParam(Integer num) {
        super(num);
        this.useArgb = false;
    }

    public final Boolean getUseArgb() {
        return this.useArgb;
    }

    public final void setUseArgb(Boolean bool) {
        this.useArgb = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UIColorParam(ISchemaData iSchemaData, String str, Integer num) {
        this(null);
        Intrinsics.checkNotNullParameter(iSchemaData, "data");
        Intrinsics.checkNotNullParameter(str, "key");
        this.useArgb = new BooleanParam(iSchemaData, "use_argb", false).getValue();
        super.initWithData(iSchemaData, str, num);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.ies.bullet.service.sdk.param.Param
    public Integer stringToValue(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            if (StringsKt.startsWith$default(string, "#", false, 2, (Object) null)) {
                string = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(string, "(this as java.lang.String).substring(startIndex)");
            }
            if (StringsKt.startsWith$default(string, "%23", false, 2, (Object) null)) {
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                string = string.substring(3);
                Intrinsics.checkNotNullExpressionValue(string, "(this as java.lang.String).substring(startIndex)");
            }
            int length = string.length();
            if (length == 3) {
                string = "#FF" + string.charAt(0) + string.charAt(0) + string.charAt(1) + string.charAt(1) + string.charAt(2) + string.charAt(2);
            } else if (length == 6) {
                string = "#FF" + string;
            } else if (length == 8) {
                if (Intrinsics.areEqual(this.useArgb, true)) {
                    string = "#" + string;
                } else {
                    string = "#" + StringsKt.takeLast(string, 2) + StringsKt.dropLast(string, 2);
                }
            }
            return Integer.valueOf(Color.parseColor(string));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.ies.bullet.service.schema.IParam
    public String valueToString() {
        Integer value = getValue();
        if (value == null) {
            return null;
        }
        int intValue = value.intValue();
        int i = intValue >> 24;
        int i2 = (16711680 & intValue) >> 16;
        int i3 = (65280 & intValue) >> 8;
        int i4 = intValue & HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_UNKNOWN;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%x%x%x%x", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i)}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
