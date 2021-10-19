package com.liu.code.gateway.filter;

import com.liu.code.gateway.service.QpsCounter;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.swing.plaf.IconUIResource;
import java.util.Date;

/**
 * 自定义global filter的实现
 * 这里实现user鉴权功能
 * filter都可以对request/response进行处理(pre/post)
 * filter分为GatewayFilter and GlobalFilter,都有很多可用的内置，但一般来说自定义全局filter最实用
 */
@Component
@Log4j2
public class UserFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        QpsCounter.count++;
        ServerHttpRequest request = exchange.getRequest();
//        log.info(request.getRemoteAddress() + " comes into UserFilter: " + new Date());
        // MultiValueMap对每一个key可以对应多个值，如LinkedMultiValueMap是利用list来存储多个值的
        String username = request.getQueryParams().getFirst("username");
        if (!"lxf".equals(username)) {
//            log.info("invalid user!");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            // 不符合要求，直接返回response给client
            return exchange.getResponse().setComplete();
        }
        // 否则便将封装的exchange传给下一个filter
        return chain.filter(exchange);
    }

    // 全局的一般排在最先
    @Override
    public int getOrder() {
        return 0;
    }
}
