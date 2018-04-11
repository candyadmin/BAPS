package tk.baseaccept.pass.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*********************************************************************
 * @Author: Administrator extends BaseAccpet 
 * @Date: 2018/4/10 0010 下午 4:40 
 * @Package: tk.baseaccept.pass.api
 * @ClassInfo
 **********************************************************************/
@Path("testService")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface TestService {
    @GET
    @Path("sayHello")
    public String SayHello(String name );
}
