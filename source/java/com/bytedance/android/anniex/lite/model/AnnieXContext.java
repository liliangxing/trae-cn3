package com.bytedance.android.anniex.lite.model;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.anniex.scene.data.SceneDbContract;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010.\u001a\u00020/H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0010¨\u00060"}, d2 = {"Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", SceneDbContract.Scenes.TABLE_NAME, "Lcom/bytedance/ies/bullet/core/common/Scenes;", "sessionId", "", "bid", "bundle", "Landroid/os/Bundle;", "originSchema", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "(Lcom/bytedance/ies/bullet/core/common/Scenes;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/utils/KitType;Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;)V", "getBid", "()Ljava/lang/String;", "getBundle", "()Landroid/os/Bundle;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "midProperties", "", "", "getMidProperties$annotations", "()V", "getMidProperties", "()Ljava/util/Map;", "setMidProperties", "(Ljava/util/Map;)V", "getOriginSchema", "getScenes", "()Lcom/bytedance/ies/bullet/core/common/Scenes;", "getSchemaModelUnion", "()Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getSessionId", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXContext implements IReleasable {
    private final String bid;
    private final Bundle bundle;
    private Context context;
    private final ContextProviderFactory contextProviderFactory;
    private final KitType kitType;
    private Map<String, Object> midProperties;
    private final String originSchema;
    private final Scenes scenes;
    private final SchemaModelUnion schemaModelUnion;
    private final String sessionId;

    @Deprecated(message = "AnnieXContext中不允许渲染相关props，请通过Event替换 => annie.updateRenderData")
    public static /* synthetic */ void getMidProperties$annotations() {
    }

    public AnnieXContext(Scenes scenes, String str, String str2, Bundle bundle, String str3, KitType kitType, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(scenes, SceneDbContract.Scenes.TABLE_NAME);
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "bid");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str3, "originSchema");
        Intrinsics.checkNotNullParameter(kitType, "kitType");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        this.contextProviderFactory = new ContextProviderFactory();
        this.midProperties = new LinkedHashMap();
        this.scenes = scenes;
        this.sessionId = str;
        this.bid = str2;
        this.bundle = bundle;
        this.originSchema = str3;
        this.kitType = kitType;
        this.schemaModelUnion = schemaModelUnion;
    }

    public final Scenes getScenes() {
        return this.scenes;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getBid() {
        return this.bid;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final KitType getKitType() {
        return this.kitType;
    }

    public final String getOriginSchema() {
        return this.originSchema;
    }

    public final SchemaModelUnion getSchemaModelUnion() {
        return this.schemaModelUnion;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final ContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public final Map<String, Object> getMidProperties() {
        return this.midProperties;
    }

    public final void setMidProperties(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.midProperties = map;
    }

    public void release() {
        this.context = null;
        ContextProviderFactory contextProviderFactory = this.contextProviderFactory;
        if (contextProviderFactory != null) {
            contextProviderFactory.removeAll();
        }
    }
}
