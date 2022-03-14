package recover;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.Gson;
import com.portal.app.AppConfig;
import com.portal.app.SecurityConfig;
import com.portal.app.api.ApiController;
import com.portal.app.dao.AppDao;
import com.portal.app.dto.AfiliaBitacora;
import com.portal.app.service.AppService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, SecurityConfig.class })
@WebAppConfiguration
class Reafiliacion  {

	private static final Logger log = LoggerFactory.getLogger(Reafiliacion.class);
	@Autowired
	private AppDao dao;
	@Autowired
	private AppService service;
	private Datos datos;
	
	@Test
	void testReafiliacionDao() {
		//Assert. assertEquals(AfiliaBitacora.class, dao.reactivarSocio(datos.getReactivarRequest());
		dao.reactivarSocio(datos.getReactivarRequest());
	}
	
	/*@Test
	void testReafiliacionService() {
		service.reactivarSocio(datos.getReactivarRequest());
	}*/

}
