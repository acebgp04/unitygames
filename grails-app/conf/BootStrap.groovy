class BootStrap {

    def init = { servletContext ->
        def adminRole = new org.unity.security.Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new org.unity.security.Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new org.unity.security.User(username: 'admin', enabled: true, password: 'admin')
        testUser.save(flush: true)

        org.unity.security.UserRole.create testUser, adminRole, true

        //assert SecAppUser.count() == 1
        //assert SecAppRole.count() == 2
        //assert SecAppUserSecAppRole.count() == 1
    }
    def destroy = {
    }
}
