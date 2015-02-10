import com.microposter.core.post.dao.PostDao;
import com.microposter.core.post.domain.Post;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

public class Main {

@Value("#{postDao}")
private PostDao postDao;

  public static void main(String [ ] args) {
    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory); rdr.loadBeanDefinitions(new
        FileSystemResource("src/main/resources/microposter-core-context.xml"));
// Oracle oracle = (Oracle)factory.getBean("oracle"); Oracle oracle = factory.getBean("oracle", Oracle.class); System.out.println(oracle.defineMeaningOfLife());
    System.out.print("");
  }

}
