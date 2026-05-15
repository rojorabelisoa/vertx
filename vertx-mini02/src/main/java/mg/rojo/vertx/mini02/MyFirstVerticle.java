package mg.rojo.vertx.mini02;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyFirstVerticle extends AbstractVerticle {

  private static final int HTTP_PORT = 8668;

  @Override
  public void start(Future<Void> startFuture) {
    vertx
        .createHttpServer()
        .requestHandler(req -> req.response().end("<h1>Hello from Vert.x 3</h1>"))
        .listen(HTTP_PORT, result -> {
          if (result.succeeded()) {
            startFuture.complete();
          } else {
            startFuture.fail(result.cause());
          }
        });
  }
}