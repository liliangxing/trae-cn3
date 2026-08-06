package com.lynx.animax.p034ui;

import android.content.Context;
import com.lynx.animax.ability.BaseAbility;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimaXContext {
    private final BaseAbility mAbility;
    private final Context mContext;
    private final boolean mMultiThreadAccelerate;

    private AnimaXContext(Builder builder) {
        this.mAbility = builder.mAbility;
        this.mContext = builder.mContext;
        this.mMultiThreadAccelerate = builder.mMultiThreadAccelerate;
    }

    public BaseAbility getAbility() {
        return this.mAbility;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Boolean multiThreadAccelerate() {
        return Boolean.valueOf(this.mMultiThreadAccelerate);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Builder {
        private final BaseAbility mAbility;
        private final Context mContext;
        private boolean mMultiThreadAccelerate = false;

        public Builder(BaseAbility baseAbility, Context context) {
            this.mAbility = baseAbility;
            this.mContext = context;
        }

        public Builder multiThreadAccelerate(boolean z) {
            this.mMultiThreadAccelerate = z;
            return this;
        }

        public AnimaXContext build() {
            return new AnimaXContext(this);
        }
    }
}
