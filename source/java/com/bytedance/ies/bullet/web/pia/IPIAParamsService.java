package com.bytedance.ies.bullet.web.pia;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IPIAParamsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/IPIAParamsService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getGlobalProps", "", "", "", "context", "Landroid/content/Context;", "originSchema", "checkPermission", "", "url", "processAndUpdateUrl", "currentTemplateUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPIAParamsService extends IBulletService {
    Map<String, Object> getGlobalProps(Context context, String originSchema, boolean checkPermission, String url);

    String processAndUpdateUrl(String currentTemplateUrl);
}
