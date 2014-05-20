package cl.telematic.server;

import cl.telematic.data.Json;
import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.VertxFactory;
import org.vertx.java.core.http.HttpServerRequest;


import java.util.Map;

/**
 * Created by crised on 5/20/14.
 */
public class Server  {

    Vertx vertx;

    public Server() {
        this.vertx = VertxFactory.newVertx();
    }

    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            public void handle(HttpServerRequest req) {
                System.out.println("Got request: " + req.uri());
                System.out.println("Headers are: ");
                for (Map.Entry<String, String> entry : req.headers()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
                req.response().headers().set("Content-Type", "text/json; charset=UTF-8");
                if (Json.jsonString == null) {
                    req.response().end("nada");
                } else {
                    req.response().end(Json.jsonString);

                }
            }
        }).listen(8080);
    }
}
