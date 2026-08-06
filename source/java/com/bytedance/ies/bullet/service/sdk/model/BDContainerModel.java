package com.bytedance.ies.bullet.service.sdk.model;

import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import com.bytedance.ies.bullet.service.sdk.param.UIColorParam;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BDContainerModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 ¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/model/BDContainerModel;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "()V", "containerBgColor", "Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "getContainerBgColor", "()Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;", "setContainerBgColor", "(Lcom/bytedance/ies/bullet/service/sdk/param/UIColorParam;)V", "containerDarkBgColor", "getContainerDarkBgColor", "setContainerDarkBgColor", "containerLightBgColor", "getContainerLightBgColor", "setContainerLightBgColor", "contentBgColor", "getContentBgColor", "setContentBgColor", "disableBuiltin", "Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "getDisableBuiltin", "()Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;", "setDisableBuiltin", "(Lcom/bytedance/ies/bullet/service/sdk/param/BooleanParam;)V", "disableOffline", "getDisableOffline", "setDisableOffline", "fallbackUrl", "Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;", "getFallbackUrl", "()Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;", "setFallbackUrl", "(Lcom/bytedance/ies/bullet/service/sdk/param/UrlParam;)V", "hideLoading", "getHideLoading", "setHideLoading", "loadingBgColor", "getLoadingBgColor", "setLoadingBgColor", "originSchema", "", "getOriginSchema", "()Ljava/lang/String;", "setOriginSchema", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "initWithData", "", "schemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BDContainerModel implements ISchemaModel {
    public UIColorParam containerBgColor;
    public UIColorParam containerDarkBgColor;
    public UIColorParam containerLightBgColor;
    public UIColorParam contentBgColor;
    public BooleanParam disableBuiltin;
    public BooleanParam disableOffline;
    public UrlParam fallbackUrl;
    public BooleanParam hideLoading;
    public UIColorParam loadingBgColor;
    private String originSchema = "defaultSchema";
    public UrlParam url;

    public final UIColorParam getContainerBgColor() {
        UIColorParam uIColorParam = this.containerBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerBgColor");
        return null;
    }

    public final void setContainerBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.containerBgColor = uIColorParam;
    }

    public final BooleanParam getDisableBuiltin() {
        BooleanParam booleanParam = this.disableBuiltin;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableBuiltin");
        return null;
    }

    public final void setDisableBuiltin(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableBuiltin = booleanParam;
    }

    public final BooleanParam getDisableOffline() {
        BooleanParam booleanParam = this.disableOffline;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("disableOffline");
        return null;
    }

    public final void setDisableOffline(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.disableOffline = booleanParam;
    }

    public final UrlParam getFallbackUrl() {
        UrlParam urlParam = this.fallbackUrl;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fallbackUrl");
        return null;
    }

    public final void setFallbackUrl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.fallbackUrl = urlParam;
    }

    public final BooleanParam getHideLoading() {
        BooleanParam booleanParam = this.hideLoading;
        if (booleanParam != null) {
            return booleanParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hideLoading");
        return null;
    }

    public final void setHideLoading(BooleanParam booleanParam) {
        Intrinsics.checkNotNullParameter(booleanParam, "<set-?>");
        this.hideLoading = booleanParam;
    }

    public final UIColorParam getLoadingBgColor() {
        UIColorParam uIColorParam = this.loadingBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingBgColor");
        return null;
    }

    public final void setLoadingBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.loadingBgColor = uIColorParam;
    }

    public final UrlParam getUrl() {
        UrlParam urlParam = this.url;
        if (urlParam != null) {
            return urlParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("url");
        return null;
    }

    public final void setUrl(UrlParam urlParam) {
        Intrinsics.checkNotNullParameter(urlParam, "<set-?>");
        this.url = urlParam;
    }

    public final UIColorParam getContentBgColor() {
        UIColorParam uIColorParam = this.contentBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentBgColor");
        return null;
    }

    public final void setContentBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.contentBgColor = uIColorParam;
    }

    public final UIColorParam getContainerLightBgColor() {
        UIColorParam uIColorParam = this.containerLightBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerLightBgColor");
        return null;
    }

    public final void setContainerLightBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.containerLightBgColor = uIColorParam;
    }

    public final UIColorParam getContainerDarkBgColor() {
        UIColorParam uIColorParam = this.containerDarkBgColor;
        if (uIColorParam != null) {
            return uIColorParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("containerDarkBgColor");
        return null;
    }

    public final void setContainerDarkBgColor(UIColorParam uIColorParam) {
        Intrinsics.checkNotNullParameter(uIColorParam, "<set-?>");
        this.containerDarkBgColor = uIColorParam;
    }

    public final String getOriginSchema() {
        return this.originSchema;
    }

    public final void setOriginSchema(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.originSchema = str;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaModel
    public void initWithData(ISchemaData schemaData) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        try {
            Result.Companion companion = Result.Companion;
            String uri = schemaData.getInnerOriginUrl().toString();
            Intrinsics.checkNotNullExpressionValue(uri, "schemaData.originUrl.toString()");
            this.originSchema = uri;
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        setContainerBgColor(new UIColorParam(schemaData, SchemaConstants.QUERY_KEY_CONTAINER_BG_COLOR, null));
        setDisableBuiltin(new BooleanParam(schemaData, "disable_builtin", false));
        setDisableOffline(new BooleanParam(schemaData, SchemaConstants.QUERY_KEY_DISABLE_OFFLINE, false));
        setFallbackUrl(new UrlParam(schemaData, SchemaConstants.QUERY_KEY_FALLBACK_URL, null));
        setHideLoading(new BooleanParam(schemaData, "hide_loading", null));
        setLoadingBgColor(new UIColorParam(schemaData, "loading_bg_color", null));
        setUrl(new UrlParam(schemaData, "url", null));
        setContentBgColor(new UIColorParam(schemaData, "content_bg_color", null));
        setContainerLightBgColor(new UIColorParam(schemaData, "container_light_bg_color", null));
        setContainerDarkBgColor(new UIColorParam(schemaData, "container_dark_bg_color", null));
    }
}
