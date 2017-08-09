package service;

import com.calderon.sf.data.model.TranCategoryEntity;
import com.calderon.sf.data.service.TranCategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TranCategoryServiceTest extends AbstractBasicTest{

    @Autowired
    private TranCategoryService service;

    @Test
    public void findByParentId() throws Exception {
        List<TranCategoryEntity> categories = service.findByParentId(1);
        System.out.println(categories);
        assertThat(categories).isNotNull();
    }

    @Test
    public void findChildren() throws Exception {
        List<TranCategoryEntity> categories = service.findChildren();
        System.out.println(categories);
        assertThat(categories).isNotNull();
    }

    @Test
    public void findCategoryById() throws Exception {
        TranCategoryEntity category = service.findCategoryById(14);
        System.out.println(category);
        assertThat(category).isNotNull();
        TranCategoryEntity categoryNull = service.findCategoryById(142332);
        System.out.println(categoryNull);
        assertThat(categoryNull).isNull();
    }

}