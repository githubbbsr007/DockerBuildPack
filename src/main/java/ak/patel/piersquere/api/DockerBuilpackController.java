package ak.patel.piersquere.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ak.patel.piersquere.exception.InvalidUserException;

@RestController
public class DockerBuilpackController {

	@Value("${data.info}")
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@GetMapping("/getDockerPack")
	String getDockerBuilpack() {
		return "DockerBuilpackConfigSuccess";
	}

	@GetMapping("/info")
	String readInfo() {
		return info;
	}

	@GetMapping("/createUser/{user}")
	String validateUser(@PathVariable String user) {
		if (user != null && user.equalsIgnoreCase("test")) {
			throw new InvalidUserException("Invalid user: " + user);
		}

		return "user register success" + user;
	}

}
