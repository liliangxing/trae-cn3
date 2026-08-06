package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;

/* loaded from: classes5.dex */
public class MicroAppObject implements IMediaObject {
    private static final String APP_ID = "micro_app_object_app_id";
    private static final String IMAGE_ID = "micro_app_object_image_id";
    private static final String PATH = "micro_app_object_only_path";
    private static final String QUERY = "micro_app_object_query";
    private static final String THIRD_APP_SCHEMA = "micro_app_object_third_app_schema";
    private static final String TITLE = "micro_app_object_title";
    public String appId;
    public String imageId;
    public String path;
    public String query;
    public String thirdAppSchema;
    public String title;

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public boolean checkArgs() {
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString(APP_ID, this.appId);
        bundle.putString(TITLE, this.title);
        bundle.putString(PATH, this.path);
        bundle.putString(QUERY, this.query);
        bundle.putString(IMAGE_ID, this.imageId);
        bundle.putString(THIRD_APP_SCHEMA, this.thirdAppSchema);
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public int type() {
        return 9;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IMediaObject
    public void unserialize(Bundle bundle) {
        this.appId = bundle.getString(APP_ID);
        this.title = bundle.getString(TITLE);
        this.path = bundle.getString(PATH);
        this.query = bundle.getString(QUERY);
        this.imageId = bundle.getString(IMAGE_ID);
        this.thirdAppSchema = bundle.getString(THIRD_APP_SCHEMA);
    }
}
