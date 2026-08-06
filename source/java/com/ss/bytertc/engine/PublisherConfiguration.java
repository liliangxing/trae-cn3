package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.ttm.player.MediaFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PublisherConfiguration {
    private static final String TAG = "PublisherConfiguration";
    private JSONObject mJsonObject;

    public boolean validate() {
        return this.mJsonObject != null;
    }

    public String toJsonString() {
        if (validate()) {
            return this.mJsonObject.toString();
        }
        return null;
    }

    public PublisherConfiguration() {
    }

    private PublisherConfiguration(Builder builder) {
        try {
            JSONObject jSONObject = new JSONObject();
            this.mJsonObject = jSONObject;
            jSONObject.put("owner", builder.params.owner);
            this.mJsonObject.put("lifecycle", builder.params.lifecycle);
            this.mJsonObject.put("defaultLayout", builder.params.defaultLayout);
            this.mJsonObject.put("width", builder.params.width);
            this.mJsonObject.put("height", builder.params.height);
            this.mJsonObject.put("framerate", builder.params.framerate);
            this.mJsonObject.put(MediaFormat.KEY_BIT_RATE, builder.params.kBitrate);
            this.mJsonObject.put("mosaicStream", builder.params.mosaicStream);
            this.mJsonObject.put("extraInfo", builder.params.extraInfo);
            this.mJsonObject.put("audiosamplerate", builder.params.audiosamplerate);
            this.mJsonObject.put("audiobitrate", builder.params.audioKBitrate * 1000);
            this.mJsonObject.put("audiochannels", builder.params.audiochannels);
        } catch (JSONException unused) {
            this.mJsonObject = null;
            LogUtil.w(TAG, "failed to create PublisherConfiguration");
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private PublisherParameters params = new PublisherParameters();

        public Builder owner(boolean isRoomOwner) {
            this.params.owner = isRoomOwner;
            return this;
        }

        public Builder liftCycle(int lifecycle) {
            this.params.lifecycle = lifecycle;
            return this;
        }

        public Builder size(int width, int height) {
            this.params.width = width;
            this.params.height = height;
            return this;
        }

        public Builder frameRate(int framerate) {
            this.params.framerate = framerate;
            return this;
        }

        public Builder kBitRate(int kBitrate) {
            this.params.kBitrate = kBitrate;
            return this;
        }

        public Builder defaultLayout(int layoutStyle) {
            this.params.defaultLayout = layoutStyle;
            return this;
        }

        public Builder extraInfo(String optionalInfo) {
            this.params.extraInfo = optionalInfo;
            return this;
        }

        public Builder audioSampleRate(int rate) {
            this.params.audiosamplerate = rate;
            return this;
        }

        public Builder audioKBitrate(int bitrate) {
            this.params.audioKBitrate = bitrate / 1000;
            return this;
        }

        public Builder audioChannels(int channel) {
            this.params.audiochannels = channel;
            return this;
        }

        public Builder publishUrl(String url) {
            this.params.mosaicStream = url;
            return this;
        }

        public PublisherConfiguration build() {
            return new PublisherConfiguration(this);
        }
    }
}
