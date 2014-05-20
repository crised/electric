package cl.telematic.server;

import cl.telematic.data.Json;
import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

import java.util.Map;

/**
 * Created by crised on 5/20/14.
 */
public class Server extends Verticle {

    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            public void handle(HttpServerRequest req) {
                System.out.println("Got request: " + req.uri());
                System.out.println("Headers are: ");
                for (Map.Entry<String, String> entry : req.headers()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
                req.response().headers().set("Content-Type", "text/json; charset=UTF-8");
                if(Json.jsonString!=null) req.response().end(Json.jsonString);
            }
        }).listen(8080);
    }
}
