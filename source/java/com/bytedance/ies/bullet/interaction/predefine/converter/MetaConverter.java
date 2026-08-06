package com.bytedance.ies.bullet.interaction.predefine.converter;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.HybridLoggerConst;
import com.bytedance.ies.bullet.interaction.predefine.model.MetaModelConfig;
import com.bytedance.news.common.settings.api.annotation.ITypeConverter;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetaConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/converter/MetaConverter;", "Lcom/bytedance/news/common/settings/api/annotation/ITypeConverter;", "Lcom/bytedance/ies/bullet/interaction/predefine/model/MetaModelConfig;", "()V", PraiseDialogConstant.FROM, "", "t", "to", "json", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class MetaConverter implements ITypeConverter<MetaModelConfig> {
    @Override // com.bytedance.news.common.settings.api.annotation.ITypeConverter, com.bytedance.platform.settingsx.api.ITypeConverter
    /* renamed from: to */
    public MetaModelConfig mo4to(String json) {
        String str = json;
        if (!(str == null || str.length() == 0)) {
            try {
                return new MetaModelConfig(new JSONObject(json));
            } catch (JSONException e) {
                HybridLogger hybridLogger = HybridLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("MetaConverter error:");
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                HybridLogger.e$default(hybridLogger, HybridLoggerConst.MODULE_PREDEFINE, sb.append(message).toString(), null, null, 12, null);
            }
        }
        return null;
    }

    @Override // com.bytedance.news.common.settings.api.annotation.ITypeConverter, com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(MetaModelConfig t) {
        return String.valueOf(t);
    }
}
