package testcase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lixiaoyu
 * @since 2019-11-24 23:20
 */
public class TestBeanPostProcessor {

	@Test
	public void test1(){
		BeanDefinitionRegistryPostProcessor beanDefinitionRegistryPostProcessor = new MyBeanDefinitionRegistryPostProcessor();
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanDefinitionRegistryPostProcessor);
		annotationConfigApplicationContext.getDefaultListableBeanFactory().registerBeanDefinition("def", BeanDefinitionBuilder.genericBeanDefinition(beanDefinitionRegistryPostProcessor.getClass()).getBeanDefinition());
		annotationConfigApplicationContext.refresh();
	}
}
