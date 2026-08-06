package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class DownloadEventModel {
    private final long mAdId;
    private String mCategory;
    private final List<String> mClickTrackUrl;
    private final int mEventSource;
    private final JSONObject mExtJson;
    private final long mExtValue;
    private final Object mExtraObject;
    private final boolean mIsAd;
    private final String mLabel;
    private final String mLogExtra;
    private final String mTag;

    DownloadEventModel(Builder builder) {
        this.mCategory = builder.mCategory;
        this.mTag = builder.mTag;
        this.mLabel = builder.mLabel;
        this.mIsAd = builder.mIsAd;
        this.mAdId = builder.mAdId;
        this.mLogExtra = builder.mLogExtra;
        this.mExtValue = builder.mExtValue;
        this.mExtJson = builder.mExtJson;
        this.mClickTrackUrl = builder.mClickTrackUrl;
        this.mEventSource = builder.mEventSource;
        this.mExtraObject = builder.mExtraObject;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private long mAdId;
        private String mCategory;
        private List<String> mClickTrackUrl;
        private Map<String, Object> mEventMap;
        private int mEventSource;
        private JSONObject mExtJson;
        private long mExtValue;
        private Object mExtraObject;
        private boolean mIsAd = false;
        private String mLabel;
        private String mLogExtra;
        private String mTag;

        public Builder setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder setLabel(String str) {
            this.mLabel = str;
            return this;
        }

        public Builder setAdId(long j) {
            this.mAdId = j;
            return this;
        }

        public Builder setExtValue(long j) {
            this.mExtValue = j;
            return this;
        }

        public Builder setLogExtra(String str) {
            this.mLogExtra = str;
            return this;
        }

        public Builder setIsAd(boolean z) {
            this.mIsAd = z;
            return this;
        }

        public Builder setExtJson(JSONObject jSONObject) {
            this.mExtJson = jSONObject;
            return this;
        }

        public Builder setEventMap(Map<String, Object> map) {
            this.mEventMap = map;
            return this;
        }

        public Builder setClickTrackUrl(List<String> list) {
            this.mClickTrackUrl = list;
            return this;
        }

        public Builder setEventSource(int i) {
            this.mEventSource = i;
            return this;
        }

        public Builder setExtraObject(Object obj) {
            this.mExtraObject = obj;
            return this;
        }

        public DownloadEventModel build() {
            if (TextUtils.isEmpty(this.mCategory)) {
                this.mCategory = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.mExtJson == null) {
                this.mExtJson = new JSONObject();
            }
            try {
                Map<String, Object> map = this.mEventMap;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.mEventMap.entrySet()) {
                        if (!this.mExtJson.has(entry.getKey())) {
                            this.mExtJson.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.mIsAd) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.mExtJson.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.mLogExtra)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.mLogExtra);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.mExtJson);
                }
                this.mExtJson = jSONObject;
            } catch (Exception unused) {
            }
            return new DownloadEventModel(this);
        }
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public boolean isAd() {
        return this.mIsAd;
    }

    public long getAdId() {
        return this.mAdId;
    }

    public String getLogExtra() {
        return this.mLogExtra;
    }

    public long getExtValue() {
        return this.mExtValue;
    }

    public JSONObject getExtJson() {
        return this.mExtJson;
    }

    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    public int getEventSource() {
        return this.mEventSource;
    }

    public Object getExtraObject() {
        return this.mExtraObject;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("category: ").append(this.mCategory).append("\ntag: ").append(this.mTag).append("\nlabel: ").append(this.mLabel).append("  <------------------\nisAd: ").append(this.mIsAd).append("\nadId: ").append(this.mAdId).append("\nlogExtra: ").append(this.mLogExtra).append("\nextValue: ").append(this.mExtValue).append("\nextJson: ").append(this.mExtJson).append("\nclickTrackUrl: ");
        List<String> list = this.mClickTrackUrl;
        StringBuilder append2 = append.append(list != null ? list.toString() : "").append("\neventSource: ").append(this.mEventSource).append("\nextraObject:");
        Object obj = this.mExtraObject;
        return append2.append(obj != null ? obj.toString() : "").toString();
    }
}
