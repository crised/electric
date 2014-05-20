package cl.telematic.server;

import cl.telematic.data.Json;
import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.VertxFactory;
import org.vertx.java.core.http.HttpServerRequest;

public class Server  {

    Vertx vertx;

    public Server() {
        this.vertx = VertxFactory.newVertx();
    }

    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {

            public void handle(HttpServerRequest req) {

                req.response().headers().set("Content-Type", "application/json");
                if (Json.jsonString == null) {
                    req.response().end("nada");
                } else {
                    req.response().end(Json.jsonString);

                }
            }
        }).listen(8080);
    }
}
