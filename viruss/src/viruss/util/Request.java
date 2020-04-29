package viruss.util;

import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author ccarranza
 */
public class Request {

    private Client client;
    private Invocation.Builder builder;
    private WebTarget webTarget;
    private Response response;

    public Request() {
        this.client = ClientBuilder.newClient();
    }

    public Request(String target) {
        this.client = ClientBuilder.newClient();
        setTarget(target);
    }

    public Request(String target, String parametros, Map<String, Object> valores) {
        this.client = ClientBuilder.newClient();
        System.out.println(AppContext.getInstance().get("resturl") + target);
        this.webTarget = client.target(AppContext.getInstance().get("resturl") + target).path(parametros).resolveTemplates(valores);
        this.builder = webTarget.request(MediaType.APPLICATION_JSON);
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        builder.headers(headers);

    }

    /**
     * Ingresa el objetivo de la petición
     *
     * @param target Objetivo de la petición
     */
    public void setTarget(String target) {
        this.webTarget = client.target(AppContext.getInstance().get("resturl") + target);
        this.builder = webTarget.request(MediaType.APPLICATION_JSON);
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        builder.headers(headers);
    }

    public void setHeader(String nombre, Object valor) {
        builder.header(nombre, valor);
    }

    public void setHeader(MultivaluedMap<String, Object> valores) {
        valores.add("Content-Type", "application/json; charset=UTF-8");
        builder.headers(valores);
    }

    public void get() {
        response = builder.get();
    }

    public void post(Object clazz) {
        Entity<?> entity = Entity.entity(clazz, "application/json; charset=UTF-8");
        response = builder.post(entity);
    }

    public void put(Object clazz) {
        Entity<?> entity = Entity.entity(clazz, "application/json; charset=UTF-8");
        response = builder.put(entity);
    }

    public void delete() {
        response = builder.delete();
    }

    public int getStatus() {
        
        return response.getStatus();
    }

    public Boolean isError() {
        return getStatus() != HttpServletResponse.SC_OK;
    }

    public String getError() {
        if (response.getStatus() != HttpServletResponse.SC_OK) {
            String mensaje;
            if (response.getMediaType().equals(MediaType.APPLICATION_JSON_TYPE)) {
                mensaje = response.readEntity(String.class);
            } else {
                mensaje = response.getStatusInfo().getReasonPhrase();
            }
            return mensaje;
        } else {
            return null;
        }
    }

    public Object readEntity(Class clazz) {
        return response.readEntity(clazz);
    }

    public Object readEntity(GenericType<?> genericType) {
        return response.readEntity(genericType);
    }
//    if(response.getStatus()==401){
//            Mensaje mensaje = new Mensaje();
//            if(mensaje.showConfirmation("Error", null, "Volver a login a loguearse")){
//                FlowController.getInstance().goViewInWindowModalRequts("LogIng2", Boolean.FALSE);
//            }
//        }
}
