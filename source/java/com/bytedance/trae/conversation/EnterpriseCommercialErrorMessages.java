package com.bytedance.trae.conversation;

import android.content.res.Resources;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseCommercialErrorMessages.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/EnterpriseCommercialErrorMessages;", "", "<init>", "()V", "TEAM_GROUP", "", "TEAM_GROUP_V2", "TEAM_FLAGSHIP", "TEAM_FLAGSHIP_V2", "TEAM_DEFAULT_PARALLEL_LIMIT", "FLAGSHIP_DEFAULT_PARALLEL_LIMIT", "parallelLimitMessage", "", "resources", "Landroid/content/res/Resources;", "limit", "(Landroid/content/res/Resources;Ljava/lang/Integer;)Ljava/lang/String;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EnterpriseCommercialErrorMessages {
    private static final int FLAGSHIP_DEFAULT_PARALLEL_LIMIT = 20;
    public static final EnterpriseCommercialErrorMessages INSTANCE = new EnterpriseCommercialErrorMessages();
    private static final int TEAM_DEFAULT_PARALLEL_LIMIT = 10;
    private static final int TEAM_FLAGSHIP = 230;
    private static final int TEAM_FLAGSHIP_V2 = 231;
    private static final int TEAM_GROUP = 220;
    private static final int TEAM_GROUP_V2 = 221;

    private EnterpriseCommercialErrorMessages() {
    }

    public static /* synthetic */ String parallelLimitMessage$default(EnterpriseCommercialErrorMessages enterpriseCommercialErrorMessages, Resources resources, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return enterpriseCommercialErrorMessages.parallelLimitMessage(resources, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String parallelLimitMessage(Resources resources, Integer limit) {
        boolean z;
        int i;
        int i2;
        AccountInfo accountInfo;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (!LoginUtils.INSTANCE.isEnterpriseLogin()) {
            return null;
        }
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        int productType = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? 0 : accountInfo.getProductType();
        if (productType == TEAM_GROUP || productType == TEAM_GROUP_V2) {
            z = true;
        } else {
            if (productType != TEAM_FLAGSHIP) {
            }
            z = false;
        }
        if (limit != null) {
            if (!(limit.intValue() > 0)) {
                limit = null;
            }
            if (limit != null) {
                i = limit.intValue();
                if (!z) {
                    i2 = com.bytedance.trae.multilanguage.R.string.imkit_error_enterprise_parallel_limit_team;
                } else {
                    i2 = com.bytedance.trae.multilanguage.R.string.imkit_error_enterprise_parallel_limit_flagship;
                }
                return I18nTextProvider.INSTANCE.getString(resources, i2, new Object[]{Integer.valueOf(i)});
            }
        }
        i = z ? 10 : 20;
        if (!z) {
        }
        return I18nTextProvider.INSTANCE.getString(resources, i2, new Object[]{Integer.valueOf(i)});
    }
}
