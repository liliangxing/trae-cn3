package com.bytedance.android.livesdk.pannel.params;

import android.content.Context;
import com.bytedance.android.livesdk.pannel.R;
import com.bytedance.android.livesdk.pannel.utils.UIUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogUIParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0019\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam;", "", "backGroundColor", "", "radius", "(II)V", "getBackGroundColor", "()I", "setBackGroundColor", "(I)V", "getRadius", "setRadius", "Builder", "Companion", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DialogUIParam {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int backGroundColor;
    private int radius;

    private DialogUIParam(int i, int i2) {
        this.backGroundColor = i;
        this.radius = i2;
    }

    public /* synthetic */ DialogUIParam(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    public final int getBackGroundColor() {
        return this.backGroundColor;
    }

    public final void setBackGroundColor(int i) {
        this.backGroundColor = i;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final void setRadius(int i) {
        this.radius = i;
    }

    /* compiled from: DialogUIParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\bJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam$Companion;", "", "()V", "build", "Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam;", "block", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam$Builder;", "", "Lkotlin/ExtensionFunctionType;", "getStandardParam", "context", "Landroid/content/Context;", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DialogUIParam build(Function1<? super Builder, Unit> block) {
            Intrinsics.checkParameterIsNotNull(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }

        public final DialogUIParam getStandardParam(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Builder builder = new Builder();
            builder.setBackGroundColor(context.getResources().getColor(R.color.ttlive_dialog_standard_bg));
            builder.setRadius((int) UIUtils.dip2Px(context, 8));
            return builder.build();
        }
    }

    /* compiled from: DialogUIParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam$Builder;", "", "()V", "backGroundColor", "", "getBackGroundColor", "()I", "setBackGroundColor", "(I)V", "radius", "getRadius", "setRadius", "build", "Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam;", "panel_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class Builder {
        private int backGroundColor;
        private int radius;

        public final int getBackGroundColor() {
            return this.backGroundColor;
        }

        public final void setBackGroundColor(int i) {
            this.backGroundColor = i;
        }

        public final int getRadius() {
            return this.radius;
        }

        public final void setRadius(int i) {
            this.radius = i;
        }

        public final DialogUIParam build() {
            return new DialogUIParam(this.backGroundColor, this.radius, null);
        }
    }
}
