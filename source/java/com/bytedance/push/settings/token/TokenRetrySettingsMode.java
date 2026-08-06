package com.bytedance.push.settings.token;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class TokenRetrySettingsMode {

    @SerializedName("enable_token_retry")
    public boolean enableTokenRetry = true;

    @SerializedName("token_register_timeout_in_second")
    public long tokenRegisterTimeout = 60;

    @SerializedName("need_retry_channel")
    public List<Integer> needRetryChannel = Arrays.asList(1, 7, 10, 11, 22);

    @SerializedName("retry_after_network_changed")
    public boolean retryAfterNetworkChanged = true;

    @SerializedName("max_loop_retry_times")
    public int maxLoopRetryTimes = -1;

    @SerializedName("loop_retry_interval_in_second")
    public long loopRetryIntervalInSecond = 60;

    @SerializedName("retry_after_enter_background")
    public boolean retryAfterEnterBackground = true;

    @SerializedName("trigger_retry_event_list")
    public List<String> triggerRetryEventList = new ArrayList();
}
