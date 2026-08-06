package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.praisedialoglib.manager.PraiseSdkManager;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.init.task.base.IInitReportTask;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.praise.PraiseDialogConfigImpl;
import com.bytedance.trae.praise.PraiseDialogHelper;
import com.bytedance.trae.praise.PraiseDialogTrigger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* compiled from: InitPraiseDialogTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/init/task/InitPraiseDialogTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/bytedance/trae/init/task/base/IInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "checkOldUserIfNeeded", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitPraiseDialogTask implements IInitTask, IInitReportTask {
    public static final int $stable = 0;
    private final String scene = ServiceType.BASIC_SERVICE;

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
        PraiseSdkManager.getInstance().init(new PraiseDialogConfigImpl(), AppHost.INSTANCE.getApplication());
        PraiseDialogHelper.INSTANCE.registerSettingsListener();
        checkOldUserIfNeeded();
    }

    private final void checkOldUserIfNeeded() {
        if (PraiseDialogTrigger.INSTANCE.isOldUserDetermined()) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bytedance.trae.init.task.InitPraiseDialogTask$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InitPraiseDialogTask.checkOldUserIfNeeded$lambda$2(InitPraiseDialogTask.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkOldUserIfNeeded$lambda$2(InitPraiseDialogTask initPraiseDialogTask) {
        String str;
        Object obj;
        AccountInfo accountInfo;
        try {
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
                str = "anonymous";
            }
            ConversationDao conversationDao = new ConversationDao(DatabaseManager.INSTANCE.getDatabase(AppHost.INSTANCE.getApplication(), str));
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(conversationDao.queryAll());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                obj = CollectionsKt.emptyList();
            }
            PraiseDialogHelper.INSTANCE.setHasTaskHistory(!((List) obj).isEmpty());
        } catch (Exception unused) {
        }
    }
}
