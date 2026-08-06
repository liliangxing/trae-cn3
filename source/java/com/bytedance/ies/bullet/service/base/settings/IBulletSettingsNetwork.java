package com.bytedance.ies.bullet.service.base.settings;

import com.bytedance.android.monitorV2.constant.ReportConst;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IBulletSettingsService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/settings/IBulletSettingsNetwork;", "", "post", "Lcom/bytedance/ies/bullet/service/base/settings/SettingsResponse;", "url", "", "headers", "", ReportConst.ValidationReport.BODY, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletSettingsNetwork {
    SettingsResponse post(String url, Map<String, String> headers, Map<String, String> body);
}
