package com.bytedance.android.anniex.base.service;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXUIService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXUIService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "()V", "createLoadingView", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$LoadingView;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createMorePanel", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanel;", "createTitleBar", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$TitleBar;", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "LoadingView", "MorePanel", "MorePanelButton", "TitleBar", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXUIService extends BaseBulletService {

    /* compiled from: AnnieXUIService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXUIService$LoadingView;", "", "()V", "constructUi", "Landroid/view/View;", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "updateProgress", "", NotificationCompat.CATEGORY_PROGRESS, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class LoadingView {
        public View constructUi(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public void updateProgress(int progress) {
        }
    }

    /* compiled from: AnnieXUIService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXUIService$TitleBar;", "", "()V", "constructUi", "Landroid/view/View;", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createBackButton", "createCloseButton", "createMoreButton", "createSearchButton", "createTitleView", "setTitle", "", "title", "", "showCloseButton", "visible", "", "showOrHideRightButtonLayout", "show", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class TitleBar {
        public View constructUi(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public View createBackButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public View createCloseButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public View createMoreButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public View createSearchButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public View createTitleView(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public void setTitle(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
        }

        public void showCloseButton(boolean visible) {
        }

        public void showOrHideRightButtonLayout(boolean show) {
        }
    }

    public TitleBar createTitleBar(ContextProviderFactory contextProviderFactory, IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        AnnieXUIService annieXUIService = ServiceCenter.Companion.instance().get(AnnieXUIService.class);
        if (annieXUIService != null) {
            return annieXUIService.createTitleBar(contextProviderFactory, container);
        }
        return null;
    }

    public LoadingView createLoadingView(IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        AnnieXUIService annieXUIService = ServiceCenter.Companion.instance().get(AnnieXUIService.class);
        if (annieXUIService != null) {
            return annieXUIService.createLoadingView(container);
        }
        return null;
    }

    /* compiled from: AnnieXUIService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "", "key", "", "labelId", "", "drawableId", "clickListener", "Lkotlin/Function0;", "", "(Ljava/lang/String;IILkotlin/jvm/functions/Function0;)V", "getDrawableId", "getKey", "getLabelId", "onClick", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class MorePanelButton {
        private final Function0<Unit> clickListener;
        private final int drawableId;
        private final String key;
        private final int labelId;

        public MorePanelButton(String str, int i, int i2, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(function0, "clickListener");
            this.key = str;
            this.labelId = i;
            this.drawableId = i2;
            this.clickListener = function0;
        }

        public final String getKey() {
            return this.key;
        }

        public final int getLabelId() {
            return this.labelId;
        }

        public final int getDrawableId() {
            return this.drawableId;
        }

        public final void onClick() {
            this.clickListener.invoke();
        }
    }

    /* compiled from: AnnieXUIService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanel;", "", "()V", "constructButtons", "", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createCopyLinkButton", "createOpenBrowserButton", "createRefreshButton", "createReportButton", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class MorePanel {
        public MorePanelButton createCopyLinkButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public MorePanelButton createOpenBrowserButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public MorePanelButton createRefreshButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public MorePanelButton createReportButton(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return null;
        }

        public List<MorePanelButton> constructButtons(Context context, IContainer container) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(container, "container");
            return CollectionsKt.emptyList();
        }
    }

    public MorePanel createMorePanel(IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        AnnieXUIService annieXUIService = ServiceCenter.Companion.instance().get(AnnieXUIService.class);
        if (annieXUIService != null) {
            return annieXUIService.createMorePanel(container);
        }
        return null;
    }
}
