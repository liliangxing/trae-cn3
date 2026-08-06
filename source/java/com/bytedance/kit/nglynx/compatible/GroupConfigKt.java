package com.bytedance.kit.nglynx.compatible;

import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GroupConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"readGroupConfig", "Lcom/bytedance/kit/nglynx/compatible/GroupConfig;", "inputStream", "Ljava/io/InputStream;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class GroupConfigKt {
    public static final GroupConfig readGroupConfig(InputStream inputStream) {
        String str;
        JSONObject optJSONObject;
        int i;
        String str2 = "";
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                JSONObject jSONObject = new JSONObject(readText);
                String optString = jSONObject.optString(IPiaCacheProvider.CacheConfig.FIELD_VERSION, "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("android");
                JSONArray optJSONArray = optJSONObject2 != null ? optJSONObject2.optJSONArray("card_list") : null;
                HashMap hashMap = new HashMap();
                boolean z = false;
                int length = optJSONArray != null ? optJSONArray.length() : 0;
                int i2 = 0;
                while (i2 < length) {
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(i2)) == null) {
                        str = str2;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                        String optString2 = optJSONObject.optString("card_version", str2);
                        String optString3 = optJSONObject.optString("card_id", str2);
                        String optString4 = optJSONObject.optString("card_template_path", str2);
                        String optString5 = optJSONObject.optString("desc");
                        boolean optBoolean = optJSONObject.optBoolean("fetch_res", z);
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("res_http_prefix");
                        if (optJSONArray2 != null) {
                            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(\"res_http_prefix\")");
                            int length2 = optJSONArray2.length();
                            for (int i3 = z; i3 < length2; i3++) {
                                String str3 = str2;
                                String optString6 = optJSONArray2.optString(i3);
                                if (optString6 != null) {
                                    i = length2;
                                    Intrinsics.checkNotNullExpressionValue(optString6, "optString(prefixIndex)");
                                    arrayList.add(optString6);
                                } else {
                                    i = length2;
                                }
                                length2 = i;
                                str2 = str3;
                            }
                        }
                        str = str2;
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("extra");
                        Intrinsics.checkNotNullExpressionValue(optString3, "id");
                        Intrinsics.checkNotNullExpressionValue(optString2, "cardVersion");
                        Intrinsics.checkNotNullExpressionValue(optString4, "path");
                        hashMap.put(optString3, new CardConfig(optString2, optString3, optString4, optString5, optBoolean, arrayList, optJSONObject3));
                    }
                    i2++;
                    str2 = str;
                    z = false;
                }
                Intrinsics.checkNotNullExpressionValue(optString, "groupVersion");
                return new GroupConfig(optString, hashMap);
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }
}
