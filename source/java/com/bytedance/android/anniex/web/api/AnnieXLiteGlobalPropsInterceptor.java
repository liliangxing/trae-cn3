package com.bytedance.android.anniex.web.api;

import android.net.Uri;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.sdk.SchemaInterceptor;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXLiteGlobalPropsInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/web/api/AnnieXLiteGlobalPropsInterceptor;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaInterceptor;", "bid", "", "(Ljava/lang/String;)V", StrategyConstants.NAME, "getName", "()Ljava/lang/String;", "convert", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLiteGlobalPropsInterceptor extends SchemaInterceptor {
    private final String bid;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnnieXLiteGlobalPropsInterceptor() {
        this(r0, 1, r0);
        String str = null;
    }

    public String getName() {
        return "AnnieXLiteGlobalPropsInterceptor";
    }

    public AnnieXLiteGlobalPropsInterceptor(String str) {
        Intrinsics.checkNotNullParameter(str, "bid");
        this.bid = str;
    }

    public /* synthetic */ AnnieXLiteGlobalPropsInterceptor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_bid" : str);
    }

    public boolean convert(ISchemaMutableData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        List<String> list = (List) new StringListParam((ISchemaData) schemaData, "append_global_props", CollectionsKt.emptyList()).getValue();
        if (list != null) {
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list != null && HybridSecureUtil.INSTANCE.inCommonParamsAllowList(schemaData.getOriginUrl())) {
                Map<String, String> globalPropsForAppend = GlobalPropsHelper.INSTANCE.getGlobalPropsForAppend(this.bid, list, schemaData.getOriginUrl());
                Uri.Builder buildUpon = schemaData.getOriginUrl().buildUpon();
                buildUpon.appendQueryParameter("appended_global_props", new JSONObject(globalPropsForAppend).toString());
                Uri build = buildUpon.build();
                Intrinsics.checkNotNullExpressionValue(build, "appendedUrl");
                schemaData.setOriginUrl(build);
            }
        }
        return true;
    }
}
