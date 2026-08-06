package com.ss.bytertc.engine.data;

import com.ss.bytertc.engine.IMediaPlayerCustomSourceProvider;

/* loaded from: classes7.dex */
public class MediaPlayerCustomSource {
    public MediaPlayerCustomSourceMode mode;
    public IMediaPlayerCustomSourceProvider provider;
    public MediaPlayerCustomSourceStreamType type;

    public MediaPlayerCustomSource() {
        this.provider = null;
        this.mode = MediaPlayerCustomSourceMode.PUSH;
        this.type = MediaPlayerCustomSourceStreamType.RAW;
    }

    public MediaPlayerCustomSource(IMediaPlayerCustomSourceProvider provider, MediaPlayerCustomSourceMode mode, MediaPlayerCustomSourceStreamType type) {
        this.provider = null;
        this.mode = MediaPlayerCustomSourceMode.PUSH;
        MediaPlayerCustomSourceStreamType mediaPlayerCustomSourceStreamType = MediaPlayerCustomSourceStreamType.RAW;
        this.mode = mode;
        this.type = type;
        this.provider = provider;
    }

    public String toString() {
        return "MediaPlayerCustomSource{provider='" + this.provider + "', MediaPlayerCustomSourceMode='" + this.mode + "', MediaPlayerCustomSourceStreamType='" + this.type + "'}";
    }
}
