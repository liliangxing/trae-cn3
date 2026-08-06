package com.bytedance.ies.xbridge.platform.web;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* compiled from: Utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000¨\u0006\n"}, d2 = {"map", "", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/json/JSONArray;", CommonConstants.CLIPBOARD_CONTENT, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "item", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    public static final <T> List<T> map(JSONArray jSONArray, Function1<Object, ? extends T> cb) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(cb, "cb");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            Intrinsics.checkNotNullExpressionValue(opt, "opt(i)");
            arrayList.add(cb.invoke(opt));
        }
        return arrayList;
    }
}
