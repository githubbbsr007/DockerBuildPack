package ak.patel.piersquere.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ak.patel.piersquere.config.CompanyInfoConfig;
import ak.patel.piersquere.exception.InvalidUserException;

@RestController
public class DockerBuilpackController {

	@Autowired
	private CompanyInfoConfig companyInfoConfig;

	@GetMapping("/getDockerPack")
	String getDockerBuilpack() {
		return "DockerBuilpackConfigSuccess";
	}

	@GetMapping("/contactInfo")
	public String printCompanyInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Company Name: ").append(companyInfoConfig.getName()).append("\n");
		sb.append("Contact Number: ").append(companyInfoConfig.getContactNumber()).append("\n");
		sb.append("Address: ").append(companyInfoConfig.getAddress()).append("\n");
		return sb.toString();
	}

	@GetMapping("/createUser/{user}")
	String validateUser(@PathVariable String user) {
		if (user != null && user.equalsIgnoreCase("test")) {
			throw new InvalidUserException("Invalid user: " + user);
		}
		return "user register success" + user;
	}

}
