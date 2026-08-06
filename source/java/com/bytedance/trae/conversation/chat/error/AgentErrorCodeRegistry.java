package com.bytedance.trae.conversation.chat.error;

import android.content.res.Resources;
import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.conversation.EnterpriseCommercialErrorMessages;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: AgentErrorCodeRegistry.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002J\u001c\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002J$\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002JK\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ+\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001cJ5\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\tJ\u001a\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u001d\u0010#\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\tH\u0002J\u001d\u0010'\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0002\u0010(J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0**\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050,X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b-\u0010\u0003¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry;", "", "<init>", "()V", "DEFAULT_CONFIG", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeConfig;", "CODE_FREE_ACTIVITY_QUOTA_EXHAUSTED", "", "ERROR_CODE_I18N_PREFIX", "", "sanitizeDataType", DBData.FIELD_TYPE, "buildErrorCodeI18nKey", "code", "dataType", "config", "resources", "Landroid/content/res/Resources;", "displayMessage", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;", "originMessage", "data", "Lcom/google/gson/JsonObject;", "resolvedDataType", "creditsFeatureEnabled", "", "(Landroid/content/res/Resources;Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/String;Z)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;", "buildEnterpriseCommercialDisplay", "(Landroid/content/res/Resources;Ljava/lang/Integer;Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;", "buildModelUnavailableDisplay", "(Landroid/content/res/Resources;Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;", "contentSecurityBlockedMessage", "ruleName", "buildInternalUsageLimitMessage", "isInternalUser", "readBoolean", "key", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "readString", "readInt", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "readStringList", "", "CONFIG_MAP", "", "getCONFIG_MAP$annotations", "DisplayResult", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentErrorCodeRegistry {
    public static final int CODE_FREE_ACTIVITY_QUOTA_EXHAUSTED = 4031;
    private static final Map<Integer, AgentErrorCodeConfig> CONFIG_MAP;
    private static final String ERROR_CODE_I18N_PREFIX = "icube_error_code_";
    public static final AgentErrorCodeRegistry INSTANCE = new AgentErrorCodeRegistry();
    private static final AgentErrorCodeConfig DEFAULT_CONFIG = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_default), "Unknown error", false, 8, null);

    private static /* synthetic */ void getCONFIG_MAP$annotations() {
    }

    private AgentErrorCodeRegistry() {
    }

    /* compiled from: AgentErrorCodeRegistry.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/AgentErrorCodeRegistry$DisplayResult;", "", "message", "", "level", "Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "title", "showInfoIcon", "", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;Ljava/lang/String;Z)V", "getMessage", "()Ljava/lang/String;", "getLevel", "()Lcom/bytedance/trae/conversation/chat/error/AgentErrorLevel;", "getTitle", "getShowInfoIcon", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class DisplayResult {
        private final AgentErrorLevel level;
        private final String message;
        private final boolean showInfoIcon;
        private final String title;

        public static /* synthetic */ DisplayResult copy$default(DisplayResult displayResult, String str, AgentErrorLevel agentErrorLevel, String str2, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = displayResult.message;
            }
            if ((i & 2) != 0) {
                agentErrorLevel = displayResult.level;
            }
            if ((i & 4) != 0) {
                str2 = displayResult.title;
            }
            if ((i & 8) != 0) {
                z = displayResult.showInfoIcon;
            }
            return displayResult.copy(str, agentErrorLevel, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final AgentErrorLevel getLevel() {
            return this.level;
        }

        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getShowInfoIcon() {
            return this.showInfoIcon;
        }

        public final DisplayResult copy(String message, AgentErrorLevel level, String title, boolean showInfoIcon) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(level, "level");
            return new DisplayResult(message, level, title, showInfoIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisplayResult)) {
                return false;
            }
            DisplayResult displayResult = (DisplayResult) other;
            return Intrinsics.areEqual(this.message, displayResult.message) && this.level == displayResult.level && Intrinsics.areEqual(this.title, displayResult.title) && this.showInfoIcon == displayResult.showInfoIcon;
        }

        public int hashCode() {
            int hashCode = ((this.message.hashCode() * 31) + this.level.hashCode()) * 31;
            String str = this.title;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.showInfoIcon);
        }

        public String toString() {
            return "DisplayResult(message=" + this.message + ", level=" + this.level + ", title=" + this.title + ", showInfoIcon=" + this.showInfoIcon + ')';
        }

        public DisplayResult(String str, AgentErrorLevel agentErrorLevel, String str2, boolean z) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(agentErrorLevel, "level");
            this.message = str;
            this.level = agentErrorLevel;
            this.title = str2;
            this.showInfoIcon = z;
        }

        public /* synthetic */ DisplayResult(String str, AgentErrorLevel agentErrorLevel, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, agentErrorLevel, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? false : z);
        }

        public final String getMessage() {
            return this.message;
        }

        public final AgentErrorLevel getLevel() {
            return this.level;
        }

        public final String getTitle() {
            return this.title;
        }

        public final boolean getShowInfoIcon() {
            return this.showInfoIcon;
        }
    }

    static {
        Map createMapBuilder = MapsKt.createMapBuilder();
        AgentErrorCodeConfig agentErrorCodeConfig = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_default), "Unknown error", false, 8, null);
        Iterator it = CollectionsKt.listOf(new Integer[]{-2, 10, 11, 12, 13, 14}).iterator();
        while (it.hasNext()) {
            createMapBuilder.put(Integer.valueOf(((Number) it.next()).intValue()), agentErrorCodeConfig);
        }
        createMapBuilder.put(-1, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_server_crash), "Server error. Please try again later.", false, 8, null));
        createMapBuilder.put(999, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_network), "Request service failed, please check your network configuration and try again.", false, 8, null));
        createMapBuilder.put(998, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_network_internal), "Request service failed, please check if you are in an intranet environment and try again.", false, 8, null));
        createMapBuilder.put(997, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_client_network), "Request service failed, please check your network configuration and try again.", false, 8, null));
        createMapBuilder.put(996, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_client_network_internal), "Request service failed, please check if you are in an intranet environment and try again.", false, 8, null));
        createMapBuilder.put(995, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_request_timeout), "Request service timeout, please check your network configuration and try again.", false, 8, null));
        createMapBuilder.put(994, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_request_timeout_internal), "Request service timeout, please check if you are in an intranet environment and try again.", false, 8, null));
        createMapBuilder.put(993, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_response_timeout), "Model response timeout, please try again later.", false, 8, null));
        createMapBuilder.put(992, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_response_failed), "Model response failed, please try again later.", false, 8, null));
        createMapBuilder.put(978, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_auto_selection_failed), "Model response failed, please try again later.", false, 8, null));
        createMapBuilder.put(976, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_os_suspend_timeout), "Request timed out, possibly due to network interruption caused by the device screen turning off.", false, 8, null));
        createMapBuilder.put(975, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_network_changed), "Your network has changed. Please try again after the network stabilizes.", false, 8, null));
        createMapBuilder.put(974, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_network_disconnected), "Your network connection has been disconnected. Please reconnect and try again.", false, 8, null));
        createMapBuilder.put(1006, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_connection), "Network error, please check your network configuration and try again.", false, 8, null));
        createMapBuilder.put(700, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_firewall_blocked), "Request blocked by current network. Please check your network proxy or contact your network administrator.", false, 8, null));
        createMapBuilder.put(980, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_proxy_connect), "Service request failed, please check the system network proxy settings and try again.", false, 8, null));
        createMapBuilder.put(1001, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_invalid_token), "Authentication error, please log in again and try again.", false, 8, null));
        createMapBuilder.put(1002, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_auth_fail), "Authentication failed. Please log in again and retry.", false, 8, null));
        createMapBuilder.put(1003, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_password_changed), "Your session has expired due to a password change. Please log in again.", false, 8, null));
        createMapBuilder.put(4010, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_abnormal_account_logout), "Risky account detected. You have been automatically logged out.", false, 8, null));
        createMapBuilder.put(4011, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_abnormal_account_limit), "AI Chat usage today has reached the limit.", false, 8, null));
        createMapBuilder.put(4014, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_account_deleted), "Your account has been deleted.", false, 8, null));
        createMapBuilder.put(3004, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_request_limit), "The model is experiencing high traffic, please try again later.", false, 8, null));
        createMapBuilder.put(4007, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_user_request_limit), "Request throttled. Please try again later.", false, 8, null));
        createMapBuilder.put(4008, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.trae_agent_error_premium_usage_limit), "Your current usage has been exhausted, and you’re temporarily unable to continue the conversation.", false, 8, null));
        createMapBuilder.put(4009, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_standard_usage_limit), "Request throttled. Please try again later.", false, 8, null));
        createMapBuilder.put(4021, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_today_request_limit), "The number of sessions today has reached the upper limit, please come back tomorrow.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig2 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_queue_timeout), "The request has timed out. Please try again later.", false, 8, null);
        createMapBuilder.put(4050, agentErrorCodeConfig2);
        createMapBuilder.put(4051, agentErrorCodeConfig2);
        createMapBuilder.put(4052, agentErrorCodeConfig2);
        createMapBuilder.put(5003, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_out_of_quota), "Request throttled. Please try again later.", false, 8, null));
        createMapBuilder.put(977, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_premium_quota_drained), "You've used up your Premium model request quota.", false, 8, null));
        createMapBuilder.put(Integer.valueOf(VcdNetConstants.API_VCD_GET_LOGIN_TICKET), new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_unknown), "Request failed. Please try again later.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig3 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_fail), "Model Request failed. Please try again later.", false, 8, null);
        createMapBuilder.put(3003, agentErrorCodeConfig3);
        createMapBuilder.put(4053, agentErrorCodeConfig3);
        createMapBuilder.put(4054, agentErrorCodeConfig3);
        createMapBuilder.put(4001, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_invalid_args), "Request failed. Please try again later.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig4 = new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_token_limit), "Request failed. Please create a new session and try again.", false, 8, null);
        createMapBuilder.put(4006, agentErrorCodeConfig4);
        createMapBuilder.put(4022, agentErrorCodeConfig4);
        createMapBuilder.put(4026, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_context_length_exceeded), "Context length has exceeded the maximum limit.", false, 8, null));
        createMapBuilder.put(Integer.valueOf(AccountErrorCode.ERROR_REUSED_MOBILE_CONFIRM), new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_not_existed), "Model list has been updated. Please confirm and try again.", false, 8, null));
        createMapBuilder.put(4024, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_existed), "Please don't add the same model more than once.", false, 8, null));
        createMapBuilder.put(991, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_return_empty), "Model has heavy traffic. Please try again later.", false, 8, null));
        createMapBuilder.put(987, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_model_output_too_long), "Output is too long, please enter 'Continue' to get more.", false, 8, null));
        createMapBuilder.put(1009, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_big_message), "Message too long, please optimize the input and try again.", false, 8, null));
        createMapBuilder.put(983, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_sensitive_content), "Message may contain sensitive words. Please check and resend.", false, 8, null));
        createMapBuilder.put(979, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_input_sensitive), "Your input may contain sensitive words. Please check and resend.", false, 8, null));
        createMapBuilder.put(4016, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_image_content_safety), "The picture contains sensitive content.", false, 8, null));
        createMapBuilder.put(4400, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_ai_feature_restricted), "The AI feature is restricted in the current workspace.", false, 8, null));
        createMapBuilder.put(4013, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_request_abnormal), "AI service is not available in the current region now.", false, 8, null));
        createMapBuilder.put(4012, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_request_downgrade), "Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(4015, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_risk_request), "Your request has been flagged for security review.", false, 8, null));
        createMapBuilder.put(4017, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_risk_request), "Your request has been flagged for security review.", false, 8, null));
        createMapBuilder.put(40142, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_abnormal_account_limit), "AI Chat usage today has reached the limit.", false, 8, null));
        createMapBuilder.put(985, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, null, "", true));
        createMapBuilder.put(984, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_custom_model_not_found), "Incorrect model name, please verify it matches the provider's name.", false, 8, null));
        createMapBuilder.put(4028, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, null, "Unknown error", true));
        createMapBuilder.put(5001, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_turn_exceeded), "The number of session turns has exceeded the upper limit, please try creating a new session.", false, 8, null));
        createMapBuilder.put(5002, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_timeout), "Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(5004, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_agent_busy), "Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(6004, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_intent_error), "Intent recognition failed. Please try again later.", false, 8, null));
        createMapBuilder.put(7000, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_not_support_multimedia), "The current model does not support questions containing images.", false, 8, null));
        createMapBuilder.put(7001, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_system_not_support_ai), "The current remote operating system version does not support AI features.", false, 8, null));
        createMapBuilder.put(7002, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_default), "Unknown error", false, 8, null));
        createMapBuilder.put(Integer.valueOf(AccountErrorCode.UNBIND_PHONE_ERROR), new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_solo_agent_exclusive), "This mode is exclusive to Pro users. Upgrade to unlock.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig5 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_llm_invalid_json), "An error occurred during model processing. Please try again or switch the model.", false, 8, null);
        createMapBuilder.put(4000003, agentErrorCodeConfig5);
        createMapBuilder.put(4000004, agentErrorCodeConfig5);
        createMapBuilder.put(4000005, new AgentErrorCodeConfig(AgentErrorLevel.INFO, Integer.valueOf(R.string.imkit_error_llm_queuing), "Too many current requests. Please wait in the queue.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig6 = new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_llm_loop_detected), "Loop was detected in the model and the request has been interrupted.", false, 8, null);
        createMapBuilder.put(4000009, agentErrorCodeConfig6);
        createMapBuilder.put(4000012, agentErrorCodeConfig6);
        createMapBuilder.put(4000010, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_llm_prompt_too_long), "The input is too long. Please shorten your input.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig7 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_task_timeout_expired), "Task timeout: Execution exceeded 24 hours.", false, 8, null);
        createMapBuilder.put(4000100, agentErrorCodeConfig7);
        createMapBuilder.put(4000101, agentErrorCodeConfig7);
        createMapBuilder.put(4000002, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_task_turn_exceeded), "Model thinking limit reached, please enter 'Continue' to get more.", false, 8, null));
        createMapBuilder.put(5000001, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_project_not_found), "Project error. Please reopen the project folder.", false, 8, null));
        createMapBuilder.put(1010002, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_client_unauthorized), "Authorization failed. Please log in again.", false, 8, null));
        createMapBuilder.put(13000000, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_tool_call_retry_limit), "Tool call failed due to model hallucination.", false, 8, null));
        createMapBuilder.put(4200, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_subscription_expired), "The enterprise subscription has expired.", false, 8, null));
        createMapBuilder.put(4201, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_seat_quota_billing_disabled), "The seat-included conversation quota has been reached. Please contact your administrator to activate pay-as-you-go services.", false, 8, null));
        createMapBuilder.put(4202, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_seat_quota_billing_insufficient), "The seat-included conversation quota has been reached. Please contact your administrator to check if the pay-as-you-go service is functioning properly.", false, 8, null));
        createMapBuilder.put(4203, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_seat_quota_limit_reached), "Your usage has reached the limit. Please contact your administrator to raise the pay-as-you-go quota.", false, 8, null));
        createMapBuilder.put(4213, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_enterprise_no_custom_model), "Not allowed to add custom models.", false, 8, null));
        createMapBuilder.put(4214, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_enterprise_account_not_exist), "Account does not exist.", false, 8, null));
        createMapBuilder.put(4215, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_enterprise_subscription_expired), "Enterprise subscription expired.", false, 8, null));
        createMapBuilder.put(4216, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_enterprise_session_expired), "Session expired. Please log in again.", false, 8, null));
        createMapBuilder.put(4220, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_model_usage_exhausted), "Model usage exhausted.", false, 8, null));
        createMapBuilder.put(4221, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_tenant_quota), "Enterprise quota limit reached.", false, 8, null));
        createMapBuilder.put(4222, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_user_quota), "Personal quota limit reached.", false, 8, null));
        createMapBuilder.put(4223, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_per_model_tenant_quota), "Enterprise per-model quota limit reached.", false, 8, null));
        createMapBuilder.put(4224, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_per_model_user_quota), "Personal per-model quota limit reached.", false, 8, null));
        createMapBuilder.put(4225, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_quota_config_invalid), "Per-user quota cannot exceed total quota.", false, 8, null));
        createMapBuilder.put(4232, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_enterprise_solo_subscription), "SOLO is not available in your current subscription plan.", false, 8, null));
        createMapBuilder.put(4237, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_enterprise_auto_mode_all_models_disabled), "All models supported by Auto mode have been disabled. Please contact your administrator.", false, 8, null));
        createMapBuilder.put(4113, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_claude_model_forbidden), "Claude series models are currently unavailable in Hong Kong and Macau.", false, 8, null));
        createMapBuilder.put(4120, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_cannot_use_solo_mode), "Can not use solo mode, please switch to dev mode.", false, 8, null));
        createMapBuilder.put(Integer.valueOf(CODE_FREE_ACTIVITY_QUOTA_EXHAUSTED), new AgentErrorCodeConfig(AgentErrorLevel.INFO, Integer.valueOf(R.string.imkit_error_free_activity_quota), "Let's call it a day. Get some rest and we'll pick this back up tomorrow!", false, 8, null));
        createMapBuilder.put(4032, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_free_activity_end), "The event has ended. Please try again.", false, 8, null));
        createMapBuilder.put(4035, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_paygo_arrears), "Account status abnormal. Unable to start tasks at this time.", false, 8, null));
        createMapBuilder.put(4036, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_invite_only), "Invite-only access. Redeem your invitation code.", false, 8, null));
        createMapBuilder.put(4027, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_invalid_tool_call), "The argument schema for mcp tool is incompatible with current model.", false, 8, null));
        AgentErrorCodeConfig agentErrorCodeConfig8 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_git_repo_not_found), "Repository info not found.", false, 8, null);
        createMapBuilder.put(991400, agentErrorCodeConfig8);
        createMapBuilder.put(991401, agentErrorCodeConfig8);
        AgentErrorCodeConfig agentErrorCodeConfig9 = new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_git_token_invalid), "Git token is invalid.", false, 8, null);
        createMapBuilder.put(991402, agentErrorCodeConfig9);
        createMapBuilder.put(991403, agentErrorCodeConfig9);
        createMapBuilder.put(991209, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_insufficient_resources), "Insufficient resources, please retry later.", false, 8, null));
        createMapBuilder.put(4050, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_model_overloaded), "Model overloaded, please retry later.", false, 8, null));
        createMapBuilder.put(992600, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_not_initialized), "VM manager is not initialized.", false, 8, null));
        createMapBuilder.put(992601, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_vm_not_running), "Lite VM is not running.", false, 8, null));
        createMapBuilder.put(992602, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_start_failed), "Failed to start Lite VM.", false, 8, null));
        createMapBuilder.put(992603, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_status_error), "Lite VM status error.", false, 8, null));
        createMapBuilder.put(992604, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_communication_error), "Failed to communicate with Lite VM.", false, 8, null));
        createMapBuilder.put(992605, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_invoke_error), "Lite VM invocation failed.", false, 8, null));
        createMapBuilder.put(992606, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_session_sync), "Lite VM session sync failed.", false, 8, null));
        createMapBuilder.put(992607, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_mount_error), "Lite VM mount failed.", false, 8, null));
        createMapBuilder.put(992608, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_config_error), "Lite VM configuration error.", false, 8, null));
        createMapBuilder.put(992609, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_vm_pending_task), "Lite VM has pending tasks.", false, 8, null));
        createMapBuilder.put(992610, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_vm_not_supported), "Lite VM is not supported.", false, 8, null));
        createMapBuilder.put(992611, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_packet_loss), "SOLO workspace event stream packet loss detected.", false, 8, null));
        createMapBuilder.put(992612, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_stream_disconnected), "SOLO workspace event stream disconnected.", false, 8, null));
        createMapBuilder.put(992613, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_stream_timeout), "SOLO workspace event stream timed out.", false, 8, null));
        createMapBuilder.put(992614, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_out_of_memory), "SOLO workspace failed to start due to insufficient memory.", false, 8, null));
        createMapBuilder.put(992615, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_dhcp_failed), "SOLO workspace DHCP failed.", false, 8, null));
        createMapBuilder.put(992616, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_vm_dns_proxy_failed), "SOLO workspace DNS Proxy failed.", false, 8, null));
        createMapBuilder.put(2000101, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_git_clone_failed), "GitHub Repository sync failed.", false, 8, null));
        createMapBuilder.put(2000102, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_git_clone_timeout), "GitHub Repository sync timed out.", false, 8, null));
        createMapBuilder.put(2000103, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_restic_restore_failed), "Data sync failed.", false, 8, null));
        createMapBuilder.put(2000104, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_restic_restore_timeout), "Data sync timed out.", false, 8, null));
        createMapBuilder.put(2000105, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_env_restore_failed), "Environment restore failed.", false, 8, null));
        createMapBuilder.put(2000106, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_env_restore_timeout), "Environment restore timed out.", false, 8, null));
        createMapBuilder.put(2000107, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_storage_error), "Task initialization failed.", false, 8, null));
        createMapBuilder.put(2000108, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_session_busy), "Task initialization failed.", false, 8, null));
        createMapBuilder.put(2000109, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_git_push_failed), "Code push failed. Changes may be lost.", false, 8, null));
        createMapBuilder.put(2000110, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_backup_failed), "Data backup failed. Changes may be lost.", false, 8, null));
        createMapBuilder.put(2000111, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_remote_history_restore_failed), "Task history restoration failed.", false, 8, null));
        createMapBuilder.put(5910000, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5910000), "Model Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(5910001, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5910001), "Model Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(5910002, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5910002), "Model Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(5910003, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5910003), "Model Request failed. Please try again later.", false, 8, null));
        createMapBuilder.put(5920000, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5920000), "Server error. Please try again later.", false, 8, null));
        createMapBuilder.put(5920001, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5920001), "Server error. Please try again later.", false, 8, null));
        createMapBuilder.put(5920002, new AgentErrorCodeConfig(AgentErrorLevel.ERROR, Integer.valueOf(R.string.imkit_error_5920002), "Server error. Please try again later.", false, 8, null));
        createMapBuilder.put(991502, new AgentErrorCodeConfig(AgentErrorLevel.WARN, Integer.valueOf(R.string.imkit_error_solo_parallel_limit), "Parallel tasks have reached the limit.", false, 8, null));
        CONFIG_MAP = MapsKt.build(createMapBuilder);
    }

    private final String sanitizeDataType(String r4) {
        String str = r4;
        return str == null || str.length() == 0 ? "" : new Regex("[^a-zA-Z0-9_]").replace(str, "");
    }

    static /* synthetic */ String buildErrorCodeI18nKey$default(AgentErrorCodeRegistry agentErrorCodeRegistry, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return agentErrorCodeRegistry.buildErrorCodeI18nKey(i, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022 A[Catch: all -> 0x0049, TryCatch #0 {all -> 0x0049, blocks: (B:3:0x000f, B:5:0x0016, B:10:0x0022, B:14:0x0032), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildErrorCodeI18nKey(int code, String dataType) {
        boolean z;
        String str = ERROR_CODE_I18N_PREFIX + code;
        try {
            String str2 = dataType;
            if (str2 != null && str2.length() != 0) {
                z = false;
                if (!z) {
                    return str;
                }
                String sanitizeDataType = sanitizeDataType(dataType);
                return sanitizeDataType.length() > 0 ? str + '_' + sanitizeDataType : str;
            }
            z = true;
            if (!z) {
            }
        } catch (Throwable unused) {
            return str;
        }
    }

    static /* synthetic */ AgentErrorCodeConfig config$default(AgentErrorCodeRegistry agentErrorCodeRegistry, Resources resources, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        return agentErrorCodeRegistry.config(resources, i, str);
    }

    private final AgentErrorCodeConfig config(Resources resources, int code, String dataType) {
        AgentErrorCodeConfig agentErrorCodeConfig = CONFIG_MAP.get(Integer.valueOf(code));
        if (agentErrorCodeConfig != null) {
            String str = dataType;
            if (!(str == null || str.length() == 0)) {
                String stringByName = I18nTextProvider.INSTANCE.getStringByName(resources, buildErrorCodeI18nKey(code, dataType));
                if (stringByName != null) {
                    return new AgentErrorCodeConfig(agentErrorCodeConfig.getLevel(), null, stringByName, false, 8, null);
                }
            }
            return agentErrorCodeConfig;
        }
        String str2 = dataType;
        if (!(str2 == null || str2.length() == 0)) {
            String stringByName2 = I18nTextProvider.INSTANCE.getStringByName(resources, buildErrorCodeI18nKey(code, dataType));
            if (stringByName2 != null) {
                return new AgentErrorCodeConfig(AgentErrorLevel.WARN, null, stringByName2, false, 8, null);
            }
        }
        String stringByName3 = I18nTextProvider.INSTANCE.getStringByName(resources, buildErrorCodeI18nKey$default(this, code, null, 2, null));
        if (stringByName3 != null) {
            return new AgentErrorCodeConfig(AgentErrorLevel.WARN, null, stringByName3, false, 8, null);
        }
        return DEFAULT_CONFIG;
    }

    public static /* synthetic */ DisplayResult displayMessage$default(AgentErrorCodeRegistry agentErrorCodeRegistry, Resources resources, Integer num, String str, JsonObject jsonObject, String str2, boolean z, int i, Object obj) {
        return agentErrorCodeRegistry.displayMessage(resources, num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : jsonObject, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? TocCreditsPolicy.INSTANCE.isEnabled() : z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        if ((r12 == null || r12.length() == 0) == false) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DisplayResult displayMessage(Resources resources, Integer code, String originMessage, JsonObject data, String resolvedDataType, boolean creditsFeatureEnabled) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        TocCreditsErrorOverride resolve = TocCreditsErrorDisplayPolicy.INSTANCE.resolve(code, creditsFeatureEnabled);
        if (resolve != null) {
            return new DisplayResult(I18nTextProvider.INSTANCE.getString(resources, resolve.getMessageResId(), new Object[0]), resolve.getLevel(), I18nTextProvider.INSTANCE.getString(resources, resolve.getTitleResId(), new Object[0]), resolve.getShowInfoIcon());
        }
        DisplayResult buildModelUnavailableDisplay = buildModelUnavailableDisplay(resources, code, originMessage, data);
        if (buildModelUnavailableDisplay != null) {
            return buildModelUnavailableDisplay;
        }
        DisplayResult buildEnterpriseCommercialDisplay = buildEnterpriseCommercialDisplay(resources, code, data);
        if (buildEnterpriseCommercialDisplay != null) {
            return buildEnterpriseCommercialDisplay;
        }
        AgentErrorCodeConfig config = code != null ? config(resources, code.intValue(), resolvedDataType) : DEFAULT_CONFIG;
        if (config.getUseOriginMessage()) {
            String str = originMessage;
        }
        if (config.getStringResId() != null) {
            String string = I18nTextProvider.INSTANCE.getString(resources, config.getStringResId().intValue(), new Object[0]);
            if (string.length() == 0) {
                string = config.getDefaultMessage();
            }
            originMessage = string;
        } else {
            originMessage = config.getDefaultMessage();
        }
        if (config.getLevel() == AgentErrorLevel.ERROR && code != null) {
            if (originMessage.length() > 0) {
                originMessage = originMessage + " (" + code + ')';
            }
        }
        return new DisplayResult(originMessage, config.getLevel(), null, false, 12, null);
    }

    private final DisplayResult buildEnterpriseCommercialDisplay(Resources resources, Integer code, JsonObject data) {
        if (code == null || code.intValue() != 991502) {
            return null;
        }
        Integer readInt = readInt(data, "limit");
        if (readInt == null && (readInt = readInt(data, "parallel_limit")) == null) {
            readInt = readInt(data, "solo_agent_parallel_limit");
        }
        String parallelLimitMessage = EnterpriseCommercialErrorMessages.INSTANCE.parallelLimitMessage(resources, readInt);
        if (parallelLimitMessage == null) {
            return null;
        }
        return new DisplayResult(parallelLimitMessage, AgentErrorLevel.WARN, null, false, 12, null);
    }

    private final DisplayResult buildModelUnavailableDisplay(Resources resources, Integer code, String originMessage, JsonObject data) {
        String stringWithNamedArgs;
        if (code != null && code.intValue() == 4008) {
            if (isInternalUser() && Intrinsics.areEqual(readBoolean(data, "is_internal_usage_limit"), true)) {
                return new DisplayResult(buildInternalUsageLimitMessage(resources, data), AgentErrorLevel.WARN, I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_internalUsageLimit_title, new Object[0]), false, 8, null);
            }
            return null;
        }
        if (code != null && code.intValue() == 4037) {
            if (Intrinsics.areEqual(readString(data, DBData.FIELD_TYPE), "empty_git")) {
                stringWithNamedArgs = I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_repoLevelModelUnavailable_emptyGit, new Object[0]);
            } else {
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                int i = R.string.imkit_error_repoLevelModelUnavailable;
                String readString = readString(data, "level");
                if (readString == null) {
                    readString = "";
                }
                stringWithNamedArgs = i18nTextProvider.getStringWithNamedArgs(resources, i, MapsKt.mapOf(TuplesKt.to("repoLevel", readString)));
            }
            String str = stringWithNamedArgs;
            if (StringsKt.isBlank(str)) {
                if (originMessage == null) {
                    originMessage = "";
                }
                str = originMessage;
            }
            return new DisplayResult(str, AgentErrorLevel.WARN, null, false, 12, null);
        }
        if (code != null && code.intValue() == 4410) {
            return new DisplayResult(contentSecurityBlockedMessage(resources, readString(data, "rule_name")), AgentErrorLevel.WARN, null, false, 12, null);
        }
        return null;
    }

    public final String contentSecurityBlockedMessage(Resources resources, String ruleName) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return ContentSecurityErrorMessages.INSTANCE.blockedMessage(resources, ruleName);
    }

    private final String buildInternalUsageLimitMessage(Resources resources, JsonObject data) {
        List<String> readStringList = readStringList(data, "models");
        if (readStringList.isEmpty()) {
            readStringList = INSTANCE.readStringList(data, "model_names");
        }
        List<String> list = readStringList;
        if (list.isEmpty()) {
            list = INSTANCE.readStringList(data, "modelNames");
        }
        List distinct = CollectionsKt.distinct(list);
        if (distinct.isEmpty()) {
            return I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_internalUsageLimit_message, new Object[0]);
        }
        return I18nTextProvider.INSTANCE.getStringWithNamedArgs(resources, R.string.imkit_error_internalUsageLimit_messageWithModels, MapsKt.mapOf(TuplesKt.to("models", CollectionsKt.joinToString$default(distinct, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null))));
    }

    private final boolean isInternalUser() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        if (Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD)) {
            return true;
        }
        return accountInfo != null && accountInfo.getOdinUserType() == 12;
    }

    private final Boolean readBoolean(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(jsonElement.getAsBoolean()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Boolean) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final String readString(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(jsonElement.getAsString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            return null;
        }
        return str2;
    }

    private final Integer readInt(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Integer.valueOf(jsonElement.getAsInt()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Integer) (Result.isFailure-impl(obj) ? null : obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r1)) != false) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> readStringList(JsonObject jsonObject, String str) {
        JsonElement jsonElement;
        Object obj;
        Object obj2;
        String str2;
        if (jsonObject == null || (jsonElement = jsonObject.get(str)) == null) {
            return CollectionsKt.emptyList();
        }
        List<String> list = null;
        if (!jsonElement.isJsonArray()) {
            if (!jsonElement.isJsonPrimitive()) {
                return CollectionsKt.emptyList();
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(jsonElement.getAsString());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            String str3 = (String) obj;
            if (str3 != null) {
                if (!(!StringsKt.isBlank(str3))) {
                    str3 = null;
                }
                if (str3 != null) {
                    list = CollectionsKt.listOf(str3);
                }
            }
            return list == null ? CollectionsKt.emptyList() : list;
        }
        Iterable<JsonElement> asJsonArray = jsonElement.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement2 : asJsonArray) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj2 = Result.constructor-impl(jsonElement2.getAsString());
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                str2 = (String) obj2;
                if (str2 != null) {
                }
            }
            str2 = null;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }
}
