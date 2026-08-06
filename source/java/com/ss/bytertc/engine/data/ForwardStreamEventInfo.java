package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class ForwardStreamEventInfo {
    public ForwardStreamEvent event;
    public String roomId;

    /* loaded from: classes7.dex */
    public enum ForwardStreamEvent {
        FORWARD_STREAM_EVENT_DISCONNECTED(0),
        FORWARD_STREAM_EVENT_CONNECTED(1),
        FORWARD_STREAM_EVENT_INTERRUPT(2),
        FORWARD_STREAM_EVENT_DST_ROOM_UPDATED(3),
        FORWARD_STREAM_EVENT_UN_EXPECT_API_CALL(4);

        private int value;

        ForwardStreamEvent(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamEvent fromId(int id) {
            for (ForwardStreamEvent forwardStreamEvent : values()) {
                if (forwardStreamEvent.value() == id) {
                    return forwardStreamEvent;
                }
            }
            return null;
        }
    }

    public ForwardStreamEventInfo(String roomId, ForwardStreamEvent event) {
        this.roomId = roomId;
        this.event = event;
    }

    private static ForwardStreamEventInfo create(String roomId, int eventId) {
        return new ForwardStreamEventInfo(roomId, ForwardStreamEvent.fromId(eventId));
    }
}
