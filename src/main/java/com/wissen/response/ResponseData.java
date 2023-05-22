package com.wissen.response;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Response data class.
 * @author Vishal Tomar
 *
 * @param <T>
 */
@Data
public class ResponseData<T> implements Serializable {

    private  List<T> data  = new ArrayList<>();

    public void addData(T t) {
        data.add(t);
    }

    public void addData(List<T> dataList) {
        data.addAll(dataList);
    }
}
