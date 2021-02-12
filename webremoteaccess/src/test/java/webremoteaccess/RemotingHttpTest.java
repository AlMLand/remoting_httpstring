package webremoteaccess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.m_landalex.webremoteaccess.configuration.RemoteClientConfiguration;
import com.m_landalex.webremoteaccess.data.Employee;
import com.m_landalex.webremoteaccess.service.EmployeeService;

@ContextConfiguration(classes = RemoteClientConfiguration.class)
@RunWith(SpringRunner.class)
public class RemotingHttpTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void quantityOfEntities() {
		List<Employee> returnedList = employeeService.fetchAll();
		assertEquals(3, returnedList.size());
	}
	
	@Test
	public void contentCheck() {
		Employee returnedEmployee = employeeService.fetchById(1L);
		assertEquals("McGregor", returnedEmployee.getLastName());
	}
	
}
