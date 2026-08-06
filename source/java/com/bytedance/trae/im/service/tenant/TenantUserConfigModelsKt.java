package com.bytedance.trae.im.service.tenant;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TenantUserConfigModels.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0002\u001a\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0005"}, d2 = {"stringOrNumber", "", "Lcom/google/gson/JsonElement;", "stringListFromArrayOrJsonString", "", "im_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TenantUserConfigModelsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String stringOrNumber(JsonElement jsonElement) {
        JsonPrimitive asJsonPrimitive;
        Object obj;
        if (jsonElement == null) {
            return "";
        }
        if (!(!jsonElement.isJsonNull() && jsonElement.isJsonPrimitive())) {
            jsonElement = null;
        }
        if (jsonElement == null || (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) == null) {
            return "";
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(asJsonPrimitive.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (String) (Result.isFailure-impl(obj) ? "" : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x002e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<String> stringListFromArrayOrJsonString(JsonElement jsonElement) {
        Object obj;
        Iterable<JsonElement> asJsonArray;
        String str;
        JsonPrimitive asJsonPrimitive;
        String str2;
        JsonPrimitive asJsonPrimitive2;
        if (jsonElement != null) {
            ArrayList arrayList = null;
            if (!(!jsonElement.isJsonNull())) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                if (!jsonElement.isJsonArray()) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                        try {
                            Result.Companion companion = Result.Companion;
                            JsonElement parseString = JsonParser.parseString(jsonElement.getAsString());
                            if (!parseString.isJsonArray()) {
                                parseString = null;
                            }
                            if (parseString != null && (asJsonArray = parseString.getAsJsonArray()) != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (JsonElement jsonElement2 : asJsonArray) {
                                    if (!(!jsonElement2.isJsonNull() && jsonElement2.isJsonPrimitive())) {
                                        jsonElement2 = null;
                                    }
                                    if (jsonElement2 != null && (asJsonPrimitive = jsonElement2.getAsJsonPrimitive()) != null) {
                                        if (!asJsonPrimitive.isString()) {
                                            asJsonPrimitive = null;
                                        }
                                        if (asJsonPrimitive != null) {
                                            str = asJsonPrimitive.getAsString();
                                            if (str == null) {
                                                arrayList2.add(str);
                                            }
                                        }
                                    }
                                    str = null;
                                    if (str == null) {
                                    }
                                }
                                ArrayList arrayList3 = new ArrayList();
                                for (Object obj2 : arrayList2) {
                                    if (!StringsKt.isBlank((String) obj2)) {
                                        arrayList3.add(obj2);
                                    }
                                }
                                arrayList = arrayList3;
                            }
                            if (arrayList == null) {
                                arrayList = CollectionsKt.emptyList();
                            }
                            obj = Result.constructor-impl(arrayList);
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        List emptyList = CollectionsKt.emptyList();
                        if (Result.isFailure-impl(obj)) {
                            obj = emptyList;
                        }
                        return (List) obj;
                    }
                    return CollectionsKt.emptyList();
                }
                Iterable<JsonElement> asJsonArray2 = jsonElement.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray2, "getAsJsonArray(...)");
                ArrayList arrayList4 = new ArrayList();
                for (JsonElement jsonElement3 : asJsonArray2) {
                    if (!(!jsonElement3.isJsonNull() && jsonElement3.isJsonPrimitive())) {
                        jsonElement3 = null;
                    }
                    if (jsonElement3 != null && (asJsonPrimitive2 = jsonElement3.getAsJsonPrimitive()) != null) {
                        if (!asJsonPrimitive2.isString()) {
                            asJsonPrimitive2 = null;
                        }
                        if (asJsonPrimitive2 != null) {
                            str2 = asJsonPrimitive2.getAsString();
                            if (str2 == null) {
                                arrayList4.add(str2);
                            }
                        }
                    }
                    str2 = null;
                    if (str2 == null) {
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                for (Object obj3 : arrayList4) {
                    if (!StringsKt.isBlank((String) obj3)) {
                        arrayList5.add(obj3);
                    }
                }
                return arrayList5;
            }
        }
        return CollectionsKt.emptyList();
    }
}
