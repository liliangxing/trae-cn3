package com.bytedance.trae.praise;

import android.content.res.Resources;
import com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PraiseDialogUIConfigImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogUIConfigImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogUIConfig;", "<init>", "()V", "getMainBackgroundResId", "", "getMainTitleString", "", "getMainTitleStrColor", "getMainTitleStrSize", "getSecondTitleString", "getSecondTitleStrColor", "getSecondTitleStrSize", "getMiddleImageResId", "getMiddleImageStyle2ResId", "getMiddleImageStyle3ResId", "getPositiveBtnText", "getPositiveBtnTextColor", "getPositiveBtnResId", "getPositiveBtnTextSize", "getNegativeBtnText", "getNegativeBtnTextColor", "getNegativeBtnTextSize", "getNegativeBtnResId", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PraiseDialogUIConfigImpl implements IPraiseDialogUIConfig {
    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getMainBackgroundResId() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getMainTitleStrColor() {
        return null;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getMainTitleStrSize() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getMiddleImageResId() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getMiddleImageStyle2ResId() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getMiddleImageStyle3ResId() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getNegativeBtnResId() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getNegativeBtnTextColor() {
        return "#000000";
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getNegativeBtnTextSize() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getPositiveBtnTextColor() {
        return null;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getPositiveBtnTextSize() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getSecondTitleStrColor() {
        return null;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getSecondTitleStrSize() {
        return 0;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getMainTitleString() {
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = AppHost.Companion.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return i18nTextProvider.getString(resources, C0882R.string.trae_praise_title, new Object[0]);
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getSecondTitleString() {
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = AppHost.Companion.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return i18nTextProvider.getString(resources, C0882R.string.trae_praise_subtitle, new Object[0]);
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getPositiveBtnText() {
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = AppHost.Companion.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return i18nTextProvider.getString(resources, C0882R.string.trae_praise_positive_btn, new Object[0]);
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public int getPositiveBtnResId() {
        return com.bytedance.trae.common_ui.R.color.trae_bg_bg_brand;
    }

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig
    public String getNegativeBtnText() {
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = AppHost.Companion.getApplication().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return i18nTextProvider.getString(resources, C0882R.string.trae_praise_negative_btn, new Object[0]);
    }
}
