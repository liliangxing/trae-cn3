package com.bytedance.ies.bullet.schema.interceptor;

import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.service.base.BulletSettings;
import com.bytedance.ies.bullet.service.base.ISettingService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.IntegerParam;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimation;
import com.bytedance.ies.bullet.service.sdk.param.OutAnimationParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebStandardInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/schema/interceptor/WebStandardInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "bid", "", "(Ljava/lang/String;)V", "name", "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebStandardInterceptor extends SchemaInterceptor {
    private final String bid;
    private final String name;

    public WebStandardInterceptor(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
        this.name = "WebStandardInterceptor";
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.service.sdk.SchemaInterceptor, com.bytedance.ies.bullet.service.schema.ISchemaInterceptor
    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        if (schemaData.isWeb()) {
            ISettingService iSettingService = (ISettingService) ServiceCenter.INSTANCE.instance().get(ISettingService.class);
            BulletSettings provideBulletSettings = iSettingService != null ? iSettingService.provideBulletSettings() : null;
            boolean z = false;
            if (!(provideBulletSettings != null && provideBulletSettings.getEnableWebStandard())) {
                return true;
            }
            Set<String> blockBid = provideBulletSettings.getBlockBid();
            if (blockBid != null && blockBid.contains(this.bid)) {
                return true;
            }
            ISchemaMutableData iSchemaMutableData = schemaData;
            String value = new StringParam(iSchemaMutableData, SchemaConstants.QUERY_KEY_ENTRANCE_FORM, null).getValue();
            if (value != null) {
                Set<String> blockEntranceForm = provideBulletSettings.getBlockEntranceForm();
                if (blockEntranceForm != null && blockEntranceForm.contains(value)) {
                    return true;
                }
            }
            String value2 = new StringParam(iSchemaMutableData, "url", null).getValue();
            if (value2 == null) {
                value2 = schemaData.getInnerOriginUrl().toString();
                Intrinsics.checkNotNullExpressionValue(value2, "schemaData.originUrl.toString()");
            }
            int domainParty = AnnieXRuntime.INSTANCE.getApplicationDepend().getDomainParty(value2);
            if (domainParty != 1) {
                schemaData.addParam(SchemaConstants.QUERY_KEY_WEB_DOMAIN_PARTY, new IntegerParam(Integer.valueOf(domainParty)), true);
                schemaData.addParam(SchemaConstants.QUERY_KEY_ENABLE_WEBVIEW_SELECT_SEARCH, new BooleanParam(true), false);
                schemaData.addParam(SchemaConstants.QUERY_KEY_NEED_OUT_ANIMATION, new OutAnimationParam(OutAnimation.RIGHT), true);
                List<String> blockSchema = provideBulletSettings.getBlockSchema();
                if (blockSchema != null) {
                    Iterator<String> it = blockSchema.iterator();
                    while (it.hasNext()) {
                        if (schemaData.getQueryItems().containsKey(it.next())) {
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    schemaData.addParam(SchemaConstants.QUERY_KEY_ENABLE_THIRD_PARTY_WEB_UI, new BooleanParam(true), true);
                }
            }
        }
        return true;
    }
}
