package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.multilanguage.I18nLanguage;
import com.bytedance.trae.multilanguage.StarlingOnlineTextConfig;
import com.bytedance.trae.multilanguage.StarlingOnlineTextUpdater;
import com.bytedance.trae.network.TraeTTNet;
import com.bytedance.trae.utils.AppLocaleUtils;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: InitStarlingOnlineTextTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001\u000bB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitStarlingOnlineTextTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String STARLING_APP_KEY = "371d23c04dd711f1a159f17d708204a2";

    @Deprecated
    public static final String STARLING_MAINLAND_NAMESPACE = "errorCodes_cn";

    @Deprecated
    public static final String STARLING_MAINLAND_ZONE_HOST = "https://starling.zijieapi.com";

    @Deprecated
    public static final String STARLING_NORMAL_MODE = "normal";

    @Deprecated
    public static final String STARLING_OFFLINE_MODE = "offline";

    @Deprecated
    public static final String STARLING_OVERSEA_NAMESPACE = "errorCodes_i18n";

    @Deprecated
    public static final String STARLING_OVERSEA_ZONE_HOST = "https://starling-oversea.byteoversea.com";

    @Deprecated
    public static final String TAG = "StarlingOnlineText";

    @Deprecated
    public static final boolean USE_STARLING_OFFLINE_MODE = false;
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
        final boolean isOversea = AppHost.INSTANCE.isOversea();
        final String str = isOversea ? STARLING_OVERSEA_NAMESPACE : STARLING_MAINLAND_NAMESPACE;
        final I18nLanguage fromLocale = I18nLanguage.Companion.fromLocale(AppLocaleUtils.INSTANCE.getAppLocale());
        TraeLogUtil.INSTANCE.i(TAG, "init task scheduled: waitTtnetReady=true, isOversea=" + isOversea + ", mode=normal, namespace=" + str + ", language=" + fromLocale.getCode() + ", cronetReady=" + TraeTTNet.INSTANCE.isCronetInitSuccess());
        final String str2 = "normal";
        TraeTTNet.INSTANCE.runAfterCronetInit(new Function0() { // from class: com.bytedance.trae.init.task.InitStarlingOnlineTextTask$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit runInternal$lambda$0;
                runInternal$lambda$0 = InitStarlingOnlineTextTask.runInternal$lambda$0(str, fromLocale, isOversea, str2);
                return runInternal$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runInternal$lambda$0(String str, I18nLanguage i18nLanguage, boolean z, String str2) {
        TraeLogUtil.INSTANCE.i(TAG, "refresh start trigger: reason=ttnet_ready, namespace=" + str + ", language=" + i18nLanguage.getCode());
        StarlingOnlineTextUpdater.refreshAll$default(StarlingOnlineTextUpdater.INSTANCE, AppHost.INSTANCE.getApplication(), new StarlingOnlineTextConfig(STARLING_APP_KEY, str, z ? STARLING_OVERSEA_ZONE_HOST : STARLING_MAINLAND_ZONE_HOST, str2, CollectionsKt.emptyList()), CollectionsKt.listOf(i18nLanguage), (Function1) null, (Function2) null, 24, (Object) null);
        return Unit.INSTANCE;
    }

    /* compiled from: InitStarlingOnlineTextTask.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/init/task/InitStarlingOnlineTextTask$Companion;", "", "<init>", "()V", "TAG", "", "STARLING_APP_KEY", "STARLING_MAINLAND_NAMESPACE", "STARLING_OVERSEA_NAMESPACE", "USE_STARLING_OFFLINE_MODE", "", "STARLING_NORMAL_MODE", "STARLING_OFFLINE_MODE", "STARLING_MAINLAND_ZONE_HOST", "STARLING_OVERSEA_ZONE_HOST", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
