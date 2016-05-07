package com.appiskey.simplifyvolleynetworkresponse;

/**
 * Created by Dell 5521 on 5/7/2016.
 */
public interface ServiceListener<T> {
    void success(T obj);
    void fail(T obj);
}
