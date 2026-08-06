package com.ss.bytertc.audio.device.hwearback.ovm;

import java.util.List;

/* loaded from: classes7.dex */
public class HardwareEarbackParams {
    public static final int AUDIO_INPUT_FLAG_FAST = 1;
    public static final int AUDIO_INPUT_FLAG_ROW = 4;
    public static final int AUDIO_OUTPUT_FLAG_DEEP_BUFFER = 8;
    public static final int AUDIO_OUTPUT_FLAG_FAST = 4;
    public List<Play> playParamsList;
    public List<Record> recordParamsList;

    /* loaded from: classes7.dex */
    public static class Play {
        public int flags;
        public int format;
        public int sampleRate;
        public int streamType;
        public int version;
    }

    /* loaded from: classes7.dex */
    public static class Record {
        public int flags;
        public int format;
        public int sampleRate;
        public int source;
        public int streamType;
        public int version;
    }
}
