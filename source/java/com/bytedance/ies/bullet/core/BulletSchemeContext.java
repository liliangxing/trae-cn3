package com.bytedance.ies.bullet.core;

import android.os.Bundle;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletSchemeContext;", "", "()V", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "extraSchemaModelList", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getExtraSchemaModelList", "()Ljava/util/List;", "setExtraSchemaModelList", "(Ljava/util/List;)V", SchemaConstants.QUERY_KEY_PACKAGES, "", "", "getPackages", "setPackages", "getPackagesString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BulletSchemeContext {
    private Bundle bundle;
    private List<ISchemaModel> extraSchemaModelList;
    private List<String> packages;

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public final List<String> getPackages() {
        return this.packages;
    }

    public final void setPackages(List<String> list) {
        this.packages = list;
    }

    public final List<ISchemaModel> getExtraSchemaModelList() {
        return this.extraSchemaModelList;
    }

    public final void setExtraSchemaModelList(List<ISchemaModel> list) {
        this.extraSchemaModelList = list;
    }

    public final String getPackagesString() {
        StringBuilder sb = new StringBuilder();
        List<String> list = this.packages;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append(',');
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
