package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.BaseStrategyConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B]\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\u0002\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyConfig;", "Lcom/bytedance/ies/argus/strategy/provider/BaseStrategyConfig;", "skipDetectPathList", "", "", "maxDetectFileSizeInKB", "", "detectTimeout", "enableDetectSessionId", "", "sessionIdBlockEntryList", "regexConfigList", "Lcom/bytedance/ies/argus/strategy/provider/client/RegexConfig;", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;ZLjava/util/List;Ljava/util/List;)V", "getDetectTimeout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableDetectSessionId", "()Z", "getMaxDetectFileSizeInKB", "getRegexConfigList", "()Ljava/util/List;", "getSessionIdBlockEntryList", "getSkipDetectPathList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class UploadFileVerifyStrategyConfig extends BaseStrategyConfig {

    @SerializedName("detect_timeout")
    private final Integer detectTimeout;

    @SerializedName("enable_detect_session_id")
    private final boolean enableDetectSessionId;

    @SerializedName("max_detect_file_size_in_kb")
    private final Integer maxDetectFileSizeInKB;

    @SerializedName("regex_config_list")
    private final List<RegexConfig> regexConfigList;

    @SerializedName("session_id_block_entry_list")
    private final List<String> sessionIdBlockEntryList;

    @SerializedName("skip_detect_path_list")
    private final List<String> skipDetectPathList;

    public UploadFileVerifyStrategyConfig() {
        this(null, null, null, false, null, null, 63, null);
    }

    public /* synthetic */ UploadFileVerifyStrategyConfig(List list, Integer num, Integer num2, boolean z, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3);
    }

    public final List<String> getSkipDetectPathList() {
        return this.skipDetectPathList;
    }

    public final Integer getMaxDetectFileSizeInKB() {
        return this.maxDetectFileSizeInKB;
    }

    public final Integer getDetectTimeout() {
        return this.detectTimeout;
    }

    public final boolean getEnableDetectSessionId() {
        return this.enableDetectSessionId;
    }

    public final List<String> getSessionIdBlockEntryList() {
        return this.sessionIdBlockEntryList;
    }

    public final List<RegexConfig> getRegexConfigList() {
        return this.regexConfigList;
    }

    public UploadFileVerifyStrategyConfig(List<String> list, Integer num, Integer num2, boolean z, List<String> list2, List<RegexConfig> list3) {
        this.skipDetectPathList = list;
        this.maxDetectFileSizeInKB = num;
        this.detectTimeout = num2;
        this.enableDetectSessionId = z;
        this.sessionIdBlockEntryList = list2;
        this.regexConfigList = list3;
    }
}
