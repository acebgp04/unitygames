package unitygamesv2

import org.springframework.security.access.annotation.Secured
import org.unity.Team

/**
 * TeamController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
@Secured(['ROLE_ADMIN'])
class TeamController {

    static scaffold = Team
//	def index = { }
}
