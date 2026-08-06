package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: IRemoteModelsApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ,\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'J@\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\u00042\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0001H'¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;", "", "getModels", "Lcom/bytedance/retrofit2/Call;", "", "functions", "", "extraInfo", "getPcModels", "cliId", "forceRefresh", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IRemoteModelsApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @GET("api/remote/v1/models")
    Call<String> getModels(@Query("functions") List<String> functions, @ExtraInfo Object extraInfo);

    @GET("api/solo_hub/v1/clis/models")
    Call<String> getPcModels(@Query("cli_id") String cliId, @Query("functions") List<String> functions, @Query("force_refresh") boolean forceRefresh, @ExtraInfo Object extraInfo);

    /* compiled from: IRemoteModelsApi.kt */
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\\B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eJ,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0017JT\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u001eJ\u001e\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0017\u0010%\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J&\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0016\u00103\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J\u001e\u00104\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J&\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0002J\n\u00107\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0013\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001fJ\u0018\u0010;\u001a\u0004\u0018\u00010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u000eH\u0002J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J7\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001a2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050E\"\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ\u0016\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010A\u001a\u00020BH\u0002J\u000e\u0010H\u001a\u0004\u0018\u00010I*\u00020BH\u0002J\u000e\u0010J\u001a\u0004\u0018\u00010K*\u00020BH\u0002J'\u0010L\u001a\u0004\u0018\u00010\u0005*\u00020I2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050E\"\u00020\u0005H\u0002¢\u0006\u0002\u0010MJ\f\u0010N\u001a\u00020\u001a*\u00020IH\u0002J\u0014\u0010O\u001a\u00020\u001a*\u00020I2\u0006\u0010C\u001a\u00020\u001aH\u0002J\u001b\u0010P\u001a\u0004\u0018\u00010\u0007*\u00020I2\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u0004\u0018\u00010\u001a*\u00020I2\u0006\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010SJ4\u0010T\u001a\u00020\u000f*\u00020I2\u0006\u0010U\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\u001a2\u0006\u0010Y\u001a\u00020\u001aH\u0002J\u0018\u0010Z\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001fJ\n\u0010[\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;", "", "<init>", "()V", "TAG", "", "CODE_CLI_OFFLINE", "", "CODE_CLI_UNREGISTERED", "CODE_PC_MODEL_LIST_UNSUPPORTED", "CACHE_TYPE_REMOTE", "CACHE_TYPE_PC", "modelListMemoryCache", "Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;", "", "Lcom/bytedance/trae/conversation/network/RemoteModelItem;", "getCachedModelsForUi", "cliType", "Lcom/bytedance/trae/im/service/CliType;", "cliId", "functions", "fetchModelsForUi", "trigger", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPcModelsForUi", "forceRefresh", "", "ideVersion", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/CliType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadOnAppStart", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAccountChanged", "readBody", "body", "errorBody", "Lcom/bytedance/retrofit2/mime/TypedInput;", "parseBizCode", "rawBody", "(Ljava/lang/String;)Ljava/lang/Integer;", "isSuccessBizCode", "code", "isExpectedPcModelListBizCode", "normalizeModels", "models", "putModelsCache", "requestOwner", "Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;", "key", "getCachedModelsOrAuto", "reason", "remoteCacheKey", "pcCacheKey", "modelListCacheKey", DBData.FIELD_TYPE, "currentModelListUserId", "resolveCachedPcCliId", "resolvePcCliInfo", "Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;", "findSingleOnlineLocalCli", "Lcom/bytedance/trae/im/service/Cli;", "clis", "parseModels", "normalizeBody", "collectModels", TimonPipeline.KEY_SOURCE, "Lcom/google/gson/JsonElement;", "defaultBuiltin", "keys", "", "(Lcom/google/gson/JsonElement;Z[Ljava/lang/String;)Ljava/util/List;", "collectGroupedModels", "asObjectOrNull", "Lcom/google/gson/JsonObject;", "asArrayOrNull", "Lcom/google/gson/JsonArray;", "readString", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/String;", "shouldDisplayModel", "readBuiltin", "readInt", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "readBoolean", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "toRemoteModelItem", "id", "name", "displayName", "isBuiltin", "isDefault", "findCliIdeVersion", "minSupportedIdeVersion", "PcCliInfo", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        private static final String CACHE_TYPE_PC = "pc";
        private static final String CACHE_TYPE_REMOTE = "remote";
        private static final int CODE_CLI_OFFLINE = 2900101;
        private static final int CODE_CLI_UNREGISTERED = 2900102;
        private static final int CODE_PC_MODEL_LIST_UNSUPPORTED = 2900104;
        private static final String TAG = "IRemoteModelsApi";
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final UserScopedModelListMemoryCache<List<RemoteModelItem>> modelListMemoryCache = new UserScopedModelListMemoryCache<>();

        /* compiled from: IRemoteModelsApi.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CliType.values().length];
                try {
                    iArr[CliType.LOCAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CliType.IDE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CliType.REMOTE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isExpectedPcModelListBizCode(int code) {
            return code == CODE_CLI_OFFLINE || code == CODE_CLI_UNREGISTERED || code == CODE_PC_MODEL_LIST_UNSUPPORTED;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isSuccessBizCode(int code) {
            return code == 0 || code == 200;
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: IRemoteModelsApi.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;", "", "id", "", "ideVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIdeVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class PcCliInfo {
            private final String id;
            private final String ideVersion;

            public static /* synthetic */ PcCliInfo copy$default(PcCliInfo pcCliInfo, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = pcCliInfo.id;
                }
                if ((i & 2) != 0) {
                    str2 = pcCliInfo.ideVersion;
                }
                return pcCliInfo.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getIdeVersion() {
                return this.ideVersion;
            }

            public final PcCliInfo copy(String id, String ideVersion) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new PcCliInfo(id, ideVersion);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PcCliInfo)) {
                    return false;
                }
                PcCliInfo pcCliInfo = (PcCliInfo) other;
                return Intrinsics.areEqual(this.id, pcCliInfo.id) && Intrinsics.areEqual(this.ideVersion, pcCliInfo.ideVersion);
            }

            public int hashCode() {
                int hashCode = this.id.hashCode() * 31;
                String str = this.ideVersion;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "PcCliInfo(id=" + this.id + ", ideVersion=" + this.ideVersion + ')';
            }

            public PcCliInfo(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "id");
                this.id = str;
                this.ideVersion = str2;
            }

            public final String getId() {
                return this.id;
            }

            public final String getIdeVersion() {
                return this.ideVersion;
            }
        }

        public final List<RemoteModelItem> getCachedModelsForUi(CliType cliType, String cliId, List<String> functions) {
            String pcCacheKey;
            Intrinsics.checkNotNullParameter(cliType, "cliType");
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            Intrinsics.checkNotNullParameter(functions, "functions");
            if (functions.isEmpty()) {
                return null;
            }
            if (cliType == CliType.LOCAL || cliType == CliType.IDE) {
                cliId = resolveCachedPcCliId(cliId);
            }
            int i = WhenMappings.$EnumSwitchMapping$0[cliType.ordinal()];
            if (i == 1) {
                pcCacheKey = pcCacheKey(cliId, functions);
            } else if (i == 2) {
                pcCacheKey = pcCacheKey(cliId, functions);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                pcCacheKey = remoteCacheKey(functions);
            }
            List<RemoteModelItem> list = modelListMemoryCache.get(currentModelListUserId(), pcCacheKey);
            if (list != null) {
                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                StringBuilder append = new StringBuilder("getCachedModelsForUi: hit, key=").append(pcCacheKey).append(", count=").append(list.size()).append(", names=");
                List take = CollectionsKt.take(list, 6);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
                Iterator it = take.iterator();
                while (it.hasNext()) {
                    arrayList.add(((RemoteModelItem) it.next()).getName());
                }
                traeLogUtil.i(TAG, append.append(arrayList).toString());
            } else {
                TraeLogUtil.INSTANCE.i(TAG, "getCachedModelsForUi: miss, key=" + pcCacheKey);
            }
            return list;
        }

        public static /* synthetic */ Object fetchModelsForUi$default(Companion companion, List list, String str, Continuation continuation, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "unknown";
            }
            return companion.fetchModelsForUi(list, str, continuation);
        }

        public final Object fetchModelsForUi(List<String> list, String str, Continuation<? super List<RemoteModelItem>> continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new IRemoteModelsApi$Companion$fetchModelsForUi$2(str, list, null), continuation);
        }

        public final Object fetchPcModelsForUi(String str, List<String> list, boolean z, String str2, String str3, CliType cliType, Continuation<? super List<RemoteModelItem>> continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new IRemoteModelsApi$Companion$fetchPcModelsForUi$2(str3, cliType, str, list, z, str2, null), continuation);
        }

        public static /* synthetic */ Object preloadOnAppStart$default(Companion companion, String str, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "unknown";
            }
            return companion.preloadOnAppStart(str, continuation);
        }

        public final Object preloadOnAppStart(String str, Continuation<? super Unit> continuation) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new IRemoteModelsApi$Companion$preloadOnAppStart$2(str, null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }

        public final void onAccountChanged() {
            modelListMemoryCache.onAccountChanged();
            TraeLogUtil.INSTANCE.i(TAG, "onAccountChanged: model list cache invalidated");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String readBody(String body, TypedInput errorBody) {
            InputStream in;
            if (body != null) {
                return body;
            }
            if (errorBody == null || (in = errorBody.in()) == null) {
                return null;
            }
            Reader inputStreamReader = new InputStreamReader(in, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, FConstants.DOWNLOAD_BUFFER_SIZE);
            try {
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                return readText;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Integer parseBizCode(String rawBody) {
            Object obj;
            JsonObject asObjectOrNull;
            Integer num;
            JsonElement jsonElement;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                JsonElement parseString = JsonParser.parseString(normalizeBody(rawBody));
                Intrinsics.checkNotNullExpressionValue(parseString, "parseString(...)");
                asObjectOrNull = asObjectOrNull(parseString);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (asObjectOrNull != null && (jsonElement = asObjectOrNull.get("code")) != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null) {
                    num = Integer.valueOf(jsonElement.getAsInt());
                    obj = Result.constructor-impl(num);
                    return (Integer) (Result.isFailure-impl(obj) ? null : obj);
                }
            }
            num = null;
            obj = Result.constructor-impl(num);
            return (Integer) (Result.isFailure-impl(obj) ? null : obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<RemoteModelItem> normalizeModels(List<RemoteModelItem> models) {
            List<RemoteModelItem> list = models;
            if (list.isEmpty()) {
                list = CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
            }
            return list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean putModelsCache(UserScopedModelListMemoryCache.Owner requestOwner, String key, List<RemoteModelItem> models) {
            if (!modelListMemoryCache.putIfCurrent(requestOwner, currentModelListUserId(), key, models)) {
                TraeLogUtil.INSTANCE.i(TAG, "putModelsCache: ignored because account changed, key=" + key);
                return false;
            }
            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
            StringBuilder append = new StringBuilder("putModelsCache: key=").append(key).append(", count=").append(models.size()).append(", names=");
            List take = CollectionsKt.take(models, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
            Iterator it = take.iterator();
            while (it.hasNext()) {
                arrayList.add(((RemoteModelItem) it.next()).getName());
            }
            traeLogUtil.i(TAG, append.append(arrayList).toString());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<RemoteModelItem> getCachedModelsOrAuto(String key, String reason) {
            List<RemoteModelItem> list = modelListMemoryCache.get(currentModelListUserId(), key);
            if (list != null) {
                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                StringBuilder append = new StringBuilder("getCachedModelsOrAuto: hit, reason=").append(reason).append(", key=").append(key).append(", count=").append(list.size()).append(", names=");
                List take = CollectionsKt.take(list, 6);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
                Iterator it = take.iterator();
                while (it.hasNext()) {
                    arrayList.add(((RemoteModelItem) it.next()).getName());
                }
                traeLogUtil.i(TAG, append.append(arrayList).toString());
                return list;
            }
            TraeLogUtil.INSTANCE.i(TAG, "getCachedModelsOrAuto: miss, reason=" + reason + ", key=" + key);
            return CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String remoteCacheKey(List<String> functions) {
            return modelListCacheKey(CACHE_TYPE_REMOTE, "", functions);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String pcCacheKey(String cliId, List<String> functions) {
            return modelListCacheKey(CACHE_TYPE_PC, cliId, functions);
        }

        private final String modelListCacheKey(String type, String cliId, List<String> functions) {
            return type + '|' + cliId + '|' + CollectionsKt.joinToString$default(functions, IWeiboService.Scope.EMPTY_SCOPE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String currentModelListUserId() {
            AccountInfo accountInfo;
            String userId;
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (userId = accountInfo.getUserId()) == null || !(!StringsKt.isBlank(userId))) {
                return null;
            }
            return userId;
        }

        private final String resolveCachedPcCliId(String cliId) {
            if (!StringsKt.isBlank(cliId)) {
                return cliId;
            }
            Cli findSingleOnlineLocalCli = findSingleOnlineLocalCli(CliListRepository.INSTANCE.getInstance().getCacheClis());
            String id = findSingleOnlineLocalCli != null ? findSingleOnlineLocalCli.getId() : null;
            if (id == null) {
                id = "";
            }
            if (!StringsKt.isBlank(id)) {
                TraeLogUtil.INSTANCE.i(TAG, "getCachedModelsForUi: resolved empty cliId from cache, cliId=" + id);
            }
            return id;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(2:10|11)(2:25|26))(2:27|(2:29|30)(2:31|(4:33|(1:35)|36|37)(2:38|(1:40)(1:41))))|12|13|(1:15)|16|(3:18|(1:20)|21)|22))|44|6|7|(0)(0)|12|13|(0)|16|(0)|22) */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0031, code lost:
        
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
        
            r8 = kotlin.Result.Companion;
            r7 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r7));
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object resolvePcCliInfo(String str, Continuation<? super PcCliInfo> continuation) {
            IRemoteModelsApi$Companion$resolvePcCliInfo$1 iRemoteModelsApi$Companion$resolvePcCliInfo$1;
            int i;
            Object obj;
            Cli cli;
            Companion companion;
            if (continuation instanceof IRemoteModelsApi$Companion$resolvePcCliInfo$1) {
                iRemoteModelsApi$Companion$resolvePcCliInfo$1 = (IRemoteModelsApi$Companion$resolvePcCliInfo$1) continuation;
                if ((iRemoteModelsApi$Companion$resolvePcCliInfo$1.label & Integer.MIN_VALUE) != 0) {
                    iRemoteModelsApi$Companion$resolvePcCliInfo$1.label -= Integer.MIN_VALUE;
                    Object obj2 = iRemoteModelsApi$Companion$resolvePcCliInfo$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iRemoteModelsApi$Companion$resolvePcCliInfo$1.label;
                    PcCliInfo pcCliInfo = null;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        if (!StringsKt.isBlank(str)) {
                            return new PcCliInfo(str, null);
                        }
                        Cli findSingleOnlineLocalCli = findSingleOnlineLocalCli(CliListRepository.INSTANCE.getInstance().getCacheClis());
                        if (findSingleOnlineLocalCli != null) {
                            String id = findSingleOnlineLocalCli.getId();
                            return new PcCliInfo(id != null ? id : "", findSingleOnlineLocalCli.getIdeVersion());
                        }
                        Result.Companion companion2 = Result.Companion;
                        Companion companion3 = this;
                        CliListRepository companion4 = CliListRepository.INSTANCE.getInstance();
                        iRemoteModelsApi$Companion$resolvePcCliInfo$1.L$0 = this;
                        iRemoteModelsApi$Companion$resolvePcCliInfo$1.label = 1;
                        obj2 = companion4.getClis(iRemoteModelsApi$Companion$resolvePcCliInfo$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        companion = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        companion = (Companion) iRemoteModelsApi$Companion$resolvePcCliInfo$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    obj = Result.constructor-impl(companion.findSingleOnlineLocalCli((List) obj2));
                    if (Result.isFailure-impl(obj)) {
                        obj = null;
                    }
                    cli = (Cli) obj;
                    if (cli != null) {
                        String id2 = cli.getId();
                        pcCliInfo = new PcCliInfo(id2 != null ? id2 : "", cli.getIdeVersion());
                    }
                    return pcCliInfo;
                }
            }
            iRemoteModelsApi$Companion$resolvePcCliInfo$1 = new IRemoteModelsApi$Companion$resolvePcCliInfo$1(this, continuation);
            Object obj22 = iRemoteModelsApi$Companion$resolvePcCliInfo$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iRemoteModelsApi$Companion$resolvePcCliInfo$1.label;
            PcCliInfo pcCliInfo2 = null;
            if (i != 0) {
            }
            obj = Result.constructor-impl(companion.findSingleOnlineLocalCli((List) obj22));
            if (Result.isFailure-impl(obj)) {
            }
            cli = (Cli) obj;
            if (cli != null) {
            }
            return pcCliInfo2;
        }

        private final Cli findSingleOnlineLocalCli(List<Cli> clis) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : clis) {
                Cli cli = (Cli) obj;
                boolean z = false;
                if ((Intrinsics.areEqual(cli.getType(), CliType.LOCAL.getValue()) || Intrinsics.areEqual(cli.getType(), CliType.IDE.getValue())) && Intrinsics.areEqual(cli.getStatus(), "online")) {
                    String id = cli.getId();
                    if (!(id == null || StringsKt.isBlank(id))) {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            return (Cli) CollectionsKt.singleOrNull(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<RemoteModelItem> parseModels(String rawBody) {
            Object obj;
            JsonElement jsonElement;
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                JsonElement parseString = JsonParser.parseString(normalizeBody(rawBody));
                Intrinsics.checkNotNull(parseString);
                JsonObject asObjectOrNull = asObjectOrNull(parseString);
                if (asObjectOrNull != null && (jsonElement = asObjectOrNull.get("data")) != null) {
                    parseString = jsonElement;
                }
                List mutableListOf = CollectionsKt.mutableListOf(new RemoteModelItem[]{RemoteModelItem.INSTANCE.auto()});
                Intrinsics.checkNotNull(parseString);
                mutableListOf.addAll(collectModels(parseString, true, "builtin_models", "built_in_models", "builtins"));
                mutableListOf.addAll(collectModels(parseString, false, "custom_models", "customModels"));
                mutableListOf.addAll(collectModels(parseString, true, "models", "items"));
                mutableListOf.addAll(collectGroupedModels(parseString));
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : mutableListOf) {
                    RemoteModelItem remoteModelItem = (RemoteModelItem) obj2;
                    String id = remoteModelItem.getId();
                    if (StringsKt.isBlank(id)) {
                        id = remoteModelItem.getName();
                    }
                    if (hashSet.add(id)) {
                        arrayList.add(obj2);
                    }
                }
                obj = Result.constructor-impl(arrayList);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                TraeLogUtil.INSTANCE.w(TAG, "parseModels failed", th2);
                obj = CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
            }
            return (List) obj;
        }

        private final String normalizeBody(String rawBody) {
            String obj = StringsKt.trim(rawBody).toString();
            if (StringsKt.startsWith$default(obj, "\"", false, 2, (Object) null) && StringsKt.endsWith$default(obj, "\"", false, 2, (Object) null)) {
                obj = (String) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(obj, String.class);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "let(...)");
            return obj;
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00be, code lost:
        
            if (r12 == null) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x013a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0071 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<RemoteModelItem> collectModels(JsonElement source, boolean defaultBuiltin, String... keys) {
            List<Iterable> emptyList;
            String asString;
            RemoteModelItem remoteModelItem;
            Boolean readBoolean;
            String readString;
            String readString2;
            if (source.isJsonArray()) {
                emptyList = CollectionsKt.listOf(source.getAsJsonArray());
            } else if (!source.isJsonObject()) {
                emptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                for (String str : keys) {
                    JsonElement jsonElement = source.getAsJsonObject().get(str);
                    JsonArray asArrayOrNull = jsonElement != null ? $$INSTANCE.asArrayOrNull(jsonElement) : null;
                    if (asArrayOrNull != null) {
                        arrayList.add(asArrayOrNull);
                    }
                }
                emptyList = arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Iterable<JsonElement> iterable : emptyList) {
                Intrinsics.checkNotNull(iterable);
                ArrayList arrayList3 = new ArrayList();
                for (JsonElement jsonElement2 : iterable) {
                    Companion companion = $$INSTANCE;
                    Intrinsics.checkNotNull(jsonElement2);
                    JsonObject asObjectOrNull = companion.asObjectOrNull(jsonElement2);
                    if (!((asObjectOrNull == null || companion.shouldDisplayModel(asObjectOrNull)) ? false : true)) {
                        if (asObjectOrNull == null || (asString = companion.readString(asObjectOrNull, "name", "model_name", "id")) == null) {
                            if (!jsonElement2.isJsonPrimitive()) {
                                jsonElement2 = null;
                            }
                            asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
                        }
                        String str2 = asString;
                        String str3 = (asObjectOrNull == null || (readString2 = companion.readString(asObjectOrNull, IGoogleService.ResponseKey.DISPLAY_NAME, "title")) == null) ? str2 : readString2;
                        String str4 = (asObjectOrNull == null || (readString = companion.readString(asObjectOrNull, "id", "model_id", "model_name", "name")) == null) ? str2 : readString;
                        boolean readBuiltin = asObjectOrNull != null ? companion.readBuiltin(asObjectOrNull, defaultBuiltin) : defaultBuiltin;
                        boolean booleanValue = (asObjectOrNull == null || (readBoolean = companion.readBoolean(asObjectOrNull, "is_default")) == null) ? false : readBoolean.booleanValue();
                        if (asObjectOrNull == null || (remoteModelItem = companion.toRemoteModelItem(asObjectOrNull, str4, str2, str3, readBuiltin, booleanValue)) == null) {
                            remoteModelItem = new RemoteModelItem(str4, str2, str3, readBuiltin, null, null, null, null, null, null, null, null, null, null, booleanValue, 16368, null);
                        }
                        if (remoteModelItem == null) {
                            arrayList3.add(remoteModelItem);
                        }
                    }
                    remoteModelItem = null;
                    if (remoteModelItem == null) {
                    }
                }
                CollectionsKt.addAll(arrayList2, arrayList3);
            }
            return arrayList2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x00bc, code lost:
        
            if (r14 == null) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0134 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x006e A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final List<RemoteModelItem> collectGroupedModels(JsonElement source) {
            JsonArray asJsonArray;
            ArrayList arrayList;
            JsonElement jsonElement;
            Iterable<JsonElement> asArrayOrNull;
            String asString;
            RemoteModelItem remoteModelItem;
            Boolean readBoolean;
            String readString;
            String readString2;
            if (source.isJsonObject()) {
                JsonElement jsonElement2 = source.getAsJsonObject().get("list");
                if (jsonElement2 != null) {
                    asJsonArray = asArrayOrNull(jsonElement2);
                }
                asJsonArray = null;
            } else {
                if (source.isJsonArray()) {
                    asJsonArray = source.getAsJsonArray();
                }
                asJsonArray = null;
            }
            if (asJsonArray == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList2 = new ArrayList();
            for (JsonElement jsonElement3 : (Iterable) asJsonArray) {
                Companion companion = $$INSTANCE;
                Intrinsics.checkNotNull(jsonElement3);
                JsonObject asObjectOrNull = companion.asObjectOrNull(jsonElement3);
                if (asObjectOrNull == null || (jsonElement = asObjectOrNull.get("models")) == null || (asArrayOrNull = companion.asArrayOrNull(jsonElement)) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    for (JsonElement jsonElement4 : asArrayOrNull) {
                        Companion companion2 = $$INSTANCE;
                        Intrinsics.checkNotNull(jsonElement4);
                        JsonObject asObjectOrNull2 = companion2.asObjectOrNull(jsonElement4);
                        boolean z = false;
                        if (!((asObjectOrNull2 == null || companion2.shouldDisplayModel(asObjectOrNull2)) ? false : true)) {
                            if (asObjectOrNull2 == null || (asString = companion2.readString(asObjectOrNull2, "name", "model_name", "id")) == null) {
                                if (!jsonElement4.isJsonPrimitive()) {
                                    jsonElement4 = null;
                                }
                                asString = jsonElement4 != null ? jsonElement4.getAsString() : null;
                            }
                            String str = asString;
                            String str2 = (asObjectOrNull2 == null || (readString2 = companion2.readString(asObjectOrNull2, IGoogleService.ResponseKey.DISPLAY_NAME, "title")) == null) ? str : readString2;
                            String str3 = (asObjectOrNull2 == null || (readString = companion2.readString(asObjectOrNull2, "id", "model_id", "model_name", "name")) == null) ? str : readString;
                            boolean readBuiltin = asObjectOrNull2 != null ? companion2.readBuiltin(asObjectOrNull2, true) : true;
                            if (asObjectOrNull2 != null && (readBoolean = companion2.readBoolean(asObjectOrNull2, "is_default")) != null) {
                                z = readBoolean.booleanValue();
                            }
                            boolean z2 = z;
                            if (asObjectOrNull2 == null || (remoteModelItem = companion2.toRemoteModelItem(asObjectOrNull2, str3, str, str2, readBuiltin, z2)) == null) {
                                remoteModelItem = new RemoteModelItem(str3, str, str2, readBuiltin, null, null, null, null, null, null, null, null, null, null, z2, 16368, null);
                            }
                            if (remoteModelItem == null) {
                                arrayList3.add(remoteModelItem);
                            }
                        }
                        remoteModelItem = null;
                        if (remoteModelItem == null) {
                        }
                    }
                    arrayList = arrayList3;
                }
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                CollectionsKt.addAll(arrayList2, arrayList);
            }
            return arrayList2;
        }

        private final JsonObject asObjectOrNull(JsonElement jsonElement) {
            if (!jsonElement.isJsonObject()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                return jsonElement.getAsJsonObject();
            }
            return null;
        }

        private final JsonArray asArrayOrNull(JsonElement jsonElement) {
            if (!jsonElement.isJsonArray()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                return jsonElement.getAsJsonArray();
            }
            return null;
        }

        private final boolean shouldDisplayModel(JsonObject jsonObject) {
            if (jsonObject.has(PageDataManager.EXTRA_STATUS)) {
                return Intrinsics.areEqual(readBoolean(jsonObject, PageDataManager.EXTRA_STATUS), true);
            }
            return true;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:28:0x006a. Please report as an issue. */
        private final boolean readBuiltin(JsonObject jsonObject, boolean z) {
            String str;
            Boolean readBoolean = readBoolean(jsonObject, "is_builtin");
            if (readBoolean != null) {
                return readBoolean.booleanValue();
            }
            Boolean readBoolean2 = readBoolean(jsonObject, "builtin");
            if (readBoolean2 != null) {
                return readBoolean2.booleanValue();
            }
            Integer readInt = readInt(jsonObject, "config_source");
            if (readInt != null) {
                int intValue = readInt.intValue();
                if (intValue == 3) {
                    return false;
                }
                if (intValue == 1 || intValue == 2) {
                    return true;
                }
            }
            Boolean readBoolean3 = readBoolean(jsonObject, "is_preset");
            if (readBoolean3 != null) {
                return readBoolean3.booleanValue();
            }
            String readString = readString(jsonObject, DBData.FIELD_TYPE, "model_type", TimonPipeline.KEY_SOURCE, AccountConstants.AccountShareCols.ACCOUNT_TYPE);
            if (readString != null) {
                str = readString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str == null) {
                return z;
            }
            switch (str.hashCode()) {
                case -1430179194:
                    if (!str.equals("built_in")) {
                        return z;
                    }
                    return true;
                case -1349088399:
                    if (!str.equals("custom")) {
                        return z;
                    }
                    return false;
                case -887328209:
                    if (!str.equals("system")) {
                        return z;
                    }
                    return true;
                case -765289749:
                    if (!str.equals("official")) {
                        return z;
                    }
                    return true;
                case -607137179:
                    if (!str.equals("user_custom")) {
                        return z;
                    }
                    return false;
                case 3039347:
                    if (!str.equals("byok")) {
                        return z;
                    }
                    return false;
                case 3599307:
                    if (!str.equals(ParsedChatMessage.ROLE_USER)) {
                        return z;
                    }
                    return false;
                case 230960163:
                    if (!str.equals("builtin")) {
                        return z;
                    }
                    return true;
                default:
                    return z;
            }
        }

        private final Integer readInt(JsonObject jsonObject, String str) {
            Object obj;
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement == null) {
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

        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ac, code lost:
        
            if (r5.equals("0") == false) goto L46;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Boolean readBoolean(JsonObject jsonObject, String str) {
            JsonPrimitive asJsonPrimitive;
            Object obj;
            Boolean bool;
            JsonElement jsonElement = jsonObject.get(str);
            if (jsonElement == null) {
                return null;
            }
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement == null || (asJsonPrimitive = jsonElement.getAsJsonPrimitive()) == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                if (asJsonPrimitive.isBoolean()) {
                    bool = Boolean.valueOf(asJsonPrimitive.getAsBoolean());
                } else if (asJsonPrimitive.isNumber()) {
                    int asInt = asJsonPrimitive.getAsInt();
                    if (asInt != 0) {
                        bool = asInt != 1 ? null : true;
                    } else {
                        bool = false;
                    }
                } else {
                    if (asJsonPrimitive.isString()) {
                        String asString = asJsonPrimitive.getAsString();
                        Intrinsics.checkNotNullExpressionValue(asString, "getAsString(...)");
                        String lowerCase = StringsKt.trim(asString).toString().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        int hashCode = lowerCase.hashCode();
                        if (hashCode != 48) {
                            if (hashCode == 49) {
                                if (!lowerCase.equals("1")) {
                                }
                                bool = true;
                            } else if (hashCode == 3569038) {
                                if (!lowerCase.equals("true")) {
                                }
                                bool = true;
                            } else if (hashCode == 97196323) {
                                if (!lowerCase.equals("false")) {
                                }
                                bool = false;
                            }
                        }
                    }
                }
                obj = Result.constructor-impl(bool);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            return (Boolean) (Result.isFailure-impl(obj) ? null : obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final RemoteModelItem toRemoteModelItem(JsonObject jsonObject, String str, String str2, String str3, boolean z, boolean z2) {
            Boolean bool;
            Integer readInt = readInt(jsonObject, "config_source");
            JsonElement jsonElement = jsonObject.get("icon");
            JsonObject asObjectOrNull = jsonElement != null ? asObjectOrNull(jsonElement) : null;
            String readString = readString(jsonObject, "features");
            Boolean readBoolean = readBoolean(jsonObject, "multimodal");
            Boolean readBoolean2 = readBoolean(jsonObject, "is_preset");
            if (readBoolean2 == null) {
                if (readInt == null) {
                    bool = null;
                    String readString2 = readString(jsonObject, "provider");
                    String readString3 = readString(jsonObject, "custom_model_id");
                    String readString4 = asObjectOrNull == null ? readString(asObjectOrNull, "light") : null;
                    String readString5 = asObjectOrNull == null ? readString(asObjectOrNull, "dark") : null;
                    Boolean readBoolean3 = readBoolean(jsonObject, "is_internal_usage_limit");
                    JsonObject deepCopy = jsonObject.deepCopy();
                    Boolean readBoolean4 = readBoolean(jsonObject, "is_default");
                    return new RemoteModelItem(str, str2, str3, z, readBoolean, bool, readInt, readString2, readString3, readString4, readString5, readBoolean3, readString, deepCopy, readBoolean4 == null ? readBoolean4.booleanValue() : false);
                }
                readBoolean2 = Boolean.valueOf(readInt.intValue() == 1);
            }
            bool = readBoolean2;
            String readString22 = readString(jsonObject, "provider");
            String readString32 = readString(jsonObject, "custom_model_id");
            if (asObjectOrNull == null) {
            }
            if (asObjectOrNull == null) {
            }
            Boolean readBoolean32 = readBoolean(jsonObject, "is_internal_usage_limit");
            JsonObject deepCopy2 = jsonObject.deepCopy();
            Boolean readBoolean42 = readBoolean(jsonObject, "is_default");
            return new RemoteModelItem(str, str2, str3, z, readBoolean, bool, readInt, readString22, readString32, readString4, readString5, readBoolean32, readString, deepCopy2, readBoolean42 == null ? readBoolean42.booleanValue() : false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|(1:(2:10|11)(2:34|35))(7:36|(2:37|(2:39|(1:41)(1:57))(2:58|59))|42|(1:44)(1:56)|45|(1:55)(1:49)|(1:51)(2:52|(1:54)))|12|(2:13|(2:15|(2:17|18)(1:31))(2:32|33))|19|(1:21)(1:30)|22|23|(1:28)(2:25|26)))|62|6|7|(0)(0)|12|(3:13|(0)(0)|31)|19|(0)(0)|22|23|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0030, code lost:
        
            r7 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00c7, code lost:
        
            r8 = kotlin.Result.Companion;
            r7 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r7));
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00a5 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x002b, B:12:0x0099, B:13:0x009f, B:15:0x00a5, B:19:0x00b8, B:21:0x00bc, B:22:0x00c2, B:52:0x0083), top: B:7:0x0023 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00bc A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:11:0x002b, B:12:0x0099, B:13:0x009f, B:15:0x00a5, B:19:0x00b8, B:21:0x00bc, B:22:0x00c2, B:52:0x0083), top: B:7:0x0023 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00d8  */
        /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object findCliIdeVersion(String str, Continuation<? super String> continuation) {
            IRemoteModelsApi$Companion$findCliIdeVersion$1 iRemoteModelsApi$Companion$findCliIdeVersion$1;
            int i;
            Object obj;
            Object obj2;
            Iterator it;
            Object obj3;
            if (continuation instanceof IRemoteModelsApi$Companion$findCliIdeVersion$1) {
                iRemoteModelsApi$Companion$findCliIdeVersion$1 = (IRemoteModelsApi$Companion$findCliIdeVersion$1) continuation;
                if ((iRemoteModelsApi$Companion$findCliIdeVersion$1.label & Integer.MIN_VALUE) != 0) {
                    iRemoteModelsApi$Companion$findCliIdeVersion$1.label -= Integer.MIN_VALUE;
                    Object obj4 = iRemoteModelsApi$Companion$findCliIdeVersion$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = iRemoteModelsApi$Companion$findCliIdeVersion$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj4);
                        Iterator<T> it2 = CliListRepository.INSTANCE.getInstance().getCacheClis().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            if (Intrinsics.areEqual(((Cli) obj2).getId(), str)) {
                                break;
                            }
                        }
                        Cli cli = (Cli) obj2;
                        String ideVersion = cli != null ? cli.getIdeVersion() : null;
                        String str2 = ideVersion;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            return ideVersion;
                        }
                        Result.Companion companion = Result.Companion;
                        Companion companion2 = this;
                        CliListRepository companion3 = CliListRepository.INSTANCE.getInstance();
                        iRemoteModelsApi$Companion$findCliIdeVersion$1.L$0 = str;
                        iRemoteModelsApi$Companion$findCliIdeVersion$1.label = 1;
                        obj4 = companion3.getClis(iRemoteModelsApi$Companion$findCliIdeVersion$1);
                        if (obj4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) iRemoteModelsApi$Companion$findCliIdeVersion$1.L$0;
                        ResultKt.throwOnFailure(obj4);
                    }
                    it = ((Iterable) obj4).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it.next();
                        if (Intrinsics.areEqual(((Cli) obj3).getId(), str)) {
                            break;
                        }
                    }
                    Cli cli2 = (Cli) obj3;
                    obj = Result.constructor-impl(cli2 == null ? cli2.getIdeVersion() : null);
                    if (Result.isFailure-impl(obj)) {
                        return obj;
                    }
                    return null;
                }
            }
            iRemoteModelsApi$Companion$findCliIdeVersion$1 = new IRemoteModelsApi$Companion$findCliIdeVersion$1(this, continuation);
            Object obj42 = iRemoteModelsApi$Companion$findCliIdeVersion$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = iRemoteModelsApi$Companion$findCliIdeVersion$1.label;
            if (i != 0) {
            }
            it = ((Iterable) obj42).iterator();
            while (true) {
                if (it.hasNext()) {
                }
            }
            Cli cli22 = (Cli) obj3;
            obj = Result.constructor-impl(cli22 == null ? cli22.getIdeVersion() : null);
            if (Result.isFailure-impl(obj)) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String minSupportedIdeVersion() {
            return ModelListSettings.INSTANCE.minSupportedIdeVersion();
        }

        private final String readString(JsonObject jsonObject, String... strArr) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                String str = null;
                if (i >= length) {
                    return null;
                }
                JsonElement jsonElement = jsonObject.get(strArr[i]);
                if (jsonElement != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str = jsonElement.getAsString();
                    }
                }
                String str2 = str;
                if (!(str2 == null || StringsKt.isBlank(str2))) {
                    return str;
                }
                i++;
            }
        }
    }
}
