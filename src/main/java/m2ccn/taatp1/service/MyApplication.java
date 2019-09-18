package m2ccn.taatp1.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import app.web.rest.SwaggerResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();
        clazzes.add(OpenApiResource.class);
        clazzes.add(Service.class);
        clazzes.add(SwaggerResource.class);

        return clazzes;
    }

}