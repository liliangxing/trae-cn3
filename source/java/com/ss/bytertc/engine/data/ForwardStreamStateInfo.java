package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class ForwardStreamStateInfo {
    public ForwardStreamError error;
    public String roomId;
    public ForwardStreamState state;

    /* loaded from: classes7.dex */
    public enum ForwardStreamState {
        FORWARD_STREAM_STATE_IDLE(0),
        FORWARD_STREAM_STATE_SUCCESS(1),
        FORWARD_STREAM_STATE_FAILURE(2);

        private int value;

        ForwardStreamState(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamState fromId(int id) {
            for (ForwardStreamState forwardStreamState : values()) {
                if (forwardStreamState.value() == id) {
                    return forwardStreamState;
                }
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public enum ForwardStreamError {
        FORWARD_STREAM_ERROR_OK(0),
        FORWARD_STREAM_ERROR_INVALID_ARGUMENT(1201),
        FORWARD_STREAM_ERROR_INVALID_TOKEN(1202),
        FORWARD_STREAM_ERROR_RESPONSE(1203),
        FORWARD_STREAM_ERROR_REMOTE_KICKED(1204),
        FORWARD_STREAM_ERROR_NOT_SUPPORT(1205);

        private int value;

        ForwardStreamError(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static ForwardStreamError fromId(int id) {
            for (ForwardStreamError forwardStreamError : values()) {
                if (forwardStreamError.value() == id) {
                    return forwardStreamError;
                }
            }
            return null;
        }
    }

    public ForwardStreamStateInfo(String roomId, ForwardStreamState state, ForwardStreamError error) {
        this.roomId = roomId;
        this.state = state;
        this.error = error;
    }

    private static ForwardStreamStateInfo create(String roomId, int stateId, int errorId) {
        return new ForwardStreamStateInfo(roomId, ForwardStreamState.fromId(stateId), ForwardStreamError.fromId(errorId));
    }
}
