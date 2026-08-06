package com.bytedance.android.anniex.detect.schema;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.StringParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXBlankDetectModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/detect/schema/BDXBlankDetectModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "bdhmBid", "Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "getBdhmBid", "()Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;", "setBdhmBid", "(Lcom/bytedance/ies/bullet/service/sdk/param/StringParam;)V", "enableBlankDetect", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getEnableBlankDetect", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setEnableBlankDetect", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BDXBlankDetectModel implements ISchemaModel {
    public StringParam bdhmBid;
    public BooleanParam enableBlankDetect;

    public final BooleanParam getEnableBlankDetect() {
        BooleanParam booleanParam = this.enableBlankDetect;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableBlankDetect");
        return null;
    }

    public final void setEnableBlankDetect(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableBlankDetect = booleanParam;
    }

    public final StringParam getBdhmBid() {
        StringParam stringParam = this.bdhmBid;
        if (stringParam != null) {
            return stringParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bdhmBid");
        return null;
    }

    public final void setBdhmBid(StringParam stringParam) {
        Intrinsics.checkNotNullParameter(stringParam, "<set-?>");
        this.bdhmBid = stringParam;
    }

    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setEnableBlankDetect(new BooleanParam(schemaData, "enable_blank_detect", false));
        setBdhmBid(new StringParam(schemaData, "bdhm_bid", ""));
    }
}
