package com.hzitxx.hitao.service;

import com.hzitxx.hitao.commons.ServerResponse;

public interface RefreshRouteService {
    /**
     * 刷新路由
     * @return
     */
    ServerResponse<String> refreshRoute();
}
