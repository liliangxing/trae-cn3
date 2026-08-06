package com.bytedance.trae.conversation.chat.block.renderer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* compiled from: PureShowWidgetInlineView.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"readString", "", "Lcom/google/gson/JsonObject;", "key", "readStringArray", "", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetInlineViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String readString(JsonObject jsonObject, String str) {
        String asString;
        if (jsonObject == null) {
            return null;
        }
        try {
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement == null) {
                return null;
            }
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement == null || (asString = jsonElement.getAsString()) == null) {
                return null;
            }
            if (!StringsKt.isBlank(asString)) {
                return asString;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0027 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List<String> readStringArray(JsonObject jsonObject, String str) {
        Iterable<JsonElement> asJsonArray;
        String str2;
        if (jsonObject != null) {
            try {
                JsonElement jsonElement = jsonObject.get(str);
                if (jsonElement != null) {
                    if (!jsonElement.isJsonArray()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
                        ArrayList arrayList = new ArrayList();
                        for (JsonElement jsonElement2 : asJsonArray) {
                            if (jsonElement2 != null) {
                                if (!jsonElement2.isJsonPrimitive()) {
                                    jsonElement2 = null;
                                }
                                if (jsonElement2 != null && (str2 = jsonElement2.getAsString()) != null && (!StringsKt.isBlank(str2))) {
                                    if (str2 == null) {
                                        arrayList.add(str2);
                                    }
                                }
                            }
                            str2 = null;
                            if (str2 == null) {
                            }
                        }
                        return arrayList;
                    }
                }
            } catch (Throwable unused) {
                return CollectionsKt.emptyList();
            }
        }
        return CollectionsKt.emptyList();
    }
}
