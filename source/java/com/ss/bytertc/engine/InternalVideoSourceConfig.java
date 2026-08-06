package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalVideoSourceConfig {
    private int source_category;
    private int source_type;

    /* loaded from: classes7.dex */
    public enum VideoSourceType {
        VIDEO_SOURCE_TYPE_EXTERNAL(0),
        VIDEO_SOURCE_TYPE_INTERNAL(1),
        VIDEO_SOURCE_TYPE_ENCODER_WITH_AUTO_SIMULCAST(2),
        VIDEO_SOURCE_TYPE_ENCODER_WITHOUT_AUTO_SIMULCAST(3);

        private int value;

        VideoSourceType(int v) {
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes7.dex */
    public enum VideoContentCategory {
        VIDEO_CONTENT_CATEGORY_CAMERA(0),
        VIDEO_CONTENT_CATEGRORY_SCREEN(1);

        private int value;

        VideoContentCategory(int v) {
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }

    public InternalVideoSourceConfig(VideoSourceType sourceType, VideoContentCategory contentCategory) {
        this.source_type = sourceType.getValue();
        this.source_category = contentCategory.getValue();
    }

    public int getVideoSourceType() {
        return this.source_type;
    }

    public int getVideoSourceCategory() {
        return this.source_category;
    }
}
