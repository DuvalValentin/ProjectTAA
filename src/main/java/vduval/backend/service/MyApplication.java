package vduval.backend.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import app.web.rest.SwaggerResource;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import vduval.backend.endpoint.DepartementEP;
import vduval.backend.endpoint.RegionEP;
import vduval.backend.endpoint.SportEP;
import vduval.backend.endpoint.VilleEP;

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
        classes.add(SportEP.class);
        classes.add(SwaggerResource.class);
        return classes;
    }
}