package com.example.saputra.application2.util;

/**
 * Created by Verdiyanto Saputra on 21/05/2017.
 */

public interface BasePresenter<V> {

    void bind(V view);
    void unbind();
}
