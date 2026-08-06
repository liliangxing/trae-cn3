package com.bytedance.trae.init.task;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.common.activity.SimpleWebViewActivity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.init.markdown.CMarkInjectParser;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.larus.business.markdown.api.MarkdownService;
import com.larus.business.markdown.api.depend.IMarkdownConfig;
import com.larus.business.markdown.api.depend.IMarkdownSettings;
import com.larus.business.markdown.api.depend.LinkResolverWithStyle;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InitMarkdownTask.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/init/task/InitMarkdownTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "isBlockedLink", "", "link", "openLink", "view", "Landroid/view/View;", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitMarkdownTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    private final String scene = ServiceType.BASIC_TEC;

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public boolean checkFirstStartAsyncTaskInit(String str) {
        return IInitReportTask.DefaultImpls.checkFirstStartAsyncTaskInit(this, str);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getFirstStyle() {
        return IInitReportTask.DefaultImpls.getFirstStyle(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask, java.lang.Runnable
    public void run() {
        IInitReportTask.DefaultImpls.run(this);
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public String getScene() {
        return this.scene;
    }

    @Override // com.bytedance.trae.init.task.base.IInitReportTask
    public void runInternal() {
        Application application = AppHost.INSTANCE.getApplication();
        MarkdownService service = MarkdownService.Companion.getService();
        if (service != null) {
            service.init(application, new IMarkdownConfig() { // from class: com.bytedance.trae.init.task.InitMarkdownTask$runInternal$1$1
                public IMarkdownSettings getMarkdownSettings() {
                    return null;
                }
            });
            service.registerInjectParser(CMarkInjectParser.INSTANCE);
            service.registerLinkResolver(new LinkResolverWithStyle() { // from class: com.bytedance.trae.init.task.InitMarkdownTask$runInternal$1$2
                public boolean enableLinkColor(String url) {
                    Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
                    return false;
                }

                public int getLinkColor(String url) {
                    Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
                    return 0;
                }

                public boolean needUnderline(String link) {
                    Intrinsics.checkNotNullParameter(link, "link");
                    return false;
                }

                public void resolve(View view, String link) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(link, "link");
                    InitMarkdownTask.this.openLink(view, link);
                }

                public void resolve(View view, String link, boolean enableLinkStyle) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(link, "link");
                    if (enableLinkStyle) {
                        InitMarkdownTask.this.openLink(view, link);
                    }
                }

                public boolean enableLinkStyle(String link) {
                    boolean isBlockedLink;
                    Intrinsics.checkNotNullParameter(link, "link");
                    isBlockedLink = InitMarkdownTask.this.isBlockedLink(link);
                    return !isBlockedLink;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBlockedLink(String link) {
        String lowerCase = link.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (!StringsKt.startsWith$default(lowerCase, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(lowerCase, "https://", false, 2, (Object) null)) {
            return true;
        }
        try {
            String host = Uri.parse(link).getHost();
            if (host != null) {
                String lowerCase2 = host.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (lowerCase2 != null) {
                    return Intrinsics.areEqual(lowerCase2, "127.0.0.1") || Intrinsics.areEqual(lowerCase2, "localhost") || Intrinsics.areEqual(lowerCase2, "0.0.0.0") || Intrinsics.areEqual(lowerCase2, "::1");
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openLink(View view, String link) {
        if (!StringsKt.isBlank(link) && !isBlockedLink(link)) {
            try {
                SimpleWebViewActivity.Companion companion = SimpleWebViewActivity.INSTANCE;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                companion.start(context, link, true);
            } catch (Exception unused) {
            }
        }
    }
}
