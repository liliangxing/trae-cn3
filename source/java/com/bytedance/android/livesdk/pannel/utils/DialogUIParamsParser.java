package com.bytedance.android.livesdk.pannel.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.android.livesdk.pannel.params.DialogUIParam;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogUIParamsParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/utils/DialogUIParamsParser;", "", "()V", "parseUiParams", "Landroid/graphics/drawable/Drawable;", RemoteMessageConst.MessageBody.PARAM, "Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam;", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DialogUIParamsParser {
    public static final DialogUIParamsParser INSTANCE = new DialogUIParamsParser();

    private DialogUIParamsParser() {
    }

    public final Drawable parseUiParams(DialogUIParam param) {
        Intrinsics.checkParameterIsNotNull(param, "param");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(param.getBackGroundColor());
        float radius = param.getRadius();
        gradientDrawable.setCornerRadii(new float[]{radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }
}
