package com.bytedance.trae.conversation.settings;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* compiled from: IConversationListSettings.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;", "", "<init>", "()V", "TAG", "", "DEFAULT_PAGE_SIZE", "", "cachedPageSize", "Ljava/lang/Integer;", "getPageSize", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationListSettingsService {
    private static final int DEFAULT_PAGE_SIZE = 300;
    public static final ConversationListSettingsService INSTANCE = new ConversationListSettingsService();
    private static final String TAG = "ConversationListSettings";
    private static volatile Integer cachedPageSize;

    private ConversationListSettingsService() {
    }

    public final int getPageSize() {
        Object obj;
        int i;
        Integer intOrNull;
        Integer num = cachedPageSize;
        if (num != null) {
            return num.intValue();
        }
        try {
            Result.Companion companion = Result.Companion;
            ConversationListSettingsService conversationListSettingsService = this;
            IConversationListSettings iConversationListSettings = (IConversationListSettings) SettingsManager.obtain(IConversationListSettings.class);
            obj = Result.constructor-impl(iConversationListSettings != null ? iConversationListSettings.getConversationListPageSize() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            TraeLogUtil.INSTANCE.w(TAG, "obtain conversation_list_page_size settings failed", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
            Integer num2 = intOrNull.intValue() > 0 ? intOrNull : null;
            if (num2 != null) {
                i = num2.intValue();
                cachedPageSize = Integer.valueOf(i);
                return i;
            }
        }
        i = 300;
        cachedPageSize = Integer.valueOf(i);
        return i;
    }
}
