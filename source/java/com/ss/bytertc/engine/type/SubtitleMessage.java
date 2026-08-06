package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public class SubtitleMessage {
    public boolean definite;
    public String language;
    public SubtitleMode mode;
    public int sequence;
    public String text;
    public String userId;

    public SubtitleMessage(String userId, String text, String language, SubtitleMode mode, int sequence, boolean definite) {
        this.userId = userId;
        this.text = text;
        this.language = language;
        this.mode = mode;
        this.sequence = sequence;
        this.definite = definite;
    }

    public static SubtitleMessage create(String userId, String text, String language, int mode, int sequence, boolean definite) {
        return new SubtitleMessage(userId, text, language, SubtitleMode.fromId(mode), sequence, definite);
    }
}
