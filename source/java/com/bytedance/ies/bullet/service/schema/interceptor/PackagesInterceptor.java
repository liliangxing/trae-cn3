package com.bytedance.ies.bullet.service.schema.interceptor;

import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PackagesInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/interceptor/PackagesInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", SchemaConstants.QUERY_KEY_PACKAGES, "", "", "(Ljava/util/List;)V", "name", "getName", "()Ljava/lang/String;", "getPackages", "()Ljava/util/List;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PackagesInterceptor extends SchemaInterceptor {
    private final String name;
    private final List<String> packages;

    public PackagesInterceptor(List<String> list) {
        Intrinsics.checkNotNullParameter(list, SchemaConstants.QUERY_KEY_PACKAGES);
        this.packages = list;
        this.name = "Packages";
    }

    public final List<String> getPackages() {
        return this.packages;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        ArrayList arrayList = new ArrayList();
        String str = schemaData.getQueryItems().get(SchemaConstants.QUERY_KEY_PACKAGES);
        if (str != null) {
            for (String str2 : StringsKt.split$default(str, new char[]{StringListParam.SPLIT_DELIMITER}, false, 0, 6, (Object) null)) {
                if ((str2.length() > 0) && !this.packages.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        arrayList.addAll(this.packages);
        schemaData.addParam(SchemaConstants.QUERY_KEY_PACKAGES, new StringListParam(arrayList), true);
        return true;
    }
}
