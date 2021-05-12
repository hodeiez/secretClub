package hodei.secretclub.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Hodei Eceiza
 * Date: 5/9/2021
 * Time: 22:55
 * Project: secretClub
 * Copyright: MIT
 */
@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {
private static final Logger logger= LoggerFactory.getLogger(HttpHandshakeInterceptor.class);


    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
    logger.info("before handshake");
    if(serverHttpRequest instanceof ServletServerHttpRequest){
      ServletServerHttpRequest servletRequest=(ServletServerHttpRequest)serverHttpRequest;
      HttpSession session=servletRequest.getServletRequest().getSession();
      map.put("sessionId",session.getId());
    }
    return true;
    }


    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        logger.info("after handShake");
    }
}
