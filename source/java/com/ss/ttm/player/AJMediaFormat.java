package com.ss.ttm.player;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class AJMediaFormat {
    public int channelCount;
    public int colorFormat;
    public int colorRange;
    public int colorSpace;
    public int colorTrans;
    public int height;
    public int sampleRate;
    public int sliceHeight;
    public int stride;
    public int width;
    private android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
    private Map<String, Object> map = new HashMap();

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.sampleRate = 0;
        this.channelCount = 0;
        this.colorFormat = 0;
        this.colorTrans = 0;
        this.sliceHeight = 0;
        this.stride = 0;
        this.colorSpace = 0;
        this.colorRange = 0;
    }

    public void setInteger(String name, int value) {
        this.mediaFormat.setInteger(name, value);
        this.map.put(name, Integer.valueOf(value));
    }

    public void setFeatureEnabled(String str, boolean z) {
        setInteger("feature-" + str, z ? 1 : 0);
    }

    public void setString(String name, String value) {
        this.mediaFormat.setString(name, value);
        this.map.put(name, value);
    }

    public void setByteBuffer(String name, ByteBuffer bytes) {
        this.mediaFormat.setByteBuffer(name, bytes);
        this.map.put(name, bytes);
    }

    public String getString(String name) {
        return this.mediaFormat.getString(name);
    }

    public android.media.MediaFormat getMediaFormat() {
        return this.mediaFormat;
    }

    public Map<String, Object> getMap() {
        return this.map;
    }

    public void getOptions(String[] keys, Object[] values) {
        int i = 0;
        for (Map.Entry<String, Object> entry : this.map.entrySet()) {
            keys[i] = entry.getKey();
            values[i] = entry.getValue();
            i++;
        }
    }
}
