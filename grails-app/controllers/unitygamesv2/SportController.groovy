package unitygamesv2

import org.springframework.security.access.annotation.Secured
import org.unity.Sport

/**
 * SportController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
@Secured(['ROLE_ADMIN'])
class SportController {

    static scaffold = Sport
//	def index = { }
}
