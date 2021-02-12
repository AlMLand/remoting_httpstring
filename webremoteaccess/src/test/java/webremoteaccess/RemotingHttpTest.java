package webremoteaccess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.m_landalex.webremoteaccess.configuration.RemoteClientConfiguration;
import com.m_landalex.webremoteaccess.data.Employee;
import com.m_landalex.webremoteaccess.service.EmployeeService;

@ContextConfiguration(classes = RemoteClientConfiguration.class)
@RunWith(SpringRunner.class)
public class RemotingHttpTest {

	private static final Logger logger = LoggerFactory.getLogger(RemotingHttpTest.class);
	
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
		show(returnedEmployee);
		assertEquals("McGregor", returnedEmployee.getLastName());
	}
	
	private void show(Employee employee) {
		logger.info("Employee: {}", employee.toString());
	}
	
}
