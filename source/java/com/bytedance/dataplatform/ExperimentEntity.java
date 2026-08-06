package com.bytedance.dataplatform;

import android.text.TextUtils;
import com.bytedance.dataplatform.client.ClientDataSource;
import java.io.Serializable;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class ExperimentEntity implements Serializable {
    private ClientDataSource clientDataSource;
    private Object defaultValue;
    private String description;
    private String key;
    private String[] option;
    private Type type;

    public ExperimentEntity(String key, Type type, Object defaultValue, String description, String... option) {
        this.key = key;
        this.description = description;
        this.option = option;
        this.type = type;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return this.key;
    }

    public String getDescription() {
        return this.description;
    }

    public String[] getOption() {
        return this.option;
    }

    public Type getType() {
        return this.type;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.key)) {
            return 0;
        }
        return this.key.hashCode();
    }

    public boolean equals(Object o) {
        return (o instanceof ExperimentEntity) && TextUtils.equals(this.key, ((ExperimentEntity) o).key);
    }

    public ExperimentEntity withClientDataSource(ClientDataSource clientDataSource) {
        this.clientDataSource = clientDataSource;
        return this;
    }

    public ClientDataSource getClientDataSource() {
        return this.clientDataSource;
    }
}
