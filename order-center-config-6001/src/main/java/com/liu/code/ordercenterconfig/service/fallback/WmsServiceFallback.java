package com.liu.code.ordercenterconfig.service.fallback;

import com.liu.code.ordercenterconfig.service.WmsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定义降级功能，可以用于记录错误日志，后续来做异步处理
 * 熔断降级，限流降级等等，都可以在dashboard快速设置（功能强大）
 * 熔断降级：为了节省资源，不要每次都尝试调用无效远端
 *
 * sentinel限流：QPS（放进来限定数量的请求），线程数（放进来所有请求但只能有一个线程阻塞处理）
 * Sentinel限流的Warm Up方式，即预热/冷启动方式。当系统长期处于低水位的情况下，
 * 当流量突然增加时，直接把系统拉升到高水位可能瞬间把系统压垮。通过"冷启动"，让通过的流量缓慢增加，在一定时间内逐渐增加到阈值上限，
 * 给冷系统一个预热的时间，避免冷系统被压垮。warm up冷启动主要用于启动需要额外开销的场景，例如建立数据库连接,利用缓存等。
 * 限流排队方式，削峰填谷，迅速通过请求给服务器，适用于短时间内请求急剧加大的场景
 */
@Service
public class WmsServiceFallback implements WmsService {
    @Override
    @Transactional
    public String test() {
        return "test failed!";
    }

    @Override
    public String stockDec(String name, int number) {
        return "stock decrease failed! Try again!";
    }
}
