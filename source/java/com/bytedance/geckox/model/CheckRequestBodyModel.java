package com.bytedance.geckox.model;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class CheckRequestBodyModel {

    /* loaded from: classes3.dex */
    public static class TargetChannel {

        @SerializedName(AirActionConstant.ActionId.ACTION_ID_CALL)
        public String channelName;

        @SerializedName("from")
        public List<String> from;

        @SerializedName("t_v")
        public Long targetVersion;

        public TargetChannel() {
        }

        public TargetChannel(String str) {
            this.channelName = str;
        }

        public TargetChannel(String str, Long l) {
            this.channelName = str;
            this.targetVersion = l;
        }
    }
}
