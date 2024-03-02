import org.junit.Test;
import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

public class FreeMarkerTest {

    @Test
    public void test() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28) ;

        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        configuration.setDefaultEncoding("UTF-8");
    }
}
