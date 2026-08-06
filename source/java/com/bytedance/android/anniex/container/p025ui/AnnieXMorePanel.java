package com.bytedance.android.anniex.container.p025ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.data.ICopyData;
import com.bytedance.android.anniex.base.data.IReportData;
import com.bytedance.android.anniex.base.service.AnnieXActionService;
import com.bytedance.android.anniex.base.service.AnnieXUIService;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
import com.bytedance.ies.argus.aspect.eventCenter.WebViewContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXMorePanel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXMorePanel;", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanel;", "()V", "constructButtons", "", "Lcom/bytedance/android/anniex/base/service/AnnieXUIService$MorePanelButton;", "context", "Landroid/content/Context;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createCopyLinkButton", "createOpenBrowserButton", "createRefreshButton", "createReportButton", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXMorePanel extends AnnieXUIService.MorePanel {
    private static final String BUTTON_KEY_COPY_LINK = "copy";
    private static final String BUTTON_KEY_OPEN_BROWSER = "open_browser";
    private static final String BUTTON_KEY_REFRESH = "refresh";
    private static final String BUTTON_KEY_REPORT = "report";

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.MorePanel
    public List<AnnieXUIService.MorePanelButton> constructButtons(Context context, IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        if (IConditionCallKt.enableSecLinkReportEntry()) {
            return CollectionsKt.listOf(new AnnieXUIService.MorePanelButton[]{createRefreshButton(context, container), createCopyLinkButton(context, container), createReportButton(context, container), createOpenBrowserButton(context, container)});
        }
        return CollectionsKt.listOf(new AnnieXUIService.MorePanelButton[]{createRefreshButton(context, container), createCopyLinkButton(context, container), createOpenBrowserButton(context, container)});
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.MorePanel
    public AnnieXUIService.MorePanelButton createRefreshButton(Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        return new AnnieXUIService.MorePanelButton(BUTTON_KEY_REFRESH, C0840R.string.annie_x_button_label_refresh, C0840R.drawable.more_panel_refresh_btn, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXMorePanel$createRefreshButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3307invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3307invoke() {
                IContainer.DefaultImpls.reload$default(IContainer.this, null, 1, null);
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.MorePanel
    public AnnieXUIService.MorePanelButton createCopyLinkButton(final Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        return new AnnieXUIService.MorePanelButton(BUTTON_KEY_COPY_LINK, C0840R.string.annie_x_button_label_copy_link, C0840R.drawable.more_panel_copylink_btn, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXMorePanel$createCopyLinkButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3305invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3305invoke() {
                AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(IContainer.this.getBid(), AnnieXActionService.class);
                if (annieXActionService != null) {
                    annieXActionService.copy(context, new ICopyData.CopyDataBuilder().setText(IContainer.this.getCurrentUrl()).build());
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.MorePanel
    public AnnieXUIService.MorePanelButton createReportButton(final Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        return new AnnieXUIService.MorePanelButton(BUTTON_KEY_REPORT, C0840R.string.annie_x_button_label_report, C0840R.drawable.more_panel_report_btn, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXMorePanel$createReportButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3308invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3308invoke() {
                ArgusWebDelegateAdapter argusAdapter$anniex_release;
                ArgusWebDelegate innerDelegate;
                WebViewContext viewContext$anniex_release;
                ContainerContext argusContext$anniex_release;
                ContainerContext argusContext$anniex_release2;
                BulletContext bulletContext;
                ContextProviderFactory contextProviderFactory = IContainer.this.getContextProviderFactory();
                String str = null;
                ArgusContainerDelegate argusContainerDelegate = (contextProviderFactory == null || (bulletContext = (BulletContext) contextProviderFactory.provideInstance(BulletContext.class)) == null) ? null : bulletContext.getArgusContainerDelegate();
                String traceId = (argusContainerDelegate == null || (argusContext$anniex_release2 = argusContainerDelegate.getArgusContext$anniex_release()) == null) ? null : argusContext$anniex_release2.getTraceId();
                String secLinkScene = (argusContainerDelegate == null || (argusContext$anniex_release = argusContainerDelegate.getArgusContext$anniex_release()) == null) ? null : argusContext$anniex_release.getSecLinkScene();
                SSWebView kitView = IContainer.this.getKitView();
                SSWebView sSWebView = kitView instanceof SSWebView ? kitView : null;
                if (sSWebView != null && (argusAdapter$anniex_release = sSWebView.getArgusAdapter$anniex_release()) != null && (innerDelegate = argusAdapter$anniex_release.getInnerDelegate()) != null && (viewContext$anniex_release = innerDelegate.getViewContext$anniex_release()) != null) {
                    str = viewContext$anniex_release.getTraceId();
                }
                AnnieXActionService annieXActionService = ServiceCenter.Companion.instance().get(IContainer.this.getBid(), AnnieXActionService.class);
                if (annieXActionService != null) {
                    annieXActionService.report(context, new IReportData.ReportDataBuilder().setUrl(IContainer.this.getCurrentUrl()).setContainerTraceId(traceId).setViewTraceId(str).setScene(secLinkScene).setSessionId(IContainer.this.getContainerId()).build());
                }
            }
        });
    }

    @Override // com.bytedance.android.anniex.base.service.AnnieXUIService.MorePanel
    public AnnieXUIService.MorePanelButton createOpenBrowserButton(final Context context, final IContainer container) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        return new AnnieXUIService.MorePanelButton(BUTTON_KEY_OPEN_BROWSER, C0840R.string.annie_x_button_label_open_browser, C0840R.drawable.more_panel_browser_btn, new Function0<Unit>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXMorePanel$createOpenBrowserButton$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3306invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3306invoke() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(IContainer.this.getCurrentUrl()));
                intent.addFlags(268435456);
                intent.addCategory("android.intent.category.BROWSABLE");
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    Context context2 = context;
                    intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                    context2.startActivity(intent);
                }
            }
        });
    }
}
