package com.bytedance.ies.bullet.service.schema;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.schema.model.BDXContainerModel;
import com.bytedance.ies.bullet.service.schema.model.BDXPageModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaModelTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/SchemaModelTransformer;", "", "()V", "generateContainerModel", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "generateUiModel", "transform", "containerModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXContainerModel;", "pageModel", "Lcom/bytedance/ies/bullet/service/schema/model/BDXPageModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SchemaModelTransformer {
    public static final SchemaModelTransformer INSTANCE = new SchemaModelTransformer();

    private SchemaModelTransformer() {
    }

    public final void transform(BDXContainerModel containerModel) {
        Intrinsics.checkNotNullParameter(containerModel, "containerModel");
        if (containerModel.getLoadingBgColor().get_isSet()) {
            return;
        }
        containerModel.setLoadingBgColor(containerModel.getLoadingBgColorOld());
    }

    public final void transform(BDXPageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        if (!pageModel.isAdjustPan().get_isSet()) {
            pageModel.setAdjustPan(pageModel.getEnableImmersionKeyboardControl());
        }
        if (pageModel.getStatusBarBgColor().get_isSet()) {
            pageModel.setStatusBarColor(pageModel.getStatusBarBgColor());
        }
        if (!pageModel.getStatusFontMode().get_isSet()) {
            pageModel.setStatusFontMode(pageModel.getStatusFontDark());
        }
        if (!pageModel.getTransStatusBar().get_isSet()) {
            pageModel.setTransStatusBar(pageModel.getShouldFullScreen());
        }
        if (Intrinsics.areEqual(pageModel.getTransStatusBar().getValue(), true)) {
            pageModel.setHideNavBar(pageModel.getTransStatusBar());
        }
    }

    public final void generateContainerModel(BulletContext bulletContext, ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        if (bulletContext.getSchemaModelUnion().getContainerModel() != null) {
            return;
        }
        BDXContainerModel bDXContainerModel = (BDXContainerModel) com.bytedance.ies.bullet.service.sdk.SchemaService.INSTANCE.getInstance().generateSchemaModel(schemaData, BDXContainerModel.class);
        if (bDXContainerModel != null) {
            INSTANCE.transform(bDXContainerModel);
        }
        bulletContext.getSchemaModelUnion().setContainerModel(bDXContainerModel);
    }

    public final void generateUiModel(BulletContext bulletContext, ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        if (bulletContext.getSchemaModelUnion().getUiModel() != null) {
            return;
        }
        BDXPageModel bDXPageModel = (BDXPageModel) com.bytedance.ies.bullet.service.sdk.SchemaService.INSTANCE.getInstance().generateSchemaModel(schemaData, BDXPageModel.class);
        if (bDXPageModel != null) {
            INSTANCE.transform(bDXPageModel);
        }
        bulletContext.getSchemaModelUnion().setUiModel(bDXPageModel);
    }
}
