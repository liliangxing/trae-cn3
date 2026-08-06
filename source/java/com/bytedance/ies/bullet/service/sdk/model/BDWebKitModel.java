package com.bytedance.ies.bullet.service.sdk.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDWebKitModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/model/BDWebKitModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "disableBounce", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getDisableBounce", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setDisableBounce", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class BDWebKitModel implements ISchemaModel {
    public BooleanParam disableBounce;

    public final BooleanParam getDisableBounce() {
        BooleanParam booleanParam = this.disableBounce;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableBounce");
        return null;
    }

    public final void setDisableBounce(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableBounce = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setDisableBounce(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_DISABLE_BOUNCE, false));
    }
}
