package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.librarian.LibrarianImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PrefetchSchema.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "", "enablePrefetch", "", "business", "", "rawData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "(ZLjava/lang/String;Lcom/bytedance/ies/bullet/service/schema/ISchemaData;)V", "getBusiness", "()Ljava/lang/String;", "getEnablePrefetch", "()Z", "isDevMode", "setDevMode", "(Z)V", "getRawData", "()Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "getQuery", "key", "getQueryFromObject", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SchemaModel {
    private final String business;
    private final boolean enablePrefetch;
    private boolean isDevMode;
    private final ISchemaData rawData;

    public SchemaModel(boolean z, String str, ISchemaData iSchemaData) {
        Intrinsics.checkNotNullParameter(iSchemaData, "rawData");
        this.enablePrefetch = z;
        this.business = str;
        this.rawData = iSchemaData;
    }

    public final String getBusiness() {
        return this.business;
    }

    public final boolean getEnablePrefetch() {
        return this.enablePrefetch;
    }

    public final ISchemaData getRawData() {
        return this.rawData;
    }

    /* renamed from: isDevMode, reason: from getter */
    public final boolean getIsDevMode() {
        return this.isDevMode;
    }

    public final void setDevMode(boolean z) {
        this.isDevMode = z;
    }

    public final String getQuery(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.rawData.getQueryItems().get(key);
    }

    public final String getQueryFromObject(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        List split$default = StringsKt.split$default(key, new String[]{LibrarianImpl.Constants.DOT}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            throw new PrefetchException("配置错误，格式应该为a.b: " + key);
        }
        String query = getQuery((String) split$default.get(0));
        if (query == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(query);
        String str = (String) split$default.get(1);
        if (IConditionCallKt.fixPrefetchQueryObject()) {
            String optString = jSONObject.optString(str);
            Intrinsics.checkNotNullExpressionValue(optString, "it");
            if (optString.length() > 0) {
                return optString;
            }
            return null;
        }
        return jSONObject.optString(str);
    }
}
