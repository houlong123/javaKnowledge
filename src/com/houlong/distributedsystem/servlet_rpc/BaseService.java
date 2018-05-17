package com.houlong.distributedsystem.servlet_rpc;

import java.util.Map;

/**
 * Created by houlong on 2018/1/4.
 */
public interface BaseService {
    public Object execute(Map<String, Object> args);
}
