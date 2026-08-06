package com.bytedance.ies.bullet.service.base;

import android.content.Context;
import android.net.Uri;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IGlobalPropsInjectService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IGlobalPropsInjectService;", "", "getStorageValues", "", "", "uri", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "getUserDomainStorageValues", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IGlobalPropsInjectService {
    Map<String, Object> getStorageValues(Uri uri, Context context);

    Map<String, Object> getUserDomainStorageValues(Uri uri, Context context);
}
