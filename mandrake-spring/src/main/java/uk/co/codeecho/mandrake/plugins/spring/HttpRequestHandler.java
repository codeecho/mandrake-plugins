package uk.co.codeecho.mandrake.plugins.spring;

import uk.co.codeecho.mandrake.core.router.Router;

public class HttpRequestHandler extends uk.co.codeecho.mandrake.core.HttpRequestHandler implements org.springframework.web.HttpRequestHandler {

    public HttpRequestHandler(Router router) {
        super(router);
    }

}
