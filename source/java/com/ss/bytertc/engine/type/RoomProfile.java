package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RoomProfile {
    COMMUNICATION(0),
    GAME(2),
    CLOUD_GAME(3),
    LOW_LATENCY(4),
    CHAT_ROOM(6),
    INTERACTIVE_PODCAST(10),
    CHORUS(12),
    GAME_STREAMING(14),
    MEETING(16),
    MEETING_ROOM(17),
    CLASSROOM(18),
    CALL(19),
    LIVE(20);

    private final int value;

    public static RoomProfile fromId(int type) {
        for (RoomProfile roomProfile : values()) {
            if (roomProfile.value() == type) {
                return roomProfile;
            }
        }
        return COMMUNICATION;
    }

    public int value() {
        return this.value;
    }

    RoomProfile(int value) {
        this.value = value;
    }
}
