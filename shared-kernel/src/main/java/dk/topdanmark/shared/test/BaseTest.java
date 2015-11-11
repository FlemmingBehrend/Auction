package dk.topdanmark.shared.test;

import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

@RunWith(HierarchicalContextRunner.class)
public class BaseTest {

    @Before
    public void initMockito() {
        MockitoAnnotations.initMocks(this);
    }

}
