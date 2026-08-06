package com.bytedance.android.anniex.lite.flow.schema;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDXPreTaskModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/schema/BDXPreTaskModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "enableEnginePreload", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getEnableEnginePreload", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setEnableEnginePreload", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "enableModelPreCreate", "getEnableModelPreCreate", "setEnableModelPreCreate", "enablePrefetch", "getEnablePrefetch", "setEnablePrefetch", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class BDXPreTaskModel implements ISchemaModel {
    public BooleanParam enableEnginePreload;
    public BooleanParam enableModelPreCreate;
    public BooleanParam enablePrefetch;

    public final BooleanParam getEnablePrefetch() {
        BooleanParam booleanParam = this.enablePrefetch;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enablePrefetch");
        return null;
    }

    public final void setEnablePrefetch(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enablePrefetch = booleanParam;
    }

    public final BooleanParam getEnableModelPreCreate() {
        BooleanParam booleanParam = this.enableModelPreCreate;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableModelPreCreate");
        return null;
    }

    public final void setEnableModelPreCreate(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableModelPreCreate = booleanParam;
    }

    public final BooleanParam getEnableEnginePreload() {
        BooleanParam booleanParam = this.enableEnginePreload;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("enableEnginePreload");
        return null;
    }

    public final void setEnableEnginePreload(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.enableEnginePreload = booleanParam;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        setEnablePrefetch(new BooleanParam(schemaData, SchemaConstants.ENABLE_PREFETCH_V2, false));
        setEnableModelPreCreate(new BooleanParam(schemaData, "enable_model_pre_create", true));
        setEnableEnginePreload(new BooleanParam(schemaData, "enable_engine_preload", true));
    }
}
