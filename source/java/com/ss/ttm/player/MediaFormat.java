package com.ss.ttm.player;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class MediaFormat {
    public static final String KEY_AUDIO = "audio";
    public static final String KEY_BIT_RATE = "bitrate";
    public static final String KEY_CHANNEL_COUNT = "channel-count";
    public static final String KEY_CODEC_NAME = "codec-name";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_FRAME_RATE = "frame-rate";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_ROTATION = "rotation";
    public static final String KEY_SAMPLE_RATE = "sample-rate";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_TRACK_ID = "track-id";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_WIDTH = "width";
    private Map<String, Object> mMap;

    public MediaFormat() {
        this.mMap = new HashMap();
    }

    public MediaFormat(Map<String, Object> values) {
        this.mMap = values;
    }

    public Map<String, Object> getValues() {
        return this.mMap;
    }

    public final int getInteger(String name) {
        Object obj = this.mMap.get(name);
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public final long getLong(String name) {
        Object obj = this.mMap.get(name);
        if (obj != null) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    public final float getFloat(String name) {
        Object obj = this.mMap.get(name);
        if (obj != null) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public final String getString(String name) {
        return (String) this.mMap.get(name);
    }

    public final void setInteger(String name, int value) {
        this.mMap.put(name, Integer.valueOf(value));
    }

    public final void setLong(String name, long value) {
        this.mMap.put(name, Long.valueOf(value));
    }

    public final void setFloat(String name, float value) {
        this.mMap.put(name, Float.valueOf(value));
    }

    public final void setString(String name, String value) {
        this.mMap.put(name, value);
    }

    public static final MediaFormat createAudioFormat(int trackId, int sampleRate, int channelCount) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, trackId);
        mediaFormat.setInteger(KEY_SAMPLE_RATE, sampleRate);
        mediaFormat.setInteger(KEY_CHANNEL_COUNT, channelCount);
        return mediaFormat;
    }

    public static final MediaFormat createSubtitleFormat(int trackId, String language) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, trackId);
        mediaFormat.setString("language", language);
        return mediaFormat;
    }

    public static final MediaFormat createVideoFormat(int trackId, int width, int height, int bitrate) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setInteger(KEY_TRACK_ID, trackId);
        mediaFormat.setInteger("width", width);
        mediaFormat.setInteger("height", height);
        mediaFormat.setInteger(KEY_BIT_RATE, bitrate);
        return mediaFormat;
    }

    public static final MediaFormat createAudioFormat(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        return createAudioFormat(obj.optInt(KEY_TRACK_ID), obj.optInt(KEY_SAMPLE_RATE), obj.optInt(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createSubtitleFormat(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        return createSubtitleFormat(obj.optInt(KEY_TRACK_ID), obj.optString("language"));
    }

    public static final MediaFormat createVideoFormat(JSONObject obj) {
        if (obj == null) {
            return null;
        }
        return createVideoFormat(obj.optInt(KEY_TRACK_ID), obj.optInt("width"), obj.optInt("height"), obj.optInt(KEY_BIT_RATE));
    }

    public static final MediaFormat createAudioFormat(android.media.MediaFormat format) {
        if (format == null) {
            return null;
        }
        return createAudioFormat(format.getInteger(KEY_TRACK_ID), format.getInteger(KEY_SAMPLE_RATE), format.getInteger(KEY_CHANNEL_COUNT));
    }

    public static final MediaFormat createSubtitleFormat(android.media.MediaFormat format) {
        if (format == null) {
            return null;
        }
        return createSubtitleFormat(format.getInteger(KEY_TRACK_ID), format.getString("language"));
    }

    public static final MediaFormat createVideoFormat(android.media.MediaFormat format) {
        if (format == null) {
            return null;
        }
        return createVideoFormat(format.getInteger(KEY_TRACK_ID), format.getInteger("width"), format.getInteger("height"), format.getInteger(KEY_BIT_RATE));
    }

    public String toString() {
        return this.mMap.toString();
    }
}
