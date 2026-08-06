package com.bytedance.forest.model;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PreloadConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000¨\u0006\u0004"}, d2 = {"calcMainUrlType", "Lcom/bytedance/forest/model/PreloadType;", "mainUrl", "", "forest_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PreloadConfigKt {
    public static final PreloadType calcMainUrlType(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str == null) {
            Intrinsics.throwNpe();
        }
        if (StringsKt.contains$default(str2, ".", false, 2, (Object) null)) {
            String substring = str.substring(StringsKt.lastIndexOf$default(str2, ".", 0, false, 6, (Object) null));
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            if (Intrinsics.areEqual(substring, ".html")) {
                return PreloadType.WEB;
            }
        }
        if (!StringsKt.contains$default(str2, "/", false, 2, (Object) null)) {
            return null;
        }
        String substring2 = str.substring(StringsKt.lastIndexOf$default(str2, "/", 0, false, 6, (Object) null) + 1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        if (Intrinsics.areEqual(substring2, "template.js")) {
            return PreloadType.LYNX;
        }
        return null;
    }
}
