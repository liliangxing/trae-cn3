package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSArrayKt;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorUtilsStringUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0001H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/salamander/anniex/AnnieXStringUtils;", "", "()V", "objectMapToStringMap", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "objMap", "objectToString", "obj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class AnnieXStringUtils {
    public String objectToString(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return String.valueOf(obj);
    }

    public Map<String, String> objectMapToStringMap(Map<String, Object> objMap) {
        Intrinsics.checkNotNullParameter(objMap, "objMap");
        Map<String, String> RTSMap = RTSMapKt.RTSMap();
        ArrayList keys = RTSMapKt.keys(objMap);
        for (int i = 0; i < RTSArrayKt.getLength(keys); i++) {
            Object obj = keys.get(i);
            Intrinsics.checkNotNullExpressionValue(obj, "_mKeys[i]");
            String str = (String) obj;
            Object obj2 = objMap.get(str);
            if (obj2 != null) {
                RTSMapKt.set(RTSMap, str, objectToString(obj2));
            }
        }
        return RTSMap;
    }
}
