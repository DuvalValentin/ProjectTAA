package m2ccn.taatp1.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import app.web.rest.SwaggerResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import m2ccn.taatp1.endpoint.DepartementEP;
import m2ccn.taatp1.endpoint.RegionEP;
import m2ccn.taatp1.endpoint.VilleEP;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application 
{
    @Override
    public Set<Class<?>> getClasses() 
    {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(OpenApiResource.class);
        classes.add(VilleEP.class);
        classes.add(DepartementEP.class);
        classes.add(RegionEP.class);
        classes.add(SwaggerResource.class);
        return classes;
    }
}