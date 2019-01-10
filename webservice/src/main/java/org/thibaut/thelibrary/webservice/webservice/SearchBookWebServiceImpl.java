package org.thibaut.thelibrary.webservice.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.thibaut.thelibrary.webservice.configuration.WebApplicationContextLocator;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;


@Service
@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService")
public class SearchBookWebServiceImpl extends AbstractWebService implements SearchBookWebService{


	@Override
	@WebMethod
	public String getBookTitle( Integer id ){
		return getServiceFactory().getBookService().getBookTitle( id );
	}

	public SearchBookWebServiceImpl() {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		WebApplicationContext currentContext = WebApplicationContextLocator.getCurrentWebApplicationContext();
		bpp.setBeanFactory(currentContext.getAutowireCapableBeanFactory());
		bpp.processInjection(this);
	}

	// alternative constructor to facilitate unit testing.
	protected SearchBookWebServiceImpl( ApplicationContext context) {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		bpp.setBeanFactory(new DefaultListableBeanFactory(context));
		bpp.processInjection(this);
	}

}

